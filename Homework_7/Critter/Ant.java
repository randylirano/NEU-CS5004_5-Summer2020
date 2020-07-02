package Critter;

/**
 * Ant.java
 */

/**
 * CS5004 Assignment 7: Ant Class.
 * This class is programmer defined Ant which is derived from Organism class.
 * 
 * @author Randy Lirano
 * @since 2020-06-28
 */

import java.util.Random;
import java.util.ArrayList;

public class Ant extends Organism {
    // Class instances
    private Coordinate coordinate;
    private int timeStep;
    private int spawnCount;
    private Organism[][] critterWorld;
    private ArrayList<Ant> antSpawn;

    // Constructor
    public Ant(Organism[][] critterWorld, ArrayList<Ant> antSpawn) {
        this.critterWorld = critterWorld;
        this.timeStep = 0;
        this.spawnCount = 0;
        this.antSpawn = antSpawn;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    public int getTimeStep() {
        return this.timeStep;
    }

    public int getSpawn() {
        return this.spawnCount;
    }

    public void setCoordinate(int row, int col) {
        this.coordinate = new Coordinate(row, col);
    }

    @Override
    // Using random number generator to determined the direction of the movement
    public void move() {
        ArrayList<Coordinate> validDirectionList = checkSurrounding();
        if (validDirectionList.size() > 0) {
            this.move(validDirectionList);
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

    // Check surrounding of the ant, if there is an empty spot, add it to list of valid direction
    private ArrayList<Coordinate> checkSurrounding() {
        ArrayList<Coordinate> validDirectionList = new ArrayList<Coordinate>();
        Coordinate up = new Coordinate(getCoordinate().getRow(), getCoordinate().getCol() - 1);
        Coordinate right = new Coordinate(getCoordinate().getRow() + 1, getCoordinate().getCol());
        Coordinate down = new Coordinate(getCoordinate().getRow(), getCoordinate().getCol() + 1);
        Coordinate left = new Coordinate(getCoordinate().getRow() - 1, getCoordinate().getCol());

        if (validDirection(up)) {
            validDirectionList.add(up);
        }

        if (validDirection(right)) {
            validDirectionList.add(right);
        }

        if (validDirection(down)) {
            validDirectionList.add(down);
        }

        if (validDirection(left)) {
            validDirectionList.add(left);
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
        Ant spawn = new Ant(critterWorld, antSpawn);
        spawn.setCoordinate(spawnRow, spawnCol);
        critterWorld[spawnRow][spawnCol] = spawn;
        antSpawn.add(spawn);

        this.spawnCount++;
        this.timeStep = 0;
    }

    public String toString() {
        return "o";
    }

}



