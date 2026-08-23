package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeviceIdManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {
    String a(String str);

    boolean a();

    String b();

    String b(String str);

    String c(String str);

    String d(String str);

    String e(String str);

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class AbstractBinderC0121a extends Binder implements a {
        static final int a = 1;
        static final int b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f1011c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final String h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public AbstractBinderC0121a() {
            attachInterface(this, h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(h);
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0122a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(h);
                        String a2 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface(h);
                        String b2 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b2);
                        return true;
                    case 3:
                        parcel.enforceInterface(h);
                        String c2 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c2);
                        return true;
                    case 4:
                        parcel.enforceInterface(h);
                        String d2 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d2);
                        return true;
                    case 5:
                        parcel.enforceInterface(h);
                        String e2 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e2);
                        return true;
                    case 6:
                        parcel.enforceInterface(h);
                        boolean a3 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(h);
                        String b3 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b3);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(h);
            return true;
        }

        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.umeng.analytics.pro.a$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        private static class C0122a implements a {
            private IBinder a;

            C0122a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    obtain.writeString(str);
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

            @Override // com.umeng.analytics.pro.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return AbstractBinderC0121a.h;
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0121a.h);
                    this.a.transact(7, obtain, obtain2, 0);
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
