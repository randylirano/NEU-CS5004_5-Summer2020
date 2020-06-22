
/**
 * Test.java
 */

/**
 * CS5004 Assignment 6: Problem 1 - Test.
 * This class test the programmer defined classes.
 * 
 * @author Randy Lirano
 * @since 2020-06-21
 */

public class Test {
    /**
     * This method perform the necessary operation to test programmer defined classes.
     * @param args(unused)
     */
    public static void main(String[] args) {
        // Test Person class
        // Person p1 = new Person();
        // System.out.println("Person 1");
        // System.out.println(p1);
        // Person p2 = new Person("Randy", "Lirano");
        // System.out.println("Person 2");
        // System.out.println(p2);
        // Person p3 = new Person("Randy", "Lirano");
        // System.out.println("Person 3");
        // System.out.println(p3);
        // System.out.println(p2.equals(p3));
        // Person p4 = new Person(p2);
        // System.out.println("Person 4");
        // System.out.println(p4);

        // Test Student class
        // Student s1 = new Student();
        // System.out.println("Student 1");
        // System.out.println(s1);
        // Student s2 = new Student("Randy", "Lirano", "10005", "CS5004", "Hamid");
        // System.out.println("Student 2");
        // System.out.println(s2);
        // Student s3 = new Student(s2);
        // System.out.println("Student 3");
        // System.out.println(s3);
        // System.out.println("Student 2 equals to Student 3: " + s2.equals(s3));
        // System.out.println("Student 2 equals to Student 1: " + s2.equals(s1));

        // Test Teacher class
        Teacher t1 = new Teacher();
        System.out.println("Teacher 1");
        System.out.println(t1);
        Teacher t2 = new Teacher("Randy", "Lirano", "CS5004", 100000);
        System.out.println("Teacher 2");
        System.out.println(t2);
        Teacher t3 = new Teacher(t2);
        System.out.println("Teacher 3");
        System.out.println(t3);
        System.out.println("Teacher 2 equals to Teacher 3: " + t2.equals(t3));
        System.out.println("Teacher 2 equals to Teacher 1: " + t2.equals(t1));
    }
}

// programmer defined Person object
class Person {
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

// programmer defined Student object which is a derivation from pre-defined Person object.
class Student extends Person {
    // Class instances
    private String studentId;
    private String course;
    private String teacherName;

    // 0 argument constructor
    public Student() {
        this("", "", "", "", "");
    }

    // 5 argument constructor
    public Student(String firstName, String lastName, String studentId, String course, String teacherName) {
        super(firstName, lastName);
        setStudentId(studentId);
        setCourse(course);
        setTeacherName(teacherName);
    }

    // Copy constructor
    public Student(Student other) {
        this(other.getFirstName(), other.getLastName(), other.getStudentId(), other.getCourse(), other.getTeacherName());
    }

    // Getter methods
    public String getStudentId() {
        return this.studentId;
    }

    public String getCourse() {
        return this.course;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    // Setter methods
    public void setStudentId(String studentId) {
        try {
            if (studentId.isEmpty()) {
                this.studentId = "[EMPTY]";
            } else {
                this.studentId = studentId;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    public void setCourse(String course) {
        try {
            if (course.isEmpty()) {
                this.course = "[EMPTY]";
            } else {
                this.course = course;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    public void setTeacherName(String teacherName) {
        try {
            if (teacherName.isEmpty()) {
                this.teacherName = "[EMPTY]";
            } else {
                this.teacherName = teacherName;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. Exiting the program");
            System.exit(-1);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "; Student ID: " + getStudentId() + "; Course: " + getCourse() + "; Teacher: " + getTeacherName();
    }

    @Override
    // Check to see if there is any missing information
    // if any instances is equal to [EMPTY], the program will return true
    // and false otherwise
    public boolean missingInfo() {
        return super.missingInfo() || getStudentId().equals("[EMPTY]") || getCourse().equals("[EMPTY]") || getTeacherName().equals("[EMPTY]");
    }

    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Student)) {
            return false;
        } else {
            Student other = (Student) otherObj;
            // If there is an instance that is "[EMPTY]", the program return false
            if (this.missingInfo() || other.missingInfo()) {
                return false;
            }
            boolean equalStudentID = this.getStudentId().equals(other.getStudentId());
            boolean equalCourse = this.getCourse().equalsIgnoreCase(other.getCourse());
            boolean equalTeacher = this.getTeacherName().equalsIgnoreCase(other.getTeacherName());
            return super.equals(otherObj) && equalStudentID && equalCourse && equalTeacher;
        }
    }
}

// programmer defined Teacher object which is a derivation from pre-defined Person object.
class Teacher extends Person {
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