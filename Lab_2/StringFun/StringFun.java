package StringFun;

/*
 * StringFun.java
 */

/**
 * CS5004 Lab 2: Problem 3 - String Operation
 * This class demonstrate several String methods
 * 
 * @author Randy Lirano
 * @since 2020-05-14
 */
public class StringFun {
    /**
     * This function print several output from operation using several String methods
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        // String concatenation
        String hello = "Hello";
        String world = "World";
        String helloWorld = hello + world;
        System.out.println("The concatenation of variable hello and world: " + helloWorld);

        // String length
        int helloWorldLength = helloWorld.length();
        System.out.println("The length of String helloWorld: " + helloWorldLength);

        // Count the number of space and periods
        String helloWorld2 = "Hello World.";
        int count = 0;
        for (int i = 0; i < helloWorld2.length(); i++){
            char curr = helloWorld2.charAt(i);
            if (curr == ' ' || curr == '.'){
                count++;
            }
        }
        System.out.println("There are " + count + " blank space and periods in helloWorld2");

        // Substring
        String substring1 = helloWorld.substring(2, 5);
        System.out.println("Substring of helloWorld variable between index 2 and 5 is: " + substring1);

        // Equals vs EqualsIgnoreCase
        String helloWorld3 = "helloworld";
        boolean comparison1 = helloWorld.equals(helloWorld3);
        boolean comparison2 = helloWorld.equalsIgnoreCase(helloWorld3);
        System.out.println("comparison 1: " + comparison1);
        System.out.println("comparison 2: " + comparison2);

        // toLowerCase, toUpperCase, and trim
        String helloWorld4 = " Hello World ";
        String lowerHelloWorld = helloWorld4.toLowerCase();
        String upperHelloWorld = helloWorld4.toUpperCase();
        String trimHelloWorld = helloWorld4.trim();
        System.out.println("Lower: " + lowerHelloWorld);
        System.out.println("Upper: " + upperHelloWorld);
        System.out.println("Trim : " + trimHelloWorld);

        // indexOf and lastIndexOf
        int indexOfE = helloWorld.indexOf("e");
        int indexOfL = helloWorld.indexOf("l");
        int indexOfA = helloWorld.indexOf("a");
        int lastIndexOfE = helloWorld.lastIndexOf("e");
        int lastIndexOfL = helloWorld.lastIndexOf("l");
        int lastIndexOfA = helloWorld.lastIndexOf("a");
        System.out.println("Index of e: " + indexOfE);
        System.out.println("Index of l: " + indexOfL);
        System.out.println("Index of a: " + indexOfA);
        System.out.println("Last index of e: " + lastIndexOfE);
        System.out.println("Last index of l: " + lastIndexOfL);
        System.out.println("Last index of a: " + lastIndexOfA);

        // compareTo and compareToIgnoreCase
        String entry = "adventure";
        int comparison3 = entry.compareTo("zoo");
        int comparison4 = entry.compareTo("adventure");
        int comparison5 = entry.compareTo("Adventure");
        int comparison6 = entry.compareToIgnoreCase("Adventure");
        int comparison7 = entry.compareTo("above");
        System.out.println("Comparison 3: " + comparison3);
        System.out.println("Comparison 4: " + comparison4);
        System.out.println("Comparison 5: " + comparison5);
        System.out.println("Comparison 6: " + comparison6);
        System.out.println("Comparison 7: " + comparison7);

        // Immutable String
        /*
        String is immutable means the value of the assigned string cannot be changed
        String a = "hello";
        Means the program have a variable typed String called 'a' with a value "hello".
        The program cannot change the value "hello", but it can reassign a new String
        value to variable 'a'.
        a = "world";
        This way, a new value "world" have been re assigned to 'a', but in the memory the value
        "hello" is still unchanged.
        */

        System.out.println("String with \"inside\"");

        double value = 12.123;
        System.out.printf("Start%8.2fEnd", value);
        System.out.println();
        System.out.printf("Start%-8.2fEnd", value);
    }
    
}