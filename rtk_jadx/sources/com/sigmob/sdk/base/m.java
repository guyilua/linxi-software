package com.sigmob.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.p;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m extends j {
    private com.sigmob.sdk.videoAd.h b;

    /* renamed from: c, reason: collision with root package name */
    private com.sigmob.sdk.videoAd.h f409c;
    private Handler d;
    private LoadAdRequest e;
    private o f;
    private boolean g;
    private a h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements o {
        private o b;

        a(o oVar) {
            this.b = oVar;
        }

        public void a() {
            this.b = null;
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadError(final WindAdError windAdError, final String str) {
            SigmobLog.i("onVideoAdLoadError |" + str + "|" + m.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusNone;
            }
            mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.onAdLoadError(windAdError, str);
                    }
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdLoadSuccess(final String str) {
            SigmobLog.i("onVideoAdLoadSuccess |" + str + "|" + m.this.mADStatus);
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusReady;
            }
            mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.onAdLoadSuccess(str);
                    }
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadFail(final WindAdError windAdError, final String str) {
            SigmobLog.i("onVideoAdPreLoadFail |" + str + "|" + m.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            m mVar = m.this;
            if (mVar.mADStatus != AdStatus.AdStatusPlaying) {
                mVar.mADStatus = AdStatus.AdStatusNone;
            }
            mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        a.this.b.onAdPreLoadFail(windAdError, str);
                    }
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.o
        public void onAdPreLoadSuccess(final String str) {
            m.this.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.b != null) {
                        SigmobLog.i("onVideoAdPreLoadSuccess |" + str);
                        a.this.b.onAdPreLoadSuccess(str);
                    }
                }
            });
        }
    }

    public m(WindAdRequest windAdRequest, boolean z) {
        super(windAdRequest, z);
        com.sigmob.sdk.base.common.h.g().a(a(), windAdRequest.getAdType());
        this.g = z;
        this.b = new com.sigmob.sdk.videoAd.h(z);
        this.d = new Handler(Looper.getMainLooper());
    }

    private boolean d() {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
                this.h = null;
            }
            this.h = new a(this.f);
            com.sigmob.sdk.videoAd.h hVar = this.b;
            if (hVar == null) {
                this.b = new com.sigmob.sdk.videoAd.h(this.g);
            } else if (hVar.a() && this.mADStatus == AdStatus.AdStatusReady) {
                this.h.onAdPreLoadSuccess(a());
                this.h.onAdLoadSuccess(a());
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.a);
            this.e = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.e.setBidFloor(getBidFloor());
            this.e.setCurrency(getCurrency());
            com.sigmob.sdk.videoAd.h hVar2 = this.b;
            if (hVar2 != null) {
                hVar2.a(this.h);
            }
            if (this.mADStatus != AdStatus.AdStatusPlaying) {
                b();
                this.mADStatus = AdStatus.AdStatusLoading;
                this.b.a(this.e);
            } else if (this.f409c == null) {
                com.sigmob.sdk.videoAd.h hVar3 = new com.sigmob.sdk.videoAd.h(this.g);
                this.f409c = hVar3;
                hVar3.a(this.h);
                this.f409c.a(this.e);
                b();
            } else if (this.f != null) {
                SigmobLog.i("onVideoAdLoadSuccess |" + a());
                this.f.onAdLoadSuccess(a());
            }
            return true;
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            if (this.f != null) {
                SigmobLog.i("onVideoAdLoadError |" + a());
                this.f.onAdLoadError(windAdError, a());
            }
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(WindAdError windAdError) {
        if (this.mADStatus != AdStatus.AdStatusLoading) {
            this.mADStatus = AdStatus.AdStatusNone;
        }
        o oVar = this.f;
        if (oVar != null) {
            oVar.onAdPreLoadFail(windAdError, a());
            this.f.onAdLoadError(windAdError, a());
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(String str, String str2) {
        com.sigmob.sdk.videoAd.h hVar = this.b;
        if (hVar != null) {
            hVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected Map<String, BiddingResponse> c() {
        com.sigmob.sdk.videoAd.h hVar = this.b;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public void destroy() {
        Object[] objArr = new Object[1];
        WindAdRequest windAdRequest = this.a;
        objArr[0] = windAdRequest != null ? windAdRequest.getPlacementId() : "null";
        SigmobLog.i(String.format("video ad %s is Destroy", objArr));
        com.sigmob.sdk.videoAd.h hVar = this.b;
        if (hVar != null) {
            hVar.b();
            this.b = null;
        }
        com.sigmob.sdk.videoAd.h hVar2 = this.f409c;
        if (hVar2 != null) {
            hVar2.b();
            this.f409c = null;
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
            this.h = null;
        }
        this.f = null;
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        com.sigmob.sdk.videoAd.h hVar = this.b;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public boolean isReady() {
        com.sigmob.sdk.videoAd.h hVar;
        return WindAds.sharedAds().isInit() && !TextUtils.isEmpty(a()) && (hVar = this.b) != null && this.mADStatus == AdStatus.AdStatusReady && hVar.a();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd() {
        super.loadAd();
        return d();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        super.loadAd(str);
        return d();
    }

    public void setAdLoadListener(o oVar) {
        this.f = oVar;
    }

    public boolean show(HashMap<String, String> hashMap, q qVar) {
        return show(hashMap, qVar, null);
    }

    public boolean show(HashMap<String, String> hashMap, final q qVar, final p pVar) {
        LoadAdRequest loadAdRequest;
        try {
            loadAdRequest = this.e;
        } catch (Throwable th) {
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            SigmobLog.e("show Ad ", th);
        }
        if (loadAdRequest == null) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY;
            PointEntitySigmobError SigmobError2 = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), "loadAdRequest is null");
            SigmobError2.setAdtype(String.valueOf(1));
            SigmobError2.setPlacement_id(a());
            SigmobError2.commit();
            if (qVar == null) {
                return false;
            }
            qVar.onAdShowError(windAdError, a());
            return false;
        }
        com.sigmob.sdk.base.common.h.f(loadAdRequest.getPlacementId());
        if (hashMap != null) {
            if (hashMap.containsKey(WindAds.AD_SCENE_ID)) {
                this.e.setAd_scene_id(hashMap.get(WindAds.AD_SCENE_ID));
            }
            if (hashMap.containsKey(WindAds.AD_SCENE_DESC)) {
                this.e.setAd_scene_desc(hashMap.get(WindAds.AD_SCENE_DESC));
            }
        }
        if (this.a.getAdType() == 1) {
            this.b.a(new p() { // from class: com.sigmob.sdk.base.m.1
                @Override // com.sigmob.sdk.videoAd.p
                public void onVideoAdRewarded(final WindRewardInfo windRewardInfo, final String str) {
                    m.this.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (m.this.b != null) {
                                m.this.b.a("reward_callback", windRewardInfo.getOptions());
                            }
                            if (pVar != null) {
                                SigmobLog.i("onVideoAdRewarded " + str);
                                pVar.onVideoAdRewarded(windRewardInfo, str);
                            }
                        }
                    });
                }
            });
        }
        this.b.a(this.e, new q() { // from class: com.sigmob.sdk.base.m.2
            @Override // com.sigmob.sdk.videoAd.q
            public void onAdClicked(final String str) {
                m.this.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (m.this.b != null) {
                            m.this.b.a("click_callback", (Map<String, String>) null);
                        }
                        if (qVar != null) {
                            SigmobLog.i("onVideoAdClicked |" + str);
                            qVar.onAdClicked(str);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.videoAd.q
            public void onAdClosed(final String str) {
                m mVar = m.this;
                mVar.mADStatus = AdStatus.AdStatusClose;
                mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (m.this.b != null) {
                            m.this.b.a("close_callback", (Map<String, String>) null);
                        }
                        if (m.this.f409c != null) {
                            if (m.this.b != null) {
                                m.this.b.b();
                            }
                            m mVar2 = m.this;
                            mVar2.b = mVar2.f409c;
                            m mVar3 = m.this;
                            mVar3.mADStatus = AdStatus.AdStatusReady;
                            mVar3.f409c = null;
                        }
                        if (qVar != null) {
                            SigmobLog.i("onVideoAdClosed " + str);
                            qVar.onAdClosed(str);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.videoAd.q
            public void onAdShow(final String str) {
                m mVar = m.this;
                mVar.mADStatus = AdStatus.AdStatusPlaying;
                mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (m.this.b != null) {
                            m.this.b.a("show_callback", (Map<String, String>) null);
                        }
                        if (qVar != null) {
                            SigmobLog.i("onVideoAdPlayStart |" + str);
                            qVar.onAdShow(str);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.videoAd.q
            public void onAdShowError(final WindAdError windAdError2, final String str) {
                m mVar = m.this;
                mVar.mADStatus = AdStatus.AdStatusClose;
                mVar.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (m.this.f409c != null) {
                            if (m.this.b != null) {
                                m.this.b.b();
                            }
                            m mVar2 = m.this;
                            mVar2.b = mVar2.f409c;
                            m mVar3 = m.this;
                            mVar3.mADStatus = AdStatus.AdStatusReady;
                            mVar3.f409c = null;
                        }
                        if (qVar != null) {
                            SigmobLog.i("onVideoAdPlayError " + windAdError2.toString() + "|" + str);
                            qVar.onAdShowError(windAdError2, str);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.videoAd.q
            public void onVideoAdPlayComplete(final String str) {
                m.this.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.onVideoAdPlayComplete(str);
                        }
                    }
                });
            }

            @Override // com.sigmob.sdk.videoAd.q
            public void onVideoAdPlayEnd(final String str) {
                m.this.d.post(new Runnable() { // from class: com.sigmob.sdk.base.m.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qVar != null) {
                            SigmobLog.i("onVideoAdPlayEnd |" + str);
                            qVar.onVideoAdPlayEnd(str);
                        }
                    }
                });
            }
        });
        return true;
    }
}
