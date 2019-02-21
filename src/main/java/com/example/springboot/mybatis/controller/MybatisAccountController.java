package com.example.springboot.mybatis.controller;

import com.example.springboot.beans.Account;
import com.example.springboot.mybatis.service.MybatisAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MybatisAccountController {

    @Autowired
    MybatisAccountService mybatisAccountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return mybatisAccountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return mybatisAccountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {

        int t= mybatisAccountService.update(name,money,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= mybatisAccountService.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        int t= mybatisAccountService.add(name,money);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }
}
