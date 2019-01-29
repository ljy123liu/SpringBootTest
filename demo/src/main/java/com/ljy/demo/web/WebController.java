package com.ljy.demo.web;

import com.ljy.demo.web.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Value("${com.ljy.title}")
    private String title;

    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setUserName("小明");
        System.out.println(title);
        user.setPassWord(title);
        return user;
    }
}
