package myShapes;

public class Circle extends Shapes {
    private double radius;

    // Constructor with no arguments
    public Circle() {
        this(0.0);
    }

    // Constructor with width and length as arguments
    public Circle(double radius) {
        setRadius(radius);
    }

    // Copy constructor
    public Circle(Circle other) {
        this(other.getRadius());
    }

    // Getter method
    public double getRadius() {
        return this.radius;
    }

    // Setter method
    public boolean setRadius(double radius) {
        if (radius >= 0.0) {
            this.radius = radius;
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double perimeter() {
        return Math.PI * 2 * getRadius();
    }

    public String toString() {
        return "radius: " + getRadius() + "; area: " + area();
    }
    
    // public static void main(String[] args) {
    //     Circle a = new Circle();
    //     Circle b = new Circle(3);
    //     Circle c = new Circle(b);
    //     System.out.println("a is larger than b: " + a.compareTo(b));
    //     System.out.println("b is larger than a: " + b.compareTo(a));
    //     System.out.println("B dimension: " + b.getRadius());
    //     System.out.println("C dimension: " + c.getRadius());

    //     Shapes d = new Circle(4);
    //     System.out.println("d is larger than b: " + d.compareTo(b));

    //     Rectangle e = new Rectangle(2, 4);
    //     System.out.println("b is larger than e: " + b.compareTo(e));
    // }
}