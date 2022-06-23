package com.example.timetable;

import java.util.Calendar;
import java.util.Date;

public class DateItem {
    private int day;
    private String dayNedeli;
    private int month;
    private int year;

    public DateItem (int _day, String _dayN , int _month, int _year){
        day = _day;
        dayNedeli = _dayN;
        this.month = _month;
        this.year = _year;
    }

    public String getDay(){
        return Integer.toString(day);
    }
    public int getDayInt(){
        return day;
    }

    public String getDayNedeli() {
        return dayNedeli;
    }

    public void setDayNedeli(String _ned) {
        this.dayNedeli = _ned;
    }

    public void setDay(int _day) {
        this.day = _day;
    }

    public int getMonth(){return month;}
    public int getYear(){return year;}

    public void setMonth(int _month){this.month = _month;}
    public void setYear(int _year){this.year = _year;}
}
