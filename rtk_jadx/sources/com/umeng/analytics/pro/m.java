package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.constants.ErrorCode;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* compiled from: BackgroundMonitor.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m implements Application.ActivityLifecycleCallbacks {
    private static m a = new m();
    private final int b = ErrorCode.NETWORK_UNKNOWN;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1056c = false;
    private boolean d = true;
    private Handler e = new Handler(Looper.getMainLooper());
    private ArrayList<n> f = new ArrayList<>();
    private a g = new a();

    /* compiled from: BackgroundMonitor.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f1056c && m.this.d) {
                m.this.f1056c = false;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
                for (int i = 0; i < m.this.f.size(); i++) {
                    ((n) m.this.f.get(i)).n();
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.d = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
            this.e.postDelayed(this.g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.d = false;
        this.f1056c = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) == nVar) {
                    this.f.remove(i);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static m a() {
        return a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f.add(nVar);
        }
    }
}
