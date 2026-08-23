package com.sigmob.sdk.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.czhj.sdk.common.utils.Dips;
import com.qumeng.advlib.core.ADEvent;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static int a = 0;
    public static final int b = 32;

    /* renamed from: c, reason: collision with root package name */
    public static final int f677c = 8;
    private static int d;
    private static int e;

    public static int a(Activity activity) {
        Resources resources;
        int identifier;
        if (!d(activity) || (resources = activity.getResources()) == null || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String str, Context context) {
        if (!a()) {
            return 0;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return 0;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static com.sigmob.sdk.base.utils.d a(WindowInsets windowInsets) {
        int systemWindowInsetLeft;
        int systemWindowInsetRight;
        int systemWindowInsetBottom;
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        if (i >= 28) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                i2 = displayCutout.getSafeInsetTop();
                systemWindowInsetLeft = displayCutout.getSafeInsetLeft();
                systemWindowInsetRight = displayCutout.getSafeInsetRight();
                systemWindowInsetBottom = displayCutout.getSafeInsetBottom();
            }
            systemWindowInsetBottom = 0;
            systemWindowInsetLeft = 0;
            systemWindowInsetRight = 0;
        } else if (i >= 21) {
            i2 = windowInsets.getStableInsetTop();
            systemWindowInsetLeft = windowInsets.getStableInsetLeft();
            systemWindowInsetRight = windowInsets.getStableInsetRight();
            systemWindowInsetBottom = windowInsets.getStableInsetBottom();
        } else {
            if (i == 20) {
                i2 = windowInsets.getSystemWindowInsetTop();
                systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
                systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
                systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            }
            systemWindowInsetBottom = 0;
            systemWindowInsetLeft = 0;
            systemWindowInsetRight = 0;
        }
        return new com.sigmob.sdk.base.utils.d(i2, systemWindowInsetLeft, systemWindowInsetBottom, systemWindowInsetRight);
    }

    public static String a(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i))).toString();
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str3 = "KLLK";
        if (str.contains("KLLK")) {
            str2 = BaseConstants.ROM_OPPO_UPPER_CONSTANT;
        } else {
            str3 = "kllk";
            if (!str.contains("kllk")) {
                return "";
            }
            str2 = ADEvent.OPPO;
        }
        return str.replace(str3, str2);
    }

    public static void a(Context context, int i) {
        Activity b2 = b(context);
        if (b2 != null) {
            b2.setRequestedOrientation(i);
        }
    }

    public static void a(Window window) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            if (i < 19 || window == null) {
                return;
            }
            window.addFlags(134217728);
            return;
        }
        if (window != null) {
            a = window.getDecorView().getSystemUiVisibility();
            window.clearFlags(134217728);
            window.getDecorView().setSystemUiVisibility(a | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT | 4 | 256 | 512);
            window.addFlags(Integer.MIN_VALUE);
            d = window.getStatusBarColor();
            window.setStatusBarColor(0);
            e = window.getNavigationBarColor();
            window.setNavigationBarColor(0);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
    }

    public static boolean a() {
        try {
            return Class.forName("miui.os.Build") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean b(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (activity == null) {
            activity = com.sigmob.sdk.b.h();
        }
        if (activity == null) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Window c(Context context) {
        Activity b2 = b(context);
        if (b2 != null) {
            return b2.getWindow();
        }
        return null;
    }

    public static boolean c(Activity activity) {
        return b(activity) || a("ro.miui.notch", com.sigmob.sdk.b.e()) == 1 || i(com.sigmob.sdk.b.e()) || k(com.sigmob.sdk.b.e()) || j(com.sigmob.sdk.b.e());
    }

    public static void d(Context context) {
        Window c2;
        if (!g.p || (c2 = c(context)) == null) {
            return;
        }
        c2.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public static boolean d(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(activity).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && g(activity)) {
            h(activity);
        }
    }

    public static void e(Context context) {
        Window c2;
        if (!g.p || (c2 = c(context)) == null) {
            return;
        }
        c2.setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public static void f(Context context) {
        Window c2;
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            if (i < 19 || (c2 = c(context)) == null) {
                return;
            }
            c2.addFlags(67108864);
            c2.addFlags(134217728);
            return;
        }
        Window c3 = c(context);
        if (c3 != null) {
            a = c3.getDecorView().getSystemUiVisibility();
            c3.clearFlags(134217728);
            c3.getDecorView().setSystemUiVisibility(a | f.a.f548c | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT | 4 | 2 | 256 | 512);
            c3.addFlags(Integer.MIN_VALUE);
            d = c3.getStatusBarColor();
            c3.setStatusBarColor(0);
            e = c3.getNavigationBarColor();
            c3.setNavigationBarColor(0);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = c3.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                c3.setAttributes(attributes);
            }
        }
    }

    public static boolean f(Activity activity) {
        Window window = activity != null ? activity.getWindow() : null;
        if (window == null) {
            return true;
        }
        return (window.getDecorView().getSystemUiVisibility() & 1028) == 1028 && (Build.VERSION.SDK_INT < 28 || (window.getAttributes().layoutInDisplayCutoutMode & 1) == 1);
    }

    public static void g(Context context) {
        c(context);
    }

    public static boolean g(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void h(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void h(Context context) {
        Window c2 = c(context);
        if (c2 != null) {
            c2.getDecorView().setSystemUiVisibility(a);
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                c2.clearFlags(Integer.MIN_VALUE);
            }
            if (i >= 28) {
                WindowManager.LayoutParams attributes = c2.getAttributes();
                attributes.layoutInDisplayCutoutMode = 0;
                c2.setAttributes(attributes);
            }
        }
    }

    public static boolean i(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        return context.getPackageManager().hasSystemFeature(a("com.kllk.feature.screen.heteromorphism"));
    }

    public static int l(Context context) {
        int dimensionPixelSize;
        int dipsToIntPixels = Dips.dipsToIntPixels(30.0f, com.sigmob.sdk.b.e());
        if (context == null) {
            return dipsToIntPixels;
        }
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return dipsToIntPixels;
                }
            }
            return dimensionPixelSize;
        } catch (Throwable unused) {
            return dipsToIntPixels;
        }
    }
}
