package com.campusconnect.assignment;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class AssignmentDAO {
    private Connection conn = DBUtil.getConnection();

    public void createAssignment(Assignment a) {
        String sql = "INSERT INTO assignments (title, description, due_date, created_by) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getTitle());
            ps.setString(2, a.getDescription());
            ps.setDate(3, Date.valueOf(a.getDueDate()));
            ps.setInt(4, a.getCreatedBy());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Assignment> getAssignmentsForStudent() {
        String sql = "SELECT * FROM assignments WHERE due_date >= CURDATE() ORDER BY due_date ASC";
        List<Assignment> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Assignment a = new Assignment();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setDueDate(rs.getDate("due_date").toLocalDate());
                a.setCreatedBy(rs.getInt("created_by"));
                a.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

