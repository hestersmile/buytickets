package com.moviepojo;

import java.util.Date;

public class TestMovie {

    private String movieTitle;

    private String movieNum;

    private String movieTempNum;

    private String movieActor;

    private Integer movieImgName;


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle == null ? null : movieTitle.trim();
    }



    public String getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(String movieNum) {
        this.movieNum = movieNum;
    }

    public String getMovieTempNum() {
        return movieTempNum;
    }

    public void setMovieTempNum(String movieTempNum) {
        this.movieTempNum = movieTempNum;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor == null ? null : movieActor.trim();
    }





    public Integer getMovieImgName() {
        return movieImgName;
    }

    public void setMovieImgName(Integer movieImgName) {
        this.movieImgName = movieImgName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                " movieTitle='" + movieTitle + '\'' +
                ", movieNum=" + movieNum +
                ", movieTempNum=" + movieTempNum +
                ", movieActor='" + movieActor + '\'' +
                ", movieImgName='" + movieImgName + '\'' +
                '}';
    }
}