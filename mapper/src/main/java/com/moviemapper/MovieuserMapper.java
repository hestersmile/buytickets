package com.moviemapper;

import com.moviepojo.Movieuser;
import com.moviepojo.MovieuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieuserMapper {
    int countByExample(MovieuserExample example);

    int deleteByExample(MovieuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Movieuser record);

    int insertSelective(Movieuser record);

    List<Movieuser> selectByExample(MovieuserExample example);

    Movieuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Movieuser record, @Param("example") MovieuserExample example);

    int updateByExample(@Param("record") Movieuser record, @Param("example") MovieuserExample example);

    int updateByPrimaryKeySelective(Movieuser record);

    int updateByPrimaryKey(Movieuser record);

    List<Movieuser> searchMovieUserInfo(String movieTitle);
}