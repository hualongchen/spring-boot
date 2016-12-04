package com.lemon.chen.service;

/**
 * Created by chenhualong on 2016/11/13.
 */
public interface UserService {

    public void createUser(String userName,int age );

    public void deleteByName(String userName);

    public  int getAllUsers();

    public void deleteAllUser();
}
