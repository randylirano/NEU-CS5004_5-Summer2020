package myShapes;

public class Rectangle extends Shapes {
    private double width;
    private double length;

    // Constructor with no arguments
    public Rectangle() {
        this(0.0, 0.0);
    }

    // Constructor with width and length as arguments
    public Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
    }

    // Copy constructor
    public Rectangle(Rectangle other) {
        this(other.getWidth(), other.getLength());
    }

    // Getter methods
    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    // Setter methods
    public boolean setWidth(double width) {
        if (width >= 0.0) {
            this.width = width;
            return true;
        }
        return false;
    }

    public boolean setLength(double length) {
        if (width >= 0.0) {
            this.length = length;
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        return getWidth() * getLength();
    }

    @Override
    public double perimeter() {
        return (2 * getWidth()) + (2 * getLength());
    }

    public String toString() {
        return "width: " + getWidth() + "; length: " + getLength() + "; area: " + area();
    }

    // public static void main(String[] args) {
    //     Rectangle a = new Rectangle();
    //     Rectangle b = new Rectangle(2.5, 4.5);
    //     Rectangle c = new Rectangle(b);
    //     System.out.println("a is larger than b: " + a.compareTo(b));
    //     System.out.println("b is larger than a: " + b.compareTo(a));
    //     System.out.println("B dimension: " + b.getWidth() + " x " + b.getLength());
    //     System.out.println("C dimension: " + c.getWidth() + " x " + c.getLength());

    //     Shapes d = new Rectangle(3, 6);
    //     System.out.println("d is larger than b: " + d.compareTo(b));
    // }
}