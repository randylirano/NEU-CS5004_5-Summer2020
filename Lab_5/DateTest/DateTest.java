/**
 * DateTest.java
 */

/**
 * CS5005 Lab 5: Problem 0, 1, and 2 - Date and Person Class.
 * This class demonstrate exercise working with Date and Person class.
 *
 * @author Randy Lirano
 * @since 2020-06-04
 */

public class DateTest {
    public static void main(String[] args) {
        // Problem 1 - Modifying dateCheck
        // dateCheck updated to take into account leap year, and the number of days
        // based on the month
        System.out.println("minYear is " + Date.MIN_YEAR);

        Date d = new Date(2, 29, 2020);

        System.out.println("day of d is " + d.getDay());
        System.out.println("minYear (d) is " + d.MIN_YEAR);
        System.out.println();

        // Problem 2 - Returning a copy of a reference
        /*
        String could be returned without making a copy because String is immutable, so if client have access
        to its original address, client still cannot modify it.
        Where in other object, when the program return it, it returns a reference to the original.
        That being said, if client modify it, they will modify the original object as well.
        This could result in a bug when the instances behavior of an object has been overwritten.

        Picture submitted separately.
         */

        // Sample get born where the accessor is not returning a copy
        Date born = new Date(6, 6, 2020);
        Date died = null;
        Person p = new Person("Randy", born, died);
        System.out.println("Person born: " + p.getBorn());
        Date bornCopy = p.copyGetBorn();
        bornCopy.setYear(1995);
        System.out.println("Copy born: " + bornCopy.getYear());
        System.out.println("Person born: " + p.getBorn());

    }
}

class Date {
    public Date(int month, int day, int year) {
        if (dateCheck(month, day, year) == true) {
            this.month = month;
            this.day = day;
            this.year = year;
        } else {
            System.out.println("Error: invalid date.");
            System.exit(1);
        }
    }

    // copy constructor
    public Date(Date other) {
        this(other.month, other.day, other.year);
    }

    private int year;
    private int month;
    private int day;
    
    public static final int MIN_YEAR = 1900;

    public int getYear() {
        return this.year;
    }

    public boolean setYear(int year) {
        if (dateCheck(month, day, year) == true) {
            this.year = year;
            return true;
        }
        return false;
    }

    public int getMonth() {
        return this.month;
    }

    public boolean setMoth(int month) {
        if (dateCheck(month, day, year) == true) {
            this.month = month;
            return true;
        }
        return false;
    }

    public int getDay() {
        return this.day;
    }

    public boolean setDay(int day) {
        if (dateCheck(month, day, year) == true) {
            this.day = day;
            return true;
        }
        return false;
    }

    private boolean dateCheck(int month, int day, int year) {
        if (year < MIN_YEAR) {
            return false;
        }

        if (month <= 0 || month > 12) {
            return false;
        }

        // Check for Leap Year
        if ((year % 100 == 0 && year % 400 != 0) || (year % 100 != 0 && year % 4 != 0)) {
            if (month == 2 && (day <= 0 || day > 28)) {
                return false;
            }
        }

        // Odd number months below 8 other than 2 has 31 days
        // Even number months greater than equal to 8 has 31 days
        if ((month < 8 && month != 2 && month % 2 != 0) || (month >= 8 && month % 2 == 0)) {
            if (day <= 0 || day > 31) {
                return false;
            }
        } else {
            if (day <= 0 || day > 30) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    public boolean equals(Date other) {
        return (this.month == other.month) && (this.day == other.day) && (this.year == other.year);
    }

    public static String monthString(int m) {
        String str;
        switch (m) {
            case 1: 
            str = "Jan";
            break;
            case 2:
            str = "Feb";
            break;
            case 3:
            str = "Mar";
            break;
            case 4:
            str = "Apr";
            break;
            case 5:
            str = "May";
            break;
            case 6:
            str = "Jun";
            break;
            case 7:
            str = "Jul";
            break;
            case 8:
            str = "Aug";
            break;
            case 9:
            str = "Sep";
            break;
            case 10:
            str = "Oct";
            break;
            case 11:
            str = "Nov";
            break;
            case 12:
            str = "Dec";
            break;
            default:
            str = "ERR";
            break;
        }
        return str;
    }
}

// Programmer defined person class
class Person {
    // Class instances
    private String name;
    private Date born;
    private Date died;

    public Person(String name, Date born, Date died) {
        this.name = name;
        this.born = new Date(born);
        if (died == null) {
            this.died = null;
        } else {
            this.died = new Date(died);
        }
    }

    public Person(Person other) {
        this(other.name, other.born, other.died);
    }

    public String getName() {
        return this.name;
    } 

    public Date getBorn() {
        return new Date(born);
    }

    // born accessor not returning a copy
    public Date copyGetBorn() {
        return this.born;
    }

    public Date getDied() {
        if (died == null) {
            return null;
        }
        return new Date(died);
    }
}