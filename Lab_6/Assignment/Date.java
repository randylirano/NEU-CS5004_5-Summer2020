package Assignment;

/**
 * Date.java
 */

/**
 * CS5005 Lab 6: Problem 7 - Date
 * This class is a support class for the assignment class.
 *
 * @author Randy Lirano
 * @since 2020-06-18
 */

public class Date {

    public Date(int month, int day, int year) {
        if (dateCheck(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        } else {
            System.out.println("Error: invalid date: " + month + "/" + day + "/" + year);
            // System.exit(1);
        }
    }

    // copy constructor
    public Date(Date other) {
        this(other.month, other.day, other.year);
    }

    private int year;
    private int month;
    private int day;

    public final static int MIN_YEAR = 1900;

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

    public boolean setMonth(int month) {
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

    public static boolean leapYear(int year) {
        // If a year is multiple of 400, then it is a leap year
        if (year % 400 == 0) {
            return true;
        }

        // Else If a year is multiple of 100, then it is not a leap year
        if (year % 100 == 0) {
            return false;
        }

        // Else If a year is multiple of 4, then it is a leap year
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private boolean dateCheck(int month, int day, int year) {
        int monthLength;
        if (year < MIN_YEAR) {
            return false;
        }
        if (month <= 0 || month > 12) {
            return false;
        }

        // Figure out correct monthLength for this month
        switch (month) {
            case 1:  // Jan
                monthLength = 31;
                break;
            case 2:  // Feb
                if (leapYear(year)) {
                    monthLength = 29;
                } else {
                    monthLength = 28;
                }
                break;
            case 3:  // Mar
                monthLength = 31;
                break;
            case 4:  // Apr
                monthLength = 30;
                break;
            case 5:  // May
                monthLength = 31;
                break;
            case 6:  // Jun
                monthLength = 30;
                break;
            case 7:  // Jul
                monthLength = 31;
                break;
            case 8:  // Aug
                monthLength = 31;
                break;
            case 9:  // Sep
                monthLength = 30;
                break;
            case 10:  // Oct
                monthLength = 31;
                break;
            case 11:  // Nov
                monthLength = 30;
                break;
            case 12:  // Dec
                monthLength = 31;
                break;
            default:
                monthLength = 31;
                break;
        }

        if (day <= 0 || day > monthLength) {
            return false;
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
