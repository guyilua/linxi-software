package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DateSorter {
    public static int DAY_COUNT;
    private android.webkit.DateSorter a;
    private IX5DateSorter b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        t a = t.a();
        if (a != null && a.b()) {
            this.b = a.c().h(context);
        } else {
            this.a = new android.webkit.DateSorter(context);
        }
    }

    private static boolean a() {
        t a = t.a();
        return a != null && a.b();
    }

    public long getBoundary(int i) {
        t a = t.a();
        if (a != null && a.b()) {
            return this.b.getBoundary(i);
        }
        return this.a.getBoundary(i);
    }

    public int getIndex(long j) {
        t a = t.a();
        if (a != null && a.b()) {
            return this.b.getIndex(j);
        }
        return this.a.getIndex(j);
    }

    public String getLabel(int i) {
        t a = t.a();
        if (a != null && a.b()) {
            return this.b.getLabel(i);
        }
        return this.a.getLabel(i);
    }
}
