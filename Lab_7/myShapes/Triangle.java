package myShapes;

public class Triangle extends Shapes {
    private double side1;
    private double side2;
    private double side3;

    // Constructor with no arguments
    public Triangle() {
        this(0.0, 0.0, 0.0);
    }

    // Constructor with width and length as arguments
    public Triangle(double side1, double side2, double side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    // Copy constructor
    public Triangle(Triangle other) {
        this(other.getSide1(), other.getSide2(), other.getSide3());
    }

    // Getter method
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    // Setter method
    public boolean setSide1(double side1) {
        if (side1 >= 0.0) {
            this.side1 = side1;
            return true;
        }
        return false;
    }

    public boolean setSide2(double side2) {
        if (side2 >= 0.0) {
            this.side2 = side2;
            return true;
        }
        return false;
    }

    public boolean setSide3(double side3) {
        if (side3 >= 0.0) {
            this.side3 = side3;
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - getSide1()) * (p - getSide2()) * (p - getSide3()));
    }

    @Override
    public double perimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public String toString() {
        return "Side 1: " + getSide1() + "; Side 2: " + getSide2() + "; Side 3: " + getSide3() + "; area: " + area();
    }
    
}