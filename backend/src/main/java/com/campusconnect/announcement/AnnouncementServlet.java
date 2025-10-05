package com.campusconnect.announcement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/postAnnouncement")
@MultipartConfig
public class AnnouncementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String category = req.getParameter("category");
        String text = req.getParameter("text");

        Part imagePart = req.getPart("image");
        Part pdfPart = req.getPart("pdf");

        String imagePath = null, pdfPath = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            String imageName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            imagePath = "uploads/images/" + imageName;
            imagePart.write(imagePath);
        }

        if (pdfPart != null && pdfPart.getSize() > 0) {
            String pdfName = Paths.get(pdfPart.getSubmittedFileName()).getFileName().toString();
            pdfPath = "uploads/pdfs/" + pdfName;
            pdfPart.write(pdfPath);
        }

        Announcement a = new Announcement();
        a.setCategory(AnnouncementCategory.valueOf(category));
        a.setText(text);
        a.setImagePath(imagePath);
        a.setPdfPath(pdfPath);

        new AnnouncementDAO().postAnnouncement(a);
        res.sendRedirect("admin");
    }
}
