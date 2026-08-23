package com.sigmob.sdk.base.mta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEntitySigmobRequest extends PointEntitySigmob {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f420c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public String getGdpr_filters() {
        return this.f420c;
    }

    public String getInit_filters() {
        return this.h;
    }

    public String getInterval_filters() {
        return this.g;
    }

    public String getInvalid_load_count() {
        return this.b;
    }

    public String getLoad_count() {
        return this.a;
    }

    public String getLoading_filters() {
        return this.e;
    }

    public String getPlaying_filters() {
        return this.f;
    }

    public String getPldempty_filters() {
        return this.d;
    }

    public String getProguard_filters() {
        return this.i;
    }

    public void setGdpr_filters(String str) {
        this.f420c = str;
    }

    public void setInit_filters(String str) {
        this.h = str;
    }

    public void setInterval_filters(String str) {
        this.g = str;
    }

    public void setInvalid_load_count(String str) {
        this.b = str;
    }

    public void setLoad_count(String str) {
        this.a = str;
    }

    public void setLoading_filters(String str) {
        this.e = str;
    }

    public void setPlaying_filters(String str) {
        this.f = str;
    }

    public void setPldempty_filters(String str) {
        this.d = str;
    }

    public void setProguard_filters(String str) {
        this.i = str;
    }
}
