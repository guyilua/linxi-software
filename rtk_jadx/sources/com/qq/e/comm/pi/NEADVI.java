package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NEADVI extends LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
