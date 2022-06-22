package com.example.timetable;

import java.util.Date;

public class DateItem {
    private int day;
    private String dayNedeli;
    private Date date;

    public DateItem (int _day, String _dayN , Date _date){
        day = _day;
        dayNedeli = _dayN;
        date = _date;
    }

    public String getDay(){
        return Integer.toString(day);
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

    public void setDate(Date _date) {this.date = _date;}
    public Date getDate(){return date;}
}
