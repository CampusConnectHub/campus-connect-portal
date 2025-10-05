package com.campusconnect.utils;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {
    public static boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("userId") != null;
    }

    public static boolean isRole(HttpSession session, String role) {
        return isLoggedIn(session) && role.equals(session.getAttribute("role"));
    }
}
