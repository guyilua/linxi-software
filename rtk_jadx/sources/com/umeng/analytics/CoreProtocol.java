package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {
    private static Context a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static final CoreProtocol a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return o.a(a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        o.a(a).a(obj, i);
    }

    private CoreProtocol() {
    }
}
