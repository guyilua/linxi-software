package com.rtk.app.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.rtk.app.R;
import java.util.ArrayList;

/* compiled from: ActivityUntil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static long a;

    static {
        new ArrayList();
        a = 0L;
    }

    public static void a(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.dialog_enter_anim, R.anim.dialog_exit_anim);
    }

    public static <T> void b(Activity activity, Class<T> cls, Bundle bundle) {
        if (System.currentTimeMillis() - a < 400) {
            return;
        }
        a = System.currentTimeMillis();
        Intent intent = new Intent((Context) activity, (Class<?>) cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void c() {
        a = System.currentTimeMillis();
    }
}
