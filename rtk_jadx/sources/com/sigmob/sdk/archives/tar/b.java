package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends com.sigmob.sdk.archives.c {
    private static final int b = 256;

    /* renamed from: c, reason: collision with root package name */
    private static final int f344c = 8192;
    protected final d a;
    private boolean d;
    private long e;
    private long f;
    private byte[] g;
    private a h;

    public b(InputStream inputStream) {
        this(inputStream, d.b, 512);
    }

    public b(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public b(InputStream inputStream, int i, int i2) {
        this.a = new d(inputStream, i, i2);
        this.g = null;
        this.d = false;
    }

    public static boolean a(byte[] bArr, int i) {
        if (i < 265) {
            return false;
        }
        if (com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, e.n, 6) && com.sigmob.sdk.archives.utils.a.a(e.V, bArr, e.p, 2)) {
            return true;
        }
        if (com.sigmob.sdk.archives.utils.a.a(e.W, bArr, e.n, 6) && (com.sigmob.sdk.archives.utils.a.a(e.X, bArr, e.p, 2) || com.sigmob.sdk.archives.utils.a.a(e.Y, bArr, e.p, 2))) {
            return true;
        }
        return com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, e.n, 6) && com.sigmob.sdk.archives.utils.a.a(e.aa, bArr, e.p, 2);
    }

    private byte[] h() {
        if (this.d) {
            return null;
        }
        byte[] d = this.a.d();
        if (d == null || this.a.a(d)) {
            this.d = true;
        }
        if (this.d) {
            return null;
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        r5 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r7 = r0.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r7 == (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r7 != 61) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
    
        r5.append((char) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r5 = r5.toString();
        r4 = r4 - r3;
        r3 = new char[r4];
        r8 = r0.read(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r8 != r4) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r1.put(r5, new java.lang.String(r3, 0, r4 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0063, code lost:
    
        throw new java.io.IOException("Failed to read Paxheader. Expected " + r4 + " chars, read " + r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.archives.tar.b.i():void");
    }

    private void j() {
        byte[] h;
        if (!this.h.m()) {
            return;
        }
        do {
            h = h();
            if (this.d) {
                this.h = null;
                return;
            }
        } while (new c(h).a());
    }

    @Override // com.sigmob.sdk.archives.c
    public com.sigmob.sdk.archives.a a() {
        return e();
    }

    protected final void a(a aVar) {
        this.h = aVar;
    }

    protected final void a(boolean z) {
        this.d = z;
    }

    @Override // com.sigmob.sdk.archives.c
    public boolean a(com.sigmob.sdk.archives.a aVar) {
        if (aVar instanceof a) {
            return !((a) aVar).o();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.e;
        long j2 = this.f;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.h();
    }

    public int d() {
        return this.a.b();
    }

    public a e() {
        if (this.d) {
            return null;
        }
        if (this.h != null) {
            long j = this.e;
            long j2 = this.f;
            do {
                j -= j2;
                if (j > 0) {
                    j2 = skip(j);
                } else {
                    this.g = null;
                }
            } while (j2 > 0);
            throw new RuntimeException("failed to skip current tar entry");
        }
        byte[] h = h();
        if (this.d) {
            this.h = null;
            return null;
        }
        a aVar = new a(h);
        this.h = aVar;
        this.f = 0L;
        this.e = aVar.b();
        if (this.h.p()) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[256];
            while (true) {
                int read = read(bArr);
                if (read < 0) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
            a();
            if (this.h == null) {
                return null;
            }
            if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.h.a(stringBuffer.toString());
        }
        if (this.h.q()) {
            i();
        }
        if (this.h.o()) {
            j();
        }
        return this.h;
    }

    protected final a f() {
        return this.h;
    }

    protected final boolean g() {
        return this.d;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.f;
        long j2 = this.e;
        if (j >= j2) {
            return -1;
        }
        if (i2 + j > j2) {
            i2 = (int) (j2 - j);
        }
        byte[] bArr2 = this.g;
        if (bArr2 != null) {
            int length = i2 > bArr2.length ? bArr2.length : i2;
            System.arraycopy(bArr2, 0, bArr, i, length);
            byte[] bArr3 = this.g;
            if (length >= bArr3.length) {
                this.g = null;
            } else {
                int length2 = bArr3.length - length;
                byte[] bArr4 = new byte[length2];
                System.arraycopy(bArr3, length, bArr4, 0, length2);
                this.g = bArr4;
            }
            i3 = length + 0;
            i2 -= length;
            i += length;
        } else {
            i3 = 0;
        }
        while (i2 > 0) {
            byte[] d = this.a.d();
            if (d == null) {
                throw new IOException("unexpected EOF with " + i2 + " bytes unread. Occured at byte: " + c());
            }
            a(d.length);
            int length3 = d.length;
            if (length3 > i2) {
                System.arraycopy(d, 0, bArr, i, i2);
                int i4 = length3 - i2;
                byte[] bArr5 = new byte[i4];
                this.g = bArr5;
                System.arraycopy(d, i2, bArr5, 0, i4);
                length3 = i2;
            } else {
                System.arraycopy(d, 0, bArr, i, length3);
            }
            i3 += length3;
            i2 -= length3;
            i += length3;
        }
        this.f += i3;
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        byte[] bArr = new byte[f344c];
        long j2 = j;
        while (j2 > 0) {
            long j3 = f344c;
            if (j2 <= j3) {
                j3 = j2;
            }
            int read = read(bArr, 0, (int) j3);
            if (read == -1) {
                break;
            }
            j2 -= read;
        }
        return j - j2;
    }
}
