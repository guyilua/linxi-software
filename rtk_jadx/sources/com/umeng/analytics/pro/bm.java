package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TCompactProtocol.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class bm extends bs {
    private static final bx d = new bx("");
    private static final bn e = new bn("", (byte) 0, 0);
    private static final byte[] f;
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f1031c;
    private ar m;
    private short n;
    private bn o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* compiled from: TCompactProtocol.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class b {
        public static final byte a = 1;
        public static final byte b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final byte f1032c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    static {
        f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public bm(cg cgVar, long j2) {
        super(cgVar);
        this.m = new ar(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.f1031c = new byte[1];
        this.q = j2;
    }

    private int E() {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & Byte.MAX_VALUE) << i5;
                if ((u & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                j3 |= (r4 & Byte.MAX_VALUE) << i3;
                if ((f2[g + i2] & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                j2 |= (r0 & Byte.MAX_VALUE) << i2;
                if ((u() & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & bz.m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) {
        if (i2 >= 0) {
            long j2 = this.q;
            if (j2 == -1 || i2 <= j2) {
                return;
            }
            throw new bt("Length exceeded max allowed: " + i2);
        }
        throw new bt("Negative length: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bs
    public ByteBuffer A() {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bs
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bs
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bq bqVar) {
        b(h);
        d(((bqVar.b << 5) & (-32)) | 1);
        b(bqVar.f1035c);
        a(bqVar.a);
    }

    @Override // com.umeng.analytics.pro.bs
    public void b() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bs
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bs
    public void d() {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bs
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bs
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bs
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bs
    public bq h() {
        byte u = u();
        if (u == -126) {
            byte u2 = u();
            byte b2 = (byte) (u2 & j);
            if (b2 == 1) {
                return new bq(z(), (byte) ((u2 >> 5) & 3), E());
            }
            throw new bt("Expected version 1 but got " + ((int) b2));
        }
        throw new bt("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
    }

    @Override // com.umeng.analytics.pro.bs
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bs
    public bx j() {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.bs
    public void k() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bs
    public bn l() {
        short s;
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s2 = (short) ((u & 240) >> 4);
        if (s2 == 0) {
            s = v();
        } else {
            s = (short) (this.n + s2);
        }
        byte b2 = (byte) (u & bz.m);
        bn bnVar = new bn("", d(b2), s);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bnVar.f1033c;
        return bnVar;
    }

    @Override // com.umeng.analytics.pro.bs
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bs
    public bp n() {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new bp(d((byte) (u >> 4)), d((byte) (u & bz.m)), E);
    }

    @Override // com.umeng.analytics.pro.bs
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bs
    public bo p() {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new bo(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.bs
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bs
    public bw r() {
        return new bw(p());
    }

    @Override // com.umeng.analytics.pro.bs
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bs
    public boolean t() {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.bs
    public byte u() {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.f1031c, 0, 1);
        return this.f1031c[0];
    }

    @Override // com.umeng.analytics.pro.bs
    public short v() {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bs
    public int w() {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bs
    public long x() {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bs
    public double y() {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bs
    public String z() {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() >= E) {
                String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
                this.g.a(E);
                return str;
            }
            return new String(e(E), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new az("UTF-8 not supported!");
        }
    }

    /* compiled from: TCompactProtocol.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements bu {
        private final long a;

        public a() {
            this.a = -1L;
        }

        @Override // com.umeng.analytics.pro.bu
        public bs a(cg cgVar) {
            return new bm(cgVar, this.a);
        }

        public a(int i) {
            this.a = i;
        }
    }

    private void b(int i2) {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) {
        b((byte) i2);
    }

    private byte d(byte b2) {
        byte b3 = (byte) (b2 & bz.m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return bz.m;
            case 10:
                return bz.l;
            case 11:
                return bz.k;
            case 12:
                return (byte) 12;
            default:
                throw new bt("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private void b(long j2) {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.b;
        bArr[i2] = (byte) j2;
        this.g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bx bxVar) {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bn bnVar) {
        if (bnVar.b == 2) {
            this.o = bnVar;
        } else {
            a(bnVar, (byte) -1);
        }
    }

    private void b(byte b2) {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.g.b(bArr);
    }

    private void a(bn bnVar, byte b2) {
        if (b2 == -1) {
            b2 = e(bnVar.b);
        }
        short s = bnVar.f1033c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(bnVar.f1033c);
        }
        this.n = bnVar.f1033c;
    }

    public bm(cg cgVar) {
        this(cgVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bp bpVar) {
        int i2 = bpVar.f1034c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(bpVar.b) | (e(bpVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bo boVar) {
        a(boVar.a, boVar.b);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(bw bwVar) {
        a(bwVar.a, bwVar.b);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(boolean z) {
        bn bnVar = this.o;
        if (bnVar != null) {
            a(bnVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(byte b2) {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(short s) {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(int i2) {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(long j2) {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(double d2) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new az("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bs
    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
