package LineWithoutInnerClass;

// Since Point class is another top level class, the line class have no access
// to Point x-coordinate and y-coordinate. 
// A getter methods are required in this case.

public class Line {
    // Line class instances
    private Point p1;
    private Point p2;

    // Line class constructor
    public Line(double x1, double y1, double x2, double y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    // Check for horizontal line
    private boolean isHorizontal() {
        return this.p1.getY() == this.p2.getY();
    }

    // Check for vertical line
    private boolean isVertical() {
        return this.p1.getX() == this.p2.getX();
    }

    public double slope() {
        if (this.isHorizontal() || this.isVertical()) {
            return 0.0;
        } else {
            double dy = this.p2.getY() - this.p1.getY();
            double dx = this.p2.getX() - this.p1.getX();
            return dy / dx;
        }
    }

    public String toString() {
        return "P1: " + p1 + ", P2: " + p2;
    }

    // Main for test
    // public static void main(String[] args) {
    //     Line l1 = new Line(0, 0, 1, 1);
    //     Line l2 = new Line(-1, -1, 0, 0);
    //     System.out.println("L1:");
    //     System.out.println(l1);
    //     System.out.println("L2:");
    //     System.out.println("(" + l2.p1.getX() + ", " + l2.p1.getY() + "), " + "(" + l2.p2.getX() + ", " + l2.p2.getY() + ")");
    //     // It is possible for the main method to access x and y of point p1 and p2 since both the main and the inner class
    //     // are local to the outer class Line
    // }
}