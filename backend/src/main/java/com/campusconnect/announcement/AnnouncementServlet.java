package com.campusconnect.announcement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/announcement")
public class AnnouncementServlet extends HttpServlet
{
    private AnnouncementDAO announcementDAO;

    @Override
    public void init()
    {
        announcementDAO = new AnnouncementDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int facultyId = Integer.parseInt(request.getParameter("facultyId"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Announcement announcement = new Announcement(facultyId, title, content);
        boolean success = announcementDAO.postAnnouncement(announcement);

        response.sendRedirect(success ? "facultyDashboard.jsp" : "error.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        List<Announcement> announcements = announcementDAO.getAllAnnouncements();
        request.setAttribute("announcements", announcements);
        request.getRequestDispatcher("announcement.jsp").forward(request, response);
    }
}