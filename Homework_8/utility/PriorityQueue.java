package utility;

/**
 * PriorityQueue.java
 */

/**
 * CS5004 Assignment 8: PriorityQueue Class
 * This class implements priority queue using generic type and ArrayList.
 * 
 * @author Randy Lirano
 * @since 2020-07-19
 */

import java.util.ArrayList;

/**
 * Store items and sort them based their given weight (priority).
 * Item with the highest prioritu goes to the front of the queue.
 * 
 * @param <T1> itemList holds the given items.
 * @param <T2> weightList holds the weight of the given item, and determined the ordering.
 */
public class PriorityQueue<T1, T2 extends Comparable<T2>> {
    private ArrayList<T1> itemList;
    private ArrayList<T2> weightList;

    // Default constructor
    public PriorityQueue() {
        this.itemList = new ArrayList<T1>();
        this.weightList = new ArrayList<T2>();
    }

    // Copy constructor
    public PriorityQueue(PriorityQueue<T1, T2> other) {
        this.itemList = new ArrayList<T1>(other.getItems());
        this.weightList = new ArrayList<T2>(other.getWeight());
    }

    public void add(T1 item, T2 weight) {
        if (this.itemList.isEmpty()) {
            // If the list is empty, then item and its weight will be added directly
            itemList.add(item);
            weightList.add(weight);
        } else {
            // If there are elements in the list, then the program iterate to find the appropriate index to insert
            // the item based on its weight.
            boolean added = false;
            int i = 0;
            while (!added && (i < itemList.size())) {
                if (weight.compareTo(this.weightList.get(i)) >= 0) {
                    itemList.add(i, item);
                    weightList.add(i, weight);
                    added = true;
                }
                i++;
            }

            // In the case that the new item has the smallest weight, then no addition inside the above loop
            // hence the program add the item after checking the boolean flag "added"
            if (!added) {
                itemList.add(item);
                weightList.add(weight);
            }
        }
    }

    public ArrayList<T1> getItems() {
        return new ArrayList<T1>(this.itemList);
    }

    public ArrayList<T2> getWeight() {
        return new ArrayList<T2>(this.weightList);
    }

    // Return the top element in the queue, or null if the list is empty
    public T1 peek() {
        if (itemList.isEmpty()) {
            return null;
        } else {
            return itemList.get(0);
        }
    }

    // Check if there are elements in the list
    // If there are elements,this method will return the element with largest priority and remove it from the list
    // otherwise, it returns null
    public T1 remove() {
        if (itemList.isEmpty()) {
            return null;
        } else {
            return itemList.remove(0);
        }
    }

    // Remove all items from the list
    public void reset() {
        this.itemList.clear();
        this.weightList.clear();
    }

    // Return the number of items in the list
    public int size() {
        return this.itemList.size();
    }

    public String toString() {
        return itemList.toString();
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        } else if (getClass() != otherObj.getClass()) {
            return false;
        } else {
            PriorityQueue<T1, T2> other = (PriorityQueue<T1, T2>) otherObj;
            return getItems().equals(other.getItems());
        }
    }

    // Main method for debugging
    // public static void main(String[] args) {
    //     PriorityQueue<String, Integer> q = new PriorityQueue<String, Integer>();
    //     q.add("X", 10);
    //     q.add("Y", 1);
    //     q.add("Z", 3);
    //     System.out.println(q.remove()); // Returns X
    //     System.out.println(q.remove()); // Returns Z
    //     System.out.println(q.remove()); // Returns Y
    //     System.out.println(q);

    //     PriorityQueue<String, Integer> p = new PriorityQueue<String, Integer>();
    //     p.add("X", 10);
    //     p.add("Z", 3);

    //     System.out.println("Q is equal to P: " + q.equals(p));

    //     ArrayList<Integer> x = new ArrayList<Integer>();
    //     ArrayList<Integer> y = new ArrayList<Integer>();
    //     x.add(1);
    //     x.add(2);
    //     y.add(2);
    //     y.add(1);
    //     System.out.println("X is equal to Y: " + x.equals(y));
    // }
}