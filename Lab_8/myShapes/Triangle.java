package myShapes;

public abstract class Triangle extends Shapes {
    private double side1;
    private double side2;
    private double side3;
    private int color;

    // Constructor with width and length as arguments
    public Triangle(double side1, double side2, double side3, int color) {
        if (checkSide(side1) && checkSide(side2) && checkSide(side3)) {
            setSide1(side1);
            setSide2(side2);
            setSide3(side3);
            setColor(color);
        } else {
            System.out.println("Illegal Dimension");
            System.exit(-1);
        }
    }

    // Copy constructor
    public Triangle(Triangle other) {
        this(other.getSide1(), other.getSide2(), other.getSide3(), other.getColor());
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

    @Override
    public int getColor() {
        return this.color;
    }

    // Setter method
    public boolean setSide1(double side1) {
        if (checkSide(side1)) {
            this.side1 = side1;
            return true;
        }
        return false;
    }

    public boolean setSide2(double side2) {
        if (checkSide(side2)) {
            this.side2 = side2;
            return true;
        }
        return false;
    }

    public boolean setSide3(double side3) {
        if (checkSide(side3)) {
            this.side3 = side3;
            return true;
        }
        return false;
    }

    public boolean setColor(int color) {
        if (color >= 0) {
            this.color = color;
            return true;
        }
        return false;
    }

    public boolean checkSide(double side) {
        if (side < 0) {
            return false;
        }
        return true;
    }

    // Check if triangle is right-triangle or equilateral-triangle
    abstract boolean isRightTriangle();
    abstract boolean isEquilateralTriangle();

    @Override
    public double area() {
        // Heron's formula
        double p = this.perimeter() / 2;
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