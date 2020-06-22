package myShapes;

public abstract class Shapes {
    abstract double area();

    abstract double perimeter();

    public boolean compareTo(Shapes other) {
        if (this.area() > other.area()) {
            return true;
        } else {
            return false;
        }
    }
}