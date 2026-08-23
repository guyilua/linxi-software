package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: FieldValueMetaData.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class bg implements Serializable {
    private final boolean a;
    public final byte b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1027c;
    private final boolean d;

    public bg(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.f1027c = null;
        this.d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.f1027c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }

    public bg(byte b) {
        this(b, false);
    }

    public bg(byte b, String str) {
        this.b = b;
        this.a = true;
        this.f1027c = str;
        this.d = false;
    }
}
