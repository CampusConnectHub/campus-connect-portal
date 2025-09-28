package com.campusconnect.project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class TeamServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String teamName = req.getParameter("teamName");
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        String members = req.getParameter("members"); // comma-separated

        Team team = new Team();
        team.setTeamName(teamName);
        team.setProjectId(projectId);
        team.setMembers(members);

        try
        {
            new ProjectDAO().registerTeam(team);
            res.sendRedirect("teamSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
