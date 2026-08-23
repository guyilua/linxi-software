package com.qq.e.comm.pi;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.ADRewardListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IReward {
    void setRewardListener(ADRewardListener aDRewardListener);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
