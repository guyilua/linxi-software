package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.i.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private Application a;
    private c b;

    /* renamed from: c, reason: collision with root package name */
    private final List<InterfaceC0086a> f829c;
    private int d;
    private WeakReference<Activity> e;
    private volatile int f;
    private volatile boolean g;
    private final Application.ActivityLifecycleCallbacks h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0086a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private static final a a = new a();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f829c) {
            array = this.f829c.size() > 0 ? this.f829c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f = 1;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0086a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = 0;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0086a) obj).c();
            }
        }
    }

    private boolean g() {
        try {
            Application application = this.a;
            if (application == null) {
                return false;
            }
            application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), f.d(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private a() {
        this.f829c = new ArrayList();
        this.f = -1;
        this.g = false;
        this.h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.g = true;
                if (a.this.d != 0 || activity == null) {
                    return;
                }
                a.this.d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = a.this.d;
                a.this.g = false;
                a.this.d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.e = new WeakReference(activity);
                int i = a.this.d;
                a.this.d = activity != null ? activity.hashCode() : i;
                a.this.g = false;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.d) {
                    a.this.d = 0;
                    a.this.f();
                }
                a.this.g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    public boolean b() {
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            ?? g = g();
            this.f = g;
            i2 = g;
        }
        return i2 == 1;
    }

    public boolean c() {
        return b() && !this.g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC0086a interfaceC0086a) {
        synchronized (this.f829c) {
            this.f829c.remove(interfaceC0086a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a(InterfaceC0086a interfaceC0086a) {
        if (interfaceC0086a == null) {
            return;
        }
        synchronized (this.f829c) {
            if (!this.f829c.contains(interfaceC0086a)) {
                this.f829c.add(interfaceC0086a);
            }
        }
    }
}
