package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements g {
    @Override // com.ss.android.downloadlib.addownload.d.g
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b;
        if (bVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        return n.a(bVar, b, i, hVar, true, cVar);
    }
}
