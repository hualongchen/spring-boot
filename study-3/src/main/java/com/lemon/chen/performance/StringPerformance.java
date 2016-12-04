package com.lemon.chen.performance;

/**
 * Created by chenhualong on 2016/11/28.
 * String 的优化
 */
public class StringPerformance {


    public static void main(String[] args) {


        String str1 = "abc";

        String str2 = "abc";

        String str3 = new String("abc") ;

        System.out.println(str1 == str2);  //true

        System.out.println(str1 == str3);  //false

        System.out.println(str1 == str3.intern());  //jvm判断重复，  如有字符串池子中有，则不会创建
    }



}
