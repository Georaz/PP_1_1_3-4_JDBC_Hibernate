package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pp_1_1_4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "georaz";
    private static Connection con;

    public static Connection getDBConnection() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение с БД установлено.");
        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД.");
            e.printStackTrace();
        }
        return con;
    }
}