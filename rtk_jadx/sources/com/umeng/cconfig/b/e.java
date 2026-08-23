package com.umeng.cconfig.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e {
    public static synchronized JSONArray a(c cVar, Context context) {
        synchronized (e.class) {
            JSONArray jSONArray = null;
            if (cVar != null && context != null) {
                try {
                    a aVar = new a();
                    String uMId = UMUtils.getUMId(context);
                    if (TextUtils.isEmpty(uMId)) {
                        return null;
                    }
                    aVar.i = uMId;
                    String appkey = UMUtils.getAppkey(context);
                    if (TextUtils.isEmpty(appkey)) {
                        return null;
                    }
                    aVar.h = appkey;
                    aVar.l = Long.valueOf(System.currentTimeMillis());
                    aVar.j = Integer.valueOf(Integer.parseInt(cVar.f1076c));
                    aVar.k = Integer.valueOf(Integer.parseInt(cVar.d));
                    aVar.m = cVar.a;
                    aVar.n = cVar.b;
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        try {
                            jSONObject.put(a.a, aVar.h);
                            jSONObject.put(a.e, aVar.l);
                            jSONObject.put(a.f1074c, aVar.j);
                            jSONObject.put(a.d, aVar.k);
                            jSONObject.put(a.b, aVar.i);
                            jSONObject.put(a.f, aVar.m);
                            jSONObject.put(a.g, aVar.n);
                            jSONArray2.put(0, jSONObject);
                            List<JSONObject> b = b(context);
                            if (b.size() > 0) {
                                for (int i = 1; i <= b.size(); i++) {
                                    jSONArray2.put(i, b.get(i - 1));
                                }
                            }
                            try {
                                SharedPreferences a = com.umeng.cconfig.a.c.a(context);
                                if (a != null) {
                                    SharedPreferences.Editor edit = a.edit();
                                    edit.putString("abtest_sp_last_request_data", "");
                                    edit.commit();
                                }
                            } catch (Exception unused) {
                            }
                            return jSONArray2;
                        } catch (Exception unused2) {
                            ULog.i("jessie", "[getUpdateAbEventLogParam] error i");
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused3) {
                        jSONArray = jSONArray2;
                        ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
                        return jSONArray;
                    }
                } catch (Exception unused4) {
                }
            }
            return jSONArray;
        }
    }

    public static synchronized JSONObject a(Context context) {
        JSONObject jSONObject;
        synchronized (e.class) {
            JSONObject jSONObject2 = null;
            try {
                b bVar = new b();
                String uMId = UMUtils.getUMId(context);
                if (TextUtils.isEmpty(uMId)) {
                    return null;
                }
                bVar.n = uMId;
                String appkey = UMUtils.getAppkey(context);
                if (TextUtils.isEmpty(appkey)) {
                    return null;
                }
                bVar.o = appkey;
                bVar.p = UMUtils.getAppVersionName(context);
                bVar.q = "9.3.3";
                bVar.r = UMUtils.getChannel(context);
                StringBuilder sb = new StringBuilder();
                sb.append(Build.VERSION.SDK_INT);
                bVar.s = sb.toString();
                bVar.t = Build.BRAND;
                bVar.u = Build.MODEL;
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                bVar.v = localeInfo[1];
                bVar.y = localeInfo[0];
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                bVar.x = Integer.valueOf(resolutionArray[1]);
                bVar.w = Integer.valueOf(resolutionArray[0]);
                String str = "";
                if (context != null) {
                    str = UMEnvelopeBuild.imprintProperty(context, "install_datetime", "");
                }
                bVar.z = str;
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException unused) {
                }
                try {
                    jSONObject.put(b.a, bVar.n);
                    jSONObject.put(b.f1075c, bVar.p);
                    jSONObject.put(b.b, bVar.o);
                    jSONObject.put(b.d, bVar.q);
                    jSONObject.put(b.e, bVar.r);
                    jSONObject.put(b.f, bVar.s);
                    jSONObject.put(b.g, bVar.t);
                    jSONObject.put(b.h, bVar.u);
                    jSONObject.put(b.k, bVar.x);
                    jSONObject.put(b.j, bVar.w);
                    jSONObject.put(b.l, bVar.y);
                    jSONObject.put(b.i, bVar.v);
                    jSONObject.put(b.m, bVar.z);
                    return jSONObject;
                } catch (JSONException unused2) {
                    jSONObject2 = jSONObject;
                    ULog.i("jessie", "[getCloudConfigParam] error i");
                    return jSONObject2;
                } catch (Exception unused3) {
                    jSONObject2 = jSONObject;
                    ULog.i("jessie", "[getCloudConfigParam] error ii");
                    return jSONObject2;
                }
            } catch (Exception unused4) {
            }
        }
    }

    private static List<JSONObject> b(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences a = com.umeng.cconfig.a.c.a(context);
            if (a != null) {
                String string = a.getString("abtest_sp_last_request_data", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string2 = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string2)) {
                                arrayList.add(new JSONObject(string2));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
