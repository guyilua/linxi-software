package com.qq.e.comm.managers.plugin;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.ak;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d {
    private static final String[] a = {"0", "1", "2", GlobalSetting.SPLASH_AD, GlobalSetting.NATIVE_EXPRESS_AD, "5", GlobalSetting.NATIVE_UNIFIED_AD, GlobalSetting.UNIFIED_BANNER_AD, GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "9", ak.av, "b", ak.aF, "d", "e", "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
