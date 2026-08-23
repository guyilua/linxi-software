package com.ss.android.downloadlib.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.g.m;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final String a = "a";

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        boolean z;
        DeepLink deepLink = eVar.b.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), eVar);
        m.a(a2, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a2, eVar);
        com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(openUrl, eVar);
        if (a3.a() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                b("by_url", a3, a2, eVar);
            }
            a3 = com.ss.android.downloadlib.g.i.a(k.a(), eVar.b.getPackageName(), eVar);
        }
        boolean z2 = false;
        if (a(eVar.a) && k.j().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = eVar.b;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.d.a.a().a(eVar.a, 0);
            z = true;
        } else {
            z = false;
        }
        int a4 = a3.a();
        if (a4 == 1) {
            b("by_url", a2, eVar);
        } else if (a4 == 3) {
            a("by_package", a2, eVar);
        } else {
            if (a4 != 4) {
                com.ss.android.downloadlib.e.c.a().b("AppLinkClick default");
            } else {
                a("by_package", a3, a2, eVar);
            }
            if (z2 && !z && ((com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(eVar.a, eVar.b.getLogExtra())) || com.ss.android.downloadlib.d.c.a().c())) {
                com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
        }
        return z2;
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String f = com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 ? bVar.f() : null;
        JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        m.a(a2, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a2, bVar);
        com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(f, bVar);
        if (a3.a() == 2) {
            if (!TextUtils.isEmpty(f)) {
                b("dialog_by_url", a3, a2, bVar);
            }
            a3 = com.ss.android.downloadlib.g.i.a(k.a(), bVar.e(), bVar);
        }
        int a4 = a3.a();
        if (a4 == 1) {
            b("dialog_by_url", a2, bVar);
            return;
        }
        if (a4 == 3) {
            a("dialog_by_package", a2, bVar);
        } else if (a4 != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickDialog default");
        } else {
            a("dialog_by_package", a3, a2, bVar);
        }
    }

    public static void b(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open", jSONObject, aVar);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals("auto_by_url")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1374618233:
                if (str.equals("by_url")) {
                    c2 = 1;
                    break;
                }
                break;
            case -129544387:
                if (str.equals("notify_by_url")) {
                    c2 = 2;
                    break;
                }
                break;
            case 829750366:
                if (str.equals("dialog_by_url")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((k.j().optInt("check_applink_mode") & 1) != 0) {
                    m.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.2
                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z) {
                                k.v();
                                k.a();
                                aVar.u();
                                aVar.w();
                                aVar.v();
                                aVar.e();
                            }
                        }
                    });
                    return;
                }
                k.c();
                k.a();
                aVar.u();
                aVar.w();
                aVar.v();
                aVar.e();
                return;
            default:
                return;
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        String f = bVar.f();
        JSONObject a2 = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        m.a(a2, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", a2, bVar);
        com.ss.android.downloadlib.addownload.b.g a3 = com.ss.android.downloadlib.g.i.a(f, bVar);
        if (a3.a() == 2) {
            if (!TextUtils.isEmpty(f)) {
                b("notify_by_url", a3, a2, bVar);
            }
            a3 = com.ss.android.downloadlib.g.i.a(k.a(), bVar.e(), bVar);
        }
        int a4 = a3.a();
        if (a4 == 1) {
            b("notify_by_url", a2, bVar);
            return;
        }
        if (a4 == 3) {
            a("notify_by_package", a2, bVar);
        } else if (a4 != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickNotification default");
        } else {
            a("notify_by_package", a3, a2, bVar);
        }
    }

    public static void b(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open_fail", jSONObject, aVar);
    }

    public static boolean a(String str, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        if (!com.ss.android.downloadlib.addownload.i.b(bVar.O())) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.b.a().f(bVar.s());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.g.f.a(jSONObject, bVar);
        m.a(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.d.a.a().b("applink_click", bVar);
        com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(bVar, bVar.f(), bVar.e());
        int a3 = a2.a();
        if (a3 == 1) {
            b("auto_by_url", jSONObject, bVar);
            return true;
        }
        if (a3 == 2) {
            b("auto_by_url", a2, jSONObject, bVar);
            return false;
        }
        if (a3 == 3) {
            a("auto_by_package", jSONObject, bVar);
            return true;
        }
        if (a3 != 4) {
            return false;
        }
        a("auto_by_package", a2, jSONObject, bVar);
        return false;
    }

    public static void a(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open", jSONObject, aVar);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals("notify_by_package")) {
                    c2 = 0;
                    break;
                }
                break;
            case -441514770:
                if (str.equals("auto_by_package")) {
                    c2 = 1;
                    break;
                }
                break;
            case -185950114:
                if (str.equals("by_package")) {
                    c2 = 2;
                    break;
                }
                break;
            case 368401333:
                if (str.equals("dialog_by_package")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((k.j().optInt("check_applink_mode") & 1) != 0) {
                    m.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.1
                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z) {
                                k.v();
                                k.a();
                                aVar.u();
                                aVar.w();
                                aVar.v();
                                aVar.e();
                            }
                        }
                    });
                    return;
                }
                k.c();
                k.a();
                aVar.u();
                aVar.w();
                aVar.v();
                aVar.e();
                return;
            default:
                return;
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
        m.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open_fail", jSONObject, aVar);
    }

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, int i) {
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g a2 = com.ss.android.downloadlib.g.i.a(k.a(), eVar, eVar.b.getPackageName());
        String a3 = m.a(a2.c(), PointCategory.OPEN_MARKET);
        int a4 = a2.a();
        if (a4 == 5) {
            a(a3, jSONObject, eVar, true);
        } else {
            if (a4 == 6) {
                m.a(jSONObject, "error_code", Integer.valueOf(a2.b()));
                m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            }
            if (a4 != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.d.a.a().a(eVar.a, i);
        return true;
    }

    public static void a(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.e.c.a().a(e, "onMarketSuccess");
                return;
            }
        }
        m.a(jSONObject, "applink_source", str);
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        if (z) {
            com.ss.android.downloadlib.d.a.a().b("market_open_success", jSONObject, eVar);
        }
        if ((k.j().optInt("check_applink_mode") & 4) != 0) {
            e.a().b(new d() { // from class: com.ss.android.downloadlib.b.a.3
                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z2) {
                    if (!z2 && !PointCategory.OPEN_MARKET.equals(str)) {
                        a.a(com.ss.android.downloadlib.g.i.a(k.a(), Uri.parse(BaseConstants.MARKET_PREFIX + eVar.e())), eVar, false);
                    }
                    com.ss.android.downloadlib.d.a.a().a(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, eVar);
                    if (z2) {
                        k.v();
                        k.a();
                        eVar.b.getPackageName();
                    }
                }
            });
        } else {
            k.c();
            k.a();
            eVar.b.getPackageName();
        }
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(eVar.b.getPackageName());
        if (a2 != null) {
            l.a().a(a, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            l.a().a(a, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            a2 = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.f728c, eVar.d);
        }
        a2.e(2);
        a2.f(System.currentTimeMillis());
        a2.h(4);
        a2.i(2);
        com.ss.android.downloadlib.addownload.b.f.a().a(a2);
        l.a().a(a, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.i.a().a(eVar, a2);
    }

    public static void a(com.ss.android.downloadlib.addownload.b.g gVar, com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        String a2 = m.a(gVar.c(), PointCategory.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "ttdownloader_type", "backup");
        int a3 = gVar.a();
        if (a3 == 5) {
            a(a2, jSONObject, eVar, z);
        } else {
            if (a3 != 6) {
                return;
            }
            m.a(jSONObject, "error_code", Integer.valueOf(gVar.b()));
            m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
            com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
        }
    }

    public static boolean a(long j) {
        return com.ss.android.downloadlib.addownload.b.f.a().d(j) == null;
    }
}
