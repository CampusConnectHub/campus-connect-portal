package com.campusconnect.assignment;

import com.campusconnect.utils.DBUtil;
import java.sql.*;
import java.util.*;

public class AssignmentDAO
{
    public List<Assignment> getAllAssignments() throws Exception
    {
        List<Assignment> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM assignments");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Assignment a = new Assignment();
            a.setId(rs.getInt("id"));
            a.setTitle(rs.getString("title"));
            a.setDescription(rs.getString("description"));
            a.setDeadline(rs.getString("deadline"));
            a.setCourseId(rs.getInt("course_id"));
            list.add(a);
        }
        conn.close();
        return list;
    }

    public void addAssignment(Assignment a) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO assignments (title, description, deadline, course_id) VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, a.getTitle());
        ps.setString(2, a.getDescription());
        ps.setString(3, a.getDeadline());
        ps.setInt(4, a.getCourseId());
        ps.executeUpdate();
        conn.close();
    }
}
