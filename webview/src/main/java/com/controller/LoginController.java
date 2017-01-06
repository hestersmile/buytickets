package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hestersmile on 2016/12/22.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String getLoginIndex(){
        return "login";
    }

    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page) {
        return page;
    }

}
