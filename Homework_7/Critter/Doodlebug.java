package Critter;

/**
 * Doodlebug.java
 */

/**
 * CS5004 Assignment 7: Organism Class.
 * This class is programmer defined Doodlebug which is derived from Organism class.
 * 
 * @author Randy Lirano
 * @since 2020-06-28
 */

import java.util.Random;
import java.util.ArrayList;

public class Doodlebug extends Organism {
    // Class instances
    private Coordinate coordinate;
    private int timeStep;
    private int spawnCount;
    private Organism[][] critterWorld;
    private ArrayList<Ant> antList;
    private ArrayList<Doodlebug> doodlebugList;
    private ArrayList<Doodlebug> doodlebugSpawn;
    private int starve;

    // Constructor
    public Doodlebug(Organism[][] critterWorld, ArrayList<Ant> antList, ArrayList<Doodlebug> doodlebugList, ArrayList<Doodlebug> doodlebugSpawn) {
        this.critterWorld = critterWorld;
        this.timeStep = 0;
        this.spawnCount = 0;
        this.starve = 0;
        this.antList = antList;
        this.doodlebugList = doodlebugList;
        this.doodlebugSpawn = doodlebugSpawn;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    public int getTimeStep() {
        return this.timeStep;
    }

    public int getStarve() {
        return this.starve;
    }

    public int getSpawn() {
        return this.spawnCount;
    }

    public void setCoordinate(int row, int col) {
        this.coordinate = new Coordinate(row, col);
    }

    @Override
    public void move() {
        ArrayList<Coordinate> validDirectionList = checkSurrounding();

        if (validDirectionList.size() > 0) {
            if (isPrey(validDirectionList.get(0))) {
                this.eatAndMove(validDirectionList);
                this.starve = 0;
            } else {
                this.move(validDirectionList);
                this.starve++;
            }
        } else {
            this.starve++;
        }
        this.timeStep++;
    }

    // Private helper for move method
    // It takes an arraylist of all possible direction
    // If there is a possible direction randomly choose it and move, then increase timestep
    // If there is no possible direction, just increase timestep without making a move
    private void move(ArrayList<Coordinate> valildDirectionList) {
        // Decide on the direction
        Random rand = new Random();
        int direction = rand.nextInt(valildDirectionList.size());

        // Hold the current row and col
        int currRow = getCoordinate().getRow();
        int currCol = getCoordinate().getCol();

        // Get the new row and col
        int newRow = valildDirectionList.get(direction).getRow();
        int newCol = valildDirectionList.get(direction).getCol();

        // Execute moving by setting new row and col value
        setCoordinate(newRow, newCol);
        critterWorld[newRow][newCol] = this;
        critterWorld[currRow][currCol] = null;
    }

    private void eatAndMove(ArrayList<Coordinate> preyList) {
        // Decide on the direction
        Random rand = new Random();
        int direction = rand.nextInt(preyList.size());

        // Hold the current row and col
        int currRow = getCoordinate().getRow();
        int currCol = getCoordinate().getCol();

        // Get the new row and col
        int newRow = preyList.get(direction).getRow();
        int newCol = preyList.get(direction).getCol();

        // Remove ant at critterWorld[newRow][newCol], then remove it from antList
        antList.remove(antList.indexOf(critterWorld[newRow][newCol]));
        setCoordinate(newRow, newCol);
        critterWorld[newRow][newCol] = this;
        critterWorld[currRow][currCol] = null;

    }

    @Override
    public void breed() {
        ArrayList<Coordinate> validDirectionList = checkSurrounding();
        if (validDirectionList.size() > 0) {
            this.breed(validDirectionList);
            this.spawnCount++;
            this.timeStep = 0;
        }
    }

    private void breed(ArrayList<Coordinate> validDirectionList) {
        // Decide on the direction
        Random rand = new Random();
        int direction = rand.nextInt(validDirectionList.size());

        // Get the new row and col
        int spawnRow = validDirectionList.get(direction).getRow();
        int spawnCol = validDirectionList.get(direction).getCol();

        // Produce spawn
        Doodlebug spawn = new Doodlebug(critterWorld, antList, doodlebugList, doodlebugSpawn);
        spawn.setCoordinate(spawnRow, spawnCol);
        critterWorld[spawnRow][spawnCol] = spawn;
        doodlebugSpawn.add(spawn);
    }

    public void dead() {
        int row = getCoordinate().getRow();
        int col = getCoordinate().getCol();
        critterWorld[row][col] = null;
        doodlebugList.remove(this);
    }

    // Check surrounding of the ant, if there is an empty spot, add it to list of valid direction
    private ArrayList<Coordinate> checkSurrounding() {
        ArrayList<Coordinate> validDirectionList = new ArrayList<Coordinate>();
        ArrayList<Coordinate> preyList = new ArrayList<Coordinate>();
        Coordinate up = new Coordinate(getCoordinate().getRow(), getCoordinate().getCol() - 1);
        Coordinate right = new Coordinate(getCoordinate().getRow() + 1, getCoordinate().getCol());
        Coordinate down = new Coordinate(getCoordinate().getRow(), getCoordinate().getCol() + 1);
        Coordinate left = new Coordinate(getCoordinate().getRow() - 1, getCoordinate().getCol());

        if (isPrey(up)) {
            preyList.add(up);
        } else if (validDirection(up)) {
            validDirectionList.add(up);
        }

        if (isPrey(right)) {
            preyList.add(right);
        } else if (validDirection(right)) {
            validDirectionList.add(right);
        }

        if (isPrey(down)) {
            preyList.add(down);
        } else if (validDirection(down)) {
            validDirectionList.add(down);
        }

        if (isPrey(left)) {
            preyList.add(left);
        } else if (validDirection(left)) {
            validDirectionList.add(left);
        }

        if (preyList.size() > 0) {
            return preyList;
        } 
        return validDirectionList;
    }

    private boolean validDirection(Coordinate c) {
        int row = c.getRow();
        int col = c.getCol();

        if (row < 0 || row >= critterWorld.length || col < 0 || col >= critterWorld[0].length || critterWorld[row][col] != null) {
            return false;
        } 
        return true;
    }

    private boolean isPrey(Coordinate c) {
        int row = c.getRow();
        int col = c.getCol();

        if (row < 0 || row >= critterWorld.length || col < 0 || col >= critterWorld[0].length) {
            return false;
        } 

        if (critterWorld[row][col] instanceof Ant) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "X";
    }
    
}

