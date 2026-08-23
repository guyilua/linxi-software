package com.windmill.baidu;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.windmill.sdk.base.WMLogUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class BdNativeAdData2$1 implements NativeResponse.AdInteractionListener {
    public void onADExposed() {
        if (i.a() != null && i.b() != null) {
            i.a().onADExposed(i.b().getAdInFo(i.c()));
        }
        WMLogUtil.d(WMLogUtil.TAG, "onADExposed:" + i.d().getTitle());
        if (i.b() != null) {
            i.b().callNativeAdShow(i.c());
        }
    }

    public void onADExposureFailed(int i) {
        WMLogUtil.d(WMLogUtil.TAG, "onADExposureFailed:".concat(String.valueOf(i)));
    }

    public void onADStatusChanged() {
        WMLogUtil.d(WMLogUtil.TAG, "onADStatusChanged()");
        if (i.d().getAdActionType() != 2 || i.e() == null) {
            return;
        }
        int downloadStatus = i.d().getDownloadStatus();
        if (downloadStatus >= 0 && downloadStatus <= 100) {
            i.e().onDownloadActive(100L, downloadStatus, "", "");
            return;
        }
        if (downloadStatus == 101) {
            i.e().onDownloadFinished(100L, "", "");
            return;
        }
        if (downloadStatus == 102) {
            i.e().onDownloadPaused(100L, 50L, "", "");
            return;
        }
        if (downloadStatus == 103) {
            i.e().onInstalled("", "");
        } else if (downloadStatus == 104) {
            i.e().onDownloadFailed(100L, 1L, "", "");
        } else {
            i.e().onIdle();
        }
    }

    public void onAdClick() {
        if (i.a() != null && i.b() != null) {
            i.a().onADClicked(i.b().getAdInFo(i.c()));
        }
        WMLogUtil.d(WMLogUtil.TAG, "onAdClick:" + i.d().getTitle());
        if (i.b() != null) {
            i.b().callNativeAdClick(i.c());
        }
    }

    public void onAdUnionClick() {
        WMLogUtil.d(WMLogUtil.TAG, "onAdUnionClick()");
    }
}
