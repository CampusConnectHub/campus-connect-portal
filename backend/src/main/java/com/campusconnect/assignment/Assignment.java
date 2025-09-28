package com.campusconnect.assignment;

public class Assignment
{
    private int id;
    private String title;
    private String description;
    private String deadline;
    private int courseId;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDeadline()
    {
        return deadline;
    }
    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }
    public int getCourseId()
    {
        return courseId;
    }
    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }
}
