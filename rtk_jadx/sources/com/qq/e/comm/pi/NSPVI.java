package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NSPVI extends LADI {
    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    @Deprecated
    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    void setDeveloperLogo(int i);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    @Deprecated
    void setSkipView(View view);

    @Deprecated
    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void showFullScreenAd(ViewGroup viewGroup);

    @Deprecated
    void zoomOutAnimationFinish();
}
