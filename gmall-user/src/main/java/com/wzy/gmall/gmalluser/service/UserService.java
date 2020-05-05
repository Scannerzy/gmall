package com.wzy.gmall.gmalluser.service;

import com.wzy.gmall.gmalluser.pojo.UserInfo;

import java.util.List;


public interface UserService {


    /**
     * 查询
     * @return
     */
    List<UserInfo> finAll();

    /**
     * 添加
     * @param userInfo
     * @return
     */
    int insertOne(UserInfo userInfo);

    //修改

    /**
     * 修改 按照id修改
     * @param userInfo
     */
    void updataUser(UserInfo userInfo);


    /**
     * 按条件修改
     * @param userInfo
     */
    void updateUserByName(UserInfo userInfo);

    //删除

    /**
     * 按id 删除
     * @param id
     */
    void deleteUserById(String id);

    /**
     * 按条件删除
     * @param userInfo
     */
    void deleteByExample(UserInfo userInfo);


    /**
     * 按条件删除2
     * @param userInfo
     */
    void delete(UserInfo userInfo);

}
