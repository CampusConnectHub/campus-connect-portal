package com.campusconnect.attendance;

public class Attendance
{
    private int id;
    private int studentId;
    private String date;
    private boolean present;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getStudentId()
    {
        return studentId;
    }
    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    public boolean isPresent()
    {
        return present;
    }
    public void setPresent(boolean present)
    {
        this.present = present;
    }
}
