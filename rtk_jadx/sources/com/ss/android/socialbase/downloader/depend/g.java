package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface g extends IInterface {
    Uri a(String str, String str2);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements g {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.g$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0095a implements g {
            public static g a;
            private IBinder b;

            C0095a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C0095a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri a = a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (a != null) {
                parcel2.writeInt(1);
                a.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static g a() {
            return C0095a.a;
        }
    }
}
