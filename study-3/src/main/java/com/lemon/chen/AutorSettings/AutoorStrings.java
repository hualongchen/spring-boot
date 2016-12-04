package com.lemon.chen.AutorSettings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by chenhualong on 2016/11/15.
 */

@Component
@ConfigurationProperties(prefix = "demo")    //加载配置文件中的demo开头的属性
public class AutoorStrings {


    private String name ;


    private Long  age ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }



}
