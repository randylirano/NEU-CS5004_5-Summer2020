package myShapes;

import java.util.Comparator;

public abstract class Shapes implements Comparable<Shapes>, Ordered {
    abstract double area();

    abstract double perimeter();

    abstract int getColor();

    public int compareTo(Shapes other) {
        return Double.compare(this.area(), other.area());
    }

    public boolean precedes(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Shapes)) {
            return false;
        } else {
            return this.perimeter() < ((Shapes) other).perimeter();
        }
    }

    public boolean follows(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Shapes)) {
            return false;
        } else {
            return this.perimeter() > ((Shapes) other).perimeter();
        }
    }
}