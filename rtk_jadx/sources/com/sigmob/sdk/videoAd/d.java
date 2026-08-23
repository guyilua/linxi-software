package com.sigmob.sdk.videoAd;

import android.os.Handler;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d extends RepeatingHandlerRunnable {
    private final n a;
    private final a b;

    public d(n nVar, a aVar, Handler handler) {
        super(handler);
        Preconditions.NoThrow.checkNotNull(nVar);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.a = nVar;
        this.b = aVar;
    }

    public void doWork() {
    }
}
