package com.lemon.chen.junit;

import com.MobileApplicationMain;
import com.lemon.chen.bean.User;
import com.lemon.chen.dao.mapper.MbUserPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenhualong on 2016/12/3.
 * 通用的测试步骤
 */

@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(MobileApplicationMain.class)
public class TestMain {

    @Autowired
    private MbUserPOMapper   userPOMapper ;


    @Test
    public void test() {


        System.out.println(userPOMapper.selectByPrimaryKey(1).toString());
    }
}
