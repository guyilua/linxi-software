package com.rtk.app.main.comment.express;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.rtk.app.R;

/* compiled from: KeyboardUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static int a;
    private static int b;

    public static int a(Resources resources) {
        if (a == 0) {
            a = resources.getDimensionPixelSize(R.dimen.max_panel_height);
        }
        return a;
    }

    public static int b(Resources resources) {
        if (b == 0) {
            b = resources.getDimensionPixelSize(R.dimen.min_panel_height);
        }
        return b;
    }

    public static int c(Context context) {
        a(context.getResources());
        return b(context.getResources());
    }

    @TargetApi(3)
    public static void d(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        view.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @TargetApi(3)
    public static void e(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }
}
