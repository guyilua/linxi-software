package com.sigmob.sdk.videoplayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    public static final String a = "URL_KEY_DEFAULT";
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f681c;
    public HashMap<String, String> d;
    public boolean e;
    public Object[] f;
    public String title;

    public h(Object obj) {
        this.f681c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.f681c.put(a, obj);
        this.b = 0;
    }

    public h(String str) {
        this.f681c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.f681c.put(a, str);
        this.b = 0;
    }

    public h(String str, String str2) {
        this.f681c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.f681c.put(a, str);
        this.title = str2;
        this.b = 0;
    }

    public h(LinkedHashMap linkedHashMap) {
        this.f681c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.f681c.clear();
        this.f681c.putAll(linkedHashMap);
        this.b = 0;
    }

    public h(LinkedHashMap linkedHashMap, String str) {
        this.f681c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.f681c.clear();
        this.f681c.putAll(linkedHashMap);
        this.title = str;
        this.b = 0;
    }

    public Object a() {
        return b(this.b);
    }

    public String a(int i) {
        int i2 = 0;
        for (Object obj : this.f681c.keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }

    public boolean a(Object obj) {
        if (obj != null) {
            return this.f681c.containsValue(obj);
        }
        return false;
    }

    public Object b() {
        return a(this.b);
    }

    public Object b(int i) {
        int i2 = 0;
        for (Object obj : this.f681c.keySet()) {
            if (i2 == i) {
                return this.f681c.get(obj);
            }
            i2++;
        }
        return null;
    }

    public h c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.f681c);
        return new h(linkedHashMap, this.title);
    }
}
