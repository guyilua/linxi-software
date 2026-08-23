package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;

@Deprecated
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setAdSize(int i, int i2);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
