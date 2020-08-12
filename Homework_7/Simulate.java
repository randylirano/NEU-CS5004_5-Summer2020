/**
 * Critter.java
 */

/**
 * CS5004 Assignment 7: Organism Class.
 * This class runs simulation between two critters, ant and doodlebug.
 * 
 * @author Randy Lirano
 * @since 2020-06-28
 */

import Critter.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Simulate {
    // Initial number of Ant and Doodlebug
    private static final int ANT = 5;
    private static final int DOODLEBUG = 100;

    public static void main(String[] args) {
        // Initialize console for user input and random number
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        // Test world constructor
        World world = new World(20, 20);
        Organism[][] critterWorld = world.getCritterWorld();
        ArrayList<Ant> antList = world.getAntList();
        ArrayList<Ant> antSpawn = world.getAntSpawn();
        ArrayList<Doodlebug> doodlebugList = world.getDoodlebugList();
        ArrayList<Doodlebug> doodlebugSpawn = world.getDoodlebugSpawn();

        while (doodlebugList.size() < DOODLEBUG) {
            int row = rand.nextInt(world.getWidth());
            int col = rand.nextInt(world.getLength());
            Doodlebug d = new Doodlebug(critterWorld, antList, doodlebugList, doodlebugSpawn);

            if (critterWorld[row][col] == null) {
                world.addDoodlebug(d, row, col);
            }
        }

        while (antList.size() < ANT) {
            int row = rand.nextInt(world.getWidth());
            int col = rand.nextInt(world.getLength());
            Ant a = new Ant(critterWorld, antSpawn);

            if (critterWorld[row][col] == null) {
                world.addAnt(a, row, col);
            }
        }

        world.displayWorld();
        
        System.out.println("Start Moving: ");
        String userInput = console.nextLine();
        while (!userInput.equals("END")) {
            world.oneTimeStep();
            world.displayWorld();
            userInput = console.nextLine();
        }

    }
}

/**
 * Programmer defined World object.
 * The program initialize the critter World which provides field for critters
 * to interact.
 */
class World {
    // Class instances
    // Maximum number of row
    private int width;
    // Maximum number of col
    private int length;
    // 2-D Array of Organism object, serves as the world for the critter
    private Organism[][] critterWorld;

    // Store the life Ants that are currently in the world
    private ArrayList<Ant> antList = new ArrayList<Ant>();
    private ArrayList<Ant> antSpawn = new ArrayList<Ant>();

    // Store the life Doodlebugs that are currently in the world
    private ArrayList<Doodlebug> doodlebugList = new ArrayList<Doodlebug>();
    private ArrayList<Doodlebug> doodlebugSpawn = new ArrayList<Doodlebug>();
    private ArrayList<Doodlebug> doodlebugDied = new ArrayList<Doodlebug>();


    // Constructor
    public World(int width, int length) {
        this.width = width;
        this.length = length;
        this.critterWorld = new Organism[width][length];
    }

    // Since the information of the playing field will be shared with several Organism
    // and updates will be done continuously, the getter for the array actually return the reference
    // instead of performing a deep copy
    public Organism[][] getCritterWorld() {
        return this.critterWorld;
    }

    public ArrayList<Ant> getAntList() {
        return this.antList;
    }

    public ArrayList<Ant> getAntSpawn() {
        return this.antSpawn;
    }

    public ArrayList<Doodlebug> getDoodlebugList() {
        return this.doodlebugList;
    }

    public ArrayList<Doodlebug> getDoodlebugSpawn() {
        return this.doodlebugSpawn;
    }

    // Return the width of the world
    public int getWidth() {
        return this.width;
    }

    // Return the length of the world
    public int getLength() {
        return this.length;
    }

    // Display the world along with the critter that it has
    public void displayWorld() {
        for (int row = 0; row < getWidth(); row++) {
            for (int col = 0; col < getLength(); col++) {
                if (this.critterWorld[row][col] == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + this.critterWorld[row][col] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Add critter into the world
    public void addAnt(Ant a, int row, int col) {
        this.critterWorld[row][col] = a;
        a.setCoordinate(row, col);
        antList.add(a);
    }

    public void addDoodlebug(Doodlebug d, int row, int col) {
        this.critterWorld[row][col] = d;
        d.setCoordinate(row, col);
        doodlebugList.add(d);
    }

    public void oneTimeStep() {
        for (Doodlebug d : doodlebugList) {
            d.move();
        }
        for (Doodlebug d : doodlebugList) {
            if (d.getStarve() == 3) {
                doodlebugDied.add(d);
            }
        }
        for (Doodlebug d : doodlebugDied) {
            d.dead();
        }
        doodlebugDied.clear();
        for (Ant a : antList) {
            a.move();
        }
        for (Doodlebug d : doodlebugList) {
            if (d.getTimeStep() >= 8 && d.getSpawn() < 10) {
                d.breed();
            }
        }
        for (Ant a : antList) {
            if (a.getTimeStep() >= 3 && a.getSpawn() < 10) {
                a.breed();
            }
        }
        for (Doodlebug d : doodlebugSpawn) {
            doodlebugList.add(d);
        }
        doodlebugSpawn.clear();
        for (Ant a : antSpawn) {
            antList.add(a);
        }
        antSpawn.clear();

    }

    
}


