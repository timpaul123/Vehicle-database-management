/*
 * A simple Date class
 */

package databasemanagement;

/**
 *
 * @author Tim Carrington
 */
public class Date {
    
    private int day;
    private int month;
    private int year;
    
    private static final int daysPerMonth[] 
                                    = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    public Date(int day, int month, int year){
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month value. Month must be between 1-12");
            }
        if(day < 1 || ((day > daysPerMonth[month]) && !(month == 2 && day == 29))){
                throw new IllegalArgumentException ("Invalid day for the month");
            }
        if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            throw new IllegalArgumentException ("Invalid day for month and year");
        }
    
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    @Override
    public String toString(){
        return String.format("%d/%d/%d", day, month, year);
    }
}
