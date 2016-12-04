package com.lemon.chen;

import com.StarupThread;
import com.lemon.chen.AsyncTask.TaskAsync;
import com.lemon.chen.bean.User;
import com.lemon.chen.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by chenhualong on 2016/11/14.
 * <p>
 * 测试异步回调，缩短时间
 */


@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(StarupThread.class)
public class TestMybatis {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {

        User user = userMapper.findByName("aaa");

        System.out.println(user.toString());
    }

}
