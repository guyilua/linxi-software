package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.m;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private SoftReference<Activity> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static b a = new b();
    }

    public void b(long j) {
        com.ss.android.downloadlib.addownload.e a2 = com.ss.android.downloadlib.h.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j).b.getDownloadUrl());
        if (a2 != null) {
            a2.a(true, true);
        } else {
            g.a(11, j);
            com.ss.android.downloadlib.e.c.a().b("startDownload handler null");
        }
    }

    private b() {
    }

    public static b a() {
        return a.a;
    }

    public void a(long j) {
        TTDelegateActivity.a(j);
    }

    public boolean a(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || k.j().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(k.j().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity b() {
        Activity activity = this.a.get();
        this.a = null;
        return activity;
    }

    public boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        long j;
        long j2;
        if (!TextUtils.isEmpty(eVar.b.getLogExtra())) {
            try {
                j = m.a(new JSONObject(eVar.b.getLogExtra()), "convert_id");
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                g.a(3, eVar);
            }
            j2 = j;
        } else {
            g.a(9, eVar);
            com.ss.android.downloadlib.e.c.a().a("requestAppInfo getLogExtra null");
            j2 = 0;
        }
        final long j3 = eVar.a;
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(j2, j3);
        if (a2 != null) {
            d.a().a(a2.a(), j3, a2.d);
            a(a2.a());
            g.a("lp_app_dialog_try_show", eVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!TextUtils.isEmpty(eVar.b.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(eVar.b.getPackageName());
        }
        if (sb.length() <= 0) {
            g.a(6, eVar);
            return false;
        }
        final long j4 = j2;
        com.ss.android.downloadlib.g.c.a((c.a<String, R>) new c.a<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2
            @Override // com.ss.android.downloadlib.g.c.a
            public Boolean a(String str) {
                final boolean[] zArr = {false};
                k.e().a("GET", str, new HashMap(), new r() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1
                    @Override // com.ss.android.download.api.config.r
                    public void a(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.this.a(j4, j3, str2);
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(Throwable th) {
                        g.a(2, j3);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).a(new c.a<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.1
            @Override // com.ss.android.downloadlib.g.c.a
            public Object a(Boolean bool) {
                if (bool.booleanValue()) {
                    b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j4, j3));
                    g.b("lp_app_dialog_try_show", j3);
                    return null;
                }
                b.this.b(j3);
                return null;
            }
        }).a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                bVar.a = j;
                bVar.b = j2;
                bVar.d = optJSONObject.optString("icon_url");
                bVar.e = optJSONObject.optString("app_name");
                bVar.f724c = optJSONObject.optString("package_name");
                bVar.f = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                bVar.g = optJSONObject.optString("developer_name");
                bVar.i = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                        bVar.h.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                c.a().a(bVar);
                d.a().a(bVar.a(), j2, bVar.d);
                return true;
            }
            g.a(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "AdLpComplianceManager parseResponse");
            g.a(7, j2);
            return false;
        }
    }

    public void a(Activity activity) {
        this.a = new SoftReference<>(activity);
    }
}
