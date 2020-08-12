/**
 * Calculator.java
 */

/**
 * CS5004 Assignment 9: Calculator Class
 * This class implements simple interactive calculator.
 * 
 * @author Randy Lirano
 * @since 2020-07-26
 */

import java.util.*;

public class Calculator {
    /**
     * Check if the operator provided from the console is a valid operator (+, -, *, /)
     * @param ch
     * @return true if the operator is valid, and false otherwise
     */
    public static boolean validOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * Takes the current result in a calculator and update it based on the given number and operator from console
     * @param result
     * @param number
     * @param operator
     * @return newResult
     */
    public static double performCalculation(double result, double number, char operator) {
        double newResult = result;
        if (operator == '+') {
            newResult += number;
        } else if (operator == '-') {
            newResult -= number;
        } else if (operator == '*') {
            newResult *= number;
        } else if (operator == '/') {
            newResult /= number;
        }
        return newResult;
    }

    /**
     * Continuously ask user to provide input of operator and number
     * If the provided input is 'r' or 'R', then the final value of calculated value will be returned
     * @param console
     * @param startValue
     * @return 
     */
    public static double calculatorOn(Scanner console, double startValue) {
        boolean resultRequested = false;
        double calculatedResult = startValue;

        while(!resultRequested) {
            String userInput = console.nextLine().trim();
            char operator = userInput.charAt(0);

            if (operator == 'r' || operator == 'R') {
                resultRequested = true;
            } else {
                try {
                    if (!validOperator(operator)) {
                        throw new UnknownOperatorException();
                    } else {
                        Scanner input = new Scanner(userInput.substring(1).trim());
                        double number = input.nextDouble();
                        calculatedResult = performCalculation(calculatedResult, number, operator);
                        System.out.println("result " + operator + " " + number + " = " + calculatedResult);
                        System.out.println("Updated result = " + calculatedResult);
                    }
                } catch (UnknownOperatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return calculatedResult;
    }

    public static void main(String[] args) throws UnknownOperatorException {
        // Initialize console to take user input
        Scanner console = new Scanner(System.in);
        
        boolean done = false;

        System.out.println("Calculator on");

        while (!done) {
            // Result to be calculated
            double result = 0.0;
            System.out.println("result = " + result);
            result = calculatorOn(console, result);
            System.out.println("Final result: " + result);
            System.out.println("Again? (y/n)");
            String userInput = console.next();
            String junkCollection = console.nextLine();
            if (userInput.equalsIgnoreCase("n")) {
                done = true;
            }
        }
        System.out.println("End program");

    }
}

class UnknownOperatorException extends Exception {
    UnknownOperatorException(String m) {
        super(m);
    }

    UnknownOperatorException() {
        super("unknown operator. please reenter last line");
    }
}