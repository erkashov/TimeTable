package com.example.timetable;

public class News {
    private String title;
    private String description;
    private String href;

    public News( String _title, String _description, String _href){
        this.description = _description;
        this.title = _title;
        this.href = _href;
    }

    public void setTitle(String _title){title = _title;}
    public void setDescription(String _description){description = _description;}
    public void setHref(String _description){href = _description;}

    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public String getHref(){return href;}
}
