package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t {
    static final int a = 50;
    static final long b = 3000000;
    private static final long d = 3000000;

    @SuppressLint({"UseSparseArrays"})
    private static final Map<String, a> e = Collections.synchronizedMap(new HashMap());

    /* renamed from: c, reason: collision with root package name */
    static final b f575c = new b();
    private static Handler f = new Handler();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private final com.sigmob.sdk.base.views.g a;
        private final WeakReference<v> b;

        /* renamed from: c, reason: collision with root package name */
        private final com.sigmob.sdk.base.common.t f576c;
        private final d d;

        a(com.sigmob.sdk.base.views.g gVar, v vVar, com.sigmob.sdk.base.common.t tVar, d dVar) {
            this.a = gVar;
            this.b = new WeakReference<>(vVar);
            this.f576c = tVar;
            this.d = dVar;
        }

        public com.sigmob.sdk.base.views.g a() {
            return this.a;
        }

        public WeakReference<v> b() {
            return this.b;
        }

        public com.sigmob.sdk.base.common.t c() {
            return this.f576c;
        }

        public d d() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a();
        }
    }

    private t() {
    }

    public static a a(String str) {
        Preconditions.checkNotNull(str);
        return e.remove(str);
    }

    static synchronized void a() {
        synchronized (t.class) {
            Iterator<Map.Entry<String, a>> it = e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, a> next = it.next();
                if (next.getValue().b().get() == null) {
                    next.getValue().c().a();
                    it.remove();
                }
            }
            if (!e.isEmpty()) {
                Handler handler = f;
                b bVar = f575c;
                handler.removeCallbacks(bVar);
                f.postDelayed(bVar, 3000000L);
            }
        }
    }

    @Deprecated
    static void a(Handler handler) {
        f = handler;
    }

    public static void a(String str, e eVar, com.sigmob.sdk.base.views.g gVar, com.sigmob.sdk.base.common.t tVar, d dVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(eVar);
        Preconditions.checkNotNull(gVar);
        a();
        Map<String, a> map = e;
        if (map.size() >= 50) {
            SigmobLog.w("Unable to cache web view. Please destroy some via #destroy() and try again.");
        } else {
            map.put(str, new a(gVar, eVar, tVar, dVar));
        }
    }

    @Deprecated
    public static void b() {
        e.clear();
        f.removeCallbacks(f575c);
    }

    @Deprecated
    static Map<String, a> c() {
        return e;
    }
}
