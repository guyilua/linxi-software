package com.umeng.umzid;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
