package com.sigmob.sdk.newInterstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.k;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView;
import com.sigmob.sdk.videoplayer.l;
import com.sigmob.windad.natives.WindNativeAdData;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends com.sigmob.sdk.videoAd.c {
    private boolean A;
    private boolean B;
    private q C;
    private boolean D;
    private boolean E;
    private boolean F;
    private com.sigmob.sdk.nativead.a G;
    private View.OnClickListener H;
    private final BaseAdUnit f;
    private final Bundle g;
    private com.sigmob.sdk.base.common.i h;
    private f i;
    private RelativeLayout j;
    private List<String> k;
    private List<String> l;
    private com.sigmob.sdk.videoplayer.a m;
    private ImageView n;
    private g o;
    private InterstitialSetting p;
    private boolean q;
    private ViewGroup r;
    private View s;
    private NewInterstitialHeaderView t;
    private SigAdInfoView u;
    private int v;
    private String w;
    private long x;
    private int y;
    private Handler z;

    /* renamed from: com.sigmob.sdk.newInterstitial.h$7, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.e.values().length];
            a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public h(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, k kVar) {
        super(activity, str, kVar);
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.q = false;
        this.H = new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n = h.this.n();
                if (n == null || h.this.f == null) {
                    return;
                }
                h.this.G = new com.sigmob.sdk.nativead.a(n, h.this.f);
                if (h.this.G != null) {
                    h.this.G.a();
                }
                h.this.G.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.newInterstitial.h.5.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        h.this.g();
                        if (h.this.G != null) {
                            h.this.G.dismiss();
                            h.this.G.b();
                            h.this.G = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        h.this.g();
                        if (h.this.G != null) {
                            h.this.G.dismiss();
                            h.this.G.b();
                            h.this.G = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        h.this.f();
                    }
                });
            }
        };
        this.f = baseAdUnit;
        this.g = bundle;
        this.z = new Handler(Looper.getMainLooper());
        com.sigmob.sdk.base.common.i adConfig = baseAdUnit.getAdConfig();
        this.h = adConfig;
        adConfig.a(n(), baseAdUnit, new q.b() { // from class: com.sigmob.sdk.newInterstitial.h.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                h.this.D = false;
                if (h.this.m != null) {
                    h.this.m.d();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                h.this.f.getClickCommon().click_area = "appinfo";
                h.this.f.getClickCommon().is_final_click = true;
                h.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
                if (h.this.a() != null) {
                    h.this.a().a("click", 0);
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                h.this.D = true;
                if (h.this.m != null) {
                    h.this.m.j();
                }
            }
        });
        k().a(7);
        n().requestWindowFeature(1);
        this.q = baseAdUnit.getTemplateType() == 0;
    }

    private void A() {
        View privacyLl;
        if (this.B) {
            return;
        }
        com.sigmob.sdk.videoplayer.a aVar = this.m;
        if (aVar != null) {
            aVar.r();
            this.m = null;
        }
        this.B = true;
        if (this.o == null) {
            g gVar = new g(this.b);
            this.o = gVar;
            gVar.a(this.H);
            Button cTAButton = this.o.getCTAButton();
            com.sigmob.sdk.base.a aVar2 = com.sigmob.sdk.base.a.ENDCARD;
            a(cTAButton, aVar2);
            this.o.a(this.f.getIconUrl(), this.f.getEndCardImageUrl(), this.f.getAppName(), this.f.getCreativeTitle(), this.f.getCTAText());
            SigAdPrivacyInfoView adPrivacyInfo = this.o.getAdPrivacyInfo();
            if (adPrivacyInfo != null && (privacyLl = adPrivacyInfo.getPrivacyLl()) != null) {
                privacyLl.setBackgroundColor(0);
                a(adPrivacyInfo, aVar2);
            }
            this.o.getCloseButton().setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.r();
                }
            });
        }
        this.t.hideSoundIcon();
        ViewUtil.removeFromParent(this.i);
        m().addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }

    private void a(ViewGroup viewGroup) {
        int templateId = this.f.getTemplateId();
        if (templateId == 6001) {
            com.sigmob.sdk.videoplayer.a w = w();
            this.m = w;
            viewGroup.addView(w, new ViewGroup.LayoutParams(-1, -1));
            this.m.a();
            return;
        }
        if (templateId != 6002) {
            return;
        }
        ImageView imageView = new ImageView(this.b);
        this.n = imageView;
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        com.sigmob.sdk.base.common.h.a().load(this.f.getMainImage()).into(this.n);
    }

    private void a(Button button, final com.sigmob.sdk.base.a aVar) {
        button.setText(this.f.getCTAText());
        button.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.h.9

            /* renamed from: c, reason: collision with root package name */
            private MotionEvent f635c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String str;
                if (motionEvent.getAction() == 0) {
                    this.f635c = motionEvent;
                } else if (motionEvent.getAction() == 1) {
                    SigMacroCommon macroCommon = h.this.f.getMacroCommon();
                    if (macroCommon != null) {
                        macroCommon.updateClickMarco(this.f635c, motionEvent, false);
                        str = macroCommon.getCoordinate();
                    } else {
                        str = "";
                    }
                    h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    h.this.f.getClickCommon().click_scene = aVar == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
                    h.this.f.getClickCommon().is_final_click = h.this.f.noHasDownloadDialog();
                    h.this.f.getAdConfig().a(aVar, str, true);
                }
                return false;
            }
        });
        this.f.getAdConfig().a(new ac() { // from class: com.sigmob.sdk.newInterstitial.h.10
            @Override // com.sigmob.sdk.base.common.ac
            public void a(boolean z, com.sigmob.sdk.base.a aVar2) {
                if (h.this.f.getClickCommon().is_final_click) {
                    h.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
                }
                if (h.this.a() != null) {
                    h.this.a().a("click", 0);
                }
            }
        });
    }

    private void a(SigAdPrivacyInfoView sigAdPrivacyInfoView, final com.sigmob.sdk.base.a aVar) {
        if (sigAdPrivacyInfoView != null) {
            sigAdPrivacyInfoView.a(this.f.getAd_source_logo(), this.f.getadPrivacy() != null);
            sigAdPrivacyInfoView.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.h.15

                /* renamed from: c, reason: collision with root package name */
                private MotionEvent f634c;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.f634c = motionEvent;
                    } else if (motionEvent.getAction() == 1) {
                        SigMacroCommon macroCommon = h.this.f.getMacroCommon();
                        if (macroCommon != null) {
                            macroCommon.updateClickMarco(this.f634c, motionEvent, false);
                        }
                        h.this.a(aVar);
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final com.sigmob.sdk.base.a aVar) {
        try {
            Activity n = n();
            if (this.C == null && n != null) {
                q qVar = new q(n(), this.f);
                this.C = qVar;
                qVar.a(new q.b() { // from class: com.sigmob.sdk.newInterstitial.h.2
                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a() {
                        if (h.this.m != null) {
                            h.this.m.d();
                        }
                        if (h.this.C != null) {
                            h.this.C.dismiss();
                            h.this.C.c();
                            h.this.C = null;
                        }
                        h.this.D = false;
                        if (h.this.a() != null) {
                            h.this.a().a(com.sigmob.sdk.base.common.a.g, 0);
                        }
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(String str, String str2) {
                        if (h.this.f != null) {
                            h.this.f.getClickCommon().is_final_click = true;
                            h.this.f.getAdConfig().a(aVar, str, str2, true);
                        }
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void b() {
                        if (h.this.m != null) {
                            h.this.m.j();
                        }
                        if (h.this.a() != null) {
                            h.this.a().a(com.sigmob.sdk.base.common.a.f, 0);
                        }
                    }
                });
            }
            q qVar2 = this.C;
            if (qVar2 == null || !qVar2.a() || this.D) {
                return false;
            }
            this.f.getClickCommon().click_area = "appinfo";
            this.f.getClickCommon().click_scene = aVar == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
            this.f.getClickCommon().is_final_click = false;
            if (a() != null) {
                a().a("click", 0);
            }
            this.C.show();
            this.D = true;
            return true;
        } catch (Exception e) {
            SigmobLog.e("openFourElements fail:" + e.getMessage());
            return false;
        }
    }

    private void q() {
        Context context;
        String str;
        this.i = new f(this.b);
        int screenHeightAsIntDips = Dips.screenHeightAsIntDips(this.b);
        int screenWidthAsIntDips = Dips.screenWidthAsIntDips(this.b);
        if (this.q) {
            context = this.b;
            str = "sig_new_interstitial_full_layout";
        } else if (screenHeightAsIntDips * 0.8f <= 553.0f || screenWidthAsIntDips * 0.8f <= 287.0f) {
            context = this.b;
            str = "sig_new_interstitial_small_layout";
        } else {
            context = this.b;
            str = "sig_new_interstitial_layout";
        }
        this.i.a(ResourceUtil.getLayoutId(context, str));
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        this.r = this.i.getMainAdContainer();
        this.p = this.f.getNewInterstitialSetting();
        m().addView(this.i, new ViewGroup.LayoutParams(-1, -1));
        a(this.r);
        v();
        s();
        a(this.i.getCTAButton(), com.sigmob.sdk.base.a.AD);
        if (this.p != null) {
            m().postDelayed(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h.8
                @Override // java.lang.Runnable
                public void run() {
                    h.this.u();
                }
            }, this.p.charge_time.intValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        k().a();
    }

    private void s() {
        NewInterstitialHeaderView headerView = this.i.getHeaderView();
        this.t = headerView;
        boolean z = true;
        headerView.showFeedback(this.m != null, this.H);
        this.t.setAdHeaderViewStateListener(new NewInterstitialHeaderView.a() { // from class: com.sigmob.sdk.newInterstitial.h.11
            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void a() {
                h.this.u();
                if (h.this.a() != null) {
                    h.this.a().a("show_close", 0);
                }
            }

            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void b() {
                h.this.u();
                if (h.this.a() != null) {
                    h.this.a().a("show_skip", 0);
                }
            }
        });
        this.t.setSoundClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.A = !r2.A;
                h.this.t.setSoundStatus(h.this.A);
                if (h.this.m != null) {
                    h.this.m.setMute(h.this.A);
                }
            }
        });
        this.t.setCloseClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.r();
            }
        });
        this.t.setSkipClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.t();
            }
        });
        InterstitialSetting interstitialSetting = this.p;
        if (interstitialSetting != null) {
            if (!interstitialSetting.skip_close_ad.booleanValue() && this.f.hasEndCard()) {
                z = false;
            }
            this.t.startAdTimer(this.p.show_skip_seconds.intValue(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (a() != null) {
            a().a("skip", 0);
        }
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.F) {
            return;
        }
        this.F = true;
        if (a() != null) {
            a().a("charge", 0);
        }
    }

    private void v() {
        SigAdInfoView adInfView = this.i.getAdInfView();
        if (adInfView != null) {
            adInfView.setAppInfoView(this.f.getIconUrl(), this.f.getAppName(), this.f.getCreativeTitle());
            SigAdPrivacyInfoView adPrivacyInfo = adInfView.getAdPrivacyInfo();
            if (adPrivacyInfo != null) {
                adPrivacyInfo.getPrivacyAdText().setTextColor(-1);
                a(adInfView.getAdPrivacyInfo(), com.sigmob.sdk.base.a.AD);
            }
        }
    }

    private com.sigmob.sdk.videoplayer.a w() {
        if (this.m == null) {
            com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(l());
            this.m = aVar;
            aVar.setVideoPlayerStatusListener(new l() { // from class: com.sigmob.sdk.newInterstitial.h.3
                private boolean b;

                @Override // com.sigmob.sdk.videoplayer.l
                public void a(long j, long j2) {
                    SigmobLog.d("position " + j + " duration " + j2);
                    for (com.sigmob.sdk.videoAd.f fVar : h.this.h.a(j, (long) h.this.v)) {
                        h.this.b(fVar.getEvent());
                        fVar.setTracked();
                    }
                    if (j > h.this.v) {
                        h.this.p();
                    }
                }

                @Override // com.sigmob.sdk.videoplayer.l
                public void a(final com.sigmob.sdk.videoplayer.e eVar) {
                    if (h.this.m == null) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h.3.1
                        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0024. Please report as an issue. */
                        @Override // java.lang.Runnable
                        public void run() {
                            SigmobLog.i("video player state change " + eVar);
                            switch (AnonymousClass7.a[eVar.ordinal()]) {
                                case 1:
                                    if (h.this.m != null) {
                                        h hVar = h.this;
                                        hVar.v = (int) hVar.m.getDuration();
                                        if (h.this.v == 0) {
                                            h hVar2 = h.this;
                                            hVar2.v = hVar2.f.getDuration();
                                        }
                                        h.this.f.getVideoCommon().video_time = (int) (h.this.v / 1000.0f);
                                    }
                                    h.this.f.getVideoCommon().is_first = 1;
                                    h.this.f.getVideoCommon().type = 1;
                                    h.this.f.getVideoCommon().scene = 1;
                                    h.this.f.getVideoCommon().is_auto_play = 1;
                                    h.this.f.getVideoCommon().is_last = 0;
                                    h.this.f.getVideoCommon().end_time = 0;
                                    h hVar3 = h.this;
                                    hVar3.A = hVar3.f.getIsMute() != 0;
                                    if (h.this.m != null) {
                                        h.this.m.setMute(h.this.A);
                                        h.this.t.setSoundStatus(h.this.A);
                                        h.this.t.showSoundIcon();
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (AnonymousClass3.this.b) {
                                        h.this.f.getVideoCommon().type = 2;
                                    }
                                    AnonymousClass3.this.b = false;
                                    if (h.this.a() != null) {
                                        h.this.a().a("video_start", 0);
                                    }
                                    if (h.this.m != null) {
                                        h.this.f.getVideoCommon().begin_time = (int) (((float) h.this.m.getCurrentPositionWhenPlaying()) / 1000.0f);
                                        return;
                                    }
                                    return;
                                case 3:
                                    if (h.this.m != null) {
                                        ae.a(PointCategory.VIDEO, h.this.m.getErrorCode(), h.this.m.getErrorMessage(), h.this.f);
                                    }
                                    h.this.p();
                                    return;
                                case 4:
                                    if (h.this.a() != null) {
                                        h.this.a().a("complete", 0);
                                    }
                                    if (!h.this.f.hasEndCard()) {
                                        h.this.f.getVideoCommon().type = 3;
                                        if (h.this.m == null) {
                                            return;
                                        }
                                        h.this.m.d();
                                        return;
                                    }
                                    h.this.p();
                                    return;
                                case 5:
                                    h.this.p();
                                    return;
                                case 6:
                                    h.this.y();
                                    if (h.this.m != null) {
                                        h.this.m.j();
                                        return;
                                    }
                                    return;
                                case 7:
                                    h.this.z();
                                    if (h.this.m == null) {
                                        return;
                                    }
                                    h.this.m.d();
                                    return;
                                case 8:
                                    if (h.this.a() != null) {
                                        h.this.a().a("video_pause", 0);
                                    }
                                    AnonymousClass3.this.b = true;
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
            });
            x();
        }
        this.m.setUp(this.f.getProxyVideoUrl());
        return this.m;
    }

    private void x() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_three_quarters", 0.75f));
        this.h.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.j.setVisibility(0);
        this.w = "loading";
        int i = this.y + 1;
        this.y = i;
        if (i > 2) {
            return;
        }
        this.z.postDelayed(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h.4
            @Override // java.lang.Runnable
            public void run() {
                h.this.z.removeCallbacksAndMessages(null);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void z() {
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.k.add(String.format("%d", Long.valueOf(System.currentTimeMillis() - this.x)));
        this.l.add(String.format("%.2f", Float.valueOf(((int) this.m.getCurrentPositionWhenPlaying()) / 1000.0f)));
        this.w = PointCategory.PLAY;
        this.z.removeCallbacksAndMessages(null);
        this.j.setVisibility(4);
    }

    public ag a() {
        BaseAdUnit baseAdUnit = this.f;
        if (baseAdUnit == null) {
            return null;
        }
        ag sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        c cVar = new c();
        cVar.a(this.f);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    void b(String str) {
        if (a() != null) {
            a().a(str, (int) this.m.getCurrentPositionWhenPlaying());
        }
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        b();
        b(n(), 7, this.g);
        q();
        if (a() != null) {
            a().a("start", 0);
        }
        a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        com.sigmob.sdk.videoplayer.a aVar = this.m;
        if (aVar == null || this.D) {
            return;
        }
        aVar.j();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        com.sigmob.sdk.videoplayer.a aVar = this.m;
        if (aVar == null || this.D) {
            return;
        }
        aVar.d();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        com.sigmob.sdk.videoplayer.a aVar = this.m;
        if (aVar != null) {
            aVar.r();
            this.m = null;
        }
        q qVar = this.C;
        if (qVar != null) {
            qVar.dismiss();
            this.C.c();
            this.C = null;
        }
        com.sigmob.sdk.nativead.a aVar2 = this.G;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.G.b();
            this.G = null;
        }
        this.f.destroy();
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public void p() {
        z();
        A();
    }
}
