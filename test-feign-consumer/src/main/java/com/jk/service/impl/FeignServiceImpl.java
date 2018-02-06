package com.jk.service.impl;

import com.jk.pojo.User;
import com.jk.service.FeignService;
import org.springframework.stereotype.Component;

@Component//和@controller,@Service,@Repository一样
public class FeignServiceImpl implements FeignService {


    public String sayHiFromProducter(String name, int age) {


        return "sorry feign hi error!";
    }

    public User queryUserInfo(String userName, String password) {
        return null;
    }

    public User returnUser(User user) {
        return null;
    }
}
