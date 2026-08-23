package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface y extends IInterface {
    String a();

    void a(int i, DownloadInfo downloadInfo, String str, String str2);

    boolean a(boolean z);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements y {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static y a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof y)) {
                return (y) queryLocalInterface;
            }
            return new C0104a(iBinder);
        }

        public static y b() {
            return C0104a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                a(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean a = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String a2 = a();
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.y$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0104a implements y {
            public static y a;
            private IBinder b;

            C0104a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(i);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a(i, downloadInfo, str, str2);
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

            @Override // com.ss.android.socialbase.downloader.depend.y
            public boolean a(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
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
