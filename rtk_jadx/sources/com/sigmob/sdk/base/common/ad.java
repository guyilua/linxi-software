package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ad extends PointEntityCommon {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f360c;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f360c;
    }

    public void c(String str) {
        this.f360c = str;
    }

    public DeviceContext getDeviceContext() {
        return com.sigmob.sdk.b.b();
    }

    public String getSdkversion() {
        return com.sigmob.sdk.base.k.k;
    }

    public boolean isAcTypeBlock() {
        if (!com.sigmob.sdk.base.f.a().i()) {
            return true;
        }
        Iterator<Integer> it = com.sigmob.sdk.base.l.a().H().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }
}
