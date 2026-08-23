package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface q {
    void onAdClicked(String str);

    void onAdClosed(String str);

    void onAdShow(String str);

    void onAdShowError(WindAdError windAdError, String str);

    void onVideoAdPlayComplete(String str);

    void onVideoAdPlayEnd(String str);
}
