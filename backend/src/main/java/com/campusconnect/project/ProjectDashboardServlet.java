@WebServlet("/viewProjects")
public class ProjectDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int studentId = (int) req.getSession().getAttribute("userId");
        List<Project> projects = new ProjectDAO().getProjectsForStudent(studentId);
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("student/ViewProjects.jsp").forward(req, res);
    }
}
