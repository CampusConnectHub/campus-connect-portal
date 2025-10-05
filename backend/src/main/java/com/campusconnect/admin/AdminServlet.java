package com.campusconnect.admin;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        List<User> users = dao.getAllUsers();
        Map<String, Integer> stats = dao.getSystemStats();

        req.setAttribute("users", users);
        req.setAttribute("stats", stats);
        req.getRequestDispatcher("AdminDashboard.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("approve".equals(action)) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            new AdminDAO().approveUser(userId);
        }
        res.sendRedirect("admin");
    }
}
