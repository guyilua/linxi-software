package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements Closeable {
    private BufferedOutputStream a;
    private FileDescriptor b;

    /* renamed from: c, reason: collision with root package name */
    private RandomAccessFile f899c;

    public e(File file, int i) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f899c = randomAccessFile;
            this.b = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                }
                this.a = new BufferedOutputStream(new FileOutputStream(this.f899c.getFD()), i);
                return;
            }
            this.a = new BufferedOutputStream(new FileOutputStream(this.f899c.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }

    public void b() {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() {
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f.a(this.f899c, this.a);
    }

    public void a() {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b(long j) {
        this.f899c.setLength(j);
    }

    public void a(long j) {
        this.f899c.seek(j);
    }
}
