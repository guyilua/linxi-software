package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aa extends Handler {
    static final int b = 87108;

    /* renamed from: c, reason: collision with root package name */
    long f603c;
    boolean d;

    public aa() {
        this.f603c = 100L;
        this.d = true;
    }

    public aa(Looper looper) {
        super(looper);
        this.f603c = 100L;
        this.d = true;
    }

    public void a() {
        sendEmptyMessageDelayed(b, this.f603c);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.d;
    }
}
