package com.wangweibo.pojo;

public class Genre {
private String genreId;
public String getGenreId(){
	return genreId;
}
public void setGenreId(String genreId){
	this.genreId=genreId;
}
@Override
public int hashCode() {
    return genreId.hashCode();
}

@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Genre)) {
        return false;
    }
    Genre genre = (Genre) obj;
    return this.genreId.equals(genre.getGenreId());
}

}
