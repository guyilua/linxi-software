package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;
    CopyOnWriteArrayList<b> a;
    String b;

    /* renamed from: c, reason: collision with root package name */
    a f924c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b {
        int a;
        String b;

        /* renamed from: c, reason: collision with root package name */
        String f926c;
        ValueCallback<Boolean> d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                if (d == null) {
                    d = new CookieManager();
                }
            }
        }
        return d;
    }

    public static int getROMCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        return sharedPreferences.getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.f = true;
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            t a2 = t.a();
            if (a2 != null && a2.b()) {
                Iterator<b> it = this.a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    int i = next.a;
                    if (i == 1) {
                        setCookie(next.b, next.f926c, next.d);
                    } else if (i == 2) {
                        setCookie(next.b, next.f926c);
                    }
                }
            } else {
                Iterator<b> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    b next2 = it2.next();
                    int i2 = next2.a;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            android.webkit.CookieManager.getInstance().setCookie(next2.b, next2.f926c);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, next2.b, next2.f926c, next2.d);
                    }
                }
            }
            this.a.clear();
        }
    }

    public boolean acceptCookie() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().d();
        }
        return android.webkit.CookieManager.getInstance().acceptCookie();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            Object invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        Object a3 = com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class}, webView.getView());
        if (a3 == null) {
            return false;
        }
        return ((Boolean) a3).booleanValue();
    }

    public void flush() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "flush", (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().a(str);
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().h();
        }
        return android.webkit.CookieManager.getInstance().hasCookies();
    }

    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().e();
        } else {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public void removeExpiredCookie() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        } else {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        }
    }

    public void removeSessionCookie() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        } else {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.f924c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (aVar == a.MODE_NONE || !z || t.a().d()) {
            return true;
        }
        t.a().a(context);
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        t a2 = t.a();
        if ((a2 == null || !a2.b()) ? false : a2.c().a(map)) {
            return;
        }
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                setCookie(str, str2);
            }
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        } else {
            if (this.f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!t.a().d()) {
                b bVar = new b();
                bVar.a = 2;
                bVar.b = str;
                bVar.f926c = str2;
                bVar.d = null;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(Context context, boolean z, boolean z2) {
        int i;
        int d2;
        if (this.f924c != a.MODE_NONE && context != null && TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) && !this.e) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (!z && !QbSdk.getIsSysWebViewForcedByOuter() && !QbSdk.a) {
                t.a().a(context);
                return;
            }
            int i2 = 0;
            r4 = false;
            r4 = false;
            boolean z3 = false;
            if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                z2 = false;
            }
            boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
            TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
            TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
            if (canUseFunction == z2) {
                return;
            }
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            if (!TextUtils.isEmpty(this.b)) {
                if (l.a().i(context) > 0 && l.a().i(context) < 36001) {
                    return;
                }
                if (canUseFunction) {
                    d2 = h.d(context);
                    if (d2 > 0) {
                        i = getROMCookieDBVersion(context);
                        if (i <= 0) {
                            z3 = true;
                        }
                    }
                    i = 0;
                } else {
                    d2 = h.d(context);
                    if (d2 > 0) {
                        String d3 = l.a().d(context, "cookies_database_version");
                        if (!TextUtils.isEmpty(d3)) {
                            try {
                                i = Integer.parseInt(d3);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    i = 0;
                }
                if (!z3 && (d2 <= 0 || i <= 0)) {
                    tbsLogInfo.setErrorCode(702);
                } else if (i >= d2) {
                    tbsLogInfo.setErrorCode(703);
                } else {
                    h.a(context, this.f924c, this.b, z3, z2);
                    tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_COOKIE_SWITCH_TRANSFER);
                    j = System.currentTimeMillis() - currentTimeMillis;
                }
                i2 = d2;
            } else {
                tbsLogInfo.setErrorCode(701);
                i = 0;
            }
            tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i2 + " to:" + i + ",timeused:" + j);
            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
        }
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        } else {
            if (!t.a().d()) {
                b bVar = new b();
                bVar.a = 1;
                bVar.b = str;
                bVar.f926c = str2;
                bVar.d = valueCallback;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
            if (this.f) {
                if (Build.VERSION.SDK_INT < 21) {
                } else {
                    com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
                }
            }
        }
    }
}
