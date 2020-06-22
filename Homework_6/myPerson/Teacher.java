package myPerson;

/**
 * Teacher.java
 */

/**
 * CS5004 Assignment 6: Problem 1 - Teacher Class.
 * This class is a programmer defined Teacher object which is a
 * derivation from pre-defined Person object.
 * 
 * @author Randy Lirano
 * @since 2020-06-21
 */

public class Teacher extends Person {
    // Class instances
    private String subject;
    private double salary;

    // 0 argument constructor
    public Teacher() {
        this("", "", "", 0.0);
    }

    // 4 argument constructor
    public Teacher(String firstName, String lastName, String subject, double salary) {
        super(firstName, lastName);
        setSubject(subject);
        setSalary(salary);
    }

    // copy constructor
    public Teacher(Teacher other) {
        this(other.getFirstName(), other.getLastName(), other.getSubject(), other.getSalary());
    }

    // Getter methods
    public String getSubject() {
        return this.subject;
    }

    public double getSalary() {
        return this.salary;
    }

    // Setter methods
    public void setSubject(String subject) {
        try {
            if (subject.isEmpty()) {
                this.subject = "[EMPTY]";
            } else {
                this.subject = subject;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    // Set salary, if the provided argument is negative, the program will set it to 0
    public void setSalary(double salary) {
        if (salary < 0) {
            this.salary = 0.0;
        } else {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "; Subject: " + getSubject() + "; Salary: " + getSalary();
    }

    @Override
    // Check to see if there is any missing information
    // if any instances is equal to [EMPTY], the program will return true
    // and false otherwise
    public boolean missingInfo() {
        return super.missingInfo() || getSubject().equalsIgnoreCase("[EMPTY]");
    }

    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Teacher)) {
            return false;
        } else {
            Teacher other = (Teacher) otherObj;
            // If there is an instance that is "[EMPTY]", the program return false
            if (this.missingInfo() || other.missingInfo()) {
                return false;
            }
            boolean equalSubject = this.getSubject().equals(other.getSubject());
            boolean equalSalary = this.getSalary() == other.getSalary();
            return super.equals(otherObj) && equalSubject && equalSalary;
        }
    }
}