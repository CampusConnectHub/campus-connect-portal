package com.campusconnect.attendance;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/markAttendance")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int facultyId = (int) session.getAttribute("userId");
        String[] studentIds = req.getParameterValues("studentId");
        String[] statuses = req.getParameterValues("status");
        LocalDate date = LocalDate.parse(req.getParameter("date"));

        AttendanceDAO dao = new AttendanceDAO();
        for (int i = 0; i < studentIds.length; i++) {
            Attendance a = new Attendance();
            a.setStudentId(Integer.parseInt(studentIds[i]));
            a.setDate(date);
            a.setStatus(statuses[i]);
            a.setMarkedBy(facultyId);
            dao.markAttendance(a);
        }

        res.sendRedirect("faculty/dashboard.jsp");
    }
}
