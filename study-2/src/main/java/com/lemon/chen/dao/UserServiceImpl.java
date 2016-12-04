package com.lemon.chen.dao;

import com.lemon.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by chenhualong on 2016/11/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUser(String userName, int age) {

        String sql ="insert into mb_user(userid,username,age) VALUES (?,?,?)";


        //第一种塞入方法
        jdbcTemplate.update(sql,new Object[]{1,userName,age});

        //第二种塞入方法
        jdbcTemplate.update(sql, 1, userName, age);

        //第三种塞入方法

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {


                preparedStatement.setInt(1, 2222);
                preparedStatement.setString(2, "lemon");
                preparedStatement.setInt(3, 44);
            }
        });

    }

    @Override
    public void deleteByName(String userName) {

        jdbcTemplate.update("delete from mb_user where username = ?", userName);
    }

    @Override
    public int getAllUsers() {

        return jdbcTemplate.queryForObject("select count(1) from mb_user", Integer.class);
    }

    @Override
    public void deleteAllUser() {

        jdbcTemplate.update("delete from mb_user ");
    }


}
