package com.qumeng.advlib.open.oaid.qma;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.qumeng.advlib.open.oaid.OAIDException;
import com.qumeng.advlib.open.oaid.qm.qm.qm.a;
import com.qumeng.advlib.open.oaid.qma.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d implements com.qumeng.advlib.open.oaid.b {
    private final Context a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements f.a {
        a() {
        }

        @Override // com.qumeng.advlib.open.oaid.qma.f.a
        public String a(IBinder iBinder) {
            com.qumeng.advlib.open.oaid.qm.qm.qm.a a = a.b.a(iBinder);
            if (a != null) {
                if (a.e()) {
                    return a.a();
                }
                throw new OAIDException("MsaIdInterface#isSupported return false");
            }
            throw new OAIDException("MsaIdInterface is null");
        }
    }

    public d(Context context) {
        this.a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        f.a(this.a, intent, aVar, new a());
    }
}
