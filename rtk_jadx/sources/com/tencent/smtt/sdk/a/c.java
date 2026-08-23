package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.FileProvider;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: MttLoader.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {

    /* compiled from: MttLoader.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        public int a = -1;
        public int b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f954c = "";
        public String d = "0";
        public String e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MttLoader.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        public String a;
        public String b;

        private b() {
            this.a = "";
            this.b = "";
        }
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        Set<String> keySet;
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str3 : keySet) {
                    String str4 = hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra(str3, str4);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            Uri a2 = a(context, str);
            if (a2 == null) {
                return false;
            }
            intent.setDataAndType(a2, "mtt/" + str2);
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context) {
        return a(context).a != -1;
    }

    public static boolean c(Context context) {
        a a2 = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a2.d).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (a2.b >= 601500) {
            return true;
        }
        return z;
    }

    private static int d(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals(TbsConfig.APP_QQ)) {
            return 13;
        }
        if (str.equals(TbsConfig.APP_QZONE)) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals("com.tencent.mm") ? 24 : 26;
    }

    private static Uri a(Context context, String str) {
        return FileProvider.a(context, str);
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        boolean z;
        Set<String> keySet;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null && (keySet = hashMap.keySet()) != null) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:2|3)|(3:7|8|(8:10|11|12|(1:14)|15|(1:17)(1:21)|18|19))|25|11|12|(0)|15|(0)(0)|18|19) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r4, java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.String> r6, java.lang.String r7, com.tencent.smtt.sdk.WebView r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L1d
            java.lang.String r3 = "com.tencent.mtt"
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L1d
            int r2 = r2.versionCode     // Catch: java.lang.Throwable -> L1d
            r3 = 601000(0x92ba8, float:8.4218E-40)
            if (r2 <= r3) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.String r3 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r5, r3)     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L27
            r5 = r1
        L27:
            r1 = r2
            goto L2a
        L29:
        L2a:
            if (r1 == 0) goto L2f
            java.lang.String r1 = ",encoded=1"
            goto L31
        L2f:
            java.lang.String r1 = ""
        L31:
            java.lang.String r2 = "mttbrowser://url="
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = ",product="
            r0.append(r5)
            java.lang.String r5 = "TBS"
            r0.append(r5)
            java.lang.String r5 = ",packagename="
            r0.append(r5)
            java.lang.String r5 = r4.getPackageName()
            r0.append(r5)
            java.lang.String r5 = ",from="
            r0.append(r5)
            r0.append(r7)
            java.lang.String r5 = ",version="
            r0.append(r5)
            java.lang.String r5 = "4.3.0.1148"
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            int r4 = a(r4, r5, r6, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.c.a(android.content.Context, java.lang.String, java.util.HashMap, java.lang.String, com.tencent.smtt.sdk.WebView):int");
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        Set<String> keySet;
        if (context == null) {
            return 3;
        }
        if (!a(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            a a2 = a(context);
            int i = a2.a;
            if (i == -1) {
                return 4;
            }
            if (i == 2 && a2.b < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            int i2 = a2.a;
            if (i2 == 2) {
                int i3 = a2.b;
                if (i3 >= 33 && i3 <= 39) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                } else if (i3 >= 40 && i3 <= 45) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                } else if (i3 >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a3 = a(context, parse);
                    if (a3 != null && !TextUtils.isEmpty(a3.a)) {
                        intent.setClassName(a3.b, a3.a);
                    }
                }
            } else if (i2 == 1) {
                int i4 = a2.b;
                if (i4 == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                } else if (i4 == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (i2 == 0) {
                int i5 = a2.b;
                if (i5 >= 4 && i5 <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (i5 > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a4 = a(context, parse);
                    if (a4 != null && !TextUtils.isEmpty(a4.a)) {
                        intent.setClassName(a4.b, a4.a);
                    }
                }
            } else {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                b a5 = a(context, parse);
                if (a5 != null && !TextUtils.isEmpty(a5.a)) {
                    intent.setClassName(a5.b, a5.a);
                }
            }
            intent.setData(parse);
            if (hashMap != null && (keySet = hashMap.keySet()) != null) {
                for (String str2 : keySet) {
                    String str3 = hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
            try {
                intent.putExtra("loginType", d(context));
                intent.addFlags(268435456);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException unused) {
                return 4;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    private static b a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                bVar.a = activityInfo.name;
                bVar.b = activityInfo.packageName;
                return bVar;
            }
            if (str.contains("com.tencent.qbx")) {
                ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                bVar.a = activityInfo2.name;
                bVar.b = activityInfo2.packageName;
            }
        }
        return bVar;
    }

    public static a a(Context context) {
        int i;
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        a aVar = new a();
        if (z) {
            return aVar;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.a = 2;
                aVar.e = TbsConfig.APP_QB;
                aVar.f954c = "ADRQB_";
                if (packageInfo != null && (i = packageInfo.versionCode) > 420000) {
                    aVar.b = i;
                    aVar.f954c += packageInfo.versionName.replaceAll("\\.", "");
                    aVar.d = packageInfo.versionName.replaceAll("\\.", "");
                    return aVar;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            try {
                try {
                    try {
                        try {
                            try {
                                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                                aVar.a = 0;
                                aVar.e = "com.tencent.qbx";
                                aVar.f954c = "ADRQBX_";
                            } catch (PackageManager.NameNotFoundException unused2) {
                                packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                                aVar.e = "com.tencent.mtt.x86";
                                aVar.a = 2;
                                aVar.f954c = "ADRQB_";
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (PackageManager.NameNotFoundException unused4) {
                        packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                        aVar.a = 1;
                        aVar.e = "com.tencent.qbx5";
                        aVar.f954c = "ADRQBX5_";
                    }
                } catch (Exception unused5) {
                    b a2 = a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                    if (a2 != null && !TextUtils.isEmpty(a2.b)) {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(a2.b, 0);
                        try {
                            aVar.e = a2.b;
                            aVar.a = 2;
                            aVar.f954c = "ADRQB_";
                        } catch (Exception unused6) {
                        }
                        packageInfo = packageInfo2;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused7) {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.e = TbsConfig.APP_QB;
                aVar.a = 2;
                aVar.f954c = "ADRQB_";
            }
            if (packageInfo != null) {
                aVar.b = packageInfo.versionCode;
                aVar.f954c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception unused8) {
        }
        return aVar;
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase().contains("://");
        }
        return false;
    }

    public static boolean a(Context context, long j, long j2) {
        boolean z = false;
        try {
            if (Long.valueOf(a(context).d).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (r5.b >= j2) {
            return true;
        }
        return z;
    }
}
