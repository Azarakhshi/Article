package config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.sql.*;


@Log4j2
public class ApplicationConnection {

    private static Connection connection;

    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres",
                            "mysecretpassword");
        } catch (SQLException ex) {

            log.error("connection error", ex);

        }

    }
    public static Connection getConnection() {
        return connection;
    }

}
