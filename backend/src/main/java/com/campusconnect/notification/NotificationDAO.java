package com.campusconnect.notification;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class NotificationDAO {
    private Connection conn = DBUtil.getConnection();

    public void sendNotification(Notification n) {
        String sql = "INSERT INTO notifications (sender_id, role_target, message, urgency) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, n.getSenderId());
            ps.setString(2, n.getRoleTarget());
            ps.setString(3, n.getMessage());
            ps.setString(4, n.getUrgency());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Notification> getNotificationsForRole(String role) {
        String sql = "SELECT * FROM notifications WHERE role_target = ? OR role_target = 'ALL' ORDER BY posted_on DESC";
        List<Notification> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, role);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notification n = new Notification();
                n.setId(rs.getInt("id"));
                n.setSenderId(rs.getInt("sender_id"));
                n.setRoleTarget(rs.getString("role_target"));
                n.setMessage(rs.getString("message"));
                n.setUrgency(rs.getString("urgency"));
                n.setPostedOn(rs.getTimestamp("posted_on").toLocalDateTime());
                list.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
