package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface UMLogDataProtocol {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
