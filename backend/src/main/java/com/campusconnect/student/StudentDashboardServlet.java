package com.campusconnect.student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class StudentDashboardServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null)
        {
            res.sendRedirect("login.jsp");
            return;
        }

        String email = ((com.campusconnect.auth.User) session.getAttribute("user")).getEmail();

        try
        {
            Student student = new StudentDAO().getStudentByEmail(email);
            req.setAttribute("student", student);
            RequestDispatcher rd = req.getRequestDispatcher("studentDashboard.jsp");
            rd.forward(req, res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
