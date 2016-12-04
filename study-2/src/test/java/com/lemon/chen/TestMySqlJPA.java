package com.lemon.chen;

import com.StarupThread;
import com.lemon.chen.Repository.UserRepository;
import com.lemon.chen.service.UserService;
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
public class TestMySqlJPA {


    /**
     * 测试一把jpa,感觉也可以装逼呀！
     */
    @Autowired
    private UserRepository  repository;




    @Test
    public void test(){

        System.out.println(repository.findUser("chen2"));

    }



}
