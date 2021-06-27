package Adventure;
import java.util.*;

public class Maze {
    private HashSet<Room> theMaze;
    private Room currentRoom;

    public Maze() {
        this.currentRoom = new Room("Trail Head",
                "You are on the side of a country road, at a trail head.\n" +
                          "You notice a sign saying, \'Enter at your own risk.\'");
        theMaze = new HashSet<>();
        // currentRoom.addExit(Adventure.Direction.NORTH, currentRoom);
        addToMaze(this.currentRoom);
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room r) {
        this.currentRoom = r;
    }

    public HashSet<Room> getTheMaze() {
        return theMaze;
    }

    public void setTheMaze(HashSet<Room> theMaze) {
        this.theMaze = theMaze;
    }

    public void addToMaze(Room r){
        theMaze.add(r);
    }

    public static void main(String[] args) {
        // Create the Maze
        // Ideally read the Maze in from a text file or possibly generate one randomly
        Maze MAZE = new Maze();
        System.out.println("Welcome to Adventure!");
        String[] stuff = new String[]{"Scribbled Note", "Bottle of Potion"};
        Room r1 = MAZE.getCurrentRoom();
        MAZE.getCurrentRoom().setContents(stuff);
        Room r2 = new Room("Hall of Mountain King", "You are in a Giant Chamber with a tall ceiling.");
        r1.addExit(Adventure.Direction.NORTH, r2);
        r2.setContents(new String[] {"Knife", "Golden Amulet"});
        r2.addExit(Adventure.Direction.SOUTH, r1);

        System.out.println(MAZE.getCurrentRoom());

        // Skeleton for main "game loop"
        boolean finished = false;
        while (!finished) {
            // Ask the user for next direction and assume it is legal
            // Also ask about use of inventory items, battles, and so on, of course
            MAZE.setCurrentRoom(MAZE.getCurrentRoom().getNextRoom(Direction.NORTH));
            System.out.println("Heading " + Direction.NORTH);
            System.out.println(MAZE.getCurrentRoom());
            MAZE.setCurrentRoom(MAZE.getCurrentRoom().getNextRoom(Direction.SOUTH));
            System.out.println("Heading " + Direction.SOUTH);
            System.out.println(MAZE.getCurrentRoom());
            finished = true;
        }
    }
}
