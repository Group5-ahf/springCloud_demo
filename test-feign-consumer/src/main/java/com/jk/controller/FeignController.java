package com.jk.controller;

import com.jk.pojo.User;
import com.jk.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于@ResponseBody+@Controller
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/hi")
    public String sayHi(String name,int age){

     return  feignService.sayHiFromProducter(name,age)+"from feign consumer";
    }

    @RequestMapping("/queryUserInfo")
    public String queryUserInfo(String userName, String password){

        return feignService.queryUserInfo(userName,password).toString();
    }

    @RequestMapping("/returnUser")
    public String returnUser(){

        User user=new User();
        user.setUserId(0);
        user.setUserName("李思");
        user.setPassword("abc");

        //只能传一个对象类型的参数，多了会报错。
        User newUser=feignService.returnUser(user);

        return newUser.toString();
    }




}
