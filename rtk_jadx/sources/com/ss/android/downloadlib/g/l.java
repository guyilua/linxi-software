package com.ss.android.downloadlib.g;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static l a = new l();
    }

    public static l a() {
        return a.a;
    }

    public void b(String str, String str2, String str3) {
        Log.e("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }

    private l() {
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }
}
