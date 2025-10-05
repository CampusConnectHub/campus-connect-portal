@WebServlet("/assignProject")
public class ProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int facultyId = (int) req.getSession().getAttribute("userId");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int teamId = Integer.parseInt(req.getParameter("teamId"));
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));

        Project p = new Project();
        p.setTitle(title);
        p.setDescription(description);
        p.setAssignedBy(facultyId);
        p.setTeamId(teamId);
        p.setDueDate(dueDate);

        new ProjectDAO().assignProject(p);
        res.sendRedirect("faculty/FacultyDashboard.jsp");
    }
}
