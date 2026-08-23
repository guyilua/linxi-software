package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private InputStream a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private int f817c;

    public d() {
    }

    public final void a(InputStream inputStream, boolean z) {
        this.a = inputStream;
        this.b = z;
        this.f817c = 0;
    }

    public final int b() {
        return a(4);
    }

    public final void c(int i) {
        if (i > 0) {
            long j = i;
            long skip = this.a.skip(j);
            this.f817c = (int) (this.f817c + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    public d(InputStream inputStream, boolean z) {
        a(inputStream, z);
    }

    public final int[] b(int i) {
        int[] iArr = new int[i];
        a(iArr, 0, i);
        return iArr;
    }

    public final void a() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            a(null, false);
        }
    }

    public final void c() {
        c(4);
    }

    public final int a(int i) {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.b) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int read = this.a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f817c++;
                    i2 |= read << i3;
                }
                return i2;
            }
            int i4 = i * 8;
            int i5 = 0;
            while (i2 != i4) {
                int read2 = this.a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f817c++;
                i5 |= read2 << i2;
                i2 += 8;
            }
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public final void a(int[] iArr, int i, int i2) {
        while (i2 > 0) {
            iArr[i] = b();
            i2--;
            i++;
        }
    }
}
