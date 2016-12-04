package com.lemon.chen.service.impl;

import com.lemon.chen.bean.User;
import com.lemon.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chenhualong on 2016/11/16.
 */
@Service
public class UserServiceImpl implements UserService {


    /**
     * 如果是单一数据库，直接@Autowired就可以了
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUser(String userName, int age) {

        String sql = "insert into mb_user(userid,username,age) VALUES (?,?,?)";


        //第一种塞入方法
        jdbcTemplate.update(sql, new Object[]{1, userName, age});

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
    public User findUserById(int userId) {

        final User user = new User();
        String sql = "SELECT userid, username,age from mb_user where userid=?";

        try {
            jdbcTemplate.query(sql, new Object[]{userId}, new RowCallbackHandler() {

                @Override
                public void processRow(ResultSet rs) throws SQLException {

                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setAge(rs.getInt(3));
                }
            });
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            //这类异常不用处理， 因为相当于没有这个数据而已
        }

        return user;
    }



    @Override
    public void deleteAllUser() {

        jdbcTemplate.update("delete from mb_user ");
    }
}
