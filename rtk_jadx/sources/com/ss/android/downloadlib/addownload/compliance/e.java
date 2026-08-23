package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.g.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private boolean a;
    private a b;

    /* renamed from: c, reason: collision with root package name */
    private int f740c;
    private int d;
    private int e = 15;
    private int f;
    private String g;
    private String h;
    private int i;
    private String j;
    private long k;
    private String l;
    private String m;
    private b n;
    private String o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private String a;
        private String b;

        /* renamed from: c, reason: collision with root package name */
        private long f741c;
        private long d;
        private String e;
        private String f;
        private List<C0074a> g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.e$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class C0074a {
            private String a;
            private String b;

            public void a(String str) {
                this.a = str;
            }

            public void b(String str) {
                this.b = str;
            }
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.e = str;
        }

        public void d(String str) {
            this.f = str;
        }

        public void e(String str) {
            this.h = str;
        }

        public void f(String str) {
            this.i = str;
        }

        public void g(String str) {
            this.j = str;
        }

        public void h(String str) {
            this.k = str;
        }

        public void i(String str) {
            this.l = str;
        }

        public void a(long j) {
            this.f741c = j;
        }

        public void b(long j) {
            this.d = j;
        }

        public void a(List<C0074a> list) {
            this.g = list;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private int a;
        private String b;

        public void a(int i) {
            this.a = i;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public static e g(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a a2 = a(jSONObject);
            b b2 = b(jSONObject);
            eVar.a(a2);
            eVar.a(b2);
            eVar.a(jSONObject.optInt("show_auth", 0) == 1);
            eVar.a(jSONObject.optInt("download_permit"));
            eVar.b(jSONObject.optInt("appstore_permit"));
            eVar.c(jSONObject.optInt("market_online_status", 15));
            eVar.d(jSONObject.optInt("hijack_permit"));
            eVar.a(jSONObject.optString("package_name"));
            eVar.b(jSONObject.optString("hijack_url"));
            eVar.e(jSONObject.optInt("code"));
            eVar.c(jSONObject.optString("message"));
            eVar.a(jSONObject.optLong("request_duration", 0L));
            eVar.d(jSONObject.optString("back_web_url"));
            eVar.e(jSONObject.optString("hw_app_id"));
            eVar.f(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "ComplianceResult fromJson");
        }
        return eVar;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.f = i;
    }

    public void e(int i) {
        this.i = i;
    }

    public void f(String str) {
        this.m = str;
    }

    public String toString() {
        return a(this);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void b(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(String str) {
        this.o = str;
    }

    public void e(String str) {
        this.l = str;
    }

    private static JSONArray c(a aVar) {
        JSONArray jSONArray = new JSONArray();
        List<a.C0074a> list = aVar.g;
        if (list != null && list.size() > 0) {
            for (a.C0074a c0074a : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0074a.a);
                jSONObject.putOpt("permission_desc", c0074a.b);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public void a(int i) {
        this.f740c = i;
    }

    public String b() {
        return this.m;
    }

    private static JSONObject b(a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("app_name", aVar.a);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, aVar.b);
            jSONObject.putOpt("update_time", Long.valueOf(aVar.f741c));
            jSONObject.putOpt("size", Long.valueOf(aVar.d));
            jSONObject.putOpt("developer_name", aVar.e);
            jSONObject.putOpt("policy_url", aVar.i);
            jSONObject.putOpt("icon_url", aVar.j);
            jSONObject.putOpt("download_url", aVar.k);
            jSONObject.putOpt("permissions", c(aVar));
            jSONObject.putOpt("permission_classify_url", aVar.h);
            jSONObject.putOpt("desc_url", aVar.l);
        }
        return jSONObject;
    }

    public void a(String str) {
        this.g = str;
    }

    public int a() {
        return this.i;
    }

    public void a(long j) {
        this.k = j;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public static String a(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(eVar.a ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(eVar.f740c));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(eVar.d));
            jSONObject.putOpt("market_online_status", Integer.valueOf(eVar.e));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(eVar.f));
            jSONObject.putOpt("package_name", eVar.g);
            jSONObject.putOpt("hijack_url", eVar.h);
            jSONObject.putOpt("code", Integer.valueOf(eVar.i));
            jSONObject.putOpt("message", eVar.j);
            jSONObject.putOpt("request_duration", Long.valueOf(eVar.k));
            jSONObject.putOpt("auth_info", b(eVar.b));
            jSONObject.putOpt("status", b(eVar.n));
            jSONObject.putOpt("back_web_url", eVar.o);
            jSONObject.putOpt("hw_app_id", eVar.l);
            jSONObject.putOpt("deep_link", eVar.m);
        } catch (JSONException e) {
            com.ss.android.downloadlib.e.c.a().a(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static b b(JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                bVar.a(optJSONObject.optInt("status"));
                bVar.a(optJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "ComplianceResult getStatus");
        }
        return bVar;
    }

    private static JSONObject b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (bVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(bVar.a));
            jSONObject.putOpt("message", bVar.b);
        }
        return jSONObject;
    }

    private static a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                aVar.a(optJSONObject.optString("app_name"));
                aVar.b(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                aVar.a(m.a(optJSONObject, "update_time"));
                aVar.b(m.a(optJSONObject, "size"));
                aVar.c(optJSONObject.optString("developer_name"));
                aVar.d(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    a(optJSONArray, arrayList);
                    aVar.a(arrayList);
                }
                aVar.e(optJSONObject.optString("permission_classify_url"));
                aVar.f(optJSONObject.optString("policy_url"));
                aVar.g(optJSONObject.optString("icon_url"));
                aVar.h(optJSONObject.optString("download_url"));
                aVar.i(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.e.c.a().a(e, "ComplianceResult getAuthInfo");
        }
        return aVar;
    }

    private static void a(JSONArray jSONArray, List<a.C0074a> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                a.C0074a c0074a = new a.C0074a();
                c0074a.a(optJSONObject.optString("permission_name"));
                c0074a.b(optJSONObject.optString("permission_desc"));
                list.add(c0074a);
            }
        }
    }
}
