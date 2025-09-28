package com.campusconnect.student;

import com.campusconnect.utils.DBUtil;
import java.sql.*;

public class StudentDAO
{
    public Student getStudentByEmail(String email) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        Student s = null;
        if (rs.next())
        {
            s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setDepartment(rs.getString("department"));
            s.setRollNumber(rs.getString("roll_number"));
        }

        conn.close();
        return s;
    }
}
