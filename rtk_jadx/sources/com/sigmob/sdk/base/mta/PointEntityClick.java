package com.sigmob.sdk.base.mta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEntityClick extends PointEnitySigmobBase {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f417c;
    private String d;
    private String e;
    private String f;

    public String getClick_duration() {
        return this.b;
    }

    public String getIs_valid_click() {
        return this.f417c;
    }

    public String getLocation() {
        return this.a;
    }

    public String getPressure() {
        return this.e;
    }

    public String getTouchSize() {
        return this.f;
    }

    public String getTouchType() {
        return this.d;
    }

    public void setClick_duration(String str) {
        this.b = str;
    }

    public void setIs_valid_click(String str) {
        this.f417c = str;
    }

    public void setLocation(String str) {
        this.a = str;
    }

    public void setPressure(String str) {
        this.e = str;
    }

    public void setTouchSize(String str) {
        this.f = str;
    }

    public void setTouchType(String str) {
        this.d = str;
    }
}
