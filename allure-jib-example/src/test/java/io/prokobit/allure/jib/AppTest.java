package io.prokobit.allure.jib;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Calculator Application")
@Feature("Basic Arithmetic Operations")
class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    @Story("Addition Operation")
    @Description("Test basic addition functionality")
    @Severity(SeverityLevel.CRITICAL)
    void testAddition() {
        Allure.step("Performing addition of 2 + 2");
        int result = app.add(2, 2);
        
        Allure.step("Verifying the result equals 4");
        assertEquals(4, result, "Addition of 2 + 2 should equal 4");
    }

    @Test
    @Story("Subtraction Operation")
    @Description("Test basic subtraction functionality")
    @Severity(SeverityLevel.CRITICAL)
    void testSubtraction() {
        Allure.step("Performing subtraction of 5 - 3");
        int result = app.subtract(5, 3);
        
        Allure.step("Verifying the result equals 2");
        assertEquals(2, result, "Subtraction of 5 - 3 should equal 2");
    }

    @Test
    @Story("Multiplication Operation")
    @Description("Test basic multiplication functionality")
    @Severity(SeverityLevel.CRITICAL)
    void testMultiplication() {
        Allure.step("Performing multiplication of 4 * 6");
        int result = app.multiply(4, 6);
        
        Allure.step("Verifying the result equals 24");
        assertEquals(24, result, "Multiplication of 4 * 6 should equal 24");
    }

    @Test
    @Story("Division Operation")
    @Description("Test basic division functionality")
    @Severity(SeverityLevel.CRITICAL)
    void testDivision() {
        Allure.step("Performing division of 10 / 2");
        double result = app.divide(10, 2);
        
        Allure.step("Verifying the result equals 5.0");
        assertEquals(5.0, result, "Division of 10 / 2 should equal 5.0");
    }

    @Test
    @Story("Division by Zero")
    @Description("Test division by zero exception handling")
    @Severity(SeverityLevel.BLOCKER)
    void testDivisionByZero() {
        Allure.step("Attempting division by zero");
        ArithmeticException exception = assertThrows(ArithmeticException.class, 
            () -> app.divide(10, 0), 
            "Division by zero should throw ArithmeticException");
        
        Allure.step("Verifying exception message");
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "0, 5, 5", 
        "-1, 1, 0",
        "100, 200, 300"
    })
    @Story("Parameterized Addition")
    @Description("Test addition with various input combinations")
    @Severity(SeverityLevel.NORMAL)
    void testParameterizedAddition(int a, int b, int expected) {
        Allure.step("Performing addition of " + a + " + " + b);
        int result = app.add(a, b);
        
        Allure.step("Verifying the result equals " + expected);
        assertEquals(expected, result, 
            String.format("Addition of %d + %d should equal %d", a, b, expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Story("Even Number Detection")
    @Description("Test even number detection for positive even numbers")
    @Severity(SeverityLevel.MINOR)
    void testEvenNumbers(int number) {
        Allure.step("Checking if " + number + " is even");
        boolean result = app.isEven(number);
        
        Allure.step("Verifying the result is true");
        assertTrue(result, number + " should be identified as even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @Story("Odd Number Detection")
    @Description("Test even number detection for positive odd numbers")
    @Severity(SeverityLevel.MINOR)
    void testOddNumbers(int number) {
        Allure.step("Checking if " + number + " is even");
        boolean result = app.isEven(number);
        
        Allure.step("Verifying the result is false");
        assertFalse(result, number + " should be identified as odd");
    }

    @Test
    @Story("Factorial Calculation")
    @Description("Test factorial calculation for positive numbers")
    @Severity(SeverityLevel.NORMAL)
    void testFactorial() {
        Allure.step("Calculating factorial of 5");
        long result = app.factorial(5);
        
        Allure.step("Verifying the result equals 120");
        assertEquals(120, result, "Factorial of 5 should equal 120");
    }

    @Test
    @Story("Factorial Edge Cases")
    @Description("Test factorial calculation for edge cases (0 and 1)")
    @Severity(SeverityLevel.NORMAL)
    void testFactorialEdgeCases() {
        Allure.step("Calculating factorial of 0");
        long result0 = app.factorial(0);
        assertEquals(1, result0, "Factorial of 0 should equal 1");
        
        Allure.step("Calculating factorial of 1");
        long result1 = app.factorial(1);
        assertEquals(1, result1, "Factorial of 1 should equal 1");
    }

    @Test
    @Story("Negative Factorial")
    @Description("Test factorial calculation for negative numbers")
    @Severity(SeverityLevel.BLOCKER)
    void testNegativeFactorial() {
        Allure.step("Attempting to calculate factorial of -1");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> app.factorial(-1),
            "Factorial of negative number should throw IllegalArgumentException");
        
        Allure.step("Verifying exception message");
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }

    @Test
    @Story("Large Number Operations")
    @Description("Test operations with large numbers")
    @Severity(SeverityLevel.NORMAL)
    void testLargeNumbers() {
        Allure.step("Performing addition with large numbers");
        int largeResult = app.add(1000000, 2000000);
        assertEquals(3000000, largeResult, "Large number addition should work correctly");
        
        Allure.step("Performing multiplication with large numbers");
        int multiplyResult = app.multiply(1000, 2000);
        assertEquals(2000000, multiplyResult, "Large number multiplication should work correctly");
    }

    @Test
    @Story("Floating Point Division")
    @Description("Test division that results in floating point numbers")
    @Severity(SeverityLevel.NORMAL)
    void testFloatingPointDivision() {
        Allure.step("Performing division that results in decimal");
        double result = app.divide(7, 2);
        
        Allure.step("Verifying the result equals 3.5");
        assertEquals(3.5, result, "Division of 7 / 2 should equal 3.5");
    }

    @Test
    @Story("This Test Will Fail")
    @Description("This test is intentionally failing to demonstrate Allure error reporting")
    @Severity(SeverityLevel.CRITICAL)
    void thisTestWillFail() {
        Allure.step("Performing incorrect calculation");
        int result = app.add(2, 2);
        
        Allure.step("Intentionally asserting wrong result");
        assertEquals(10, result, "This calculation should fail: 2 + 2 ≠ 10");
    }

    @Test
    @Story("Another Failing Test")
    @Description("Another failing test to show comprehensive error reporting")
    @Severity(SeverityLevel.NORMAL)
    void anotherFailingTest() {
        Allure.step("Performing string comparison");
        String actual = "hello";
        String expected = "world";
        
        Allure.step("Intentionally asserting wrong string");
        assertEquals(expected, actual, "This string comparison should fail");
    }

    @Test
    @Story("Test with Attachments")
    @Description("Test demonstrating Allure attachments")
    @Severity(SeverityLevel.MINOR)
    void testWithAttachments() {
        Allure.step("Creating test data");
        String testData = "Sample test data for attachment demonstration";
        
        Allure.step("Attaching test data to report");
        Allure.attachment("test-data.txt", testData);
        
        Allure.step("Performing test operation");
        int result = app.add(3, 4);
        
        Allure.step("Attaching result to report");
        Allure.attachment("result.json", 
            String.format("{\"operation\": \"addition\", \"result\": %d}", result));
        
        assertEquals(7, result, "Addition of 3 + 4 should equal 7");
    }
} 