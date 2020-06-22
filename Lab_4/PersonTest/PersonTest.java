package PersonTest;

/**
 * PersonTest.java
 */

import java.util.Calendar;

/**
 * CS5005 Lab 4: Problem 0 - Person Test.
 * This class demonstrate working with a person object.
 *
 * @author Randy Lirano
 * @since 2020-05-28
 */

class Person {
    // Class instances
    private String firstName;
    private String lastName;
    private double height;
    private int yearOfBirth;

    // Calendar and current year for age calculation
    Calendar cal = Calendar.getInstance();
    int currentYear = cal.get(Calendar.YEAR);

    // default constructor
    public Person() {
        this("", "", 0.0, 0);
    }

    public Person(String firstName, String lastName, double height, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setHeight(height);
        this.setAge(yearOfBirth);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        if(yearOfBirth > 0) {
            return currentYear - yearOfBirth;
        } else {
            return 0;
        }
    }

    // setAge(int)
    public boolean setAge(int yearOfBirth) {
        // Current year should be greater than or equal to the year of birth
        // to prevent negative age during calculation
        if (currentYear >= yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return true;
        }
        // In case of year of birth is greater than the current year
        else {
            System.out.println("ERROR: Unreasonable Year of Birth");
            return false;
        }
    }

    // setAge(double)
    public boolean setAge(double yearOfBirth) {
        return setAge((int) yearOfBirth);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            System.out.println("Error, invalid height");
        }
        this.height = height;
    }

    public boolean equals(Person other) {
        return this.firstName == other.firstName && this.lastName == other.lastName && this.yearOfBirth == other.yearOfBirth && this.height == other.height;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + ", Age " + getAge() + ", height " + getHeight();
    }
}

public class PersonTest {
    public static void main(String[] args) {
        // Test constructor and equal method
        Person p = new Person("Randy", "Lirano", 69, 1995);
        Person q = new Person("Randy", "Lirano", 65, 1995);
        System.out.println("Person p: " + p);
        System.out.println("Person q: " + q);
        System.out.println("Person p equals to person q: " + p.equals(q));
        System.out.println("");

        // Test setAge method
        System.out.println("Person p age: " + p.getAge());
        boolean personPSetAge = p.setAge(2100);
        System.out.println("Person p age: " + p.getAge());
        personPSetAge = p.setAge(2000);
        System.out.println("Person p age: " + p.getAge());
        
    }
}