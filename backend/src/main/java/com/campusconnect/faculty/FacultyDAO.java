package com.campusconnect.faculty;

import com.campusconnect.utils.DBUtil;
import java.sql.*;

public class FacultyDAO
{
    public Faculty getFacultyByEmail(String email) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        Faculty f = null;
        if (rs.next())
        {
            f = new Faculty();
            f.setId(rs.getInt("id"));
            f.setName(rs.getString("name"));
            f.setEmail(rs.getString("email"));
            f.setDepartment(rs.getString("department"));
        }

        conn.close();
        return f;
    }
}
