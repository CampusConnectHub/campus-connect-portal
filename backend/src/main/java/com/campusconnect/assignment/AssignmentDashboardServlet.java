@WebServlet("/viewAssignments")
public class AssignmentDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int studentId = (int) req.getSession().getAttribute("userId");
        List<Assignment> assignments = new AssignmentDAO().getAssignmentsForStudent(studentId);
        req.setAttribute("assignments", assignments);
        req.getRequestDispatcher("student/ViewAssignments.jsp").forward(req, res);
    }
}
