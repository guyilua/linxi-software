package com.rtk.app.b;

import com.rtk.app.main.MyApplication;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: Utils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Date parse = a.parse(str);
            Date parse2 = a.parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(parse2);
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            int timeInMillis = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
            if (timeInMillis != 0) {
                for (int i = 0; i <= timeInMillis; i++) {
                    long timeInMillis2 = calendar.getTimeInMillis() + (BaseConstants.Time.DAY * i);
                    b.b("起止日期之间的日期包括：" + a.format(Long.valueOf(timeInMillis2)));
                    arrayList.add(a.format(Long.valueOf(timeInMillis2)));
                }
            } else {
                b.b("起止日期之间的日期包括：" + str);
                arrayList.add(str);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static void b() {
        a.d(e());
        a.d(c());
        a.d(g());
        b.b = false;
    }

    public static String c() {
        return MyApplication.b().getExternalCacheDir().getPath() + "/RTKLog/copy/";
    }

    public static String d(int i) {
        return a.format(new Date(System.currentTimeMillis() - (i * 86400000)));
    }

    public static String e() {
        return MyApplication.b().getExternalCacheDir().getPath() + "/RTKLog/logs/";
    }

    public static String f() {
        return a.format(new Date());
    }

    public static String g() {
        return MyApplication.b().getExternalCacheDir().getPath() + "/RTKLog/upload/";
    }
}
