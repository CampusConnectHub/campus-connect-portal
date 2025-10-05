@WebServlet("/viewNotifications")
public class NotificationDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String role = (String) req.getSession().getAttribute("role");
        List<Notification> notifications = new NotificationDAO().getNotificationsForRole(role);
        req.setAttribute("notifications", notifications);
        req.getRequestDispatcher("student/ViewNotifications.jsp").forward(req, res);
    }
}
