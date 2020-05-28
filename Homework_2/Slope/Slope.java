package Slope;

/*
 * Slope.java 
 */

import java.util.Scanner;

/**
 * CS5004 Assignment 2: Problem 1 - Slope.
 * This class serves as a simple slope calculator between two points.
 * 
 * @author Randy Lirano
 * @since 2020-05-22
 */
public class Slope {
    
    /**
     * This function serves as a simple slope calculator 
     * between the first point (point p) and the second point (point q).
     * 
     * @param args(unused)
     */
    public static void main(String[] args) {
        // Initialize Scanner class named console to receive keyboard input
        Scanner console = new Scanner(System.in);

        // Request user for x and y coordinates of both points
        System.out.print("Enter the x-value of the first point: ");
        // Store the provided x value of point p in variable xp
        int xp = console.nextInt();
        System.out.print("Enter the y-value of the first point: ");
        // Store the provided y value of point p in variable yp
        int yp = console.nextInt();
        System.out.print("Enter the x-value of the second point: ");
        // Store the provided x value of point q in variable xq
        int xq = console.nextInt();
        System.out.print("Enter the y-value of the second point: ");
        // Store the provided y value of point q in variable yq
        int yq = console.nextInt();

        // Check if the provided two points coordinate are
        // vertical, horizontal, the same point, or have a slope
        if(xp == xq && yp != yq) {
            System.out.println("The line is vertical");
        } else if(xp != xq && yp == yq) {
            System.out.println("The line is horizontal");
        } else if(xp == xq && yp == yq) {
            System.out.println("This is the same point");
        } else {
            float slope = (float) (yq - yp) / (xq - xp);
            System.out.printf("The slope of this line is %1.1f\n", slope);
        }
        
        console.close();
    }
}