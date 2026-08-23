package com.sigmob.windad.rewardVideo;

import com.sigmob.sdk.base.m;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.p;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindRewardVideoAd extends m implements o, p, q {
    protected WindRewardVideoAdListener b;

    public WindRewardVideoAd(WindRewardAdRequest windRewardAdRequest) {
        super(windRewardAdRequest, false);
        setAdLoadListener(this);
    }

    @Override // com.sigmob.sdk.base.m
    public void destroy() {
        this.b = null;
        super.destroy();
    }

    @Override // com.sigmob.sdk.base.m, com.sigmob.sdk.base.j
    public boolean loadAd() {
        return super.loadAd();
    }

    @Override // com.sigmob.sdk.base.m, com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        return super.loadAd(str);
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdClicked(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdClicked(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdClosed(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdClosed(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdLoadError(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdLoadError(windAdError, str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdLoadSuccess(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdLoadSuccess(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdPreLoadFail(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdPreLoadFail(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.o
    public void onAdPreLoadSuccess(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdPreLoadSuccess(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdShow(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdPlayStart(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onAdShowError(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdPlayError(windAdError, str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onVideoAdPlayComplete(String str) {
    }

    @Override // com.sigmob.sdk.videoAd.q
    public void onVideoAdPlayEnd(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdPlayEnd(str);
        }
    }

    @Override // com.sigmob.sdk.videoAd.p
    public void onVideoAdRewarded(WindRewardInfo windRewardInfo, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.b;
        if (windRewardVideoAdListener != null) {
            windRewardVideoAdListener.onRewardAdRewarded(windRewardInfo, str);
        }
    }

    public void setWindRewardVideoAdListener(WindRewardVideoAdListener windRewardVideoAdListener) {
        this.b = windRewardVideoAdListener;
    }

    public boolean show(HashMap<String, String> hashMap) {
        return super.show(hashMap, this, this);
    }
}
