/*
 * Converter.java
 */

/**
 * CS5004 Assignment 1: Problem 1 - Converter
 * This class serves as a simple Converter
 * 
 * @author Randy Lirano
 * @since 2020-05-14
 */

public class Converter {
    /**
     * This function serves as a simple converter and performs the required operations
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        long giga = 500;
        long gibi = 0;

        gibi = (long) giga * 1000000000 / (1024 * 1024 * 1024);

        System.out.println(giga + "GB = " + gibi + "GiB");
    }
    
}