package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i implements com.ss.android.socialbase.downloader.downloader.k {
    @Override // com.ss.android.socialbase.downloader.downloader.k
    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String e = com.ss.android.socialbase.downloader.i.f.e(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(e)) {
            return 0;
        }
        return e.hashCode();
    }
}
