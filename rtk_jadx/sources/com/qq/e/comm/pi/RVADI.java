package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface RVADI extends LADI {
    String getAdNetWorkName();

    @Deprecated
    long getExpireTimestamp();

    int getRewardAdType();

    int getVideoDuration();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(Activity activity);
}
