package com.sigmob.sdk.base.services;

import android.content.Context;
import android.content.IntentFilter;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.services.j;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements j.a {
    c a;
    k b = k.STOP;

    public d() {
        if (this.a == null) {
            this.a = new c();
        }
    }

    public void a(Context context) {
        u.a(context, this.a, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), true);
    }

    public void b(Context context) {
        context.unregisterReceiver(this.a);
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean e() {
        a(com.sigmob.sdk.b.e());
        this.b = k.RUNNING;
        return false;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k f() {
        return null;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void g() {
        b(com.sigmob.sdk.b.e());
        this.b = k.STOP;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error h() {
        return null;
    }
}
