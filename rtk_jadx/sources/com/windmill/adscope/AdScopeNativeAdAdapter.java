package com.windmill.adscope;

import android.app.Activity;
import android.content.Context;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.adscope.d;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdScopeNativeAdAdapter extends WMCustomNativeAdapter implements d.a {
    private d a;

    public void destroyAd() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public List<WMNativeAdData> getNativeAdDataList() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public boolean isReady() {
        try {
            d dVar = this.a;
            if (dVar != null) {
                return dVar.a();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        try {
            String str = (String) map2.get("placementId");
            int nativeAdType = getNativeAdType();
            SigmobLog.i(getClass().getSimpleName() + " loadAd:" + str + ":" + nativeAdType);
            if (nativeAdType != 0) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "not support nativeAdType"));
                return;
            }
            e eVar = new e(this, this);
            this.a = eVar;
            eVar.a(context, str, map, map2);
        } catch (Throwable th) {
            SigmobLog.i(getClass().getSimpleName() + " catch throwable " + th);
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage()));
        }
    }

    @Override // com.windmill.adscope.d.a
    public void onADClicked(WMNativeAdData wMNativeAdData) {
        callNativeAdClick(wMNativeAdData);
    }

    @Override // com.windmill.adscope.d.a
    public void onADExposure(WMNativeAdData wMNativeAdData) {
        callNativeAdShow(wMNativeAdData);
    }

    @Override // com.windmill.adscope.d.a
    public void onNativeAdFailToLoad(WMAdapterError wMAdapterError) {
        SigmobLog.i(getClass().getSimpleName() + " onNativeAdFailToLoad:" + wMAdapterError.toString());
        callLoadFail(wMAdapterError);
    }

    @Override // com.windmill.adscope.d.a
    public void onNativeAdLoadSuccess(List<WMNativeAdData> list, int i) {
        SigmobLog.i(getClass().getSimpleName() + " onNativeAdLoadSuccess:" + i);
        if (getBiddingType() == 1) {
            callLoadBiddingSuccess(new BidPrice(String.valueOf(i)));
        }
        callLoadSuccess(list);
    }

    public void onResume(Activity activity) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.c();
        }
    }
}
