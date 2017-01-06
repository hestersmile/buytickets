package com.moviemapper;

import com.moviepojo.OrderList;
import com.moviepojo.Moviedetail;
import com.moviepojo.MoviedetailExample;
import java.util.List;

import com.moviepojo.OrderMovieList;
import org.apache.ibatis.annotations.Param;

public interface MoviedetailMapper {
    int countByExample(MoviedetailExample example);

    int deleteByExample(MoviedetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Moviedetail record);

    int insertSelective(Moviedetail record);

    List<Moviedetail> selectByExample(MoviedetailExample example);

    Moviedetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Moviedetail record, @Param("example") MoviedetailExample example);

    int updateByExample(@Param("record") Moviedetail record, @Param("example") MoviedetailExample example);

    int updateByPrimaryKeySelective(Moviedetail record);

    int updateByPrimaryKey(Moviedetail record);

    List<OrderList> getOrderAllList();

    List<OrderList> getOrderListByMovieid(int movieid);

    OrderList getInfoByPrimaryKey(int movieid);

    List<OrderList> searchOrderInfoByUsername(String name);

    int getOrderCountByMoviedAndUserid(OrderMovieList orderMovieList);
}