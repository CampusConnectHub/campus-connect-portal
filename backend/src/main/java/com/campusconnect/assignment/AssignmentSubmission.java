package com.campusconnect.assignment;

import java.sql.Timestamp;

public class AssignmentSubmission
{
    private int id;
    private int assignmentId;
    private String studentId;
    private String filename;
    private Timestamp submittedOn;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getAssignmentId()
    {
        return assignmentId;
    }
    public void setAssignmentId(int assignmentId)
    {
        this.assignmentId = assignmentId;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    public String getFilename()
    {
        return filename;
    }
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    public Timestamp getSubmittedOn()
    {
        return submittedOn;
    }
    public void setSubmittedOn(Timestamp submittedOn)
    {
        this.submittedOn = submittedOn;
    }
}
