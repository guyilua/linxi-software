package com.qumeng.advlib.open.oaid.qma;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.qumeng.advlib.open.oaid.OAIDException;
import com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a;
import com.qumeng.advlib.open.oaid.qma.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class b implements com.qumeng.advlib.open.oaid.b {
    private final Context a;
    private String b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements f.a {
        a() {
        }

        @Override // com.qumeng.advlib.open.oaid.qma.f.a
        public String a(IBinder iBinder) {
            com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a a = a.b.a(iBinder);
            if (!a.b()) {
                return a.g();
            }
            throw new OAIDException("User has disabled advertising identifier");
        }
    }

    public b(Context context) {
        this.a = context;
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        Context context = this.a;
        if (context == null || aVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    aVar.a(string);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            aVar.a(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        f.a(this.a, intent, aVar, new a());
    }
}
