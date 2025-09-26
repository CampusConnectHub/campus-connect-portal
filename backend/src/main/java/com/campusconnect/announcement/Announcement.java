package com.campusconnect.announcement;

import java.time.LocalDateTime;

public class Announcement
{
    private int id;
    private int facultyId;
    private String title;
    private String content;
    private LocalDateTime timestamp;

    // Constructor for new announcements (no ID yet)
    public Announcement(int facultyId, String title, String content)
    {
        this.facultyId = facultyId;
        this.title = title;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    // Constructor for announcements fetched from DB
    public Announcement(int id, int facultyId, String title, String content, LocalDateTime timestamp)
    {
        this.id = id;
        this.facultyId = facultyId;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId()
    {
        return id;
    }

    public int getFacultyId()
    {
        return facultyId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    // Setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setFacultyId(int facultyId)
    {
        this.facultyId = facultyId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }
}