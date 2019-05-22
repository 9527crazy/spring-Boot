package com.core.service.impl;

import com.core.dao.UserMapper;
import com.core.po.User;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FileName: UserServicelmpl
 * Author:   刘帅
 * Date:     2019-5-15 18:10
 */
//用户service接口实现类
@Service("userService")
@Transactional
public class UserServicelmpl implements UserService {
    //注入UserDao
    @Autowired
    private UserMapper userMapper;
    //通过账户和密码查询用户
    @Override
    public User findUser(String usercode, String password) {
        User user=this.userMapper.findUser(usercode,password);
        return user;
    }
}
