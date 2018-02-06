package com.jk.service;

import com.jk.pojo.User;
import com.jk.service.impl.FeignServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@ FeignClient（“服务名”），来指定调用哪个服务。
//@fallback = FeignServiceImpl.class指明断路后要调用的实现类。
@FeignClient(value = "service-hi",fallback = FeignServiceImpl.class)
    public interface FeignService {
        //Feign类型的消费者controller传两个以上的参数时，接口里必须要加@RequestParam注解,生产者不需要。ribbon消费者也不需要
        @RequestMapping("/producter/hi")
        String sayHiFromProducter(@RequestParam("name") String name, @RequestParam("age") int age);

        @RequestMapping("/producter/queryUserInfo")
        User queryUserInfo(@RequestParam("userName") String userName, @RequestParam("password") String password);

         //Feign类型的消费者controller传对象到接口时，生产者接收Feign类型的消费者穿过来的对象参数时，对象参数前都必须加@RequestBody注解。
        //且Feign类型的消费者只能传一个对象，两个及以上会报错
        @RequestMapping("/producter/returnUser")
        User returnUser(@RequestBody User user);
}


