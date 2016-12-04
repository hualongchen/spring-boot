package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by chenhualong on 2016/11/13.
 */

@SpringBootApplication  //这个注解必须放到包的最外层，不然无法注入进去
@EnableScheduling   //启用定时任务
@EnableAsync   //为了让异步调用生效
@EnableCaching  //为了开启缓存功能
public class StarupThread {


    public static void main(String[] args) {

        SpringApplication.run(StarupThread.class,args);
    }
}
