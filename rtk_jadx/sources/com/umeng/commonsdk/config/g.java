package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: SensitiveFieldHandler.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g implements e {
    @Override // com.umeng.commonsdk.config.e
    public void a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong == -1) {
                UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof b)) {
                return;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    String str2 = strArr[i];
                    if (d.a(str2)) {
                        ((b) obj).a(str2, Boolean.valueOf(a.a(parseLong, i)));
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
        } catch (Throwable unused2) {
            UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
