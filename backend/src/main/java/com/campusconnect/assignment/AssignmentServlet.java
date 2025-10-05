package com.campusconnect.assignment;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/createAssignment")
public class AssignmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
        int facultyId = (int) session.getAttribute("userId");

        Assignment a = new Assignment();
        a.setTitle(title);
        a.setDescription(description);
        a.setDueDate(dueDate);
        a.setCreatedBy(facultyId);

        new AssignmentDAO().createAssignment(a);
        res.sendRedirect("faculty/dashboard.jsp");
    }
}
