package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d {
    public static final int a = 512;
    public static final int b = 10240;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f345c;
    private OutputStream d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    public d(InputStream inputStream) {
        this(inputStream, b);
    }

    public d(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public d(InputStream inputStream, int i, int i2) {
        this.f345c = inputStream;
        this.d = null;
        a(i, i2);
    }

    public d(OutputStream outputStream) {
        this(outputStream, b);
    }

    public d(OutputStream outputStream, int i) {
        this(outputStream, i, 512);
    }

    public d(OutputStream outputStream, int i, int i2) {
        this.f345c = null;
        this.d = outputStream;
        a(i, i2);
    }

    private void a(int i, int i2) {
        this.h = i;
        this.i = i2;
        int i3 = i / i2;
        this.j = i3;
        this.e = new byte[i];
        if (this.f345c != null) {
            this.f = -1;
            this.g = i3;
        } else {
            this.f = 0;
            this.g = 0;
        }
    }

    private boolean i() {
        if (this.f345c == null) {
            throw new IOException("reading from an output buffer");
        }
        this.g = 0;
        int i = this.h;
        int i2 = 0;
        while (true) {
            if (i <= 0) {
                break;
            }
            long read = this.f345c.read(this.e, i2, i);
            if (read != -1) {
                i2 = (int) (i2 + read);
                i = (int) (i - read);
            } else {
                if (i2 == 0) {
                    return false;
                }
                Arrays.fill(this.e, i2, i + i2, (byte) 0);
            }
        }
        this.f++;
        return true;
    }

    private void j() {
        OutputStream outputStream = this.d;
        if (outputStream == null) {
            throw new IOException("writing to an input buffer");
        }
        outputStream.write(this.e, 0, this.h);
        this.d.flush();
        this.g = 0;
        this.f++;
        Arrays.fill(this.e, (byte) 0);
    }

    public int a() {
        return this.h;
    }

    public void a(byte[] bArr, int i) {
        if (this.d == null) {
            if (this.f345c != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (this.i + i <= bArr.length) {
            if (this.g >= this.j) {
                j();
            }
            byte[] bArr2 = this.e;
            int i2 = this.g;
            int i3 = this.i;
            System.arraycopy(bArr, i, bArr2, i2 * i3, i3);
            this.g++;
            return;
        }
        throw new IOException("record has length '" + bArr.length + "' with offset '" + i + "' which is less than the record size of '" + this.i + "'");
    }

    public boolean a(byte[] bArr) {
        int b2 = b();
        for (int i = 0; i < b2; i++) {
            if (bArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int b() {
        return this.i;
    }

    public void b(byte[] bArr) {
        if (this.d == null) {
            if (this.f345c != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (bArr.length != this.i) {
            throw new IOException("record to write has length '" + bArr.length + "' which is not the record size of '" + this.i + "'");
        }
        if (this.g >= this.j) {
            j();
        }
        byte[] bArr2 = this.e;
        int i = this.g;
        int i2 = this.i;
        System.arraycopy(bArr, 0, bArr2, i * i2, i2);
        this.g++;
    }

    public void c() {
        if (this.f345c == null) {
            throw new IOException("reading (via skip) from an output buffer");
        }
        if (this.g < this.j || i()) {
            this.g++;
        }
    }

    public byte[] d() {
        if (this.f345c == null) {
            if (this.d == null) {
                throw new IOException("input buffer is closed");
            }
            throw new IOException("reading from an output buffer");
        }
        if (this.g >= this.j && !i()) {
            return null;
        }
        int i = this.i;
        byte[] bArr = new byte[i];
        System.arraycopy(this.e, this.g * i, bArr, 0, i);
        this.g++;
        return bArr;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g - 1;
    }

    void g() {
        if (this.d == null) {
            throw new IOException("writing to an input buffer");
        }
        if (this.g > 0) {
            j();
        }
    }

    public void h() {
        if (this.d == null) {
            InputStream inputStream = this.f345c;
            if (inputStream != null) {
                if (inputStream != System.in) {
                    inputStream.close();
                }
                this.f345c = null;
                return;
            }
            return;
        }
        g();
        OutputStream outputStream = this.d;
        if (outputStream == System.out || outputStream == System.err) {
            return;
        }
        outputStream.close();
        this.d = null;
    }
}
