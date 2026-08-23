package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static void a(String str, long j) {
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        if (e.x()) {
            return;
        }
        e.f728c.setRefer(str);
        com.ss.android.downloadlib.d.a.a().b("lp_app_dialog_click", e);
    }

    public static void b(String str, long j) {
        a(str, null, j);
    }

    public static void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, com.ss.android.downloadlib.addownload.b.f.a().e(j));
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadlib.d.a.a().b(str, eVar);
    }

    public static void a(int i, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, eVar);
    }

    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.b.f.a().e(j));
    }
}
