package com.lemon.chen.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by chenhualong on 2016/12/1.
 */
public class ArgumentMatchTest {

    /**
     * Matchers类内加你有很多参数匹配器
     * anyInt、anyString、anyMap.....Mockito类继承于Matchers
     * Stubbing时使用内建参数匹配器
     *
     */

    @Test
    public void test() {


        List<String> list = mock(List.class);

        when(list.get(anyInt())).thenReturn("hello","world");

        String result = list.get(0)+list.get(1);

        verify(list,times(2)).get(anyInt());

        Assert.assertEquals("helloworld", result);
    }


    /**
     *
     *  注意：如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。
     */
    @Test
    public void test2(){

        Map<Integer,String> map = mock(Map.class);
        when(map.put(anyInt(),anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错
        map.put(1, "world");
        verify(map).put(eq(1), eq("world")); //eq("world")替换成"world"也会报错
    }


    public  void test3(){


    }

}
