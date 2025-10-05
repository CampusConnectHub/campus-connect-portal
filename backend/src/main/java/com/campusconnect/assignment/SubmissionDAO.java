package com.campusconnect.assignment;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class SubmissionDAO {
    private Connection conn = DBUtil.getConnection();

    public void submitAssignment(AssignmentSubmission s) {
        String sql = "INSERT INTO assignment_submissions (assignment_id, student_id, file_path) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getAssignmentId());
            ps.setInt(2, s.getStudentId());
            ps.setString(3, s.getFilePath());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AssignmentSubmission> getSubmissionsForFaculty(int facultyId) {
        String sql = """
            SELECT s.*, a.title FROM assignment_submissions s
            JOIN assignments a ON s.assignment_id = a.id
            WHERE a.created_by = ?
            ORDER BY s.submitted_on DESC
        """;
        List<AssignmentSubmission> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, facultyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AssignmentSubmission s = new AssignmentSubmission();
                s.setId(rs.getInt("id"));
                s.setAssignmentId(rs.getInt("assignment_id"));
                s.setStudentId(rs.getInt("student_id"));
                s.setFilePath(rs.getString("file_path"));
                s.setSubmittedOn(rs.getTimestamp("submitted_on").toLocalDateTime());
                s.setGrade(rs.getString("grade"));
                s.setFeedback(rs.getString("feedback"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
