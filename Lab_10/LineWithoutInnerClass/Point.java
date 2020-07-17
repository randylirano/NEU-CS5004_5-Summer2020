package LineWithoutInnerClass;

public class Point {
    // Point class instances
    private double x;
    private double y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}