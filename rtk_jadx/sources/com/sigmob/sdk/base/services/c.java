package com.sigmob.sdk.base.services;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.czhj.sdk.common.utils.FileUtil;
import com.sigmob.sdk.base.common.p;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0017, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r17, long r18, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.c.a(android.content.Context, long, java.lang.Object):void");
    }

    DownloadManager a(Context context) {
        return (DownloadManager) context.getSystemService("download");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        File file = new File(com.sigmob.sdk.base.utils.e.g(), longExtra + ".log");
        Object readFromCache = FileUtil.readFromCache(file.getAbsolutePath());
        p.b(longExtra, "");
        FileUtil.deleteFile(file.getAbsolutePath());
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            a(context, longExtra, readFromCache);
        }
    }
}
