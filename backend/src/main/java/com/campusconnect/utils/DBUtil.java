package com.campusconnect.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil
{
    private static final HikariDataSource dataSource;

    static
    {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/campusconnect");
        config.setUsername("root");
        config.setPassword("your_password");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setLeakDetectionThreshold(2000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }
}