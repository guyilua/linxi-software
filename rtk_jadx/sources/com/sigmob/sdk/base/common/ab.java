package com.sigmob.sdk.base.common;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ab {
    private static final String a = "NativeLoadReadyRecordManager";
    private static ab f = new ab();
    private boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f359c = 120;
    private HandlerThread d;
    private Handler e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ab.this.b) {
                ab.this.e.removeCallbacksAndMessages(null);
                HashMap<String, z> a = z.a();
                if (!a.isEmpty()) {
                    for (z zVar : a.values()) {
                        if (zVar != null) {
                            ae.a(zVar);
                            zVar.b();
                        }
                    }
                }
                ab.this.e.postDelayed(this, ab.this.f359c * 1000);
            }
        }
    }

    private ab() {
    }

    public static ab a() {
        return f;
    }

    public void a(int i) {
        if (i <= 0) {
            c();
            return;
        }
        int max = Math.max(i, 10);
        if (this.f359c == max) {
            return;
        }
        this.f359c = max;
        if (!this.b) {
            b();
        } else {
            this.e.removeCallbacksAndMessages(null);
            this.e.postDelayed(new a(), i * 1000);
        }
    }

    public synchronized void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        z.c();
        if (this.d == null) {
            HandlerThread handlerThread = new HandlerThread(a);
            this.d = handlerThread;
            handlerThread.start();
        }
        if (this.e == null) {
            this.e = new Handler(this.d.getLooper());
        }
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(new a(), this.f359c * 1000);
    }

    public void c() {
        this.b = false;
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
