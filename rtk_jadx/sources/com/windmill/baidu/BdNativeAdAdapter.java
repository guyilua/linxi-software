package com.windmill.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.baidu.g;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdNativeAdAdapter extends WMCustomNativeAdapter implements g.a {
    private g a;

    public void destroyAd() {
    }

    public Map<String, Object> getMediaExtraOption() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public List<WMNativeAdData> getNativeAdDataList() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    public boolean isReady() {
        try {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.a();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        g mVar;
        try {
            String str = (String) map2.get("placementId");
            int nativeType = getNativeType();
            int nativeAdType = getNativeAdType();
            SigmobLog.i(getClass().getSimpleName() + " loadAd:" + str + ":" + nativeType + ":" + nativeAdType);
            if (nativeType != 1) {
                if (nativeType != 2) {
                    callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "not support nativeType"));
                    return;
                } else {
                    if (nativeAdType != 1) {
                        callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "not support nativeAdType"));
                        return;
                    }
                    mVar = new k(this, this);
                }
            } else if (nativeAdType == 0) {
                mVar = new l(this, this);
            } else {
                if (nativeAdType != 1) {
                    callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "not support nativeAdType"));
                    return;
                }
                mVar = new m(this, this);
            }
            this.a = mVar;
            this.a.a(context, str, map, map2);
        } catch (Throwable th) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult:" + z + ":" + str);
        try {
            if (this.a != null) {
                Map bidInfoToOut = WMBidUtil.getBidInfoToOut(z, map);
                SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult-----1:" + getChannelId() + ":" + z + ":" + map + ":" + bidInfoToOut);
                Map bidInfoWithChannel = WMBidUtil.getBidInfoWithChannel(getChannelId(), z, map, bidInfoToOut);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" notifyBiddingResult-----2:");
                sb.append(bidInfoWithChannel);
                SigmobLog.i(sb.toString());
                LinkedHashMap<String, Object> castBiddingInfo = bidInfoWithChannel != null ? BdAdapterProxy.castBiddingInfo(z, bidInfoWithChannel) : BdAdapterProxy.castBiddingInfo(z, bidInfoToOut);
                SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult-----3:" + castBiddingInfo);
                if (z) {
                    this.a.a(String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                    return;
                }
                g gVar = this.a;
                String.valueOf(castBiddingInfo.get("ecpm"));
                gVar.b(String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.windmill.baidu.g.a
    public void onNativeAdFailToLoad(WMAdapterError wMAdapterError) {
        SigmobLog.i(getClass().getSimpleName() + " onNativeAdFailToLoad:" + wMAdapterError.toString());
        callLoadFail(wMAdapterError);
    }

    @Override // com.windmill.baidu.g.a
    public void onNativeAdLoadSuccess(List<WMNativeAdData> list, String str, String... strArr) {
        SigmobLog.i(getClass().getSimpleName() + " onNativeAdLoadSuccess:" + str);
        if (getBiddingType() == 1) {
            BidPrice bidPrice = new BidPrice(!TextUtils.isEmpty(str) ? String.valueOf(str) : "0");
            if (strArr != null && strArr.length > 0) {
                bidPrice.pecpm = strArr[0];
            }
            callLoadBiddingSuccess(bidPrice);
        }
        callLoadSuccess(list);
    }
}
