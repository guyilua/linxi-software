package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: CoolpadDeviceIdSupplier.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ab implements z {
    private static final String a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1012c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static a d;
    private CountDownLatch f;
    private Context g;
    private String e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.d = a.AbstractBinderC0121a.a(iBinder);
                ab.this.e = ab.d.b(ab.this.g.getPackageName());
                Log.d(ab.a, "onServiceConnected: oaid = " + ab.this.e);
            } catch (RemoteException | NullPointerException e) {
                Log.e(ab.a, "onServiceConnected failed e=" + e.getMessage());
            }
            ab.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.a, "onServiceDisconnected");
            a unused = ab.d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, f1012c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(a, "bindService return false");
        } catch (Throwable th) {
            Log.e(a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(a, "getOAID time-out");
            }
            return this.e;
        } catch (InterruptedException e) {
            Log.e(a, "getOAID interrupted. e=" + e.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
