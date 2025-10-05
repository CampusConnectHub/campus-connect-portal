public class ProjectDAO {
    private Connection conn = DBUtil.getConnection();

    public void assignProject(Project p) {
        String sql = "INSERT INTO projects (title, description, assigned_by, team_id, due_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getTitle());
            ps.setString(2, p.getDescription());
            ps.setInt(3, p.getAssignedBy());
            ps.setInt(4, p.getTeamId());
            ps.setDate(5, Date.valueOf(p.getDueDate()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitProject(ProjectSubmission s) {
        String sql = "INSERT INTO project_submissions (project_id, team_id, file_path, submitted_on, status) VALUES (?, ?, ?, NOW(), 'SUBMITTED')";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getProjectId());
            ps.setInt(2, s.getTeamId());
            ps.setString(3, s.getFilePath());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void approveProject(int submissionId, String feedback) {
        String sql = "UPDATE project_submissions SET status = 'APPROVED', feedback = ? WHERE submission_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback);
            ps.setInt(2, submissionId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
