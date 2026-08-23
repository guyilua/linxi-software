package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w extends com.sigmob.sdk.base.common.j {
    private static o g;
    public final long f;
    private ab h;
    private ab i;
    private RelativeLayout j;
    private FrameLayout k;
    private BaseAdUnit l;
    private c m;
    private com.sigmob.sdk.mraid.d n;
    private View o;
    private WindNativeAdData p;
    private APKStatusBroadcastReceiver q;
    private ImageView r;
    private com.sigmob.sdk.base.views.q s;
    private boolean t;
    private boolean u;

    public w(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f = 300L;
        this.t = false;
        this.l = baseAdUnit;
        c cVar = (c) baseAdUnit.getAdConfig();
        this.m = cVar;
        cVar.a(n(), this.l, (q.b) null);
        this.h = (ab) bundle.getParcelable("attr");
        k().a(1);
        int a = com.sigmob.sdk.base.g.a();
        if (a != 0) {
            n().getTheme().applyStyle(a, true);
        }
    }

    private void a(Context context) {
        if (this.r != null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.r = imageView;
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.CLOSE.a());
        this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.r.setImageAlpha(127);
        this.r.setClickable(true);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.w.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.this.k().onBackPressed();
            }
        });
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        int i = dipsToIntPixels / 2;
        layoutParams.setMargins(i, i, 0, 0);
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.addView(this.r, layoutParams);
        }
    }

    public static void a(j jVar) {
        if (jVar instanceof o) {
            g = (o) jVar;
        }
    }

    private int r() {
        DisplayMetrics displayMetrics = ClientMetadata.getInstance().getDisplayMetrics();
        return Math.min((int) (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / this.l.getAdPercent()), Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.r == null) {
            a(n());
        }
        this.r.setVisibility(0);
    }

    private void u() {
        this.u = true;
        if (g == null) {
            k().a();
            return;
        }
        new ac(this.k, this.i, this.h, 300L).a();
        this.j.setVisibility(8);
        this.k.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.w.8
            @Override // java.lang.Runnable
            public void run() {
                if (w.g != null) {
                    w.g.setUIStyle(g.PREVIEW);
                }
                w.this.k().a();
            }
        }, 300L);
    }

    public ag a() {
        ag sessionManager = this.l.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        f fVar = new f();
        fVar.a(this.l);
        return fVar;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        m().removeAllViews();
        k().onSetContentView(m());
        this.l.getClickCommon().click_scene = "template";
        RelativeLayout relativeLayout = new RelativeLayout(l());
        this.j = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.o = p();
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.a(n());
        }
        this.j.addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        o oVar = g;
        if (oVar != null) {
            WindNativeAdData nativeAdUnit = oVar.getNativeAdUnit();
            this.p = nativeAdUnit;
            if (nativeAdUnit != null) {
                layoutParams.setMargins(0, r(), 0, 0);
            }
        }
        m().addView(this.j, layoutParams);
        if (g != null) {
            this.k = new FrameLayout(n());
            g.setBackClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.k().onBackPressed();
                }
            });
            m().addView(this.k, new RelativeLayout.LayoutParams(-1, r()));
            g.getSigVideoAdController().c();
            this.k.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.nativead.w.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (w.g == null || w.this.k == null) {
                        return false;
                    }
                    w.this.k.getViewTreeObserver().removeOnPreDrawListener(this);
                    w.g.setUIStyle(g.DETAIL_PAGE);
                    ViewGroup videoContainer = w.g.getVideoContainer();
                    if (videoContainer != null) {
                        com.sigmob.sdk.base.utils.f.a(videoContainer);
                        w.this.k.addView(videoContainer, new FrameLayout.LayoutParams(-1, -1));
                    }
                    w.this.i = new ab();
                    int[] iArr = new int[2];
                    w.this.k.getLocationOnScreen(iArr);
                    w.this.i.a(iArr[0]);
                    w.this.i.b(0);
                    w.this.i.c(w.this.k.getMeasuredWidth());
                    w.this.i.d(w.this.k.getMeasuredHeight());
                    new ac(w.this.k, w.this.h, w.this.i, 300L).a();
                    w.this.h.b(w.this.h.b() - iArr[1]);
                    if (w.this.j != null) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(com.sigmob.sdk.base.blurkit.c.d, 1.0f);
                        alphaAnimation.setDuration(300L);
                        w.this.j.setAnimation(alphaAnimation);
                        alphaAnimation.start();
                    }
                    return true;
                }
            });
        }
        a(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW, 100);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        q sigVideoAdController;
        o oVar = g;
        if (oVar == null || this.u || (sigVideoAdController = oVar.getSigVideoAdController()) == null) {
            return;
        }
        sigVideoAdController.a();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        q sigVideoAdController;
        o oVar = g;
        if (oVar != null && (sigVideoAdController = oVar.getSigVideoAdController()) != null) {
            sigVideoAdController.c();
        }
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.q;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.q = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.s;
        if (qVar != null) {
            qVar.dismiss();
            this.s.c();
            this.s = null;
        }
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.m();
            this.n = null;
        }
        o oVar = g;
        if (oVar != null) {
            oVar.setBackClickListener(null);
            g = null;
        }
        a(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        o oVar = g;
        if (oVar != null && oVar.b()) {
            return false;
        }
        u();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public View p() {
        if (this.n == null) {
            this.n = new com.sigmob.sdk.mraid.d(this.b, this.l, PlacementType.INTERSTITIAL);
        }
        this.n.a(new d.a() { // from class: com.sigmob.sdk.nativead.w.4
            @Override // com.sigmob.sdk.mraid.d.a
            public void a() {
                SigmobLog.d("SigNativeAdLandViewController onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(float f) {
                SigmobLog.d("SigNativeAdLandViewController onReward()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z) {
                SigmobLog.i("SigNativeAdLandViewController onResize()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(View view) {
                SigmobLog.d("SigNativeAdLandViewController onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(WindAdError windAdError) {
                SigmobLog.i("SigNativeAdLandViewController onRenderProcessGone:" + windAdError.toString());
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(String str) {
                SigmobLog.i("SigNativeAdLandViewController onCompanionClick:" + str);
                boolean z = true;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        w.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                        w.this.l.getClickCommon().is_final_click = true;
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt(com.umeng.analytics.pro.d.y);
                        w.this.n.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (optInt != 1) {
                            w.this.a().a("click", 0);
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        w.this.n.a("0", "0");
                        w.this.a().a("click", 0);
                    }
                }
                w.this.m.a(com.sigmob.sdk.base.a.COMPANION, w.this.n.a(), z);
                w.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            }

            /* JADX WARN: Removed duplicated region for block: B:5:0x0092  */
            @Override // com.sigmob.sdk.mraid.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.net.URI r8, int r9, java.lang.String r10) {
                /*
                    r7 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "SigNativeAdLandViewController  onOpen:"
                    r0.append(r1)
                    r0.append(r8)
                    java.lang.String r1 = "======"
                    r0.append(r1)
                    r0.append(r9)
                    java.lang.String r9 = "====="
                    r0.append(r9)
                    r0.append(r10)
                    java.lang.String r9 = r0.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r9)
                    boolean r9 = android.text.TextUtils.isEmpty(r10)
                    r0 = 0
                    r1 = 1
                    if (r9 != 0) goto L8e
                    com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L8a
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.w.i(r9)     // Catch: java.lang.Exception -> L8a
                    com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()     // Catch: java.lang.Exception -> L8a
                    java.lang.String r2 = "btn"
                    r9.click_area = r2     // Catch: java.lang.Exception -> L8a
                    com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L8a
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.w.i(r9)     // Catch: java.lang.Exception -> L8a
                    com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()     // Catch: java.lang.Exception -> L8a
                    r9.is_final_click = r1     // Catch: java.lang.Exception -> L8a
                    org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8a
                    r9.<init>(r10)     // Catch: java.lang.Exception -> L8a
                    java.lang.String r10 = "type"
                    int r10 = r9.optInt(r10)     // Catch: java.lang.Exception -> L8a
                    java.lang.String r2 = "x"
                    int r2 = r9.optInt(r2)     // Catch: java.lang.Exception -> L8a
                    java.lang.String r3 = "y"
                    int r3 = r9.optInt(r3)     // Catch: java.lang.Exception -> L8a
                    java.lang.String r4 = "disable_landing"
                    boolean r4 = r9.optBoolean(r4)     // Catch: java.lang.Exception -> L8a
                    java.lang.String r5 = "feDisable"
                    boolean r9 = r9.optBoolean(r5)     // Catch: java.lang.Exception -> L89
                    if (r9 != 0) goto L6d
                    r9 = 1
                    goto L6e
                L6d:
                    r9 = 0
                L6e:
                    com.sigmob.sdk.nativead.w r5 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L87
                    com.sigmob.sdk.mraid.d r5 = com.sigmob.sdk.nativead.w.m(r5)     // Catch: java.lang.Exception -> L87
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L87
                    java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L87
                    r5.a(r2, r3)     // Catch: java.lang.Exception -> L87
                    if (r10 != r1) goto L82
                    goto L83
                L82:
                    r0 = 1
                L83:
                    r6 = r9
                    r5 = r0
                    r0 = r4
                    goto L90
                L87:
                    r0 = r4
                    goto L8b
                L89:
                    r0 = r4
                L8a:
                    r9 = 1
                L8b:
                    r6 = r9
                    r5 = 1
                    goto L90
                L8e:
                    r5 = 1
                    r6 = 1
                L90:
                    if (r0 != 0) goto Lad
                    com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.w.i(r9)
                    java.lang.String r9 = r9.getLanding_page()
                    boolean r9 = android.text.TextUtils.isEmpty(r9)
                    if (r9 == 0) goto La3
                    goto Lad
                La3:
                    com.sigmob.sdk.nativead.w r8 = com.sigmob.sdk.nativead.w.this
                    com.sigmob.sdk.nativead.c r1 = com.sigmob.sdk.nativead.w.j(r8)
                    com.sigmob.sdk.base.a r2 = com.sigmob.sdk.base.a.ENDCARD
                    r3 = 0
                    goto Lb9
                Lad:
                    com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                    com.sigmob.sdk.nativead.c r1 = com.sigmob.sdk.nativead.w.j(r9)
                    com.sigmob.sdk.base.a r2 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r3 = r8.toString()
                Lb9:
                    com.sigmob.sdk.nativead.w r8 = com.sigmob.sdk.nativead.w.this
                    com.sigmob.sdk.mraid.d r8 = com.sigmob.sdk.nativead.w.m(r8)
                    java.lang.String r4 = r8.a()
                    r1.a(r2, r3, r4, r5, r6)
                    com.sigmob.sdk.nativead.w r8 = com.sigmob.sdk.nativead.w.this
                    java.lang.String r9 = "action.native.temple.click"
                    com.sigmob.sdk.nativead.w.c(r8, r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.w.AnonymousClass4.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(boolean z) {
                SigmobLog.d("SigNativeAdLandViewController onMute()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b() {
                SigmobLog.d("SigNativeAdLandViewController onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b(float f) {
                SigmobLog.d("SigNativeAdLandViewController onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void d() {
                SigmobLog.d("SigNativeAdLandViewController onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void e() {
                SigmobLog.i("SigNativeAdLandViewController onFailedToLoad()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void f() {
                SigmobLog.i("SigNativeAdLandViewController onUnload()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void g() {
                SigmobLog.i("SigNativeAdLandViewController onOpenFourElements()");
                if (w.this.s == null) {
                    w.this.s = new com.sigmob.sdk.base.views.q(w.this.n(), w.this.l);
                    w.this.s.a(new q.b() { // from class: com.sigmob.sdk.nativead.w.4.1
                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a() {
                            if (w.this.s != null) {
                                w.this.s.dismiss();
                                w.this.s.c();
                                w.this.s = null;
                                w.this.t = false;
                            }
                            w.this.l.getClickCommon().click_scene = "template";
                            w.this.a().a(com.sigmob.sdk.base.common.a.g, 0);
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(String str, String str2) {
                            w.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                            w.this.l.getClickCommon().click_scene = "appinfo";
                            w.this.l.getClickCommon().is_final_click = true;
                            if (w.this.m != null) {
                                w.this.m.a(com.sigmob.sdk.base.a.COMPANION, str, str2, true);
                                w.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
                            }
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void b() {
                            w.this.a().a(com.sigmob.sdk.base.common.a.f, 0);
                        }
                    });
                }
                if (w.this.s == null || !w.this.s.a() || w.this.t) {
                    return;
                }
                w.this.l.getClickCommon().click_area = "appinfo";
                w.this.l.getClickCommon().is_final_click = false;
                w.this.a().a("click", 0);
                w.this.s.show();
                w.this.t = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void h() {
                SigmobLog.i("SigNativeAdLandViewController onClose()");
                w.this.k().onBackPressed();
            }
        });
        if (!TextUtils.isEmpty(this.l.getHtmlUrl())) {
            this.n.b(this.l.getHtmlUrl(), new d.b() { // from class: com.sigmob.sdk.nativead.w.5
                @Override // com.sigmob.sdk.mraid.d.b
                public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
                }
            });
        } else if (!TextUtils.isEmpty(this.l.getHtmlData())) {
            this.n.a(this.l.getHtmlData(), new d.b() { // from class: com.sigmob.sdk.nativead.w.6
                @Override // com.sigmob.sdk.mraid.d.b
                public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
                }
            });
        }
        this.n.a(new d.e() { // from class: com.sigmob.sdk.nativead.w.7
            @Override // com.sigmob.sdk.mraid.d.e
            public void a(boolean z) {
                if (z) {
                    w.this.s();
                } else if (w.g == null) {
                    w.this.t();
                }
            }
        });
        return this.n.q();
    }
}
