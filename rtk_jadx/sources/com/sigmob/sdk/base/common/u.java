package com.sigmob.sdk.base.common;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u {
    private u() {
    }

    public static Intent a(Context context, Class cls, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.addFlags(268435456);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    private static Uri a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        return Uri.parse(BaseConstants.MARKET_PREFIX + intent.getPackage());
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        a(context, broadcastReceiver, intentFilter, true);
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        }
    }

    private static void a(Context context, Intent intent, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            c(context, intent);
        } catch (Throwable th) {
            throw new IntentNotResolvableException(str + UMCustomLogInfoBuilder.LINE_SEP + th.getMessage());
        }
    }

    public static void a(Context context, Uri uri) {
        a(context, uri, (String) null);
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(uri);
        if (a(context, intent)) {
            a(context, intent, "Unable to open intent: " + intent);
            return;
        }
        throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4) {
        if (i != 0) {
            if (i == 1) {
                if (TextUtils.isEmpty(str4)) {
                    throw new IntentNotResolvableException("get mini_program error: " + str + "," + str2 + "," + str3 + "," + i + "," + str4);
                }
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                Method method = cls.getMethod("createWXAPI", Context.class, String.class);
                method.setAccessible(true);
                Object invoke = method.invoke(cls, context, str);
                Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView$Req");
                Object newInstance = cls2.newInstance();
                Field declaredField = cls2.getDeclaredField("businessType");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, "nativeOpenAdCanvas");
                Field declaredField2 = cls2.getDeclaredField("extInfo");
                declaredField2.setAccessible(true);
                declaredField2.set(newInstance, str4);
                Method method2 = invoke.getClass().getMethod("sendReq", newInstance.getClass().getSuperclass());
                method2.setAccessible(true);
                boolean booleanValue = ((Boolean) method2.invoke(invoke, newInstance)).booleanValue();
                SigmobLog.d("openB:isSendReq " + booleanValue);
                if (booleanValue) {
                    return;
                }
                throw new IntentNotResolvableException("get mini_program error: " + str + "," + str2 + "," + str3 + "," + i + "," + str4);
            }
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new IntentNotResolvableException("get mini_program error: " + str + "," + str2 + "," + str3 + "," + i + "," + str4);
        }
        Class<?> cls3 = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        Method method3 = cls3.getMethod("createWXAPI", Context.class, String.class);
        method3.setAccessible(true);
        Object invoke2 = method3.invoke(cls3, context, str);
        Class<?> cls4 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
        Object newInstance2 = cls4.newInstance();
        Field declaredField3 = cls4.getDeclaredField("userName");
        declaredField3.setAccessible(true);
        declaredField3.set(newInstance2, str2);
        Field declaredField4 = cls4.getDeclaredField("path");
        declaredField4.setAccessible(true);
        declaredField4.set(newInstance2, str3);
        if (!TextUtils.isEmpty(str4)) {
            Field declaredField5 = cls4.getDeclaredField("extData");
            declaredField5.setAccessible(true);
            declaredField5.set(newInstance2, str4);
        }
        Field declaredField6 = cls4.getDeclaredField("miniprogramType");
        declaredField6.setAccessible(true);
        declaredField6.set(newInstance2, 0);
        Method method4 = invoke2.getClass().getMethod("sendReq", newInstance2.getClass().getSuperclass());
        method4.setAccessible(true);
        boolean booleanValue2 = ((Boolean) method4.invoke(invoke2, newInstance2)).booleanValue();
        SigmobLog.d("openB:isSendReq " + booleanValue2);
        if (booleanValue2) {
            return;
        }
        throw new IntentNotResolvableException("get mini_program error: " + str + "," + str2 + "," + str3 + "," + i + "," + str4);
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static void b(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (a(context, intent)) {
            a(context, intent, "Unable to open intent: " + intent);
            return;
        }
        throw new IntentNotResolvableException("Could not handle application specific action: " + intent.toString() + "\n\tYou may be running in the emulator or another device which does not have the required application.");
    }

    public static void b(Context context, Uri uri, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(uri);
        a(context, new Intent("android.intent.action.VIEW", uri), str);
    }

    public static boolean b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            c(context, launchIntentForPackage);
            return true;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return false;
        }
    }

    private static void c(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            intent.addFlags(872415232);
            context.startActivity(intent);
        } catch (Throwable th) {
            throw new IntentNotResolvableException(th);
        }
    }
}
