package com.qq.e.ads.nativ;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i, int i2);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
