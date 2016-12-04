package com.lemon.chen.dubbo.service;

import com.lemon.chen.dao.bean.MbUserPO;
import com.lemon.chen.dao.mapper.MbUserPOMapper;
import com.lemon.chen.dubbo.api.UserInfoAPI;
import com.lemon.chen.util.datasource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenhualong on 2016/11/29.
 * dubbo例子
 */
@Service
public class UserInfoBIZ implements UserInfoAPI {



    @Autowired
    private MbUserPOMapper  userPOMapper ;


    @TargetDataSource(name="ds1")
    @Override
    public MbUserPO getUserInfoById(Integer userId){

        return userPOMapper.selectByPrimaryKey(userId);
    }
}
