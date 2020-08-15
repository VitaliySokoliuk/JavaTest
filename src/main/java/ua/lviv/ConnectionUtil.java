package ua.lviv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private final static String URL = "jdbc:mysql://localhost:3306/garage?serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASSWORD = "qwerty";

    protected static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to DB");
        }
    }

}
