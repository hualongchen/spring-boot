package com;

import com.lemon.chen.util.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by chenhualong on 2016/11/16.
 */

@SpringBootApplication  //这个注解必须放到包的最外层，不然无法注入进去,也是最开始入口
@MapperScan("com.lemon.chen.dao.mapper")//增加注解类，把mybatis注入
@Import({DynamicDataSourceRegister.class})  //进行多数据源注入
@EnableAsync  //为了让异步调用生效
@EnableCaching // 打开缓存，ecache用的
@ImportResource({"classpath:spring-dubbo-provider.xml"})
public class MobileApplicationMain {


    public static void main(String[] args) {

        SpringApplication.run(MobileApplicationMain.class, args);
    }
}
