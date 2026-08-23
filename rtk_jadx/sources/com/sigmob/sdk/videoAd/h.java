package com.sigmob.sdk.videoAd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.umeng.analytics.pro.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h implements h.b, e.a, k.a {
    private o b;

    /* renamed from: c, reason: collision with root package name */
    private int f654c;
    private AdStatus d;
    private List<BaseAdUnit> e;
    private BaseAdUnit f;
    private long g;
    private LoadAdRequest h;
    private String j;
    private k k;
    private q l;
    private p m;
    private boolean p;
    private final int i = o.a.p;
    private String n = null;
    private String o = null;
    private final Handler a = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.videoAd.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 8193 && h.this.d == AdStatus.AdStatusLoading) {
                h.this.a.removeMessages(o.a.p);
                h.this.c(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
            }
        }
    };

    public h(boolean z) {
        this.p = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit baseAdUnit, String str, final int i, final String str2, final String str3, WindAdError windAdError) {
        ae.a(str, windAdError, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.videoAd.h.8
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
                    pointEntitySigmobError.setLoad_id(str3);
                    pointEntitySigmobError.setPlacement_id(str2);
                    pointEntitySigmobError.setAdtype(String.valueOf(i));
                }
            }
        });
    }

    private void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.rewardVideoAd.a aVar, e.a aVar2) {
        String placementId = loadAdRequest.getPlacementId();
        h();
        loadAdRequest.setRequest_scene_type(aVar.a().intValue());
        if (aVar != com.sigmob.sdk.rewardVideoAd.a.NormalRequest) {
            ae.a(PointCategory.REQUEST, PointCategory.PLAY, (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, new ae.a() { // from class: com.sigmob.sdk.videoAd.h.3
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setAdx_id(null);
                    }
                }
            });
        }
        loadAdRequest.setExpired(e());
        com.sigmob.sdk.base.network.e.a(loadAdRequest, aVar2);
        SigmobLog.d("adsRequest loadAdRequest = [" + loadAdRequest + "], placementId = [" + placementId + "]");
    }

    private void a(WindAdError windAdError) {
        if (this.d != AdStatus.AdStatusLoading) {
            h();
            this.d = AdStatus.AdStatusNone;
        }
        q qVar = this.l;
        if (qVar == null || windAdError == null) {
            return;
        }
        qVar.onAdShowError(windAdError, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LoadAdRequest loadAdRequest) {
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.AutoNextPreload, new e.a() { // from class: com.sigmob.sdk.videoAd.h.7
            @Override // com.sigmob.sdk.base.network.e.a
            public void a(int i, String str, String str2, LoadAdRequest loadAdRequest2) {
                ae.a(PointCategory.RESPOND, "0", loadAdRequest2);
                ae.a(PointCategory.RESPOND, "0", i, str, loadAdRequest2);
            }

            @Override // com.sigmob.sdk.base.network.e.a
            public void a(final List<BaseAdUnit> list, LoadAdRequest loadAdRequest2) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                BaseAdUnit baseAdUnit = list.get(0);
                h.this.e = list;
                h.this.o = baseAdUnit.getRequestId();
                ae.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest2, new ae.a() { // from class: com.sigmob.sdk.videoAd.h.7.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ad_count", String.valueOf(list.size()));
                            ((PointEntitySigmob) obj).setOptions(hashMap);
                        }
                    }
                });
                if (!h.this.k.a(baseAdUnit)) {
                    h.this.c(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                    return;
                }
                if (baseAdUnit.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
                    com.sigmob.sdk.base.common.h.g().f(baseAdUnit);
                }
                if (baseAdUnit.getPlayMode() != 0) {
                    h.this.g = baseAdUnit.getCreate_time();
                }
                com.sigmob.sdk.base.common.h.a(list);
                h.b bVar = new h.b() { // from class: com.sigmob.sdk.videoAd.h.7.2
                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit2) {
                        ae.a(PointCategory.LOADSTART, (String) null, baseAdUnit2, (WindAdRequest) null, h.this.h, (ae.a) null);
                        com.sigmob.sdk.base.network.g.a(baseAdUnit2, "load");
                    }

                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit2, String str) {
                        com.sigmob.sdk.base.network.g.a(baseAdUnit2, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
                        h.this.a.removeMessages(o.a.p);
                        ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit2, (WindAdRequest) null, h.this.h, (ae.a) null);
                        if (baseAdUnit2 == null || baseAdUnit2.getPlayMode() != 0) {
                            return;
                        }
                        if (TextUtils.isEmpty(str)) {
                            h.this.g = baseAdUnit2.getCreate_time();
                            return;
                        }
                        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
                        windAdError.setMessage(str);
                        h.this.a(baseAdUnit2, "load", baseAdUnit2.getAd_type(), baseAdUnit2.getAdslot_id(), baseAdUnit2.getLoad_id(), windAdError);
                        h.this.h();
                    }
                };
                if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.a()) {
                    if (new com.sigmob.sdk.base.common.e(list, bVar, h.this.h).a(false)) {
                        h.this.k.a(new HashMap(), baseAdUnit);
                        return;
                    }
                    return;
                }
                if (baseAdUnit.getPlayMode() != 2) {
                    h.this.k.a(new HashMap(), baseAdUnit);
                    com.sigmob.sdk.base.common.h.g().a(baseAdUnit, bVar);
                }
            }
        });
    }

    private void b(WindAdError windAdError) {
        o oVar;
        if (this.d == AdStatus.AdStatusLoading && (oVar = this.b) != null) {
            oVar.onAdPreLoadFail(windAdError, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WindAdError windAdError) {
        if (this.d != AdStatus.AdStatusLoading) {
            return;
        }
        if (windAdError == null) {
            this.d = AdStatus.AdStatusReady;
            List<BaseAdUnit> list = this.e;
            if (list != null && list.size() > 0) {
                ae.a(PointCategory.READY, (String) null, this.e.get(0), this.h, (ae.a) null);
            }
        } else {
            this.d = AdStatus.AdStatusNone;
        }
        o oVar = this.b;
        if (oVar != null) {
            if (windAdError != null) {
                oVar.onAdLoadError(windAdError, this.j);
            } else {
                oVar.onAdLoadSuccess(this.j);
            }
        }
    }

    private boolean e() {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        return (this.g == 0 || (list = this.e) == null || list.isEmpty() || (baseAdUnit = this.e.get(0)) == null || !baseAdUnit.isExpiredAd()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.sigmob.sdk.videoAd.k f() {
        /*
            r5 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.czhj.sdk.common.models.AdStatus r1 = r5.d
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusPlaying
            r3 = 0
            r4 = 0
            if (r1 != r2) goto L14
            com.sigmob.windad.WindAdError r1 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_HAS_PLAYING
            java.lang.String r1 = r1.getMessage()
        L10:
            r0.setMessage(r1)
            goto L5c
        L14:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.e
            if (r1 == 0) goto L59
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L1f
            goto L59
        L1f:
            com.czhj.sdk.common.models.AdStatus r1 = r5.d
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r1 == r2) goto L28
            java.lang.String r1 = "ad status is not ready"
            goto L10
        L28:
            com.sigmob.sdk.videoAd.k r1 = r5.k
            if (r1 != 0) goto L2f
            java.lang.String r1 = "interstitial object is null"
            goto L10
        L2f:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.e
            java.lang.Object r1 = r1.get(r4)
            com.sigmob.sdk.base.models.BaseAdUnit r1 = (com.sigmob.sdk.base.models.BaseAdUnit) r1
            boolean r2 = r5.e()
            if (r2 == 0) goto L43
            java.lang.String r2 = "ad unit is expired"
        L3f:
            r0.setMessage(r2)
            goto L5d
        L43:
            boolean r2 = r5.j(r1)
            if (r2 != 0) goto L4c
            java.lang.String r2 = "check ad unit endcard is invalid"
            goto L3f
        L4c:
            com.sigmob.sdk.videoAd.k r2 = r5.k
            boolean r2 = r2.a(r1)
            if (r2 != 0) goto L57
            java.lang.String r2 = "check ad unit info is invalid"
            goto L3f
        L57:
            r4 = 1
            goto L5d
        L59:
            java.lang.String r1 = "not ready adUnit"
            goto L10
        L5c:
            r1 = r3
        L5d:
            if (r4 != 0) goto L6a
            r5.a(r0)
            com.sigmob.sdk.base.models.LoadAdRequest r2 = r5.h
            java.lang.String r4 = "play"
            com.sigmob.sdk.base.common.ae.a(r4, r0, r1, r2)
            return r3
        L6a:
            com.sigmob.sdk.videoAd.k r0 = r5.k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.h.f():com.sigmob.sdk.videoAd.k");
    }

    private void g() {
        o oVar;
        if (this.d == AdStatus.AdStatusLoading && (oVar = this.b) != null) {
            oVar.onAdPreLoadSuccess(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<BaseAdUnit> list = this.e;
        if (list != null && list.size() > 0) {
            for (BaseAdUnit baseAdUnit : this.e) {
                if (baseAdUnit != null) {
                    if (baseAdUnit.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
                        com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
                    }
                    com.sigmob.sdk.base.common.h.b(baseAdUnit);
                }
            }
        }
        this.e = null;
    }

    private boolean j(BaseAdUnit baseAdUnit) {
        try {
            if (baseAdUnit.getPlayMode() != 0) {
                return true;
            }
            boolean isEndCardIndexExist = baseAdUnit.isEndCardIndexExist();
            if (!isEndCardIndexExist) {
                SigmobLog.e("endIndex file not ready");
            }
            return isEndCardIndexExist;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void k(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            String rvCallBackUrl = baseAdUnit.getRvCallBackUrl();
            if (!TextUtils.isEmpty(rvCallBackUrl)) {
                AdTracker adTracker = new AdTracker(AdTracker.MessageType.TRACKING_URL, rvCallBackUrl, "reward_server", baseAdUnit.getRequestId());
                adTracker.setRetryNum(Integer.valueOf(baseAdUnit.getTrackingRetryNum()));
                com.sigmob.sdk.base.network.g.a(adTracker, baseAdUnit, false, true, true, new TrackManager.Listener() { // from class: com.sigmob.sdk.videoAd.h.6
                    public void onErrorResponse(AdTracker adTracker2, VolleyError volleyError) {
                        if (h.this.f654c == 1) {
                            h.this.f654c = 2;
                            if (h.this.m != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(WindAds.TRANS_ID, h.this.n);
                                hashMap.put(WindAds.SERVER_ARRIVED, "0");
                                hashMap.put(WindAds.REWARD_TYPE, "1");
                                h.this.m.onVideoAdRewarded(new WindRewardInfo(true, hashMap), h.this.j);
                            }
                        }
                    }

                    public void onSuccess(AdTracker adTracker2, NetworkResponse networkResponse) {
                        if (h.this.f654c == 1) {
                            h.this.f654c = 2;
                            if (h.this.m != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(WindAds.TRANS_ID, h.this.n);
                                hashMap.put(WindAds.SERVER_ARRIVED, "1");
                                hashMap.put(WindAds.REWARD_TYPE, "1");
                                h.this.m.onVideoAdRewarded(new WindRewardInfo(true, hashMap), h.this.j);
                            }
                        }
                    }
                });
                return;
            }
        }
        this.f654c = 2;
        if (this.m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(WindAds.TRANS_ID, this.n);
            hashMap.put(WindAds.SERVER_ARRIVED, "0");
            hashMap.put(WindAds.REWARD_TYPE, "0");
            this.m.onVideoAdRewarded(new WindRewardInfo(true, hashMap), this.j);
        }
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        ae.a(PointCategory.RESPOND, "0", loadAdRequest);
        ae.a(PointCategory.RESPOND, "0", i, str, loadAdRequest);
        WindAdError windAdError = WindAdError.getWindAdError(i);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i, str);
        }
        b(windAdError);
        c(windAdError);
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, this.h, (ae.a) null);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "load");
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("onInterstitialLoaded() called");
        com.sigmob.sdk.base.network.g.a(baseAdUnit, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
        this.a.removeMessages(o.a.p);
        ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.h, (ae.a) null);
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.g = baseAdUnit.getCreate_time();
            c((WindAdError) null);
            return;
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
        c(windAdError);
        h();
    }

    public void a(LoadAdRequest loadAdRequest) {
        WindAdError sigMobError;
        this.d = AdStatus.AdStatusLoading;
        if (loadAdRequest == null || TextUtils.isEmpty(loadAdRequest.getPlacementId())) {
            SigmobLog.e("loadAd error loadAdRequest or placementId is null");
            c(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY);
            return;
        }
        try {
            if (Sigmob.getInstance() != null && (sigMobError = Sigmob.getInstance().getSigMobError()) != null) {
                SigmobLog.e("check loadAd error " + sigMobError.toString());
                PointEntitySigmobError.SigmobError("load", sigMobError.getErrorCode(), sigMobError.getMessage()).commit();
                c(sigMobError);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
            h();
        }
        this.j = loadAdRequest.getPlacementId();
        this.h = loadAdRequest;
        if (this.k == null) {
            this.k = new k(this, this.p);
        }
        if (a()) {
            this.k.a((Map<String, Object>) null, this.e.get(0));
            SigmobLog.d("adsRequest isReady  placementId = [" + this.j + "]");
            g();
            c((WindAdError) null);
            return;
        }
        if (!TextUtils.isEmpty(this.n)) {
            com.sigmob.sdk.base.common.h.b(this.n);
        }
        if (!TextUtils.isEmpty(this.o)) {
            com.sigmob.sdk.base.common.h.b(this.o);
        }
        loadAdRequest.setLastCampid(com.sigmob.sdk.base.common.h.g().o());
        loadAdRequest.setLastCrid(com.sigmob.sdk.base.common.h.g().n());
        this.a.sendEmptyMessageDelayed(o.a.p, com.sigmob.sdk.base.l.a().t());
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.NormalRequest, this);
    }

    public void a(LoadAdRequest loadAdRequest, q qVar) {
        this.l = qVar;
        this.h = loadAdRequest;
        k f = f();
        if (f == null) {
            return;
        }
        BaseAdUnit baseAdUnit = this.e.get(0);
        this.f = baseAdUnit;
        this.n = baseAdUnit.getRequestId();
        this.f.setLoad_id(this.h.getLoadId());
        this.f.setBid_token(this.h.getBidToken());
        this.f.setAd_scene_id(this.h.getAdSceneId());
        this.f.setAd_scene_desc(this.h.getAdSceneDesc());
        SigMacroCommon macroCommon = this.f.getMacroCommon();
        if (macroCommon instanceof SigMacroCommon) {
            if (!TextUtils.isEmpty(this.h.getAdSceneDesc())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, this.h.getAdSceneDesc());
            }
            if (!TextUtils.isEmpty(this.h.getAdSceneId())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, this.h.getAdSceneId());
            }
            if (!TextUtils.isEmpty(this.f.getVideo_url())) {
                macroCommon.addMarcoKey(SigMacroCommon._VMD5_, com.sigmob.sdk.base.common.h.g().k(this.f.getVideoPath()));
                try {
                    macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(this.f.getVideo_url(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    SigmobLog.e(e.getMessage());
                }
            }
        }
        if (this.f.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.a()) {
            if (!new com.sigmob.sdk.base.common.e(this.e, this, this.h).a(true)) {
                f.a(new HashMap(), this.f);
            }
        } else if (this.f.getPlayMode() == 2) {
            f.a(new HashMap(), this.f);
            com.sigmob.sdk.base.common.h.g().a(this.f, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.sigmob.sdk.base.k.u, this.h.isEnable_keep_on() || com.sigmob.sdk.base.l.a().i());
        bundle.putBoolean(com.sigmob.sdk.base.k.t, this.h.isEnable_screen_lock_displayad() || com.sigmob.sdk.base.l.a().h());
        f.a(this.f, bundle);
        this.g = 0L;
        this.d = AdStatus.AdStatusPlaying;
    }

    public void a(o oVar) {
        this.b = oVar;
    }

    public void a(p pVar) {
        this.m = pVar;
    }

    public void a(String str, String str2) {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        AdStatus adStatus = this.d;
        if (adStatus == AdStatus.AdStatusPlaying) {
            baseAdUnit = this.f;
            if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
                return;
            }
        } else if (adStatus != AdStatus.AdStatusReady || (list = this.e) == null || list.size() <= 0 || (baseAdUnit = this.e.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public void a(String str, final Map<String, String> map) {
        if (com.sigmob.sdk.base.l.a().aa()) {
            ae.a(str, (String) null, this.f, new ae.a() { // from class: com.sigmob.sdk.videoAd.h.2
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                        if (map != null) {
                            pointEntitySigmob.getOptions().putAll(map);
                        }
                    }
                }
            });
        }
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(final List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    BaseAdUnit baseAdUnit = list.get(0);
                    this.e = list;
                    this.n = baseAdUnit.getRequestId();
                    ae.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new ae.a() { // from class: com.sigmob.sdk.videoAd.h.4
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("ad_count", String.valueOf(list.size()));
                                ((PointEntitySigmob) obj).setOptions(hashMap);
                            }
                        }
                    });
                    if (this.k == null) {
                        this.k = new k(this, this.p);
                    }
                    if (!this.k.a(baseAdUnit)) {
                        c(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                        return;
                    }
                    g();
                    com.sigmob.sdk.base.common.h.a(list);
                    for (BaseAdUnit baseAdUnit2 : this.e) {
                        if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
                            com.sigmob.sdk.base.common.h.g().f(baseAdUnit2);
                        }
                    }
                    if (baseAdUnit.getPlayMode() != 0) {
                        this.g = baseAdUnit.getCreate_time();
                        c((WindAdError) null);
                    }
                    if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.a()) {
                        if (new com.sigmob.sdk.base.common.e(list, this, this.h).a(false)) {
                            this.k.a(new HashMap(), baseAdUnit);
                            return;
                        }
                        return;
                    }
                    if (baseAdUnit.getPlayMode() != 2) {
                        this.k.a(new HashMap(), baseAdUnit);
                        com.sigmob.sdk.base.common.h.g().a(baseAdUnit, this);
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                h();
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                windAdError.setMessage(th.getMessage());
                ae.a(PointCategory.RESPOND, "0", windAdError.getErrorCode(), windAdError.getMessage(), loadAdRequest);
                c(windAdError);
                return;
            }
        }
        WindAdError windAdError2 = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        b(windAdError2);
        ae.a(PointCategory.RESPOND, "0", windAdError2.getErrorCode(), windAdError2.getMessage(), loadAdRequest);
        c(windAdError2);
    }

    public boolean a() {
        List<BaseAdUnit> list = this.e;
        if (list != null && list.size() > 0) {
            BaseAdUnit baseAdUnit = this.e.get(0);
            if (baseAdUnit != null && !e() && j(baseAdUnit) && this.k != null && com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid()) != null && this.k.a(baseAdUnit)) {
                return true;
            }
            if (baseAdUnit != null) {
                com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
            }
        }
        return false;
    }

    public void b() {
        if (!TextUtils.isEmpty(this.n)) {
            com.sigmob.sdk.base.common.h.b(this.n);
        }
        if (!TextUtils.isEmpty(this.o)) {
            com.sigmob.sdk.base.common.h.b(this.o);
        }
        h();
        this.l = null;
        this.b = null;
        this.m = null;
        this.f = null;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialShown() called");
        this.f654c = 0;
        h();
        q qVar = this.l;
        if (qVar != null) {
            qVar.onAdShow(this.j);
        }
        if (baseAdUnit == null || baseAdUnit.getDisableAutoLoad() || !TextUtils.isEmpty(this.h.getBidToken()) || baseAdUnit.bidding_response != null) {
            return;
        }
        SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onInterstitialShown: " + this.h.getBidToken());
        if (baseAdUnit.getPlayMode() == 0 && TextUtils.isEmpty(this.h.getBidToken())) {
            this.h.setLastCampid(baseAdUnit.getCamp_id());
            this.h.setLastCrid(baseAdUnit.getCrid());
            this.a.post(new Runnable() { // from class: com.sigmob.sdk.videoAd.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h hVar = h.this;
                    hVar.b(hVar.h);
                }
            });
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        this.a.removeMessages(o.a.p);
        SigmobLog.d("onInterstitialFailed() called with: errorCode = [" + str + "]");
        ae.a(PointCategory.LOADEND, "0", baseAdUnit, (WindAdRequest) null, this.h, (ae.a) null);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.C);
        h();
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
        c(windAdError);
    }

    public String c() {
        List<BaseAdUnit> list;
        BiddingResponse biddingResponse;
        AdStatus adStatus = this.d;
        if (adStatus == AdStatus.AdStatusPlaying) {
            BaseAdUnit baseAdUnit = this.f;
            if (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
                return null;
            }
        } else {
            if (adStatus != AdStatus.AdStatusReady || (list = this.e) == null || list.size() <= 0 || this.e.get(0) == null || this.e.get(0).bidding_response == null) {
                return null;
            }
            biddingResponse = this.e.get(0).bidding_response;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void c(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialClicked() called");
        q qVar = this.l;
        if (qVar != null) {
            qVar.onAdClicked(this.j);
        }
    }

    @Override // com.sigmob.sdk.videoAd.k.a
    public void c(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
            com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        a(windAdError);
        a(baseAdUnit, PointCategory.PLAY, this.h.getAdType(), this.j, this.h.getLoadId(), windAdError);
        SigmobLog.d("onVideoPlayFail() called");
    }

    public Map<String, BiddingResponse> d() {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        AdStatus adStatus = this.d;
        if (adStatus == AdStatus.AdStatusPlaying) {
            BaseAdUnit baseAdUnit2 = this.f;
            if (baseAdUnit2 == null || baseAdUnit2.bidding_response == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(this.f.getRequestId(), this.f.bidding_response);
            return hashMap;
        }
        if (adStatus != AdStatus.AdStatusReady || (list = this.e) == null || list.size() <= 0 || (baseAdUnit = this.e.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap2;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialDismissed() called");
        AdStatus adStatus = this.d;
        AdStatus adStatus2 = AdStatus.AdStatusClose;
        if (adStatus == adStatus2) {
            return;
        }
        this.d = adStatus2;
        k kVar = this.k;
        if (kVar != null) {
            kVar.b(baseAdUnit);
        }
        if (this.f654c == 1) {
            this.f654c = 0;
            if (this.m != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(WindAds.TRANS_ID, this.n);
                hashMap.put(WindAds.SERVER_ARRIVED, "0");
                hashMap.put(WindAds.REWARD_TYPE, "1");
                this.m.onVideoAdRewarded(new WindRewardInfo(true, hashMap), this.j);
            }
        }
        q qVar = this.l;
        if (qVar != null) {
            qVar.onAdClosed(this.j);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void e(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            com.sigmob.sdk.base.common.h.g().j(baseAdUnit.getCamp_id());
            com.sigmob.sdk.base.common.h.g().i(baseAdUnit.getCrid());
            h();
        }
    }

    @Override // com.sigmob.sdk.videoAd.k.a
    public void f(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoComplete() called");
        this.f654c = 1;
        q qVar = this.l;
        if (qVar != null) {
            qVar.onVideoAdPlayComplete(this.j);
        }
        k(baseAdUnit);
    }

    @Override // com.sigmob.sdk.videoAd.k.a
    public void g(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoPlay() called");
    }

    @Override // com.sigmob.sdk.videoAd.k.a
    public void h(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.videoAd.k.a
    public void i(BaseAdUnit baseAdUnit) {
        q qVar = this.l;
        if (qVar != null) {
            qVar.onVideoAdPlayEnd(this.j);
        }
        if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.h.getBidToken()) && baseAdUnit.bidding_response == null) {
            SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onVideoClose: " + this.h.getBidToken());
            if (baseAdUnit.getPlayMode() == 0 || !TextUtils.isEmpty(this.h.getBidToken())) {
                return;
            }
            this.h.setLastCampid(baseAdUnit.getCamp_id());
            this.h.setLastCrid(baseAdUnit.getCrid());
            b(this.h);
        }
    }
}
