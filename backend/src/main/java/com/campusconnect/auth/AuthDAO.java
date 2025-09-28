package com.campusconnect.auth;

import com.campusconnect.utils.DBUtil;
import java.sql.*;

public class AuthDAO
{
    public User login(String email, String password) throws Exception
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE email = ? AND password = ?"
        );
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        User user = null;
        if (rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }

        conn.close();
        return user;
    }
}
