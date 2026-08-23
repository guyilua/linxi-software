package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static Boolean a;

    public static boolean a() {
        Boolean bool = a;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static boolean b() {
        if (d() == 0) {
            return true;
        }
        return e();
    }

    public static boolean c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static int d() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, a("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    private static boolean e() {
        String[] strArr = {a("2f7362696e2f7375"), a("2f73797374656d2f62696e2f7375"), a("2f73797374656d2f7862696e2f7375"), a("2f646174612f6c6f63616c2f7862696e2f7375"), a("2f646174612f6c6f63616c2f62696e2f7375"), a("2f73797374656d2f73642f7862696e2f7375"), a("2f73797374656d2f62696e2f6661696c736166652f7375"), a("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean f() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(a("636f6d2e73617572696b2e737562737472617465")) || str.contains(a("58706f7365644272696467652e6a6172")) || str.contains(a("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static synchronized void a(@NonNull Context context) {
        synchronized (f.class) {
            if (a == null) {
                a = Boolean.valueOf((b() || b(context) || c(context) || !d(context) || c() || e(context)) ? false : true);
            }
        }
    }

    public static boolean b(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @WorkerThread
    public static boolean c() {
        try {
            InetAddress.getByName(a("3132372e302e302e31"));
            new Socket(a("3132372e302e302e31"), Integer.parseInt(a("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean d(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    private static String a(@NonNull String str) {
        return com.ss.android.socialbase.downloader.i.f.a(str);
    }

    @WorkerThread
    public static boolean e(Context context) {
        return f() || f(context);
    }

    private static boolean f(Context context) {
        List asList = Arrays.asList(a("64652e726f62762e616e64726f69642e78706f736564"), a("636f6d2e746f706a6f686e77752e6d616769736b"), a("696f2e76612e6578706f736564"), a("636f6d2e77696e642e636f74746572"), a("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), a("6d652e7765697368752e657870"), a("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }
}
