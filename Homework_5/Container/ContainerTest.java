package Container;

/**
 * ContainerTest.java
 */

/**
 * CS5004 Assignment 5: Problem 1 - Container Class.
 * This class test a programmer defined container object.
 * 
 * @author Randy Lirano
 * @since 2020-06-14
 */
public class ContainerTest {
    
    public static void main(String[] args) {
        // Test transfer from container b to container a
        Container a = new Container(10);
        Container b = new Container(5);

        // Case 1: Container B is empty
        // a.transfer(b, 1);

        // Case 2: Container B is not empty, but transferQuantity negative value
        // b.full();
        // a.transfer(b, -1);

        // Case 3: Container A full 
        // a.full();
        // b.full();
        // a.transfer(b, 1);

        // Case 4: Transfer more than B quantity
        // b.full();
        // a.transfer(b, 10);

        // Case 5: Transfer more than A leftOver
        // Container c = new Container(15);
        // c.full();
        // a.empty();
        // a.transfer(c, 12);

        // Case 6: Transfer not more than leftover and quantity
        // b.full();
        // a.transfer(b, 2);
        // a.displayQuantity();
    }
}

/**
 * This class is a programmer-defined container object
 */
class Container {
    // Container class instances
    private double maximumCapacity;
    private double currentQuantity;

    // Constructor needs to have maximumCapacity
    // as it does not make sense to have container with no capacity being specified
    public Container(double maximumCapacity) {
        if (maximumCapacity > 0.0) {
            this.maximumCapacity = maximumCapacity;
        } else {
            System.out.println("ERROR: Invalid Input Entered. Exiting Program");
            System.exit(1);
        }
    }

    // Get the current quantity in the container
    public double quantity() {
        return this.currentQuantity;
    }

    // Calculate the amount of quantity that can be filled before the container is full
    public double leftOver() {
        return this.maximumCapacity - quantity();
    }

    // Completely fill the container
    public void full() {
        this.currentQuantity = this.maximumCapacity;
    }

    // Completely empty the container
    public void empty() {
        this.currentQuantity = 0.0;
    }

    // Transfer liquid from other container
    public void transfer(Container other, double transferQuantity) {
        // other container is empty || transferQuantity < 0.0 -> transfer not permitted
        if (other.currentQuantity == 0.0 || transferQuantity <= 0.0 || transferQuantity > this.leftOver() || transferQuantity > other.quantity()) {
            System.out.println("ERROR: Invalid transfer condition");
        } else if (transferQuantity <= this.leftOver() && transferQuantity <= other.quantity()) {
            this.currentQuantity += transferQuantity;
            other.currentQuantity -= transferQuantity;
            System.out.println("SUCCESS: Transfer Completed");
        } 
    }

    public void displayQuantity() {
        System.out.println("Current Quantity: " + this.quantity());
    }
    
}