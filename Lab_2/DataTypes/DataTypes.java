package DataTypes;

/*
 * DataTypes.java
 */

/**
 * CS5004 Lab 2: Problem 2 - Data Types
 * This class print all 8 primitive data types in Java
 * 
 * @author Randy Lirano
 * @since 2020-05-14
 */
public class DataTypes {
    /**
     * This function print all 8 primitive data types in Java
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        boolean a = true;
        char b = 'j';
        byte c = 127;
        short d = 327;
        int e = 214;
        long f = 922L;
        float g = 1.5f;
        double h = 1.5;

        System.out.println("boolean: " + "a: " + a);
        System.out.println("char: " + "b: " + b);
        System.out.println("byte: " + "c: " + c);
        System.out.println("short: " + "d: " + d);
        System.out.println("int: " + "e: " + e);
        System.out.println("long: " + "f: " + f);
        System.out.println("float: " + "g: " + g);
        System.out.println("double: " + "h: " + h);
    }
}