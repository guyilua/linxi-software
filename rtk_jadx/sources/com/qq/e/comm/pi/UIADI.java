package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface UIADI extends LADI {
    void close();

    void destroy();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void show();

    void show(Activity activity);

    void showFullScreenAD(Activity activity);
}
