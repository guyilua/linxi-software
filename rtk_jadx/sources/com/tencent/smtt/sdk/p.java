package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* compiled from: TbsVideoUtilsWizard.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class p {
    private DexLoader a;

    public p(DexLoader dexLoader) {
        this.a = null;
        this.a = dexLoader;
    }

    public void a(Context context, String str) {
        Object newInstance;
        DexLoader dexLoader = this.a;
        if (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }

    public String a(Context context) {
        Object newInstance;
        Object invokeMethod;
        DexLoader dexLoader = this.a;
        return (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (invokeMethod = this.a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? "" : String.valueOf(invokeMethod);
    }
}
