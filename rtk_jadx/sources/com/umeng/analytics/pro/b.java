package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeviceIdService.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface b extends IInterface {
    String a();

    String a(String str);

    String b(String str);

    /* compiled from: IDeviceIdService.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements b {
        static final int a = 1;
        static final int b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f1022c = 3;
        private static final String d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public a() {
            attachInterface(this, d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0123a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(d);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(d);
                return true;
            }
            parcel.enforceInterface(d);
            String b2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        private static class C0123a implements b {
            private IBinder a;

            C0123a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.d);
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

            public String b() {
                return a.d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.d);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.d);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
