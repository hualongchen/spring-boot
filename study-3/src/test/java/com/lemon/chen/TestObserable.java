package com.lemon.chen;

import com.lemon.chen.observer.DemoObserable;
import com.lemon.chen.observer.DemoObserver;
import org.junit.Test;

/**
 * Created by chenhualong on 2016/11/29.
 *
 * 测试观察者
 */
public class TestObserable {


    @Test
    public  void  testObserable(){

        DemoObserable demoObserable = new DemoObserable();

        //加入观察者
        demoObserable.addObserver(new DemoObserver());

        demoObserable.demoSerable();
    }
}
