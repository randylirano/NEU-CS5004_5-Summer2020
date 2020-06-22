/**
 * FractionTest.java
 */

/**
 * CS5004 Lab 5: Problem 4 - Fraction Class.
 * This class test a programmer defined Fraction number object.
 * 
 * @author Randy Lirano
 * @since 2020-06-04
 */
public class FractionTest {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(2, 4);
        System.out.println("Numerator: " + a.getNumerator());
        System.out.println("Denominator: " + a.getDenominator());
        System.out.println("Double: " + a.toDouble());
        System.out.println("A is equal to B: " + a.isEqualTo(b));
    }
    
}

/**
 * Programmer defined Fraction class
 */
class Fraction {
    // Class instances
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        setDenominator(denominator);
        setNumerator(numerator);
    }

    // Getter methods
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    // Setter methods
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (checkDenominator(denominator)) {
            this.denominator = denominator;
        } else {
            System.exit(-1);
        }
    }

    // Check if denominator is a positive number
    private boolean checkDenominator(int denominator) {
        if (denominator <= 0) {
            System.out.println("ERROR: Division-By-Zero");
            return false;
        } else {
            return true;
        }
    }

    public boolean isEqualTo(Fraction other) {
        return (this.getNumerator() * other.getDenominator()) == (this.getDenominator() * other.getNumerator());
    }

    public double toDouble() {
        return (double)getNumerator()/getDenominator();
    }

}