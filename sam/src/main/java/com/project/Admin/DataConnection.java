package com.project.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/app_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "pesson123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}
