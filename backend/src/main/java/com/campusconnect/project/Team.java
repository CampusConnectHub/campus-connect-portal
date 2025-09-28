package com.campusconnect.project;

public class Team
{
    private int id;
    private String teamName;
    private int projectId;
    private String members; // comma-separated student IDs or names

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getTeamName()
    {
        return teamName;
    }
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }
    public int getProjectId()
    {
        return projectId;
    }
    public void setProjectId(int projectId)
    {
        this.projectId = projectId;
    }
    public String getMembers()
    {
        return members;
    }
    public void setMembers(String members)
    {
        this.members = members;
    }
}
