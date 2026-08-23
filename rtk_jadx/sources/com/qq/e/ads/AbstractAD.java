package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class AbstractAD<T> {
    private static final AtomicBoolean g = new AtomicBoolean(true);
    protected T a;
    private volatile boolean e;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1c = false;
    private volatile boolean d = false;
    private volatile long f = -1;
    private final Handler b = new Handler(Looper.getMainLooper());

    static void b(AbstractAD abstractAD) {
        if (abstractAD.f > 0) {
            try {
                GlobalSetting.getSettings().putOpt("gdtwict", Long.valueOf(SystemClock.elapsedRealtime() - abstractAD.f));
            } catch (Throwable unused) {
            }
        }
    }

    private void e(final Context context, final String str, final String str2) {
        this.e = true;
        if (a.b().d()) {
            final String a = a.b().a();
            if (com.qq.e.comm.a.a(context)) {
                this.d = true;
                a.g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = a.b().c().getPOFactory();
                            AbstractAD.this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.a = (T) abstractAD.a(context, pOFactory2, a, str, str2);
                                            AbstractAD.this.f1c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            if (abstractAD2.a == null) {
                                                abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                AbstractAD.b(abstractAD2);
                                                AbstractAD abstractAD3 = AbstractAD.this;
                                                abstractAD3.a((AbstractAD) abstractAD3.a);
                                            }
                                        } else {
                                            AbstractAD.this.f1c = true;
                                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                        AbstractAD.this.f1c = true;
                                        AbstractAD.this.a(ErrorCode.INIT_ERROR);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                            AbstractAD.this.f1c = true;
                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            } else {
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                a(ErrorCode.MANIFEST_ERROR);
                return;
            }
        }
        a(ErrorCode.NOT_INIT);
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i);
        } else {
            this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            e(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return this.e && this.d;
    }

    protected abstract void b(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        if (!this.f1c && g.compareAndSet(true, false)) {
            this.f = SystemClock.elapsedRealtime();
        }
        return this.f1c;
    }
}
