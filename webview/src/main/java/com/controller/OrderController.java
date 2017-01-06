package com.controller;

import com.common.DefineData;
import com.common.SendEMailUtil;
import com.github.pagehelper.PageInfo;
import com.moviepojo.EUOrderGridResult;
import com.moviepojo.OrderList;
import com.moviepojo.OrderMovieList;
import com.service.OrderService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hestersmile on 2016/12/30.
 */
@Controller
@RequestMapping("/getOrderInfos")

public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @RequestMapping("/getOrderListByMovieid")
    public ModelAndView getOrderListByMovieid(int id) {
        return null;
    }

    @RequestMapping("/getOrderAllList")
    public ModelAndView getOrderAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        EUOrderGridResult result = orderService.getOrderMovieList(page, rows);
        List<OrderList> movielist = result.getRows();
        for (OrderList item : movielist) {
            System.out.println(item.getMovieTitle());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<OrderList> moviepagehelper = new PageInfo<OrderList>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_order_list");

        return modelAndView;
    }

    @RequestMapping("/getOneOrderListDetail")
    public ModelAndView getOneOrderListDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mid = request.getParameter("movieid");
        ModelAndView modelAndView = new ModelAndView();
        OrderList movie1 = orderService.getOneOrderListDetail(Integer.parseInt(mid));
        System.out.print(movie1);
        modelAndView.addObject("userdetails", movie1);
        modelAndView.setViewName("/admin_orderInfo_detail");
        return modelAndView;
    }

    @RequestMapping("/getOrderAllListaByMovieID")
    public ModelAndView getOrderAllListByMovieid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int movieid = Integer.parseInt(request.getParameter("movieid"));
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
        EUOrderGridResult result = orderService.getOrderListByMovieid(movieid, page, rows);
        List<OrderList> movielist = result.getRows();
        for (OrderList item : movielist) {
            System.out.println(item.getMovieTitle());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<OrderList> moviepagehelper = new PageInfo<OrderList>(movielist);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_ordemovier_list");

        return modelAndView;
    }

    @RequestMapping("/searchOrderListByUsername")
    public ModelAndView searchOrderListByUsername(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String str = request.getParameter("searchStr");
        System.out.print(str);
        EUOrderGridResult result = orderService.searchOrderMovieListByUsername(str, DefineData.PageRow);
        List<OrderList> list = result.getRows();
        for (OrderList item : list) {
            System.out.println(item.getMusername());
        }
//        创建modelAndView准备填充数据、设置视图
        PageInfo<OrderList> moviepagehelper = new PageInfo<OrderList>(list);
        moviepagehelper.getList();
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("pagehelper", moviepagehelper);
        //视图
        modelAndView.setViewName("/admin_order_list");
        return modelAndView;
    }

    @RequestMapping("/orderMovieListByUser")
    @ResponseBody
    public Map<String, String> insertOrderDetail(@RequestBody OrderMovieList orderMovieList, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> resultMap = new HashMap<String, String>();

        int count = orderService.getOrderDetailCount(orderMovieList.getMovieid(), orderMovieList.getUserid());
        System.out.println("count:"+count);
        if (count == 2) {
            resultMap.put("orderstatus", "false");
            resultMap.put("ordermessage", "已经购买2张票，请不要重复抢票");
            return  resultMap;
        } else {
            int id=orderService.insertOrderDetail(orderMovieList.getMovieid(), orderMovieList.getUserid());
            if (id==-1){
                resultMap.put("orderstatus", "false");
                resultMap.put("ordermessage", "非常抱歉，余票不够");
            }else {
                OrderList orderList=orderService.getOneOrderListDetail(id);
                resultMap.put("orderstatus", "success");
                resultMap.put("ordermessage", "订票成功！！");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String time=sdf.format(orderList.getOrdertime());
                String address=userService.getMovieUserByID(orderList.getUserid()).getMemail();
                SendEMailUtil sendEMailUtil=new SendEMailUtil(address,orderList.getMusername(),time,orderList.getMovieTitle());
                sendEMailUtil.SendMessage();
            }
        }
        return  resultMap;
    }
//
//    @Override
//    public int getOrderDetailCount(int movieid, int userid) {
//        return 0;
//    }

}
