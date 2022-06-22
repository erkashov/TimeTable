package com.example.timetable;

public class DateItem {
    private int day;
    private String dayNedeli;

    public DateItem (int _day, String _dayN){
        day = _day;
        dayNedeli = _dayN;
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
}
