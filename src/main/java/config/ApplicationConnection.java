package config;

import java.sql.*;


public class ApplicationConnection {
    private static Connection connection;
    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres",
                            "mysecretpassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
