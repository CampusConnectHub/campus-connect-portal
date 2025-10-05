package com.campusconnect.faculty;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class FacultyDAO {
    private Connection conn = DBUtil.getConnection();

    public Faculty getFacultyById(int facultyId) {
        String sql = "SELECT * FROM faculty WHERE faculty_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, facultyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Faculty f = new Faculty();
                f.setFacultyId(rs.getInt("faculty_id"));
                f.setName(rs.getString("name"));
                f.setEmail(rs.getString("email"));
                f.setDepartment(rs.getString("department"));
                return f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> getAssignedStudents(int facultyId) {
        String sql = "SELECT student_id FROM mentor_assignment WHERE mentor_id = ?";
        List<Integer> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, facultyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("student_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
