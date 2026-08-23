package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface WindNewInterstitialAdListener {
    void onInterstitialAdClicked(String str);

    void onInterstitialAdClosed(String str);

    void onInterstitialAdLoadError(WindAdError windAdError, String str);

    void onInterstitialAdLoadSuccess(String str);

    void onInterstitialAdPreLoadFail(String str);

    void onInterstitialAdPreLoadSuccess(String str);

    void onInterstitialAdShow(String str);

    void onInterstitialAdShowError(WindAdError windAdError, String str);
}
