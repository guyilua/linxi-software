package com.qumeng.advlib.open.oaid.qma;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qumeng.advlib.open.oaid.OAIDException;
import com.qumeng.advlib.open.oaid.qm.qma.qm.a;
import com.qumeng.advlib.open.oaid.qma.f;
import java.security.MessageDigest;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class g implements com.qumeng.advlib.open.oaid.b {
    private final Context a;
    private String b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements f.a {
        a() {
        }

        @Override // com.qumeng.advlib.open.oaid.qma.f.a
        public String a(IBinder iBinder) {
            try {
                return g.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public g(Context context) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        f.a(this.a, intent, aVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) {
        String packageName = this.a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.b = sb2;
            return a(iBinder, packageName, sb2);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) {
        com.qumeng.advlib.open.oaid.qm.qma.qm.a a2 = a.b.a(iBinder);
        if (a2 != null) {
            return a2.a(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
