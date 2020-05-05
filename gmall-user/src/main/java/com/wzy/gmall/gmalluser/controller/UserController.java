package com.wzy.gmall.gmalluser.controller;

import com.wzy.gmall.gmalluser.pojo.UserInfo;
import com.wzy.gmall.gmalluser.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //查找
    @RequestMapping("/findAll")
    public List<UserInfo> findAll(){
        return userService.finAll();
    }

    //增加
    @RequestMapping("/insertOne")
    public int insertOne(UserInfo userInfo){
        userInfo.setName("haha");
        userInfo.setEmail("3231@163.com");
        userInfo.setLoginName("hahahei");
        System.out.println(userInfo.getId());
        return userService.insertOne(userInfo);
    }

    //修改 id
    @RequestMapping("/updateUser")
    public String updateUser(UserInfo userInfo){

        userService.updataUser(userInfo);
        return "OK";
    }

    //修改 按name
    @RequestMapping("/updateUserByName")
    public String updateUserByName(UserInfo userInfo){
        userService.updateUserByName(userInfo);
        return "ok";
    }
    //删除

    @RequestMapping("/deleteUserById")
    public  void deleteUserById(String id){
        userService.deleteUserById(id);
    }

    @RequestMapping("/deleteUserByExampl")
    public void deleteUserByExampl(UserInfo userInfo){

        userService.deleteByExample(userInfo);
    }

    @RequestMapping("/delete")
    public void delete(UserInfo userInfo){
        userService.delete(userInfo);
    }

}
