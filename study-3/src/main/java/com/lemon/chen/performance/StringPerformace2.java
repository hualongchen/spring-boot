package com.lemon.chen.performance;

/**
 * Created by chenhualong on 2016/11/28.
 */
public class StringPerformace2 {


    /**
     * 演示subString 内存溢出
     * S
     * @param args
     */
    public static void main(String[] args) {


        String  str1 = "abcde";

        String str2 = str1.substring(1,3); //此方法存在内存溢出

    }
}
