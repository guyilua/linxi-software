package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o {
    public static long a(@NonNull List<i> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar.c() > j) {
                break;
            }
            if (iVar.e() > j) {
                j = iVar.e();
            }
        }
        return j;
    }

    public static long b(@NonNull List<i> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (i iVar : list) {
                if (j == -1) {
                    if (iVar.a() > 0) {
                        j = iVar.c();
                        j2 = iVar.d();
                    }
                } else if (iVar.c() > j2) {
                    j3 += j2 - j;
                    if (iVar.a() > 0) {
                        j = iVar.c();
                        j2 = iVar.d();
                    }
                } else if (iVar.d() > j2) {
                    j2 = iVar.d();
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
    }
}
