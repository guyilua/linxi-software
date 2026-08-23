package com.rtk.app.custom.AutoListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Utils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static String a() {
        return b("yyyy-MM-dd  HH:mm:ss");
    }

    public static String b(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }
}
