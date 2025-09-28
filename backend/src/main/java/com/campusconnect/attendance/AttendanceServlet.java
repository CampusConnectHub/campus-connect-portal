package com.campusconnect.attendance;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AttendanceServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String date = req.getParameter("date");
        boolean present = Boolean.parseBoolean(req.getParameter("present"));

        Attendance a = new Attendance();
        a.setStudentId(studentId);
        a.setDate(date);
        a.setPresent(present);

        try
        {
            new AttendanceDAO().markAttendance(a);
            res.sendRedirect("attendanceSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
