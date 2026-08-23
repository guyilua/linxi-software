package com.rtk.app.main.coins;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: PayResult.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f227c;

    public e(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, "resultStatus")) {
                this.a = map.get(str);
            } else if (TextUtils.equals(str, "result")) {
                this.b = map.get(str);
            } else if (TextUtils.equals(str, "memo")) {
                this.f227c = map.get(str);
            }
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return "resultStatus={" + this.a + "};memo={" + this.f227c + "};result={" + this.b + "}";
    }
}
