package com.campusconnect.attendance;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewAttendance")
public class AttendanceViewerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int studentId = (int) session.getAttribute("userId");
        AttendanceDAO dao = new AttendanceDAO();
        List<Attendance> records = dao.getAttendanceForStudent(studentId);
        double percentage = dao.calculateAttendancePercentage(studentId);

        req.setAttribute("records", records);
        req.setAttribute("percentage", percentage);
        req.getRequestDispatcher("student/AttendanceViewer.jsp").forward(req, res);
    }
}
