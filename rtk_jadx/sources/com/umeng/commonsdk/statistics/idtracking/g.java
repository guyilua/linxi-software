package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: MacTracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends a {
    private static final String a = "mac";
    private Context b;

    public g(Context context) {
        super(a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.b);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                e.printStackTrace();
            }
            UMCrashManager.reportCrash(this.b, e);
            return null;
        }
    }
}
