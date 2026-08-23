package com.sigmob.sdk.videocache.file;

import android.text.TextUtils;
import com.sigmob.sdk.videocache.r;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements c {
    private static final int a = 4;

    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.sigmob.sdk.videocache.file.c
    public String a(String str) {
        String b = b(str);
        String d = r.d(str);
        if (TextUtils.isEmpty(b)) {
            return d;
        }
        return d + "." + b;
    }
}
