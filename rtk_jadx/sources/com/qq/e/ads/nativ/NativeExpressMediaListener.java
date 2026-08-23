package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NativeExpressMediaListener {
    void onVideoCached(NativeExpressADView nativeExpressADView);

    void onVideoComplete(NativeExpressADView nativeExpressADView);

    void onVideoError(NativeExpressADView nativeExpressADView, AdError adError);

    void onVideoInit(NativeExpressADView nativeExpressADView);

    void onVideoLoading(NativeExpressADView nativeExpressADView);

    void onVideoPageClose(NativeExpressADView nativeExpressADView);

    void onVideoPageOpen(NativeExpressADView nativeExpressADView);

    void onVideoPause(NativeExpressADView nativeExpressADView);

    void onVideoReady(NativeExpressADView nativeExpressADView, long j);

    void onVideoStart(NativeExpressADView nativeExpressADView);
}
