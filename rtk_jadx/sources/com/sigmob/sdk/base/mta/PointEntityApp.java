package com.sigmob.sdk.base.mta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEntityApp extends PointEntitySigmobSuper {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f416c;
    private String d;

    public String getApp_name() {
        return this.a;
    }

    public String getApp_version() {
        return this.d;
    }

    public String getPackage_name() {
        return this.b;
    }

    public String getUpdate() {
        return this.f416c;
    }

    public void setApp_name(String str) {
        this.a = str;
    }

    public void setApp_version(String str) {
        this.d = str;
    }

    public void setPackage_name(String str) {
        this.b = str;
    }

    public void setUpdate(String str) {
        this.f416c = str;
    }
}
