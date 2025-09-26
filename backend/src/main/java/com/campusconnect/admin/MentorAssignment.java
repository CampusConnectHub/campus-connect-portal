package com.campusconnect.admin;

public class MentorAssignment
{
    private int studentId;
    private int facultyId;

    public MentorAssignment(int studentId, int facultyId)
    {
        this.studentId = studentId;
        this.facultyId = facultyId;
    }

    public int getStudentId()
    {
        return studentId;
    }
    public int getFacultyId()
    {
        return facultyId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }
    public void setFacultyId(int facultyId)
    {
        this.facultyId = facultyId;
    }
}