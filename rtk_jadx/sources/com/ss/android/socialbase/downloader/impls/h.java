package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends com.ss.android.socialbase.downloader.downloader.a {
    private static final String e = "h";

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c() {
        if (com.ss.android.socialbase.downloader.i.a.a(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT)) {
            this.b = true;
            this.d = false;
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(e, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(e, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.i.a.a(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT)) {
            this.b = true;
        }
        e();
    }
}
