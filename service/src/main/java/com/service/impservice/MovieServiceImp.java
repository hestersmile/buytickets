package com.service.impservice;

import com.common.DefineData;
import com.moviemapper.MovieMapper;
import com.moviepojo.EUMovieGridResult;
import com.common.DateUtil;
import com.common.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moviepojo.Movie;
import com.moviepojo.MovieExample;
import com.service.MovieService;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by hestersmile on 2016/12/21.
 */
@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getMovieAllInfo() {
        //TbItem item = itemMapper.selectByPrimaryKey(itemId);
        //添加查询条件
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        criteria.andMovieTempNumGreaterThan(0);
        List<Movie> list = movieMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;

    }

    @Override
    public EUMovieGridResult getMovieAllInfoByPage(int page, int rows) {
        MovieExample example = new MovieExample();
        PageHelper.startPage(page, rows);
        List<Movie> list = movieMapper.selectByExample(example);
        EUMovieGridResult result = new EUMovieGridResult();
        result.setRows(list);
        PageInfo<Movie> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        System.out.print("aaa" + pageInfo.getOrderBy());
        System.out.print("aaa" + pageInfo.getList());
        return result;

    }

    @Override
    public boolean UploadMyPic(MultipartFile file, JSONObject params) throws IOException {
        //过滤合法的文件类型
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String allowSuffixs = "gif,jpg,jpeg,bmp,png,ico";
        if (allowSuffixs.indexOf(suffix) == -1) {
            params.put("resultStr", "not support the file type!");
            return false;
        }
        //创建新目录
        String uri = File.separator + DateUtil.getNowDateStr(File.separator);
        File dir = new File(DefineData.LocalUploadPath + uri);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //创建新文件
        String newFileName = StringUtil.getUniqueFileName();
        File f = new File(dir.getPath() + File.separator + newFileName + "." + suffix);
        //将输入流中的数据复制到新文件
        FileUtils.copyInputStreamToFile(file.getInputStream(), f);

        params.put("resultStr", DefineData.NgnixPath + uri.replace("\\", "/") + "/" + newFileName + "." + suffix);

        return true;
    }

    @Override
    public boolean updateMovieInfo(Movie movie) {
        movieMapper.updateByPrimaryKey(movie);
        return true;
    }

    @Override
    public int insertMovieInfo(Movie movie) {
        movieMapper.insert(movie);
        int movieid = movie.getId();
        return movieid;
    }

    @Override
    public Movie getMovieDetails(int id) {
        Movie movie = movieMapper.selectByPrimaryKey(id);
        return movie;
    }

    @Override
    public void deleteMovieInfo(int id) {
        movieMapper.deleteByPrimaryKey(id);
    }

    @Override
    public EUMovieGridResult getMovieInfoBySearch(String string,int rows) {
        List<Movie> list = movieMapper.searchMovieInfo(string);
        PageHelper.startPage(1, rows);
        EUMovieGridResult result = new EUMovieGridResult();
        result.setRows(list);
        PageInfo<Movie> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }


}
