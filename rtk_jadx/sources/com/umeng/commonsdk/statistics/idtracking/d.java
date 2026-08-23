package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: IDMD5Tracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends a {
    private static final String a = "idmd5";
    private Context b;

    public d(Context context) {
        super("idmd5");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.b);
    }
}
