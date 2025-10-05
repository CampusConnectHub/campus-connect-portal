@WebServlet("/createTeam")
public class TeamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int creatorId = (int) req.getSession().getAttribute("userId");
        String teamName = req.getParameter("teamName");
        String[] memberIds = req.getParameterValues("memberIds");

        Team t = new Team();
        t.setTeamName(teamName);
        t.setCreatedBy(creatorId);

        TeamDAO dao = new TeamDAO();
        int teamId = dao.createTeam(t);

        for (String memberId : memberIds) {
            TeamMember tm = new TeamMember();
            tm.setTeamId(teamId);
            tm.setStudentId(Integer.parseInt(memberId));
            tm.setRole("Member");
            dao.addTeamMember(tm);
        }

        res.sendRedirect("student/StudentDashboard.jsp");
    }
}
