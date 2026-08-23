package com.windmill.baidu;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.windmill.sdk.base.WMLogUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class BdNativeAdData2$2 implements NativeResponse.AdDownloadWindowListener {
    public void adDownloadWindowClose() {
        WMLogUtil.d(WMLogUtil.TAG, "adDownloadWindowClose");
    }

    public void adDownloadWindowShow() {
        WMLogUtil.d(WMLogUtil.TAG, "AdDownloadWindowShow");
    }

    public void onADFunctionClick() {
        WMLogUtil.d(WMLogUtil.TAG, "onADFunctionClick");
    }

    public void onADPermissionClose() {
        WMLogUtil.d(WMLogUtil.TAG, "onADPermissionClose");
    }

    public void onADPermissionShow() {
        WMLogUtil.d(WMLogUtil.TAG, "onADPermissionShow");
    }

    public void onADPrivacyClick() {
        WMLogUtil.d(WMLogUtil.TAG, "onADPrivacyClick");
    }
}
