package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoComplete();
}
