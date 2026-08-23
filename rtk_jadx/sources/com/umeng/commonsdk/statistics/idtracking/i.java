package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: SerialTracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i extends a {
    private static final String a = "serial";

    public i() {
        super(a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getSerial();
    }
}
