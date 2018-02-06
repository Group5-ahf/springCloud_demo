package com.jk.controller;

import com.jk.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by scc on 2018/1/12.
 */
@RestController
@RequestMapping("ribbon")
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("doService")
    @HystrixCommand(fallbackMethod = "hiError")//@HystrixCommand开启断路器的注解。fallbackMethod指明断路后调用的方法。
    public String doService(String name, int age){
        //ribbon类型的消费者用RestTemplate对象传值，这里访问生产者可不写生产者地址，直接用生产者的名字调用对应生产者。
        //String.class返回值类型。

         return  restTemplate.getForObject("http://SERVICE-HI/producter/hi?name="+name+"&age="+age,String.class)+"from ribbon consumer";
    }

    //断路后调用的方法。参数要和实现断路的方法参数保持一致。
    public String hiError(String name, int age) {
        return "sorry ribbon！There is some error!";
    }


    @RequestMapping("returnRibbonUser")
    public String returnUser(String name, String pass){

        User user=new User();
        //ribbon类型的消费者不传对象可用第一种传值方式。传对象用第二种传值方式。
//        restTemplate.getForObject("http://SERVICE-HI/producter/returnRibbonUser?name="+name+"&pass="+pass,String.class);
        return restTemplate.postForEntity("http://SERVICE-HI/producter/returnRibbonUser?name="+name+"&pass="+pass, user, String.class).getBody();
    }

}
