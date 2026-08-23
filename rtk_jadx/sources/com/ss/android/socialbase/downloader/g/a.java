package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final h<Integer, a> a = new h<>(16, 16);
    private static final a b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static JSONObject f866c;
    private static JSONObject d;
    private static Boolean e;
    private static boolean f;
    private static a g;
    private final JSONObject h;
    private final JSONObject i;
    private final Boolean j;
    private int k;

    static {
        a();
    }

    private a(JSONObject jSONObject) {
        Boolean bool;
        this.h = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.i = jSONObject2;
        this.j = bool;
    }

    public static void a() {
        JSONObject F = c.F();
        f = F.optInt("disable_task_setting", 0) == 1;
        f866c = F.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = F.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        d = optJSONObject;
        e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.F();
    }

    @NonNull
    public static a c() {
        return b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f866c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.i != null && !f(str)) {
            if (this.i.has(str)) {
                return this.i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    private static a c(int i) {
        DownloadInfo downloadInfo;
        if (f) {
            return b;
        }
        Context O = c.O();
        if (O != null && (downloadInfo = Downloader.getInstance(O).getDownloadInfo(i)) != null) {
            return b(downloadInfo);
        }
        return b;
    }

    public static void a(String str, boolean z) {
        try {
            if (d == null) {
                d = new JSONObject();
            }
            d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static a a(int i) {
        return a(i, (DownloadInfo) null);
    }

    public int b(String str) {
        return a(str, 0);
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i) {
        a aVar = g;
        if (aVar != null && aVar.k == i) {
            g = null;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            hVar.remove(Integer.valueOf(i));
        }
    }

    private static a a(int i, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = g;
        if (aVar2 != null && aVar2.k == i) {
            return aVar2;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            aVar = hVar.get(Integer.valueOf(i));
        }
        if (aVar == null) {
            aVar = downloadInfo == null ? c(i) : b(downloadInfo);
            synchronized (hVar) {
                hVar.put(Integer.valueOf(i), aVar);
            }
        }
        aVar.k = i;
        g = aVar;
        return aVar;
    }

    private static a b(DownloadInfo downloadInfo) {
        if (f) {
            return b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optInt(str, i);
        }
        return b().optInt(str, i);
    }

    public long a(String str, long j) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optLong(str, j);
        }
        return b().optLong(str, j);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f) {
            a aVar = g;
            if (aVar != null && aVar.h == jSONObject) {
                return aVar;
            }
            h<Integer, a> hVar = a;
            synchronized (hVar) {
                for (a aVar2 : hVar.values()) {
                    if (aVar2.h == jSONObject) {
                        g = aVar2;
                        return aVar2;
                    }
                }
                a aVar3 = new a(jSONObject);
                g = aVar3;
                return aVar3;
            }
        }
        return b;
    }

    public static void a(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f) {
            return;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            a aVar = g;
            if (aVar != null && aVar.h == jSONObject) {
                aVar.k = i;
            } else {
                aVar = null;
                Iterator<a> it = hVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.h == jSONObject) {
                        next.k = i;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i;
                }
                g = aVar;
            }
            a.put(Integer.valueOf(i), aVar);
        }
    }
}
