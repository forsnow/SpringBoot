package com.xuesong.springbootrestfulcrud.controller;

import com.xuesong.springbootrestfulcrud.exception.UserNotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: Snow
 * @create: 2020-07-14 17:34
 **/
@Controller
public class HelloController {

    //这样就可以访问到templates目录下面的index.html文件了 经过thymeleaf解析器的
//    @RequestMapping({"/login.html","/"})
//    public String index(){
//        return "index";
//    }


    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExitException();
        }
        return "Hello SpringBoot";
    }

    //查出一些数据在页面展示
    @RequestMapping(value = "/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>xuesong</h1>");
        map.put("users", Arrays.asList("Danny","Frank","Merry"));
        return "success";
    }
}
