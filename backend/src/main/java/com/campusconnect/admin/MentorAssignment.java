package com.campusconnect.admin;
public class AdminDAO {
    private Connection conn = DBUtil.getConnection();

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setName(rs.getString("name"));
                u.setRole(rs.getString("role"));
                u.setApproved(rs.getBoolean("approved"));
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void approveUser(int userId) {
        String sql = "UPDATE users SET approved = true WHERE user_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getSystemStats() {
        Map<String, Integer> stats = new HashMap<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM users");
            if (rs1.next()) stats.put("totalUsers", rs1.getInt(1));

            ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM projects");
            if (rs2.next()) stats.put("totalProjects", rs2.getInt(1));

            ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM assignments");
            if (rs3.next()) stats.put("totalAssignments", rs3.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stats;
    }
}
