package com.sigmob.sdk.newInterstitial;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.newInterstitial.e;
import com.sigmob.sdk.videoAd.o;
import com.sigmob.sdk.videoAd.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.umeng.analytics.pro.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements h.b, e.a, e.a {
    private o b;

    /* renamed from: c, reason: collision with root package name */
    private AdStatus f628c;
    private List<BaseAdUnit> d;
    private BaseAdUnit e;
    private long f;
    private LoadAdRequest g;
    private String i;
    private e j;
    private q k;
    private String l;
    private String m;
    private final int h = o.a.p;
    private final Handler a = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.newInterstitial.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 8193 && a.this.f628c == AdStatus.AdStatusLoading) {
                a.this.a.removeMessages(o.a.p);
                a.this.c(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit baseAdUnit, String str, final int i, final String str2, final String str3, WindAdError windAdError) {
        ae.a(str, windAdError, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.a.7
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
        loadAdRequest.setRequest_scene_type(aVar.a().intValue());
        if (aVar != com.sigmob.sdk.rewardVideoAd.a.NormalRequest) {
            ae.a(PointCategory.REQUEST, PointCategory.PLAY, (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.a.3
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setAdx_id(null);
                    }
                }
            });
        }
        loadAdRequest.setExpired(e());
        h();
        com.sigmob.sdk.base.network.e.a(loadAdRequest, aVar2);
    }

    private void a(WindAdError windAdError) {
        if (this.f628c != AdStatus.AdStatusLoading) {
            h();
            this.f628c = AdStatus.AdStatusNone;
        }
        q qVar = this.k;
        if (qVar == null || windAdError == null) {
            return;
        }
        qVar.onAdShowError(windAdError, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LoadAdRequest loadAdRequest) {
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.AutoNextPreload, new e.a() { // from class: com.sigmob.sdk.newInterstitial.a.6
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
                a.this.l = baseAdUnit.getRequestId();
                a.this.d = list;
                ae.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest2, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.a.6.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ad_count", String.valueOf(list.size()));
                            ((PointEntitySigmob) obj).setOptions(hashMap);
                        }
                    }
                });
                if (!a.this.j.a(baseAdUnit)) {
                    a.this.c(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                    return;
                }
                for (BaseAdUnit baseAdUnit2 : a.this.d) {
                    if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase(k.i)) {
                        com.sigmob.sdk.base.common.h.g().f(baseAdUnit2);
                    }
                }
                if (baseAdUnit.getPlayMode() != 0) {
                    a.this.f = baseAdUnit.getCreate_time();
                }
                com.sigmob.sdk.base.common.h.a(list);
                h.b bVar = new h.b() { // from class: com.sigmob.sdk.newInterstitial.a.6.2
                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit3) {
                        ae.a(PointCategory.LOADSTART, (String) null, baseAdUnit3, (WindAdRequest) null, a.this.g, (ae.a) null);
                        com.sigmob.sdk.base.network.g.a(baseAdUnit3, "load");
                    }

                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit3, String str) {
                        com.sigmob.sdk.base.network.g.a(baseAdUnit3, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
                        a.this.a.removeMessages(o.a.p);
                        ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit3, (WindAdRequest) null, a.this.g, (ae.a) null);
                        if (baseAdUnit3 == null || baseAdUnit3.getPlayMode() != 0) {
                            return;
                        }
                        if (TextUtils.isEmpty(str)) {
                            a.this.f = baseAdUnit3.getCreate_time();
                            return;
                        }
                        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
                        windAdError.setMessage(str);
                        a.this.a(baseAdUnit3, "load", baseAdUnit3.getAd_type(), baseAdUnit3.getAdslot_id(), baseAdUnit3.getLoad_id(), windAdError);
                        a.this.h();
                    }
                };
                if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.a()) {
                    if (new com.sigmob.sdk.base.common.e(list, bVar, a.this.g).a(false)) {
                        a.this.j.a(new HashMap(), baseAdUnit);
                        return;
                    }
                    return;
                }
                if (baseAdUnit.getPlayMode() != 2) {
                    a.this.j.a(new HashMap(), baseAdUnit);
                    com.sigmob.sdk.base.common.h.g().a(baseAdUnit, bVar);
                }
            }
        });
    }

    private void b(WindAdError windAdError) {
        com.sigmob.sdk.videoAd.o oVar;
        if (this.f628c == AdStatus.AdStatusLoading && (oVar = this.b) != null) {
            oVar.onAdPreLoadFail(windAdError, this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WindAdError windAdError) {
        if (this.f628c != AdStatus.AdStatusLoading) {
            return;
        }
        if (windAdError == null) {
            this.f628c = AdStatus.AdStatusReady;
            List<BaseAdUnit> list = this.d;
            if (list != null && list.size() > 0) {
                ae.a(PointCategory.READY, (String) null, this.d.get(0), this.g, (ae.a) null);
            }
        } else {
            this.f628c = AdStatus.AdStatusNone;
        }
        com.sigmob.sdk.videoAd.o oVar = this.b;
        if (oVar != null) {
            if (windAdError != null) {
                oVar.onAdLoadError(windAdError, this.i);
            } else {
                oVar.onAdLoadSuccess(this.i);
            }
        }
    }

    private boolean e() {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        return (this.f == 0 || (list = this.d) == null || list.isEmpty() || (baseAdUnit = this.d.get(0)) == null || !baseAdUnit.isExpiredAd()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.sigmob.sdk.newInterstitial.e f() {
        /*
            r5 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.czhj.sdk.common.models.AdStatus r1 = r5.f628c
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
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.d
            if (r1 == 0) goto L59
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L1f
            goto L59
        L1f:
            com.czhj.sdk.common.models.AdStatus r1 = r5.f628c
            com.czhj.sdk.common.models.AdStatus r2 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r1 == r2) goto L28
            java.lang.String r1 = "ad status is not ready"
            goto L10
        L28:
            com.sigmob.sdk.newInterstitial.e r1 = r5.j
            if (r1 != 0) goto L2f
            java.lang.String r1 = "interstitial object is null"
            goto L10
        L2f:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r1 = r5.d
            java.lang.Object r1 = r1.get(r4)
            com.sigmob.sdk.base.models.BaseAdUnit r1 = (com.sigmob.sdk.base.models.BaseAdUnit) r1
            boolean r2 = r5.e()
            if (r2 == 0) goto L43
            java.lang.String r2 = "ad unit is expired"
        L3f:
            r0.setMessage(r2)
            goto L5d
        L43:
            boolean r2 = r5.i(r1)
            if (r2 != 0) goto L4c
            java.lang.String r2 = "check ad unit endcard is invalid"
            goto L3f
        L4c:
            com.sigmob.sdk.newInterstitial.e r2 = r5.j
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
            com.sigmob.sdk.base.models.LoadAdRequest r2 = r5.g
            java.lang.String r4 = "play"
            com.sigmob.sdk.base.common.ae.a(r4, r0, r1, r2)
            return r3
        L6a:
            com.sigmob.sdk.newInterstitial.e r0 = r5.j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.newInterstitial.a.f():com.sigmob.sdk.newInterstitial.e");
    }

    private void g() {
        com.sigmob.sdk.videoAd.o oVar;
        if (this.f628c == AdStatus.AdStatusLoading && (oVar = this.b) != null) {
            oVar.onAdPreLoadSuccess(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.d;
        if (list != null && list.size() > 0 && (baseAdUnit = this.d.get(0)) != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase(k.i)) {
            com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
        }
        this.d = null;
    }

    private boolean i(BaseAdUnit baseAdUnit) {
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
        ae.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, this.g, (ae.a) null);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "load");
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("onInterstitialLoaded() called");
        com.sigmob.sdk.base.network.g.a(baseAdUnit, TextUtils.isEmpty(str) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
        this.a.removeMessages(o.a.p);
        ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.g, (ae.a) null);
        if (baseAdUnit == null || baseAdUnit.getPlayMode() != 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f = baseAdUnit.getCreate_time();
            c((WindAdError) null);
            return;
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
        c(windAdError);
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoadAdRequest loadAdRequest) {
        WindAdError sigMobError;
        this.f628c = AdStatus.AdStatusLoading;
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
        this.i = loadAdRequest.getPlacementId();
        this.g = loadAdRequest;
        if (this.j == null) {
            this.j = new e(this) { // from class: com.sigmob.sdk.newInterstitial.a.2
            };
        }
        if (a()) {
            this.j.a((Map<String, Object>) null, this.d.get(0));
            SigmobLog.d("adsRequest isReady  placementId = [" + this.i + "]");
            g();
            c((WindAdError) null);
            return;
        }
        if (!TextUtils.isEmpty(this.m)) {
            com.sigmob.sdk.base.common.h.b(this.m);
        }
        if (!TextUtils.isEmpty(this.l)) {
            com.sigmob.sdk.base.common.h.b(this.l);
        }
        loadAdRequest.setLastCampid(com.sigmob.sdk.base.common.h.g().o());
        loadAdRequest.setLastCrid(com.sigmob.sdk.base.common.h.g().n());
        this.a.sendEmptyMessageDelayed(o.a.p, l.a().t());
        a(loadAdRequest, com.sigmob.sdk.rewardVideoAd.a.NormalRequest, this);
    }

    public void a(LoadAdRequest loadAdRequest, q qVar) {
        this.k = qVar;
        this.g = loadAdRequest;
        e f = f();
        if (f == null) {
            return;
        }
        BaseAdUnit baseAdUnit = this.d.get(0);
        this.e = baseAdUnit;
        this.m = baseAdUnit.getRequestId();
        this.e.setLoad_id(this.g.getLoadId());
        this.e.setBid_token(this.g.getBidToken());
        this.e.setAd_scene_id(this.g.getAdSceneId());
        this.e.setAd_scene_desc(this.g.getAdSceneDesc());
        SigMacroCommon macroCommon = this.e.getMacroCommon();
        if (macroCommon instanceof SigMacroCommon) {
            if (!TextUtils.isEmpty(this.g.getAdSceneDesc())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, this.g.getAdSceneDesc());
            }
            if (!TextUtils.isEmpty(this.g.getAdSceneId())) {
                macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, this.g.getAdSceneId());
            }
            if (!TextUtils.isEmpty(this.e.getVideo_url())) {
                macroCommon.addMarcoKey(SigMacroCommon._VMD5_, com.sigmob.sdk.base.common.h.g().k(this.e.getVideoPath()));
                try {
                    macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(this.e.getVideo_url(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    SigmobLog.e(e.getMessage());
                }
            }
        }
        if (this.e.getCreativeType() == m.CreativeTypeMRAIDTWO.a()) {
            if (!new com.sigmob.sdk.base.common.e(this.d, this, this.g).a(true)) {
                f.a(new HashMap(), this.e);
            }
        } else if (this.e.getPlayMode() == 2) {
            f.a(new HashMap(), this.e);
            com.sigmob.sdk.base.common.h.g().a(this.e, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(k.u, this.g.isEnable_keep_on() || l.a().i());
        bundle.putBoolean(k.t, this.g.isEnable_screen_lock_displayad() || l.a().h());
        f.a(this.e, bundle);
        this.f628c = AdStatus.AdStatusPlaying;
        this.f = 0L;
    }

    public void a(com.sigmob.sdk.videoAd.o oVar) {
        this.b = oVar;
    }

    public void a(String str, String str2) {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        AdStatus adStatus = this.f628c;
        if (adStatus == AdStatus.AdStatusPlaying) {
            baseAdUnit = this.e;
            if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
                return;
            }
        } else if (adStatus != AdStatus.AdStatusReady || (list = this.d) == null || list.size() <= 0 || (baseAdUnit = this.d.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public void a(String str, final Map<String, String> map) {
        if (l.a().aa()) {
            ae.a(str, (String) null, this.e, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.a.8
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
                    this.m = baseAdUnit.getRequestId();
                    this.d = list;
                    ae.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.a.4
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("ad_count", String.valueOf(list.size()));
                                ((PointEntitySigmob) obj).setOptions(hashMap);
                            }
                        }
                    });
                    if (this.j == null) {
                        this.j = new e(this);
                    }
                    if (!this.j.a(baseAdUnit)) {
                        c(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                        return;
                    }
                    g();
                    com.sigmob.sdk.base.common.h.a(list);
                    for (BaseAdUnit baseAdUnit2 : this.d) {
                        if (baseAdUnit2.getAd_source_channel().equalsIgnoreCase(k.i)) {
                            com.sigmob.sdk.base.common.h.g().f(baseAdUnit2);
                        }
                    }
                    if (baseAdUnit.getPlayMode() != 0) {
                        this.f = baseAdUnit.getCreate_time();
                        c((WindAdError) null);
                    }
                    if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.a()) {
                        if (new com.sigmob.sdk.base.common.e(list, this, this.g).a(false)) {
                            this.j.a(new HashMap(), baseAdUnit);
                            return;
                        }
                        return;
                    }
                    if (baseAdUnit.getPlayMode() != 2) {
                        this.j.a(new HashMap(), baseAdUnit);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        List<BaseAdUnit> list = this.d;
        if (list != null && list.size() > 0) {
            BaseAdUnit baseAdUnit = this.d.get(0);
            if (baseAdUnit != null && !e() && i(baseAdUnit) && this.j != null && com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid()) != null && this.j.a(baseAdUnit)) {
                return true;
            }
            if (baseAdUnit != null) {
                com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
            }
        }
        return false;
    }

    public void b() {
        if (!TextUtils.isEmpty(this.m)) {
            com.sigmob.sdk.base.common.h.b(this.m);
        }
        if (!TextUtils.isEmpty(this.l)) {
            com.sigmob.sdk.base.common.h.b(this.l);
        }
        h();
        this.b = null;
        this.k = null;
        this.e = null;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialShown() called");
        h();
        if (baseAdUnit != null) {
            q qVar = this.k;
            if (qVar != null) {
                qVar.onAdShow(this.i);
            }
            if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.g.getBidToken()) && baseAdUnit.bidding_response == null) {
                SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onInterstitialShown: " + this.g.getBidToken());
                if (baseAdUnit.getPlayMode() == 0 && TextUtils.isEmpty(this.g.getBidToken())) {
                    this.g.setLastCampid(baseAdUnit.getCamp_id());
                    this.g.setLastCrid(baseAdUnit.getCrid());
                    this.a.post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.a.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar = a.this;
                            aVar.b(aVar.g);
                        }
                    });
                }
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        this.a.removeMessages(o.a.p);
        SigmobLog.d("onInterstitialFailed() called with: errorCode = [" + str + "]");
        ae.a(PointCategory.LOADEND, "0", baseAdUnit, (WindAdRequest) null, this.g, (ae.a) null);
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
        AdStatus adStatus = this.f628c;
        if (adStatus == AdStatus.AdStatusPlaying) {
            BaseAdUnit baseAdUnit = this.e;
            if (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
                return null;
            }
        } else {
            if (adStatus != AdStatus.AdStatusReady || (list = this.d) == null || list.size() <= 0 || this.d.get(0) == null || this.d.get(0).bidding_response == null) {
                return null;
            }
            biddingResponse = this.d.get(0).bidding_response;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void c(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialClicked() called");
        q qVar = this.k;
        if (qVar != null) {
            qVar.onAdClicked(this.i);
        }
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void c(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != null && baseAdUnit.getAd_source_channel().equalsIgnoreCase(k.i)) {
            com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        a(windAdError);
        a(baseAdUnit, PointCategory.PLAY, this.g.getAdType(), this.i, this.g.getLoadId(), windAdError);
        SigmobLog.d("onAdShowFail() called");
    }

    public Map<String, BiddingResponse> d() {
        List<BaseAdUnit> list;
        BaseAdUnit baseAdUnit;
        AdStatus adStatus = this.f628c;
        if (adStatus == AdStatus.AdStatusPlaying) {
            BaseAdUnit baseAdUnit2 = this.e;
            if (baseAdUnit2 == null || baseAdUnit2.bidding_response == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(this.e.getRequestId(), this.e.bidding_response);
            return hashMap;
        }
        if (adStatus != AdStatus.AdStatusReady || (list = this.d) == null || list.size() <= 0 || (baseAdUnit = this.d.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap2;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onInterstitialDismissed() called");
        AdStatus adStatus = this.f628c;
        AdStatus adStatus2 = AdStatus.AdStatusClose;
        if (adStatus == adStatus2) {
            return;
        }
        this.f628c = adStatus2;
        e eVar = this.j;
        if (eVar != null) {
            eVar.b(baseAdUnit);
        }
        q qVar = this.k;
        if (qVar != null) {
            qVar.onAdClosed(this.i);
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

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void f(BaseAdUnit baseAdUnit) {
        if (this.f628c == AdStatus.AdStatusClose) {
            return;
        }
        q qVar = this.k;
        if (qVar != null) {
            qVar.onVideoAdPlayEnd(this.i);
        }
        if (!baseAdUnit.getDisableAutoLoad() && TextUtils.isEmpty(this.g.getBidToken()) && baseAdUnit.bidding_response == null) {
            SigmobLog.d(baseAdUnit.getPlayMode() + " adsRequest onVideoClose: " + this.g.getBidToken());
            if (baseAdUnit.getPlayMode() == 0 || !TextUtils.isEmpty(this.g.getBidToken())) {
                return;
            }
            this.g.setLastCampid(baseAdUnit.getCamp_id());
            this.g.setLastCrid(baseAdUnit.getCrid());
            b(this.g);
        }
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void g(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void h(BaseAdUnit baseAdUnit) {
    }
}
