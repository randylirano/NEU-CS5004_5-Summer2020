package MyTriple;

/**
 * TripleTest.java
 */

/**
 * CS5004 Assignment 8: TripleTest Class
 * This class tested the programmer defined generic Triple class.
 * 
 * @author Randy Lirano
 * @since 2020-07-19
 */

public class TripleTest {
    /**
     * This method perform the necessary operation to test programmer-defined Triple class.
     * @param args (unused)
     */
    public static void main(String[] args) {
        // Test 1: Empty argument constructor
        Triple<String, Integer, Double> personA = new Triple<String, Integer, Double>();
        System.out.println("Person A:\n" + personA);
        // Test 2: Same type arguments constructor
        Triple<String, String, String> personB = new Triple<String, String, String>("Randy", "[EMPTY]", "Lirano");
        System.out.println("Person B:");
        System.out.println("First Name: " + personB.getFirst());
        System.out.println("Middle Name: " + personB.getSecond());
        System.out.println("Last Name: " + personB.getThird());
        // Test 3: All different type arguments constructor
        Triple<String, Integer, Double> personC = new Triple<String,Integer,Double>("Randy Lirano", 25, 163.5);
        System.out.println("Person C:");
        System.out.println("Name: " + personC.getFirst());
        System.out.println("Age: " + personC.getSecond());
        System.out.println("Height [cm]: " + personC.getThird());

        // Test equals
        Triple<String, Integer, Double> personD = new Triple<String,Integer,Double>("Randy Lirano", 25, 163.5);
        Triple<String, Integer, Double> personE = new Triple<String,Integer,Double>("Randy Lirano", 20, 150.0);
        System.out.println("Person C is equals to person D:" + personC.equals(personD));
        System.out.println("Person C is equals to person E:" + personC.equals(personE));
    }
}