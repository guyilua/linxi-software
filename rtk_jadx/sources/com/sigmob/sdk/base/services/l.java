package com.sigmob.sdk.base.services;

import android.content.Context;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.IntentUtil;
import com.sigmob.sdk.base.services.j;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l implements j.a {
    k b = k.STOP;
    WifiScanReceiver a = new WifiScanReceiver();

    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        IntentUtil.registerReceiver(context, this.a, intentFilter);
    }

    public void b(Context context) {
        context.unregisterReceiver(this.a);
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean e() {
        k kVar = this.b;
        k kVar2 = k.RUNNING;
        if (kVar == kVar2) {
            return false;
        }
        a(com.sigmob.sdk.b.e());
        this.b = kVar2;
        return true;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k f() {
        return this.b;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void g() {
        if (this.b == k.RUNNING) {
            b(com.sigmob.sdk.b.e());
            this.b = k.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error h() {
        return null;
    }
}
