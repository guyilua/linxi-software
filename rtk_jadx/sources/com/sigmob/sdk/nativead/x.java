package com.sigmob.sdk.nativead;

import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface x {
    void onNativeAdLoadFail(int i, String str);

    void onNativeAdLoaded(List<WindNativeAdData> list);
}
