package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

/* compiled from: VideoWizard.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class s {
    protected DexLoader a;

    public s(DexLoader dexLoader) {
        this.a = null;
        this.a = dexLoader;
    }

    public Object a(Context context) {
        DexLoader dexLoader = this.a;
        return dexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, dexLoader.getClassLoader());
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        if (obj2 != null) {
            invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", PointCategory.PLAY, new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", PointCategory.PLAY, new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        return false;
    }

    public void a(Object obj, Activity activity, int i) {
        this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    public void a(Object obj) {
        this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }
}
