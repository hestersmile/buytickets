package com.controller;

import com.common.CookieUtils;
import com.common.DefineData;
import com.common.JsonUtil;
import com.github.pagehelper.PageInfo;
import com.google.gson.reflect.TypeToken;
import com.moviepojo.EUMovieGridResult;
import com.moviepojo.Movie;
import com.moviepojo.Movieuser;
import com.moviepojo.UpdateMovie;
import com.myredis.InitRedisClient;
import com.myredis.JedisClientSingimp;
import com.service.MovieService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hestersmile on 2016/12/21.
 */
@Controller
@RequestMapping("/getMovieInfos")
public class MovieInfoController {
    @Autowired
    private MovieService movieService;
    private JedisClientSingimp jedisClient = new JedisClientSingimp();
    private InitRedisClient initRedisClient;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("执行了InitBinder方法");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Movie> getMovieShowingInfo() {
        List<Movie> movieinfos = movieService.getMovieAllInfo();
        return movieinfos;
    }

    @RequestMapping(value = "/getShowingMovie", method = {RequestMethod.POST,
            RequestMethod.GET})
    @ResponseBody
    public ModelAndView getItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
//从缓存中取内容
        int page = 1;
        int rows = DefineData.PageRow;
        if (pageNum != null && !"".equals(pageNum)) {
            page = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            rows = Integer.parseInt(pageSize);
        }
        try {
            initRedisClient = new InitRedisClient();
            Jedis jedis = initRedisClient.getJedis();
            String result = jedis.hget(DefineData.MOVIE_GET_INGO_BY_PAGE, "movieid:" + page);
            jedis.close();
            if (!StringUtils.isBlank(result)) {
                //把字符串转换成list
                PageInfo<Movie> resultList = JsonUtil.fromJson(result, new TypeToken<PageInfo<Movie>>() {
                }.getType());
                ModelAndView modelAndView = new ModelAndView();
                //填充数据
                modelAndView.addObject("pagehelper", resultList);
                //视图
                modelAndView.setViewName("/admin_movie_list");
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EUMovieGridResult result = movieService.getMovieAllInfoByPage(page, rows);
        List<Movie> movielist = result.getRows();
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movie> moviepagehelper = new PageInfo<Movie>(movielist);
        //向缓存中添加内容
        try {
            //把list转换成字符串
            String cacheString = JsonUtil.toJson(moviepagehelper);
            System.out.println("我是cache++++++++++++++++++" + cacheString);
            initRedisClient = new InitRedisClient();
            Jedis jedis = initRedisClient.getJedis();
            jedis.hset(DefineData.MOVIE_GET_INGO_BY_PAGE, "movieid:" + page, cacheString);
            jedis.expire(DefineData.MOVIE_GET_INGO_BY_PAGE, 20);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_movie_list");

        return modelAndView;
    }

    /**
     * 用户购票电影列表
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getShowingMovieListForUser", method = {RequestMethod.POST,
            RequestMethod.GET})
    @ResponseBody
    public ModelAndView getItemListForUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        String userid = request.getParameter("userid");
        Movieuser movieuser = new Movieuser();
        String string = (String) session.getAttribute("userid:" + userid);

        movieuser = JsonUtil.fromJson(string, new TypeToken<Movieuser>() {
        }.getType());
//从缓存中取内容

        int page = 1;
        int rows = DefineData.PageRowForUser;
        if (pageNum != null && !"".equals(pageNum)) {
            page = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            rows = Integer.parseInt(pageSize);
        }
        try {
            initRedisClient = new InitRedisClient();
            Jedis jedis = initRedisClient.getJedis();
            String result = jedis.hget(DefineData.MOVIE_ORDER_BY_USER_FOR_USER, "movieid:" + page);
            jedis.close();
            if (!StringUtils.isBlank(result)) {
                //把字符串转换成list
                PageInfo<Movie> resultList = JsonUtil.fromJson(result, new TypeToken<PageInfo<Movie>>() {
                }.getType());
                ModelAndView modelAndView = new ModelAndView();
                //填充数据
                modelAndView.addObject("pagehelper", resultList);
                modelAndView.addObject("movieuser", movieuser);
                //视图
                modelAndView.setViewName("/movielist");
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EUMovieGridResult result = movieService.getMovieAllInfoByPage(page, rows);
        List<Movie> movielist = result.getRows();
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movie> moviepagehelper = new PageInfo<Movie>(movielist);
        //向缓存中添加内容
        try {
            //把list转换成字符串
            String cacheString = JsonUtil.toJson(moviepagehelper);
            initRedisClient = new InitRedisClient();
            Jedis jedis = initRedisClient.getJedis();
            jedis.hset(DefineData.MOVIE_ORDER_BY_USER_FOR_USER, "movieid:" + page, cacheString);
//            jedis.expire("movieid:" + page, 30);
            jedis.expire(DefineData.MOVIE_ORDER_BY_USER_FOR_USER, 10);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        modelAndView.addObject("movieuser", movieuser);
        //视图
        modelAndView.setViewName("/movielist");

        return modelAndView;
    }

    @RequestMapping(value = "/getMovieDetails", method = RequestMethod.GET)
    public ModelAndView getMovieDetails(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String id = request.getParameter("movieid");
        Movie movie = movieService.getMovieDetails(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("moviedetails", movie);
        modelAndView.setViewName("/admin_movieInfo_detail");
        return modelAndView;
    }

    @RequestMapping(value = "/getUpdateMovieDetails", method = RequestMethod.GET)
    public ModelAndView getMovieUpdateDetails(HttpServletResponse response, HttpServletRequest request) throws Exception {

        String mid = request.getParameter("movieid");
        ModelAndView modelAndView = new ModelAndView();
        Movie movie1 = movieService.getMovieDetails(Integer.parseInt(mid));
        System.out.print(movie1);
        modelAndView.addObject("moviedetails", movie1);
        modelAndView.setViewName("/admin_movieInfo_update");
        return modelAndView;
    }

    @RequestMapping(value = "/getUpdateMovieDetailsForUser", method = RequestMethod.GET)
    public ModelAndView getMovieUpdateDetailsForUser(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        Movieuser movieuser = new Movieuser();
        String userid = request.getParameter("userid");
        String string = (String) session.getAttribute("userid:" + userid);
        movieuser = JsonUtil.fromJson(string, new TypeToken<Movieuser>() {
        }.getType());
        String mid = request.getParameter("movieid");
        ModelAndView modelAndView = new ModelAndView();
        Movie movie = movieService.getMovieDetails(Integer.parseInt(mid));
        System.out.print(movieuser);
        modelAndView.addObject("moviedetails", movie);
        modelAndView.addObject("movieuser", movieuser);
        modelAndView.setViewName("/moviebuy");
        return modelAndView;
    }



    @RequestMapping(value = "/serachMovieInfos", method = RequestMethod.GET)
    public ModelAndView searchMovieDetails(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String str = request.getParameter("searchStr");
        System.out.print(str);
        EUMovieGridResult result = movieService.getMovieInfoBySearch(str, DefineData.PageRow);
        List<Movie> movielist = result.getRows();
        for (Movie item : movielist) {
            System.out.println(item.getMovieTitle());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movie> moviepagehelper = new PageInfo<Movie>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_movie_list");
        return modelAndView;
    }

    @RequestMapping(value = "/serachMovieInfosForUser", method = RequestMethod.GET)
    public ModelAndView serachMovieInfosForUser(HttpSession session,HttpServletResponse response, HttpServletRequest request) throws Exception {
        String str = request.getParameter("searchStr");
        String userid = request.getParameter("userid");
        Movieuser movieuser = new Movieuser();
        String string = (String) session.getAttribute("userid:" + userid);

        movieuser = JsonUtil.fromJson(string, new TypeToken<Movieuser>() {
        }.getType());
        System.out.print(str);
        EUMovieGridResult result = movieService.getMovieInfoBySearch(str, DefineData.PageRow);
        List<Movie> movielist = result.getRows();
        for (Movie item : movielist) {
            System.out.println(item.getMovieTitle());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movie> moviepagehelper = new PageInfo<Movie>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        modelAndView.addObject("movieuser", movieuser);
        //视图
        modelAndView.setViewName("/movielist");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadMovieInfos", method = RequestMethod.POST)
    public String uploadItemList(UpdateMovie movie, @RequestParam(value = "movieTime") Date movieDate, @RequestParam(value = "movieImg") MultipartFile img, HttpServletResponse response, HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        boolean flag = true;
        try {
            movieService.UploadMyPic(img, result);
            String url = result.getString("resultStr");
            Movie updatemovie = new Movie();
            updatemovie.setMovieTitle(movie.getMovieTitle());
            updatemovie.setMovieInfo(movie.getMovieInfo());
            updatemovie.setMovieNum(Integer.parseInt(movie.getMovieNum()));
            updatemovie.setMovieTempNum(Integer.parseInt(movie.getMovieNum()));
            updatemovie.setMovieImg(url);
            updatemovie.setMovieActor(movie.getMovieActor());
            updatemovie.setMovieTime(movieDate);
            updatemovie.setMovieImgName(movie.getMovieImgName());
            int id = movieService.insertMovieInfo(updatemovie);
            if (id >= 0) {
                flag = true;
            }

        } catch (Exception e) {
            result.put("mess", "调用失败");
            flag = false;
            e.printStackTrace();
        }
        result.put("flag", flag);

        response.setContentType("text/html;charset=UTF-8");
        //解决跨域名访问问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelAndView modelAndView = new ModelAndView();
        if (flag == true) {
            return "redirect:/getMovieInfos/getShowingMovie";
        }
        return "redirect:/admin_movieInfo_add";
    }

    @RequestMapping(value = "/deleteMovieInfos", method = RequestMethod.GET)
    @ResponseBody
    public int deleteMovieDetails(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.print(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        movieService.deleteMovieInfo(id);
        return 1;
    }

    @RequestMapping(value = "/updateMovieInfos", method = RequestMethod.POST)
    public String updateMovieDetails(UpdateMovie movie, @RequestParam(value = "movieTime") Date movieDate, @RequestParam(value = "id") int id, @RequestParam(value = "movieImg") MultipartFile img, HttpServletResponse response, HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        boolean flag = true;
        try {
            movieService.UploadMyPic(img, result);
            String url = result.getString("resultStr");
            Movie updatemovie = new Movie();
            updatemovie.setId(id);
            updatemovie.setMovieTitle(movie.getMovieTitle());
            updatemovie.setMovieInfo(movie.getMovieInfo());
            updatemovie.setMovieNum(Integer.parseInt(movie.getMovieNum()));
            updatemovie.setMovieTempNum(Integer.parseInt(movie.getMovieNum()));
            updatemovie.setMovieImg(url);
            updatemovie.setMovieActor(movie.getMovieActor());
            updatemovie.setMovieTime(movieDate);
            updatemovie.setMovieImgName(movie.getMovieImgName());
            flag = movieService.updateMovieInfo(updatemovie);

        } catch (Exception e) {
            result.put("mess", "调用失败");
            flag = false;
            e.printStackTrace();
        }
        result.put("flag", flag);

        response.setContentType("text/html;charset=UTF-8");
        //解决跨域名访问问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        ModelAndView modelAndView = new ModelAndView();
        if (flag == true) {
            return "redirect:/getMovieInfos/getShowingMovie";
        }
        return "redirect:/admin_movieInfo_add";
    }
}
