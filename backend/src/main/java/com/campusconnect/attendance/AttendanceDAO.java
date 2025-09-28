package com.campusconnect.attendance;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class AttendanceDAO
{
    public void markAttendance(Attendance a) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO attendance (student_id, date, present) VALUES (?, ?, ?)"
        );
        ps.setInt(1, a.getStudentId());
        ps.setString(2, a.getDate());
        ps.setBoolean(3, a.isPresent());
        ps.executeUpdate();
        conn.close();
    }

    public List<Attendance> getAttendanceByStudent(int studentId) throws Exception
    {
        List<Attendance> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM attendance WHERE student_id = ?"
        );
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Attendance a = new Attendance();
            a.setId(rs.getInt("id"));
            a.setStudentId(rs.getInt("student_id"));
            a.setDate(rs.getString("date"));
            a.setPresent(rs.getBoolean("present"));
            list.add(a);
        }
        conn.close();
        return list;
    }
}
