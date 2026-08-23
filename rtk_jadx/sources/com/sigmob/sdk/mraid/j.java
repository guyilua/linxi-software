package com.sigmob.sdk.mraid;

import android.content.Context;
import android.view.View;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class j {
    protected String a;
    String b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(Context context, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);

        void h(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(String str) {
        this.a = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public abstract View b();

    public abstract void c();

    public String d() {
        return this.b;
    }
}
