package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NativeADEventListener {
    void onAdClicked();

    void onAdDetailDismiss();

    void onAdDetailShow();

    void onAdError(WindAdError windAdError);

    void onAdExposed();
}
