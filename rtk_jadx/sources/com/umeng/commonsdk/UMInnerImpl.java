package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.d;
import com.umeng.commonsdk.internal.utils.b;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.statistics.common.ULog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMInnerImpl {
    private static boolean isInternal = false;

    public static synchronized void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                        return;
                                    }
                                    try {
                                        if (!b.a(context).a()) {
                                            b.a(context).b();
                                        }
                                    } catch (Throwable th) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th);
                                    }
                                    try {
                                        j.b(context);
                                    } catch (Throwable th2) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th2);
                                    }
                                } catch (Throwable th3) {
                                    UMCrashManager.reportCrash(context, th3);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                    try {
                                        d.b(context);
                                    } catch (Throwable th) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th);
                                    }
                                }
                            } catch (Throwable th2) {
                                UMCrashManager.reportCrash(context, th2);
                            }
                        }
                    }).start();
                    isInternal = true;
                } finally {
                }
            }
        }
    }
}
