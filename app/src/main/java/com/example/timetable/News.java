package com.example.timetable;

public class News {
    private String title;
    private String description;

    public News( String _title, String _description){
        this.description = _description;
        this.title = _title;
    }

    public void setTitle(String _title){title = _title;}
    public void setDescription(String _description){description = _description;}

    public String getTitle(){return title;}
    public String getDescription(){return description;}
}
