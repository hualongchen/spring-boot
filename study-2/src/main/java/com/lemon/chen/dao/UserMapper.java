package com.lemon.chen.dao;

import com.lemon.chen.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by chenhualong on 2016/11/15.
 */

@Mapper
public interface UserMapper {



    @Select("SELECT * FROM mb_user where username=#{name}")
    User findByName(@Param("name") String name);


}
