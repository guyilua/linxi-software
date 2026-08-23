package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l implements i {
    @Override // com.ss.android.downloadlib.addownload.d.i
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i, h hVar) {
        DownloadInfo b;
        if (bVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b = com.ss.android.downloadlib.j.a((Context) null).a(bVar.af(), null, true);
        } else {
            b = com.ss.android.downloadlib.j.a((Context) null).b(bVar.a());
        }
        return n.a(bVar, b, i, hVar, false, null);
    }
}
