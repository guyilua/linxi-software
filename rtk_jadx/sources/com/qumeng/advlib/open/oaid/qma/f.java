package com.qumeng.advlib.open.oaid.qma;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.qumeng.advlib.open.oaid.OAIDException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class f implements ServiceConnection {
    private final Context a;
    private final com.qumeng.advlib.open.oaid.a b;

    /* renamed from: c, reason: collision with root package name */
    private final a f31c;

    @FunctionalInterface
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        String a(IBinder iBinder);
    }

    private f(Context context, com.qumeng.advlib.open.oaid.a aVar, a aVar2) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
        this.b = aVar;
        this.f31c = aVar2;
    }

    public static void a(Context context, Intent intent, com.qumeng.advlib.open.oaid.a aVar, a aVar2) {
        new f(context, aVar, aVar2).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        String a2;
        try {
            try {
                try {
                    a2 = this.f31c.a(iBinder);
                } catch (Exception e) {
                    this.b.a(e);
                    context = this.a;
                }
                if (a2 != null && a2.length() != 0) {
                    this.b.a(a2);
                    context = this.a;
                    context.unbindService(this);
                    return;
                }
                throw new OAIDException("OAID/AAID acquire failed");
            } catch (Throwable th) {
                try {
                    this.a.unbindService(this);
                } catch (Exception unused) {
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    private void a(Intent intent) {
        try {
            if (this.a.bindService(intent, this, 1)) {
            } else {
                throw new OAIDException("Service binding failed");
            }
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
