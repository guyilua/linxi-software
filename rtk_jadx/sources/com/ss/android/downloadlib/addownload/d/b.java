package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements g {
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
        long a2 = com.ss.android.downloadlib.addownload.j.a(b2.getId(), b2.getCurBytes(), b2.getTotalBytes());
        long totalBytes = b2.getTotalBytes();
        if (a2 >= 0 && totalBytes > 0) {
            if (totalBytes <= a(bVar.s())) {
                final int i2 = (int) (a2 / BaseConstants.MB_VALUE);
                a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.b.1
                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void a() {
                        com.ss.android.downloadlib.addownload.a.d unused = b.a = null;
                        b.this.a(i2, i2, bVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void b() {
                        com.ss.android.downloadlib.addownload.a.d unused = b.a = null;
                        b.this.a(i2, i2, bVar, "apk_size_cancel", "cancel");
                        hVar.a(bVar);
                    }
                };
                String format = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", m.a(totalBytes - a2));
                if (cVar != null) {
                    a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.b.2
                        @Override // com.ss.android.downloadlib.addownload.a.c
                        public void a() {
                            com.ss.android.downloadlib.addownload.a.d unused = b.a = null;
                            b.this.a(i2, i2, bVar, "apk_size_cancel", "delete");
                            cVar.a();
                        }
                    });
                }
                TTDelegateActivity.a(bVar, format, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("cancel_pause_optimise_apk_size", 100) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).a("cancel_pause_optimise_apk_retain_switch", 0) == 1 && aVar.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_cancel_optimise", jSONObject, bVar);
    }
}
