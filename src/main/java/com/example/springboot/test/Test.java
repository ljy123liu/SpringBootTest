package com.example.springboot.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String a(){
        return "a";
    }
}
