package com.qq.e.comm.managers;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GDTAdSdk {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface OnStartListener {
        void onStartFailed(Exception exc);

        void onStartSuccess();
    }

    public static IGDTAdManager getGDTAdManger() {
        return a.b();
    }

    @Deprecated
    public static void init(Context context, String str) {
        GDTLogger.w("该方法已被废弃，请尽快切换初始化接口为GDTAdSdk#initWithoutStart、GDTAdSdk#start，详见接入文档或咨询技术支持。");
        a.b().c(context, str, true);
    }

    public static void initWithoutStart(Context context, String str) {
        a.b().c(context, str, false);
    }

    public static void start(OnStartListener onStartListener) {
        a.b().b(onStartListener);
    }
}
