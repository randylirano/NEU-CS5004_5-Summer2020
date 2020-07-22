/**
 * ArrayListDemo.java
 */

/**
 * CS5004 Lab 11: Problem 0, 1, 2, 3, 4
 * This class provides excercise to work with ArrayList
 * 
 * @author Randy Lirano
 * @since 2020-07-16
 */

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<String> toDoList = new ArrayList<String>(3);
        System.out.println("List size: " + toDoList.size());
        boolean done = false;
        String next = null;
        String answer;

        System.out.println("Enter list entries when prompted!");
        while(!done) {
            System.out.println("Input an entry:");
            next = console.nextLine();

            // Adding to end of list
            toDoList.add(next);

            // Adding to beginning of list
            // toDoList.add(0, next);

            System.out.println("More item for the list?");
            answer = console.nextLine();

            if (!(answer.equalsIgnoreCase("yes"))) {
                done = true;
            }
        }

        // Custom print method
        // printList(toDoList);

        // Printing with for-each loop
        // System.out.println("The list contains:");
        // for (String item : toDoList) {
        //     System.out.println(item);
        // }

        // Try-block to handle IndexOutOfBoundsException when
        // the program try to get index larger than the current size
        // try {
        //     System.out.println("Try retrieving item of index 3 from toDoList");
        //     System.out.println(toDoList.get(3));
        // } catch (IndexOutOfBoundsException e) {
        //     System.out.println("The requested index is larger than the current size");
        //     System.out.println("The current highest index is:");
        //     System.out.println(toDoList.size() - 1 + ". " + toDoList.get(toDoList.size() - 1));
        // }

        // Try retrieving negative index
        // try {
        //     callNegativeIndex(toDoList);
        // } catch (IndexOutOfBoundsException e) {
        //     System.out.println("Cannot retrieve negative index");
        //     System.out.println("Here is the smallest index:");
        //     System.out.println("0. " + toDoList.get(0));
        // }
    }

    // Custom print method
    // Print the size of a given list, and element with their index
    public static void printList(ArrayList<String> list) {
        System.out.println("The size of the list is: " + list.size());
        
        // Use Set to modify the middle of the list
        // int index = list.size() / 2;
        // list.set(index, "EDITTED");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }

    // Custom method to retrieve element of negative index
    // Exception is to be thrown upward and handled by the calling method
    public static void callNegativeIndex(ArrayList<String> list) throws IndexOutOfBoundsException {
        System.out.println(list.get(-1));
    }
}

/*
Problem 0
Q1: 
When is a traditional for loop better?

>> Traditional loop is better when we need to perform an operation involving the actual index in the list.
Other condition is when we don't want to access every element in a list, but only limit accessing until a certain limit or accessing specific number of index.

Q2: 
Why use the for-each construct instead of regular for loop?

>> for-each loop is better when we are sure to access all element in a given list and our operation does not include the index.

Problem 1
Q1:
Try using the get(index) method to obtain an element that is at a position higher than you have entered but lower than the initial capacity of the ArrayList. what was the result?

>> It will throw an IndexOutOfBoundException

Q2:
Is size() the same as capacity?

>> No, size() is how many item in the list, and capacity() is how many item can be hold in the list.

Q3:
Is there a way to look up capacity without violating source code privacy?

>> No

Q4: Since ArrayLists automatically re-size, anyway, why bother providing an initial capacity?

>>

Problem 4
Q1:
Could you accomplish the same behavior, without using a try block?

>> Yes, if a method throws an exception it doesn't have to have a try block, but the calling method still
required to have try block to handle the exception.

Q2:
Since your code may throw an exception, even though you have a catch block,
do you need a “throws” declaration here? (Why or why not?)

>> No need for throws declaration if the methods handle the exception directly.
*/