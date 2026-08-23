package com.sigmob.windad;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindAdOptions {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f692c;
    private WindCustomController d;

    public WindAdOptions(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str.trim();
        }
        this.b = str2;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppKey() {
        return this.b;
    }

    public WindCustomController getCustomController() {
        return this.d;
    }

    public HashMap<String, String> getExtData() {
        return this.f692c;
    }

    public WindAdOptions setCustomController(WindCustomController windCustomController) {
        this.d = windCustomController;
        return this;
    }

    public WindAdOptions setExtData(HashMap<String, String> hashMap) {
        this.f692c = hashMap;
        return this;
    }
}
