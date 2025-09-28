package com.campusconnect.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AuthServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try
        {
            User user = new AuthDAO().login(email, password);
            if (user != null)
            {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                res.sendRedirect("dashboard.jsp");
            }
            else
            {
                res.sendRedirect("login.jsp?error=invalid");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
