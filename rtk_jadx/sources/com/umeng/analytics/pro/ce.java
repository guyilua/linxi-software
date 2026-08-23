package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ce extends cg {
    protected InputStream a;
    protected OutputStream b;

    protected ce() {
        this.a = null;
        this.b = null;
    }

    @Override // com.umeng.analytics.pro.cg
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ch(4);
            } catch (IOException e) {
                throw new ch(0, e);
            }
        }
        throw new ch(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.cg
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cg
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cg
    public void b(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new ch(0, e);
            }
        }
        throw new ch(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.analytics.pro.cg
    public void c() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cg
    public void d() {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e) {
                throw new ch(0, e);
            }
        }
        throw new ch(1, "Cannot flush null outputStream");
    }

    public ce(InputStream inputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
    }

    public ce(OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.b = outputStream;
    }

    public ce(InputStream inputStream, OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
        this.b = outputStream;
    }
}
