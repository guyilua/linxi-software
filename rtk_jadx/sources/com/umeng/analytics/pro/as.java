package com.umeng.analytics.pro;

/* compiled from: TApplicationException.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class as extends az {
    public static final int a = 0;
    public static final int b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1021c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final bx j = new bx("TApplicationException");
    private static final bn k = new bn("message", (byte) 11, 1);
    private static final bn l = new bn(d.y, (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public as() {
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public void b(bs bsVar) {
        bsVar.a(j);
        if (getMessage() != null) {
            bsVar.a(k);
            bsVar.a(getMessage());
            bsVar.c();
        }
        bsVar.a(l);
        bsVar.a(this.i);
        bsVar.c();
        bsVar.d();
        bsVar.b();
    }

    public static as a(bs bsVar) {
        bsVar.j();
        String str = null;
        int i = 0;
        while (true) {
            bn l2 = bsVar.l();
            byte b2 = l2.b;
            if (b2 == 0) {
                bsVar.k();
                return new as(i, str);
            }
            short s = l2.f1033c;
            if (s != 1) {
                if (s != 2) {
                    bv.a(bsVar, b2);
                } else if (b2 == 8) {
                    i = bsVar.w();
                } else {
                    bv.a(bsVar, b2);
                }
            } else if (b2 == 11) {
                str = bsVar.z();
            } else {
                bv.a(bsVar, b2);
            }
            bsVar.m();
        }
    }

    public as(int i) {
        this.i = 0;
        this.i = i;
    }

    public as(int i, String str) {
        super(str);
        this.i = 0;
        this.i = i;
    }

    public as(String str) {
        super(str);
        this.i = 0;
    }
}
