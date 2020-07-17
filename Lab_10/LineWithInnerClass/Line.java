package LineWithInnerClass;

public class Line {
    // Private inner-class Point
    private class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

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
        return this.p1.y == this.p2.y;
    }

    // Check for vertical line
    private boolean isVertical() {
        return this.p1.x == this.p2.x;
    }

    public double slope() {
        if (this.isHorizontal() || this.isVertical()) {
            return 0.0;
        } else {
            double dy = this.p2.y - this.p1.y;
            double dx = this.p2.x - this.p1.x;
            return dy / dx;
        }
    }

    public String toString() {
        return "P1: " + p1 + ", P2: " + p2;
    }

    // Main for test
    public static void main(String[] args) {
        Line l1 = new Line(0, 0, 1, 1);
        Line l2 = new Line(-1, -1, 0, 0);
        System.out.println("L1:");
        System.out.println(l1);
        System.out.println("L2:");
        System.out.println("(" + l2.p1.x + ", " + l2.p1.y + "), " + "(" + l2.p2.x + ", " + l2.p2.y + ")");
        // It is possible for the main method to access x and y of point p1 and p2 since both the main and the inner class
        // are local to the outer class Line
    }
}