package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.sdk.mraid.t;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n extends com.sigmob.sdk.videoAd.c implements ac {
    private View.OnClickListener A;
    protected com.sigmob.sdk.base.common.t f;
    private final Bundle g;
    private int h;
    private com.sigmob.sdk.videoAd.a i;
    private int j;
    private boolean k;
    private BaseAdUnit l;
    private d m;
    private r n;
    private ap o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private com.sigmob.sdk.base.views.q t;
    private boolean u;
    private com.sigmob.sdk.mraid2.f v;
    private h w;
    private com.sigmob.sdk.nativead.a x;
    private w y;
    private JSONObject z;

    /* renamed from: com.sigmob.sdk.mraid.n$4, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr2;
            try {
                iArr2[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.r = false;
        this.s = false;
        this.u = false;
        this.A = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n = n.this.n();
                if (n == null || n.this.l == null) {
                    return;
                }
                n.this.x = new com.sigmob.sdk.nativead.a(n, n.this.l);
                if (n.this.x != null) {
                    n.this.x.a();
                }
                n.this.x.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.n.2.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        if (n.this.x != null) {
                            n.this.x.dismiss();
                            n.this.x.b();
                            n.this.x = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        if (n.this.x != null) {
                            n.this.x.dismiss();
                            n.this.x.b();
                            n.this.x = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.l = baseAdUnit;
        this.g = bundle;
        com.sigmob.sdk.videoAd.a aVar = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.i = aVar;
        aVar.a(n(), this.l, new q.b() { // from class: com.sigmob.sdk.mraid.n.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                b e;
                if (n.this.m == null || n.this.m.g() == null || (e = n.this.m.e()) == null) {
                    return;
                }
                e.a("fourElementsDidDisappear", (HashMap<String, Object>) null);
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                n.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                n.this.l.getClickCommon().click_scene = "appinfo";
                n.this.l.getClickCommon().is_final_click = true;
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                b e;
                if (n.this.m == null || n.this.m.g() == null || (e = n.this.m.e()) == null) {
                    return;
                }
                e.a("fourElementsDidAppear", (HashMap<String, Object>) null);
            }
        });
        this.i.a(this);
        this.j = ClientMetadata.getInstance().getInsetBottom();
        n().requestWindowFeature(1);
        m().setBackgroundColor(0);
    }

    private void a(Context context, int i) {
        if (this.o != null) {
            return;
        }
        ap apVar = new ap(context);
        this.o = apVar;
        apVar.setVisibility(i);
        this.o.setId(ClientMetadata.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
        m().addView(this.o, layoutParams);
        this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid.n.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    n.this.r = true;
                    n.this.i.b(n.this.l(), n.this.p, n.this.l);
                    n.this.k().a();
                }
                return true;
            }
        });
        this.o.a(this.l);
        String f = this.i.f();
        if (f != null) {
            this.o.a(f);
        }
    }

    private void b(Context context, int i) {
        if (this.y == null) {
            w wVar = new w(context);
            this.y = wVar;
            wVar.setText("反馈");
            this.y.setOnClickListener(this.A);
            this.y.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.o.getId());
            layoutParams.addRule(6, this.o.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.y, layoutParams);
        }
        w wVar2 = this.y;
        if (wVar2 != null) {
            wVar2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ap apVar = this.o;
        if (apVar != null) {
            apVar.setVisibility(4);
        }
        w wVar = this.y;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.o == null) {
            a(this.b, 0);
        }
        this.o.setVisibility(0);
        b(l(), 0);
    }

    public View a() {
        String str = this.a;
        t.a a = str != null ? t.a(str) : null;
        this.m = (a == null || a.d() == null) ? new d(this.b, this.l, PlacementType.INTERSTITIAL) : a.d();
        if (Build.VERSION.SDK_INT >= 20) {
            a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid.n.6
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    n.this.m.a(windowInsets);
                    return windowInsets;
                }
            });
        }
        this.m.a(this.e);
        this.m.a(new d.f() { // from class: com.sigmob.sdk.mraid.n.7
            private boolean b;

            @Override // com.sigmob.sdk.mraid.d.f
            public void a() {
                SigmobLog.d("adImpression() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Integer num) {
                n.this.p = num == null ? -1 : num.intValue();
                n nVar = n.this;
                nVar.f.a(nVar.p, n.this.i.l());
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Map<String, String> map) {
                try {
                    map.get("id");
                    String str2 = map.get("url");
                    if (!map.get("playerHandles").equalsIgnoreCase("false")) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.startsWith("http")) {
                                n.this.l.setCustomLandPageUrl(str2);
                            } else {
                                n.this.l.setCustomDeeplink(str2);
                            }
                        }
                        n.this.i.a(com.sigmob.sdk.base.a.ENDCARD, n.this.m.a(), true);
                    }
                    SigmobLog.d("adClickThru() called" + map.toString());
                } catch (Throwable th) {
                    SigmobLog.e("adClickThru", th);
                }
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b() {
                if (this.b) {
                    return;
                }
                n.this.b("pause");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b(Map<String, String> map) {
                SigmobLog.d("adError() called " + map);
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void c() {
                SigmobLog.d("adPlaying() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void d() {
                this.b = true;
                n.this.b("complete");
                SigmobLog.d("adVideoComplete() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void e() {
                n.this.b("play_quarter");
                SigmobLog.d("adVideoFirstQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void f() {
                n.this.b("play_three_quarters");
                SigmobLog.d("adVideoThirdQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void g() {
                n.this.b("play_two_quarters");
                SigmobLog.d("adVideoMidpoint() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void h() {
                n.this.b(com.sigmob.sdk.base.common.a.P);
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
                SigmobLog.d("adVideoStart() called");
            }
        });
        this.m.a(new d.a() { // from class: com.sigmob.sdk.mraid.n.8
            @Override // com.sigmob.sdk.mraid.d.a
            public void a() {
                n.this.b("show");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(float f) {
                n.this.k = true;
                n.this.b("reward");
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z) {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(View view) {
                n.this.b("start");
                n.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
                SigmobLog.d("onLoaded() called");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(WindAdError windAdError) {
                SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
                n.this.b("error");
                if (((com.sigmob.sdk.base.common.j) n.this).a != null) {
                    n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
                }
                ((com.sigmob.sdk.base.common.j) n.this).d.a();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(String str2) {
                boolean z = true;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt(com.umeng.analytics.pro.d.y);
                        if (jSONObject.has("x") && jSONObject.has("y")) {
                            n.this.m.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        }
                        if (optInt != 1) {
                            n.this.z = jSONObject.optJSONObject("log_data");
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        n.this.m.a("0", "0");
                    }
                }
                n.this.i.a(com.sigmob.sdk.base.a.COMPANION, n.this.m.a(), z);
            }

            /* JADX WARN: Removed duplicated region for block: B:5:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0087  */
            @Override // com.sigmob.sdk.mraid.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.net.URI r11, int r12, java.lang.String r13) {
                /*
                    r10 = this;
                    java.lang.String r12 = "y"
                    java.lang.String r0 = "x"
                    boolean r1 = android.text.TextUtils.isEmpty(r13)
                    r2 = 0
                    r3 = 1
                    r4 = 0
                    if (r1 != 0) goto L68
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L63
                    r1.<init>(r13)     // Catch: java.lang.Exception -> L63
                    java.lang.String r13 = "type"
                    int r13 = r1.optInt(r13)     // Catch: java.lang.Exception -> L62
                    boolean r4 = r1.has(r0)     // Catch: java.lang.Exception -> L62
                    if (r4 == 0) goto L3d
                    boolean r4 = r1.has(r12)     // Catch: java.lang.Exception -> L62
                    if (r4 == 0) goto L3d
                    int r0 = r1.optInt(r0)     // Catch: java.lang.Exception -> L62
                    int r12 = r1.optInt(r12)     // Catch: java.lang.Exception -> L62
                    com.sigmob.sdk.mraid.n r4 = com.sigmob.sdk.mraid.n.this     // Catch: java.lang.Exception -> L62
                    com.sigmob.sdk.mraid.d r4 = com.sigmob.sdk.mraid.n.a(r4)     // Catch: java.lang.Exception -> L62
                    java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L62
                    java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Exception -> L62
                    r4.a(r0, r12)     // Catch: java.lang.Exception -> L62
                L3d:
                    java.lang.String r12 = "disable_landing"
                    boolean r12 = r1.optBoolean(r12)     // Catch: java.lang.Exception -> L62
                    java.lang.String r0 = "feDisable"
                    boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Exception -> L61
                    r0 = r0 ^ r3
                    if (r13 == r3) goto L5c
                    com.sigmob.sdk.mraid.n r13 = com.sigmob.sdk.mraid.n.this     // Catch: java.lang.Exception -> L59
                    java.lang.String r2 = "log_data"
                    org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch: java.lang.Exception -> L59
                    com.sigmob.sdk.mraid.n.a(r13, r2)     // Catch: java.lang.Exception -> L59
                    r2 = 1
                    goto L5c
                L59:
                    r2 = r12
                    r4 = r1
                    goto L64
                L5c:
                    r8 = r0
                    r9 = r1
                    r7 = r2
                    r2 = r12
                    goto L6b
                L61:
                    r2 = r12
                L62:
                    r4 = r1
                L63:
                    r0 = 1
                L64:
                    r8 = r0
                    r9 = r4
                    r7 = 1
                    goto L6b
                L68:
                    r9 = r4
                    r7 = 1
                    r8 = 1
                L6b:
                    if (r2 == 0) goto L87
                    com.sigmob.sdk.mraid.n r12 = com.sigmob.sdk.mraid.n.this
                    com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.mraid.n.c(r12)
                    com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r5 = r11.toString()
                    com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.mraid.n.a(r11)
                    java.lang.String r6 = r11.a()
                    r3.a(r4, r5, r6, r7, r8, r9)
                    goto L9d
                L87:
                    com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                    com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.mraid.n.c(r11)
                    com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                    r5 = 0
                    com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.mraid.n.a(r11)
                    java.lang.String r6 = r11.a()
                    r3.a(r4, r5, r6, r7, r8)
                L9d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.n.AnonymousClass8.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(boolean z) {
                n nVar;
                String str2;
                if (z) {
                    nVar = n.this;
                    str2 = com.sigmob.sdk.base.common.a.D;
                } else {
                    nVar = n.this;
                    str2 = com.sigmob.sdk.base.common.a.E;
                }
                nVar.b(str2);
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b() {
                n.this.b("show_skip");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b(float f) {
                if (n.this.q) {
                    return;
                }
                n.this.q = true;
                n.this.b("skip");
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void c() {
                Activity n = n.this.n();
                if (n == null || n.this.l == null) {
                    return;
                }
                n.this.x = new com.sigmob.sdk.nativead.a(n, n.this.l);
                if (n.this.x != null) {
                    n.this.x.a();
                }
                n.this.x.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.n.8.2
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        b e;
                        if (n.this.m != null && n.this.m.g() != null && (e = n.this.m.e()) != null) {
                            e.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                        }
                        if (n.this.x != null) {
                            n.this.x.dismiss();
                            n.this.x.b();
                            n.this.x = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        b e;
                        if (n.this.m != null && n.this.m.g() != null && (e = n.this.m.e()) != null) {
                            e.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                        }
                        if (n.this.x != null) {
                            n.this.x.dismiss();
                            n.this.x.b();
                            n.this.x = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        b e;
                        if (n.this.m == null || n.this.m.g() == null || (e = n.this.m.e()) == null) {
                            return;
                        }
                        e.a("feedbackDidAppear", (HashMap<String, Object>) null);
                    }
                });
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void d() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void e() {
                SigmobLog.d("MraidActivity failed to load. Finishing the activity");
                if (((com.sigmob.sdk.base.common.j) n.this).a != null) {
                    n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
                }
                ((com.sigmob.sdk.base.common.j) n.this).d.a();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void f() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void g() {
                if (n.this.t == null) {
                    n.this.t = new com.sigmob.sdk.base.views.q(n.this.n(), n.this.l);
                    n.this.t.a(new q.b() { // from class: com.sigmob.sdk.mraid.n.8.3
                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a() {
                            b e;
                            if (n.this.t != null) {
                                n.this.t.dismiss();
                                n.this.t.c();
                                n.this.t = null;
                                n.this.u = false;
                            }
                            com.sigmob.sdk.base.common.t tVar = n.this.f;
                            if (tVar != null) {
                                tVar.a(com.sigmob.sdk.base.common.a.g, 0);
                            }
                            if (n.this.m == null || n.this.m.g() == null || (e = n.this.m.e()) == null) {
                                return;
                            }
                            e.a("fourElementsDidDisappear", (HashMap<String, Object>) null);
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(String str2, String str3) {
                            if (n.this.i != null) {
                                n.this.i.a(com.sigmob.sdk.base.a.ENDCARD, str2, str3, true);
                            }
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void b() {
                            b e;
                            com.sigmob.sdk.base.common.t tVar = n.this.f;
                            if (tVar != null) {
                                tVar.a(com.sigmob.sdk.base.common.a.f, 0);
                            }
                            if (n.this.m == null || n.this.m.g() == null || (e = n.this.m.e()) == null) {
                                return;
                            }
                            e.a("fourElementsDidAppear", (HashMap<String, Object>) null);
                        }
                    });
                }
                if (n.this.t == null || !n.this.t.a() || n.this.u) {
                    return;
                }
                n.this.t.show();
                n.this.u = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void h() {
                n.this.m.a(new ValueCallback<String>() { // from class: com.sigmob.sdk.mraid.n.8.1
                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str2) {
                        if (b.a(str2) == null || n.this.f == null) {
                            return;
                        }
                        Float valueOf = Float.valueOf(str2);
                        if (valueOf.floatValue() < 0.999f && !n.this.q) {
                            n.this.q = true;
                            n.this.b("skip");
                        }
                        if (n.this.k || n.this.l.getAd_type() == 4 || valueOf.floatValue() <= n.this.l.getFinishedTime()) {
                            return;
                        }
                        n.this.k = true;
                        n nVar = n.this;
                        nVar.f.a("reward", nVar.m.f().intValue());
                        n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
                    }
                });
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
                n.this.r = true;
                ((com.sigmob.sdk.base.common.j) n.this).d.a();
            }
        });
        this.m.a(new d.e() { // from class: com.sigmob.sdk.mraid.n.9
            @Override // com.sigmob.sdk.mraid.d.e
            public void a(boolean z) {
                if (z) {
                    n.this.p();
                } else {
                    n.this.q();
                }
            }
        });
        if (a != null) {
            this.f = a.c();
        } else if (!TextUtils.isEmpty(this.l.getHtmlData())) {
            this.m.a(this.l.getHtmlData(), new d.b() { // from class: com.sigmob.sdk.mraid.n.10
                @Override // com.sigmob.sdk.mraid.d.b
                public void a(p pVar, com.sigmob.sdk.base.common.t tVar) {
                    n nVar = n.this;
                    if (tVar != null) {
                        nVar.f = tVar;
                        return;
                    }
                    nVar.f = new com.sigmob.sdk.base.common.t();
                    n nVar2 = n.this;
                    nVar2.f.a(nVar2.l);
                }
            });
        } else if (!TextUtils.isEmpty(this.l.getHtmlUrl())) {
            this.m.b(this.l.getHtmlUrl(), new d.b() { // from class: com.sigmob.sdk.mraid.n.11
                @Override // com.sigmob.sdk.mraid.d.b
                public void a(p pVar, com.sigmob.sdk.base.common.t tVar) {
                    n nVar = n.this;
                    if (tVar != null) {
                        nVar.f = tVar;
                        return;
                    }
                    nVar.f = new com.sigmob.sdk.base.common.t();
                    n nVar2 = n.this;
                    nVar2.f.a(nVar2.l);
                }
            });
        }
        return this.m.q();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        this.m.a(configuration.orientation);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    public void a(r rVar) {
        this.n = rVar;
        d dVar = this.m;
        if (dVar != null) {
            dVar.a(rVar);
        }
    }

    @Override // com.sigmob.sdk.base.common.ac
    public void a(boolean z, com.sigmob.sdk.base.a aVar) {
        String str;
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        if (z) {
            int i = AnonymousClass4.b[aVar.ordinal()];
            if (i == 1) {
                ClickCommon clickCommon = this.l.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.COMPANION, "click", this.l, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.p, this.z);
                str = com.sigmob.sdk.base.common.a.w;
            } else if (i != 2) {
                ClickCommon clickCommon2 = this.l.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.l, clickCommon2.isDeeplink, clickCommon2.clickUrl, clickCommon2.clickCoordinate, this.p, this.z);
                str = "click";
            } else {
                ClickCommon clickCommon3 = this.l.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.l, clickCommon3.isDeeplink, clickCommon3.clickUrl, clickCommon3.clickCoordinate, this.p, this.z);
                str = "full_video_click";
            }
            b(str);
        }
        this.z = null;
    }

    public void b(final String str) {
        final Integer f = this.m.f();
        this.m.a(new ValueCallback<String>() { // from class: com.sigmob.sdk.mraid.n.5
            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str2) {
                Integer num;
                try {
                    if (n.this.f == null) {
                        return;
                    }
                    if (b.a(str2) == null) {
                        if (str.equals("show_skip")) {
                            n.this.f.a(false, 0);
                        }
                        n.this.f.a(str, 0);
                        return;
                    }
                    Float valueOf = Float.valueOf(str2);
                    float f2 = -1.0f;
                    if (valueOf.floatValue() > 1.0E-7d && (num = f) != null && num.intValue() > 0) {
                        f2 = f.intValue() * valueOf.floatValue();
                    }
                    if (str.equals("show_skip")) {
                        n.this.f.a(false, (int) f2);
                    }
                    n.this.f.a(str, (int) f2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        b(n(), this.h, this.g);
        n().getWindow().addFlags(16778240);
        com.sigmob.sdk.base.common.t tVar = this.f;
        if (tVar != null) {
            tVar.a("show", 0);
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
        d dVar = this.m;
        if (dVar != null) {
            dVar.a(n());
        }
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        a(new r() { // from class: com.sigmob.sdk.mraid.n.3
            @Override // com.sigmob.sdk.mraid.r
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass4.a[consoleMessage.messageLevel().ordinal()] != 1) {
                    return false;
                }
                SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                ae.a("h5_error", "mraid1", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, n.this.l, (ae.a) null);
                return false;
            }

            @Override // com.sigmob.sdk.mraid.r
            public boolean a(String str, JsResult jsResult) {
                return false;
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (!this.r) {
            this.m.b();
        } else {
            this.s = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        this.m.c();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        com.sigmob.sdk.base.common.t tVar = this.f;
        if (tVar != null) {
            tVar.a();
            this.f = null;
        }
        d dVar = this.m;
        if (dVar != null) {
            dVar.m();
        }
        com.sigmob.sdk.nativead.a aVar = this.x;
        if (aVar != null) {
            aVar.dismiss();
            this.x.b();
            this.x = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.t;
        if (qVar != null) {
            qVar.dismiss();
            this.t.c();
            this.t = null;
            this.u = false;
        }
        if (!this.r || !this.s) {
            this.s = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        BaseAdUnit baseAdUnit = this.l;
        if (baseAdUnit != null) {
            baseAdUnit.destroy();
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }
}
