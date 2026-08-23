package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* compiled from: TbsUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q {
    private static File a;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        File dir;
        if (context == null) {
            return false;
        }
        if (a != null) {
            return true;
        }
        try {
            if (context.getApplicationInfo().processName.contains("com.tencent.mm") && (dir = context.getDir("tbs", 0)) != null && dir.isDirectory()) {
                File file = new File(dir, "share");
                if (!file.isDirectory() && !file.mkdir()) {
                    return false;
                }
                a = file;
                file.setExecutable(true, false);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
