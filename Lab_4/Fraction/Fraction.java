package Fraction;

/**
 * Tic.java
 */

import java.util.Scanner;

/**
 * CS5005 Lab 4: Problem 2 - Fraction.
 * This class serves as a fraction class in mathematic.
 *
 * @author Randy Lirano
 * @since 2020-06-04
 */

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator <= 0) {
            throw new IllegalArgumentException("Denominator not positive");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int newNumerator) {
        this.numerator = newNumerator;
    }

    public boolean setDenominator(int newDenominator) {
        if(newDenominator <= 0) {
            return false;
        }
        this.denominator = newDenominator;
        return true;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Fraction test1 = new Fraction();
        System.out.println("Test 1 numerator = " + test1.getNumerator());
        System.out.println("Test 1 denominator = " + test1.getDenominator());
        System.out.println();
        Fraction test2 = new Fraction(2, 4);
        System.out.println("Test 2 numerator = " + test2.getNumerator());
        System.out.println("Test 2 denominator = " + test2.getDenominator());
        System.out.println();
        System.out.print("Provide new numerator: ");
        int newNumerator = console.nextInt();
        test2.setNumerator(newNumerator);
        System.out.print("Provide new denominator: ");
        int newDenominator = console.nextInt();
        test2.setDenominator(newDenominator);
        System.out.println("Test 2 numerator = " + test2.getNumerator());
        System.out.println("Test 2 denominator = " + test2.getDenominator());
        console.close();
    }
}