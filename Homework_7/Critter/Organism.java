package Critter;

import java.util.TreeMap;

/**
 * Organism.java
 */

/**
 * CS5004 Assignment 7: Organism Class.
 * This class is programmer defined Organism which will be a base class.
 * 
 * @author Randy Lirano
 * @since 2020-06-28
 */

public abstract class Organism {
    
    abstract void move();

    abstract void breed();
}

/**
 * Programmer defined Coordinate object.
 * It holds an information on
 * x-coordinate: row
 * y-coordinate: col
 */
class Coordinate {
    // Class instances
    private int row;
    private int col;

    // Constructor without parameters is not allowed
    // Any coordinate even (0, 0) should be specified
    public Coordinate(int row, int col) {
        setRow(row);
        setCol(col);
    }

    // Copy constructor
    public Coordinate(Coordinate other) {
        this(other.getRow(), other.getCol());
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String toString(){
        return getRow() + ", " + getCol();
    }
}
