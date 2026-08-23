package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class I implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.i(str, str2);
    }
}
