package com.campusconnect.assignment;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AssignmentServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String deadline = req.getParameter("deadline");
        int courseId = Integer.parseInt(req.getParameter("courseId"));

        Assignment a = new Assignment();
        a.setTitle(title);
        a.setDescription(description);
        a.setDeadline(deadline);
        a.setCourseId(courseId);

        try
        {
            new AssignmentDAO().addAssignment(a);
            res.sendRedirect("assignments.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
