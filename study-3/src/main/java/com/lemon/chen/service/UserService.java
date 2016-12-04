package com.lemon.chen.service;

import com.lemon.chen.bean.User;

/**
 * Created by chenhualong on 2016/11/23.
 */
public interface UserService {


    public void createUser(String userName, int age);

    public User findUserById(int userId);

    public void deleteAllUser();




}
