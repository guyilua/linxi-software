package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityAntiSpan;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WifiScanReceiver extends BroadcastReceiver {
    private List<ScanResult> a;
    private long b = 0;

    private void a(String str, String str2) {
        PointEntityAntiSpan pointEntityAntiSpan = new PointEntityAntiSpan();
        pointEntityAntiSpan.setCategory(PointCategory.WIFI_LIST);
        pointEntityAntiSpan.setAc_type("101");
        pointEntityAntiSpan.setWifi_id_list(str);
        pointEntityAntiSpan.setWifi_mac_list(str2);
        pointEntityAntiSpan.commit();
    }

    @SuppressLint({"MissingPermission"})
    public void a(Context context) {
        try {
            WifiManager wifiManager = DeviceUtils.getWifiManager(context);
            if (wifiManager != null && wifiManager.getWifiState() == 3 && com.sigmob.sdk.base.l.a().m().up_wifi_list_interval.intValue() >= 60) {
                SigmobLog.d("private :use_wifi ");
                SigmobLog.i("scanResult " + wifiManager.startScan());
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r2 == 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    @Override // android.content.BroadcastReceiver
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r8, android.content.Intent r9) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.WifiScanReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
