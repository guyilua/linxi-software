package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface j extends IInterface {
    String a();

    void a(String str);

    int[] b();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (queryLocalInterface != null && (queryLocalInterface instanceof j)) {
                return (j) queryLocalInterface;
            }
            return new C0098a(iBinder);
        }

        public static j c() {
            return C0098a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] b = b();
            parcel2.writeNoException();
            parcel2.writeIntArray(b);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.j$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0098a implements j {
            public static j a;
            private IBinder b;

            C0098a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.c() != null) {
                        a.c().a(str);
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

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().b();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().a();
                    }
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
