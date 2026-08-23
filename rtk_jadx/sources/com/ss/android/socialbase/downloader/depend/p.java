package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.o;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface p extends IInterface {
    boolean a(long j, long j2, o oVar);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements p {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.p$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0101a implements p {
            public static p a;
            private IBinder b;

            C0101a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j, long j2, o oVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(j, j2, oVar);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static p a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof p)) {
                return (p) queryLocalInterface;
            }
            return new C0101a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean a = a(parcel.readLong(), parcel.readLong(), o.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(a ? 1 : 0);
            return true;
        }

        public static p a() {
            return C0101a.a;
        }
    }
}
