package com.booktracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {
    private static final String URL = System.getProperty("booktracker.db.url", "jdbc:mysql://localhost:3306/book_issue_tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
    private static final String USER = System.getProperty("booktracker.db.user", "root");
    private static final String PASSWORD = System.getProperty("booktracker.db.password",
            System.getenv().getOrDefault("BOOKTRACKER_DB_PASSWORD", "YOUR_MYSQL_PASSWORD"));
    static {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) { throw new ExceptionInInitializerError(e); }
    }
    private DBUtil() {}
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL, USER, PASSWORD); }
}
