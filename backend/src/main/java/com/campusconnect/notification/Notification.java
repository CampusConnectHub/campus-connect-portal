package com.campusconnect.notification;

public class Notification
{
    private int id;
    private String title;
    private String message;
    private String timestamp;
    private String recipientType; // e.g., "student", "faculty", "admin"

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
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getTimestamp()
    {
        return timestamp;
    }
    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
    public String getRecipientType()
    {
        return recipientType;
    }
    public void setRecipientType(String recipientType)
    {
        this.recipientType = recipientType;
    }
}
