package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CookieSyncManager {
    private static android.webkit.CookieSyncManager a = null;
    private static CookieSyncManager b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f927c = false;

    private CookieSyncManager(Context context) {
        t a2 = t.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        f927c = true;
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            a = android.webkit.CookieSyncManager.createInstance(context);
            if (b == null || !f927c) {
                b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            cookieSyncManager = b;
            if (cookieSyncManager == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
        }
        return cookieSyncManager;
    }

    public void startSync() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(a)).setUncaughtExceptionHandler(new e());
        } catch (Exception unused) {
        }
    }

    public void stopSync() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        } else {
            a.stopSync();
        }
    }

    public void sync() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        } else {
            a.sync();
        }
    }
}
