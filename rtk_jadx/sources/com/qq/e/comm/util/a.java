package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final Map<String, Boolean> a = new HashMap();

    private static boolean a(Class cls, String str, Class... clsArr) {
        String sb;
        if (cls == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("#");
            sb2.append(str);
            for (Class cls2 : clsArr) {
                sb2.append("_");
                sb2.append(cls2.getName());
            }
            sb = sb2.toString();
        }
        Map<String, Boolean> map = a;
        Boolean bool = map.get(sb);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(sb, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            a.put(sb, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
