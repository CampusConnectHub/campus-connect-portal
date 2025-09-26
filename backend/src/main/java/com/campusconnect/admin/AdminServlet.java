package com.campusconnect.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminServlet extends HttpServlet
{
    private AdminDAO adminDAO;

    @Override
    public void init()
    {
        adminDAO = new AdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");

        switch (action)
        {
            case "createSection":
                createSection(request, response);
                break;
            case "assignMentor":
                assignMentor(request, response);
                break;
        }
    }

    private void createSection(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String sectionName = request.getParameter("sectionName");
        adminDAO.createSection(new Section(sectionName));
        response.sendRedirect("adminPanel.jsp");
    }

    private void assignMentor(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int facultyId = Integer.parseInt(request.getParameter("facultyId"));
        adminDAO.assignMentor(new MentorAssignment(studentId, facultyId));
        response.sendRedirect("adminPanel.jsp");
    }
}