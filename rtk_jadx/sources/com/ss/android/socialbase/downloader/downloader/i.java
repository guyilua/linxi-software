package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface i extends IInterface {
    int a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, int i3, long j);

    void a(int i, int i2, long j);

    void a(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z);

    void a(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z, boolean z2);

    void a(int i, long j);

    void a(int i, Notification notification);

    void a(int i, y yVar);

    void a(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void a(int i, boolean z);

    void a(ai aiVar);

    void a(com.ss.android.socialbase.downloader.model.a aVar);

    void a(com.ss.android.socialbase.downloader.model.b bVar);

    void a(List<String> list);

    void a(boolean z);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(String str, String str2);

    List<DownloadInfo> b();

    List<DownloadInfo> b(String str);

    void b(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z);

    void b(int i, List<com.ss.android.socialbase.downloader.model.b> list);

    void b(int i, boolean z);

    void b(List<String> list);

    boolean b(int i);

    boolean b(DownloadInfo downloadInfo);

    List<DownloadInfo> c(String str);

    void c(int i);

    void c(int i, boolean z);

    boolean c();

    List<DownloadInfo> d(String str);

    void d(int i);

    void d(int i, boolean z);

    boolean d();

    long e(int i);

    List<DownloadInfo> e(String str);

    void e();

    int f(int i);

    boolean f();

    boolean g(int i);

    DownloadInfo h(int i);

    List<com.ss.android.socialbase.downloader.model.b> i(int i);

    void j(int i);

    boolean k(int i);

    void l(int i);

    int m(int i);

    boolean n(int i);

    void o(int i);

    boolean p(int i);

    y q(int i);

    ad r(int i);

    com.ss.android.socialbase.downloader.depend.g s(int i);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements i {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0106a(iBinder);
        }

        public static i g() {
            return C0106a.a;
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(a.AbstractBinderC0110a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean b = b(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(b ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        c(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        d(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        long e = e(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(e);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int f = f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(f);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean g = g(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(g ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo h = h(parcel.readInt());
                        parcel2.writeNoException();
                        if (h != null) {
                            parcel2.writeInt(1);
                            h.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> a = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(a);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.model.b> i3 = i(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(i3);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int a2 = a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a2);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo b2 = b(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (b2 != null) {
                            parcel2.writeInt(1);
                            b2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> b3 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(b3);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> c2 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(c2);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> d = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(d);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> b4 = b();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(b4);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        b(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        b(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        c(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        b(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), i.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean a3 = a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt() != 0);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean c3 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c3 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> e2 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(e2);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean k = k(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(k ? 1 : 0);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        l(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean d2 = d();
                        parcel2.writeNoException();
                        parcel2.writeInt(d2 ? 1 : 0);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        d(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int m = m(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(m);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.b.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean b5 = b(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(b5 ? 1 : 0);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean n = n(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(n ? 1 : 0);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        o(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean p = p(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(p ? 1 : 0);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        e();
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        b(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(ai.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        y q = q(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(q != null ? q.asBinder() : null);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ad r = r(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(r != null ? r.asBinder() : null);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), y.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        com.ss.android.socialbase.downloader.depend.g s = s(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(s != null ? s.asBinder() : null);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean f2 = f();
                        parcel2.writeNoException();
                        parcel2.writeInt(f2 ? 1 : 0);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.downloader.i$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0106a implements i {
            public static i a;
            private IBinder b;

            C0106a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(com.ss.android.socialbase.downloader.model.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean b(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(4, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().b(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void c(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(5, obtain, obtain2, 0) && a.g() != null) {
                        a.g().c(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void d(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(6, obtain, obtain2, 0) && a.g() != null) {
                        a.g().d(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public long e(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(8, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().e(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int f(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(9, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().f(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean g(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(10, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().g(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public DownloadInfo h(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(11, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().h(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(13, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().i(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.b.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void j(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(24, obtain, obtain2, 0) && a.g() != null) {
                        a.g().j(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean k(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(33, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().k(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void l(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(34, obtain, obtain2, 0) && a.g() != null) {
                        a.g().l(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int m(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(37, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().m(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean n(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(40, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().n(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void o(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(41, obtain, obtain2, 0) && a.g() != null) {
                        a.g().o(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean p(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(45, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().p(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public y q(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(51, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().q(i);
                    }
                    obtain2.readException();
                    return y.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public ad r(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(52, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().r(i);
                    }
                    obtain2.readException();
                    return ad.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public com.ss.android.socialbase.downloader.depend.g s(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(54, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().s(i);
                    }
                    obtain2.readException();
                    return g.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.b.transact(17, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().c(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> d(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.b.transact(18, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().d(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public DownloadInfo b(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(15, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().b(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> e(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.b.transact(32, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().e(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(55, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().f();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void c(int i, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(23, obtain, obtain2, 0) && a.g() != null) {
                        a.g().c(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(35, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().d();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(46, obtain, obtain2, 0) && a.g() != null) {
                        a.g().e();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.b.transact(16, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().b(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(7, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(31, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void d(int i, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(36, obtain, obtain2, 0) && a.g() != null) {
                        a.g().d(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.b.transact(19, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().b();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public List<DownloadInfo> a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.b.transact(12, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().a(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.b.transact(21, obtain, obtain2, 0) && a.g() != null) {
                        a.g().b(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public int a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(14, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(22, obtain, obtain2, 0) && a.g() != null) {
                        a.g().b(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.b.transact(20, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(26, obtain, obtain2, 0) && a.g() != null) {
                        a.g().b(i, i2, iVar, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(25, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, i2, iVar, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean b(DownloadInfo downloadInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(39, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().b(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2, com.ss.android.socialbase.downloader.depend.i iVar, int i3, boolean z, boolean z2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i3);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    try {
                        if (!this.b.transact(27, obtain, obtain2, 0) && a.g() != null) {
                            a.g().a(i, i2, iVar, i3, z, z2);
                        } else {
                            obtain2.readException();
                        }
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.b.transact(48, obtain, obtain2, 0) && a.g() != null) {
                        a.g().b(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public boolean a(DownloadInfo downloadInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(28, obtain, obtain2, 0) && a.g() != null) {
                        return a.g().a(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.b.transact(29, obtain, null, 1) || a.g() == null) {
                        return;
                    }
                    a.g().a(i, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.b.transact(30, obtain, null, 1) || a.g() == null) {
                        return;
                    }
                    a.g().a(z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(com.ss.android.socialbase.downloader.model.b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(38, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (!this.b.transact(42, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, i2, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2, int i3, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (!this.b.transact(43, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, i2, i3, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.b.transact(44, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.b.transact(47, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(ai aiVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(aiVar != null ? aiVar.asBinder() : null);
                    if (!this.b.transact(49, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(aiVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.b.transact(50, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, y yVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(yVar != null ? yVar.asBinder() : null);
                    if (!this.b.transact(53, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, yVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.i
            public void a(int i, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.b.transact(56, obtain, obtain2, 0) && a.g() != null) {
                        a.g().a(i, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
