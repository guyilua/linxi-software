package com.windmill.baidu;

import android.app.Activity;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.baidu.e;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidPrice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdInterstitialAdapter extends WMCustomInterstitialAdapter implements e.a {
    private e a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1136c;
    private boolean b = false;
    private ArrayList<WeakReference<Activity>> d = new ArrayList<>();

    public void adapterDidLoadBiddingPriceSuccess(String str) {
        callLoadBiddingSuccess(new BidPrice(str));
    }

    @Override // com.windmill.baidu.e.a
    public void adapterDidLoadBiddingPriceSuccess(String str, String... strArr) {
        BidPrice bidPrice = new BidPrice(str);
        if (strArr != null && strArr.length > 0) {
            bidPrice.pecpm = strArr[0];
        }
        callLoadBiddingSuccess(bidPrice);
    }

    public void destroyAd() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.c();
            this.a = null;
        }
    }

    public Object getChannelObject() {
        e eVar = this.a;
        return eVar != null ? eVar.a() : super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.getChannelObject();
    }

    public Map<String, Object> getMediaExtraOption() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public boolean isReady() {
        try {
            e eVar = this.a;
            if (eVar != null) {
                return eVar.b();
            }
            return false;
        } catch (Throwable th) {
            SigmobLog.e("bd isReady catch error", th);
            return false;
        }
    }

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        e cVar;
        try {
            String str = (String) map2.get("placementId");
            int interstitialAdType = getInterstitialAdType();
            this.b = false;
            SigmobLog.i(getClass().getSimpleName() + "---loadAd:" + str + ":" + interstitialAdType);
            if (interstitialAdType == 1) {
                cVar = new d(activity, this, this);
            } else {
                if (interstitialAdType != 0 && interstitialAdType != 2) {
                    callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "can not get bd adType"));
                    return;
                }
                cVar = new c(activity, this, this);
            }
            this.a = cVar;
            this.a.a(str, map2);
        } catch (Throwable th) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "catch bd loadAd error " + th.getMessage()));
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
                } else {
                    this.a.b(String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Activity activity) {
        SigmobLog.e(getClass().getSimpleName() + " GDT onCreate activity:" + activity.getClass().getName());
        String name = activity.getClass().getName();
        if (this.f1136c && this.b && !getCloseToOut() && name.startsWith("com.baidu.mobads.sdk")) {
            SigmobLog.e(getClass().getSimpleName() + " onCreate " + activity.getClass().getName() + " id " + activity.hashCode());
            this.d.add(new WeakReference<>(activity));
        }
    }

    public void onDestroy(Activity activity) {
        try {
            String name = activity.getClass().getName();
            if (this.f1136c && name.startsWith("com.baidu.mobads.sdk")) {
                SigmobLog.e(getClass().getSimpleName() + " BD onDestroy activity:" + activity.getClass().getSimpleName());
                Iterator<WeakReference<Activity>> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (activity.equals(it.next().get())) {
                        SigmobLog.e(getClass().getSimpleName() + " remove " + activity.getClass().getName() + " id " + activity.hashCode());
                        it.remove();
                        break;
                    }
                }
                if (this.b && this.d.isEmpty()) {
                    this.b = false;
                    callVideoAdClosed();
                    this.f1136c = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdClick() {
        callVideoAdClick();
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdClose() {
        if (this.b) {
            this.b = false;
            callVideoAdClosed();
        }
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdFailToLoad(WMAdapterError wMAdapterError) {
        callLoadFail(wMAdapterError);
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdFailToPlaying(WMAdapterError wMAdapterError) {
        callVideoAdPlayError(wMAdapterError);
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdLoadSuccess() {
        callLoadSuccess();
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdPlayComplete() {
        callVideoAdPlayComplete();
    }

    @Override // com.windmill.baidu.e.a
    public void onInterstitialAdStartPlaying() {
        callVideoAdShow();
    }

    public void showAd(Activity activity, HashMap<String, String> hashMap, Map<String, Object> map) {
        try {
            if (map.containsKey("auto_close_callback")) {
                this.f1136c = map.get("auto_close_callback").equals("1");
            }
            e eVar = this.a;
            if (eVar == null || !eVar.b()) {
                callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "成功加载广告后再进行广告展示！"));
            } else {
                this.b = true;
                this.a.a(activity);
            }
        } catch (Throwable th) {
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "catch bd presentVideoAd error " + th.getMessage()));
        }
    }
}
