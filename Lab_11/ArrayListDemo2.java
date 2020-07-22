/**
 * ArrayListDemo2.java
 */

/**
 * CS5004 Lab 11: Problem 5
 * This class provides excercise to work with exception when reading from file
 * 
 * @author Randy Lirano
 * @since 2020-07-16
 */

import java.util.*;
import java.io.*;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner inputFile = null;

        ArrayList<String> toDoList = new ArrayList<String>();
        boolean fileFound = false;
        int trial = 0;

        // Keep asking for file name until the provided file name exist or 3 failed trial
        while(!fileFound && trial < 3) {
            System.out.println("Provide file name");
            String fileName = console.next();

            try {
                inputFile = new Scanner(new FileInputStream(fileName));
                fileFound = true;
            } catch (Exception e) {
                System.out.println("File not found.");
                trial++;
            }
        }

        // If the program reach here while file still not found, exit the program
        if (!fileFound) {
            System.out.println("3 attempts have been made, and still no valid file provided.");
            System.out.println("Exiting.");
            System.exit(-1);
        }

        // If the file name exist, keep adding String from file to ArrayList
        while (inputFile.hasNextLine()) {
            toDoList.add(inputFile.nextLine());
        }

        // Custom print method
        printList(toDoList);

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
    // public static void callNegativeIndex(ArrayList<String> list) throws IndexOutOfBoundsException {
    //     System.out.println(list.get(-1));
    // }
}

/*
Problem 0
Q1: 
Since it is still possible to eventually throw a FileNotFoundException,
even though you have a catch block for it, does that mean you need a “throws” declaration here?
(Why or why not?)

>> No, because the exception is being handled directly.

Q2: 
Instead of having to keep asking the user whether there are more elements,
how do you know when you have read all of the elements?
Be sure to submit both your code and your sample .txt file.

>> Iterate the given file name using a while loop.
*/