package com.umeng.vt.diff;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Channel {
    private static final String UM_VISUAL_IMPRINT = "utm-visual";

    private void download() {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("download", new Class[0])) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeConfig(Map<String, String> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("storeConfig", Map.class)) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        loadConfig(applicationContext);
        registerListener(applicationContext);
    }

    public void loadConfig(Context context) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, UM_VISUAL_IMPRINT, null);
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        String str = new String(Base64.decode(imprintProperty, 0));
        HashMap hashMap = new HashMap();
        hashMap.put("data-track", str);
        storeConfig(hashMap);
    }

    public void registerListener(final Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(UM_VISUAL_IMPRINT, new UMImprintChangeCallback() { // from class: com.umeng.vt.diff.Channel.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (Channel.UM_VISUAL_IMPRINT.equals(str)) {
                    Channel.this.loadConfig(context);
                }
            }
        });
    }
}
