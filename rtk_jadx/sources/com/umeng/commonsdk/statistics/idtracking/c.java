package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: IDFATracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends a {
    private static final String a = "idfa";
    private Context b;

    public c(Context context) {
        super(a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.b);
    }
}
