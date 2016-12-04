package com.lemon.chen.web;

import com.lemon.chen.AutorSettings.AutoorStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhualong on 2016/11/15.
 */


@RestController
public class HelloworldController {


    public Logger  logger = LoggerFactory.getLogger(HelloworldController.class);
    /**
     * 获取配置中心的变量
     */
    @Value("${demo.name}")
    private String demoName;

    /**
     * 通过实体类的注解获取配置中心变量
     */
    @Autowired
    private AutoorStrings  autoorStrings ;


    /**
     * 通过value的形式来获取值
     * @return
     */
    @RequestMapping("/hello")
    public String helloWorld() {


        System.out.println("I can get the name is " + demoName);
        return "hello world";
    }


    /**
     * 测试注入bean的情况，来获取属性
     * @return
     */
    @RequestMapping("/world")
    public  String  helloworld2(){

        System.out.println("I can get the name from setting :"+ autoorStrings.getName());

        return "hello world";
    }

    /**
     * 进行测试日志
     * @return
     */
    @RequestMapping("/log")
    public String helloworld3(){

        logger.info("this is info");
        logger.trace("this is trace");
        logger.warn("this is warn");
        logger.error("this is error");
        logger.debug("this is debug");

        return "hello world 3";
    }



}
