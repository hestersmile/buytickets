package com.moviepojo;

import java.util.Date;

public class UpdateMovie {
    private String movieTitle;

    private String movieInfo;

    private String movieNum;

    private String movieTempNum;

    private String movieActor;

    private String movieImgName;


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle == null ? null : movieTitle.trim();
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo == null ? null : movieInfo.trim();
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

    public String getMovieImgName() {
        return movieImgName;
    }

    public void setMovieImgName(String movieImgName) {
        this.movieImgName = movieImgName == null ? null : movieImgName.trim();
    }

    @Override
    public String toString() {
        return "Movie{" +
                " movieTitle='" + movieTitle + '\'' +
                ", movieInfo='" + movieInfo + '\'' +
                ", movieNum=" + movieNum +
                ", movieTempNum=" + movieTempNum +
                ", movieActor='" + movieActor + '\'' +
                ", movieImgName='" + movieImgName + '\'' +
                '}';
    }
}