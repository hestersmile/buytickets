package com.moviepojo;

import java.util.Date;

public class Movie {
    private Integer id;

    private String movieTitle;

    private String movieInfo;

    private Integer movieNum;

    private Integer movieTempNum;

    private String movieActor;

    private Date movieTime;

    private String movieImg;

    private String movieImgName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(Integer movieNum) {
        this.movieNum = movieNum;
    }

    public Integer getMovieTempNum() {
        return movieTempNum;
    }

    public void setMovieTempNum(Integer movieTempNum) {
        this.movieTempNum = movieTempNum;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor == null ? null : movieActor.trim();
    }

    public Date getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Date movieTime) {
        this.movieTime = movieTime;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg == null ? null : movieImg.trim();
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
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieInfo='" + movieInfo + '\'' +
                ", movieNum=" + movieNum +
                ", movieTempNum=" + movieTempNum +
                ", movieActor='" + movieActor + '\'' +
                ", movieTime=" + movieTime +
                ", movieImg='" + movieImg + '\'' +
                ", movieImgName='" + movieImgName + '\'' +
                '}';
    }
}