package myShapes;

public class Circle extends Shapes {
    private double radius;
    private int color;

    // Constructor with width and length as arguments
    public Circle(double radius, int color) {
        if (checkDimension(radius)) {
            setRadius(radius);
            setColor(color);
        } else {
            System.out.println("Illegal Dimension");
            System.exit(-1);
        }
    }

    // Copy constructor
    public Circle(Circle other) {
        this(other.getRadius(), other.getColor());
    }

    // Getter method
    public double getRadius() {
        return this.radius;
    }

    // Setter method
    private boolean checkDimension(double radius) {
        if (radius < 0) {
            return false;
        }
        return true;
    }

    public boolean setColor(int color) {
        if (color >= 0) {
            this.color = color;
            return true;
        }
        return false;
    }

    public boolean setRadius(double radius) {
        if (checkDimension(radius)) {
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

    @Override
    public int getColor() {
        return this.color;
    }
    
    // public static void main(String[] args) {
    //     Circle b = new Circle(3);
    //     Circle c = new Circle(b);
    //     System.out.println("B dimension: " + b.getRadius());
    //     System.out.println("C dimension: " + c.getRadius());

    //     Shapes d = new Circle(4);
    //     System.out.println("d is larger than b: " + d.compareTo(b));

    //     Rectangle e = new Rectangle(2, 4);
    //     System.out.println("b is larger than e: " + b.compareTo(e));
    // }
}