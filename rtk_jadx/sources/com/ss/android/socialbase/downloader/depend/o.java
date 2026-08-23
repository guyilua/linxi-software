package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface o extends IInterface {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements o {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.o$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0100a implements o {
            public static o a;
            private IBinder b;

            C0100a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a();
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
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof o)) {
                return (o) queryLocalInterface;
            }
            return new C0100a(iBinder);
        }

        public static o b() {
            return C0100a.a;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            a();
            parcel2.writeNoException();
            return true;
        }
    }

    void a();
}
