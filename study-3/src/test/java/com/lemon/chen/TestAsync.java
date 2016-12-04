package com.lemon.chen;

import com.MobileApplicationMain;
import com.lemon.chen.AsyncTask.TaskAsync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by chenhualong on 2016/11/14.
 * <p>
 * 测试异步回调，缩短时间
 */


@RunWith(SpringJUnit4ClassRunner.class)
//加上自己的main启动类
@SpringApplicationConfiguration(MobileApplicationMain.class)
public class TestAsync {


    @Autowired
    private TaskAsync task;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.one();
        Future<String> task2 = task.two();
        Future<String> task3 = task.three();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
