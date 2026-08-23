package com.windmill.baidu;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.widget.SplashViewManager;
import com.windmill.sdk.widget.ViewInteractionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdNSAdapter extends WMCustomSplashAdapter {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private NativeResponse f1141c;
    private f d;
    private boolean e = false;
    private WMCustomSplashAdapter f = this;

    static /* synthetic */ boolean b(BdNSAdapter bdNSAdapter) {
        bdNSAdapter.e = true;
        return true;
    }

    public void destroyAd() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.destroy();
            this.d = null;
        }
        this.e = false;
    }

    public Map<String, Object> getMediaExtraOption() {
        Object adDataForKey;
        try {
            NativeResponse nativeResponse = this.f1141c;
            if (nativeResponse == null || (adDataForKey = nativeResponse.getAdDataForKey("request_id")) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("request_id", adDataForKey);
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isReady() {
        return (!this.e || this.f1141c == null || this.d == null) ? false : true;
    }

    public void loadAd(final Activity activity, ViewGroup viewGroup, Map<String, Object> map, final Map<String, Object> map2) {
        try {
            this.e = false;
            if (activity == null) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
                return;
            }
            final String str = (String) map2.get("placementId");
            SigmobLog.i(getClass().getSimpleName() + "---loadAd " + str);
            this.a = activity.getResources().getDisplayMetrics().widthPixels;
            this.b = activity.getResources().getDisplayMetrics().heightPixels;
            try {
                Object obj = map.get("ad_key_width");
                if (obj != null && ((Integer) obj).intValue() != 0) {
                    this.a = Integer.parseInt(String.valueOf(obj));
                }
                Object obj2 = map.get("ad_key_height");
                if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                    this.b = Integer.parseInt(String.valueOf(obj2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(activity, str);
            RequestParameters.Builder downloadAppConfirmPolicy = new RequestParameters.Builder().downloadAppConfirmPolicy(1);
            BidInfo lastBidInfo = this.f.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                downloadAppConfirmPolicy.addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId());
            }
            try {
                Object obj3 = map2.get("bidFloor");
                if (obj3 != null) {
                    baiduNativeManager.setBidFloor(((Integer) obj3).intValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            baiduNativeManager.loadFeedAd(downloadAppConfirmPolicy.build(), new BaiduNativeManager.FeedAdListener() { // from class: com.windmill.baidu.BdNSAdapter.1
                public void onLpClosed() {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onLpClosed()");
                }

                public void onNativeFail(int i, String str2) {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onNativeFail:" + i + ":" + str2);
                    BdNSAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNativeFail(int i, String str2, NativeResponse nativeResponse) {
                    onNativeFail(i, str2);
                }

                public void onNativeLoad(List<NativeResponse> list) {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onNativeLoad()");
                    if (list == null || list.isEmpty()) {
                        BdNSAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "list is null or size be 0 " + str));
                        return;
                    }
                    BdNSAdapter.b(BdNSAdapter.this);
                    BdNSAdapter.this.f1141c = list.get(0);
                    BdNSAdapter bdNSAdapter = BdNSAdapter.this;
                    bdNSAdapter.d = new f(activity, bdNSAdapter.f1141c, BdNSAdapter.this.f.getChannelId(), map2);
                    if (BdNSAdapter.this.getBiddingType() == 1) {
                        BidPrice bidPrice = new BidPrice(!TextUtils.isEmpty(BdNSAdapter.this.f1141c.getECPMLevel()) ? BdNSAdapter.this.f1141c.getECPMLevel() : "0");
                        bidPrice.pecpm = BdNSAdapter.this.f1141c.getPECPM();
                        BdNSAdapter.this.callLoadBiddingSuccess(bidPrice);
                    }
                    BdNSAdapter.this.callLoadSuccess();
                }

                public void onNoAd(int i, String str2) {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onNoAd:" + i + ":" + str2);
                    BdNSAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNoAd(int i, String str2, NativeResponse nativeResponse) {
                    onNoAd(i, str2);
                }

                public void onVideoDownloadFailed() {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onVideoDownloadFailed()");
                }

                public void onVideoDownloadSuccess() {
                    SigmobLog.i(BdNSAdapter.this.f.getClass().getSimpleName() + " onVideoDownloadSuccess()");
                }
            });
        } catch (Exception e3) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e3.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult:" + z + ":" + str);
        try {
            if (this.f1141c != null) {
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
                    a.a(this.f1141c, String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                } else {
                    a.b(this.f1141c, String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        f fVar;
        try {
            SigmobLog.i(getClass().getSimpleName() + " showAd");
            if (this.f1141c == null || (fVar = this.d) == null || !this.e) {
                callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "成功加载广告后再进行广告展示！"));
            } else {
                new SplashViewManager(activity, this.a, this.b, fVar, map, new ViewInteractionListener() { // from class: com.windmill.baidu.BdNSAdapter.2
                    public final void onAdClick() {
                        BdNSAdapter.this.callSplashAdClick();
                    }

                    public final void onAdClose() {
                        BdNSAdapter.this.callSplashAdClosed();
                    }

                    public final void onAdShow() {
                        BdNSAdapter.this.callSplashAdShow();
                    }

                    public final void onAdShowError(WMAdapterError wMAdapterError) {
                        BdNSAdapter.this.callSplashAdShowError(wMAdapterError);
                    }
                }).show(viewGroup);
            }
            this.e = false;
        } catch (Exception e) {
            callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
