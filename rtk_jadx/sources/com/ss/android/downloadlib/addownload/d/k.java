package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    private static k a;
    private List<i> b;

    private k() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new j());
        this.b.add(new l());
        this.b.add(new f());
        this.b.add(new a());
    }

    public static k a() {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i, h hVar) {
        DownloadInfo b;
        List<i> list = this.b;
        if (list != null && list.size() != 0 && bVar != null) {
            if (!TextUtils.isEmpty(bVar.af())) {
                b = com.ss.android.downloadlib.j.a((Context) null).a(bVar.af(), null, true);
            } else {
                b = com.ss.android.downloadlib.j.a((Context) null).b(bVar.a());
            }
            if (b != null && AdBaseConstants.MIME_APK.equals(b.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("pause_optimise_switch", 0) == 1;
                for (i iVar : this.b) {
                    if (z || (iVar instanceof l)) {
                        if (iVar.a(bVar, i, hVar)) {
                            return;
                        }
                    }
                }
                hVar.a(bVar);
                return;
            }
            hVar.a(bVar);
            return;
        }
        hVar.a(bVar);
    }
}
