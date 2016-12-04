package com.lemon.chen.mockito;

import com.lemon.chen.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by chenhualong on 2016/12/1.
 *
 * Stubbing （桩）
 *
 */
public class UserInterfaceTest {


     UserInfoInterface  infoInterface  = mock(UserInfoInterface.class);


    @Before
    public  void setUp(){

        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void test(){

        User user = new User();

        user.setAge(1111);
        user.setUserId(1);
        user.setUserName("test");

        when(infoInterface.findUserById(anyInt())).thenReturn(user);

        verify(infoInterface).findUserById(1);

        int userId = infoInterface.findUserById(1).getUserId();

        Assert.assertEquals(1,userId);

    }
}
