package com.campusconnect.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.campusconnect.utils.DBUtil;

public class AdminDAO
{
    public void createSection(Section section)
    {
        String query = "INSERT INTO Section (name) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setString(1, section.getName());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void assignMentor(MentorAssignment assignment)
    {
        String query = "UPDATE Student SET mentor_id = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setInt(1, assignment.getFacultyId());
            stmt.setInt(2, assignment.getStudentId());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}