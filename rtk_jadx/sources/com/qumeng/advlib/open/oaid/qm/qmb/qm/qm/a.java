package com.qumeng.advlib.open.oaid.qm.qmb.qm.qm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0009a implements a {
        @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
        public String a() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
        public String a(String str) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
        public String b(String str) {
            return null;
        }
    }

    String a();

    String a(String str);

    String b(String str);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class b extends Binder implements a {
        private static final String a = "com.samsung.android.deviceidservice.IDeviceIdService";
        static final int b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f29c = 2;
        static final int d = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a$b$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0010a implements a {
            public static a b;
            private IBinder a;

            C0010a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
            public String a(String str) {
                return null;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qmb.qm.qm.a
            public String b(String str) {
                return null;
            }

            public String i() {
                return b.a;
            }
        }

        public b() {
            attachInterface(this, a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0010a(iBinder);
        }

        public static a i() {
            return C0010a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(a);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a);
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            String a3 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a3);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0010a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0010a.b = aVar;
            return true;
        }
    }
}
