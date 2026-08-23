package com.rtk.app.tool;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.log4j.Level;

/* compiled from: YCStringTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c0 {
    public static String a = "DOWNLOAD_TASK_UP ";
    public static String b = "DOWNLOAD_TASK_GAME ";

    public static void a(String str, String str2, int i, Level... levelArr) {
    }

    public static String b(String str) {
        char[] charArray = str.toCharArray();
        String str2 = "";
        for (int i = 0; i < charArray.length; i++) {
            char charAt = str.charAt(i);
            str2 = charAt <= 256 ? str2 + "\\u00" + Integer.toHexString(charAt) : str2 + "\\u" + Integer.toHexString(charAt);
        }
        return str2;
    }

    public static int c(String str, String str2) {
        int i = 0;
        while (str.indexOf(str2) != -1) {
            str = str.substring(str.indexOf(str2) + 1);
            i++;
        }
        return i;
    }

    public static List<String> d(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!q(str)) {
            for (String str3 : str.split(str2)) {
                if (!q(str3)) {
                    arrayList.add(str3);
                }
            }
        }
        return arrayList;
    }

    public static String e(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        list.toArray(strArr);
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < size; i3++) {
                if (p(strArr[i], strArr[i3])) {
                    String str = strArr[i];
                    strArr[i] = strArr[i3];
                    strArr[i3] = str;
                }
            }
            i = i2;
        }
        String str2 = "";
        for (int i4 = 0; i4 < size; i4++) {
            str2 = str2 + "&" + strArr[i4];
        }
        return str2;
    }

    public static String f(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j * 1000));
    }

    public static String g(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j * 1000));
    }

    public static String h(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        String format2 = simpleDateFormat.format(Long.valueOf(j * 1000));
        return !format.equals(format2) ? format2 : "今天";
    }

    public static String i(long j) {
        return new SimpleDateFormat("HH:mm").format(Long.valueOf(j * 1000));
    }

    public static double j(double d) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("en", "US"));
        decimalFormat.applyPattern("###.##");
        return Double.parseDouble(decimalFormat.format(d));
    }

    public static String k(double d) {
        if (d > 1.073741824E9d) {
            return "" + new DecimalFormat(".00").format((float) (d / 1.073741824E9d)) + "G ";
        }
        if (d > 1048576.0d) {
            return j(d / 1048576.0d) + "M";
        }
        return j(d / 1024.0d) + "K";
    }

    public static String l(double d) {
        if (d > 1.0E9d) {
            return "" + new DecimalFormat(".00").format((float) (d / 1.0E9d)) + "G ";
        }
        if (d > 1000000.0d) {
            return j(d / 1000000.0d) + "M";
        }
        return j(d / 1000.0d) + "K";
    }

    public static String m(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(j));
    }

    public static int n(String str) {
        return Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim());
    }

    public static CharSequence o(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j * 1000));
    }

    private static boolean p(String str, String str2) {
        if (str != null && str2 != null && !"".equals(str) && !"".equals(str2)) {
            char[] charArray = str.toCharArray();
            char[] charArray2 = str2.toCharArray();
            int min = Math.min(charArray.length, charArray2.length);
            for (int i = 0; i < min; i++) {
                if (charArray[i] > charArray2[i]) {
                    return true;
                }
                if (charArray[i] < charArray2[i]) {
                    return false;
                }
            }
            if (charArray.length > charArray2.length) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null || strArr[i].length() == 0 || strArr[i].equals("null")) {
                return true;
            }
        }
        return false;
    }

    public static void r(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.rtk.app.b.b.c(str, str2);
    }

    public static void s(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.rtk.app.b.b.d(str, str2);
    }

    public static void t(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.rtk.app.b.b.h(str, str2);
    }

    public static void u(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.rtk.app.b.b.g(str, str2);
    }
}
