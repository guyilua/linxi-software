package com.windmill.baidu;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.widget.InterstitialViewManager;
import com.windmill.sdk.widget.ViewInteractionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdNIAdapter extends WMCustomInterstitialAdapter {
    private NativeResponse a;
    private f b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1139c = false;
    private WMCustomInterstitialAdapter d = this;

    static /* synthetic */ boolean a(BdNIAdapter bdNIAdapter) {
        bdNIAdapter.f1139c = true;
        return true;
    }

    public void destroyAd() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.destroy();
            this.b = null;
        }
        this.f1139c = false;
    }

    public Map<String, Object> getMediaExtraOption() {
        Object adDataForKey;
        try {
            NativeResponse nativeResponse = this.a;
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
        return (!this.f1139c || this.a == null || this.b == null) ? false : true;
    }

    public void loadAd(final Activity activity, Map<String, Object> map, final Map<String, Object> map2) {
        try {
            this.f1139c = false;
            if (activity == null) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
                return;
            }
            final String str = (String) map2.get("placementId");
            SigmobLog.i(getClass().getSimpleName() + "----loadAd " + str);
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(activity, str);
            RequestParameters.Builder downloadAppConfirmPolicy = new RequestParameters.Builder().downloadAppConfirmPolicy(1);
            BidInfo lastBidInfo = this.d.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + "---bidInfo:" + lastBidInfo.toString());
                downloadAppConfirmPolicy.addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId());
            }
            try {
                Object obj = map2.get("bidFloor");
                if (obj != null) {
                    baiduNativeManager.setBidFloor(((Integer) obj).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            baiduNativeManager.loadFeedAd(downloadAppConfirmPolicy.build(), new BaiduNativeManager.FeedAdListener() { // from class: com.windmill.baidu.BdNIAdapter.1
                public void onLpClosed() {
                    SigmobLog.i(getClass().getSimpleName() + "---onLpClosed()");
                }

                public void onNativeFail(int i, String str2) {
                    SigmobLog.i(BdNIAdapter.this.d.getClass().getSimpleName() + " onNativeFail:" + i + ":" + str2);
                    BdNIAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNativeFail(int i, String str2, NativeResponse nativeResponse) {
                    onNativeFail(i, str2);
                }

                public void onNativeLoad(List<NativeResponse> list) {
                    SigmobLog.i(getClass().getSimpleName() + "----onNativeLoad()");
                    if (list == null || list.isEmpty()) {
                        BdNIAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "list is null or size be 0 " + str));
                        return;
                    }
                    BdNIAdapter.a(BdNIAdapter.this);
                    BdNIAdapter.this.a = list.get(0);
                    BdNIAdapter bdNIAdapter = BdNIAdapter.this;
                    bdNIAdapter.b = new f(activity, bdNIAdapter.a, BdNIAdapter.this.d.getChannelId(), map2);
                    if (BdNIAdapter.this.getBiddingType() == 1) {
                        BidPrice bidPrice = new BidPrice(!TextUtils.isEmpty(BdNIAdapter.this.a.getECPMLevel()) ? BdNIAdapter.this.a.getECPMLevel() : "0");
                        bidPrice.pecpm = BdNIAdapter.this.a.getPECPM();
                        BdNIAdapter.this.callLoadBiddingSuccess(bidPrice);
                    }
                    BdNIAdapter.this.callLoadSuccess();
                }

                public void onNoAd(int i, String str2) {
                    SigmobLog.i(BdNIAdapter.this.d.getClass().getSimpleName() + " onNoAd:" + i + ":" + str2);
                    BdNIAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNoAd(int i, String str2, NativeResponse nativeResponse) {
                    onNoAd(i, str2);
                }

                public void onVideoDownloadFailed() {
                    SigmobLog.i(getClass().getSimpleName() + "---onVideoDownloadFailed()");
                }

                public void onVideoDownloadSuccess() {
                    SigmobLog.i(getClass().getSimpleName() + "---onVideoDownloadSuccess()");
                }
            });
        } catch (Exception e2) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e2.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(getClass().getSimpleName() + "---notifyBiddingResult:" + z + ":" + str);
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
                    a.a(this.a, String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                } else {
                    a.b(this.a, String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, HashMap<String, String> hashMap, Map<String, Object> map) {
        f fVar;
        try {
            SigmobLog.i(getClass().getSimpleName() + "---showAd");
            if (this.a == null || (fVar = this.b) == null || !this.f1139c) {
                callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "成功加载广告后再进行广告展示！"));
            } else {
                new InterstitialViewManager(activity, fVar, map, new ViewInteractionListener() { // from class: com.windmill.baidu.BdNIAdapter.2
                    public final void onAdClick() {
                        BdNIAdapter.this.callVideoAdClick();
                    }

                    public final void onAdClose() {
                        BdNIAdapter.this.callVideoAdClosed();
                    }

                    public final void onAdShow() {
                        BdNIAdapter.this.callVideoAdShow();
                    }

                    public final void onAdShowError(WMAdapterError wMAdapterError) {
                        BdNIAdapter.this.callVideoAdPlayError(wMAdapterError);
                    }
                }).show();
            }
            this.f1139c = false;
        } catch (Exception e) {
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
