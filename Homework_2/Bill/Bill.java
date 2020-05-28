package Bill;

/*
 * Bill.java 
 */

import java.util.Scanner;

/**
 * CS5004 Assignment 2: Problem 2 - Bill.
 * This class serves as a bill calculator for grocery items.
 * 
 * @author Randy Lirano
 * @since 2020-05-22
 */

public class Bill {
    // Declare the number of grocery items
    public static final int NUMBER_OF_ITEMS = 3;
    // Declare the tax rate (6.25%)
    public static final double TAX_RATE = .0625;

    /**
     * This function serves as a calculator for grocery items.
     * 
     * @param args(unused)
     */
    public static void main(String[] args) {
        // Initialize Scanner class named console to receive keyboard input
        Scanner console = new Scanner(System.in);

        // Use array to store the name of the items
        String[] itemNames = new String[NUMBER_OF_ITEMS];
        // Use array to store the quantity of the items
        int[] itemQuantities = new int[NUMBER_OF_ITEMS];
        // Use array to store the retail price of each item
        double[] itemRetailPrice = new double[NUMBER_OF_ITEMS];
        // Store the total price of each item
        double[] itemTotalPrice = new double[NUMBER_OF_ITEMS];

        // The sum of the grocery bill before tax
        double subTotal = 0.0;

        // Prompt user to provide name, quantity, and retail price of the grocery items
        // Update the total price and subtotal grocery as user keep providing
        // item informations
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            System.out.printf("Input name of item %d:\n", i + 1);
            itemNames[i] = console.nextLine();
            System.out.printf("Input quantity of item %d:\n", i + 1);
            itemQuantities[i] = console.nextInt();
            System.out.printf("Input price of item %d:\n", i + 1);
            itemRetailPrice[i] = console.nextDouble();
            itemTotalPrice[i] = itemQuantities[i] * itemRetailPrice[i];
            subTotal += itemTotalPrice[i];
            // Handle \n in the prompt, and store it into junk variable
            String junk = console.nextLine();
        }

        // Calculated the sales tax based of the subtotal
        double salesTax = subTotal *TAX_RATE;
        // Calculated the total grocery bill after tax
        double total = salesTax + subTotal;

        // Print all the grocery item and bill information
        System.out.println();
        System.out.println("Your bill:");
        System.out.println();
        System.out.printf("%-30s%-10s%-10s%-10s\n","Item", "Quantity", "Price", "Total");
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", itemNames[i], itemQuantities[i], itemRetailPrice[i], itemTotalPrice[i]);
        }
        System.out.printf("%-30s%20s%-10.2f\n", "Subtotal", "", subTotal);
        System.out.printf("%-30s%20s%-10.2f\n", "6.25 percent sales tax", "", salesTax);
        System.out.printf("%-30s%20s%-10.2f\n", "Total", "", total);
        console.close();
    }
    
}