package com.qumeng.advlib.open.oaid.qma;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.qumeng.advlib.open.oaid.OAIDException;
import com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a;
import com.qumeng.advlib.open.oaid.qma.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class h implements com.qumeng.advlib.open.oaid.b {
    private final Context a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements f.a {
        a() {
        }

        @Override // com.qumeng.advlib.open.oaid.qma.f.a
        public String a(IBinder iBinder) {
            com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a a = a.b.a(iBinder);
            if (a != null) {
                return a.a();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public h(Context context) {
        this.a = context;
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        f.a(this.a, intent, aVar, new a());
    }
}
