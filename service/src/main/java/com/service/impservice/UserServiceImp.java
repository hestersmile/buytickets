package com.service.impservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moviemapper.MovieuserMapper;
import com.moviepojo.EUUserGridResult;
import com.moviepojo.Movieuser;
import com.moviepojo.MovieuserExample;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hestersmile on 2016/12/29.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private MovieuserMapper movieuserMapper;

    @Override
    public EUUserGridResult getAllUserInfo(int page, int rows) {
        System.out.print("1111111111111111111111111111111111111111111111111111111111");
        MovieuserExample example = new MovieuserExample();
        MovieuserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Movieuser> list = movieuserMapper.selectByExample(example);
        System.out.print(list);
        EUUserGridResult result = new EUUserGridResult();
        result.setRows(list);
        PageInfo<Movieuser> pageInfo = new PageInfo<>(list);
        System.out.print("aaa" + pageInfo.getOrderBy());
        System.out.print("aaa" + pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public void registerMovieUser(Movieuser movieuser) {
        movieuserMapper.insert(movieuser);
        return ;
    }

    @Override
    public boolean registerMovieUserTestName(String name) {
        boolean result =false;
        MovieuserExample example = new MovieuserExample();
        MovieuserExample.Criteria criteria = example.createCriteria();
        criteria.andMusernameEqualTo(name);
        List<Movieuser> list = movieuserMapper.selectByExample(example);
        if (list.size()==0){
            result=true;
        }
        return result;
    }

    @Override
    public EUUserGridResult searchMovieUserInfo(String str, int pagerow) {
        List<Movieuser> list = movieuserMapper.searchMovieUserInfo(str);
        PageHelper.startPage(1, pagerow);
        EUUserGridResult result = new EUUserGridResult();
        result.setRows(list);
        PageInfo<Movieuser> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }


    @Override
    public boolean deleteMovieUserInfo(int id ) {
        movieuserMapper.deleteByPrimaryKey(id);
        return false;
    }

    @Override
    public Movieuser getMovieUserByID(int id) {
        Movieuser movie = movieuserMapper.selectByPrimaryKey(id);
        return movie;
    }

    @Override
    public Movieuser loginNormalMovieUser(String username) {
        MovieuserExample example = new MovieuserExample();
        MovieuserExample.Criteria criteria = example.createCriteria();
        criteria.andMusernameEqualTo(username);
        List<Movieuser> list = movieuserMapper.selectByExample(example);
        Movieuser movieuser=list.get(0);
        return movieuser;
    }
}
