package com.campusconnect.assignment;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class SubmissionDAO
{
    public void submitAssignment(AssignmentSubmission sub) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO submissions (assignment_id, student_id, submission_date, file_path) VALUES (?, ?, ?, ?)"
        );
        ps.setInt(1, sub.getAssignmentId());
        ps.setString(2, sub.getStudentId());
        ps.setTimestamp(3, sub.getSubmittedOn());
        ps.setString(4, sub.getFilename());
        ps.executeUpdate();
        conn.close();
    }

    public List<AssignmentSubmission> getSubmissionsByAssignment(int assignmentId) throws Exception
    {
        List<AssignmentSubmission> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM submissions WHERE assignment_id = ?");
        ps.setInt(1, assignmentId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            AssignmentSubmission sub = new AssignmentSubmission();
            sub.setId(rs.getInt("id"));
            sub.setAssignmentId(rs.getInt("assignment_id"));
            sub.setStudentId(rs.getString("student_id"));
            sub.setSubmittedOn(rs.getTimestamp("submission_date"));
            sub.setFilename(rs.getString("file_path"));
            list.add(sub);
        }
        conn.close();
        return list;
    }
}
