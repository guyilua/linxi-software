package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.y;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a extends IInterface {
    int a(int i);

    i a(int i, int i2);

    DownloadInfo a();

    com.ss.android.socialbase.downloader.depend.e b();

    i b(int i);

    l c(int i);

    y c();

    ad d();

    h e();

    f f();

    u g();

    ag h();

    p i();

    j j();

    g k();

    int l();

    /* renamed from: com.ss.android.socialbase.downloader.model.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class AbstractBinderC0110a extends Binder implements a {
        public AbstractBinderC0110a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0111a(iBinder);
        }

        public static a m() {
            return C0111a.a;
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        DownloadInfo a = a();
                        parcel2.writeNoException();
                        if (a != null) {
                            parcel2.writeInt(1);
                            a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        com.ss.android.socialbase.downloader.depend.e b = b();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(b != null ? b.asBinder() : null);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int a2 = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a2);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i a3 = a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i b2 = b(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(b2 != null ? b2.asBinder() : null);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        y c2 = c();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(c2 != null ? c2.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ad d = d();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        h e = e();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(e != null ? e.asBinder() : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        f f = f();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(f != null ? f.asBinder() : null);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        u g = g();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(g != null ? g.asBinder() : null);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ag h = h();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(h != null ? h.asBinder() : null);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        p i3 = i();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i3 != null ? i3.asBinder() : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        j j = j();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(j != null ? j.asBinder() : null);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        g k = k();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(k != null ? k.asBinder() : null);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int l = l();
                        parcel2.writeNoException();
                        parcel2.writeInt(l);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        l c3 = c(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(c3 != null ? c3.asBinder() : null);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.model.a$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0111a implements a {
            public static a a;
            private IBinder b;

            C0111a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(2, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().b();
                    }
                    obtain2.readException();
                    return e.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public y c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(6, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().c();
                    }
                    obtain2.readException();
                    return y.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ad d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(7, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().d();
                    }
                    obtain2.readException();
                    return ad.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(8, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().e();
                    }
                    obtain2.readException();
                    return h.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public f f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(9, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().f();
                    }
                    obtain2.readException();
                    return f.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public u g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(10, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().g();
                    }
                    obtain2.readException();
                    return u.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(11, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().h();
                    }
                    obtain2.readException();
                    return ag.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(12, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().i();
                    }
                    obtain2.readException();
                    return p.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(13, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().j();
                    }
                    obtain2.readException();
                    return j.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public g k() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(14, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().k();
                    }
                    obtain2.readException();
                    return g.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.b.transact(15, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().l();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(5, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().b(i);
                    }
                    obtain2.readException();
                    return i.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(16, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().c(i);
                    }
                    obtain2.readException();
                    return l.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.b.transact(3, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().a(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i a(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.b.transact(4, obtain, obtain2, 0) && AbstractBinderC0110a.m() != null) {
                        return AbstractBinderC0110a.m().a(i, i2);
                    }
                    obtain2.readException();
                    return i.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
