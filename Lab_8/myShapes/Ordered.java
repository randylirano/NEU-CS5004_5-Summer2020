package myShapes;

public interface Ordered {
    public boolean precedes(Object other);
    public boolean follows(Object other);
}