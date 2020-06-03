package Harmonic;

/*
 * Harmonic.java 
 */

import java.util.Scanner;

/**
 * CS5004 Assignment 3: Problem 2 - Harmonic Sequence.
 * This class calculates the n-th number of Harmonic sequence.
 * 
 * @author Randy Lirano
 * @since 2020-05-31
 */

public class Harmonic {
    /**
     * This function calculate the n-th nnumber in the harmonic sequence.
     * 
     * @param userInput
     * @return
     */
    public static double harmonicSequence(int userInput) {
        double hOfN = 0.0;
        for(int i = 1; i <= userInput; i++) {
            hOfN += ((double) 1 / i);
        }
        return hOfN;
    }
    /**
     * This function test the performance of the encryption and decryption function
     * 
     * @param args(unused)
     */
    public static void main(String[] args) {
        // Initialize Scanner class named console to receive keyboard input
        Scanner console = new Scanner(System.in);
        System.out.printf("-- Enter n: ");
        int userInput = console.nextInt();

        if(userInput <= 0) {
            System.out.printf("Invalid input!");
        } else {
            double hOfN = harmonicSequence(userInput);
            System.out.printf("%f", hOfN);
        }

        console.close();
    }
}