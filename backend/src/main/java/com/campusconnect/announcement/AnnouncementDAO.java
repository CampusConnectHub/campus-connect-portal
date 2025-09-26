package com.campusconnect.announcement;

import com.campusconnect.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDAO
{

    public boolean postAnnouncement(Announcement announcement)
    {
        String query = "INSERT INTO Announcement (faculty_id, title, content, timestamp) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setInt(1, announcement.getFacultyId());
            stmt.setString(2, announcement.getTitle());
            stmt.setString(3, announcement.getContent());
            stmt.setTimestamp(4, Timestamp.valueOf(announcement.getTimestamp()));
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public List<Announcement> getAllAnnouncements() {
        List<Announcement> list = new ArrayList<>();
        String query = "SELECT * FROM Announcement ORDER BY timestamp DESC";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery())
        {
            while (rs.next())
            {
                list.add(new Announcement(
                        rs.getInt("id"),
                        rs.getInt("faculty_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("timestamp").toLocalDateTime()
                ));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}