package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface t extends IInterface {
    void a(List<String> list);

    boolean a();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements t {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static t a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof t)) {
                return (t) queryLocalInterface;
            }
            return new C0102a(iBinder);
        }

        public static t b() {
            return C0102a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                a(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean a = a();
            parcel2.writeNoException();
            parcel2.writeInt(a ? 1 : 0);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.t$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0102a implements t {
            public static t a;
            private IBinder b;

            C0102a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public void a(List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    obtain.writeStringList(list);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a(list);
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

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
