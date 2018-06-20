package com.example.demo.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller控制器主要是接收浏览器请求。@Controller注解和@RestController的区别：
//（1）@Controller类中的方法可以直接通过返回String跳转到jsp、ftl、html等模版页面。在方法上加@ResponseBody注解，也可以返回实体对象。
//（2）@RestController类中的所有方法只能返回String、Object、Json等实体对象，不能跳转到模版页面；若要实现跳转到模板页面，需将返回的模板页面名称保持到ModelAndView中返回。
//（3）@RestController相当于@ResponseBody + @Controller。
// 相同点：都是用来表示Spring某个类的是否可以接收HTTP请求

/**
 * Created by Administrator on 2018-05-18.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public  String sayHello()
    {
        String hello="Return  HelloSpring Boot";

        return hello;
    }
}