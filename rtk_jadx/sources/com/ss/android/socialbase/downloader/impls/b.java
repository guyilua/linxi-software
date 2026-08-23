package com.ss.android.socialbase.downloader.impls;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.g {
    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int a(int i, com.ss.android.socialbase.downloader.network.l lVar) {
        if (lVar.ordinal() <= com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()) {
            return 1;
        }
        return lVar == com.ss.android.socialbase.downloader.network.l.GOOD ? i - 1 : i;
    }
}
