package com.moviepojo;

import java.util.Date;

/**
 * Created by hestersmile on 2016/12/30.
 */
public class OrderList {
    private Integer id;

    private Integer userid;

    private Integer movieid;

    private Integer ordernum;

    private Date ordertime;

    private  String movieTitle;

    private String  musername;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", userid=" + userid +
                ", movieid=" + movieid +
                ", ordernum=" + ordernum +
                ", ordertime=" + ordertime +
                ", movieTitle='" + movieTitle + '\'' +
                ", musername='" + musername + '\'' +
                '}';
    }
}
