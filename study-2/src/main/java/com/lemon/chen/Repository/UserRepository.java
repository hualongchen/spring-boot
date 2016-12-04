package com.lemon.chen.Repository;

import com.lemon.chen.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by chenhualong on 2016/11/13.
 */
public interface UserRepository extends JpaRepository<User,Integer> {




    /**
     * 利用的hibernate的映射，所以这里填写实体类即可
     * @param userName
     * @return
     */
    @Query("from User user where user.userName=:userName")
    User  findUser(@Param("userName") String userName);
}
