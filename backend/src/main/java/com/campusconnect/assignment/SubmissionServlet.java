package com.campusconnect.assignment;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.Timestamp;

public class SubmissionServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));
        String studentId = req.getParameter("studentId");
        String filename = req.getParameter("filename");

        AssignmentSubmission sub = new AssignmentSubmission();
        sub.setAssignmentId(assignmentId);
        sub.setStudentId(studentId);
        sub.setFilename(filename);
        sub.setSubmittedOn(new Timestamp(System.currentTimeMillis()));

        try
        {
            new SubmissionDAO().submitAssignment(sub);
            res.sendRedirect("submissionSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
