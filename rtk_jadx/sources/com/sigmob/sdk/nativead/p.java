package com.sigmob.sdk.nativead;

import android.content.Context;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.natives.WindNativeAdData;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p extends j {
    z g;

    public p(Context context) {
        super(context);
    }

    public void a(z zVar) {
        this.g = zVar;
    }

    @Override // com.sigmob.sdk.nativead.j
    public void c() {
        super.c();
        this.g = null;
    }

    public void e() {
    }

    public c getAdConfig() {
        z zVar = this.g;
        if (zVar != null) {
            return zVar.x();
        }
        return null;
    }

    public BaseAdUnit getAdUnit() {
        z zVar = this.g;
        if (zVar != null) {
            return zVar.k();
        }
        return null;
    }

    public k getAppInfoView() {
        z zVar = this.g;
        if (zVar != null) {
            return zVar.m();
        }
        return null;
    }

    public WindNativeAdData getNativeAdUnit() {
        z zVar = this.g;
        if (zVar != null) {
            return zVar.l();
        }
        return null;
    }

    public double getVideoDuration() {
        return 0.0d;
    }

    public double getVideoProgress() {
        return 0.0d;
    }

    public void i() {
    }

    public void j() {
    }

    public void setUIStyle(g gVar) {
        this.d = gVar;
    }
}
