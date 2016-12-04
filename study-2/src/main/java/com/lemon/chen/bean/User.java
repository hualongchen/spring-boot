package com.lemon.chen.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chenhualong on 2016/11/13.
 * 这块的实体类要和数据库的每一个字段都要对应上，不然就是错错错
 */
@Entity
@Table(name="mb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "userid")
    private  long id ;

    @Column(name = "username" ,nullable = false)
    private String userName ;

    @Column(name = "age")
    private int age ;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "LemonForm{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
