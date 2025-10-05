package com.campusconnect.faculty;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int facultyId = (int) session.getAttribute("userId");
        FacultyDAO dao = new FacultyDAO();
        Faculty faculty = dao.getFacultyById(facultyId);
        List<Integer> studentIds = dao.getAssignedStudents(facultyId);

        req.setAttribute("faculty", faculty);
        req.setAttribute("studentIds", studentIds);
        req.getRequestDispatcher("faculty/FacultyDashboard.jsp").forward(req, res);
    }
}
