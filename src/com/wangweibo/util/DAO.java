package com.wangweibo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private String url;
    private String driver;
    private String uid;
    private String pwd;

    protected Connection conn; // 连接数据库。。

    public DAO() {
        // url =
        // "jdbc:mysql://localhost/blogdatabase?useUnicode=true&characterEncoding=utf-8";
        // url="jdbc:mysql://211.87.239.106:3306/digg_origina?useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=false&rewriteBatchedStatements=true";
        url = "jdbc:mysql://211.87.239.106:3306/imdb?useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=false&rewriteBatchedStatements=true";
        driver = "com.mysql.jdbc.Driver";
        uid = "root";
        pwd = "123";
    }

    // 建立连接。。
    protected void connect() {
        loadDriver();
        try {
            conn = DriverManager.getConnection(url, uid, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 加载驱动。。
    private void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
