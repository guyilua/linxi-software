package com.windmill.baidu;

import com.windmill.sdk.base.WMLogUtil;
import java.util.LinkedHashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class a {
    public static void a(Object obj, String str, LinkedHashMap<String, Object> linkedHashMap) {
        Class<?> cls;
        if (obj == null) {
            return;
        }
        try {
            cls = Class.forName("com.baidu.mobads.sdk.api.BiddingListener");
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            if (cls != null) {
                obj.getClass().getMethod("biddingSuccess", LinkedHashMap.class, cls).invoke(obj, linkedHashMap, null);
                return;
            }
            try {
                obj.getClass().getMethod("biddingSuccess", String.class, LinkedHashMap.class).invoke(obj, str, linkedHashMap);
            } catch (Throwable th) {
                WMLogUtil.e("BDBiddingNotificationUtils", "win: ".concat(String.valueOf(th)));
                obj.getClass().getMethod("biddingSuccess", String.class).invoke(obj, str);
            }
        } catch (Throwable th2) {
            WMLogUtil.e("BDBiddingNotificationUtils", "win error: ".concat(String.valueOf(th2)));
        }
    }

    public static void b(Object obj, String str, LinkedHashMap<String, Object> linkedHashMap) {
        Class<?> cls;
        if (obj == null) {
            return;
        }
        try {
            cls = Class.forName("com.baidu.mobads.sdk.api.BiddingListener");
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            if (cls != null) {
                obj.getClass().getMethod("biddingFail", LinkedHashMap.class, cls).invoke(obj, linkedHashMap, null);
                return;
            }
            try {
                obj.getClass().getMethod("biddingFail", String.class, LinkedHashMap.class).invoke(obj, str, linkedHashMap);
            } catch (Throwable th) {
                WMLogUtil.e("BDBiddingNotificationUtils", "loss error: ".concat(String.valueOf(th)));
                obj.getClass().getMethod("biddingFail", String.class).invoke(obj, str);
            }
        } catch (Throwable th2) {
            WMLogUtil.e("BDBiddingNotificationUtils", "loss error: ".concat(String.valueOf(th2)));
        }
    }
}
