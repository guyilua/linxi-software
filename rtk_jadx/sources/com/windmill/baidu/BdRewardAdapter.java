package com.windmill.baidu;

import android.app.Activity;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomRewardAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.models.BidPrice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdRewardAdapter extends WMCustomRewardAdapter {
    private boolean a;
    private ArrayList<WeakReference<Activity>> b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f1145c;
    public RewardVideoAd mRewardVideoAd;

    static /* synthetic */ boolean b(BdRewardAdapter bdRewardAdapter) {
        bdRewardAdapter.f1145c = false;
        return false;
    }

    public void destroyAd() {
        if (this.mRewardVideoAd != null) {
            this.mRewardVideoAd = null;
        }
    }

    public Object getChannelObject() {
        return this.mRewardVideoAd;
    }

    public Map<String, Object> getMediaExtraOption() {
        Object adDataForKey;
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null || (adDataForKey = rewardVideoAd.getAdDataForKey("request_id")) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", adDataForKey);
        return hashMap;
    }

    public Map<String, Object> getRewardExtraOption() {
        Object adDataForKey;
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null || (adDataForKey = rewardVideoAd.getAdDataForKey("request_id")) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WindAds.TRANS_ID, adDataForKey);
        return hashMap;
    }

    public boolean isReady() {
        try {
            RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
            if (rewardVideoAd != null) {
                return rewardVideoAd.isReady();
            }
            return false;
        } catch (Throwable th) {
            SigmobLog.e("bd isReady catch Throwable:", th);
            return false;
        }
    }

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        try {
            String str = (String) map2.get("placementId");
            SigmobLog.i(getClass().getSimpleName() + "---loadAd " + map2);
            this.f1145c = false;
            this.mRewardVideoAd = new RewardVideoAd(activity, str, new RewardVideoAd.RewardVideoAdListener() { // from class: com.windmill.baidu.BdRewardAdapter.1
                public void onAdClick() {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " onAdClick()");
                    BdRewardAdapter.this.callVideoAdClick();
                }

                public void onAdClose(float f) {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getName() + " onAdClosed");
                    if (BdRewardAdapter.this.f1145c) {
                        BdRewardAdapter.b(BdRewardAdapter.this);
                        BdRewardAdapter.this.callVideoAdClosed();
                    }
                }

                public void onAdFailed(String str2) {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " onAdFailed:" + str2);
                    BdRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                }

                public void onAdLoaded() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(BdRewardAdapter.this.getClass().getSimpleName());
                    sb.append(" onAdLoaded:");
                    RewardVideoAd rewardVideoAd = BdRewardAdapter.this.mRewardVideoAd;
                    sb.append(rewardVideoAd != null ? Boolean.valueOf(rewardVideoAd.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    BdRewardAdapter bdRewardAdapter = BdRewardAdapter.this;
                    if (bdRewardAdapter.mRewardVideoAd == null || bdRewardAdapter.getBiddingType() != 1) {
                        return;
                    }
                    BidPrice bidPrice = new BidPrice(BdRewardAdapter.this.mRewardVideoAd.getECPMLevel());
                    bidPrice.pecpm = BdRewardAdapter.this.mRewardVideoAd.getPECPM();
                    SigmobLog.i(getClass().getSimpleName() + "----pecpm:" + bidPrice.pecpm);
                    BdRewardAdapter.this.callLoadBiddingSuccess(bidPrice);
                }

                public void onAdShow() {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " onAdShow()");
                    BdRewardAdapter.this.callVideoAdShow();
                }

                public void onAdSkip(float f) {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " onAdSkip()");
                    BdRewardAdapter.this.callVideoAdSkipped();
                }

                public void onRewardVerify(boolean z) {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getName() + " onRewardVerify:" + z);
                    BdRewardAdapter.this.callVideoAdReward(z);
                }

                public void onVideoDownloadFailed() {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " onVideoDownloadFailed()");
                    BdRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onVideoDownloadFailed"));
                }

                public void onVideoDownloadSuccess() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(BdRewardAdapter.this.getClass().getSimpleName());
                    sb.append(" onVideoDownloadSuccess:");
                    RewardVideoAd rewardVideoAd = BdRewardAdapter.this.mRewardVideoAd;
                    sb.append(rewardVideoAd != null ? Boolean.valueOf(rewardVideoAd.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    BdRewardAdapter.this.callLoadSuccess();
                }

                public void playCompletion() {
                    SigmobLog.i(BdRewardAdapter.this.getClass().getSimpleName() + " playCompletion()");
                    BdRewardAdapter.this.callVideoAdPlayComplete();
                }
            });
            Object obj = map2.get("showDownloadDialog");
            if (obj == null || !obj.equals("1")) {
                this.mRewardVideoAd.setDownloadAppConfirmPolicy(3);
            } else {
                this.mRewardVideoAd.setDownloadAppConfirmPolicy(1);
            }
            try {
                Object obj2 = map2.get("bidFloor");
                if (obj2 != null) {
                    this.mRewardVideoAd.setBidFloor(((Integer) obj2).intValue());
                }
                if (map != null) {
                    String Serialize = JSONSerializer.Serialize(map);
                    SigmobLog.i(getClass().getSimpleName() + " json " + Serialize);
                    this.mRewardVideoAd.setExtraInfo(Serialize);
                }
                this.mRewardVideoAd.setUserId(getUserId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            BidInfo lastBidInfo = getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                this.mRewardVideoAd.setRequestParameters(new RequestParameters.Builder().addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId()).build());
            }
            this.mRewardVideoAd.load();
        } catch (Throwable th) {
            SigmobLog.e("bd load ", th);
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult:" + z + ":" + str);
        try {
            if (this.mRewardVideoAd != null) {
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
                    a.a(this.mRewardVideoAd, String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                } else {
                    a.b(this.mRewardVideoAd, String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Activity activity) {
        String name = activity.getClass().getName();
        if (this.a && this.f1145c && name.startsWith("com.baidu.mobads.sdk")) {
            SigmobLog.e(getClass().getSimpleName() + " onCreate " + activity.getClass().getName() + " id " + activity.hashCode());
            this.b.add(new WeakReference<>(activity));
        }
    }

    public void onDestroy(Activity activity) {
        try {
            String name = activity.getClass().getName();
            if (this.a && name.startsWith("com.baidu.mobads.sdk")) {
                SigmobLog.e(getClass().getSimpleName() + " BD onDestroy activity:" + activity.getClass().getSimpleName());
                Iterator<WeakReference<Activity>> it = this.b.iterator();
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
                if (this.f1145c && this.b.isEmpty()) {
                    this.f1145c = false;
                    callVideoAdClosed();
                    this.a = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, HashMap<String, String> hashMap, Map<String, Object> map) {
        try {
            if (map.containsKey("auto_close_callback")) {
                this.a = map.get("auto_close_callback").equals("1");
            }
            RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
            if (rewardVideoAd == null || !rewardVideoAd.isReady()) {
                callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "成功加载广告后再进行广告展示!"));
            } else {
                this.f1145c = true;
                this.mRewardVideoAd.show(activity);
            }
        } catch (Throwable th) {
            SigmobLog.e("bd show ", th);
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), th.getMessage()));
        }
    }
}
