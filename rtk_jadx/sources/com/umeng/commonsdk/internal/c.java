package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements UMLogDataProtocol {
    public static final String a = "um_policy_grant";
    public static final String b = "preInitInvokedFlag";

    /* renamed from: c, reason: collision with root package name */
    public static final String f1091c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private static int f = 1;
    private static final String g = "info";
    private static final String h = "stat";
    private static Class<?> i = null;
    private static Method j = null;
    private static Method k = null;
    private static Method l = null;
    private static boolean m = false;
    private Context e;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || l == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) l.invoke(invoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                i = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    j = declaredMethod;
                }
                Method declaredMethod2 = i.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    k = declaredMethod2;
                }
                Method declaredMethod3 = i.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    l = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        am a2 = am.a(this.e);
        an a3 = a2.a(ao.f1020c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.a;
                String str2 = a3.b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.e.getApplicationContext(), new JSONObject(a3.f1019c), new JSONObject(a3.d), a3.e, str2, a3.f);
                if (a4 != null && a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                a2.a(ao.f1020c, str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (!m) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
                return;
            }
            m = true;
            a(this.e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            SharedPreferences sharedPreferences = c.this.e.getSharedPreferences(h.a, 0);
                            if (sharedPreferences != null) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString(h.b, str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                        UMWorkDispatch.sendEvent(c.this.e, a.w, b.a(c.this.e).a(), null);
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                }
            });
            return;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return;
        }
        m = false;
    }

    private void f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        m = true;
        UMConfigureImpl.registerInterruptFlag();
        UMConfigureImpl.init(this.e);
        f++;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
        UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
            @Override // com.umeng.commonsdk.utils.onMessageSendListener
            public void onMessageSend() {
                if (c.this.e != null) {
                    UMWorkDispatch.sendEvent(c.this.e, a.x, b.a(c.this.e).a(), null);
                }
                UMConfigureImpl.removeMessageSendListener(this);
            }
        });
        b(this.e);
    }

    private void g() {
        if (f <= 0) {
            h();
            d(this.e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.e)) {
            e(this.e);
            com.umeng.commonsdk.a.a(this.e);
            Context context = this.e;
            UMWorkDispatch.sendEvent(context, o.a.x, CoreProtocol.getInstance(context), null);
            Context context2 = this.e;
            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x019c A[Catch: all -> 0x0331, TryCatch #0 {all -> 0x0331, blocks: (B:4:0x001f, B:9:0x004f, B:16:0x0067, B:18:0x0081, B:20:0x0087, B:21:0x0097, B:23:0x00c0, B:29:0x00ca, B:31:0x00ce, B:33:0x00e0, B:51:0x0158, B:53:0x016f, B:55:0x017a, B:58:0x0181, B:60:0x0187, B:62:0x0192, B:66:0x019c, B:68:0x01a2, B:70:0x01ae, B:72:0x01b5), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5 A[Catch: all -> 0x0331, TRY_LEAVE, TryCatch #0 {all -> 0x0331, blocks: (B:4:0x001f, B:9:0x004f, B:16:0x0067, B:18:0x0081, B:20:0x0087, B:21:0x0097, B:23:0x00c0, B:29:0x00ca, B:31:0x00ce, B:33:0x00e0, B:51:0x0158, B:53:0x016f, B:55:0x017a, B:58:0x0181, B:60:0x0187, B:62:0x0192, B:66:0x019c, B:68:0x01a2, B:70:0x01ae, B:72:0x01b5), top: B:2:0x001a }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void workEvent(java.lang.Object r11, int r12) {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || k == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) k.invoke(invoke, this.e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = aa.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f1108c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.b, a2);
                        edit2.commit();
                    }
                    if (Build.VERSION.SDK_INT > 28) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put("app_version", UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(ak.x, "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
            @Override // com.umeng.commonsdk.listener.OnGetOaidListener
            public void onGetOaid(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    if (sharedPreferences == null || sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                        return;
                    }
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(h.b, str);
                    edit.commit();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void e(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + ao.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = aa.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void d(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new Object[0])) == null || (declaredMethod = a2.getDeclaredMethod(PointCategory.INIT, Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }
}
