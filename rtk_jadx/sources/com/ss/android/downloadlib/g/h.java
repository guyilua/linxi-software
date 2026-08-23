package com.ss.android.downloadlib.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static final String a = "h";

    private static void c(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(context, str, eVar.a);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
            b(eVar, jSONObject, 14, 11, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g d(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 14);
        }
    }

    private static void e(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject j = com.ss.android.downloadlib.addownload.k.j();
                    Thread.sleep(j.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.a.a.a.a().a(context, true);
                    com.ss.android.downloadlib.a.a.b bVar = new com.ss.android.downloadlib.a.a.b();
                    bVar.a = 1;
                    bVar.b = 0;
                    String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j.optString(ak.aE), j.optString(ak.aB));
                    bVar.f714c = String.format(a2, str);
                    com.ss.android.downloadlib.a.a.a.a().a(bVar, (com.ss.android.downloadlib.a.a.d) null);
                    com.ss.android.downloadlib.a.a.a.a().b();
                    h.b(eVar, jSONObject, -1, 2, String.format(a2, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    h.b(eVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void f(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject j = com.ss.android.downloadlib.addownload.k.j();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String optString = j.optString(ak.aB);
                    String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("bw"), optString);
                    String a3 = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("bx"), optString);
                    String a4 = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(BaseConstants.SCHEME_HTTPS).authority(a2).appendPath(a3).appendQueryParameter(a4, str);
                    com.ss.android.downloadlib.addownload.k.e().a("GET", builder.build().toString(), null, new r() { // from class: com.ss.android.downloadlib.g.h.6.1
                        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
                        @Override // com.ss.android.download.api.config.r
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void a(java.lang.String r6) {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.g.h.a(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.g.h.b(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                com.ss.android.downloadlib.g.h$6 r0 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                android.content.Context r2 = r2
                                com.ss.android.downloadlib.addownload.b.e r3 = r3
                                java.lang.String r0 = r1
                                com.ss.android.downloadlib.g.h.a(r2, r3, r0, r6)
                                r6 = 1
                                goto L29
                            L28:
                                r6 = 0
                            L29:
                                if (r6 != 0) goto L6d
                                com.ss.android.downloadlib.g.h$6 r6 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r2 = "market://details?id="
                                r0.<init>(r2)
                                com.ss.android.downloadlib.g.h$6 r3 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                java.lang.String r3 = r1
                                r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.b.g r6 = com.ss.android.downloadlib.g.h.a(r6, r0)
                                com.ss.android.downloadlib.g.h$6 r0 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.b.e r0 = r3
                                com.ss.android.downloadlib.b.a.a(r6, r0, r1)
                                com.ss.android.downloadlib.g.h$6 r6 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.b.e r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>(r2)
                                com.ss.android.downloadlib.g.h$6 r2 = com.ss.android.downloadlib.g.h.AnonymousClass6.this
                                java.lang.String r2 = r1
                                r4.append(r2)
                                java.lang.String r2 = r4.toString()
                                com.ss.android.downloadlib.g.h.a(r6, r0, r1, r3, r2)
                            L6d:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.g.h.AnonymousClass6.AnonymousClass1.a(java.lang.String):void");
                        }

                        @Override // com.ss.android.download.api.config.r
                        public void a(Throwable th) {
                            com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                            m.a(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            h.b(eVar, jSONObject, 11, 9, BaseConstants.MARKET_PREFIX + str);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    h.b(eVar, jSONObject, 4, 9, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void g(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(str, eVar.a);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
            b(eVar, jSONObject, 13, 10, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    private static void h(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject j = com.ss.android.downloadlib.addownload.k.j();
                String optString = j.optString(ak.aB);
                final JSONObject jSONObject = new JSONObject();
                String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                m.a(jSONObject2, ak.aH, ak.aE);
                m.a(jSONObject2, ak.ax, str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.k.e().a(a2, com.ss.android.downloadlib.addownload.k.s().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new r() { // from class: com.ss.android.downloadlib.g.h.7.1
                    @Override // com.ss.android.download.api.config.r
                    public void a(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        h.b(context, str, str2, eVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.r
                    public void a(Throwable th) {
                        com.ss.android.downloadlib.b.a.a(h.a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                        m.a(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        h.b(eVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    private static void i(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(str, eVar.a, BaseConstants.VIVO_MARKET_NEED_COMMENT);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
            b(eVar, jSONObject, 9, 8, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g b(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(ak.ax, str);
        intent.putExtra("id", eVar.a);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk2");
        } catch (Throwable unused) {
            b(eVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.f.e.c() && (context == null || uri == null || !BaseConstants.SCHEME_MARKET.equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 12);
        }
        try {
            String j = com.ss.android.socialbase.appdownloader.f.e.j();
            if (com.ss.android.socialbase.appdownloader.f.e.q() && (TextUtils.isEmpty(j) || !m.e(context, j))) {
                j = "com.huawei.appmarket";
                Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.scheme(BaseConstants.SCHEME_MARKET);
                intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!m.a(context, intent)) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 13);
            }
            if (m.e(context, j) && !com.ss.android.socialbase.appdownloader.f.e.g()) {
                intent.setPackage(j);
            }
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.g.a.c().b("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.e.c.a().a(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.b.g(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 14);
        }
    }

    public static boolean c(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String j = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j)) {
            intent.setPackage(j);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "start HM2");
            return false;
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g d(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra(ak.ax, str);
        intent.putExtra("id", eVar.a);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO);
        } else if (m.e(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
        } else if (m.e(context, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO);
        } else {
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk3");
        } catch (Throwable unused) {
            b(eVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject) {
        m.a(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString(ak.av));
            if (!TextUtils.isEmpty(a2)) {
                TTDelegateActivity.a(str, eVar.a, a2, jSONObject);
            } else {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
                b(eVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
            b(eVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String j = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j)) {
            intent.setPackage(j);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "start HM1");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String group = matcher.find() ? matcher.group() : "";
        if (!group.equals(null) && group.length() > 0) {
            for (String str2 : group.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith("value")) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(final Context context, Uri uri, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadad.api.a.b bVar;
        if (context != null && com.ss.android.downloadlib.b.j.a(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!m.a(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.b.g(6, 13);
                }
                String j = com.ss.android.socialbase.appdownloader.f.e.j();
                if (m.e(context, j)) {
                    intent.setPackage(j);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.g.a.c().b("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.k.k().f702c)) {
                    com.ss.android.downloadlib.e.c.a().a(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.b.g(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && eVar != null && (bVar = eVar.e) != null && !bVar.ae()) {
                    com.ss.android.downloadlib.h.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.g.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.k.d().a(8, com.ss.android.downloadlib.addownload.k.a(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new com.ss.android.downloadlib.addownload.b.g(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject, int i, int i2, String str) {
        m.a(jSONObject, "error_code", Integer.valueOf(i));
        m.a(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        m.a(jSONObject, "rmu", str);
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j(), Integer.valueOf(m.b(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j())));
        com.ss.android.downloadlib.d.a.a().b("am_result", jSONObject, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.b.g b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        Intent g = m.g(context, str);
        if (g == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        g.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(g);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.b.g b(String str, com.ss.android.downloadad.api.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(2, 21);
        }
        Context a2 = com.ss.android.downloadlib.addownload.k.a();
        Intent intent = null;
        String packageName = aVar.u().getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            l.a().a(a, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            intent = a(a2, aVar, packageName, 2, str);
            if (intent != null) {
                com.ss.android.downloadlib.addownload.b.g a3 = a(a2, intent, aVar, true, str);
                if (a3.a() == 1) {
                    return a3;
                }
            }
        }
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        return a(a2, intent, aVar, false, str);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.e.g() && m.e(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            return a(context, com.ss.android.download.api.c.a.a(str));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.e.g() && m.e(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            if (eVar.b.isAd() && eVar.d.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.k.j().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.f.e.e() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_3")) {
                    return b(context, eVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.f.e.f() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_2")) {
                    e(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.f.e.d() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_5")) {
                    h(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.f.e.e() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_7")) {
                    DownloadController downloadController = eVar.d;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return d(context, eVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.f.e.d() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_8") && m.a(m.c(context, "com.bbk.appstore"), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) >= 0) {
                    i(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.f.e.a() || com.ss.android.socialbase.appdownloader.f.e.b()) && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_9")) {
                    f(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.f.e.a() || com.ss.android.socialbase.appdownloader.f.e.b()) && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_10")) {
                    g(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_hr2");
                }
                DownloadController downloadController2 = eVar.d;
                if ((downloadController2 instanceof AdDownloadController) && ((AdDownloadController) downloadController2).enableOppoAutoDownload() && ((AdDownloadController) eVar.d).getDownloadMarketInterceptor() != null && eVar.b.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
                    c(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk4");
                }
                return a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
            }
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.b(str, eVar.a, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), eVar, true);
            b(eVar, jSONObject, 12, 9, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    public static void b(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
        String optString = j2.optString(ak.aB);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bz"), optString);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("ca"), optString);
        String a4 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.MARKET_SCHEME_HW_HONOR).authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(a2)) {
            builder.appendQueryParameter(a2, str2);
        }
        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a4)) {
            builder.appendQueryParameter(a3, a4);
        }
        if (b(activity, builder.build())) {
            b(e, jSONObject, -1, 9, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a("am_hr", jSONObject, e, true);
        } else {
            b(e, jSONObject, 2, 9, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
        }
    }

    public static void b(@NonNull Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        boolean enableOppoAutoDownload = ((AdDownloadController) e.d).enableOppoAutoDownload();
        HashMap hashMap = new HashMap();
        hashMap.put("is_button", Boolean.valueOf(enableOppoAutoDownload));
        m.a(jSONObject, "is_button", Boolean.valueOf(enableOppoAutoDownload));
        Map<String, Object> interceptObmMarket = ((AdDownloadController) e.d).getDownloadMarketInterceptor().interceptObmMarket(hashMap);
        if (interceptObmMarket != null && interceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(interceptObmMarket.get("convert_result").toString())) {
            b(e, jSONObject, -1, 11, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a("am_kllk4", jSONObject, e, true);
        } else {
            b(e, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
        }
    }

    public static boolean a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str, JSONObject jSONObject, boolean z, int i) {
        m.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g a2 = a(context, Uri.parse(str));
        String a3 = m.a(a2.c(), PointCategory.OPEN_MARKET);
        int a4 = a2.a();
        if (a4 == 5) {
            com.ss.android.downloadlib.b.a.a(a3, jSONObject, eVar, true);
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
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(eVar.a, i);
        }
        return true;
    }

    public static void a(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        try {
            JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
            String optString = j2.optString(ak.aB);
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("aa"), optString);
            String a3 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("ac"), optString);
            String a4 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("af"), optString);
            boolean a5 = com.ss.android.socialbase.appdownloader.f.a.a(j2, context, a3);
            StringBuilder sb = new StringBuilder(String.format(a2, str, a4, a3));
            Intent intent = new Intent("android.intent.action.VIEW");
            String j3 = com.ss.android.socialbase.appdownloader.f.e.j();
            if (m.e(context, j3)) {
                intent.setPackage(j3);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            m.a(jSONObject, "mf", Boolean.valueOf(a5));
            m.a(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.b.a.a("am_kllk2", jSONObject, e, true);
            if (a5) {
                b(e, jSONObject, -1, 3, sb.toString());
            } else {
                b(e, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
            b(e, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    public static void a(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        try {
            JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
            String optString = j2.optString(ak.aB);
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("br"), optString);
            String a3 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bs_1"), optString);
            String a4 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bs_2"), optString);
            String a5 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bs_3"), optString);
            String a6 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bt"), optString);
            String a7 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bu"), optString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(a2);
            sb.append(a3);
            sb.append(a4);
            sb.append(a5);
            sb.append(a6);
            sb.append(a7);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=".concat(String.valueOf(str)));
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            m.a(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.h.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.g.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.k.d().a(12, com.ss.android.downloadlib.addownload.k.a(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            com.ss.android.downloadad.api.a.b bVar = e.e;
            if (bVar != null) {
                bVar.v(true);
            }
            com.ss.android.downloadlib.b.a.a("am_kllk3", jSONObject, e, true);
            b(e, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.a.b bVar2 = e.e;
            if (bVar2 != null) {
                bVar2.v(false);
            }
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))), e), e, true);
            b(e, jSONObject, 2, 7, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    private static boolean a(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str))));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", hashMap);
        String j = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j)) {
            intent.setPackage(j);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "start v1");
            return false;
        }
    }

    public static void a(@NonNull Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        try {
            JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
            boolean a2 = com.ss.android.socialbase.appdownloader.f.a.a(j2, activity, com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bg"), j2.optString(ak.aB)));
            HashMap<String, String> b = m.b(new JSONObject(str2));
            if (a2 && !b.isEmpty() && a(activity, str, b)) {
                b(e, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
                com.ss.android.downloadlib.b.a.a("am_v1", jSONObject, e, true);
                return;
            }
            if (a2) {
                i = b.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            b(e, jSONObject, i, 5, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.k.a(), Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
            b(e, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
        }
    }

    public static void a(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("bv"), j2.optString(ak.aB));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.SCHEME_MARKET).authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(a2)) {
            builder.appendQueryParameter(a2, str2);
        }
        if (a(activity, builder.build())) {
            b(e, jSONObject, -1, 8, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a("am_v2", jSONObject, e, true);
        } else {
            b(e, jSONObject, 2, 8, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
        }
    }

    public static boolean a(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String j = com.ss.android.socialbase.appdownloader.f.e.j();
        if (m.e(com.ss.android.downloadlib.addownload.k.a(), j)) {
            intent.setPackage(j);
        }
        if (!m.a(com.ss.android.downloadlib.addownload.k.a(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "start v2");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent a2 = a(context, aVar, str, 1, (String) null);
        if (a2 != null) {
            l.a().a(a, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.b.g a3 = a(a2, true, context, str, aVar);
            if (a3.a() == 3) {
                return a3;
            }
        }
        Intent g = m.g(context, str);
        if (g == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        return a(g, false, context, str, aVar);
    }

    private static com.ss.android.downloadlib.addownload.b.g a(Intent intent, boolean z, Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.k.j().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.k.m() != null && com.ss.android.downloadlib.addownload.k.m().a() && aVar.q() && !z) {
            TTDelegateActivity.b(str, aVar);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception e) {
            if (z) {
                l.a().b(a, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.b.g(8, 23);
            }
            l.a().b(a, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.b.g a(String str, com.ss.android.downloadad.api.a.a aVar) {
        return a(com.ss.android.downloadlib.addownload.k.a(), str, aVar);
    }

    private static com.ss.android.downloadlib.addownload.b.g a(Context context, Intent intent, com.ss.android.downloadad.api.a.a aVar, boolean z, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        if (m.b(context, intent)) {
            if (com.ss.android.downloadlib.addownload.k.j().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.k.m() != null && com.ss.android.downloadlib.addownload.k.m().a() && Build.VERSION.SDK_INT >= 26 && aVar.q() && !z) {
                TTDelegateActivity.a(str, aVar);
                return new com.ss.android.downloadlib.addownload.b.g(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.b.g(1);
            } catch (Exception e) {
                if (z) {
                    l.a().b(a, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.b.g(9);
                }
                l.a().b(a, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.b.g(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.b.g(2, 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.b.g a(@NonNull com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.b.g b = b(str, bVar);
        return (com.ss.android.downloadlib.b.f.a(bVar) && b.a() == 2) ? a(str2, bVar) : b;
    }

    public static void a(@NonNull Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject j2 = com.ss.android.downloadlib.addownload.k.j();
        String optString = j2.optString(ak.aB);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("ca"), optString);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(j2.optString("cc"), optString);
        StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
            sb.append(str);
            sb.append("&");
            sb.append(a2);
            sb.append("=");
            sb.append(a3);
        }
        if (c(activity, Uri.parse(sb.toString()))) {
            b(e, jSONObject, -1, 10, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a("am_hr2", jSONObject, e, true);
        } else {
            b(e, jSONObject, 2, 10, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
            com.ss.android.downloadlib.b.a.a(a((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)))), e, true);
        }
    }

    private static Intent a(Context context, com.ss.android.downloadad.api.a.a aVar, String str, int i, String str2) {
        if (!aVar.c() || aVar.w() == null || aVar.w().getDownloadMode() != 2 || aVar.u() == null || e.a(aVar).a("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String c2 = com.ss.android.downloadlib.addownload.i.c(aVar.u());
        String d = com.ss.android.downloadlib.addownload.i.d(aVar.u());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(c2) || resolveActivity == null) {
            return null;
        }
        intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, c2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(d)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, d);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
