package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface ai extends IInterface {
    void a(int i, int i2);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements ai {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.ai$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0092a implements ai {
            public static ai a;
            private IBinder b;

            C0092a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i, i2);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static ai a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ai)) {
                return (ai) queryLocalInterface;
            }
            return new C0092a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static ai a() {
            return C0092a.a;
        }
    }
}
