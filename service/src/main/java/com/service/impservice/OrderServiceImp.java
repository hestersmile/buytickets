package com.service.impservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moviemapper.MovieMapper;
import com.moviemapper.MoviedetailMapper;
import com.moviemapper.MovieuserMapper;
import com.moviepojo.*;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by hestersmile on 2016/12/30.
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    MoviedetailMapper moviedetailMapper;
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MovieuserMapper movieuserMapper;

    @Override
    public EUOrderGridResult getOrderListByMovieid(int id, int page, int row) {
        PageHelper.startPage(page, row);
        List<OrderList> list = moviedetailMapper.getOrderListByMovieid(id);
        EUOrderGridResult result = new EUOrderGridResult();
        result.setRows(list);
        PageInfo<OrderList> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        System.out.print("aaa" + pageInfo.getOrderBy());
        System.out.print("aaa" + pageInfo.getList());
        return result;
    }

    @Override
    public EUOrderGridResult getOrderMovieList(int page, int row) {

        PageHelper.startPage(page, row);
        List<OrderList> list = moviedetailMapper.getOrderAllList();
        EUOrderGridResult result = new EUOrderGridResult();
        result.setRows(list);
        PageInfo<OrderList> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        System.out.print("aaa" + pageInfo.getOrderBy());
        System.out.print("aaa" + pageInfo.getList());
        return result;
    }

    @Override
    public OrderList getOneOrderListDetail(int id) {

        OrderList list = moviedetailMapper.getInfoByPrimaryKey(id);
        return list;
    }

    @Override
    public EUOrderGridResult searchOrderMovieListByUsername(String title, int rows) {
        List<OrderList> list = moviedetailMapper.searchOrderInfoByUsername(title);
        PageHelper.startPage(1, rows);
        EUOrderGridResult result = new EUOrderGridResult();
        result.setRows(list);
        PageInfo<OrderList> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public int insertOrderDetail(int movieid, int userid) {
        Movie movie = movieMapper.selectByPrimaryKey(movieid);
        int tempNum = movie.getMovieTempNum();
        if (movie.getMovieTempNum() < 1) {
            return -1;
        }
        Moviedetail moviedetail = new Moviedetail();
        moviedetail.setMovieid(movieid);
        moviedetail.setUserid(userid);
        moviedetail.setOrdernum(1);
        moviedetail.setOrdertime(new Date());
        moviedetailMapper.insert(moviedetail);
        int id=moviedetail.getId();
        tempNum--;
        movie.setMovieTempNum(tempNum);
        movieMapper.updateByPrimaryKey(movie);
        return id;
    }

    @Override
    public int getOrderDetailCount(int movieid, int userid) {
        OrderMovieList orderMovieList = new OrderMovieList();
        orderMovieList.setUserid(userid);
        orderMovieList.setMovieid(movieid);
        int count =moviedetailMapper.getOrderCountByMoviedAndUserid(orderMovieList);

        return count;
    }
}
