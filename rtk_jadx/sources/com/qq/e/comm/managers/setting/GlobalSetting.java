package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String CUSTOM_INFO_KEY = "custom_info";
    public static final String DARK_MODE_KEY = "dark_mode_info";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String NATIVE_EXPRESS_AD = "4";
    public static final String NATIVE_UNIFIED_AD = "6";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String REWARD_VIDEO_AD = "5";
    public static final String SPLASH_AD = "3";
    public static final String TT_SDK_WRAPPER = "TT";
    public static final String UNIFIED_BANNER_AD = "7";
    public static final String UNIFIED_INTERSTITIAL_FS_AD = "9";
    public static final String UNIFIED_INTERSTITIAL_HS_AD = "8";
    private static volatile Integer a = null;
    private static volatile boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f23c = true;
    private static volatile Integer d;
    private static volatile Boolean e;
    private static volatile Boolean f;
    private static volatile Boolean g;
    private static volatile Map<String, String> h = new HashMap();
    private static volatile Map<String, String> i = new HashMap();
    private static final Map<String, String> j = new HashMap();
    private static final JSONObject k = new JSONObject();
    private static volatile String l = null;
    private static volatile String m = null;
    private static volatile String n = null;
    private static volatile String o = null;
    private static volatile String p = null;

    public static Boolean getAgreeReadAndroidId() {
        return g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f;
    }

    public static Integer getChannel() {
        return a;
    }

    public static String getCustomADActivityClassName() {
        return l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return o;
    }

    public static String getCustomPortraitActivityClassName() {
        return m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(h);
    }

    public static Integer getPersonalizedState() {
        return d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return j;
    }

    public static JSONObject getSettings() {
        return k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return e == null || e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (g == null) {
            return true;
        }
        return g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f == null) {
            return true;
        }
        return f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f23c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (e == null) {
            e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        g = Boolean.valueOf(z);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f = Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        if (a == null) {
            a = Integer.valueOf(i2);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e2.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        l = str;
    }

    public static void setCustomInfo(Map<String, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            k.putOpt(CUSTOM_INFO_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setCustomInfo：" + e2);
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            k.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f23c = z;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            k.putOpt("media_ext", new JSONObject(i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        d = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        j.putAll(map);
    }
}
