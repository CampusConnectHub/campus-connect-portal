package com.campusconnect.auth;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String password = req.getParameter("password");

        AuthDAO dao = new AuthDAO();
        User user = dao.validateLogin(userId, password);

        if (user != null && user.isApproved()) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());

            switch (user.getRole()) {
                case "ADMIN": res.sendRedirect("admin/AdminDashboard.jsp"); break;
                case "FACULTY": res.sendRedirect("faculty/FacultyDashboard.jsp"); break;
                case "STUDENT": res.sendRedirect("student/StudentDashboard.jsp"); break;
            }
        } else {
            req.setAttribute("error", "Invalid credentials or not approved.");
            req.getRequestDispatcher("shared/login.jsp").forward(req, res);
        }
    }
}
