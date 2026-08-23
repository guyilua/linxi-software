package com.sigmob.sdk.base.mta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class PointEntitySensor extends PointEnitySigmobBase {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f418c;

    public String getMotion_after() {
        return this.b;
    }

    public String getMotion_before() {
        return this.a;
    }

    public String getMotion_interval() {
        return this.f418c;
    }

    public void setMotion_after(String str) {
        this.b = str;
    }

    public void setMotion_before(String str) {
        this.a = str;
    }

    public void setMotion_interval(String str) {
        this.f418c = str;
    }
}
