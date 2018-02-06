package com.jk.controller;

import com.jk.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/producter")
public class ProducterCloud {
    //所有有返回值的方法上边必须加@ResponseBody注解，否者值传不过去，或者不写@ResponseBody，在类名上加@RestController
    //@RestController注解等于@Controller和@ResponseBody注解。
    @Value("${cloud.provider}")//获取配置文件中的cloud.provider的属性值，并付给全局变量provider
    String provider;
    @RequestMapping("/hi")
    @ResponseBody//必须加@ResponseBody注解，负责值传不到页面。
    public String producterSayHi(String name,int age){

        return "Hello:  "+name+" my name is  "+provider+" and I am "+age+" years old ";
    }

    @RequestMapping("/queryUserInfo")
    @ResponseBody
    User queryUserInfo(String userName, String password){

        User user=new User();
        user.setUserId(1);
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    };

    @RequestMapping("/returnUser")
    @ResponseBody
    User returnUser(@RequestBody User user){
    //Feign类型的消费者传对象过来，必须要加@RequestBody 注解，否则接收不到，且传对象只能传一个。
        return user;
    };

    @RequestMapping("/returnRibbonUser")
    @ResponseBody
    public String returnRibbonUser(String name,String pass,User user){
    //ribbon类型的消费者传对象不需要加@RequestBody 注解
        user.setUserId(100);

        user.setUserName(name);

        user.setPassword(pass);

        return user.toString();
    }

}
