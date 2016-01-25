package com.wangweibo.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除掉数据库中投票数目<20的用户，以及把没有出现在vote表中的用户删除
 * 
 * @author woshi_bobo
 */
public class VoteDAO extends DAO {
    static int[] user = new int[336225]; // 投票表中的用户，记录每个用户投多少票
    static int[] friend = new int[336225];// 记录好友表中，一个用户有多少朋友。

    /**
     * vote表中， 得到每个用户投票数量，初始化数组
     */
    public void getVoteUser() {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select userid,count(*) as number from vote group by userid "; // 要处理的sql
            ResultSet rs = stmt.executeQuery(sql); // 返回结果集
            while (rs.next()) {
                int userId = rs.getInt("userid"); // 得到投票用户id
                int voteNumber = rs.getInt("number"); // 用户投票数，
                System.out.println("投票数，，，" + voteNumber);
                user[userId] = voteNumber;

            }
            stmt.close(); // 关闭处理语句
            conn.close(); // 关闭连接
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * vote表中，删除投票数目<20的用户
     */
    public void deleteUser() {
        connect();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            for (int i = 1; i < user.length; i++) {
                if (user[i] < 20 && user[i] > 0) { // 第一个条件不满足就不执行第二个了。
                    String sql = String.format(
                            "delete  from vote where userid=%d ", i); // 要处理的sql
                    System.out.println("删除vote表中sql 语句： " + sql);
                    stmt.execute(sql);
                }
            }
            stmt.close(); // 关闭处理语句
            conn.close(); // 关闭连接
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * friend表中得到每个用户关注了多少好友。
     */
    public void getUserFriend() {
        connect();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select userid,count(*) as number from friend group by userid "; // 要处理的sql
            ResultSet rs = stmt.executeQuery(sql); // 返回结果集
            while (rs.next()) {
                int userId = rs.getInt("userid"); // 得到投票用户id
                int friendNumber = rs.getInt("number"); // 用户投票数，
                System.out.println(userId + " 关注好友数：  " + friendNumber);
                friend[userId] = friendNumber;

            }
            stmt.close(); // 关闭处理语句
            conn.close(); // 关闭连接
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 删除没有出现在投票表中的用户
     */
    public void deleteFriend() {
        connect();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            for (int i = 1; i < friend.length; i++) {

                // System.out.println("用户： "+i+" 投票："+user[i]+" 好友数： "+friend[i]);
                if (friend[i] > 0 && user[i] == 0) { // 第一个条件不满足就不执行第二个了。
                                                     // 在friend表中出现，但是没有在vote表中出现。
                    String sql = String.format(
                            " delete  from friend where userid=%d ", i); // 要处理的sql
                    System.out.println("删除friend表中sql 语句： " + sql);
                    stmt.execute(sql);
                }
            }
            stmt.close(); // 关闭处理语句
            conn.close(); // 关闭连接
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VoteDAO vote = new VoteDAO();
        vote.getVoteUser();// 得到投票表中每个用户投票数。
        // vote.deleteUser();//把投票<20的用户删除掉
        vote.getUserFriend();// 得到好友表中每个用户关注多少人
        vote.deleteFriend();// 把没有出现在投票表中的用户删除。
        System.out.println("end...........");
        // for(int i=1;i<friend.length;i++){
        // System.out.println("用户 "+i+" 投票数目： "+friend[i]);
        // }

        // int count=0;
        // for(int i=1;i<user.length;i++){
        // if(user[i]>=20){
        // System.out.println("userid: "+i+"  votenumber: "+user[i]);
        // count++;
        // }
        // }
        // System.out.println("一共有多少个用户投票数>20  : "+count);
    }
}
