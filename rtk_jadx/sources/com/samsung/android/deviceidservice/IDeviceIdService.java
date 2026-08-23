package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IDeviceIdService extends IInterface {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getAAID(String str) {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getOAID() {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public String getVAID(String str) {
            return null;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class Stub extends Binder implements IDeviceIdService {
        private static final String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";
        public static final int TRANSACTION_getAAID = 3;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getVAID = 2;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class Proxy implements IDeviceIdService {
            public static IDeviceIdService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getAAID(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getAAID(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public String getVAID(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getVAID(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) queryLocalInterface;
        }

        public static IDeviceIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdService iDeviceIdService) {
            if (Proxy.sDefaultImpl != null || iDeviceIdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String oaid;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                oaid = getOAID();
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                oaid = getVAID(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                oaid = getAAID(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(oaid);
            return true;
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID(String str);
}
