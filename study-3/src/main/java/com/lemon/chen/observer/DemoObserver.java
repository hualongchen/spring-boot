package com.lemon.chen.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by chenhualong on 2016/11/29.
 *
 * 启用观察者模式
 */
public class DemoObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {

        DemoObserable  demoObserable  =(DemoObserable) o ;


        System.out.println("the observer data is:"+ demoObserable.demoSerable().toString());
    }
}
