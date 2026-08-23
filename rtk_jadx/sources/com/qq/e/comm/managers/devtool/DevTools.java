package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DevTools {
    private String a;

    public String getDemoGameUrl() {
        String str = this.a;
        this.a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.a = str;
        }
    }
}
