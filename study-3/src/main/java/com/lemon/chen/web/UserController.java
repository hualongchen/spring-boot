package com.lemon.chen.web;

import com.lemon.chen.dao.bean.MbUserPO;
import com.lemon.chen.dao.mapper.MbUserPOMapper;
import com.lemon.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhualong on 2016/11/16.
 * <p>
 * 验证数据库是否配置成功
 */

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private MbUserPOMapper userPOMapper ;

    /**
     * 查询接口验证
     *
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser() {

        return userService.findUserById(1).toString();
    }


    /**
     * 删除所有用户
     *
     * @return
     */
    @RequestMapping("/delUser")
    public String delUser() {

        userService.deleteAllUser();
        return "success";
    }


    /**
     * 增加一个用户
     *
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser() {

        userService.createUser("lemon", 1);
        return "success";
    }


    /**
     * 测试mybatis整合， 这个例子是个单数据源的情况
     * @return
     */
    @RequestMapping("/mybatis")
    public String testUser(){

        return  userPOMapper.selectByPrimaryKey(1).toString();
    }


    /**
     * 这个是测试单数据源情况下的事务
     * @return
     */
    @RequestMapping("/tracation")
    @Transactional
    public String  testTrancation(){

        MbUserPO po  = new MbUserPO();

        po.setUserid(1);
        po.setAge(123);
        po.setUsername("chen");
        userPOMapper.updateByPrimaryKey(po);

        throw new RuntimeException("我是故意抛个错");
        //return "sucesss";
    }


    @RequestMapping("/tracation2")   //随便写写，不加try了
    public String  testTrancation2(){

        MbUserPO po  = new MbUserPO();

        po.setUserid(1);
        po.setAge(123);
        po.setUsername("chen");
        userPOMapper.updateByPrimaryKey(po);
        return "sucesss";
    }

}

