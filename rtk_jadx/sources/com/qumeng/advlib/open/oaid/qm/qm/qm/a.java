package com.qumeng.advlib.open.oaid.qm.qm.qm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.qumeng.advlib.open.oaid.qm.qm.qm.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0005a implements a {
        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public String a() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public void c() {
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public String d() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public boolean e() {
            return false;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public String f() {
            return null;
        }

        @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
        public boolean h() {
            return false;
        }
    }

    String a();

    void c();

    String d();

    boolean e();

    String f();

    boolean h();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class b extends Binder implements a {
        private static final String a = "com.bun.lib.MsaIdInterface";
        static final int b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f28c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.qumeng.advlib.open.oaid.qm.qm.qm.a$b$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0006a implements a {
            public static a b;
            private IBinder a;

            C0006a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(3, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().a();
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

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public void c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(6, obtain, obtain2, 0) && b.i() != null) {
                        b.i().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public String d() {
                return null;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public boolean e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().e();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public String f() {
                return null;
            }

            @Override // com.qumeng.advlib.open.oaid.qm.qm.qm.a
            public boolean h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(2, obtain, obtain2, 0) && b.i() != null) {
                        return b.i().h();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
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
            return new C0006a(iBinder);
        }

        public static a i() {
            return C0006a.b;
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
                        parcel.enforceInterface(a);
                        boolean e2 = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(e2 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(a);
                        boolean h = h();
                        parcel2.writeNoException();
                        parcel2.writeInt(h ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(a);
                        String a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 4:
                        parcel.enforceInterface(a);
                        String f2 = f();
                        parcel2.writeNoException();
                        parcel2.writeString(f2);
                        return true;
                    case 5:
                        parcel.enforceInterface(a);
                        String d2 = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d2);
                        return true;
                    case 6:
                        parcel.enforceInterface(a);
                        c();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(a);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0006a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0006a.b = aVar;
            return true;
        }
    }
}
