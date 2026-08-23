package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.UMServerURL;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMCrashManager {
    private static final String CM_VERSION = "2.0";
    private static boolean isReportCrash = false;
    private static Object mObject = new Object();

    public static void buildEnvelope(Context context, Object obj) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                if (context == null || obj == null) {
                    return;
                }
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = context.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                    File file = new File(str2);
                    if (!file.isDirectory()) {
                        file.mkdir();
                    }
                    d.a(context, str2, ak.aF, 10);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ak.aN, CM_VERSION);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("content", str);
                        jSONObject2.put("ts", System.currentTimeMillis());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(PointCategory.CRASH, jSONObject2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("tp", jSONObject3);
                        UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, UMServerURL.PATH_INNER_CRASH, ak.aF, CM_VERSION);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            if (!isReportCrash) {
                isReportCrash = true;
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.u, b.a(context).a(), a.a(th));
            }
        }
    }
}
