package com.wangweibo.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

public class User {
    private int userId;
    // private int movieId; //增加电影 id
    // private int rating; //一个用户是评价了好多电影，应该是个Map
    // private long timeStamp;
    private Map<Integer, Double> rating = new HashMap<Integer, Double>(); // 用户对电影评分
    private Map<Integer, Long> timeStamp = new HashMap<Integer, Long>(); // 用户对电影评分的时间

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, Double> getRating() {
        return rating;
    }

    public void setRating(Map<Integer, Double> rating) {
        this.rating = rating;
    }

    public Map<Integer, Long> getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Map<Integer, Long> timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Use)) {
            return false;
        }
        User user = (User) obj;
        return user.getUserId() == userId;
    }

}
