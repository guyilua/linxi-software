package com.windmill.adscope;

import android.app.Activity;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.InterstitialAdListener;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.adscope.c;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b extends c {
    c.a a;
    InterstitialAd b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f1134c;

    public b(Activity activity, c.a aVar) {
        this.f1134c = activity;
        this.a = aVar;
    }

    private void a(WMAdapterError wMAdapterError) {
        c.a aVar = this.a;
        if (aVar != null) {
            aVar.onInterstitialAdFailToPlaying(wMAdapterError);
        }
    }

    @Override // com.windmill.adscope.c
    public final void a(Activity activity) {
        try {
            InterstitialAd interstitialAd = this.b;
            if (interstitialAd == null || !interstitialAd.isLoaded()) {
                a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "expressInterstitialAd is null when show"));
            } else {
                this.b.showAd(activity);
            }
        } catch (Throwable th) {
            a(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "adScope catch error when show " + th.getMessage()));
        }
    }

    @Override // com.windmill.adscope.c
    public final void a(String str, Map<String, Object> map) {
        try {
            this.b = new InterstitialAd(this.f1134c, str, new InterstitialAdListener() { // from class: com.windmill.adscope.b.1
                public final void onAdClick() {
                    c.a aVar = b.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClick();
                    }
                }

                public final void onAdClosed() {
                    c.a aVar = b.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdClose();
                    }
                }

                public final void onAdFailed(int i) {
                    SigmobLog.i(b.this.getClass().getSimpleName() + " onAdFailed:" + i);
                    c.a aVar = b.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdFailToLoad(new WMAdapterError(i, "onAdFailed"));
                    }
                }

                public final void onAdLoaded() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.this.getClass().getSimpleName());
                    sb.append(" onAdLoaded:");
                    InterstitialAd interstitialAd = b.this.b;
                    sb.append(interstitialAd != null ? Boolean.valueOf(interstitialAd.isLoaded()) : "null");
                    SigmobLog.i(sb.toString());
                    InterstitialAd interstitialAd2 = b.this.b;
                    int ecpm = interstitialAd2 != null ? interstitialAd2.getECPM() : 0;
                    c.a aVar = b.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdLoadSuccess(ecpm);
                    }
                }

                public final void onAdShown() {
                    c.a aVar = b.this.a;
                    if (aVar != null) {
                        aVar.onInterstitialAdStartPlaying();
                    }
                }
            }, 5000L);
            int i = 1;
            try {
                Object obj = map.get("adTemplateType");
                if (obj != null) {
                    i = Integer.parseInt((String) obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b.setAdVersion(i);
            this.b.loadAd();
        } catch (Throwable th) {
            c.a aVar = this.a;
            if (aVar != null) {
                aVar.onInterstitialAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "adScope catch error load " + th.getMessage()));
            }
        }
    }

    @Override // com.windmill.adscope.c
    public final boolean a() {
        InterstitialAd interstitialAd = this.b;
        return interstitialAd != null && interstitialAd.isLoaded();
    }

    @Override // com.windmill.adscope.c
    public final void b() {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.b = null;
        }
    }
}
