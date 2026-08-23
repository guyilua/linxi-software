package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Event.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private String b;
    private String a = "_$unknown";

    /* renamed from: c, reason: collision with root package name */
    private long f1125c = 0;
    private long d = 0;
    private String e = a.j;
    private Map<String, Object> f = null;

    public b(Context context) {
        this.b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.f1125c;
    }

    public Map<String, Object> c() {
        return this.f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.b);
            jSONObject.put("ds", this.d);
            jSONObject.put("ts", this.f1125c);
            Map<String, Object> map = this.f;
            if (map != null && map.size() > 0) {
                for (String str : this.f.keySet()) {
                    jSONObject.put(str, this.f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.a + ",");
        sb.append("pn:" + this.b + ",");
        sb.append("ts:" + this.f1125c + ",");
        Map<String, Object> map = this.f;
        if (map != null && map.size() > 0) {
            for (String str : this.f.keySet()) {
                Object obj = this.f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(long j) {
        this.f1125c = j;
    }

    public void a(Map<String, Object> map) {
        this.f = map;
    }
}
