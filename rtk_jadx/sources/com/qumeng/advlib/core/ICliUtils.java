package com.qumeng.advlib.core;

import android.os.Bundle;
import androidx.annotation.Keep;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ICliUtils {

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface BannerStateListener {
        void onADDeliveredResult(boolean z, String str);

        void onADEventTriggered(int i, Bundle bundle);

        void onADShown();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(ICliBundle iCliBundle);
    }
}
