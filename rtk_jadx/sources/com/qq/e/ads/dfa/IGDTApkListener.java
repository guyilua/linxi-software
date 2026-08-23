package com.qq.e.ads.dfa;

import com.qq.e.comm.util.AdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IGDTApkListener {
    void onApkLoad(GDTApk gDTApk);

    void onError(AdError adError);
}
