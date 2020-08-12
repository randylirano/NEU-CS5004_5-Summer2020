/**
 * TwoBirthdays.java
 */

/**
 * CS5004 Assignment 10 Problem 1: TwoBirthdays
 * This class approximates the probability that 2 or more people in the same room have the same birthday
 * for 2 to 50 people in a room.
 * 
 * @author Randy Lirano
 * @since 2020-08-02
 */

import java.util.*;

public class TwoBirthdays {
    // The number of trial for each value of n, where n is number of people between 2 and 50
    private static final int TRIAL = 5000;

    public static void main(String[] args) {
        // Set to store the randomly assigned birthdays
        HashSet<Integer> peopleBirthdays = new HashSet<Integer>();
        // Initialize randomizer
        Random rand = new Random();

        for (int i = 2; i <= 50; i++) {
            // Keep count on the occurence of two or more people have the same birthday
            int birthdayPair = 0;

            for (int j = 0; j < TRIAL; j++) {
                int birthday = rand.nextInt(365);
                peopleBirthdays.add(birthday);
                int birthdayAssign = 1;
                boolean pairFound = false;

                while (birthdayAssign < i && !pairFound) {
                    birthday = rand.nextInt(365);

                    if (peopleBirthdays.contains(birthday)) {
                        birthdayPair++;
                        pairFound = true;
                    } else {
                        peopleBirthdays.add(birthday);
                        birthdayAssign++;
                    }
                }
                peopleBirthdays.clear();
            }

            double probability = (double) birthdayPair / TRIAL;
            System.out.println("For " + i + " people, the probability of two birthdays is about " + probability);
        }
        
    }

}