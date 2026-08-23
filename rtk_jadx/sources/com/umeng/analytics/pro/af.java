package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: OppoDeviceIdSupplier.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class af implements z {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.a) {
                e.a.b.a.a.a.a.a(context);
                this.a = true;
            }
            if (!e.a.b.a.a.a.a.b()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return e.a.b.a.a.a.a.c(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
