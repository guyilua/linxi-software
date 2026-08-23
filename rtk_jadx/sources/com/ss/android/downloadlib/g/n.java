package com.ss.android.downloadlib.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n extends Handler {
    WeakReference<a> a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(Message message);
    }

    public n(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
