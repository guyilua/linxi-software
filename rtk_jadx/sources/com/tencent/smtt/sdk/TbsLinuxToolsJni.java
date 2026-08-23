package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsLinuxToolsJni {
    private static boolean a = false;
    private static boolean b = false;

    public TbsLinuxToolsJni(Context context) {
        a(context);
    }

    private native int ChmodInner(String str, String str2);

    public int a(String str, String str2) {
        if (!a) {
            TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
            return -1;
        }
        return ChmodInner(str, str2);
    }

    private void a(Context context) {
        File q;
        synchronized (TbsLinuxToolsJni.class) {
            TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
            if (b) {
                return;
            }
            b = true;
            try {
                if (TbsShareManager.isThirdPartyApp(context)) {
                    String a2 = TbsShareManager.a();
                    if (a2 == null) {
                        a2 = TbsShareManager.c(context);
                    }
                    q = new File(a2);
                } else {
                    q = l.a().q(context);
                }
                if (q != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(q.getAbsolutePath());
                    String str = File.separator;
                    sb.append(str);
                    sb.append("liblinuxtoolsfortbssdk_jni.so");
                    if (!new File(sb.toString()).exists() && !TbsShareManager.isThirdPartyApp(context)) {
                        q = l.a().p(context);
                    }
                    if (q != null) {
                        TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + q.getAbsolutePath());
                        System.load(q.getAbsolutePath() + str + "liblinuxtoolsfortbssdk_jni.so");
                        a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                th.printStackTrace();
                a = false;
                TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + th.getMessage() + " ## " + th.getCause());
            }
        }
    }
}
