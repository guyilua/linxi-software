package com.sigmob.sdk.newInterstitial;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i extends j {
    private com.sigmob.sdk.newInterstitial.a b;

    /* renamed from: c, reason: collision with root package name */
    private com.sigmob.sdk.newInterstitial.a f636c;
    private Handler d;
    private LoadAdRequest e;
    private o f;
    private a g;

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
            SigmobLog.i("onVideoAdLoadError |" + str + "|" + i.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusNone;
            }
            iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.a.4
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
            SigmobLog.i("onVideoAdLoadSuccess |" + str + "|" + i.this.mADStatus);
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusReady;
            }
            iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.a.1
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
            SigmobLog.i("onVideoAdPreLoadFail |" + str + "|" + i.this.mADStatus + "|" + windAdError.getErrorCode() + "|" + windAdError.getMessage());
            i iVar = i.this;
            if (iVar.mADStatus != AdStatus.AdStatusPlaying) {
                iVar.mADStatus = AdStatus.AdStatusNone;
            }
            iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.a.3
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
            i.this.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.a.2
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

    public i(WindAdRequest windAdRequest) {
        super(windAdRequest, false);
        com.sigmob.sdk.base.common.h.g().a(a(), windAdRequest.getAdType());
        this.b = new com.sigmob.sdk.newInterstitial.a();
        this.d = new Handler(Looper.getMainLooper());
    }

    private boolean d() {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            a aVar = this.g;
            if (aVar != null) {
                aVar.a();
                this.g = null;
            }
            this.g = new a(this.f);
            com.sigmob.sdk.newInterstitial.a aVar2 = this.b;
            if (aVar2 == null) {
                this.b = new com.sigmob.sdk.newInterstitial.a();
            } else if (aVar2.a() && this.mADStatus == AdStatus.AdStatusReady) {
                this.g.onAdPreLoadSuccess(a());
                this.g.onAdLoadSuccess(a());
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.a);
            this.e = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.e.setBidFloor(getBidFloor());
            this.e.setCurrency(getCurrency());
            com.sigmob.sdk.newInterstitial.a aVar3 = this.b;
            if (aVar3 != null) {
                aVar3.a(this.g);
            }
            if (this.mADStatus != AdStatus.AdStatusPlaying) {
                b();
                this.mADStatus = AdStatus.AdStatusLoading;
                this.b.a(this.e);
            } else if (this.f636c == null) {
                com.sigmob.sdk.newInterstitial.a aVar4 = new com.sigmob.sdk.newInterstitial.a();
                this.f636c = aVar4;
                aVar4.a(this.g);
                this.f636c.a(this.e);
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
                SigmobLog.i("onVideoAdLoadError |" + a() + "|" + this.mADStatus + "|" + th.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("onVideoAdLoadError |");
                sb.append(a());
                SigmobLog.i(sb.toString());
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
        com.sigmob.sdk.newInterstitial.a aVar = this.b;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected Map<String, BiddingResponse> c() {
        com.sigmob.sdk.newInterstitial.a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public void destroy() {
        com.sigmob.sdk.newInterstitial.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
            this.b = null;
        }
        com.sigmob.sdk.newInterstitial.a aVar2 = this.f636c;
        if (aVar2 != null) {
            aVar2.b();
            this.f636c = null;
        }
        a aVar3 = this.g;
        if (aVar3 != null) {
            aVar3.a();
            this.g = null;
        }
        this.f = null;
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        com.sigmob.sdk.newInterstitial.a aVar = this.b;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public boolean isReady() {
        com.sigmob.sdk.newInterstitial.a aVar;
        return WindAds.sharedAds().isInit() && !TextUtils.isEmpty(a()) && (aVar = this.b) != null && this.mADStatus == AdStatus.AdStatusReady && aVar.a();
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

    public boolean show(HashMap<String, String> hashMap, final q qVar) {
        try {
        } catch (Throwable th) {
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(1));
            SigmobError.setPlacement_id(a());
            SigmobError.commit();
            SigmobLog.e("show Ad ", th);
        }
        if (this.e != null) {
            if (hashMap != null) {
                if (hashMap.containsKey(WindAds.AD_SCENE_ID)) {
                    this.e.setAd_scene_id(hashMap.get(WindAds.AD_SCENE_ID));
                }
                if (hashMap.containsKey(WindAds.AD_SCENE_DESC)) {
                    this.e.setAd_scene_desc(hashMap.get(WindAds.AD_SCENE_DESC));
                }
            }
            this.b.a(this.e, new q() { // from class: com.sigmob.sdk.newInterstitial.i.1
                @Override // com.sigmob.sdk.videoAd.q
                public void onAdClicked(final String str) {
                    i.this.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.b != null) {
                                i.this.b.a("click_callback", (Map<String, String>) null);
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
                    i iVar = i.this;
                    iVar.mADStatus = AdStatus.AdStatusClose;
                    iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.b != null) {
                                i.this.b.a("close_callback", (Map<String, String>) null);
                            }
                            if (i.this.f636c != null) {
                                if (i.this.b != null) {
                                    i.this.b.b();
                                }
                                i iVar2 = i.this;
                                iVar2.b = iVar2.f636c;
                                i iVar3 = i.this;
                                iVar3.mADStatus = AdStatus.AdStatusReady;
                                iVar3.f636c = null;
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
                    i iVar = i.this;
                    iVar.mADStatus = AdStatus.AdStatusPlaying;
                    iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.b != null) {
                                i.this.b.a("show_callback", (Map<String, String>) null);
                            }
                            if (qVar != null) {
                                SigmobLog.i("onVideoAdPlayStart |" + str);
                                qVar.onAdShow(str);
                            }
                        }
                    });
                }

                @Override // com.sigmob.sdk.videoAd.q
                public void onAdShowError(final WindAdError windAdError, final String str) {
                    i iVar = i.this;
                    iVar.mADStatus = AdStatus.AdStatusClose;
                    iVar.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i.this.f636c != null) {
                                if (i.this.b != null) {
                                    i.this.b.b();
                                }
                                i iVar2 = i.this;
                                iVar2.b = iVar2.f636c;
                                i iVar3 = i.this;
                                iVar3.mADStatus = AdStatus.AdStatusReady;
                                iVar3.f636c = null;
                            }
                            if (qVar != null) {
                                SigmobLog.i("onVideoAdPlayError " + windAdError.toString() + "|" + str);
                                qVar.onAdShowError(windAdError, str);
                            }
                        }
                    });
                }

                @Override // com.sigmob.sdk.videoAd.q
                public void onVideoAdPlayComplete(final String str) {
                    i.this.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (qVar != null) {
                                SigmobLog.i("onVideoAdPlayComplete " + str);
                                qVar.onVideoAdPlayComplete(str);
                            }
                        }
                    });
                }

                @Override // com.sigmob.sdk.videoAd.q
                public void onVideoAdPlayEnd(final String str) {
                    i.this.d.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.i.1.3
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
}
