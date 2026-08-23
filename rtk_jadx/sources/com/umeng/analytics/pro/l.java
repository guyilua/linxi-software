package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoViewPageTracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    public static String a;
    boolean b;

    /* renamed from: c, reason: collision with root package name */
    boolean f1055c;
    com.umeng.analytics.vshelper.a f;
    Application.ActivityLifecycleCallbacks g;
    private final Map<String, Long> h;
    private boolean l;
    private int m;
    private int n;
    private static JSONArray i = new JSONArray();
    private static Object j = new Object();
    private static Application k = null;
    static String d = null;
    static int e = -1;
    private static boolean o = true;
    private static Object p = new Object();
    private static ap q = new com.umeng.analytics.vshelper.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoViewPageTracker.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static final l a = new l();

        private a() {
        }
    }

    static /* synthetic */ int a(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int e(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.m;
        lVar.m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.l) {
            return;
        }
        this.l = true;
        if (k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        k.registerActivityLifecycleCallbacks(this.g);
    }

    private l() {
        this.h = new HashMap();
        this.l = false;
        this.b = false;
        this.f1055c = false;
        this.m = 0;
        this.n = 0;
        this.f = PageNameMonitor.getInstance();
        this.g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.b = false;
                    l.q.d(activity);
                    return;
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            boolean unused = l.o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.m <= 0) {
                        if (l.d == null) {
                            l.d = UUID.randomUUID().toString();
                        }
                        if (l.e == -1) {
                            l.e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            l.e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", l.d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (l.this.n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.m <= 0) {
                        if (l.e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = l.e;
                        if ((i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", l.d);
                            hashMap.put("reason", "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (l.d != null) {
                                l.d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (p) {
            if (o) {
                o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (j) {
                    jSONArray = i.toString();
                    i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(e.d.a.f1049c, new JSONArray(jSONArray));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.l;
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (k == null && context != null) {
                if (context instanceof Activity) {
                    k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    k = (Application) context;
                }
            }
            lVar = a.a;
        }
        return lVar;
    }

    public static void a(Context context, String str) {
        if (e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", d);
            hashMap.put("reason", str);
            if (d != null) {
                d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.l = false;
        if (k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                k.unregisterActivityLifecycleCallbacks(this.g);
            }
            k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.h) {
                if (a == null && activity != null) {
                    a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(a) || !this.h.containsKey(a)) {
                    j3 = 0;
                } else {
                    long longValue = this.h.get(a).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    this.h.remove(a);
                    j2 = currentTimeMillis;
                    j3 = longValue;
                }
            }
            synchronized (j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(d.x, j3);
                    jSONObject.put(d.y, 0);
                    i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.h) {
            this.h.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f.activityResume(str);
            if (this.b) {
                this.b = false;
                if (!TextUtils.isEmpty(a)) {
                    if (a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                a = str;
                return;
            }
            b(activity);
            synchronized (p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
