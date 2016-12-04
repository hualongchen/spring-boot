package com.lemon.chen.mockito;

import com.zbj.mobile.api.activity.entry.activity.CreateActivityVO;
import com.zbj.mobile.api.activity.entry.activity.GetActivityRequest;
import com.zbj.mobile.api.activity.entry.activity.GetRefundActivityVO;
import com.zbj.mobile.api.activity.entry.activity.RefundActivityRequest;
import com.zbj.mobile.api.activity.service.activity.ActivityRefundService;
import com.zbj.mobile.common.api.MobileResultVO;

/**
 * Created by chenhualong on 2016/12/1.
 *
 * 这只是我的MOCK第三方的接口interface
 */
public class ThreeInterfaceMock implements ActivityRefundService{


    /**
     *
     * 这里我只是简单举一个例子
     * @param refundActivityRequest
     * @return
     */
    @Override
    public MobileResultVO<CreateActivityVO> createRefundActivity(RefundActivityRequest refundActivityRequest) {

        /**
         * 这里就不写refundActivityRequest 的判断了，直接给结果
         */
        MobileResultVO<CreateActivityVO>  mobileResultVO = new MobileResultVO<CreateActivityVO>();
        mobileResultVO.setResultCode(200);
        mobileResultVO.setResultMsg("success");
        CreateActivityVO   vo  = new CreateActivityVO();

        vo.setActivityId(1001L);

        mobileResultVO.setResultData(vo);

        return mobileResultVO;
    }

    @Override
    public MobileResultVO<Void> modifyRefundActivity(RefundActivityRequest refundActivityRequest) {
        return null;
    }

    @Override
    public MobileResultVO<GetRefundActivityVO> getRefundActivity(GetActivityRequest getActivityRequest) {
        return null;
    }
}
