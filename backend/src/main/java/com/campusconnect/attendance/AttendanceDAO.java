package com.campusconnect.attendance;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class AttendanceDAO {
    private Connection conn = DBUtil.getConnection();

    public void markAttendance(Attendance a) {
        String sql = "INSERT INTO attendance (student_id, date, status, marked_by) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getStudentId());
            ps.setDate(2, Date.valueOf(a.getDate()));
            ps.setString(3, a.getStatus());
            ps.setInt(4, a.getMarkedBy());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Attendance> getAttendanceForStudent(int studentId) {
        String sql = "SELECT * FROM attendance WHERE student_id = ? ORDER BY date DESC";
        List<Attendance> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setId(rs.getInt("id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setDate(rs.getDate("date").toLocalDate());
                a.setStatus(rs.getString("status"));
                a.setMarkedBy(rs.getInt("marked_by"));
                a.setMarkedOn(rs.getTimestamp("marked_on").toLocalDateTime());
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public double calculateAttendancePercentage(int studentId) {
        String sql = "SELECT status, COUNT(*) as count FROM attendance WHERE student_id = ? GROUP BY status";
        int present = 0, total = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String status = rs.getString("status");
                int count = rs.getInt("count");
                total += count;
                if ("PRESENT".equals(status)) present += count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total == 0 ? 0 : (present * 100.0) / total;
    }
}
