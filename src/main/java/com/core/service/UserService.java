package com.core.service;

import com.core.po.User;

/**
 * FileName: UserService
 * Author:   刘帅
 * Date:     2019-5-15 18:08
 */
public interface UserService {
    //通过账户和密码查询用户
    public User findUser(String usercode,String password);
}
