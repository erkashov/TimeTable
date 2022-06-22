package com.example.timetable;

public class ParaItem {
    private String nomer;
    private String startTime;
    private String endTime;
    private String naim;
    private String prepod;

    public ParaItem (String _nomer, String _start, String _end, String _naim, String _prepod){
        this.nomer = _nomer;
        this.startTime = _start;
        this.endTime = _end;
        this.naim = _naim;
        this.prepod = _prepod;
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

}
