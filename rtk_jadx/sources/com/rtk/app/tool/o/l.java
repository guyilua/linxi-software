package com.rtk.app.tool.o;

import java.io.FileInputStream;

/* compiled from: UpFileBean.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    private String a;
    private FileInputStream b;

    /* renamed from: c, reason: collision with root package name */
    private long f324c;

    public l(String str, String str2, FileInputStream fileInputStream, long j) {
        this.a = str2;
        this.b = fileInputStream;
        this.f324c = j;
    }

    public FileInputStream a() {
        return this.b;
    }

    public long b() {
        return this.f324c;
    }

    public String c() {
        return this.a;
    }
}
