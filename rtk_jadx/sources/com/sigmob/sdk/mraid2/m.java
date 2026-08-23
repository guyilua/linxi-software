package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m {
    private static Map<String, String> a = new HashMap();
    private Map<String, a> b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, a> f591c = new HashMap();
    private Context d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.d = context;
    }

    public String a(int i, String str) {
        return i == 1 ? (String) k.b(this.d, str, "") : a.get(str) == null ? "" : a.get(str);
    }

    public void a(int i) {
        if (i == 1) {
            Map<String, ?> a2 = k.a(this.d);
            if (a2 != null && a2.size() > 0) {
                for (Map.Entry<String, ?> entry : a2.entrySet()) {
                    a aVar = this.b.get(entry.getKey());
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("key", entry.getKey());
                            jSONObject.put("newValue", "");
                            jSONObject.put("oldValue", entry.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        aVar.a(jSONObject);
                    }
                }
            }
            k.b(this.d);
            return;
        }
        Map<String, String> map = a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : a.entrySet()) {
            a aVar2 = this.f591c.get(entry2.getKey());
            if (aVar2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("key", entry2.getKey());
                    jSONObject2.put("newValue", "");
                    jSONObject2.put("oldValue", entry2.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                aVar2.a(jSONObject2);
            }
        }
        a.clear();
    }

    public void a(int i, String str, a aVar) {
        (i == 1 ? this.b : this.f591c).put(str, aVar);
    }

    public void a(int i, String str, String str2) {
        a aVar;
        a aVar2;
        if (i == 1) {
            String str3 = (String) k.b(this.d, str, "");
            if (!str3.equals(str2) && (aVar2 = this.b.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", str);
                    jSONObject.put("newValue", str2);
                    jSONObject.put("oldValue", str3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.a(jSONObject);
            }
            k.a(this.d, str, str2);
            return;
        }
        String str4 = a.get(str) != null ? a.get(str) : "";
        if (!str4.equals(str2) && (aVar = this.f591c.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("newValue", str2);
                jSONObject2.put("oldValue", str4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.a(jSONObject2);
        }
        a.put(str, str2);
    }

    public int b(int i) {
        return (i == 1 ? k.a(this.d) : a).size();
    }

    public void b(int i, String str) {
        a aVar;
        a aVar2;
        if (i == 1) {
            String str2 = (String) k.b(this.d, str, "");
            if (!TextUtils.isEmpty(str2) && (aVar2 = this.b.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", str);
                    jSONObject.put("newValue", "");
                    jSONObject.put("oldValue", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.a(jSONObject);
            }
            k.b(this.d, str);
            return;
        }
        String str3 = a.get(str);
        if (!TextUtils.isEmpty(str3) && (aVar = this.f591c.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("newValue", "");
                jSONObject2.put("oldValue", str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.a(jSONObject2);
        }
        a.remove(str);
    }
}
