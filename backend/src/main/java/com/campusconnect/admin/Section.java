package com.campusconnect.admin;

public class Section
{
    private int id;
    private String name;

    public Section(String name)
    {
        this.name = name;
    }

    public Section(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}