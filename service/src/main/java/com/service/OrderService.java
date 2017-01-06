package com.service;

import com.moviepojo.EUOrderGridResult;
import com.moviepojo.OrderList;

/**
 * Created by hestersmile on 2016/12/30.
 */
public interface OrderService {
    public EUOrderGridResult getOrderListByMovieid(int id, int page, int row);//得到某个电影的所有订单

    public EUOrderGridResult getOrderMovieList(int page, int row);

    public OrderList getOneOrderListDetail(int id);//通过订单号得到具体订单信息

    public EUOrderGridResult searchOrderMovieListByUsername(String title,int rows);//通过电影名得到电影信息

    public int insertOrderDetail(int movieid,int userid);//订票通过用户id和电影id

    public int getOrderDetailCount(int movieid,int userid);//得到用户的抢票数据（超过两张不可以抢）

}
