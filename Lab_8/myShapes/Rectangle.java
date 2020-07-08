package myShapes;

public class Rectangle extends Shapes {
    private double width;
    private double length;
    private int color;

    // Constructor with width and length as arguments
    public Rectangle(double width, double length, int color) {
        if (checkSide(width) && checkSide(length)) {
            setWidth(width);
            setLength(length);
            setColor(color);
        } else {
            System.out.println("Illegal Dimension");
            System.exit(-1);
        }
    }

    // Copy constructor
    public Rectangle(Rectangle other) {
        this(other.getWidth(), other.getLength(), other.getColor());
    }

    // Getter methods
    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public int getColor() {
        return this.color;
    }

    // Setter methods
    public boolean setWidth(double width) {
        if (checkSide(width)) {
            this.width = width;
            return true;
        }
        return false;
    }

    public boolean setLength(double length) {
        if (checkSide(length)) {
            this.length = length;
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

    private boolean checkSide(double side) {
        if (side < 0) {
            return false;
        }
        return true;
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
    //     Rectangle a = new Rectangle(2.5, 4.5);
    //     Rectangle b = new Rectangle(a);
    //     System.out.println("Rectangle A: " + a);
    //     System.out.println("Rectangle B: " + b);

    //     Shapes c = new Rectangle(3, 6);
    //     System.out.println("Rectangle C is larger than Rectangle B: " + c.compareTo(b));
    // }
}