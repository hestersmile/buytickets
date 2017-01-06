package com.service;

import com.moviepojo.EUMovieGridResult;
import com.moviepojo.Movie;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by hestersmile on 2016/12/20.
 */

public interface MovieService {

    public List<Movie> getMovieAllInfo();

    public EUMovieGridResult getMovieAllInfoByPage(int page, int rows);

    public boolean UploadMyPic(MultipartFile file, JSONObject params) throws IOException;

    public int insertMovieInfo(Movie movie);

    public boolean updateMovieInfo(Movie movie);

    public Movie getMovieDetails(int id);

    public void deleteMovieInfo(int id);

    public  EUMovieGridResult  getMovieInfoBySearch(String string,int size);


}
