package com.qq.e.comm.managers.status;

import com.qq.e.comm.managers.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 101;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1481;
    }

    public static final String getIntegrationSDKVersion() {
        return "4.611." + getBuildInPluginVersion();
    }

    public static final int getPluginVersion() {
        if (a.b().d()) {
            return a.b().c().getPluginVersion();
        }
        return 0;
    }

    public static final String getSDKVersion() {
        return "4.611";
    }
}
