package com.windmill.baidu;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdSplashAdAdapter extends WMCustomSplashAdapter implements SplashInteractionListener {
    private SplashAd a;
    private String b = getClass().getSimpleName();

    public void destroyAd() {
        SplashAd splashAd = this.a;
        if (splashAd != null) {
            splashAd.destroy();
            this.a = null;
        }
    }

    public Object getChannelObject() {
        return this.a;
    }

    public Map<String, Object> getMediaExtraOption() {
        Object adDataForKey;
        SplashAd splashAd = this.a;
        if (splashAd == null || (adDataForKey = splashAd.getAdDataForKey("request_id")) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", adDataForKey);
        return hashMap;
    }

    public boolean isReady() {
        SplashAd splashAd = this.a;
        if (splashAd != null) {
            return splashAd.isReady();
        }
        return false;
    }

    public void loadAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        try {
            String str = (String) map2.get("placementId");
            SigmobLog.i(this.b + "---loadAd " + str + " " + hashCode());
            RequestParameters.Builder builder = new RequestParameters.Builder();
            Object obj = map2.get("showDownloadDialog");
            builder.addExtra("use_dialog_frame", (obj == null || !obj.equals("1")) ? "false" : "true");
            BidInfo lastBidInfo = getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                builder.addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId());
            }
            this.a = new SplashAd(activity, str, builder.build(), this);
            try {
                Object obj2 = map2.get("bidFloor");
                if (obj2 != null) {
                    this.a.setBidFloor(((Integer) obj2).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.a.load();
        } catch (Exception e2) {
            callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e2.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(this.b + " notifyBiddingResult:" + z + ":" + str);
        try {
            if (this.a != null) {
                Map bidInfoToOut = WMBidUtil.getBidInfoToOut(z, map);
                SigmobLog.i(this.b + " notifyBiddingResult-----1:" + getChannelId() + ":" + z + ":" + map + ":" + bidInfoToOut);
                Map bidInfoWithChannel = WMBidUtil.getBidInfoWithChannel(getChannelId(), z, map, bidInfoToOut);
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                sb.append(" notifyBiddingResult-----2:");
                sb.append(bidInfoWithChannel);
                SigmobLog.i(sb.toString());
                LinkedHashMap<String, Object> castBiddingInfo = bidInfoWithChannel != null ? BdAdapterProxy.castBiddingInfo(z, bidInfoWithChannel) : BdAdapterProxy.castBiddingInfo(z, bidInfoToOut);
                SigmobLog.i(this.b + " notifyBiddingResult-----3:" + castBiddingInfo);
                if (z) {
                    a.a(this.a, String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                } else {
                    a.b(this.a, String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onADLoaded() {
        SigmobLog.i(this.b + "---onADLoaded " + hashCode());
    }

    public void onAdCacheFailed() {
        SigmobLog.i(this.b + "---onAdCacheFailed");
        callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdCacheFailed"));
    }

    public void onAdCacheSuccess() {
        if (this.a != null && getBiddingType() == 1) {
            SigmobLog.i(this.b + "---onAdCacheSuccess ecpm: " + this.a.getECPMLevel() + " pecpm " + this.a.getPECPM());
            BidPrice bidPrice = new BidPrice(this.a.getECPMLevel());
            bidPrice.pecpm = this.a.getPECPM();
            callLoadBiddingSuccess(bidPrice);
        }
        callLoadSuccess();
    }

    public void onAdClick() {
        SigmobLog.i(this.b + "---onAdClick");
        callSplashAdClick();
    }

    public void onAdDismissed() {
        SigmobLog.i(this.b + "---onAdDismissed");
        callSplashAdClosed();
    }

    public void onAdExposed() {
        SigmobLog.i(this.b + "---onAdExposed");
        callSplashAdShow();
    }

    public void onAdFailed(String str) {
        SigmobLog.i(this.b + "---onAdFailed:" + str);
        callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str));
    }

    public void onAdPresent() {
        SigmobLog.i(this.b + "---onAdPresent");
    }

    public void onAdSkip() {
        SigmobLog.i(this.b + "---onAdSkip");
        callSplashAdSkipped();
    }

    public void onLpClosed() {
        SigmobLog.i(this.b + "---onLpClosed");
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        try {
            SplashAd splashAd = this.a;
            if (splashAd == null || !splashAd.isReady()) {
                callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "splashAd is null"));
            } else {
                this.a.show(viewGroup);
            }
        } catch (Exception e) {
            callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
