@WebServlet("/viewAttendance")
public class AttendanceDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int studentId = (int) req.getSession().getAttribute("userId");
        AttendanceDAO dao = new AttendanceDAO();
        List<Attendance> records = dao.getAttendanceForStudent(studentId);
        double percentage = dao.calculateAttendancePercentage(studentId);
        req.setAttribute("records", records);
        req.setAttribute("percentage", percentage);
        req.getRequestDispatcher("student/ViewAttendance.jsp").forward(req, res);
    }
}
