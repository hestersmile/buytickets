package com.moviepojo;

import java.util.Date;

/**
 * Created by hestersmile on 2016/12/30.
 */
public class OrderMovieList {

    private Integer userid;

    private Integer movieid;

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

    @Override
    public String toString() {
        return "OrderList{" +
                "userid=" + userid +
                ", movieid=" + movieid +
                '}';
    }
}
