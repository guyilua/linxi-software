package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.umeng.analytics.pro.ak;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final HashMap<String, g.a> a = new HashMap<>();

    public static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString(com.umeng.analytics.pro.d.y)) && a(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split[i2 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject == null || f.a() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject) && a(jSONObject.optJSONArray("device_requirements")) && c(jSONObject);
    }

    public static boolean a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(str)) {
                        str = e.j();
                    }
                    g.a b = b(str);
                    if (b != null && !(z = a(optJSONArray, optJSONArray2, optString2, b))) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static g.a b(String str) {
        HashMap<String, g.a> hashMap = a;
        if (hashMap.containsKey(str)) {
            g.a aVar = hashMap.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        g.a b = g.b(str);
        hashMap.put(str, b);
        if (b != null) {
            return b;
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull g.a aVar) {
        String g = aVar.g();
        int f = aVar.f();
        String str2 = f + "_" + g;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split[i + 1]);
                    if (f >= parseInt && f <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (b(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !b(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static g.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                g.a b = b(str);
                if (b != null) {
                    return b;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean a(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString(ak.aB);
            try {
                String a2 = c.a(jSONObject.optString("az"), optString);
                String a3 = c.a(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(a2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(a3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
