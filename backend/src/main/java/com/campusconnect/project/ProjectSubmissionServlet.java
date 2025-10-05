@WebServlet("/submitProject")
@MultipartConfig
public class ProjectSubmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int teamId = Integer.parseInt(req.getParameter("teamId"));
        int projectId = Integer.parseInt(req.getParameter("projectId"));

        Part filePart = req.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadDir = getServletContext().getRealPath("/uploads/projects/");
        Files.createDirectories(Paths.get(uploadDir));
        String filePath = uploadDir + File.separator + fileName;
        filePart.write(filePath);

        ProjectSubmission s = new ProjectSubmission();
        s.setProjectId(projectId);
        s.setTeamId(teamId);
        s.setFilePath("uploads/projects/" + fileName);

        new ProjectDAO().submitProject(s);
        res.sendRedirect("student/StudentDashboard.jsp");
    }
}
