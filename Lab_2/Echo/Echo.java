package Echo;
/*
 * Echo.java
 */

/**
 * CS5004 Lab 2: Problem 5 - Echo
 * This class echo scanner for user input to terminal
 * 
 * @author Randy Lirano
 * @since 2020-05-14
 */

import java.util.Scanner;

public class Echo {
    /**
     * This function prompts user input using scanner
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please provide name: ");
        String userName = console.next();
        System.out.print("Please provide age: ");
        int userAge = console.nextInt();
        System.out.print("Please provide school: ");
        String userSchool = console.nextLine();
    }
}