package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class c extends com.sigmob.sdk.base.common.j {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Activity activity, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
    }

    protected void a(boolean z) {
        if (z) {
            this.d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, int i, Bundle bundle) {
        Window window;
        try {
            a(context.getApplicationContext(), i, bundle);
            boolean z = bundle.getBoolean(com.sigmob.sdk.base.k.u, false);
            boolean z2 = bundle.getBoolean(com.sigmob.sdk.base.k.t, false);
            if (Build.VERSION.SDK_INT >= 27) {
                if (z) {
                    n().setTurnScreenOn(true);
                }
                if (z2) {
                    n().setShowWhenLocked(true);
                    n().setTurnScreenOn(true);
                }
                if (z) {
                    n().getWindow().addFlags(128);
                }
                if (!z2) {
                    return;
                } else {
                    window = n().getWindow();
                }
            } else {
                if (z) {
                    n().getWindow().addFlags(128);
                }
                if (!z2) {
                    return;
                } else {
                    window = n().getWindow();
                }
            }
            window.addFlags(2621440);
        } catch (Throwable th) {
            SigmobLog.e("optionSetting error", th);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        this.d.onSetContentView(this.f388c);
    }
}
