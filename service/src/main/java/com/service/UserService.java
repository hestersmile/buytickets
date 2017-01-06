package com.service;

import com.moviepojo.EUUserGridResult;
import com.moviepojo.Movieuser;

/**
 * Created by hestersmile on 2016/12/27.
 */
public interface UserService {
    public EUUserGridResult getAllUserInfo(int page, int rows);

    public void registerMovieUser(Movieuser movieuser);

    public boolean registerMovieUserTestName(String name);

    public EUUserGridResult searchMovieUserInfo(String str,int pagerow);

    public boolean deleteMovieUserInfo(int id);

    public Movieuser getMovieUserByID(int id);

    public Movieuser loginNormalMovieUser(String username);
}
