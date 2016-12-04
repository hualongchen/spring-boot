package com.lemon.chen.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhualong on 2016/11/15.
 */

@RestController
public class HelloController {


    @RequestMapping("/zbjcheck")
    public String  testHelloWorld(){

        return "success";
    }
}
