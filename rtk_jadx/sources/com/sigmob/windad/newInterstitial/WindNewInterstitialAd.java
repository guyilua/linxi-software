package com.sigmob.windad.newInterstitial;

import com.sigmob.sdk.newInterstitial.i;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindNewInterstitialAd extends i implements o, q {
    protected WindNewInterstitialAdListener b;

    public WindNewInterstitialAd(WindNewInterstitialAdRequest windNewInterstitialAdRequest) {
        super(windNewInterstitialAdRequest);
        setAdLoadListener(this);
    }

    @Override // com.sigmob.sdk.newInterstitial.i
    public void destroy() {
        this.b = null;
        super.destroy();
    }

    @Override // com.sigmob.sdk.newInterstitial.i, com.sigmob.sdk.base.j
    public boolean loadAd() {
        return super.loadAd();
    }

    @Override // com.sigmob.sdk.newInterstitial.i, com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        return super.loadAd(str);
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdClicked(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdClicked(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdClosed(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdClosed(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdLoadError(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdLoadError(windAdError, str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdLoadSuccess(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdLoadSuccess(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdPreLoadFail(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdPreLoadFail(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdPreLoadSuccess(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdPreLoadSuccess(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdShow(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdShow(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdShowError(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.b;
        if (windNewInterstitialAdListener != null) {
            windNewInterstitialAdListener.onInterstitialAdShowError(windAdError, str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onVideoAdPlayComplete(String str) {
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onVideoAdPlayEnd(String str) {
    }

    public void setWindNewInterstitialAdListener(WindNewInterstitialAdListener windNewInterstitialAdListener) {
        this.b = windNewInterstitialAdListener;
    }

    public boolean show(HashMap<String, String> hashMap) {
        return super.show(hashMap, this);
    }
}
