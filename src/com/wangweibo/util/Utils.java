package com.wangweibo.util;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import com.wangweibo.pojo.Actor;
import com.wangweibo.pojo.Director;
import com.wangweibo.pojo.Genre;
import com.wangweibo.pojo.Movie;
import com.wangweibo.pojo.User;

public class Utils {

    public static final String calculatorMoviesSimilarity(Movie movie1,
            Movie movie2) {
        double similarityResult = 0L;

        // directors
        double x1 = calculatorMoviesSimilarityInDirector(movie1, movie2);

        // actor
        double x2 = calculatorMoviesSimilarityInActor(movie1, movie2);

        // genre
        double x3 = calculatorMoviesSimilarityInGenre(movie1, movie2);

        // rate
        double x4 = calculatorMoviesSimilarityInRate(movie1, movie2);

        similarityResult = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2)
                + Math.pow(x3, 2) + Math.pow(x4, 2)) / 2;

        // 保留4位
        DecimalFormat df = new DecimalFormat("#.0000");
        return df.format(similarityResult);
    }
    
    //计算movie1 跟 movie2 在导演方面的相似性
    public static final double calculatorMoviesSimilarityInDirector(Movie movie1,
            Movie movie2) {
    	   // directors
        Set<Director> directors1 = movie1.getDirectors();
        Set<Director> directors2 = movie2.getDirectors();
        Set<Director> result = new HashSet<Director>();
        // 交集
        result.addAll(directors1);
        result.retainAll(directors2);
        int intersection = result.size();

        // 并集
        result.clear();
        result.addAll(directors1);
        result.addAll(directors2);
        int union = result.size();

        double x1 = intersection * 1.0D / union;
    	
    	return x1;
    	  	
    }
    
    //计算movie1 跟 movie2 在演员方面的相似性
    public static final double calculatorMoviesSimilarityInActor(Movie movie1,
            Movie movie2) {
    	   // actors
        Set<Actor> actors1 = movie1.getActors();
        Set<Actor> actors2 = movie2.getActors();
        Set<Actor> result = new HashSet<Actor>();
        // 交集
        result.addAll(actors1);
        result.retainAll(actors2);
        int intersection = result.size();

        // 并集
        result.clear();
        result.addAll(actors1);
        result.addAll(actors2);
        int union = result.size();

        double x2 = intersection * 1.0D / union;
    	
    	return x2;
    }  
    
    //计算movie1 跟 movie2 在流派方面的相似性
    public static final double calculatorMoviesSimilarityInGenre(Movie movie1,
            Movie movie2) {
    	   // genres
        Set<Genre> genres1 = movie1.getGenre();
        Set<Genre> genres2 = movie2.getGenre();
        Set<Genre> result = new HashSet<Genre>();
        // 交集
        result.addAll(genres1);
        result.retainAll(genres2);
        int intersection = result.size();

        // 并集
        result.clear();
        result.addAll(genres1);
        result.addAll(genres2);
        int union = result.size();

        double x3 = intersection * 1.0D / union;
    	
    	return x3;
    }   
    // 计算movie1跟movie2 在评分方面的相似性
    public static  final double calculatorMoviesSimilarityInRate(Movie movie1,
            Movie movie2) {
    	double rate1=movie1.getRate();
    	double rate2=movie2.getRate();
    	double x4= (double)(5-Math.abs(rate1-rate2))/5;
    	return x4;
    }
    
    /**
     * 根据用户u的打分历史记录，预测用户u对电影i的打分
     */
    public static final double predictUserRate(User user, Movie movie){
    	user.getRating();//得到用户的欢看电影记录以及打分
    	return 0;
    }
    
    /**
     * 计算movie1的流行度
     */
    public static final double caculatorMoviesPopularity(SqlDAO sqlDAO, Movie movie){
    	int num1= sqlDAO.numbersHaveBeenSee(movie); //
    	int num2 = 2113; //社交网络中总人数。
    	double pop = (double)num1/num2 ;
    	return pop;
    }

}
