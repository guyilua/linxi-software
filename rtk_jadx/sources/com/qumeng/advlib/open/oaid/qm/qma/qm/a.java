package com.qumeng.advlib.open.oaid.qm.qma.qm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.qumeng.advlib.open.oaid.qm.qma.qm.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0007a implements a {
        @Override // com.qumeng.advlib.open.oaid.qm.qma.qm.a
        public String a(String str, String str2, String str3) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    String a(String str, String str2, String str3);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class b extends Binder implements a {
        private static final String a = "com.heytap.openid.IOpenID";
        static final int b = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.qumeng.advlib.open.oaid.qm.qma.qm.a$b$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0008a implements a {
            public static a b;
            private IBinder a;

            C0008a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qma.qm.a
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.a.transact(1, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().a(str, str2, str3);
                    }
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
            return new C0008a(iBinder);
        }

        public static a i() {
            return C0008a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            String a2 = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0008a.b != null || aVar == null) {
                return false;
            }
            C0008a.b = aVar;
            return true;
        }
    }
}
