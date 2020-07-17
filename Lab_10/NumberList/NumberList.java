package NumberList;

import java.util.*;

public class NumberList {
    // Inner class number
    public class MyNumber extends Number implements Comparable<MyNumber> {
        // MyNumber class instances
        private Number num;

        // Constructor
        public MyNumber(Number n) {
            this.num = n;
        }

        // Getter methods
        public Number getNum() {
            return (Number) this.num;
        }

        public String toString() {
            return getNum().toString();
        }

        @Override
        public int compareTo(MyNumber other) {
            return Double.compare(this.getNum().doubleValue(), other.getNum().doubleValue());
        }

        @Override
        public int intValue() {
            Double d = this.num.doubleValue();
            return (int) Math.round(d);
        }

        @Override
        public long longValue() {
            Double d = this.num.doubleValue();
            return Math.round(d);
        }

        @Override
        public float floatValue() {
            return (float) this.num.doubleValue();
        }

        @Override
        public double doubleValue() {
            Number temp = this.num;
            return temp.doubleValue();
        }
    }
    // End of inner class

    private List<MyNumber> myNl;

    // Constructor for a list of slightly "tweaked" Numbers
    public NumberList() {
        myNl = new ArrayList<MyNumber>();
    }

    public List<MyNumber> getMyNl() { return this.myNl; }

    public void add(Number e) {
        this.getMyNl().add(new MyNumber(e));
    }

    public String toString() {
        String s = new String("[ ");
        // This could be done more elegantly
        for (MyNumber each : this.getMyNl()) {
            s += each.toString();
            s += " ";
        }
        s += "]";
        return s;
    }

    public MyNumber get(int i) {
        return this.getMyNl().get(i);
    }

    public MyNumber min() {
        // Implemented this one by hand, just to demonstrate what's underneath
        List<MyNumber> nl = this.getMyNl();
        MyNumber minSoFar = new MyNumber(Double.MAX_VALUE);
        for (int i = 0; i < nl.size(); i++) {
            System.out.println("minSoFar = " + minSoFar); // Comment out when it gets boring
            MyNumber current = nl.get(i);
            int ans = current.compareTo(minSoFar);
            if (ans < 0) minSoFar = current;
            }
            return minSoFar;
    }

    public MyNumber max() {
        // Do this one using Collections, to show that compareTo override operates as expected
        // Another use of Generics
        return Collections.<MyNumber>max(this.getMyNl());
    }

    public static void main(String[] args) {
        // Create a list of various types of numbers (int, float, long, double)
        // Don't worry about bytes and such
        NumberList nL = new NumberList();
        nL.add(100f);
        for (int i = 0; i < 10; i++) {
            nL.add(i);
        }
        nL.add(-150.21);
        nL.add(500);
        for (int i = -5; i < 6; i++) {
            nL.add((long) i);
        }
        System.out.println("NumberList l = " + nL);
        MyNumber nLMin = nL.min();
        MyNumber nLMax = nL.max();
        System.out.printf("Minimum is: %s%n", nLMin);
        System.out.println("Maximum is: " + nLMax);
    }
}