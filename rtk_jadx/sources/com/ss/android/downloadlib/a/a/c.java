package com.ss.android.downloadlib.a.a;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.ss.android.downloadlib.a.a.d;
import com.ss.android.downloadlib.addownload.k;
import com.umeng.analytics.pro.ak;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface c extends IInterface {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a extends Binder implements c {
        private static String a = "";

        /* renamed from: com.ss.android.downloadlib.a.a.c$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        private static class C0071a implements c {
            private IBinder a;

            C0071a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject j = k.j();
                    String unused = a.a = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("r"), j.optString(ak.aB));
                }
                this.a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.a.c
            public void a(b bVar, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(a);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0071a(iBinder);
        }
    }

    void a(b bVar, d dVar);
}
