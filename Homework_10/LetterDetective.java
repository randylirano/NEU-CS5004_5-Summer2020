/**
 * LetterDetective.java
 */

/**
 * CS5004 Assignment 10 Problem 2: LetterDetective
 * This class takes two text files (input and anonymous letter) and determines if the anonymous letter
 * could be written using characters from the input files.
 * 
 * @author Randy Lirano
 * @since 2020-08-02
 */

import java.util.*;
import java.io.*;

public class LetterDetective {
    // This method request a file name of a text file that will be used to build character dictionary
    // It parse the given text file and keep counts of all the character other than whitespace ' '.
    public static HashMap<Character, Integer> parseInputFile(Scanner console) {
        boolean validFile = false;
        Scanner input = null;
        String userFileName;

        while (!validFile) {
            System.out.print("Provide file name: ");
            userFileName = console.next();
            try {
                input = new Scanner(new File(userFileName));
                validFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("Provided file does not exist, try again");
            }
        }

        // Dictionary to keep all the character in a given file, and their count
        HashMap<Character, Integer> userFileDictionary = new HashMap<Character, Integer>();

        while (input.hasNext()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (!(ch == ' ')) {
                    if (userFileDictionary.containsKey(ch)) {
                        userFileDictionary.put(ch, userFileDictionary.get(ch) + 1);
                    } else {
                        userFileDictionary.put(ch, 1);
                    }
                }
            }
        }
        return userFileDictionary;
    }

    // This method compares two HashMap letterDictionary and sourceDictionary
    // If sourceDictionary contains all the keys in letterDictionary and the value is greater than or equal to the key-value in letterDictionary; then the method will return true and false otherwise.
    public static boolean compareDictionary(HashMap<Character, Integer> letterDictionary, HashMap<Character, Integer> sourceDictionary) {
        Set<Character> chKey = letterDictionary.keySet();
        for (Character ch : chKey) {
            if ((!sourceDictionary.containsKey(ch)) || letterDictionary.get(ch) > sourceDictionary.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Provide file name for anonymous letter:");
        HashMap<Character, Integer> letterDictionary = parseInputFile(console);
        System.out.println("Provide file name for source:");
        HashMap<Character, Integer> sourceDictionary = parseInputFile(console);        
        boolean enoughChar = compareDictionary(letterDictionary, sourceDictionary);
        System.out.println("Enough characters: " + enoughChar);
    }
}

/*
Homework 10 problem 3:
Explain clearly and briefly how the methods hashCode() and equals() are used in hash-table-based containers such as HashMap and HashSet.

>> In Java, hash-table-based containers use hash number returned by hashCode() to store objects. Since equals() method actually test to see if two objects are equal, it should also check to see if the both objects have the same hash number.
*/