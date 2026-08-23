package com.windmill.baidu;

import android.app.Activity;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.baidu.e;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class c extends e {
    e.a a;
    WMCustomInterstitialAdapter b;

    /* renamed from: c, reason: collision with root package name */
    ExpressInterstitialAd f1147c;
    Boolean d = Boolean.FALSE;
    private Activity e;

    public c(Activity activity, WMCustomInterstitialAdapter wMCustomInterstitialAdapter, e.a aVar) {
        this.e = activity;
        this.b = wMCustomInterstitialAdapter;
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, WMAdapterError wMAdapterError) {
        e.a aVar = cVar.a;
        if (aVar != null) {
            aVar.onInterstitialAdFailToLoad(wMAdapterError);
        }
    }

    private void a(WMAdapterError wMAdapterError) {
        e.a aVar = this.a;
        if (aVar != null) {
            aVar.onInterstitialAdFailToPlaying(wMAdapterError);
        }
    }

    @Override // com.windmill.baidu.e
    public final Object a() {
        return this.f1147c;
    }

    @Override // com.windmill.baidu.e
    public final void a(Activity activity) {
        try {
            ExpressInterstitialAd expressInterstitialAd = this.f1147c;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.show(activity);
            } else {
                a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "expressInterstitialAd is null when show"));
            }
        } catch (Throwable th) {
            a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "bd catch error when show " + th.getMessage()));
        }
    }

    @Override // com.windmill.baidu.e
    public final void a(String str, LinkedHashMap<String, Object> linkedHashMap) {
        ExpressInterstitialAd expressInterstitialAd = this.f1147c;
        if (expressInterstitialAd != null) {
            a.a(expressInterstitialAd, str, linkedHashMap);
        }
    }

    @Override // com.windmill.baidu.e
    public final void a(String str, Map<String, Object> map) {
        try {
            this.d = Boolean.FALSE;
            ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.e, str);
            this.f1147c = expressInterstitialAd;
            expressInterstitialAd.setLoadListener(new ExpressInterstitialListener() { // from class: com.windmill.baidu.BdExpressInterstitialAd$1
                public void onADExposed() {
                    e.a aVar = c.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdStartPlaying();
                    }
                }

                public void onADExposureFailed() {
                }

                public void onADLoaded() {
                    SigmobLog.i(c.this.getClass().getSimpleName() + " onAdLoaded:" + c.this.f1147c.isReady());
                    c cVar = c.this;
                    cVar.d = Boolean.TRUE;
                    if (cVar.f1147c == null || cVar.b.getBiddingType() != 1) {
                        return;
                    }
                    String eCPMLevel = c.this.f1147c.getECPMLevel();
                    c cVar2 = c.this;
                    e.a aVar = cVar2.a;
                    if (aVar != null) {
                        aVar.adapterDidLoadBiddingPriceSuccess(eCPMLevel, cVar2.f1147c.getPECPM());
                    }
                }

                public void onAdCacheFailed() {
                    ExpressInterstitialAd expressInterstitialAd2;
                    StringBuilder sb = new StringBuilder();
                    sb.append(c.this.getClass().getSimpleName());
                    sb.append(" onAdCacheFailed:");
                    ExpressInterstitialAd expressInterstitialAd3 = c.this.f1147c;
                    sb.append(expressInterstitialAd3 != null ? Boolean.valueOf(expressInterstitialAd3.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    if (!c.this.d.booleanValue() || (expressInterstitialAd2 = c.this.f1147c) == null || !expressInterstitialAd2.isReady()) {
                        c.a(c.this, new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdCacheFailed"));
                        return;
                    }
                    e.a aVar = c.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdLoadSuccess();
                    }
                }

                public void onAdCacheSuccess() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c.this.getClass().getSimpleName());
                    sb.append(" onAdCacheSuccess:");
                    ExpressInterstitialAd expressInterstitialAd2 = c.this.f1147c;
                    sb.append(expressInterstitialAd2 != null ? Boolean.valueOf(expressInterstitialAd2.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    e.a aVar = c.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdLoadSuccess();
                    }
                }

                public void onAdClick() {
                    e.a aVar = c.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClick();
                    }
                }

                public void onAdClose() {
                    e.a aVar = c.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClose();
                    }
                }

                public void onAdFailed(int i, String str2) {
                    c.a(c.this, new WMAdapterError(i, str2));
                }

                public void onLpClosed() {
                }

                public void onNoAd(int i, String str2) {
                    c.a(c.this, new WMAdapterError(i, str2));
                }

                public void onVideoDownloadFailed() {
                }

                public void onVideoDownloadSuccess() {
                }
            });
            try {
                Object obj = map.get("bidFloor");
                if (obj != null) {
                    this.f1147c.setBidFloor(((Integer) obj).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BidInfo lastBidInfo = this.b.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                this.f1147c.setRequestParameters(new RequestParameters.Builder().addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId()).build());
            }
            this.f1147c.load();
        } catch (Throwable th) {
            e.a aVar = this.a;
            if (aVar != null) {
                aVar.onInterstitialAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "bd catch error load " + th.getMessage()));
            }
        }
    }

    @Override // com.windmill.baidu.e
    public final void b(String str, LinkedHashMap<String, Object> linkedHashMap) {
        ExpressInterstitialAd expressInterstitialAd = this.f1147c;
        if (expressInterstitialAd != null) {
            a.b(expressInterstitialAd, str, linkedHashMap);
        }
    }

    @Override // com.windmill.baidu.e
    public final boolean b() {
        ExpressInterstitialAd expressInterstitialAd = this.f1147c;
        return expressInterstitialAd != null && expressInterstitialAd.isReady();
    }

    @Override // com.windmill.baidu.e
    public final void c() {
        ExpressInterstitialAd expressInterstitialAd = this.f1147c;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.f1147c = null;
        }
    }

    @Override // com.windmill.baidu.e
    public final Map<String, Object> d() {
        Object adDataForKey;
        ExpressInterstitialAd expressInterstitialAd = this.f1147c;
        if (expressInterstitialAd == null || (adDataForKey = expressInterstitialAd.getAdDataForKey("request_id")) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", adDataForKey);
        return hashMap;
    }
}
