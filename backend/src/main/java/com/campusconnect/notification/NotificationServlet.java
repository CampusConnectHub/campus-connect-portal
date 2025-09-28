package com.campusconnect.notification;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String title = req.getParameter("title");
        String message = req.getParameter("message");
        String recipientType = req.getParameter("recipientType");

        Notification n = new Notification();
        n.setTitle(title);
        n.setMessage(message);
        n.setRecipientType(recipientType);
        n.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        try
        {
            new NotificationDAO().sendNotification(n);
            res.sendRedirect("notificationSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
