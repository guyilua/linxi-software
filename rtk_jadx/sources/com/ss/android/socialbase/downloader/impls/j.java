package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.s;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j implements s {
    @Override // com.ss.android.socialbase.downloader.downloader.s
    public long a(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
