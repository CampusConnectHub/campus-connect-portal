package com.campusconnect.notification;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class NotificationDAO
{
    public void sendNotification(Notification n) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO notifications (title, message, timestamp, recipient_type) VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, n.getTitle());
        ps.setString(2, n.getMessage());
        ps.setString(3, n.getTimestamp());
        ps.setString(4, n.getRecipientType());
        ps.executeUpdate();
        conn.close();
    }

    public List<Notification> getNotificationsFor(String recipientType) throws Exception
    {
        List<Notification> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM notifications WHERE recipient_type = ? ORDER BY timestamp DESC"
        );
        ps.setString(1, recipientType);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Notification n = new Notification();
            n.setId(rs.getInt("id"));
            n.setTitle(rs.getString("title"));
            n.setMessage(rs.getString("message"));
            n.setTimestamp(rs.getString("timestamp"));
            n.setRecipientType(rs.getString("recipient_type"));
            list.add(n);
        }
        conn.close();
        return list;
    }
}
