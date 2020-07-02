package myPerson;

/**
 * Person.java
 */

/**
 * CS5004 Assignment 6: Problem 1 - Person Class.
 * This class is a programmer defined Person object.
 *
 * @author Randy Lirano
 * @since 2020-06-21
 */

public class Person {
    // Class instances
    private String firstName;
    private String lastName;

    // 0 argument constructor
    public Person() {
        this("", "");
    }

    // 2 arguments constructor
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Copy constructor
    // Passing null argument will cause an error message and the program will stop running
    public Person(Person other) {
        this(other.getFirstName(), other.getLastName());
    }

    // Getter methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    // Setter methods
    // Empty string will be translated as "[EMPTY]" to increase readability
    // Null argument will cause and exception with error message, and stop the program
    public void setFirstName(String firstName) {
        try {
            if (firstName.isEmpty()) {
                this.firstName = "[EMPTY]";
            } else {
                this.firstName = firstName;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    public void setLastName(String lastName) {
        try {
            if (lastName.isEmpty()) {
                this.lastName = "[EMPTY]";
            } else {
                this.lastName = lastName;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    public String toString() {
        return "First Name: " + getFirstName() + "; Last Name: " + getLastName();
    }

    // Check to see if there is any missing information
    // if any instances is equal to [EMPTY], the program will return true
    // and false otherwise
    public boolean missingInfo() {
        return getFirstName().equals("[EMPTY]") || getLastName().equals("[EMPTY]");
    }

    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Person)) {
            return false;
        } else {
            Person other = (Person) otherObj;
            // If there is an instance that is "[EMPTY]", the program return false
            if (this.missingInfo() || other.missingInfo()) {
                return false;
            }
            boolean equalFirstName = this.getFirstName().equalsIgnoreCase(other.getFirstName());
            boolean equalLastName = this.getLastName().equalsIgnoreCase(other.getLastName());
            return  equalFirstName && equalLastName;
        }
    }
}
