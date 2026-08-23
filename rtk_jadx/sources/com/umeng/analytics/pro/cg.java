package com.umeng.analytics.pro;

/* compiled from: TTransport.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class cg {
    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b();

    public void b(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2);

    public abstract void c();

    public int d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new ch("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }

    public void d() {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
