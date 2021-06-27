package Adventure;
import java.util.*;

public class Room {

    private String name;
    private String[] contents;
    private String description;
    private HashMap<Direction, Room> exits;
    // Later add other elements such as monsters, other players

    public Room(String name) {
        this.name = name;
        this.contents = new String[]{};
        this.exits = new HashMap<Direction, Room>();
        this.description = "";
    }

    public Room(String name, String description) {
        this.name = name;
        this.contents = new String[]{};
        this.exits = new HashMap<Direction, Room>();
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public HashMap<Direction, Room> getExits() {
        return this.exits;
    }

    public Set<Direction> getExitDirections() {
        return getExits().keySet();
    }

    public void setExits(HashMap<Direction, Room> exits) {
        this.exits = exits;
    }

    public void addExit(Direction d, Room r) {
        this.exits.put(d, r);
    }

    public String[] getContents() {
        return this.contents;
    }

    public void setContents(String[] newContents) {
        this.contents = newContents;
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (o instanceof Room)) {
            Room ro = (Room) o;
            return this.getName().equals(ro.getName());
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        String temp = this.name + ", with exits: " + this.getExitDirections() + ".\n";
        temp = temp + this.description + "\n";
        for (String c : this.getContents()) {
            temp = temp + "You see: " + c + ".\n";
        }
        return temp;
    }

    public Room getNextRoom(Direction d) {
        if (this.getExitDirections().contains(d)) {
            return this.exits.get(d);
        }
        System.out.println("You cannot go " + d + " from room " + this);
        return this;
    }
}
