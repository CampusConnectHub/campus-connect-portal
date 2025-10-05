package com.campusconnect.auth;

import com.campusconnect.utils.DBUtil;
import java.sql.*;

public class AuthDAO {
    private Connection conn = DBUtil.getConnection();

    public User validateLogin(int userId, String password) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password_hash");
                if (HashUtil.verify(password, storedHash)) {
                    User u = new User();
                    u.setUserId(rs.getInt("user_id"));
                    u.setName(rs.getString("name"));
                    u.setEmail(rs.getString("email"));
                    u.setRole(rs.getString("role"));
                    u.setApproved(rs.getBoolean("approved"));
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
