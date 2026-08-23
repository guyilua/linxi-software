package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.t;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface u extends IInterface {
    boolean a(t tVar);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements u {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.u$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0103a implements u {
            public static u a;
            private IBinder b;

            C0103a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a(t tVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(tVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof u)) {
                return (u) queryLocalInterface;
            }
            return new C0103a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean a = a(t.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(a ? 1 : 0);
            return true;
        }

        public static u a() {
            return C0103a.a;
        }
    }
}
