package com.campusconnect.student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int studentId = (int) session.getAttribute("userId");
        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentById(studentId);

        req.setAttribute("student", student);
        req.getRequestDispatcher("student/StudentDashboard.jsp").forward(req, res);
    }
}
