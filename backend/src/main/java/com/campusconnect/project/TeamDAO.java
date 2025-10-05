public class TeamDAO {
    private Connection conn = DBUtil.getConnection();

    public int createTeam(Team t) {
        String sql = "INSERT INTO teams (team_name, created_by) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, t.getTeamName());
            ps.setInt(2, t.getCreatedBy());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void addTeamMember(TeamMember tm) {
        String sql = "INSERT INTO team_members (team_id, student_id, role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, tm.getTeamId());
            ps.setInt(2, tm.getStudentId());
            ps.setString(3, tm.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
