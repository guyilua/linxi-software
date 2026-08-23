package com.sigmob.windad.Splash;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindSplashAdRequest extends WindAdRequest {

    /* renamed from: c, reason: collision with root package name */
    private int f691c;
    private boolean d;

    public WindSplashAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f691c = 5;
        this.d = false;
        this.a = 2;
    }

    public int getFetchDelay() {
        int i = this.f691c;
        if (i < 3) {
            return 3;
        }
        return i;
    }

    public boolean isDisableAutoHideAd() {
        return this.d;
    }

    public void setDisableAutoHideAd(boolean z) {
        this.d = z;
    }

    public void setFetchDelay(int i) {
        this.f691c = i;
    }
}
