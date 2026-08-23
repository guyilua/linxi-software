package com.ss.android.downloadlib.addownload.b;

import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static int a = 0;
    public static int b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f725c = 2;
    private int d = a;
    private long e = 0;
    private JSONObject f = null;
    private int g = 0;
    private String h = "";
    private String i = "";

    public boolean a() {
        return this.d == b;
    }

    public int b() {
        return this.g;
    }

    public c a(int i) {
        this.d = i;
        return this;
    }

    public c b(int i) {
        this.g = i;
        return this;
    }
}
