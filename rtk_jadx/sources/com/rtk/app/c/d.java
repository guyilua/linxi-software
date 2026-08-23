package com.rtk.app.c;

import java.util.Calendar;

/* compiled from: TimeUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static int a() {
        return Calendar.getInstance().get(11);
    }

    public static long b() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 10000) + (calendar.get(2) * 100) + calendar.get(5);
    }
}
