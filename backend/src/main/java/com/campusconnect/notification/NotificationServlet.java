package com.campusconnect.notification;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/sendNotification")
public class NotificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int senderId = (int) session.getAttribute("userId");
        String roleTarget = req.getParameter("roleTarget");
        String message = req.getParameter("message");
        String urgency = req.getParameter("urgency");

        Notification n = new Notification();
        n.setSenderId(senderId);
        n.setRoleTarget(roleTarget);
        n.setMessage(message);
        n.setUrgency(urgency);

        new NotificationDAO().sendNotification(n);
        res.sendRedirect("faculty/FacultyDashboard.jsp");
    }
}
