package com.controller;

import com.common.DefineData;
import com.common.JsonUtil;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.moviepojo.EUUserGridResult;
import com.moviepojo.LoginMovieUser;
import com.moviepojo.Movieuser;
import com.moviepojo.MovieuserTest;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hestersmile on 2016/12/29.
 */
@Controller
@RequestMapping("/getUserInfos")
public class MovieUserController {
    private Gson gson;
    @Autowired
    private UserService userService;

    @RequestMapping("/registerMovieUserTestName")
    @ResponseBody
    public Map<String, String> registerMovieUserTestName(@RequestBody MovieuserTest user,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String registerMovieUser =user.getMusername();
        System.out.print("register:"+registerMovieUser);
        Map<String, String> resultMap = new HashMap<String, String>();
        boolean flag = userService.registerMovieUserTestName(registerMovieUser);
        resultMap.put("status", flag + "");
        System.out.print(resultMap);
        return resultMap;
    }

    @RequestMapping(value = "/registerMovieUser", method = RequestMethod.POST)
    public String registerMovieUser(Movieuser user, HttpServletResponse response, HttpServletRequest request) throws Exception {
        user.setLoginType(1);
        JSONObject result = new JSONObject();
        boolean flag = true;
        try {
            userService.registerMovieUser(user);
        } catch (Exception e) {
            result.put("mess", "调用失败");
            flag = false;
            e.printStackTrace();
        }
        result.put("flag", flag);

        response.setContentType("text/html;charset=UTF-8");
        //解决跨域名访问问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (flag == true) {
            return "redirect:/";
        }
        return "redirect:/userInfo_register";

    }

    @RequestMapping(value = "/loginAdminMovieUser", method = {RequestMethod.POST,
            RequestMethod.GET}, consumes = "application/json")
    @ResponseBody
    public Map<String, String> loginMovieUser(@RequestBody LoginMovieUser loginMovieUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> resultMap = new HashMap<String, String>();
        System.out.print("111111111");
//        String username=user.getString("musername");
        String username = loginMovieUser.getMusername();
//        String password=user.getString("muserpassword");
        String password = loginMovieUser.getMuserpassword();
        try {
            Assert.notNull(username, "解锁账号为空");
            Assert.notNull(password, "解锁密码为空");

            Assert.isTrue(StringUtils.equals(username, DefineData.AdminName), "解锁账号错误");
            Assert.isTrue(StringUtils.equalsIgnoreCase(password, DefineData.AdminPassword), "解锁密码错误");

            resultMap.put("status", "success");
        } catch (Exception ex) {
            resultMap.put("status", "error");
        }
        return resultMap;
    }

    @RequestMapping(value = "/loginMovieUserForNormal", method = {RequestMethod.POST,
            RequestMethod.GET}, consumes = "application/json")
    @ResponseBody
    public Map<String, String> loginMovieUserForNormal(@RequestBody LoginMovieUser loginMovieUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        Map<String, String> resultMap = new HashMap<String, String>();
        System.out.print("111111111");
        String username = loginMovieUser.getMusername();
        String password = loginMovieUser.getMuserpassword();
        Movieuser movieuser = userService.loginNormalMovieUser(username);
        try {
            Assert.notNull(username, "解锁账号为空");
            Assert.notNull(password, "解锁密码为空");

            Assert.isTrue(StringUtils.equalsIgnoreCase(password, movieuser.getMuserpassword()), "解锁错误");

            resultMap.put("status", "success");
            resultMap.put("movieid", movieuser.getId() + "");
            session.setAttribute("userid:" + movieuser.getId(), JsonUtil.toJson(movieuser));
            System.out.println("已添加===============");
        } catch (Exception ex) {
            resultMap.put("status", "error");
        }
        return resultMap;
    }

    @RequestMapping(value = "/getMovieUserInfos", method = {RequestMethod.POST,
            RequestMethod.GET})
    @ResponseBody
    public ModelAndView getMovieUserInfos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        int page = 1;
        int rows = DefineData.PageRow;
        if (pageNum != null && !"".equals(pageNum)) {
            page = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            rows = Integer.parseInt(pageSize);
        }
        EUUserGridResult result = userService.getAllUserInfo(page, rows);
        List<Movieuser> movielist = result.getRows();
        for (Movieuser item : movielist) {
            System.out.println(item.getMusername());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movieuser> moviepagehelper = new PageInfo<Movieuser>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_user_list");

        return modelAndView;
    }

    @RequestMapping(value = "/getMovieUserInfoByID", method = RequestMethod.GET)
    public ModelAndView getMovieUserInfoByID(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String id = request.getParameter("userid");
        Movieuser user = userService.getMovieUserByID(Integer.parseInt(id));
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userdetails", user);
        modelAndView.setViewName("/admin_userInfo_detail");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMovieUserInfos", method = RequestMethod.GET)
    @ResponseBody
    public String deleteMovieUserInfos(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.print(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteMovieUserInfo(id);

        return "success";
    }

    @RequestMapping("/searchMovieUserInfos")
    public ModelAndView searchMovieUserInfos(HttpServletResponse response, HttpServletRequest request) throws Exception {

        String str = request.getParameter("searchStr");
        System.out.print(str);
        EUUserGridResult result = userService.searchMovieUserInfo(str, DefineData.PageRow);
        List<Movieuser> movielist = result.getRows();
        for (Movieuser item : movielist) {
            System.out.println(item.getMusername());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<Movieuser> moviepagehelper = new PageInfo<Movieuser>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_user_list");
        return modelAndView;
    }

}
