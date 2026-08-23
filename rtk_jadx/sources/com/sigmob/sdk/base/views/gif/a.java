package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.czhj.sdk.logger.SigmobLog;
import com.umeng.analytics.pro.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    static final int a = 0;
    static final int b = 1;

    /* renamed from: c, reason: collision with root package name */
    static final int f468c = 2;
    static final int d = 3;
    static final int e = -1;
    private static final String f = "a";
    private static final int g = 4096;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static final int l = -1;
    private static final int m = -1;
    private static final int n = 4;
    private static final int o = 16384;
    private d A;
    private final int[] B;
    private byte[] C;
    private short[] D;
    private Bitmap E;
    private ByteBuffer F;
    private int G;
    private boolean H;
    private int I;
    private byte[] J;
    private byte[] K;
    private int L;
    private int M;
    private int[] p;
    private final InterfaceC0039a q;
    private byte[] r;
    private int s;
    private int t;
    private int u;
    private c v;
    private boolean w;
    private int x;
    private byte[] y;
    private int[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.base.views.gif.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0039a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        byte[] a(int i);

        int[] b(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        this(new f());
    }

    a(InterfaceC0039a interfaceC0039a) {
        this.B = new int[256];
        this.L = 0;
        this.M = 0;
        this.q = interfaceC0039a;
        this.v = new c();
    }

    a(InterfaceC0039a interfaceC0039a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0039a, cVar, byteBuffer, 1);
    }

    a(InterfaceC0039a interfaceC0039a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0039a);
        a(cVar, byteBuffer, i2);
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.G + i2; i10++) {
            byte[] bArr = this.y;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.p[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.G + i12; i13++) {
            byte[] bArr2 = this.y;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.p[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.b == r18.j) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap a(com.sigmob.sdk.base.views.gif.b r18, com.sigmob.sdk.base.views.gif.b r19) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.a(com.sigmob.sdk.base.views.gif.b, com.sigmob.sdk.base.views.gif.b):android.graphics.Bitmap");
    }

    private static void a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v30, types: [short] */
    /* JADX WARN: Type inference failed for: r1v32 */
    private void a(b bVar) {
        int i2;
        int i3;
        int i4;
        short s;
        this.M = 0;
        this.L = 0;
        if (bVar != null) {
            this.F.position(bVar.a);
        }
        if (bVar == null) {
            c cVar = this.v;
            i2 = cVar.m;
            i3 = cVar.i;
        } else {
            i2 = bVar.g;
            i3 = bVar.h;
        }
        int i5 = i2 * i3;
        byte[] bArr = this.y;
        if (bArr == null || bArr.length < i5) {
            this.y = this.q.a(i5);
        }
        if (this.D == null) {
            this.D = new short[4096];
        }
        if (this.J == null) {
            this.J = new byte[4096];
        }
        if (this.C == null) {
            this.C = new byte[o.a.a];
        }
        int s2 = s();
        int i6 = 1;
        int i7 = 1 << s2;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = s2 + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            this.D[i12] = 0;
            this.J[i12] = (byte) i12;
        }
        int i13 = -1;
        int i14 = i10;
        int i15 = i9;
        int i16 = i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        while (true) {
            if (i17 >= i5) {
                break;
            }
            if (i18 == 0) {
                i18 = r();
                if (i18 <= 0) {
                    this.I = 3;
                    break;
                }
                i19 = 0;
            }
            i21 += (this.r[i19] & 255) << i20;
            i20 += 8;
            i19 += i6;
            i18 += i13;
            int i26 = i15;
            int i27 = i14;
            int i28 = i23;
            int i29 = i24;
            while (i20 >= i27) {
                int i30 = i21 & i16;
                i21 >>= i27;
                i20 -= i27;
                if (i30 != i7) {
                    int i31 = i10;
                    if (i30 > i26) {
                        this.I = 3;
                    } else if (i30 != i8) {
                        if (i28 == -1) {
                            this.C[i25] = this.J[i30];
                            i28 = i30;
                            i29 = i28;
                            i25++;
                            i10 = i31;
                        } else {
                            if (i30 >= i26) {
                                i4 = i30;
                                this.C[i25] = (byte) i29;
                                s = i28;
                                i25++;
                            } else {
                                i4 = i30;
                                s = i4;
                            }
                            while (s >= i7) {
                                this.C[i25] = this.J[s];
                                s = this.D[s];
                                i25++;
                                i7 = i7;
                            }
                            int i32 = i7;
                            byte[] bArr2 = this.J;
                            int i33 = bArr2[s] & 255;
                            int i34 = i25 + 1;
                            int i35 = i8;
                            byte b2 = (byte) i33;
                            this.C[i25] = b2;
                            if (i26 < 4096) {
                                this.D[i26] = (short) i28;
                                bArr2[i26] = b2;
                                i26++;
                                if ((i26 & i16) == 0 && i26 < 4096) {
                                    i27++;
                                    i16 += i26;
                                }
                            }
                            i25 = i34;
                            while (i25 > 0) {
                                i25--;
                                this.y[i22] = this.C[i25];
                                i17++;
                                i22++;
                            }
                            i7 = i32;
                            i28 = i4;
                            i8 = i35;
                            i29 = i33;
                            i10 = i31;
                        }
                    }
                    i15 = i26;
                    i14 = i27;
                    i23 = i28;
                    i10 = i31;
                    i24 = i29;
                    break;
                }
                i27 = i10;
                i26 = i9;
                i16 = i11;
                i28 = -1;
            }
            i24 = i29;
            i15 = i26;
            i14 = i27;
            i23 = i28;
            i6 = 1;
            i13 = -1;
        }
        for (int i36 = i22; i36 < i5; i36++) {
            this.y[i36] = 0;
        }
    }

    private void a(int[] iArr, b bVar, int i2) {
        int i3 = bVar.h;
        int i4 = this.G;
        int i5 = i3 / i4;
        int i6 = bVar.f / i4;
        int i7 = bVar.g / i4;
        int i8 = bVar.e / i4;
        int i9 = this.t;
        int i10 = (i6 * i9) + i8;
        int i11 = (i5 * i9) + i10;
        while (i10 < i11) {
            int i12 = i10 + i7;
            for (int i13 = i10; i13 < i12; i13++) {
                iArr[i13] = i2;
            }
            i10 += this.t;
        }
    }

    private d p() {
        if (this.A == null) {
            this.A = new d();
        }
        return this.A;
    }

    private Bitmap q() {
        Bitmap a2 = this.q.a(this.t, this.s, this.w ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        a(a2);
        return a2;
    }

    private int r() {
        int s = s();
        if (s > 0) {
            try {
                if (this.r == null) {
                    this.r = this.q.a(255);
                }
                int i2 = this.M;
                int i3 = this.L;
                int i4 = i2 - i3;
                if (i4 >= s) {
                    System.arraycopy(this.K, i3, this.r, 0, s);
                    this.L += s;
                } else if (this.F.remaining() + i4 >= s) {
                    System.arraycopy(this.K, this.L, this.r, 0, i4);
                    this.L = this.M;
                    t();
                    int i5 = s - i4;
                    System.arraycopy(this.K, 0, this.r, i4, i5);
                    this.L += i5;
                } else {
                    this.I = 1;
                }
            } catch (Exception e2) {
                SigmobLog.d("Error Reading Block", e2);
                this.I = 1;
            }
        }
        return s;
    }

    private int s() {
        try {
            t();
            byte[] bArr = this.K;
            int i2 = this.L;
            this.L = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.I = 1;
            return 0;
        }
    }

    private void t() {
        if (this.M > this.L) {
            return;
        }
        if (this.K == null) {
            this.K = this.q.a(16384);
        }
        this.L = 0;
        int min = Math.min(this.F.remaining(), 16384);
        this.M = min;
        this.F.get(this.K, 0, min);
    }

    int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.v;
            if (i2 < cVar.d) {
                return cVar.e.get(i2).b;
            }
        }
        return -1;
    }

    int a(InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                SigmobLog.d("Error reading data from stream", e2);
            }
        } else {
            this.I = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                SigmobLog.d("Error closing stream", e3);
            }
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int a(byte[] bArr) {
        c c2 = p().a(bArr).c();
        this.v = c2;
        if (bArr != null) {
            a(c2, bArr);
        }
        return this.I;
    }

    synchronized void a(c cVar, ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
        int highestOneBit = Integer.highestOneBit(i2);
        this.I = 0;
        this.v = cVar;
        this.w = false;
        this.u = -1;
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.F = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.F.order(ByteOrder.LITTLE_ENDIAN);
        this.H = false;
        Iterator<b> it = cVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f469c == 3) {
                this.H = true;
                break;
            }
        }
        this.G = highestOneBit;
        int i3 = cVar.m;
        this.t = i3 / highestOneBit;
        int i4 = cVar.i;
        this.s = i4 / highestOneBit;
        this.y = this.q.a(i3 * i4);
        this.z = this.q.b(this.t * this.s);
    }

    synchronized void a(c cVar, byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.v.d <= 0) {
            return false;
        }
        if (this.u == f() - 1) {
            this.x++;
        }
        c cVar = this.v;
        int i2 = cVar.j;
        if (i2 != -1 && this.x > i2) {
            return false;
        }
        this.u = (this.u + 1) % cVar.d;
        return true;
    }

    void b() {
        this.v = null;
        byte[] bArr = this.y;
        if (bArr != null) {
            this.q.a(bArr);
        }
        int[] iArr = this.z;
        if (iArr != null) {
            this.q.a(iArr);
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            this.q.a(bitmap);
        }
        this.E = null;
        this.F = null;
        this.w = false;
        byte[] bArr2 = this.r;
        if (bArr2 != null) {
            this.q.a(bArr2);
        }
        byte[] bArr3 = this.K;
        if (bArr3 != null) {
            this.q.a(bArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i2) {
        if (i2 < -1 || i2 >= f()) {
            return false;
        }
        this.u = i2;
        return true;
    }

    int c() {
        return this.F.limit() + this.y.length + (this.z.length * 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.u;
    }

    ByteBuffer e() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.v.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.v.i;
    }

    int h() {
        return this.v.j;
    }

    int i() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        int i2;
        if (this.v.d <= 0 || (i2 = this.u) < 0) {
            return 0;
        }
        return a(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bitmap k() {
        if (this.v.d <= 0 || this.u < 0) {
            SigmobLog.d("unable to decode frame, frameCount=" + this.v.d + " framePointer=" + this.u);
            this.I = 1;
        }
        int i2 = this.I;
        if (i2 != 1 && i2 != 2) {
            this.I = 0;
            b bVar = this.v.e.get(this.u);
            int i3 = this.u - 1;
            b bVar2 = i3 >= 0 ? this.v.e.get(i3) : null;
            int[] iArr = bVar.i;
            if (iArr == null) {
                iArr = this.v.f;
            }
            this.p = iArr;
            if (iArr == null) {
                SigmobLog.d("No Valid Color Table for frame #" + this.u);
                this.I = 1;
                return null;
            }
            if (bVar.k) {
                System.arraycopy(iArr, 0, this.B, 0, iArr.length);
                int[] iArr2 = this.B;
                this.p = iArr2;
                iArr2[bVar.j] = 0;
            }
            return a(bVar, bVar2);
        }
        SigmobLog.d("Unable to decode frame, status=" + this.I);
        return null;
    }

    int l() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.v.m;
    }

    void n() {
        this.u = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.x = 0;
    }
}
