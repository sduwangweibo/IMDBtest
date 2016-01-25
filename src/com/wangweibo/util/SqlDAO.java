package com.wangweibo.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wangweibo.pojo.Movie;

public class SqlDAO extends DAO {

    // 一个电影有多人看的数
    public int numbersHaveBeenSee(Movie movie) {
        connect();
        int number = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = String
                    .format("select count(userID) as number from user_ratedmovies where movieID=%d",
                            movie.getMovieId());
            System.out.println("查询一个电影有多人看sql： " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                number = rs.getInt("number");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return number;
    }
}
