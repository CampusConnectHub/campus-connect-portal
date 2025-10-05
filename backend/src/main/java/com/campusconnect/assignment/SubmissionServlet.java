package com.campusconnect.assignment;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.nio.file.*;

@WebServlet("/submitAssignment")
@MultipartConfig
public class SubmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));
        int studentId = (int) session.getAttribute("userId");

        Part filePart = req.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadDir = getServletContext().getRealPath("/uploads/assignments/");
        Files.createDirectories(Paths.get(uploadDir));
        String filePath = uploadDir + File.separator + fileName;
        filePart.write(filePath);

        AssignmentSubmission s = new AssignmentSubmission();
        s.setAssignmentId(assignmentId);
        s.setStudentId(studentId);
        s.setFilePath("uploads/assignments/" + fileName);

        new SubmissionDAO().submitAssignment(s);
        res.sendRedirect("student/dashboard.jsp");
    }
}
