package com.campusconnect.auth;

import jakarta.servlet.http.*;

public class SessionUtil {
    public static boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("userId") != null;
    }

    public static boolean isRole(HttpSession session, String role) {
        return isLoggedIn(session) && role.equals(session.getAttribute("role"));
    }
}
