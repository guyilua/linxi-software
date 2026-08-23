package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: VivoDeviceIdSupplier.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ah implements z {
    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String str = null;
        try {
            if (!e.a.b.c.a.d.a(context)) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                str = e.a.b.c.a.d.b(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}
