package com.lemon.chen;

import com.StarupThread;
import com.lemon.chen.cache.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenhualong on 2016/11/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(StarupThread.class)
public class TestCache {



    @Autowired
    private CacheService  cacheService ;


    @Test
    public void test(){

        System.out.println(cacheService.getHelloWorld("fuck"));
        System.out.println(cacheService.getHelloWorld("fuck"));
    }
}
