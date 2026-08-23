package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.sigmob.sdk.downloader.core.file.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements com.sigmob.sdk.downloader.core.file.a {
    final ParcelFileDescriptor a;
    final BufferedOutputStream b;

    /* renamed from: c, reason: collision with root package name */
    final FileOutputStream f536c;
    private final FileChannel d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements a.InterfaceC0044a {
        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0044a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, Uri uri, int i) {
            return new b(context, uri, i);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0044a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, File file, int i) {
            return new b(context, Uri.fromFile(file), i);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0044a
        public boolean a() {
            return true;
        }
    }

    public b(Context context, Uri uri, int i) {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.a = openFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
        this.f536c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        this.b = new BufferedOutputStream(fileOutputStream, i);
    }

    b(FileChannel fileChannel, ParcelFileDescriptor parcelFileDescriptor, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream) {
        this.d = fileChannel;
        this.a = parcelFileDescriptor;
        this.f536c = fileOutputStream;
        this.b = bufferedOutputStream;
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a() {
        this.b.close();
        this.f536c.close();
        this.a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(long j) {
        this.d.position(j);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b() {
        this.b.flush();
        this.a.getFileDescriptor().sync();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b(long j) {
        StringBuilder sb;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            try {
                Os.posix_fallocate(this.a.getFileDescriptor(), 0L, j);
                return;
            } catch (Throwable th) {
                th = th;
                if (th instanceof ErrnoException) {
                    int i2 = th.errno;
                    if (i2 == OsConstants.ENOSYS || i2 == OsConstants.ENOTSUP) {
                        com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                        try {
                            Os.ftruncate(this.a.getFileDescriptor(), j);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            sb = new StringBuilder();
                            sb.append("It can't pre-allocate length(");
                            sb.append(j);
                            sb.append(") on the sdk version(");
                            sb.append(Build.VERSION.SDK_INT);
                            sb.append("), because of ");
                            sb.append(th);
                            com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", sb.toString());
                        }
                    }
                    return;
                }
                sb = new StringBuilder();
                sb.append("It can't pre-allocate length(");
                sb.append(j);
                sb.append(") on the sdk version(");
                sb.append(Build.VERSION.SDK_INT);
                sb.append("), because of ");
                sb.append(th);
            }
        } else {
            sb = new StringBuilder();
            sb.append("It can't pre-allocate length(");
            sb.append(j);
            sb.append(") on the sdk version(");
            sb.append(i);
            sb.append(")");
        }
        com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", sb.toString());
    }
}
