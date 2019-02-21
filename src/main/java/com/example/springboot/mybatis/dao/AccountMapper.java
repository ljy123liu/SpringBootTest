package com.example.springboot.mybatis.dao;

import com.example.springboot.beans.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "accountMapper")
public interface AccountMapper {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(String name, double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(String name, double money, int  id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    @Results({
            @Result(property = "name",  column = "name"),
            @Result(property = "money", column = "money")
    })
    Account findAccount(int id);

    @Select("select id, name as name, money as money from account")
    @Results({
            @Result(property = "name",  column = "name"),
            @Result(property = "money", column = "money")
    })
    List<Account> findAccountList();
}
