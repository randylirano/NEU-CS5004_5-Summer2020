package Employee;

/**
 * EmployeeTest
 */

/**
 * CS5004 Assignment 4: Problem 1 - Employee Class.
 * This class test a programmer defined employee object.
 * 
 * @author Randy Lirano
 * @since 2020-06-07
 */

 public class EmployeeTest {
     /**
      * This function performs the required operation to test the employee object.
      * @param args (unused)
      */
    public static void main(String[] args) {
        // Test constructor
        Employee employee1 = new Employee("Randy", "Lirano", 50000);
        System.out.println(employee1);
        System.out.println();

        // Test instances getter methods using employee1 object
        System.out.println("Test Getter:");
        System.out.println("Employee 1 First Name: " + employee1.getFirstName());
        System.out.println("Employee 1 Last Name: " + employee1.getLastName());
        System.out.println("Employee 1 Salary: $ " + employee1.getSalary());
        System.out.println();

        // Test instances setter methods using employee1 object
        System.out.println("Test Setter:");
        employee1.setFirstName("");
        System.out.println("Employee 1 First Name: " + employee1.getFirstName());
        employee1.setFirstName("Mickey");
        System.out.println("Employee 1 First Name: " + employee1.getFirstName());
        employee1.setLastName("");
        System.out.println("Employee 1 Last Name: " + employee1.getLastName());
        employee1.setLastName("Mouse");
        System.out.println("Employee 1 Last Name: " + employee1.getLastName());
        employee1.setSalary(-1);
        System.out.println("Employee 1 Salary: $ " + employee1.getSalary());
        System.out.println(employee1);
        System.out.println();

        // Construct second Employee object to test equals method
        System.out.println("Test Equals:");
        Employee employee2 = new Employee("Mickey", "Mouse", 0.0);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println("Employee 1 is equal to Employee 2: " + employee1.equals(employee2));
        employee2.setSalary(100000);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println("Employee 1 is equal to Employee 2: " + employee1.equals(employee2));
    }
    
}

/**
 * This class is a programmer-defined Employee object
 */
class Employee {
    // Employee class instances
    private String firstName;
    private String lastName;
    private double salary;

    /**
     * Default constructor of an employee object with no argument
     */
    public Employee() {
        this("", "", 0.0);
    }

    /**
     * Create an employee object with arguments
     * 
     * @param firstName, employee's first name
     * @param lastName, employee's last name
     * @param salary, employee's salary
     */
    public Employee(String firstName, String lastName, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSalary(salary);
    }

    // Access Employee's object first name
    public String getFirstName() {
        return this.firstName;
    }

    // Access Employee's object last name
    public String getLastName() {
        return this.lastName;
    }

    // Access Employee's object salary
    public double getSalary() {
        return this.salary;
    }

    // Set new first name to Employee object
    public boolean setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            this.firstName = "[empty]";
            return false;
        } else {
            this.firstName = firstName;
            return true;
        }
    }

    // Set new last name to Employee object
    public boolean setLastName(String lastName) {
        if (lastName.isEmpty()) {
            this.lastName = "[empty]";
            return false;
        } else {
            this.lastName = lastName;
            return true;
        }
    }

    // Set new salary to Employee object
    public boolean setSalary(double salary) {
        if (salary < 0.0) {
            this.salary = 0.0;
            return false;
        } else {
            this.salary = salary;
            return true;
        }
    }

    // Check if two Employee objects contain the same information
    public boolean equals(Employee other) {
        boolean compareFirstName = this.firstName.equalsIgnoreCase(other.firstName);
        boolean compareLastName = this.lastName.equalsIgnoreCase(other.lastName);
        boolean compareSalary = this.salary == other.salary;
        return compareFirstName && compareLastName && compareSalary;
    }

    // Return string representation of Employee object
    public String toString() {
        return getFirstName() + " " + getLastName() + " - $ " + getSalary();
    }
}