package com.campusconnect.announcement;

import com.campusconnect.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDAO {
    private Connection conn = DBUtil.getConnection();

    public void postAnnouncement(Announcement a) {
        String sql = "INSERT INTO announcements (category, text, image_path, pdf_path) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getCategory().name());
            ps.setString(2, a.getText());
            ps.setString(3, a.getImagePath());
            ps.setString(4, a.getPdfPath());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Announcement> getAnnouncementsByCategory(AnnouncementCategory category) {
        String sql = "SELECT * FROM announcements WHERE category = ? ORDER BY posted_on DESC";
        List<Announcement> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.name());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Announcement a = new Announcement();
                a.setId(rs.getInt("id"));
                a.setCategory(AnnouncementCategory.valueOf(rs.getString("category")));
                a.setText(rs.getString("text"));
                a.setImagePath(rs.getString("image_path"));
                a.setPdfPath(rs.getString("pdf_path"));
                a.setPostedOn(rs.getTimestamp("posted_on").toLocalDateTime());
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
