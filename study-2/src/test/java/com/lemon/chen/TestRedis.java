package com.lemon.chen;

import com.StarupThread;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenhualong on 2016/11/14.
 */


@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(StarupThread.class)
public class TestRedis {


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    public void test() throws Exception {


        redisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));

    }
}
