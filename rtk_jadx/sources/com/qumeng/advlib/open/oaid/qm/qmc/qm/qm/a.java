package com.qumeng.advlib.open.oaid.qm.qmc.qm.qm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0011a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a
        public boolean b() {
            return false;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a
        public String g() {
            return null;
        }
    }

    boolean b();

    String g();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class b extends Binder implements a {
        private static final String a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        static final int b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f30c = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a$b$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0012a implements a {
            public static a b;
            private IBinder a;

            C0012a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(2, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().b();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qmc.qm.qm.a
            public String g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().g();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
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
            return new C0012a(iBinder);
        }

        public static a i() {
            return C0012a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(a);
                String g = g();
                parcel2.writeNoException();
                parcel2.writeString(g);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            boolean b2 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b2 ? 1 : 0);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0012a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0012a.b = aVar;
            return true;
        }
    }
}
