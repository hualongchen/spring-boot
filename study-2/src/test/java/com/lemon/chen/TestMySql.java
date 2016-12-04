package com.lemon.chen;

import com.StarupThread;
import com.lemon.chen.service.UserService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenhualong on 2016/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(StarupThread.class)
public class TestMySql {


    /**
     * swagger和spring mvc 有冲突，卧槽，这个要解决一下
     */
    @Autowired
    private UserService userService;


    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUser();
    }


    @Test
    public void test(){


        userService.createUser("chen1",22);
        userService.createUser("chen2",33);
        userService.createUser("chen3",44);
        userService.createUser("chen4",55);

    }



}
