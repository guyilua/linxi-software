package com.umeng.tunnel;

import android.content.Context;
import android.util.Log;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMChannelAgent {
    private static final String TAG = "UMChannelAgent";
    private static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady = false;

    static {
        try {
            if (Class.forName(UMENG_VCHANNEL) != null) {
                vChannelReady = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean init() {
        if (!vChannelReady) {
            Log.e(TAG, "--->>> Umeng tunnel module depends on common library, please integrate common first.");
        }
        return vChannelReady;
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) {
        reflectOnEvent(context, str, map);
    }

    private static void reflectOnEvent(Context context, String str, Map<String, Object> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, "--->>> Can not find class com.umeng.commonsdk.vchannel.sender .");
        } catch (NoSuchMethodException unused2) {
            Log.e(TAG, "--->>> Can not find method onEvent .");
        } catch (SecurityException unused3) {
            Log.e(TAG, "--->>> Security exception is thrown when we find onEvent method !");
        } catch (Exception unused4) {
            Log.e(TAG, "--->>> Exception is thrown when onEvent method is called !");
        }
    }

    private static void reflectSetCustomHeader(Map<String, String> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, "--->>> Can not find class com.umeng.commonsdk.vchannel.sender .");
        } catch (NoSuchMethodException unused2) {
            Log.e(TAG, "--->>> Can not find method setCustomHeader .");
        } catch (SecurityException unused3) {
            Log.e(TAG, "--->>> Security exception is thrown when we find setCustomHeader method !");
        } catch (Exception unused4) {
            Log.e(TAG, "--->>> Exception is thrown when setCustomHeader method is called !");
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        reflectSetCustomHeader(map);
    }
}
