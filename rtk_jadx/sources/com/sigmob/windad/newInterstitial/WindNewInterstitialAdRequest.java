package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindNewInterstitialAdRequest extends WindAdRequest {

    /* renamed from: c, reason: collision with root package name */
    private boolean f697c;
    private boolean d;

    public WindNewInterstitialAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.a = 6;
    }

    public boolean isEnableKeepOn() {
        return this.d;
    }

    public boolean isEnableScreenLockDisPlayAd() {
        return this.f697c;
    }

    public void setEnableKeepOn(boolean z) {
        this.d = z;
    }

    public void setEnableScreenLockDisPlayAd(boolean z) {
        this.f697c = z;
    }
}
