package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class C0131a {
        private final String a;
        private final boolean b;

        C0131a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.a;
        }

        public boolean a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private b() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (!this.a) {
                this.a = true;
                return this.b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0131a c2 = c(context);
            if (c2 != null && !c2.a()) {
                return c2.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0131a c2 = c(context);
            if (c2 == null) {
                return null;
            }
            return c2.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0131a c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        c cVar = new c(bVar.a());
                        boolean a = cVar.a(true);
                        return new C0131a(a ? "" : cVar.a(), a);
                    } catch (Exception e) {
                        throw e;
                    }
                } finally {
                    context.unbindService(bVar);
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class c implements IInterface {
        private IBinder a;

        public c(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
