package Rational;

/**
 * RationalTest
 */

/**
 * CS5004 Assignment 4: Problem 2 - Rational Class.
 * This class test a programmer defined rational number object.
 * 
 * @author Randy Lirano
 * @since 2020-06-07
 */

public class RationalTest {
    /**
      * This function performs the required operation to test the rational number object.
      * @param args (unused)
      */
    public static void main(String[] args) {
        // Test constructor
        System.out.println("Test Constructor");
        Rational number1 = new Rational();
        System.out.println(number1);
        System.out.println("Numerator: " + number1.getNumerator());
        System.out.println("Denominator: " + number1.getDenominator());
        Rational number2 = new Rational(3);
        System.out.println(number2);
        System.out.println("Numerator: " + number2.getNumerator());
        System.out.println("Denominator: " + number2.getDenominator());
        Rational number3 = new Rational(1, 1);
        System.out.println(number3);
        System.out.println("Numerator: " + number3.getNumerator());
        System.out.println("Denominator: " + number3.getDenominator());
        System.out.println();

        // Test add
        System.out.println("Test Addition");
        Rational number4 = new Rational(1, 2);
        Rational number5 = new Rational(1, 2);
        Rational number6 = number4.add(number5);
        System.out.println("Numerator: " + number6.getNumerator());
        System.out.println("Denominator: " + number6.getDenominator());
        System.out.println(number6);
        System.out.println();

        // Test subtraction
        Rational number7 = new Rational(1, 3);
        Rational number8 = new Rational(1, 2);
        Rational number9 = number7.sub(number8);
        System.out.println(number9);
        System.out.println();

        // Test multiplication
        Rational number10 = new Rational(2, 4);
        System.out.println(number10);
        Rational number11 = new Rational(1, 2);
        System.out.println(number11);
        Rational number12 = number10.mul(number11);
        System.out.println(number12);
        System.out.println();

        // Test Division
        System.out.println("Test Division");
        Rational number13 = new Rational(1, 6);
        Rational number14 = new Rational(2);
        Rational number15 = number13.div(number14);
        System.out.println(number15);
        System.out.println();


        // Test Equals
        System.out.println("Test Equality");
        Rational number16 = new Rational(2, 4);
        Rational number17 = new Rational(1, 2);
        boolean equalityCheck = number16.equals(number17);
        System.out.println("The two numbers are equal: " + equalityCheck);
    }
    
}

/**
 * This class is a programmer-defined Rational object
 */
class Rational {
    // Class instances
    private int numerator;
    private int denominator;

    // 0 argument constructor
    public Rational() {
        this.numerator = 0;
        // this.denominator = 0;
    }
    // 1 argument constructor
    public Rational(int whole) {
        this(whole, 1);
    }
    // 2 arguments constructor
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("ERROR: Division-By-Zero");
            System.exit(1);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("ERROR: Division-By-Zero");
            System.exit(1);
        } else {
            this.denominator = denominator;
        }
    }

    public Rational add(Rational other) {
        if (this.denominator == other.denominator) {
            int calculatedNum = this.numerator + other.numerator;
            int calculatedDen = this.denominator;
            Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
            return calculatedValue;
        } else {
            int calculatedNum = (this.numerator * other.denominator) + (other.numerator * this.denominator);
            int calculatedDen = this.denominator * other.denominator;
            Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
            return calculatedValue;
        }
    }

    public Rational sub(Rational other) {
        if (this.denominator == other.denominator) {
            int calculatedNum = this.numerator - other.numerator;
            int calculatedDen = this.denominator;
            Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
            return calculatedValue;
        } else {
            int calculatedNum = (this.numerator * other.denominator) - (other.numerator * this.denominator);
            int calculatedDen = this.denominator * other.denominator;
            Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
            return calculatedValue;
        }
    }

    public Rational mul(Rational other) {
        if (this.numerator == 0 || other.numerator == 0) {
            Rational calculatedValue = new Rational();
            return calculatedValue;
        }
        int calculatedNum = this.numerator * other.numerator;
        int calculatedDen = this.denominator * other.denominator;
        Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
        return calculatedValue;
    }

    public Rational div(Rational other) {
        int calculatedNum = this.numerator * other.denominator;
        int calculatedDen = this.denominator * other.numerator;
        Rational calculatedValue = new Rational(calculatedNum, calculatedDen);
        return calculatedValue;
    }

    private void normalize() {
        if (this.numerator == 0) {
            this.denominator = 0;
        } else {
            int gcdValue = gcd(this.numerator, this.denominator);
            this.numerator = this.numerator / gcdValue;
            this.denominator = this.denominator / gcdValue;
        }

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Helper method for the normalization function
    private static int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public String toString() {
        if (this.numerator != 0 && this.denominator == 1) {
            return "The rational number: " + this.getNumerator();
        } else if (this.numerator == 0) {
            return "The rational number: 0";
        }
        this.normalize();
        return "The rational number: " + getNumerator() + "/" + getDenominator();
    }

    public boolean equals(Rational other) {
        this.normalize();
        other.normalize();
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
}