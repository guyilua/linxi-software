package com.sigmob.windad.natives;

import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.nativead.v;
import com.sigmob.sdk.nativead.x;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindNativeUnifiedAd extends j {
    private WindNativeAdLoadListener b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f695c;
    private v d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface WindNativeAdLoadListener {
        void onAdError(WindAdError windAdError, String str);

        void onAdLoad(List<WindNativeAdData> list, String str);
    }

    public WindNativeUnifiedAd(final WindNativeAdRequest windNativeAdRequest) {
        super(windNativeAdRequest, false);
        this.f695c = new Handler(Looper.getMainLooper());
        this.d = new v(windNativeAdRequest, new x() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1
            @Override // com.sigmob.sdk.nativead.x
            public void onNativeAdLoadFail(final int i, final String str) {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                windNativeUnifiedAd.f695c.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WindNativeUnifiedAd.this.b != null) {
                            WindAdError windAdError = WindAdError.getWindAdError(i);
                            if (windAdError == null) {
                                windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                                windAdError.setErrorMessage(i, str);
                                windAdError.setMessage(str);
                            }
                            WindNativeUnifiedAd.this.b.onAdError(windAdError, windNativeAdRequest.getPlacementId());
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.nativead.x
            public void onNativeAdLoaded(final List<WindNativeAdData> list) {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                windNativeUnifiedAd.f695c.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WindNativeUnifiedAd.this.b != null) {
                            WindNativeUnifiedAd.this.b.onAdLoad(list, WindNativeUnifiedAd.this.a());
                        }
                    }
                });
            }
        });
    }

    private boolean a(int i) {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            this.mADStatus = AdStatus.AdStatusLoading;
            if (this.d.a(i, getBid_token(), getBidFloor(), getCurrency()) == 1) {
                y a = y.a(a());
                if (a != null) {
                    a(a);
                } else {
                    b();
                }
            }
            return true;
        } catch (Throwable th) {
            SigmobLog.i(getClass().getSimpleName() + " catch throwable " + th);
            if (this.b != null) {
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                windAdError.setMessage(th.getMessage());
                this.b.onAdError(windAdError, a());
            }
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(final WindAdError windAdError) {
        this.f695c.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd.2
            @Override // java.lang.Runnable
            public void run() {
                WindNativeUnifiedAd windNativeUnifiedAd = WindNativeUnifiedAd.this;
                windNativeUnifiedAd.mADStatus = AdStatus.AdStatusNone;
                if (windNativeUnifiedAd.b != null) {
                    SigmobLog.i("onVideoAdLoadFail " + windAdError.toString() + "|" + WindNativeUnifiedAd.this.a());
                    WindNativeUnifiedAd.this.b.onAdError(windAdError, WindNativeUnifiedAd.this.a());
                }
            }
        });
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(String str, String str2) {
        v vVar = this.d;
        if (vVar != null) {
            vVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected Map<String, BiddingResponse> c() {
        v vVar = this.d;
        if (vVar != null) {
            return vVar.b();
        }
        return null;
    }

    public void destroy() {
        Object[] objArr = new Object[1];
        WindAdRequest windAdRequest = this.a;
        objArr[0] = windAdRequest != null ? windAdRequest.getPlacementId() : "null";
        SigmobLog.i(String.format("native ad  %s is Destroy", objArr));
        this.b = null;
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        v vVar = this.d;
        if (vVar != null) {
            return vVar.a();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    @Deprecated
    public boolean loadAd() {
        try {
            super.loadAd();
            return a(this.a.getAdCount());
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    public boolean loadAd(int i) {
        try {
            super.loadAd();
            return a(i);
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        try {
            super.loadAd(str);
            return a(this.a.getAdCount() > 0 ? this.a.getAdCount() : 1);
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    public boolean loadAd(String str, int i) {
        try {
            super.loadAd(str);
            return a(i);
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(5));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            a(windAdError);
            return false;
        }
    }

    public void setNativeAdLoadListener(WindNativeAdLoadListener windNativeAdLoadListener) {
        this.b = windNativeAdLoadListener;
    }
}
