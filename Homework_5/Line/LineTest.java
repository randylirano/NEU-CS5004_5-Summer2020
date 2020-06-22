/**
 * LineTest.java
 */

/**
 * CS5004 Assignment 5: Problem 2 - Line Class.
 * This class test a programmer defined Line object.
 * 
 * @author Randy Lirano
 * @since 2020-06-14
 */

public class LineTest {
    /**
     * This class perform the necessary testing for Rational and Line object.
     * @param args(unused)
     */
    public static void main(String[] args) {
        // Rational Constructor Debug Print
        // Rational a = new Rational(3,4);
        // System.out.println(a);
        // System.out.println("Numerator: " + a.getNumerator());
        // System.out.println("Denominator: " + a.getDenominator());

        // Rational b = new Rational(1,2);
        // System.out.println(b);
        // System.out.println("Numerator: " + b.getNumerator());
        // System.out.println("Denominator: " + b.getDenominator());

        // Test add method
        // Rational c = b.add(b);
        // System.out.println(c);
        // System.out.println("Numerator: " + c.getNumerator());
        // System.out.println("Denominator: " + c.getDenominator());

        // Test subtract method
        // Rational d = b.sub(a);
        // System.out.println(d);
        // System.out.println("Numerator: " + d.getNumerator());
        // System.out.println("Denominator: " + d.getDenominator());

        // Test multiplication method
        // Rational e = a.mul(a);
        // System.out.println(e);
        // System.out.println("Numerator: " + e.getNumerator());
        // System.out.println("Denominator: " + e.getDenominator());

        // Test division method
        // Rational f = a.div(b);
        // System.out.println(f);
        // System.out.println("Numerator: " + f.getNumerator());
        // System.out.println("Denominator: " + f.getDenominator());

        // Test equal method
        // System.out.println(a.equals(b));

        // Line test
        // Line l1 = new Line(new Rational(1, 3), new Rational(1));
        // System.out.println("Test 1: " + l1);
        // System.out.println(l1.Includes(new Rational(1), new Rational(2)));
        // System.out.println(l1.Includes(new Rational(3), new Rational(2)));
        // System.out.println();

        // Rational slope = new Rational(1,2);
        // Rational intercept = new Rational(0);
        // Line l2 = new Line(slope, intercept);
        // System.out.println("Test 2: " + l2);
        // System.out.println(l2.Includes(new Rational(-1), new Rational(1)));
        // System.out.println(l2.Includes(new Rational(0), new Rational(0)));
        // System.out.println();

        // Rational slope1 = new Rational(5);
        // Rational intercept1 = new Rational(-5);
        // Line l3 = new Line(slope1, intercept1);
        // System.out.println("Test 3: " + l3);
        // System.out.println(l3.Includes(new Rational(0), new Rational(5)));
        // System.out.println(l3.Includes(new Rational(1), new Rational(0)));
        // System.out.println();

    }

}

/**
 * Programmer defined Rational class
 */
class Rational {
    // Class instances
    private int numerator;
    private int denominator;

