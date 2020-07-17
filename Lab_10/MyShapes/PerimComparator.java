package MyShapes;

import java.util.Comparator;

public class PerimComparator implements Comparator<Shapes> {
        // Alternative to Comparable. Hence, additional field can be compared
        public int compare(Shapes s1, Shapes s2) {
            return Double.compare(s1.perimeter(), s2.perimeter());
    }
}
