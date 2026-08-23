package com.qq.e.comm.managers;

import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IGDTAdManager {
    String getBuyerId(Map<String, Object> map);

    DevTools getDevTools();

    String getSDKInfo(String str);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
