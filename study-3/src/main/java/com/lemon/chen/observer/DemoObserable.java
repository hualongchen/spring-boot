package com.lemon.chen.observer;

import java.util.Observable;

/**
 * Created by chenhualong on 2016/11/29.
 */
public class DemoObserable extends Observable {


    /**
     * 开始调用业务，并通知观察者
     */
    public String demoSerable(){

        System.out.println("开始调用了业务");

        //先通知变化方
        setChanged();
        //掉用完后通知观察者
        notifyObservers();

        return "success";
    }
}
