/*
 * PaceCalculator.java
 */

/**
 * CS5004 Assignment 1: Problem 2 - Pace Calculator
 * This class serves as a simple pace calculator
 * 
 * @author Randy Lirano
 * @since 2020-05-14
 */

public class PaceCalculator {
     /**
     * This function serves as a simple pace calculator and performs the required operations
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        // Introduction of the program
        System.out.println("This program calculates pace");
        // Initialize time to be 35 minutes and 30 seconds
        double time = 35.5;
        // Initialize distance to be 6.21 miles
        double distance = 6.21;
        // Calculate pace based on the given time and distance
        double pace = time / distance;
        // Print out the result
        System.out.println("Pace is " + pace + " miles per hour.");
    }
}