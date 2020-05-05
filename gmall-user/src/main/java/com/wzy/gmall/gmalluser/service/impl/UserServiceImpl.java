package com.wzy.gmall.gmalluser.service.impl;

import com.wzy.gmall.gmalluser.mapper.UserInfoMapper;
import com.wzy.gmall.gmalluser.pojo.UserInfo;
import com.wzy.gmall.gmalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> finAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int insertOne(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updataUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(UserInfo userInfo) {
        userInfo.setEmail("159");
        userInfo.setLoginName("haha");
        Example example = new Example(UserInfo.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",userInfo.getName());
        criteria.andEqualTo("email","123");
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void deleteUserById(String id) {
        userInfoMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void deleteByExample(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.deleteByExample(example);
    }

    @Override
    public void delete(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }


}
