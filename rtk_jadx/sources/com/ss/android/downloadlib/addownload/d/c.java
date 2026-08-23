package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements g {
    private static com.ss.android.downloadlib.addownload.a.d a;
    private static com.ss.android.downloadlib.addownload.a.c b;

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return b;
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return a;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        b = cVar;
    }

    @Override // com.ss.android.downloadlib.addownload.d.g
    public boolean a(final com.ss.android.downloadad.api.a.b bVar, int i, final h hVar, final com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b2;
        String format;
        if (bVar == null || !a(bVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b2 = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b2 = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        if (b2 == null) {
            return false;
        }
        long curBytes = b2.getCurBytes();
        long totalBytes = b2.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int a2 = com.ss.android.downloadlib.addownload.j.a(b2.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i2 = (int) (curBytes / BaseConstants.MB_VALUE);
        boolean z = a2 > a(bVar.s());
        a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.c.1
            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                com.ss.android.downloadlib.addownload.a.d unused = c.a = null;
                c.this.a(a2, i2, i2, bVar, "download_percent_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                com.ss.android.downloadlib.addownload.a.d unused = c.a = null;
                c.this.a(a2, i2, i2, bVar, "download_percent_cancel", "cancel");
                hVar.a(bVar);
            }
        };
        String a3 = m.a(com.ss.android.downloadlib.addownload.j.a(bVar.s(), curBytes, totalBytes));
        if (z) {
            format = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", a3, m.a(totalBytes - curBytes));
        } else {
            format = String.format("该任务已下载%s，即将下载完成，是否继续下载？", a3);
        }
        String str = format;
        if (cVar != null) {
            a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.c.2
                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    com.ss.android.downloadlib.addownload.a.d unused = c.a = null;
                    c.this.a(a2, i2, i2, bVar, "download_percent_cancel", "delete");
                    cVar.a();
                }
            });
        }
        TTDelegateActivity.b(bVar, str, "继续", "暂停", "删除");
        return true;
    }

    private int a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).a("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && aVar.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_cancel_optimise", jSONObject, bVar);
    }
}
