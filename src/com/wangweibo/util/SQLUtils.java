package com.wangweibo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLUtils {
    private static String url = "jdbc:mysql://211.87.239.106:3306/imdb?useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=false&rewriteBatchedStatements=true";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String uid = "root";
    private static String pwd = "123";

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, uid, pwd);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
