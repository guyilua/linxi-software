package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.r;
import com.ss.android.downloadlib.addownload.k;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private final AtomicInteger a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static f a = new f();
    }

    private f() {
        this.a = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.ss.android.downloadlib.addownload.b.e eVar, final String str, final byte[] bArr, final h hVar) {
        k.e().a(str, bArr, "application/json; charset=utf-8", 0, new r() { // from class: com.ss.android.downloadlib.addownload.compliance.f.2
            @Override // com.ss.android.download.api.config.r
            public void a(String str2) {
                f.this.a(eVar, str2, hVar);
            }

            @Override // com.ss.android.download.api.config.r
            public void a(Throwable th) {
                f.this.a(eVar, str, bArr, hVar);
            }
        });
    }

    public static f a() {
        return a.a;
    }

    public void a(final com.ss.android.downloadlib.addownload.b.e eVar, final h hVar) {
        if (k.e() == null) {
            com.ss.android.downloadlib.e.c.a().a("getDownloadNetworkFactory == NULL");
            a(401, eVar);
        } else {
            com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f fVar = f.this;
                    fVar.b(eVar, fVar.b(), f.this.a(eVar, true, 4), hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.downloadlib.addownload.b.e eVar, String str, byte[] bArr, h hVar) {
        if (this.a.get() < 6) {
            this.a.incrementAndGet();
            b(eVar, str, bArr, hVar);
        } else {
            a("当前网络不佳，请稍后再试");
            this.a.set(0);
            a(402, eVar);
        }
    }

    private void a(final String str) {
        com.ss.android.downloadlib.h.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.3
            @Override // java.lang.Runnable
            public void run() {
                k.d().a(6, k.a(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(com.ss.android.downloadlib.addownload.b.e eVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", eVar.a());
            jSONObject.put("package_name", eVar.e());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", k.a().getPackageName());
                jSONObject.put("sender_version", k.k().e);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(eVar.b()));
                if (eVar.u().getDeepLink() != null) {
                    if (TextUtils.isEmpty(eVar.u().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.e.c.a().a("web_url is null");
                    }
                    jSONObject.put("web_url", eVar.u().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.e.c.a().a("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.e.c.a().a("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, String str, h hVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.e.c.a().a("response content is null");
                a(404, eVar);
                hVar.a();
                return;
            }
            this.a.set(0);
            e g = e.g(str);
            if (g.a() != 0) {
                a(403, eVar);
                hVar.a();
            } else if (TextUtils.isEmpty(g.b())) {
                a(405, eVar);
                hVar.a();
            } else {
                hVar.a(g.b());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void a(int i, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("get_miui_market_compliance_error", jSONObject, eVar);
    }

    public void a(int i, com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("get_miui_market_compliance_success", jSONObject, eVar);
    }
}
