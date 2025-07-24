package io.prokobit.junit.jib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void simpleTest() {
        assertEquals(4, 2 + 2);
    }
    
    @Test
    void testAppAddMethod() {
        App app = new App();
        assertEquals(4, app.add(2, 2));
    }
    
    @Test
    void thisTestWillFail() {
        // This test is intentionally failing to demonstrate error reporting
        assertEquals(10, 5 + 4, "This calculation should fail: 5 + 4 ≠ 10");
    }
    
    @Test
    void anotherFailingTest() {
        // Another failing test to show all tests run despite failures
        assertEquals("hello", "world", "This string comparison should fail");
    }
} 