package com.campusconnect.project;

public class Project
{
    private int id;
    private String title;
    private String description;
    private String domain; // e.g., "AI", "Web Dev", "IoT"
    private String createdOn;

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
    public String getDomain()
    {
        return domain;
    }
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    public String getCreatedOn()
    {
        return createdOn;
    }
    public void setCreatedOn(String createdOn)
    {
        this.createdOn = createdOn;
    }
}
