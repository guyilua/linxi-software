package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReaderWizard {
    private DexLoader a;
    private TbsReaderView.ReaderCallback b;

    public ReaderWizard(TbsReaderView.ReaderCallback readerCallback) {
        this.a = null;
        this.b = null;
        this.a = a();
        this.b = readerCallback;
    }

    private static DexLoader a() {
        r c2 = d.a(true).c();
        if (c2 != null) {
            return c2.b();
        }
        return null;
    }

    public static Drawable getResDrawable(int i) {
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    public static String getResString(int i) {
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof String) {
                return (String) invokeStaticMethod;
            }
        }
        return "";
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        DexLoader a = a();
        if (a == null) {
            return false;
        }
        Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public static boolean isSupportExt(String str) {
        DexLoader a = a();
        if (a == null) {
            return false;
        }
        Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        DexLoader dexLoader = this.a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (!(invokeMethod instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
            return false;
        }
        return ((Boolean) invokeMethod).booleanValue();
    }

    public void destroy(Object obj) {
        this.b = null;
        DexLoader dexLoader = this.a;
        if (dexLoader != null && obj != null) {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        } else {
            Log.e("ReaderWizard", "destroy:Unexpect null object!");
        }
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        DexLoader dexLoader = this.a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "doCommand:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
        }
    }

    public Object getTbsReader() {
        return this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean initTbsReader(Object obj, Context context) {
        DexLoader dexLoader = this.a;
        if (dexLoader != null && obj != null) {
            Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", PointCategory.INIT, new Class[]{Context.class, DexLoader.class, Object.class}, context, dexLoader, this);
            if (!(invokeMethod instanceof Boolean)) {
                Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
                return false;
            }
            return ((Boolean) invokeMethod).booleanValue();
        }
        Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
        return false;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        TbsReaderView.ReaderCallback readerCallback = this.b;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        DexLoader dexLoader = this.a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, new Integer(i), new Integer(i2));
        }
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        DexLoader dexLoader = this.a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "openFile:Unexpect null object!");
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (!(invokeMethod instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
            return false;
        }
        return ((Boolean) invokeMethod).booleanValue();
    }

    public void userStatistics(Object obj, String str) {
        DexLoader dexLoader = this.a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        }
    }
}
