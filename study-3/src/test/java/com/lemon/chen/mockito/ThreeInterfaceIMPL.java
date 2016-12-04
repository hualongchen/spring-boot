package com.lemon.chen.mockito;

import com.zbj.mobile.api.activity.entry.activity.CreateActivityVO;
import com.zbj.mobile.api.activity.entry.activity.RefundActivityRequest;
import com.zbj.mobile.api.activity.service.activity.ActivityRefundService;

/**
 * Created by chenhualong on 2016/12/1.
 */
public class ThreeInterfaceIMPL {



    private ActivityRefundService  activityRefundService ;


    public void setActivityRefundService(ActivityRefundService activityRefundService) {
        this.activityRefundService = activityRefundService;
    }

    public CreateActivityVO  getTest(RefundActivityRequest  request){

        return activityRefundService.createRefundActivity(request).getResultData();
    }
}
