package com.windmill.baidu;

import android.app.Activity;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.baidu.e;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidInfo;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class d extends e {
    e.a a;
    WMCustomInterstitialAdapter b;

    /* renamed from: c, reason: collision with root package name */
    public FullScreenVideoAd f1148c;
    private Activity d;

    public d(Activity activity, WMCustomInterstitialAdapter wMCustomInterstitialAdapter, e.a aVar) {
        this.d = activity;
        this.b = wMCustomInterstitialAdapter;
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(d dVar, WMAdapterError wMAdapterError) {
        e.a aVar = dVar.a;
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
        return this.f1148c;
    }

    @Override // com.windmill.baidu.e
    public final void a(Activity activity) {
        try {
            FullScreenVideoAd fullScreenVideoAd = this.f1148c;
            if (fullScreenVideoAd != null) {
                fullScreenVideoAd.show(activity);
            } else {
                a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "mFullScreenVideoAd is null when show"));
            }
        } catch (Throwable th) {
            a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "bd catch error when show " + th.getMessage()));
        }
    }

    @Override // com.windmill.baidu.e
    public final void a(String str, LinkedHashMap<String, Object> linkedHashMap) {
        FullScreenVideoAd fullScreenVideoAd = this.f1148c;
        if (fullScreenVideoAd != null) {
            a.a(fullScreenVideoAd, str, linkedHashMap);
        }
    }

    @Override // com.windmill.baidu.e
    public final void a(String str, Map<String, Object> map) {
        try {
            this.f1148c = new FullScreenVideoAd(this.d, str, new FullScreenVideoAd.FullScreenVideoAdListener() { // from class: com.windmill.baidu.BdFullScreenVideoAd$1
                public void onAdClick() {
                    e.a aVar = d.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClick();
                    }
                }

                public void onAdClose(float f) {
                    e.a aVar = d.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClose();
                    }
                }

                public void onAdFailed(String str2) {
                    d.a(d.this, new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                }

                public void onAdLoaded() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(d.this.getClass().getSimpleName());
                    sb.append(" onAdLoaded:");
                    FullScreenVideoAd fullScreenVideoAd = d.this.f1148c;
                    sb.append(fullScreenVideoAd != null ? Boolean.valueOf(fullScreenVideoAd.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    d dVar = d.this;
                    if (dVar.f1148c == null || dVar.b.getBiddingType() != 1) {
                        return;
                    }
                    String eCPMLevel = d.this.f1148c.getECPMLevel();
                    d dVar2 = d.this;
                    e.a aVar = dVar2.a;
                    if (aVar != null) {
                        aVar.adapterDidLoadBiddingPriceSuccess(eCPMLevel, dVar2.f1148c.getPECPM());
                    }
                }

                public void onAdShow() {
                    e.a aVar = d.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdStartPlaying();
                    }
                }

                public void onAdSkip(float f) {
                }

                public void onVideoDownloadFailed() {
                    d.a(d.this, new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onVideoDownloadFailed"));
                }

                public void onVideoDownloadSuccess() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(d.this.getClass().getSimpleName());
                    sb.append(" onVideoDownloadSuccess:");
                    FullScreenVideoAd fullScreenVideoAd = d.this.f1148c;
                    sb.append(fullScreenVideoAd != null ? Boolean.valueOf(fullScreenVideoAd.isReady()) : "null");
                    SigmobLog.i(sb.toString());
                    e.a aVar = d.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdLoadSuccess();
                    }
                }

                public void playCompletion() {
                    SigmobLog.i(d.this.getClass().getSimpleName() + " playCompletion()");
                    e.a aVar = d.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdPlayComplete();
                    }
                }
            });
            try {
                Object obj = map.get("bidFloor");
                if (obj != null) {
                    this.f1148c.setBidFloor(((Integer) obj).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BidInfo lastBidInfo = this.b.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                this.f1148c.setRequestParameters(new RequestParameters.Builder().addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId()).build());
            }
            this.f1148c.load();
        } catch (Throwable th) {
            e.a aVar = this.a;
            if (aVar != null) {
                aVar.onInterstitialAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "bd catch error load " + th.getMessage()));
            }
        }
    }

    @Override // com.windmill.baidu.e
    public final void b(String str, LinkedHashMap<String, Object> linkedHashMap) {
        FullScreenVideoAd fullScreenVideoAd = this.f1148c;
        if (fullScreenVideoAd != null) {
            a.b(fullScreenVideoAd, str, linkedHashMap);
        }
    }

    @Override // com.windmill.baidu.e
    public final boolean b() {
        FullScreenVideoAd fullScreenVideoAd = this.f1148c;
        return fullScreenVideoAd != null && fullScreenVideoAd.isReady();
    }

    @Override // com.windmill.baidu.e
    public final void c() {
        if (this.f1148c != null) {
            this.f1148c = null;
        }
    }

    @Override // com.windmill.baidu.e
    public final Map<String, Object> d() {
        return null;
    }
}
