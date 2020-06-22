import myShapes.*;

public class ShapesTest {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(2.5, 4.5);
        System.out.println(a);
        System.out.println("A dimension: " + a.getWidth() + " x " + a.getLength());
        Circle b = new Circle(3);
        System.out.println(b);
        Triangle c = new Triangle(3, 4, 5);
        System.out.println(c);
    }
}