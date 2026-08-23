package com.umeng.analytics.pro;

/* compiled from: TMessage.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class bq {
    public final String a;
    public final byte b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1035c;

    public bq() {
        this("", (byte) 0, 0);
    }

    public boolean a(bq bqVar) {
        return this.a.equals(bqVar.a) && this.b == bqVar.b && this.f1035c == bqVar.f1035c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bq) {
            return a((bq) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.f1035c + ">";
    }

    public bq(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.f1035c = i;
    }
}
