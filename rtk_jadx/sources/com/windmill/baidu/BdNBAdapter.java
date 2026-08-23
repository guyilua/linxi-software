package com.windmill.baidu;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMBidUtil;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.widget.BannerViewInteractionListener;
import com.windmill.sdk.widget.BannerViewManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdNBAdapter extends WMCustomBannerAdapter {
    private View a;
    private NativeResponse b;

    /* renamed from: c, reason: collision with root package name */
    private int f1137c;
    private int d;

    static /* synthetic */ void d(BdNBAdapter bdNBAdapter) {
        try {
            View view = bdNBAdapter.a;
            if (view == null || view.getParent() == null) {
                return;
            }
            ViewParent parent = bdNBAdapter.a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(bdNBAdapter.a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroyAd() {
        if (this.b != null) {
            this.b = null;
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    public View getBannerView() {
        return this.a;
    }

    public Map<String, Object> getMediaExtraOption() {
        Object adDataForKey;
        try {
            NativeResponse nativeResponse = this.b;
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
        return (this.b == null || this.a == null) ? false : true;
    }

    public void loadAd(final Activity activity, Map<String, Object> map, final Map<String, Object> map2) {
        try {
            final String str = (String) map2.get("placementId");
            SigmobLog.i(getClass().getSimpleName() + " loadAd:" + str);
            if (activity == null) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "loadAd with activity is null"));
                return;
            }
            if (map != null) {
                try {
                    Object obj = map.get("ad_key_width");
                    if (obj != null && ((Integer) obj).intValue() != 0) {
                        this.f1137c = Integer.parseInt(String.valueOf(obj));
                    }
                    Object obj2 = map.get("ad_key_height");
                    if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                        this.d = Integer.parseInt(String.valueOf(obj2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(activity, str);
            RequestParameters.Builder downloadAppConfirmPolicy = new RequestParameters.Builder().downloadAppConfirmPolicy(1);
            BidInfo lastBidInfo = getLastBidInfo();
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
            baiduNativeManager.loadFeedAd(downloadAppConfirmPolicy.build(), new BaiduNativeManager.FeedAdListener() { // from class: com.windmill.baidu.BdNBAdapter.1
                public void onLpClosed() {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onLpClosed()");
                }

                public void onNativeFail(int i, String str2) {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onNativeFail:" + i + ":" + str2);
                    BdNBAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNativeFail(int i, String str2, NativeResponse nativeResponse) {
                    onNativeFail(i, str2);
                }

                public void onNativeLoad(List<NativeResponse> list) {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onNativeLoad()");
                    if (list != null && !list.isEmpty()) {
                        BdNBAdapter.this.b = list.get(0);
                        new BannerViewManager(activity, BdNBAdapter.this.f1137c, BdNBAdapter.this.d, new f(activity, BdNBAdapter.this.b, BdNBAdapter.this.getChannelId(), map2), map2, new BannerViewInteractionListener() { // from class: com.windmill.baidu.BdNBAdapter.1.1
                            public final void onAdClick() {
                                BdNBAdapter.this.callBannerAdClick();
                            }

                            public final void onAdClose() {
                                BdNBAdapter.d(BdNBAdapter.this);
                                BdNBAdapter.this.callBannerAdClosed();
                            }

                            public final void onAdRenderError(WMAdapterError wMAdapterError) {
                                BdNBAdapter.this.callLoadFail(wMAdapterError);
                            }

                            public final void onAdRenderSuccess(View view) {
                                if (view == null) {
                                    BdNBAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdRenderSuccess view is null  " + str));
                                    return;
                                }
                                BdNBAdapter.this.a = view;
                                if (BdNBAdapter.this.getBiddingType() == 1) {
                                    BidPrice bidPrice = new BidPrice(!TextUtils.isEmpty(BdNBAdapter.this.b.getECPMLevel()) ? BdNBAdapter.this.b.getECPMLevel() : "0");
                                    bidPrice.pecpm = BdNBAdapter.this.b.getPECPM();
                                    BdNBAdapter.this.callLoadBiddingSuccess(bidPrice);
                                }
                                BdNBAdapter.this.callLoadSuccess();
                            }

                            public final void onAdShow() {
                                BdNBAdapter.this.callBannerAdShow();
                            }

                            public final void onAdShowError(WMAdapterError wMAdapterError) {
                                BdNBAdapter.this.callBannerAdShowError(wMAdapterError);
                            }
                        }).render();
                        return;
                    }
                    BdNBAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "list is null or size be 0 " + str));
                }

                public void onNoAd(int i, String str2) {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onNoAd:" + i + ":" + str2);
                    BdNBAdapter.this.callLoadFail(new WMAdapterError(i, str2));
                }

                public void onNoAd(int i, String str2, NativeResponse nativeResponse) {
                    onNoAd(i, str2);
                }

                public void onVideoDownloadFailed() {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onVideoDownloadFailed()");
                }

                public void onVideoDownloadSuccess() {
                    SigmobLog.i(BdNBAdapter.class.getClass().getSimpleName() + " onVideoDownloadSuccess()");
                }
            });
        } catch (Throwable th) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "catch TT loadAd error " + th.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        SigmobLog.i(getClass().getSimpleName() + " notifyBiddingResult:" + z + ":" + str);
        try {
            if (this.b != null) {
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
                    a.a(this.b, String.valueOf(castBiddingInfo.get("ecpm")), castBiddingInfo);
                } else {
                    a.b(this.b, String.valueOf(castBiddingInfo.get("reason")), castBiddingInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
