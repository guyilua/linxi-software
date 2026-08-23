package com.sigmob.sdk.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.splash.f;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class g implements h.b, e.a, f.a {
    private static final int l = 131073;
    private final LoadAdRequest a;

    /* renamed from: c, reason: collision with root package name */
    private Handler f644c;
    private WindSplashADListener e;
    private int f;
    private i h;
    private BaseAdUnit i;
    private int j = 0;
    private int k = 0;
    private final Runnable b = new Runnable() { // from class: com.sigmob.sdk.splash.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f644c != null) {
                g.this.f644c.removeCallbacksAndMessages(null);
                if (g.this.h == null) {
                    return;
                }
                if (g.this.f <= 0) {
                    g.this.h.setDuration(0);
                    return;
                }
                g.this.h.setDuration(g.this.f);
                g.d(g.this);
                g.this.f644c.postDelayed(g.this.b, 1000L);
            }
        }
    };
    private AdStatus g = AdStatus.AdStatusNone;
    private f d = new f(this);

    public g(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        this.a = new LoadAdRequest(windSplashAdRequest);
        this.e = windSplashADListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindAdError windAdError, boolean z) {
        WindSplashADListener windSplashADListener;
        this.g = AdStatus.AdStatusNone;
        Handler handler = this.f644c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f644c = null;
        }
        if (this.a.getRequest_scene_type() != com.sigmob.sdk.rewardVideoAd.a.SplashCloseRequest.a().intValue() && (windSplashADListener = this.e) != null) {
            if (z) {
                windSplashADListener.onSplashAdLoadFail(windAdError, this.a.getPlacementId());
            } else {
                windSplashADListener.onSplashAdShowError(windAdError, this.a.getPlacementId());
            }
            this.e = null;
        }
        f fVar = this.d;
        if (fVar != null) {
            fVar.b(this.i);
        }
    }

    private boolean a(ViewGroup viewGroup, BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return false;
        }
        i iVar = new i(viewGroup.getContext().getApplicationContext());
        this.h = iVar;
        if (iVar == null) {
            return false;
        }
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (width <= 0 || height <= 0) {
            ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.h.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            if (childMeasureSpec == 0) {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(ClientMetadata.getInstance().getDisplayMetrics().widthPixels, WXVideoFileObject.FILE_SIZE_LIMIT);
            }
            int i = layoutParams.height;
            this.h.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, WXVideoFileObject.FILE_SIZE_LIMIT) : View.MeasureSpec.makeMeasureSpec(0, 0));
            width = this.h.getMeasuredWidth();
            height = this.h.getMeasuredHeight();
        }
        if (width > 0 && height > 0) {
            this.h.setAspectRatio((width * 1.0f) / height);
        }
        this.h.b();
        this.h.setShowAppLogo(this.j != 0);
        return this.h.a(baseAdUnit, com.sigmob.sdk.base.utils.f.d(viewGroup));
    }

    static /* synthetic */ int d(g gVar) {
        int i = gVar.f;
        gVar.f = i - 1;
        return i;
    }

    private Activity m() {
        return com.sigmob.sdk.base.utils.f.c(this.h);
    }

    private void n() {
        ag sessionManager;
        if (this.d != null) {
            BaseAdUnit baseAdUnit = this.i;
            if (baseAdUnit != null && (sessionManager = baseAdUnit.getSessionManager()) != null) {
                sessionManager.a();
            }
            this.d.b(this.i);
        }
        if (this.g == AdStatus.AdStatusPlaying) {
            this.g = AdStatus.AdStatusClose;
            WindSplashADListener windSplashADListener = this.e;
            if (windSplashADListener != null) {
                windSplashADListener.onSplashAdClose(this.a.getPlacementId());
            }
        }
        Handler handler = this.f644c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f644c = null;
        }
        if (this.h != null && !this.a.isDisableAutoHideAd()) {
            com.sigmob.sdk.base.utils.f.a(this.h);
            this.h = null;
        }
        com.sigmob.sdk.base.common.h.b(this.i);
        this.i = null;
        this.e = null;
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void a() {
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        WindAdError windAdError = WindAdError.getWindAdError(i);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i, str);
        }
        ae.a(PointCategory.RESPOND, "0", loadAdRequest);
        ae.a(PointCategory.REQUEST, (String) null, i, str, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.splash.g.4
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setAdx_id(null);
                }
            }
        });
        a(windAdError, true);
    }

    public void a(Activity activity) {
        if (this.h == null || activity != m()) {
            return;
        }
        this.h.d();
        Handler handler = this.f644c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f644c = null;
        }
    }

    public void a(ViewGroup viewGroup) {
        if (!(1 == ClientMetadata.getInstance().getOrientationInt().intValue())) {
            i();
            return;
        }
        if (viewGroup != null) {
            if (!a(viewGroup, this.i)) {
                c();
                return;
            }
            this.d.a(this.i, (Bundle) null);
            int l2 = this.d.f643c.l();
            this.f = l2;
            this.h.setDuration(l2);
            if (this.h.c()) {
                viewGroup.addView(this.h, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
        }
        c();
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d(" loadEnd");
        if (!TextUtils.isEmpty(str)) {
            b(this.i, str);
            return;
        }
        ae.a(PointCategory.READY, (String) null, baseAdUnit, this.a, (ae.a) null);
        if (this.g == AdStatus.AdStatusClose) {
            SigmobLog.d(" next load");
            FileUtil.writeToCache(baseAdUnit, com.sigmob.sdk.base.utils.e.c(this.a.getPlacementId()));
        }
        if (this.g != AdStatus.AdStatusLoading) {
            return;
        }
        if (!(1 == ClientMetadata.getInstance().getOrientationInt().intValue())) {
            i();
            return;
        }
        Handler handler = this.f644c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.g = AdStatus.AdStatusReady;
        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.g.5
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.e != null) {
                    g.this.e.onSplashAdLoadSuccess(g.this.a.getPlacementId());
                }
            }
        });
    }

    public void a(String str, int i, String str2, int i2, boolean z) {
        f fVar;
        if (z) {
            this.a.setRequest_scene_type(com.sigmob.sdk.rewardVideoAd.a.SplashCloseRequest.a().intValue());
            ae.a(PointCategory.REQUEST, PointCategory.PLAY, (BaseAdUnit) null, (WindAdRequest) null, this.a, new ae.a() { // from class: com.sigmob.sdk.splash.g.2
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setAdx_id(null);
                    }
                }
            });
        } else {
            this.g = AdStatus.AdStatusLoading;
            if (g() && (fVar = this.d) != null) {
                fVar.a((Map<String, Object>) null, this.i);
                com.sigmob.sdk.base.common.h.g().a(this.i, this);
                return;
            }
            this.a.setRequest_scene_type(com.sigmob.sdk.rewardVideoAd.a.NormalRequest.a().intValue());
        }
        Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.splash.g.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != g.l) {
                    return;
                }
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_TIMEOUT;
                ae.a(PointCategory.REQUEST, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, g.this.a, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.splash.g.3.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setAdx_id(null);
                        }
                    }
                });
                g.this.a(windAdError, true);
            }
        };
        this.f644c = handler;
        handler.sendEmptyMessageDelayed(l, i2 * 1000);
        this.a.setBidToken(str);
        this.a.setBidFloor(i);
        this.a.setCurrency(str2);
        com.sigmob.sdk.base.network.e.a(this.a, this);
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit = this.i;
        if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        BaseAdUnit baseAdUnit = list.get(0);
        ae.b(PointCategory.RESPOND, "1", baseAdUnit);
        if (!this.d.a(baseAdUnit)) {
            a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE, true);
            return;
        }
        this.i = baseAdUnit;
        f fVar = this.d;
        if (fVar != null) {
            fVar.a((Map<String, Object>) null, baseAdUnit);
        }
        com.sigmob.sdk.base.common.h.g().a(this.i, this);
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void b() {
        BaseBroadcastReceiver.a(com.sigmob.sdk.b.e(), this.i.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
    }

    public void b(Activity activity) {
        if (this.h == null || activity != m()) {
            return;
        }
        this.h.e();
        if (this.f644c == null) {
            this.f644c = new Handler(Looper.getMainLooper());
        }
        this.f644c.post(this.b);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit) {
        this.g = AdStatus.AdStatusPlaying;
        h();
        com.sigmob.sdk.base.common.h.a(baseAdUnit);
        if (this.h.getDuration() > 0 && this.h.getDuration() < this.f) {
            this.f = this.h.getDuration();
        }
        i iVar = this.h;
        if (iVar != null) {
            iVar.setDuration(this.f);
            this.h.setVisibility(0);
        }
        WindSplashADListener windSplashADListener = this.e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdShow(this.a.getPlacementId());
        }
        if (this.f644c == null) {
            this.f644c = new Handler(Looper.getMainLooper());
        }
        this.k = this.f;
        this.f644c.post(this.b);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(windAdError, true);
        ae.a("load", windAdError, this.i);
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void c() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE;
        ae.a(PointCategory.PLAY, windAdError, this.i);
        a(windAdError, false);
        n();
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void c(BaseAdUnit baseAdUnit) {
        WindSplashADListener windSplashADListener = this.e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClick(this.a.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void d() {
        this.h.setDuration(0);
        WindSplashADListener windSplashADListener = this.e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdSkip(this.a.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        this.g = AdStatus.AdStatusClose;
        WindSplashADListener windSplashADListener = this.e;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClose(this.a.getPlacementId());
        }
        n();
        if (TextUtils.isEmpty(this.a.getBidToken()) && baseAdUnit.bidding_response == null) {
            a(null, 0, WindAds.CNY, 45, true);
        }
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void e() {
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void e(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.splash.f.a
    public void f() {
        Handler handler = this.f644c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f644c = null;
        }
    }

    public boolean g() {
        try {
            if (this.i == null) {
                Object readFromCache = FileUtil.readFromCache(com.sigmob.sdk.base.utils.e.c(this.a.getPlacementId()));
                if ((readFromCache instanceof BaseAdUnit) && ((BaseAdUnit) readFromCache).getAd() != null) {
                    FileUtil.deleteFile(com.sigmob.sdk.base.utils.e.c(this.a.getPlacementId()));
                    this.i = (BaseAdUnit) readFromCache;
                }
            }
            if (this.i != null) {
                return new File(this.i.getSplashFilePath()).canRead() && !this.i.isExpiredAd() && this.d.a(this.i);
            }
        } catch (Exception e) {
            SigmobLog.e(e.getMessage());
        }
        return false;
    }

    public void h() {
        if (this.i.getSessionManager() == null) {
            new k().a(this.i);
        }
    }

    public void i() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION;
        ae.a(PointCategory.PLAY, windAdError, this.i);
        a(windAdError, false);
        n();
    }

    public void j() {
        n();
    }

    public String k() {
        BiddingResponse biddingResponse;
        BaseAdUnit baseAdUnit = this.i;
        if (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
            return null;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    public Map<String, BiddingResponse> l() {
        BaseAdUnit baseAdUnit = this.i;
        if (baseAdUnit == null || baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(this.i.getRequestId(), this.i.bidding_response);
        return hashMap;
    }
}
