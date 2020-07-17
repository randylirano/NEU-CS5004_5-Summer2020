package MyTriple;

/**
 * Triple.java
 */

/**
 * CS5004 Assignment 8: Triple Class
 * This class demonstrate generic implementation by holding three heterogeneous objects.
 * 
 * @author Randy Lirano
 * @since 2020-07-19
 */

public class Triple<T1, T2, T3> {
    // Class instances
    private T1 first;
    private T2 second;
    private T3 third;

    // Constructor
    public Triple(T1 firstItem, T2 secondItem, T3 thirdItem) {
        setFirst(firstItem);
        setSecond(secondItem);
        setThird(thirdItem);
    }

    public Triple() {
        setFirst(null);
        setSecond(null);
        setThird(null);
    }

    // Getter methods
    public T1 getFirst() {
        return this.first;
    }

    public T2 getSecond() {
        return this.second;
    }

    public T3 getThird() {
        return this.third;
    }

    // Setter methods
    public void setFirst(T1 newFirst) {
        this.first = newFirst;
    }

    public void setSecond(T2 newSecond) {
        this.second = newSecond;
    }

    public void setThird(T3 newThrid) {
        this.third = newThrid;
    }

    public String toString() {
        return "First: " + getFirst() + "\n" + "Second: " + getSecond() + "\n" + "Third: " + getThird();
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        } else if (getClass() != otherObj.getClass()) {
            return false;
        } else {
            Triple<T1, T2, T3> other = (Triple<T1, T2, T3>) otherObj;
            return first.equals(other.first) && second.equals(other.second) && third.equals(other.third);
        }
    }
}



