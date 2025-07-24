package io.prokobit.allure.jib;

/**
 * Simple calculator application for demonstrating Allure reporting
 */
public class App {
    
    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts second number from first
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides first number by second
     * @param a dividend
     * @param b divisor
     * @return quotient of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
    
    /**
     * Checks if a number is even
     * @param number to check
     * @return true if number is even, false otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * Calculates factorial of a number
     * @param n number to calculate factorial for
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        App app = new App();
        System.out.println("Calculator App");
        System.out.println("2 + 3 = " + app.add(2, 3));
        System.out.println("5 - 2 = " + app.subtract(5, 2));
        System.out.println("4 * 6 = " + app.multiply(4, 6));
        System.out.println("10 / 2 = " + app.divide(10, 2));
    }
} 