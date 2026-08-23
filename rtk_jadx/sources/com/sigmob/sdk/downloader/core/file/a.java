package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a {

    /* renamed from: com.sigmob.sdk.downloader.core.file.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0044a {
        a a(Context context, Uri uri, int i);

        a a(Context context, File file, int i);

        boolean a();
    }

    void a();

    void a(long j);

    void a(byte[] bArr, int i, int i2);

    void b();

    void b(long j);
}
