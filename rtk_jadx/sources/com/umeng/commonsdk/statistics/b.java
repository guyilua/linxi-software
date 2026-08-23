package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EnvelopeManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static String a = null;
    public static String b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1101c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static boolean k;
    private int j = 0;

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
        }
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    public static long a(Context context) {
        long j = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f1101c, "free size is " + j);
        }
        return j;
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f1091c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str4;
        String str5;
        boolean z;
        String str6;
        Envelope envelope;
        String str7;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f1101c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f1101c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(d.n)) {
                    str5 = str2;
                    z = true;
                } else {
                    str5 = str2;
                    z = false;
                }
                JSONObject a2 = a(context, str5, z);
                if (a2 != null && jSONObject != null) {
                    a2 = a(a2, jSONObject);
                }
                JSONObject jSONObject5 = a2;
                if (jSONObject5 != null && jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String) && (str7 = next) != null && jSONObject2.opt(str7) != null) {
                            try {
                                jSONObject5.put(str7, jSONObject2.opt(str7));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str5 = ak.aG;
                }
                String str8 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject5 != null) {
                    String str9 = str5 + "==" + str8 + "&=";
                    if (TextUtils.isEmpty(str9)) {
                        return a(101, jSONObject5);
                    }
                    if (str9.endsWith("&=")) {
                        str9 = str9.substring(0, str9.length() - 2);
                    }
                    str6 = str9;
                } else {
                    str6 = null;
                }
                if (jSONObject5 != null) {
                    try {
                        e a3 = e.a(context);
                        if (a3 != null) {
                            a3.b();
                            String encodeToString = Base64.encodeToString(new bc().a(a3.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject6 = jSONObject5.getJSONObject("header");
                                jSONObject6.put(ak.Y, encodeToString);
                                jSONObject5.put("header", jSONObject6);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject5);
                }
                if (jSONObject5 != null) {
                    Envelope a4 = a(context, jSONObject5.toString().getBytes());
                    if (a4 == null) {
                        return a(111, jSONObject5);
                    }
                    envelope = a4;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject5);
                }
                int a5 = a(context, envelope, str6, jSONObject5 != null ? jSONObject5.optJSONObject("header").optString("app_version") : null, str);
                if (a5 != 0) {
                    return a(a5, jSONObject5);
                }
                if (ULog.DEBUG) {
                    Log.i(f1101c, "constructHeader size is " + jSONObject5.toString().getBytes().length);
                }
                if (!str6.startsWith(ak.aD) && !str6.startsWith(ak.aC) && !str6.startsWith(ak.aH) && !str6.startsWith(ak.av) && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject5;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        jSONObject4 = new JSONObject();
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = null;
                    }
                    try {
                        jSONObject4.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject3 = jSONObject4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject4;
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject2 != null) {
                    if (jSONObject3 == null) {
                        try {
                            jSONObject3 = new JSONObject();
                        } catch (Exception e4) {
                            e = e4;
                            UMCrashManager.reportCrash(context, e);
                            return a(110, jSONObject3);
                        }
                    }
                    if (jSONObject2 != null) {
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2 != null && (next2 instanceof String) && (str4 = next2) != null && jSONObject2.opt(str4) != null) {
                                try {
                                    jSONObject3.put(str4, jSONObject2.opt(str4));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("header", new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                Envelope a2 = a(context, jSONObject3.toString().getBytes());
                if (a2 == null) {
                    return a(111, jSONObject3);
                }
                envelope = a2;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a3 = a(context, envelope, "z==1.2.0", jSONObject3 != null ? jSONObject3.optJSONObject("header").optString("app_version") : null, str);
            if (a3 != 0) {
                return a(a3, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f1101c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static JSONObject a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                jSONObject = new JSONObject();
                jSONObject.put(ak.p, DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(ak.q, DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(ak.r, DeviceConfig.getAppHashKey(context));
                jSONObject.put("app_version", DeviceConfig.getAppVersionName(context));
                jSONObject.put("version_code", Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put(ak.v, DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(ak.w, DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(ak.B, mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject.put(ak.B, "");
                }
                String subOSName = DeviceConfig.getSubOSName(context);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject.put(ak.K, subOSName);
                }
                String subOSVersion = DeviceConfig.getSubOSVersion(context);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject.put(ak.L, subOSVersion);
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(ak.ai, deviceType);
                }
                jSONObject.put("package_name", DeviceConfig.getPackageName(context));
                jSONObject.put(ak.u, "Android");
                jSONObject.put("device_id", DeviceConfig.getDeviceId(context));
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put(ak.E, Build.BOARD);
                jSONObject.put(ak.F, Build.BRAND);
                jSONObject.put(ak.G, Build.TIME);
                jSONObject.put(ak.H, Build.MANUFACTURER);
                jSONObject.put(ak.I, Build.ID);
                jSONObject.put(ak.J, Build.DEVICE);
                jSONObject.put(ak.y, Build.VERSION.RELEASE);
                jSONObject.put(ak.x, "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject.put(ak.z, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(ak.A, DeviceConfig.getMac(context));
                jSONObject.put(ak.M, DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(ak.O, localeInfo[0]);
                jSONObject.put(ak.N, localeInfo[1]);
                jSONObject.put(ak.P, DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(ak.s, DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject.put(ak.Q, "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject.put(ak.Q, "2G/3G");
                } else {
                    jSONObject.put(ak.Q, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(ak.R, networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject.put(ak.ao, "harmony");
                } else {
                    jSONObject.put(ak.ao, "Android");
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.H)) {
                    jSONObject.put(ak.S, DeviceConfig.getIPAddress(context));
                }
                jSONObject.put(ak.T, DeviceConfig.getNetworkType(context));
                jSONObject.put(ak.b, "9.4.4");
                jSONObject.put(ak.f1015c, SdkVersion.SDK_TYPE);
                jSONObject.put(ak.d, "1");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put(ak.e, a);
                }
                jSONObject.put(ak.aj, Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(ak.af, UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject.put("session_id", uUIDForZid);
                } catch (Throwable unused2) {
                }
                i = jSONObject.toString();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put(ak.ak, UMUtils.getOaidRequiredTime(context));
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(ak.U, sharedPreferences.getInt("successful_request", 0));
            jSONObject.put(ak.V, sharedPreferences.getInt(ak.V, 0));
            jSONObject.put(ak.W, sharedPreferences.getInt("last_request_spent_ms", 0));
            String zid = UMUtils.getZid(context);
            if (!TextUtils.isEmpty(zid)) {
                jSONObject.put(ak.al, zid);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject.put(ak.am, UMUtils.VALUE_ASMS_VERSION);
            }
        } catch (Exception unused4) {
        }
        jSONObject.put("channel", UMUtils.getChannel(context));
        jSONObject.put("appkey", UMUtils.getAppkey(context));
        try {
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put(ak.a, deviceToken);
            }
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, ak.g, null);
            if (!TextUtils.isEmpty(imprintProperty)) {
                jSONObject.put(ak.g, imprintProperty);
            }
        } catch (Exception e3) {
            UMCrashManager.reportCrash(context, e3);
        }
        try {
            jSONObject.put("wrapper_type", a.a);
            jSONObject.put("wrapper_version", a.b);
        } catch (Exception unused5) {
        }
        try {
            int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
            boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
            jSONObject.put(ak.aU, targetSdkVersion);
            if (checkPermission) {
                jSONObject.put(ak.aV, "yes");
            } else {
                jSONObject.put(ak.aV, "no");
            }
        } catch (Throwable unused6) {
        }
        try {
            if (b()) {
                jSONObject.put("umTaskId", g);
                jSONObject.put("umCaseId", h);
            }
        } catch (Throwable unused7) {
        }
        if ((ak.aH.equals(str) || ak.av.equals(str)) && z) {
            try {
                int[] b2 = b(context);
                jSONObject.put(ak.bo, String.valueOf(b2[0]) + String.valueOf(b2[1]) + String.valueOf(b2[2]));
            } catch (Throwable unused8) {
            }
        }
        try {
            Map<String, String> moduleTags = TagHelper.getModuleTags();
            if (moduleTags != null && moduleTags.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(ak.ap, jSONObject2);
            }
        } catch (Throwable unused9) {
        }
        try {
            String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
            if (!TextUtils.isEmpty(realTimeDebugKey)) {
                jSONObject.put(ak.bn, realTimeDebugKey);
            }
        } catch (Throwable unused10) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ak.aZ, com.umeng.commonsdk.internal.a.e);
            if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                jSONObject3.put(ak.ba, UMUtils.VALUE_ANALYTICS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                jSONObject3.put(ak.bb, UMUtils.VALUE_GAME_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                jSONObject3.put(ak.bc, UMUtils.VALUE_PUSH_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                jSONObject3.put(ak.bd, UMUtils.VALUE_SHARE_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                jSONObject3.put(ak.be, UMUtils.VALUE_APM_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                jSONObject3.put(ak.bf, UMUtils.VALUE_VERIFY_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                jSONObject3.put(ak.bg, UMUtils.VALUE_SMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                jSONObject3.put(ak.bh, UMUtils.VALUE_REC_VERSION_NAME);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                jSONObject3.put(ak.bi, UMUtils.VALUE_VISUAL_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                jSONObject3.put(ak.bj, UMUtils.VALUE_ASMS_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                jSONObject3.put(ak.bk, UMUtils.VALUE_LINK_VERSION);
            }
            if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                jSONObject3.put(ak.bl, UMUtils.VALUE_ABTEST_VERSION);
            }
            jSONObject.put(ak.aY, jSONObject3);
        } catch (Throwable unused11) {
        }
        try {
            String apmFlag = UMUtils.getApmFlag();
            if (!TextUtils.isEmpty(apmFlag)) {
                jSONObject.put(ak.bm, apmFlag);
            }
        } catch (Throwable unused12) {
        }
        byte[] a2 = ImprintHandler.getImprintService(context).a();
        if (a2 != null && a2.length > 0) {
            try {
                jSONObject.put(ak.X, Base64.encodeToString(a2, 0));
            } catch (JSONException e4) {
                UMCrashManager.reportCrash(context, e4);
            }
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            return new JSONObject().put("header", jSONObject);
        }
        return null;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt("header") != null && (jSONObject.opt("header") instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(d.i) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.j = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (k) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b2 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (!str.startsWith(ak.aD) && !str.startsWith(ak.aC) && !str.startsWith(ak.av) && !str.startsWith(ak.aH)) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z) {
        k = z;
    }
}
