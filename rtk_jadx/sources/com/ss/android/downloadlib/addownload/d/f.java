package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements i {
    private static com.ss.android.downloadlib.addownload.a.d a;

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.i
    public boolean a(final com.ss.android.downloadad.api.a.b bVar, int i, final h hVar) {
        DownloadInfo b;
        if (bVar == null || bVar.ad() || !a(bVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b = com.ss.android.downloadlib.j.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        if (b == null) {
            return false;
        }
        long curBytes = b.getCurBytes();
        long totalBytes = b.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int a2 = com.ss.android.downloadlib.addownload.j.a(b.getId(), (int) ((curBytes * 100) / totalBytes));
            if (a2 > a(bVar.s())) {
                a = new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.d.f.1
                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void a() {
                        com.ss.android.downloadlib.addownload.a.d unused = f.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.d
                    public void b() {
                        com.ss.android.downloadlib.addownload.a.d unused = f.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                        hVar.a(bVar);
                    }
                };
                TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a2)), "继续", "暂停");
                bVar.o(true);
                return true;
            }
        }
        return false;
    }

    private int a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_download_percent", 50);
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).a("pause_optimise_download_percent_switch", 0) == 1 && aVar.q();
    }
}