    // 0 argument constructor
    public Rational() {
        this(0);
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
            normalize();   
        }
    }

    // Copy constructor
    public Rational(Rational other) {
        this(other.getNumerator(), other.getDenominator());
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
        normalize();
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("ERROR: Division-By-Zero");
            System.exit(1);
        } else {
            this.denominator = denominator;
            normalize();
        }
    }

    public Rational add(Rational other) {
        // Variables for calculated numerator and denominator respectively
        int calculatedNum;
        int calculatedDen;

        if (this.getDenominator() == other.getDenominator()) {
            calculatedNum = this.getNumerator() + other.getNumerator();
            calculatedDen = this.getDenominator();
        } else if (this.getDenominator() == 0 && other.getDenominator() != 0) {
            calculatedNum = other.getNumerator();
            calculatedDen = other.getDenominator();
        } else if (this.getDenominator() != 0 && other.getDenominator() == 0) {
            calculatedNum = this.getNumerator();
            calculatedDen = this.getDenominator();
        } else {
            calculatedNum = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
            calculatedDen = this.getDenominator() * other.getDenominator();
        }

        if (calculatedNum == 0) {
            return new Rational();
        } else {
            return new Rational(calculatedNum, calculatedDen);
        }
    }

    public Rational sub(Rational other) {
        // Variables for calculated numerator and denominator respectively
        int calculatedNum;
        int calculatedDen;

        if (this.getDenominator() == other.getDenominator()) {
            calculatedNum = this.getNumerator() - other.getNumerator();
            calculatedDen = this.getDenominator();
        } else if (this.getDenominator() == 0 && other.getDenominator() != 0) {
            calculatedNum = -other.getNumerator();
            calculatedDen = other.getDenominator();
        } else if (this.getDenominator() != 0 && other.getDenominator() == 0) {
            calculatedNum = this.getNumerator();
            calculatedDen = this.getDenominator();
        } else {
            calculatedNum = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
            calculatedDen = this.getDenominator() * other.getDenominator();
        }

        if (calculatedNum == 0) {
            return new Rational();
        } else {
            return new Rational(calculatedNum, calculatedDen);
        }
    }

    public Rational mul(Rational other) {
        // Variables for calculated numerator and denominator respectively
        int calculatedNum = this.getNumerator() * other.getNumerator();
        int calculatedDen = this.getDenominator() * other.getDenominator();

        if (calculatedNum == 0) {
            return new Rational();
        } else {
            return new Rational(calculatedNum, calculatedDen);
        }
        
    }

    public Rational div(Rational other) {
        if (other.getNumerator() == 0) {
            System.out.println("ERROR: Division-by-Zero");
            System.exit(1);
        }
        int calculatedNum = this.numerator * other.denominator;
        int calculatedDen = this.denominator * other.numerator;
        
        if (calculatedNum == 0) {
            return new Rational();
        } else {
            return new Rational(calculatedNum, calculatedDen);
        }
    }

    private void normalize() {
        
        int gcdValue = gcd(this.numerator, this.denominator);
        this.numerator /= gcdValue;
        this.denominator /= gcdValue;

        if (getDenominator() < 0) {
            setNumerator(-this.numerator);
            setDenominator(-this.denominator);
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
        if ((getNumerator() != 0 && getDenominator() == 1) || (getNumerator() == 0)) {
            return "" + getNumerator();
        } else {
            return "" + getNumerator() + "/" + getDenominator();
        }
    }

    public boolean equals(Rational other) {
        this.normalize();
        other.normalize();
        return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
    }
}

/**
 * Programmer defined line class
 */
 class Line {
    //  Class instances
    private Rational slope;
    private Rational intercept;

    // Constructor
    public Line(Rational slope, Rational intercept) {
        this.slope = new Rational(slope);
        this.intercept = new Rational(intercept);
    }

    // Getter methods
    public Rational getSlope() {
        return new Rational(slope);
    }

    public Rational getIntercept() {
        return new Rational(intercept);
    }

    // Setter methods
    public void setSlope(Rational slope) {
        if (slope == null) {
            System.out.println("ERROR: Illegal Argument");
            System.exit(1);
        } else {
            this.slope = new Rational(slope);
        }
    }

    public void setIntercept(Rational intercept) {
        if (intercept == null) {
            System.out.println("ERROR: Illegal Argument");
            System.exit(1);
        } else {
            this.intercept = new Rational(intercept);
        }
    }

    // Check if the given point represented in px and py for its x-coordinate and y-coordinate
    // is included in the defined line.
    // The program return true, if the point is included in the line
    // and false otherwise.
    public boolean Includes(Rational px, Rational py) {
        // Calculate the Left Hand Side (LHS) of line equation
        Rational LHS = getIntercept().add(getSlope().mul(px));
        // Check if the Right Hand Side (RHS) of line equation which is py
        // is equal to the LHS
        return py.equals(LHS);
    }

    public String toString() {
        return "y = " + this.getSlope() + "x + " + this.getIntercept();
    }

    public boolean equals(Line other) {
        return this.getSlope().equals(other.getSlope()) && this.getIntercept().equals(other.getIntercept());
    }

 }