package com.lemon.chen.mockito;

import com.zbj.mobile.api.activity.entry.activity.CreateActivityVO;
import com.zbj.mobile.api.activity.entry.activity.RefundActivityRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenhualong on 2016/12/1.
 * MOCK第三方数据，例如平台的SOA接口，或则第三方的接口
 */
public class ThreeInterfaceTest {



    @Test
    public  void testThreeInterface(){

        ThreeInterfaceMock mock = new ThreeInterfaceMock();

        ThreeInterfaceIMPL  service = new ThreeInterfaceIMPL();

        //使用替身
        service.setActivityRefundService(mock);


        CreateActivityVO vo =service.getTest(new RefundActivityRequest());

        System.out.println(vo.toString());
        Long kis = 1001L;

        Assert.assertEquals(kis,vo.getActivityId());
    }
}
