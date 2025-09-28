package com.campusconnect.project;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class ProjectDAO
{
    public void createProject(String title, String description) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO projects (title, description) VALUES (?, ?)"
        );
        ps.setString(1, title);
        ps.setString(2, description);
        ps.executeUpdate();
        conn.close();
    }

    public void registerTeam(Team team) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO teams (team_name, project_id, members) VALUES (?, ?, ?)"
        );
        ps.setString(1, team.getTeamName());
        ps.setInt(2, team.getProjectId());
        ps.setString(3, team.getMembers());
        ps.executeUpdate();
        conn.close();
    }

    public List<Team> getTeamsByProject(int projectId) throws Exception
    {
        List<Team> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM teams WHERE project_id = ?"
        );
        ps.setInt(1, projectId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Team t = new Team();
            t.setId(rs.getInt("id"));
            t.setTeamName(rs.getString("team_name"));
            t.setProjectId(rs.getInt("project_id"));
            t.setMembers(rs.getString("members"));
            list.add(t);
        }
        conn.close();
        return list;
    }
}
