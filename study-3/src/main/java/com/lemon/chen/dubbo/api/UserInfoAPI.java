package com.lemon.chen.dubbo.api;

import com.lemon.chen.bean.User;
import com.lemon.chen.dao.bean.MbUserPO;

/**
 * Created by chenhualong on 2016/11/29.
 */
public interface UserInfoAPI {

    public MbUserPO  getUserInfoById(Integer userId);



}
