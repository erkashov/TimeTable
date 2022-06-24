package com.example.timetable;

import java.util.Date;

public class ParaItem {
    private String nomer;
    private String startTime;
    private String endTime;
    private String naim;
    private String prepod;
    private String tip_zan;
    private String audit;
    private String zdanie;

    public ParaItem (String _nomer, String _start, String _end, String _naim, String _prepod, String _tip_zan, String _audit, String _zdanie){
        this.nomer = _nomer;
        this.startTime = _start;
        this.endTime = _end;
        this.naim = _naim;
        this.prepod = _prepod;
        this.audit = _audit;
        this.tip_zan = _tip_zan;
        this.zdanie = _zdanie;
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
    public String getTip_zan() {
        return tip_zan;
    }
    public String getAudit() {
        return audit;
    }
    public String getZdanie() {
        return zdanie;
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
    public void setTip_zan(String _ned) {
        this.tip_zan = _ned;
    }
    public void setAudit(String _ned) {
        this.audit = _ned;
    }
    public void setZdanie(String _ned) {
        this.zdanie = _ned;
    }
}
