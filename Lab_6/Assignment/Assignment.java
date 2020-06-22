package Assignment;

/**
 * Assignment.java
 */

/**
 * CS5005 Lab 6: Problem 7 - Assignment.
 * This class build programmer defined assignment class.
 *
 * @author Randy Lirano
 * @since 2020-06-18
 */

public class Assignment {
    private Date dateDue;
    private String filename;

    public Assignment () {
        this.dateDue = new Date(1, 1, 1900);
        this.filename = "";
    }

    public Date getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(int month, int day, int year) {
        Date d = this.dateDue;
        d.setMonth(month);
        d.setDay(day);
        d.setYear(year);
    }

    public void setFilename(String f) {
        this.filename = f;
    }

    public String getFilename() {
        return this.filename;
    }

    public String toString() {
        return "Assignment due " + this.getDateDue() + " in file " + this.getFilename();
    }

    // Copy constructor, flawed version with privacy leak risk
//     public Assignment(Assignment a) {
//         this.dateDue = a.getDateDue();
//         this.filename = a.getFilename();
//     }

     // Copy constructor, better version without privacy leak
     public Assignment(Assignment a) {
         this.dateDue = new Date(a.getDateDue());
         this.filename = a.getFilename();
     }

     public static void main(String[] args) {
        Assignment a1 = new Assignment();
        a1.setDateDue(6, 12, 2020);
        a1.setFilename("assignment01.txt");
        System.out.println("a1 = " + a1);
        Assignment a2 = new Assignment(a1);
        a2.setDateDue(6, 15, 2020);
        a2.setFilename("assignment02.txt");
        System.out.println("a2 = " + a2);
        System.out.println("a1 = " + a1);

        // With copy constructor that protects privacy leak a1.Datedue stays (6, 12, 2020)
        // even when we create new object a2 by copying from a1 and assign new due date.
        // However, if we use constructor that does not protect privacy leak, we will change
        // a1 due date when we assign new due date value to a2

     }
}
