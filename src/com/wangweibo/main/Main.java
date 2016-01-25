package com.wangweibo.main;

import java.sql.Connection;

import com.wangweibo.util.SQLUtils;

public class Main {

    // 主函数
    public static void main(String[] args) {
        Connection connection = SQLUtils.getConnection();
        try {
            
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLUtils.close(connection);
        }

    }

    // 数据预处理
    static void preDealWithData() {
        
    }

    // 计算相似度矩阵
    static void calculatorSimularity() {

    }

}
