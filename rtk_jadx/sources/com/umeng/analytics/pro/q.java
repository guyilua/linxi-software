package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DataSpliter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q {
    public static JSONObject a(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!jSONObject.has("content")) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("content");
            if (jSONObject3.has("analytics")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    jSONObject4.remove("ekv");
                }
                if (jSONObject4.has(d.T)) {
                    jSONObject4.remove(d.T);
                }
                if (jSONObject4.has("error")) {
                    jSONObject4.remove("error");
                }
                jSONObject3.put("analytics", jSONObject4);
            }
            jSONObject2.put("content", jSONObject3);
            if (jSONObject.has("header")) {
                jSONObject2.put("header", jSONObject.getJSONObject("header"));
            }
            if (a(jSONObject2) <= j) {
                return jSONObject2;
            }
            jSONObject2 = null;
            i.a(context).i();
            i.a(context).h();
            i.a(context).b(true, false);
            i.a(context).a();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    public static long a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    public static long a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }
}
