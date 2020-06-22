package myPerson;

/**
 * Student.java
 */

/**
 * CS5004 Assignment 6: Problem 1 - Student Class.
 * This class is a programmer defined Student object which is a
 * derivation from pre-defined Person object.
 * 
 * @author Randy Lirano
 * @since 2020-06-21
 */

public class Student extends Person {
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