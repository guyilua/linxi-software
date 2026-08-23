package com.ss.android.downloadlib.g;

import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    private static long a(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, a(file2, j, i2));
                }
            }
        }
        return j;
    }
}
