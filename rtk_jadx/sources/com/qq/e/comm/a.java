package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        boolean z2;
        Class<?> cls;
        Intent intent;
        String str;
        try {
            String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
            for (int i = 0; i < 2; i++) {
                try {
                    str = strArr[i];
                } catch (Throwable th) {
                    GDTLogger.e("检查权限时发生异常", th);
                }
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z || !b(context, Class.forName(CustomPkgConstants.getADActivityName())) || !b(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) || !b(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
            for (int i2 = 0; i2 < 1; i2++) {
                try {
                    cls = clsArr[i2];
                    intent = new Intent();
                    intent.setClass(context, cls);
                } catch (Throwable th2) {
                    GDTLogger.e("检查Service时发生异常", th2);
                }
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            return z2;
        } catch (Throwable th3) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th3);
            return false;
        }
    }

    private static boolean b(Context context, Class<?>... clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }
}
