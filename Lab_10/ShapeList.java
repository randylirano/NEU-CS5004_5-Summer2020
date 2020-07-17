import java.util.*;
import MyShapes.*;

public class ShapeList {
    private List<Shapes> myList;

    public ShapeList() {
        myList = new ArrayList<Shapes>();
    }

    public List<Shapes> getMyList() {
        List<Shapes> copyList = new ArrayList<Shapes>(this.myList);
        return copyList;
    }

    public void add(Shapes s) {
        this.myList.add(s);
    }

    public Shapes get(int i) {
        return this.myList.get(i);
    }

    public Shapes getMin() {
        return Collections.<Shapes>min(this.myList);
    }

    public Shapes getMax() {
        return Collections.<Shapes>max(this.myList);
    }

    public String toString() {
        String s = "[";
        for (Shapes item : this.myList) {
            s += item.toString();
            s += " ";
        }
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        ShapeList list = new ShapeList();
        System.out.println(list);
        
        Rectangle a = new Rectangle(2.5, 4.5, 1);
        Circle b = new Circle(3, 1);
        RightTri c = new RightTri(4, 3, 1);

        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list);
        System.out.println("Smallet shape: " + list.getMin());
        System.out.println("Largest shape: " + list.getMax());
    }
}