package com.sigmob.sdk.mraid2;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static final b b = new b();
    private HashMap<String, d> a = new HashMap<>();

    private b() {
    }

    public static b a() {
        return b;
    }

    public d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = this.a.get(str);
        this.a.remove(str);
        return dVar;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(str, dVar);
    }

    public d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.get(str);
    }
}
