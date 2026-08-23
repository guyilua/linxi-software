package com.ss.android.socialbase.downloader.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface b extends IInterface {
    void a(Map map, Map map2);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.b.b$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0087a implements b {
            public static b a;
            private IBinder b;

            C0087a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.b.b
            public void a(Map map, Map map2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(map, map2);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0087a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader classLoader = getClass().getClassLoader();
            a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            parcel2.writeNoException();
            return true;
        }

        public static b a() {
            return C0087a.a;
        }
    }
}
