package com.rtk.app.tool;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* compiled from: SystemStatusManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class z {
    private static String f;
    private final b a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f336c;
    private View d;
    private View e;

    /* compiled from: SystemStatusManager.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private final int a;
        private final boolean b;

        /* renamed from: c, reason: collision with root package name */
        private final int f337c;
        private final int d;
        private final boolean e;
        private final float f;

        @TargetApi(14)
        private int a(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        private int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        private int f(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        @SuppressLint({"NewApi"})
        private float g(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f = displayMetrics.widthPixels;
            float f2 = displayMetrics.density;
            return Math.min(f / f2, displayMetrics.heightPixels / f2);
        }

        @TargetApi(14)
        private boolean i(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(z.f)) {
                    return false;
                }
                if ("0".equals(z.f)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int c() {
            return this.f337c;
        }

        public int e() {
            return this.d;
        }

        public int h() {
            return this.a;
        }

        public boolean j() {
            return this.b;
        }

        public boolean k() {
            return this.f >= 600.0f || this.e;
        }

        private b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.e = resources.getConfiguration().orientation == 1;
            this.f = g(activity);
            this.a = b(resources, "status_bar_height");
            a(activity);
            int d = d(activity);
            this.f337c = d;
            this.d = f(activity);
            this.b = d > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f = null;
            }
        }
    }

    @TargetApi(19)
    public z(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
            try {
                this.b = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                int i = window.getAttributes().flags;
                if ((67108864 & i) != 0) {
                    this.b = true;
                }
                if ((i & 134217728) != 0) {
                    this.f336c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.b, this.f336c);
        this.a = bVar;
        if (!bVar.j()) {
            this.f336c = false;
        }
        if (this.b) {
            e(activity, viewGroup);
        }
        if (this.f336c) {
            d(activity, viewGroup);
        }
    }

    private void d(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.e = new View(context);
        if (this.a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundColor(-1728053248);
        this.e.setVisibility(8);
        viewGroup.addView(this.e);
    }

    private void e(Context context, ViewGroup viewGroup) {
        this.d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.a.h());
        layoutParams.gravity = 48;
        if (this.f336c && !this.a.k()) {
            layoutParams.rightMargin = this.a.e();
        }
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1728053248);
        this.d.setVisibility(8);
        viewGroup.addView(this.d);
    }

    public void b(boolean z) {
        if (this.b) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public void c(int i) {
        if (this.b) {
            this.d.setBackgroundResource(i);
        }
    }
}
