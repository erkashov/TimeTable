package com.example.timetable;

import java.util.Date;

public class ParaItem {
    private String nomer;
    private String startTime;
    private String endTime;
    private String naim;
    private String prepod;
    private Date date;

    public ParaItem (String _nomer, String _start, String _end, String _naim, String _prepod, Date _date){
        this.nomer = _nomer;
        this.startTime = _start;
        this.endTime = _end;
        this.naim = _naim;
        this.prepod = _prepod;
        this.date = _date;
    }

    public String getNomer(){ return nomer; }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getNaim() {
        return naim;
    }
    public String getPrepod() {
        return prepod;
    }
    public Date getDate(){return date;}

    public void setNomer(String _ned) {
        this.nomer = _ned;
    }
    public void setStartTime(String _ned) {
        this.startTime = _ned;
    }
    public void setEndTime(String _ned) {
        this.endTime = _ned;
    }
    public void setNaim(String _ned) {
        this.naim = _ned;
    }
    public void setPrepod(String _ned) {
        this.prepod = _ned;
    }
    public void setDate(Date _date) {this.date = _date;}

}
