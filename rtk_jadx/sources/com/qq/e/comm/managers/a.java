package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements IGDTAdManager {
    public static final ExecutorService g = Executors.newSingleThreadExecutor();
    private volatile boolean a;
    private volatile boolean b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Context f19c;
    private volatile PM d;
    private volatile DevTools e;
    private volatile String f;

    /* renamed from: com.qq.e.comm.managers.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class RunnableC0003a implements Runnable {
        final /* synthetic */ GDTAdSdk.OnStartListener a;

        RunnableC0003a(GDTAdSdk.OnStartListener onStartListener) {
            this.a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(a.this.d.getStartCaller(1));
                    GDTAdSdk.OnStartListener onStartListener = this.a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    GDTAdSdk.OnStartListener onStartListener2 = this.a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new Exception("GDTAdSdk start异常"));
                    }
                }
            } catch (e e) {
                GDTLogger.e(e.getMessage(), e);
                GDTAdSdk.OnStartListener onStartListener3 = this.a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class b {
        private static a a = new a(null);
    }

    private a() {
        this.a = false;
        this.b = false;
    }

    /* synthetic */ a(RunnableC0003a runnableC0003a) {
        this();
    }

    public static a b() {
        return b.a;
    }

    public String a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(GDTAdSdk.OnStartListener onStartListener) {
        if (this.a) {
            g.submit(new RunnableC0003a(onStartListener));
            return;
        }
        GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }

    public PM c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(Context context, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
            return false;
        }
        if (this.a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f = str;
            this.f19c = context.getApplicationContext();
            this.d = new PM(this.f19c, null);
            g.submit(new com.qq.e.comm.managers.b(this, z));
            this.a = true;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public boolean d() {
        if (this.a) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.d.getPOFactory().getBuyerId(map);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.e == null) {
            this.e = new DevTools();
        }
        return this.e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.d.getPOFactory().getSDKInfo(str);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.b) {
            return 0;
        }
        try {
            return this.d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return 0;
        }
    }
}
