package com.campusconnect.project;

public class TeamMember
{
    private int id;
    private int teamId;
    private String name;
    private String role; // e.g., "Leader", "Developer", "Designer"
    private String email;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getTeamId()
    {
        return teamId;
    }
    public void setTeamId(int teamId)
    {
        this.teamId = teamId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
