package com.campusconnect.project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ProjectServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        try
        {
            new ProjectDAO().createProject(title, description);
            res.sendRedirect("projectSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
