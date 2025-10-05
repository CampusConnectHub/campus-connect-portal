package com.campusconnect.notification;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewNotifications")
public class NotificationViewerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("role") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String role = (String) session.getAttribute("role");
        List<Notification> list = new NotificationDAO().getNotificationsForRole(role);

        req.setAttribute("notifications", list);
        req.getRequestDispatcher("student/NotificationViewer.jsp").forward(req, res);
    }
}
