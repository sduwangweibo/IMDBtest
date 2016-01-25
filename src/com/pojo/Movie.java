package com.pojo;

import java.util.HashSet;
import java.util.Set;

public class Movie {
    private int movieId;
    private double  rate;    //增加电影平均分
   // private Set<String> gener = new HashSet<String>();
    private Set<Genre> genre = new HashSet<Genre>();
    private Set<Actor> actors = new HashSet<Actor>();
    private Set<Director> directors = new HashSet<Director>();
    
    private Set<User> users = new HashSet<User>();

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Set<Genre> getGenre() {
		return genre;
	}

	public void setGenre(Set<Genre> genre) {
		this.genre = genre;
	}

	public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
