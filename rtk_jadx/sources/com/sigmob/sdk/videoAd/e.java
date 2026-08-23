package com.sigmob.sdk.videoAd;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f652c;
    private String title;

    public e(String str, String str2, String str3, String str4) {
        this.title = str;
        this.a = str2;
        this.b = str3;
        this.f652c = str4;
    }

    public String a() {
        return this.title;
    }

    public void a(String str) {
        this.title = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.f652c;
    }

    public void d(String str) {
        this.f652c = str;
    }

    public String toString() {
        return "DialogConfig{title='" + this.title + "', context='" + this.a + "', cancelTxt='" + this.b + "', closeTxtl='" + this.f652c + "'}";
    }
}
