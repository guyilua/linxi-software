package com.sigmob.sdk.videoAd;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.ak;
import com.sigmob.sdk.base.views.an;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.aq;
import com.sigmob.sdk.base.views.au;
import com.sigmob.sdk.base.views.d;
import com.sigmob.sdk.base.views.o;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.base.views.z;
import com.sigmob.sdk.videoAd.i;
import com.sigmob.windad.natives.WindNativeAdData;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n extends c implements ac, h.a, com.sigmob.sdk.videocache.d {
    static final String f = "video_config";
    private static final String h = "current_position";
    private static final String i = "video_finished";
    private static final String j = "companionAd_visable";
    private static final long k = 50;
    private static final int l = -1;
    private static final int m = 0;
    private static int n;
    private boolean A;
    private Handler B;
    private boolean C;
    private com.sigmob.sdk.base.views.d D;
    private String E;
    private int F;
    private boolean G;
    private com.sigmob.sdk.videoAd.a H;
    private int I;
    private com.sigmob.sdk.videoplayer.a J;
    private BaseAdUnit K;
    private View L;
    private t M;
    private MediaMetadataRetriever N;
    private aq O;
    private ap P;
    private w Q;
    private i R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean X;
    private RelativeLayout Y;
    private boolean Z;
    private boolean aA;
    private ap aa;
    private boolean ab;
    private boolean ac;
    private ImageLoader.ImageContainer ad;
    private com.sigmob.sdk.base.views.m ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private z aj;
    private boolean ak;
    private com.sigmob.sdk.base.views.q al;
    private boolean am;
    private w an;
    private w ao;
    private aa.a ap;
    private v aq;
    private boolean ar;
    private com.sigmob.sdk.nativead.a as;
    private w at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private String ay;
    private View.OnClickListener az;
    String g;
    private final int o;
    private com.sigmob.sdk.base.views.b p;
    private ImageView q;
    private RelativeLayout r;
    private int s;
    private boolean t;
    private int u;
    private String v;
    private List<String> w;
    private List<String> x;
    private long y;
    private String z;

    /* renamed from: com.sigmob.sdk.videoAd.n$20, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass20 {
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
            try {
                b[com.sigmob.sdk.base.a.MOTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.videoplayer.e.values().length];
            a = iArr2;
            try {
                iArr2[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        a() {
        }

        @JavascriptInterface
        public int getInteractionType() {
            return n.n;
        }

        @JavascriptInterface
        public String getSdkVersion() {
            return com.sigmob.sdk.base.k.k;
        }
    }

    public n(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.s = 0;
        this.t = false;
        this.u = 0;
        this.v = "undone";
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.z = "none";
        this.B = new Handler();
        this.C = true;
        this.K = null;
        this.N = new MediaMetadataRetriever();
        this.S = 0;
        this.X = false;
        this.Z = false;
        this.ab = false;
        this.ac = false;
        this.af = false;
        this.ak = false;
        this.am = false;
        this.az = new View.OnClickListener() { // from class: com.sigmob.sdk.videoAd.n.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n2 = n.this.n();
                if (n2 == null || n.this.K == null) {
                    return;
                }
                n.this.as = new com.sigmob.sdk.nativead.a(n2, n.this.K);
                if (n.this.as != null) {
                    n.this.as.a();
                }
                n.this.as.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.videoAd.n.22.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        n.this.M();
                        if (n.this.as != null) {
                            n.this.as.dismiss();
                            n.this.as.b();
                            n.this.as = null;
                        }
                        if (n.this.ap != null) {
                            n.this.ap.a();
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i2, String str2, boolean z) {
                        n.this.M();
                        if (n.this.as != null) {
                            n.this.as.dismiss();
                            n.this.as.b();
                            n.this.as = null;
                        }
                        if (n.this.ap != null) {
                            n.this.ap.a();
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        n.this.N();
                        if (n.this.ap != null) {
                            n.this.ap.b();
                        }
                    }
                });
            }
        };
        this.K = baseAdUnit;
        this.H = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.o = Dips.dipsToIntPixels(10.0f, this.b);
        this.H.a(n(), this.K, new q.b() { // from class: com.sigmob.sdk.videoAd.n.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                n.this.am = false;
                n.this.ar = false;
                n.this.M();
                if (n.this.ap != null) {
                    n.this.ap.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                n.this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                n.this.K.getClickCommon().click_scene = "appinfo";
                n.this.K.getClickCommon().is_final_click = true;
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                n.this.am = true;
                n.this.ar = true;
                n.this.N();
                if (n.this.ap != null) {
                    n.this.ap.b();
                }
            }
        });
        this.H.a(this);
        this.E = this.K.getAdslot_id();
        n = this.K.getInteractionType();
        n().requestWindowFeature(1);
        b(activity, this.I, bundle);
        this.K.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        this.C = this.K.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_transparent_html.a();
        if (bundle2 != null) {
            this.T = bundle2.getInt(h, -1);
            this.U = bundle2.getBoolean(i, false);
            this.X = bundle2.getBoolean(j, false);
        }
        if (this.e == null) {
            int b = com.sigmob.sdk.base.g.b();
            if (b != 0) {
                n().setTheme(b);
            }
            m().setBackgroundColor(-16777216);
        } else {
            m().setBackgroundColor(0);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.r = relativeLayout;
        relativeLayout.setBackgroundColor(-16777216);
        this.J = d(this.b, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.r.addView(this.J, layoutParams);
        m().addView(this.r, new RelativeLayout.LayoutParams(-1, -1));
        if (this.t) {
            a(this.b);
            E();
        }
        q();
        this.r.setClickable(true);
        this.r.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.n.12
            MotionEvent a = null;

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
            
                if (r5.getAction() == 0) goto L32;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x009a, code lost:
            
                r3.a = android.view.MotionEvent.obtain(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
            
                if (r5.getAction() == 0) goto L32;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
                /*
                    r3 = this;
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.c(r4)
                    boolean r4 = r4.getFullClickOnVideo()
                    r0 = 1
                    if (r4 == 0) goto L3c
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.n.e(r4)
                    if (r4 == 0) goto L21
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.n.e(r4)
                    int r4 = r4.getVisibility()
                    if (r4 == 0) goto La0
                L21:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L35
                    android.view.MotionEvent r4 = r3.a
                    if (r4 != 0) goto L2d
                    r3.a = r5
                L2d:
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    android.view.MotionEvent r1 = r3.a
                    com.sigmob.sdk.videoAd.n.a(r4, r1, r5)
                    goto La0
                L35:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La0
                    goto L9a
                L3c:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L94
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.c(r4)
                    com.sigmob.sdk.base.models.rtb.MaterialMeta r4 = r4.getMaterial()
                    java.lang.Boolean r4 = r4.enable_collapse_tool_bar
                    boolean r4 = r4.booleanValue()
                    r1 = 0
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.f(r4)
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.f(r4)
                    boolean r4 = r4.a()
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.f(r4)
                    boolean r4 = r4.b()
                    if (r4 == 0) goto L7f
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.f(r4)
                    r4.setVisibility(r1)
                    goto L89
                L7f:
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.f(r4)
                    r2 = 4
                    r4.setVisibility(r2)
                L89:
                    com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.c(r4)
                    java.lang.String r2 = "useless_video_click"
                    com.sigmob.sdk.base.common.ae.a(r4, r5, r2, r1)
                L94:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La0
                L9a:
                    android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r5)
                    r3.a = r4
                La0:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.n.AnonymousClass12.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        RelativeLayout relativeLayout = this.Y;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.y = System.currentTimeMillis();
        this.Y.setVisibility(0);
        this.z = "loading";
        int i2 = this.u + 1;
        this.u = i2;
        if (i2 > 2) {
            a((int) this.J.getCurrentPositionWhenPlaying(), true);
        } else {
            this.B.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.21
                @Override // java.lang.Runnable
                public void run() {
                    n.this.B.removeCallbacksAndMessages(null);
                    n nVar = n.this;
                    nVar.a((int) nVar.J.getCurrentPositionWhenPlaying(), true);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void F() {
        RelativeLayout relativeLayout = this.Y;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.w.add(String.format("%d", Long.valueOf(System.currentTimeMillis() - this.y)));
        this.x.add(String.format("%.2f", Float.valueOf(((int) this.J.getCurrentPositionWhenPlaying()) / 1000.0f)));
        this.z = PointCategory.PLAY;
        this.B.removeCallbacksAndMessages(null);
        this.Y.setVisibility(4);
    }

    private void G() {
        switch ((int) this.K.getWidgetId(0)) {
            case 138731:
                K();
                break;
            case 138733:
                L();
                break;
            case 138757:
                H();
                break;
            case 138758:
                J();
                break;
        }
        v vVar = this.aq;
        if (vVar != null) {
            vVar.a();
        }
    }

    private void H() {
        this.aq = new com.sigmob.sdk.base.views.ac(l());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        aa.e eVar = new aa.e(l(), new aa.b() { // from class: com.sigmob.sdk.videoAd.n.23
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || n.this.K == null || n.this.ar) {
                    return;
                }
                n.this.ar = true;
                n.this.K.getClickCommon().sld = "2";
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null) {
                    n.this.K.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.K.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.K.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                n.this.aq.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.I();
                    }
                }, 400L);
            }
        });
        this.ap = eVar;
        eVar.a(this.K.getSensitivity());
        this.ap.a();
        m().addView(this.aq, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.ar = true;
        this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
        this.K.getClickCommon().click_scene = "ad";
        this.K.getClickCommon().is_final_click = true;
        this.H.a(com.sigmob.sdk.base.a.MOTION, (String) null, true);
    }

    private void J() {
        this.aq = new au(l());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        aa.c cVar = new aa.c(l(), new aa.b() { // from class: com.sigmob.sdk.videoAd.n.24
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || n.this.K == null || n.this.ar) {
                    return;
                }
                n.this.ar = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    n.this.K.getClickCommon().turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.K.getClickCommon().turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.K.getClickCommon().turn_z = String.valueOf(number3.intValue());
                }
                n.this.K.getClickCommon().turn_time = String.valueOf(number4);
                n.this.K.getClickCommon().sld = "5";
                n.this.aq.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.I();
                    }
                }, 400L);
            }
        }, aa.d.WRING);
        this.ap = cVar;
        cVar.a(this.K.getSensitivity());
        this.ap.a();
        m().addView(this.aq, layoutParams);
    }

    private void K() {
        this.aq = new an(l());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        aa.c cVar = new aa.c(l(), new aa.b() { // from class: com.sigmob.sdk.videoAd.n.25
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
                if (n.this.aq instanceof an) {
                    ((an) n.this.aq).a(f2);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || n.this.K == null || n.this.ar) {
                    return;
                }
                n.this.ar = true;
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null) {
                    n.this.K.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.K.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.K.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                n.this.K.getClickCommon().sld = "2";
                n.this.aq.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.I();
                    }
                }, 400L);
            }
        }, aa.d.SWING);
        this.ap = cVar;
        cVar.a(this.K.getSensitivity());
        this.ap.a();
        m().addView(this.aq, layoutParams);
    }

    private void L() {
        this.aq = new ak(l());
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, l());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        aa.c cVar = new aa.c(l(), new aa.b() { // from class: com.sigmob.sdk.videoAd.n.26
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
                if (n.this.aq instanceof ak) {
                    ((ak) n.this.aq).a(f2);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || n.this.K == null || n.this.ar) {
                    return;
                }
                n.this.ar = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    n.this.K.getClickCommon().turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.K.getClickCommon().turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.K.getClickCommon().turn_z = String.valueOf(number3.intValue());
                }
                n.this.K.getClickCommon().turn_time = String.valueOf(number4);
                n.this.K.getClickCommon().sld = "5";
                n.this.aq.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.I();
                    }
                }, 400L);
            }
        }, aa.d.SLOPE);
        this.ap = cVar;
        cVar.a(this.K.getSensitivity());
        this.ap.a();
        m().addView(this.aq, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        try {
            if (this.U) {
                return;
            }
            int currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
            if (this.T > 0 && currentPositionWhenPlaying == 0) {
                SigmobLog.d("video seek to " + this.T);
                this.J.a(this.T);
            }
            com.sigmob.sdk.base.views.d dVar = this.D;
            if ((dVar == null || dVar.getVisibility() != 0) && !this.am) {
                this.J.d();
            }
            if (this.T != -1) {
                this.H.a(l(), this.T);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            if (this.U) {
                return;
            }
            this.J.j();
            SigmobLog.i("videoView.pause()");
            this.T = (int) this.J.getCurrentPositionWhenPlaying();
            r().a("pause", (int) this.J.getCurrentPositionWhenPlaying());
            this.H.b(l(), this.T);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float O() {
        return y() > 0 ? ((int) this.J.getCurrentPositionWhenPlaying()) / y() : com.sigmob.sdk.base.blurkit.c.d;
    }

    private void P() {
        try {
            this.S = this.H.e(y());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.K.getAd_type() == 4 || this.at == null) {
            return;
        }
        int B = B();
        if (B <= 0) {
            this.at.setText("已获得奖励");
            return;
        }
        this.at.setText(B + "s后获取奖励");
    }

    private void R() {
        ae.a(PointCategory.PLAY_LOADING, (String) null, this.K, new ae.a() { // from class: com.sigmob.sdk.videoAd.n.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    n nVar = n.this;
                    hashMap.put("duration_seq", nVar.a((List<String>) nVar.w));
                    n nVar2 = n.this;
                    hashMap.put("video_time_seq", nVar2.a((List<String>) nVar2.x));
                    hashMap.put("skip_state", n.this.z);
                    hashMap.put("video_duration", String.format("%.2f", Float.valueOf(n.this.y() / 1000.0f)));
                    hashMap.put("endcard_loading_state", n.this.v);
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        });
    }

    private void S() {
        int o = this.H.o();
        int y = y() - 2;
        if (o == 99999999) {
            o = 0;
        } else if (o == -99999999) {
            a(y);
            return;
        } else if (o <= 0) {
            o += y;
        }
        a(o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        ImageView imageView;
        w wVar = this.at;
        if (wVar != null) {
            ViewUtil.removeFromParent(wVar);
        }
        w wVar2 = this.ao;
        if (wVar2 != null) {
            ViewUtil.removeFromParent(wVar2);
        }
        v vVar = this.aq;
        if (vVar != null) {
            ViewUtil.removeFromParent(vVar);
        }
        z();
        aa.a aVar = this.ap;
        if (aVar != null) {
            aVar.c();
            this.ap = null;
        }
        if (!this.C && (imageView = this.q) != null) {
            ViewParent parent = imageView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.q);
            }
            m().addView(this.q, 0);
        }
        com.sigmob.sdk.base.common.h.g().b(this);
        h(l(), 0);
        com.sigmob.sdk.base.views.b bVar = this.p;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
        R();
        F();
        if (this.L == null) {
            SigmobLog.e("endcard can't show " + this.K.getEndCardIndexPath());
            HashMap hashMap = new HashMap();
            hashMap.put("error", "endcard can't show");
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
            this.d.a();
        }
        View view = this.L;
        if (view != null) {
            view.setVisibility(0);
            this.L.bringToFront();
        }
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
            a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        w wVar3 = this.Q;
        if (wVar3 != null) {
            ViewUtil.removeFromParent(wVar3);
        }
        ap apVar = this.aa;
        if (apVar != null) {
            ViewUtil.removeFromParent(apVar);
        }
        if (this.af) {
            ViewUtil.removeFromParent(this.O);
        }
        com.sigmob.sdk.base.views.m mVar = this.ae;
        if (mVar != null) {
            ViewUtil.removeFromParent(mVar);
        }
        this.X = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.18
            @Override // java.lang.Runnable
            public void run() {
                n.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            }
        });
    }

    private View a(Context context, i iVar, int i2) {
        Preconditions.NoThrow.checkNotNull(context);
        if (iVar == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        m().addView(relativeLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
        com.sigmob.sdk.base.views.o a2 = a(context, iVar);
        a2.setVisibility(i2);
        relativeLayout.addView(a2, new LinearLayout.LayoutParams(-1, -1));
        return a2;
    }

    private com.sigmob.sdk.base.views.o a(Context context, i iVar) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(iVar);
        Preconditions.NoThrow.checkNotNull(iVar.a());
        com.sigmob.sdk.base.views.o a2 = com.sigmob.sdk.base.views.o.a(context, this.K.getAd_source_logo(), false, this.K.getInvisibleAdLabel());
        a2.addJavascriptInterface(new a(), "sigVersion");
        a2.setWebViewClickListener(new o.a() { // from class: com.sigmob.sdk.videoAd.n.15
            @Override // com.sigmob.sdk.base.views.o.a
            public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
                if (n.this.P.getVisibility() != 0 || n.this.Z) {
                    SigmobLog.w("ignore invalid click");
                    return;
                }
                n.this.K.getClickCommon().sld = "0";
                ae.a(n.this.K, motionEvent2, PointCategory.ENDCARDCLICK, true);
                SigMacroCommon macroCommon = n.this.K.getMacroCommon();
                if (macroCommon instanceof SigMacroCommon) {
                    macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
                    n.this.g = macroCommon.getCoordinate();
                }
                n.this.A = true;
                if (n.this.K.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.l.FullScreen.a() || TextUtils.isEmpty(n.this.K.getLanding_page()) || n.this.K.getMaterial().creative_type.intValue() == com.sigmob.sdk.base.common.m.CreativeTypeVideo_EndCardURL.a()) {
                    n.this.ag = true;
                    return;
                }
                n.this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
                n.this.K.getClickCommon().click_scene = "endcard";
                n.this.H.a(com.sigmob.sdk.base.a.ENDCARD, n.this.g, true);
            }
        });
        a2.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.videoAd.n.16
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (n.this.A) {
                    if (TextUtils.isEmpty(n.this.K.getLanding_page()) || n.this.K.getInteractionType() == 2) {
                        n.this.K.setCustomLandPageUrl(str);
                    }
                    n.this.K.getClickCommon().click_area = "companion";
                    n.this.K.getClickCommon().click_scene = "endcard";
                    n.this.H.a(com.sigmob.sdk.base.a.ENDCARD, n.this.g, true);
                    SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j2 + "]");
                }
            }
        });
        a2.setAdUnit(this.K);
        a2.setWebViewClient(new com.sigmob.sdk.base.h() { // from class: com.sigmob.sdk.videoAd.n.17
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                SigmobLog.d("onPageFinished: ");
                n.this.v = "done";
            }

            @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                SigmobLog.d("onPageStarted: ");
            }

            @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                if (str2.startsWith("http://")) {
                    return;
                }
                n.this.v = "error";
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 21) {
                    String host = webResourceRequest.getUrl().getHost();
                    if (TextUtils.isEmpty(host) || !host.equals("localhost")) {
                        return;
                    }
                    n.this.v = "error";
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Uri parse;
                int i2;
                try {
                    SigmobLog.d("load url " + str);
                    parse = Uri.parse(str);
                    if (parse.getScheme().equalsIgnoreCase(parse.getScheme())) {
                        String host = parse.getHost();
                        if (!TextUtils.isEmpty(host)) {
                            if (!"track".equals(host) && !"active".equals(host)) {
                                if ("openFourElements".equals(host)) {
                                    n.this.b(2);
                                    return true;
                                }
                            }
                            String queryParameter = parse.getQueryParameter("data");
                            String queryParameter2 = parse.getQueryParameter("event");
                            if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                                final String str2 = new String(Base64.decode(queryParameter, 0), "utf-8");
                                ae.a(host, queryParameter2, n.this.K, new ae.a() { // from class: com.sigmob.sdk.videoAd.n.17.1
                                    @Override // com.sigmob.sdk.base.common.ae.a
                                    public void a(Object obj) {
                                        if (obj instanceof PointEntitySigmob) {
                                            ((PointEntitySigmob) obj).setUrl(str2);
                                        }
                                    }
                                });
                            }
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    SigmobLog.e("webview");
                }
                if (n.this.Z) {
                    return true;
                }
                if (n.this.K.getMaterial().disable_auto_deeplink.booleanValue() && !n.this.A) {
                    return TextUtils.isEmpty(str) || !str.startsWith("http");
                }
                if (n.this.K.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.l.Button.a() && !TextUtils.isEmpty(n.this.K.getLanding_page()) && n.this.K.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_EndCardURL.a()) {
                    return (n.this.K.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.l.FullScreen.a() || TextUtils.isEmpty(n.this.K.getLanding_page())) ? true : true;
                }
                n.this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                n.this.K.getClickCommon().click_scene = "endcard";
                if (n.this.P.getVisibility() != 0 || TextUtils.isEmpty(parse.getScheme()) || parse.getScheme().equals("http") || parse.getScheme().equals(BaseConstants.SCHEME_HTTPS)) {
                    if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals(BaseConstants.SCHEME_HTTPS))) {
                        if (n.this.ag) {
                            n.this.U();
                            n.this.ag = false;
                        }
                        webView.loadUrl(str);
                    }
                } else if (!StringUtil.scheme().equalsIgnoreCase(parse.getScheme()) || TextUtils.isEmpty(parse.getHost()) || !parse.getHost().equalsIgnoreCase("download") || TextUtils.isEmpty(n.this.K.getMaterial().landing_page)) {
                    try {
                        List<String> list = n.this.K.getAdSetting() != null ? n.this.K.getAdSetting().scheme_white_list : null;
                        if (list != null && list.size() > 0) {
                            while (i2 < list.size()) {
                                String str3 = list.get(i2);
                                i2 = (str.startsWith(str3) || str3.equals("*")) ? 0 : i2 + 1;
                                n.this.K.setCustomDeeplink(str);
                                n.this.H.a(com.sigmob.sdk.base.a.ENDCARD, n.this.g, true);
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    n.this.H.a(com.sigmob.sdk.base.a.ENDCARD, n.this.g, true);
                }
            }
        });
        iVar.a().a(a2);
        a2.a((o.a) null);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        sb.append('[');
        do {
            if (i2 != 0) {
                sb.append(',');
            }
            sb.append(list.get(i2));
            i2++;
        } while (i2 < list.size());
        sb.append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2) {
        try {
            new Thread(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.11
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap frameAtTime = n.this.N.getFrameAtTime(i2 * 1000, 2);
                    if (frameAtTime != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.q.setScaleType(ImageView.ScaleType.FIT_XY);
                                n.this.q.setImageBitmap(frameAtTime);
                            }
                        });
                    }
                }
            }).start();
        } catch (RuntimeException e) {
            SigmobLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        w wVar = this.Q;
        if (wVar == null || this.av) {
            return;
        }
        this.av = true;
        wVar.setText("跳过");
        this.Q.setEnabled(true);
        ValueAnimator duration = ValueAnimator.ofInt(Dips.dipsToIntPixels(22.0f, l()), Dips.dipsToIntPixels(45.0f, l())).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.videoAd.n.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) n.this.Q.getLayoutParams();
                layoutParams.width = intValue;
                n.this.Q.setLayoutParams(layoutParams);
                n.this.Q.invalidate();
            }
        });
        duration.start();
        this.Q.setVisibility(0);
        r().a(z, i2);
        r().a("show_skip", i2);
    }

    private void a(Context context, int i2) {
        if (this.ao == null) {
            w wVar = new w(context);
            this.ao = wVar;
            wVar.setText("反馈");
            this.ao.setId(ClientMetadata.generateViewId());
            this.ao.setOnClickListener(this.az);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int i3 = this.o;
            layoutParams.setMargins(i3, i3 * 2, 0, 0);
            m().addView(this.ao, layoutParams);
        }
        w wVar2 = this.ao;
        if (wVar2 != null) {
            wVar2.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.K.getClickCommon().click_scene = "ad";
        ClickAreaSetting clickAreaSetting = this.K.getClickAreaSetting();
        float floatValue = clickAreaSetting.left.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue2 = (1.0f - clickAreaSetting.right.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue3 = clickAreaSetting.top.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        float floatValue4 = (1.0f - clickAreaSetting.bottom.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        boolean z = true;
        if (floatValue >= motionEvent2.getRawX() || motionEvent2.getRawX() >= floatValue2 || floatValue3 >= motionEvent2.getRawY() || motionEvent2.getRawY() >= floatValue4) {
            z = false;
        } else {
            SigMacroCommon macroCommon = this.K.getMacroCommon();
            if (macroCommon instanceof SigMacroCommon) {
                macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf(((int) O()) * 100));
                macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
                this.g = macroCommon.getCoordinate();
            }
            if (this.R == null) {
                z();
            }
            this.H.a(com.sigmob.sdk.base.a.VIDEO_CLICK, this.g, true);
        }
        ae.a(this.K, motionEvent2, "useless_video_click", z);
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i2) {
        if (this.al == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(n(), this.K);
            this.al = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.videoAd.n.14
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    if (n.this.al != null) {
                        n.this.al.dismiss();
                        n.this.al.c();
                        n.this.al = null;
                        n.this.am = false;
                    }
                    if (n.this.J != null && i2 == 1) {
                        n.this.J.d();
                    }
                    if (n.this.ap != null) {
                        n.this.ap.a();
                    }
                    n.this.r().a(com.sigmob.sdk.base.common.a.g, (int) n.this.J.getCurrentPositionWhenPlaying());
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String str, String str2) {
                    if (n.this.R == null) {
                        n.this.z();
                    }
                    n.this.K.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    n.this.K.getClickCommon().click_scene = "appinfo";
                    n.this.H.a(com.sigmob.sdk.base.a.ENDCARD, str, str2, true);
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    if (n.this.J != null && i2 == 1) {
                        n.this.J.j();
                    }
                    if (n.this.ap != null) {
                        n.this.ap.b();
                    }
                    n.this.r().a(com.sigmob.sdk.base.common.a.f, (int) n.this.J.getCurrentPositionWhenPlaying());
                }
            });
        }
        com.sigmob.sdk.base.views.q qVar2 = this.al;
        if (qVar2 == null || !qVar2.a() || this.am) {
            return;
        }
        this.al.show();
        this.am = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, int i2) {
        if (this.K.getRewardStyle() == 1) {
            this.at = new w(context);
            int B = B();
            if (B > 0) {
                this.at.setText(B + "s后获取奖励");
            } else {
                this.at.setText("已获得奖励");
                b(false);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(97.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(1, this.ao.getId());
            int i3 = this.o;
            layoutParams.setMargins(i3, i3 * 2, 0, 0);
            m().addView(this.at, layoutParams);
        }
    }

    private void c(Context context, int i2) {
        if (this.an == null) {
            w wVar = new w(context);
            this.an = wVar;
            wVar.setText("反馈");
            this.an.setOnClickListener(this.az);
            this.an.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.P.getId());
            layoutParams.addRule(6, this.P.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.an, layoutParams);
        }
        w wVar2 = this.an;
        if (wVar2 != null) {
            wVar2.setVisibility(i2);
        }
    }

    private void c(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || !parse.getHost().equalsIgnoreCase("127.0.0.1")) {
            return;
        }
        Matcher matcher = Pattern.compile("/(.*)").matcher(parse.getPath());
        if (matcher.find()) {
            this.ay = matcher.group(1);
            com.sigmob.sdk.base.common.h.d().a(this, this.ay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.au || this.K.getAd_type() == 4) {
            return;
        }
        this.au = true;
        int y = z ? y() : (int) this.J.getCurrentPositionWhenPlaying();
        r().a("finish", y);
        this.H.c(l().getApplicationContext(), y, y(), a());
    }

    private com.sigmob.sdk.videoplayer.a d(Context context, int i2) {
        if (this.K.getProxyVideoUrl() == null) {
            throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
        }
        final com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(context);
        aVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.l() { // from class: com.sigmob.sdk.videoAd.n.27
            @Override // com.sigmob.sdk.videoplayer.l
            public void a(long j2, long j3) {
                int y = n.this.y();
                n.this.Q();
                if (n.this.C()) {
                    n.this.b(false);
                }
                if (n.this.u()) {
                    n.this.c(false);
                }
                int B = n.this.B();
                if (n.this.D != null) {
                    n.this.D.setduration(B);
                }
                if (n.this.af) {
                    n.this.O.a((int) n.this.J.getCurrentPositionWhenPlaying());
                }
                long j4 = y;
                if (1000 + j2 < j4) {
                    if (n.this.t()) {
                        n.this.A();
                    } else if (!n.this.av) {
                        n.this.Q.setText(String.valueOf((int) (((float) (j4 - n.this.J.getCurrentPositionWhenPlaying())) / 1000.0f)));
                    }
                }
                if (n.this.v()) {
                    n.this.w();
                }
                for (f fVar : n.this.H.a(j2, j4)) {
                    n.this.b(fVar.getEvent());
                    fVar.setTracked();
                }
                if (j2 > j4) {
                    n.this.a(true, false);
                }
            }

            @Override // com.sigmob.sdk.videoplayer.l
            public void a(com.sigmob.sdk.videoplayer.e eVar) {
                SigmobLog.i("video player state change " + eVar);
                int i3 = AnonymousClass20.a[eVar.ordinal()];
                if (i3 != 1) {
                    if (i3 == 3) {
                        n.this.z = "none";
                        n.this.a(true, false);
                        return;
                    }
                    if (i3 == 8) {
                        ae.a(PointCategory.VIDEO, aVar.getErrorCode(), aVar.getErrorMessage(), n.this.K);
                        n.this.a(false, true);
                        return;
                    } else if (i3 == 5) {
                        n.this.E();
                        aVar.j();
                        return;
                    } else {
                        if (i3 != 6) {
                            return;
                        }
                        n.this.F();
                        aVar.d();
                        return;
                    }
                }
                n.this.W = (int) aVar.getDuration();
                if (n.this.W == 0) {
                    n nVar = n.this;
                    nVar.W = nVar.K.getDuration();
                }
                if (!n.this.av) {
                    n.this.Q.setText(String.valueOf((int) (n.this.y() / 1000.0f)));
                    n.this.Q.setVisibility(0);
                }
                n nVar2 = n.this;
                nVar2.b(nVar2.l(), 0);
                aVar.getVideoWidth();
                aVar.getVideoHeight();
                if (n.this.R != null) {
                    n.this.R.a(n.this.y());
                }
                if (n.this.ab) {
                    n.this.aa.a(ResourceUtil.getDrawableId(n.this.l(), "sig_image_video_mute"));
                    n.this.J.setMute(true);
                }
                n.this.r().a(n.this.W, n.this.H.l());
                if (!n.this.U && (n.this.T == 0 || n.this.T == -1)) {
                    SigMacroCommon macroCommon = n.this.K.getMacroCommon();
                    if (macroCommon instanceof SigMacroCommon) {
                        macroCommon.addMarcoKey(SigMacroCommon._COMPLETED_, "0");
                        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(n.this.y() / 1000));
                    }
                }
                if (n.this.af) {
                    n.this.O.a(n.this.y(), 0);
                }
            }
        });
        String proxyVideoUrl = this.K.getProxyVideoUrl();
        try {
            if (!this.C) {
                new Thread(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (new File(n.this.K.getVideoPath()).exists()) {
                            n.this.N.setDataSource(n.this.K.getVideoPath());
                        } else {
                            n.this.N.setDataSource(n.this.K.getVideo_url(), new HashMap());
                        }
                    }
                }).start();
                this.q = b(context);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        aVar.setUp(proxyVideoUrl);
        c(proxyVideoUrl);
        aVar.setVisibility(i2);
        return aVar;
    }

    private void e(Context context, int i2) {
        aq aqVar = new aq(context);
        this.O = aqVar;
        aqVar.setAnchorId(this.J.getId());
        this.O.setVisibility(i2);
        m().addView(this.O);
    }

    private void f(Context context, int i2) {
        if (this.D != null) {
            return;
        }
        com.sigmob.sdk.base.views.d dVar = new com.sigmob.sdk.base.views.d(context, this.H.q());
        this.D = dVar;
        dVar.setVisibility(i2);
        m().addView(this.D);
        this.D.setDialogListener(new d.a() { // from class: com.sigmob.sdk.videoAd.n.4
            @Override // com.sigmob.sdk.base.views.d.a
            public void a() {
                if (!n.this.U) {
                    n.this.r().a("skip", (int) n.this.J.getCurrentPositionWhenPlaying());
                    n.this.H.b(((com.sigmob.sdk.base.common.j) n.this).b, (int) n.this.J.getCurrentPositionWhenPlaying(), n.this.y(), n.this.K);
                }
                n.this.D.setVisibility(8);
                if (n.this.ae != null && n.this.ae.getFourElementsLayout() != null) {
                    n.this.ae.getFourElementsLayout().setClickable(true);
                }
                if (n.this.H.m()) {
                    n.this.k().a();
                    return;
                }
                if (!n.this.C) {
                    n nVar = n.this;
                    nVar.a((int) nVar.J.getCurrentPositionWhenPlaying());
                }
                n.this.J.i();
                n.this.T();
                n.this.U = true;
                if (n.this.r() != null) {
                    n.this.M.a("show", 0);
                }
            }

            @Override // com.sigmob.sdk.base.views.d.a
            public void b() {
                n.this.J.d();
                n.this.D.setVisibility(8);
                if (n.this.ae == null || n.this.ae.getFourElementsLayout() == null) {
                    return;
                }
                n.this.ae.getFourElementsLayout().setClickable(true);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:11|12|13|(2:18|19)|22|(3:24|25|(20:27|28|29|30|(3:32|33|(2:35|36))|40|41|42|43|(1:45)(1:67)|46|47|(2:62|(1:64)(1:65))|51|52|(1:54)|55|(1:57)(1:61)|58|59))|74|29|30|(0)|40|41|42|43|(0)(0)|46|47|(1:49)|62|(0)(0)|51|52|(0)|55|(0)(0)|58|59) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fe, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00eb, code lost:
    
        r11 = r2;
        r12 = r5;
        r14 = -1;
        r16 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INSTALL_FROM_UNZIP;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #3 {all -> 0x00eb, blocks: (B:30:0x00ae, B:32:0x00b2), top: B:29:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: all -> 0x00fe, TRY_LEAVE, TryCatch #5 {all -> 0x00fe, blocks: (B:43:0x00f1, B:45:0x00f5), top: B:42:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(android.content.Context r23, int r24) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.n.g(android.content.Context, int):void");
    }

    private void h(Context context, int i2) {
        if (this.P == null) {
            ap apVar = new ap(context);
            this.P = apVar;
            apVar.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i3 = this.o;
            layoutParams.setMargins(i3, i3 * 2, i3, i3);
            m().addView(this.P, layoutParams);
            BaseAdUnit baseAdUnit = this.K;
            if (baseAdUnit != null && !TextUtils.isEmpty(baseAdUnit.getCloseCardHtmlData()) && !this.aA) {
                z zVar = new z(n(), this.K, this.H);
                this.aj = zVar;
                zVar.a(new z.a() { // from class: com.sigmob.sdk.videoAd.n.7
                    @Override // com.sigmob.sdk.base.views.z.a
                    public void a() {
                        if (n.this.aj != null) {
                            n.this.aj.dismiss();
                            n.this.aj.c();
                            n.this.aj = null;
                        }
                        n.this.Z = true;
                        n.this.H.b(n.this.l(), n.this.y(), n.this.K);
                        n.this.k().a();
                    }
                });
            }
            this.P.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.n.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        if (n.this.aA || n.this.aj == null || n.this.aj.a() || n.this.ak) {
                            n.this.Z = true;
                            n.this.H.b(n.this.l(), n.this.y(), n.this.K);
                            n.this.k().a();
                        } else {
                            n.this.aj.show();
                            n.this.ak = true;
                        }
                    }
                    return true;
                }
            });
            this.P.a(this.K);
            String f2 = this.H.f();
            if (f2 != null) {
                this.P.a(f2);
            }
        }
        ap apVar2 = this.P;
        if (apVar2 != null) {
            apVar2.setVisibility(i2);
        }
        c(l(), i2);
    }

    private void i(Context context, int i2) {
        w wVar = new w(context);
        this.Q = wVar;
        wVar.setId(ClientMetadata.generateViewId());
        this.Q.setVisibility(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        ap apVar = this.aa;
        if (apVar != null) {
            layoutParams.addRule(0, apVar.getId());
            layoutParams.setMargins(0, this.o * 2, 0, 0);
        }
        m().addView(this.Q, layoutParams);
        this.Q.setEnabled(false);
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.videoAd.n.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.r().a(com.sigmob.sdk.base.common.a.v, (int) n.this.J.getCurrentPositionWhenPlaying());
                if (n.this.C()) {
                    n.this.b(false);
                }
                if (n.this.ac || n.this.K.getConfirmDialog() == 2 || n.this.K.getAd_type() == 4) {
                    n.this.r().a("skip", (int) n.this.J.getCurrentPositionWhenPlaying());
                    n.this.H.b(((com.sigmob.sdk.base.common.j) n.this).b, (int) n.this.J.getCurrentPositionWhenPlaying(), n.this.y(), n.this.K);
                    n.this.a(false, false);
                    return;
                }
                n.this.J.j();
                SigmobLog.i("videoView.pause()");
                n.this.D.setduration(n.this.B());
                n.this.D.setVisibility(0);
                if (n.this.ae == null || n.this.ae.getFourElementsLayout() == null) {
                    return;
                }
                n.this.ae.getFourElementsLayout().setClickable(false);
            }
        });
        if ((this.K.getSkipPercent() != 0 || this.K.getSkipSeconds() >= 0) && this.K.getSkipSeconds() != 0) {
            return;
        }
        a(0, false);
    }

    private void j(Context context, int i2) {
        ap apVar = new ap(context);
        this.aa = apVar;
        apVar.setId(ClientMetadata.generateViewId());
        this.aa.setVisibility(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(4, this.ao.getId());
        layoutParams.addRule(11);
        int i3 = this.o;
        layoutParams.setMargins(i3, i3 * 2, i3, 0);
        m().addView(this.aa, layoutParams);
        this.aa.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.n.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (n.this.ab) {
                        n.this.r().a(com.sigmob.sdk.base.common.a.E, (int) n.this.J.getCurrentPositionWhenPlaying());
                        n.this.aa.a(ResourceUtil.getDrawableId(n.this.l(), "sig_image_video_unmute"));
                        n.this.J.setMute(false);
                    } else {
                        n.this.r().a(com.sigmob.sdk.base.common.a.D, (int) n.this.J.getCurrentPositionWhenPlaying());
                        n.this.aa.a(ResourceUtil.getDrawableId(n.this.l(), "sig_image_video_mute"));
                        n.this.J.setMute(true);
                    }
                    n.this.ab = !r3.ab;
                }
                return true;
            }
        });
        if (this.K.getIsMute() == 0) {
            this.aa.a(ResourceUtil.getDrawableId(l(), "sig_image_video_unmute"));
        } else {
            this.aa.a(ResourceUtil.getDrawableId(l(), "sig_image_video_mute"));
            this.J.setMute(true);
            this.ab = true;
        }
    }

    public static int p() {
        return 0;
    }

    void A() {
        if (this.K.getMaterial().disable_auto_deeplink.booleanValue()) {
            z();
        }
        a((int) this.J.getCurrentPositionWhenPlaying(), false);
        int B = B();
        com.sigmob.sdk.base.views.d dVar = this.D;
        if (dVar != null) {
            dVar.setduration(B);
        }
    }

    int B() {
        try {
            int rewardSeconds = this.K.getRewardSeconds();
            if (rewardSeconds > -1) {
                if (y() > 0 && rewardSeconds * 1000 > y()) {
                    rewardSeconds = (int) (y() / 1000.0f);
                }
                return (int) (rewardSeconds - (((float) this.J.getCurrentPositionWhenPlaying()) / 1000.0f));
            }
            if (y() <= 0) {
                return -1;
            }
            return (int) (((y() / 1000.0f) * (this.K.getRewardPercent() * 0.01d)) - (((float) this.J.getCurrentPositionWhenPlaying()) / 1000.0f));
        } catch (Throwable unused) {
            return -1;
        }
    }

    boolean C() {
        return B() <= 0;
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public BaseAdUnit a() {
        return this.K;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            k().a();
        }
    }

    public void a(Context context) {
        this.Y = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(s.LOADING.a());
        imageView.setId(ClientMetadata.generateViewId());
        RotateAnimation rotateAnimation = new RotateAnimation(com.sigmob.sdk.base.blurkit.c.d, BaseConstants.Time.HOUR, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setAnimation(rotateAnimation);
        this.Y.addView(imageView, layoutParams);
        this.Y.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        m().addView(this.Y, layoutParams2);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        if (this.H != null && this.R == null) {
            i g = com.sigmob.sdk.videoAd.a.g(this.K);
            this.R = g;
            g.a(this.H);
        }
        if (r() != null) {
            r().a(com.sigmob.sdk.base.common.a.F, (int) this.J.getCurrentPositionWhenPlaying());
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
        try {
            bundle.putBoolean(i, this.U);
            bundle.putInt(h, this.T);
            bundle.putBoolean(j, this.X);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getUuid().equals(this.K.getUuid()) && baseAdUnit.isEndCardIndexExist()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.videoAd.n.19
                @Override // java.lang.Runnable
                public void run() {
                    n.this.z();
                }
            });
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i2) {
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th) {
        SigmobLog.e("url", th);
        ae.a(PointCategory.VIDEO, 0, th.getMessage(), this.K);
        a(false, true);
    }

    @Override // com.sigmob.sdk.base.common.ac
    public void a(boolean z, com.sigmob.sdk.base.a aVar) {
        t r;
        int currentPositionWhenPlaying;
        String str;
        this.aA = true;
        U();
        if (z) {
            int i2 = AnonymousClass20.b[aVar.ordinal()];
            if (i2 == 1) {
                ClickCommon clickCommon = this.K.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.COMPANION, "click", this.K, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.w;
            } else if (i2 == 2) {
                ClickCommon clickCommon2 = this.K.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.K, clickCommon2.isDeeplink, clickCommon2.clickUrl, clickCommon2.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
                str = "full_video_click";
            } else if (i2 != 3) {
                ClickCommon clickCommon3 = this.K.getClickCommon();
                ae.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.K, clickCommon3.isDeeplink, clickCommon3.clickUrl, clickCommon3.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
                str = "click";
            } else {
                r = r();
                currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.k;
            }
            r.a(str, currentPositionWhenPlaying);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.ax) {
            return;
        }
        this.ax = true;
        F();
        boolean videoErrorReward = this.K.getVideoErrorReward();
        c(z);
        if (z || (z2 && videoErrorReward)) {
            b(z);
            if (z) {
                x();
            }
        } else if (this.H.m()) {
            k().a();
            return;
        }
        if (!this.C) {
            if (z) {
                S();
            } else {
                a((int) this.J.getCurrentPositionWhenPlaying());
            }
        }
        this.J.i();
        T();
        this.U = true;
        if (r() != null) {
            this.M.a("show", 0);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public void b(BaseAdUnit baseAdUnit) {
    }

    void b(String str) {
        if ("start".equals(str)) {
            a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
        }
        if (r() != null) {
            r().a(str, (int) this.J.getCurrentPositionWhenPlaying());
        }
    }

    void b(boolean z) {
        if (this.K.getAd_type() == 4 || this.ac) {
            return;
        }
        this.ac = true;
        int y = z ? y() : (int) this.J.getCurrentPositionWhenPlaying();
        a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        r().a("reward", y);
        this.H.c(l().getApplicationContext(), y, y(), a());
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        MaterialMeta material = this.K.getMaterial();
        this.s = ClientMetadata.getInstance().getInsetBottom();
        if (this.X) {
            T();
        } else {
            if (this.H == null) {
                throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
            }
            if (this.af) {
                e(l(), 4);
            }
            Boolean bool = material.has_companion_endcard;
            if (bool != null && bool.booleanValue() && material.companion != null) {
                g(l(), 4);
                this.F = material.companion.show_delay_secs.intValue();
            }
            a(l(), 0);
            j(l(), 0);
            i(l(), 4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f("start", com.sigmob.sdk.base.blurkit.c.d));
            arrayList.add(new f("play_quarter", 0.25f));
            arrayList.add(new f("play_two_quarters", 0.5f));
            arrayList.add(new f("play_three_quarters", 0.75f));
            this.H.a(arrayList);
            a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        f(l(), 4);
        G();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (this.Z) {
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            return;
        }
        aa.a aVar = this.ap;
        if (aVar != null) {
            aVar.b();
            v vVar = this.aq;
            if (vVar != null) {
                vVar.b();
            }
        }
        if (this.X) {
            return;
        }
        N();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        aa.a aVar;
        if (!this.X && this.as == null) {
            M();
        }
        View view = this.L;
        if (view != null && (view instanceof com.sigmob.sdk.base.views.o)) {
            ((com.sigmob.sdk.base.views.o) view).resumeTimers();
        }
        this.ar = false;
        if (this.as != null || (aVar = this.ap) == null) {
            return;
        }
        aVar.a();
        v vVar = this.aq;
        if (vVar != null) {
            vVar.a();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        try {
            SigmobLog.d("VideoViewController onDestroy() called");
            com.sigmob.sdk.base.common.h.g().b(this);
            if (!this.Z) {
                a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            }
            if (this.ay != null) {
                com.sigmob.sdk.base.common.h.d().b(this, this.ay);
            }
            w wVar = this.ao;
            if (wVar != null) {
                wVar.setOnClickListener(null);
                ViewUtil.removeFromParent(this.ao);
            }
            w wVar2 = this.an;
            if (wVar2 != null) {
                wVar2.setOnClickListener(null);
                ViewUtil.removeFromParent(this.an);
            }
            com.sigmob.sdk.nativead.a aVar = this.as;
            if (aVar != null) {
                aVar.a((WindNativeAdData.DislikeInteractionCallback) null);
                this.as.dismiss();
                this.as.b();
            }
            this.H.k();
            ImageLoader.ImageContainer imageContainer = this.ad;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.ad = null;
            }
            t tVar = this.M;
            if (tVar != null) {
                tVar.a();
                this.M = null;
            }
            i iVar = this.R;
            if (iVar != null) {
                iVar.a((i.a) null);
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.N;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            ap apVar = this.P;
            if (apVar != null) {
                apVar.setOnTouchListener(null);
            }
            w wVar3 = this.Q;
            if (wVar3 != null) {
                wVar3.setOnTouchListener(null);
            }
            ap apVar2 = this.aa;
            if (apVar2 != null) {
                apVar2.setOnTouchListener(null);
            }
            com.sigmob.sdk.videoplayer.a aVar2 = this.J;
            if (aVar2 != null) {
                aVar2.r();
            }
            View view = this.L;
            if (view != null && (view instanceof com.sigmob.sdk.base.views.o)) {
                ((com.sigmob.sdk.base.views.o) view).setWebViewClickListener(null);
                ((com.sigmob.sdk.base.views.o) this.L).setLogoClickListener(null);
            }
            z zVar = this.aj;
            if (zVar != null) {
                zVar.dismiss();
                this.aj.c();
                this.aj = null;
            }
            aa.a aVar3 = this.ap;
            if (aVar3 != null) {
                aVar3.c();
                this.ap = null;
            }
            BaseAdUnit baseAdUnit = this.K;
            if (baseAdUnit != null) {
                baseAdUnit.destroy();
            }
            this.L = null;
            this.O = null;
            super.h();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
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

    public void q() {
        com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(l().getApplicationContext(), 0);
        this.p = bVar;
        bVar.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, l()));
        com.sigmob.sdk.base.views.m mVar = this.ae;
        if (mVar != null) {
            layoutParams.addRule(8, mVar.getId());
        } else {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, this.o);
        }
        try {
            this.p.a(this.K.getAd_source_logo());
            if (!this.K.getInvisibleAdLabel()) {
                this.p.b(com.sigmob.sdk.base.g.h());
            }
        } catch (Throwable unused) {
        }
        m().addView(this.p, layoutParams);
    }

    public t r() {
        if (this.M == null) {
            t tVar = new t();
            this.M = tVar;
            tVar.a(a());
        }
        return this.M;
    }

    public String s() {
        return this.E;
    }

    public boolean t() {
        long currentPositionWhenPlaying;
        try {
            currentPositionWhenPlaying = (int) this.J.getCurrentPositionWhenPlaying();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        if (this.K.getSkipSeconds() > -1) {
            return (((float) currentPositionWhenPlaying) / 1000.0f) + 0.3f >= ((float) this.K.getSkipSeconds());
        }
        if (y() > 0) {
            return ((((float) y()) / 1000.0f) * ((float) this.K.getSkipPercent())) * 0.01f < ((float) currentPositionWhenPlaying) / 1000.0f;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (((r3 * 100) / y()) >= r7.K.getChargePercent()) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean u() {
        /*
            r7 = this;
            r0 = 1
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.K     // Catch: java.lang.Throwable -> L4f
            int r1 = r1.getAd_type()     // Catch: java.lang.Throwable -> L4f
            r2 = 0
            if (r1 != r0) goto L4e
            com.sigmob.sdk.videoplayer.a r1 = r7.J     // Catch: java.lang.Throwable -> L4f
            long r3 = r1.getCurrentPositionWhenPlaying()     // Catch: java.lang.Throwable -> L4f
            int r1 = (int) r3     // Catch: java.lang.Throwable -> L4f
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L4f
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.K     // Catch: java.lang.Throwable -> L4f
            int r1 = r1.getChargeSeconds()     // Catch: java.lang.Throwable -> L4f
            r5 = -1
            if (r1 <= r5) goto L32
            float r1 = (float) r3     // Catch: java.lang.Throwable -> L4f
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r3
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r1 = r1 + r3
            com.sigmob.sdk.base.models.BaseAdUnit r3 = r7.K     // Catch: java.lang.Throwable -> L4f
            int r3 = r3.getChargeSeconds()     // Catch: java.lang.Throwable -> L4f
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L4f
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L2f
            goto L30
        L2f:
            r0 = 0
        L30:
            r2 = r0
            goto L4e
        L32:
            int r1 = r7.y()     // Catch: java.lang.Throwable -> L4f
            if (r1 <= 0) goto L4e
            r5 = 100
            long r3 = r3 * r5
            int r1 = r7.y()     // Catch: java.lang.Throwable -> L4f
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L4f
            long r3 = r3 / r5
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.K     // Catch: java.lang.Throwable -> L4f
            int r1 = r1.getChargePercent()     // Catch: java.lang.Throwable -> L4f
            long r5 = (long) r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L2f
            goto L30
        L4e:
            return r2
        L4f:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.n.u():boolean");
    }

    public boolean v() {
        com.sigmob.sdk.base.views.m mVar = this.ae;
        if (mVar != null && mVar.a()) {
            return true;
        }
        try {
            boolean z = ((long) ((int) this.J.getCurrentPositionWhenPlaying())) / 1000 >= ((long) this.F);
            if (z) {
                SigmobLog.d("showAble CompanionAds");
            }
            return z;
        } catch (Throwable th) {
            SigmobLog.e("shouldBeShowCompanionAds", th);
            return true;
        }
    }

    public void w() {
        com.sigmob.sdk.base.views.m mVar;
        if (this.G || (mVar = this.ae) == null) {
            return;
        }
        mVar.setVisibility(0);
        this.G = true;
    }

    public void x() {
        if (this.aw) {
            return;
        }
        this.aw = true;
        this.K.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        if (this.V) {
            return;
        }
        r().a("complete", (int) this.J.getCurrentPositionWhenPlaying());
    }

    int y() {
        com.sigmob.sdk.videoplayer.a aVar = this.J;
        if (aVar == null) {
            return 0;
        }
        int i2 = this.W;
        return i2 > 0 ? this.H.b(i2) : this.H.b((int) aVar.getDuration());
    }

    void z() {
        if (this.L == null && this.K.isEndCardIndexExist()) {
            try {
                i g = com.sigmob.sdk.videoAd.a.g(this.K);
                this.R = g;
                g.a(this.H);
                this.L = a(n(), this.R, 4);
                this.R.a(y());
                h(l(), 4);
            } catch (Throwable th) {
                this.R = null;
                SigmobLog.e(th.getMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("error", th.getMessage());
                a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
                this.d.a();
            }
        }
    }
}
