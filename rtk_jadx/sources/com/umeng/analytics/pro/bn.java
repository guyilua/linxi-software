package com.umeng.analytics.pro;

/* compiled from: TField.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class bn {
    public final String a;
    public final byte b;

    /* renamed from: c, reason: collision with root package name */
    public final short f1033c;

    public bn() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bn bnVar) {
        return this.b == bnVar.b && this.f1033c == bnVar.f1033c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f1033c) + ">";
    }

    public bn(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.f1033c = s;
    }
}
