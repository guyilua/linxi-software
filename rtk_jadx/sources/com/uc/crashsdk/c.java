package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    private void a(Activity activity, int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (1 == i) {
            String unused = b.ac = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ac = "";
        }
        b.A();
        if (g.J()) {
            b.L();
            weakHashMap = b.aa;
            synchronized (weakHashMap) {
                weakHashMap2 = b.aa;
                weakHashMap2.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (g.J()) {
            b.L();
            weakHashMap = b.aa;
            synchronized (weakHashMap) {
                weakHashMap2 = b.aa;
                weakHashMap2.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (e.t()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i;
        if (!z2) {
            weakHashMap2 = b.aa;
            Iterator it = weakHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
        }
        z = z2;
        if (this.a != z) {
            b.b(z);
            this.a = z;
        }
        weakHashMap = b.aa;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.b != isEmpty) {
            if (isEmpty) {
                b.t();
            }
            this.b = isEmpty;
        }
    }
}
