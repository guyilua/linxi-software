package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    private static com.ss.android.downloadlib.addownload.a.d a;
    private static com.ss.android.downloadlib.addownload.a.c b;

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return a;
    }

    public static boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return b;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.d dVar) {
        a = dVar;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        b = cVar;
    }

    public static boolean a(final com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.d.h hVar, final boolean z, final com.ss.android.downloadlib.addownload.a.c cVar) {
        boolean b2;
        if (bVar == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            b2 = com.ss.android.downloadlib.g.e.c((com.ss.android.downloadad.api.a.a) bVar);
        } else {
            b2 = com.ss.android.downloadlib.g.e.b((com.ss.android.downloadad.api.a.a) bVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(b2 ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_switch_status", jSONObject, bVar);
        } else {
            com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
        }
        if (!b2 || !a(i) || com.ss.android.socialbase.downloader.i.f.b(k.a())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        a(new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.n.1
            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    r.a().a(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_confirm", bVar);
                    } else {
                        com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", bVar);
                    }
                }
                hVar.a(bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel", bVar);
                } else {
                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", bVar);
                }
                hVar.a(bVar);
            }
        });
        if (z && cVar != null) {
            a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.n.2
                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.a.b.this);
                    cVar.a();
                }
            });
        }
        if (z) {
            TTDelegateActivity.a(bVar, "删除");
        } else {
            TTDelegateActivity.b(bVar);
        }
        return true;
    }
}
