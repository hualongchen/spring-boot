package com.lemon.chen.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by chenhualong on 2016/12/1.
 */
public class SimpleTest {


    /**
     * 创建mock对象不能对final，Anonymous ，primitive类进行mock
     */

    @Test
    public void testOne(){

        //创建mock对象，可以是类和接口
        List<String> list  = mock(List.class);

        //设置预期返回值
        when(list.get(0)).thenReturn("helloWorld");

        //设置读取第一个的时候抛一个异常
        when(list.get(1)).thenThrow(new RuntimeException("自己抛一个异常"));
        //另外一种链式写法
        doNothing().doThrow(new RuntimeException("自己再抛一个异常")).when(list).clear();

        //运行这个，就应该抛第一个异常
        //list.get(1);

        list.clear();
        //当第二次执行的时候，就应该抛第二个异常
        //list.clear();

        verify(list,times(1)).clear();

        //获取mock的替身值
        String result = list.get(0);

        //验证是否调用了list
        verify(list).get(0);

        //断言
        Assert.assertEquals("helloWorld",result);
    }
}
