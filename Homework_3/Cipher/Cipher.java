package Cipher;

/*
 * Cipher.java 
 */

import java.util.Scanner;

/**
 * CS5004 Assignment 3: Problem 1 - Cipher.
 * This class serves as a message encryption and decryption program.
 * 
 * @author Randy Lirano
 * @since 2020-05-31
 */

public class Cipher {
    // Declare the number of available alphabet
    private static final int NUMBER_OF_LETTERS = 26;

    /**
     * This function perform encryption to a given message by increasing the character
     * value based on the given key value.
     * @param originalMessage 
     * @param key
     * @return
     */
    private static String encryption(String originalMessage, int key) {
        String encryptedMessage = "";
        int length = originalMessage.length();
        char proccessedChar;
        char encryptedChar;
        
        for(int i = 0; i < length; i++) {
            proccessedChar = originalMessage.charAt(i);
            encryptedChar = shiftCharValue(proccessedChar, key);
            encryptedMessage += encryptedChar;
        }
        return encryptedMessage;
    }

    /**
     * This function perform decryption to a given message by reducing the character
     * value based on the given key value.
     * 
     * @param encryptedMessage
     * @param key
     * @return
     */
    private static String decryption(String encryptedMessage, int key) {
        String decryptedMessage = "";
        int length = encryptedMessage.length();
        char proccessedChar;
        char decryptedChar;

        for(int i = 0; i < length; i++) {
            proccessedChar = encryptedMessage.charAt(i);
            decryptedChar = shiftCharValue(proccessedChar, -key);
            decryptedMessage += decryptedChar;
        }
        return decryptedMessage;
    }

    /**
     * The function shift a character value based on the given key.
     * 
     * @param inputChar
     * @param key
     * @return
     */
    private static char shiftCharValue(char inputChar, int key) {
        char shiftedChar;
        int charValue = inputChar;
        int shiftedValue;

        // Do shifting for uppercase letter
        if(charValue >= 'A' && charValue <= 'Z') {
            // Do an offset for character value, so the character value between 0 - 25 inclusive
            charValue -= 'A';
            // Perform the shifting of the character value
            // Modulo used to loop back to 'A' when end of character reach
            // The offset value needs to be add back to retrieve the actual ascii value of the character
            shiftedValue = ((charValue + key) % NUMBER_OF_LETTERS);
            // Handle negative modulo result, to have the equivalent positive value
            if(shiftedValue < 0) {
                shiftedValue += NUMBER_OF_LETTERS + 'A';
            } else {
                shiftedValue += 'A';
            }
            shiftedChar = (char) shiftedValue;
        }
        // Do shifting for lowercase letter
        else if(charValue >= 'a' && charValue <= 'z') {
            // Do an offset for character value, so the character value between 0 - 25 inclusive
            charValue -= 'a';
            // Perform the shifting of the character value
            // Modulo used to loop back to 'A' when end of character reach
            // The offset value needs to be add back to retrieve the actual ascii value of the character
            shiftedValue = ((charValue + key) % NUMBER_OF_LETTERS);
            // Handle negative modulo result, to have the equivalent positive value
            if(shiftedValue < 0) {
                shiftedValue += NUMBER_OF_LETTERS + 'a';
            } else {
                shiftedValue += 'a';
            }
            shiftedChar = (char) shiftedValue;
        }
        // Do nothing for non-alphabethical character
        else {
            shiftedChar = (char) charValue;
        }
        return shiftedChar;
    }

    /**
     * This function prompt user on several action that could be done.
     * 
     * @param console
     * @param userInput
     */
    public static void userOptions(Scanner console, String userInput) {
        // Prompt instruction
        System.out.printf("-- Enter E for Encryption, D for Decryption, X to exit: ");
        String userChoice = console.next();

        // If user chose 'E', then the program call the encryption function
        if(userChoice.equalsIgnoreCase("E")) {
            System.out.printf("-- Enter key: ");
            int key = console.nextInt();
            System.out.printf("-- The encrypted text is below\n");
            String encryptedInput = encryption(userInput, key);
            System.out.println(encryptedInput);
        } 
        // If user chose 'D', then the program call the decryption function
        else if(userChoice.equalsIgnoreCase("D")) {
            System.out.printf("-- Enter key: ");
            int key = console.nextInt();
            System.out.printf("-- The decrypted text is below\n");
            String decryptedInput = decryption(userInput, key);
            System.out.println(decryptedInput);
        } 
        // If user chose 'X', then the program do nothing and exit
        else if(userChoice.equalsIgnoreCase("X")) {

        } 
        // For character other than the available option will be recognize as invalid input.
        // The program will loop back and keep asking for input until valid instruction given.
        else {
            System.out.printf("-- Input not recognized. Try again.\n");
            userOptions(console, userInput);
        }
    }
    
    /**
     * This function test the performance of the encryption and decryption function
     * 
     * @param args(unused)
     */
    public static void main(String[] args) {
        
        // Initialize Scanner class named console to receive keyboard input
        Scanner console = new Scanner(System.in);
        System.out.printf("-- Enter the text below\n");
        String userInput = console.nextLine();
        userOptions(console, userInput);
        
        console.close();

    }
}