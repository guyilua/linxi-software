package com.sigmob.sdk.archives;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e {
    private static final d a = new d();

    private static void a() {
        System.out.println("Parameters: archive-name [archive-type]");
    }

    public static void a(String[] strArr) {
        if (strArr.length == 0) {
            a();
            return;
        }
        System.out.println("Analysing " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            System.err.println(file + " doesn't exist or is a directory");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        c a2 = strArr.length > 1 ? a.a(strArr[1], bufferedInputStream) : a.a(bufferedInputStream);
        System.out.println("Created " + a2.toString());
        while (true) {
            a a3 = a2.a();
            if (a3 == null) {
                a2.close();
                bufferedInputStream.close();
                return;
            }
            System.out.println(a3.a());
        }
    }
}
