package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InternalAgent.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";
    private static Context a = null;
    private static final String h = "sp_uapp";
    private static final String i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static String q = "";
    private static String r = "";
    private static final String s = "ekv_bl";
    private static final String t = "ekv_bl_ver";
    private static final String v = "ekv_wl";
    private static final String w = "ekv_wl_ver";
    private static final String z = "umsp_1";
    private ISysListener b;

    /* renamed from: c, reason: collision with root package name */
    private p f1009c;
    private v d;
    private k e;
    private u f;
    private l g;
    private boolean j;
    private volatile JSONObject k;
    private volatile JSONObject l;
    private volatile JSONObject m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;
    private m y;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalAgent.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.k == null) {
                this.k = new JSONObject();
            }
            if (this.l == null) {
                this.l = new JSONObject();
            }
            String string = sharedPreferences.getString(i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.k;
    }

    public JSONObject c() {
        return this.m;
    }

    public JSONObject d() {
        return this.l;
    }

    public void e() {
        this.l = null;
    }

    public String f() {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getOnResumedActivityName can not be called in child process");
            return null;
        }
        return q;
    }

    public String g() {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getOnPausedActivityName can not be called in child process");
            return null;
        }
        return r;
    }

    public void h() {
        try {
            Context context = a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = a;
                UMWorkDispatch.sendEvent(context2, 4352, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = a;
                UMWorkDispatch.sendEvent(context3, o.a.g, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        try {
            Context context = a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.f, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = a;
            UMWorkDispatch.sendEvent(context3, o.a.o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(a).edit();
            edit.putString(h, this.k.toString());
            edit.commit();
        } else {
            this.k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        return this.k;
    }

    public synchronized void m() {
        try {
            Context context = a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(a).edit();
                    edit.remove(h);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.D)) {
                if (UMWorkDispatch.eventHasExist(o.a.z)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = a;
                UMWorkDispatch.sendEvent(context, o.a.z, CoreProtocol.getInstance(context), null);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
        }
    }

    private b() {
        this.f1009c = new p();
        this.d = new v();
        this.e = new k();
        this.f = u.a();
        this.g = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.y = null;
        this.f1009c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (this.u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a("ekv_bl", "ekv_bl_ver");
                this.u = aVar;
                aVar.register(a);
            }
            if (this.x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b("ekv_wl", "ekv_wl_ver");
                this.x = bVar;
                bVar.register(a);
            }
            if (UMUtils.isMainProgress(a)) {
                if (!this.j) {
                    this.j = true;
                    i(a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.n) {
                            l a2 = l.a(context);
                            this.g = a2;
                            if (a2.a()) {
                                this.n = true;
                            }
                            this.y = m.a();
                            try {
                                m.a(context);
                                this.y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    this.n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(a));
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context) {
        if (context == null) {
            UMLog.aq(j.p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.q, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            r = context.getClass().getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            l lVar = this.g;
            if (lVar != null) {
                lVar.c();
            }
            l.a(context, "onKillProcess");
            k kVar = this.e;
            if (kVar != null) {
                kVar.b();
            }
            v vVar = this.d;
            if (vVar != null) {
                vVar.b();
            }
            Context context2 = a;
            if (context2 != null) {
                u uVar = this.f;
                if (uVar != null) {
                    uVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(a).d();
                v.a(a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(a);
                }
                PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.k != null) {
            if (this.k.has(str)) {
                return this.k.opt(str);
            }
        } else {
            this.k = new JSONObject();
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        this.k = new JSONObject();
        Context context2 = a;
        UMWorkDispatch.sendEvent(context2, o.a.s, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.ap, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m.length() > 0) {
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.w, CoreProtocol.getInstance(context2), null);
        }
        this.m = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.o, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.aq, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = a;
                UMWorkDispatch.sendEvent(context2, o.a.h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = a;
                UMWorkDispatch.sendEvent(context3, o.a.d, CoreProtocol.getInstance(context3), null);
                Context context4 = a;
                UMWorkDispatch.sendEvent(context4, o.a.f1058c, CoreProtocol.getInstance(context4), null);
                Context context5 = a;
                UMWorkDispatch.sendEvent(context5, o.a.i, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.an, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.m.has(str)) {
                this.m.remove(str);
                Context context2 = a;
                UMWorkDispatch.sendEvent(context2, o.a.v, CoreProtocol.getInstance(context2), this.m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean c(String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (!this.x.enabled()) {
            return false;
        }
        if (!this.x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        if (this.k.has(str)) {
            this.k.remove(str);
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.t, CoreProtocol.getInstance(context2), str);
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(d.aE, str);
                a(a, d.aD, (Map<String, Object>) hashMap, -1L, false);
                return;
            }
            UMLog.aq(j.O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.k != null) {
            return this.k.toString();
        }
        this.k = new JSONObject();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.z, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        AnalyticsConfig.a(a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.b = iSysListener;
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        AnalyticsConfig.a(a, i2);
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(i).commit();
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(a);
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            s.a(a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i2 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i2 = 0;
        }
        if (i2 > 128) {
            MLog.e("key length is " + i2 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.w, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(d.Q, 2);
            jSONObject.put(d.R, str);
            jSONObject.put("__ii", this.f.c());
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.j, CoreProtocol.getInstance(context2), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.j || !this.n) {
                    a(a);
                }
                a(a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e) {
                if (MLog.DEBUG) {
                    MLog.e(e);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str3 = this.k.toString();
            }
            s.a(a).a(str, str2, j, i2, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, Map<String, Object> map, long j) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(d.aF).contains(str)) {
                UMLog.aq(j.b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(j.d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(d.aF).contains(it.next().getKey())) {
                    UMLog.aq(j.e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j, false);
            return;
        }
        UMLog.aq(j.f1054c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j, boolean z2) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                str2 = this.k.toString();
            }
            s.a(a).a(str, map, j, str2, z2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) {
        try {
            Context context = a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                v vVar = this.d;
                if (vVar != null) {
                    vVar.b();
                }
                l.a(a, "onAppCrash");
                k kVar = this.e;
                if (kVar != null) {
                    kVar.b();
                }
                l lVar = this.g;
                if (lVar != null) {
                    lVar.c();
                }
                u uVar = this.f;
                if (uVar != null) {
                    uVar.c(a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(d.Q, 1);
                    jSONObject.put(d.R, DataHelper.convertExceptionToString(th));
                    i.a(a).a(this.f.c(), jSONObject.toString(), 1);
                }
                o.a(a).d();
                v.a(a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(a);
                }
                PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (Exception e) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            Context context = a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.e, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = a;
            UMWorkDispatch.sendEvent(context3, o.a.o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z2) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d, double d2) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.a == null) {
            AnalyticsConfig.a = new double[2];
        }
        double[] dArr = AnalyticsConfig.a;
        dArr[0] = d;
        dArr[1] = d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(a, eScenarioType.toValue());
        }
        if (this.j && this.n) {
            return;
        }
        a(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j;
            y.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i2 = 0;
        if (context == null) {
            UMLog.aq(j.af, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.k == null) {
                    this.k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            Context context2 = a;
            UMWorkDispatch.sendEvent(context2, o.a.r, CoreProtocol.getInstance(context2), this.k.toString());
            return;
        }
        UMLog.aq(j.ag, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.k == null) {
                this.k = new JSONObject();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(h, this.k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(j.aj, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        s.a(a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(j.al, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (b(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.m = jSONObject2;
            if (this.m.length() > 0) {
                Context context2 = a;
                UMWorkDispatch.sendEvent(context2, o.a.u, CoreProtocol.getInstance(context2), this.m.toString());
            }
            return;
        }
        UMLog.aq(j.am, 0, "\\|");
    }
}
