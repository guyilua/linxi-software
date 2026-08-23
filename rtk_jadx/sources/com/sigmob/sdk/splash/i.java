package com.sigmob.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.ac;
import com.sigmob.sdk.base.views.ae;
import com.sigmob.sdk.base.views.ai;
import com.sigmob.sdk.base.views.ak;
import com.sigmob.sdk.base.views.ao;
import com.sigmob.sdk.base.views.au;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.x;
import com.sigmob.windad.WindAdError;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class i extends RelativeLayout {
    private static float a = 25.0f;
    private static float b = 13.0f;

    /* renamed from: c, reason: collision with root package name */
    private final RelativeLayout f646c;
    private d d;
    private Context e;
    private BaseAdUnit f;
    private c g;
    private String h;
    private boolean i;
    private RelativeLayout j;
    private RelativeLayout k;
    private View.OnTouchListener l;
    private float m;
    private volatile boolean n;
    private boolean o;
    private boolean p;
    private ae q;
    private aa.a r;
    private k s;
    private v t;
    private boolean u;
    private float v;

    /* renamed from: com.sigmob.sdk.splash.i$5, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[am.values().length];
            a = iArr;
            try {
                iArr[am.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[am.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[am.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[am.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[am.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[am.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[am.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[am.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public i(Context context) {
        super(context);
        this.m = 1.0f;
        Context applicationContext = context.getApplicationContext();
        this.e = applicationContext;
        RelativeLayout relativeLayout = new RelativeLayout(applicationContext);
        this.f646c = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(Activity activity) {
        boolean c2 = com.sigmob.sdk.videoplayer.d.c(activity);
        boolean f = com.sigmob.sdk.videoplayer.d.f(activity);
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, getContext());
        int l = (c2 && f) ? com.sigmob.sdk.videoplayer.d.l(activity) : dipsToIntPixels * 2;
        int dipsToIntPixels2 = Dips.dipsToIntPixels(68.0f, getContext());
        int dipsToIntPixels3 = Dips.dipsToIntPixels(25.0f, getContext());
        ae aeVar = new ae(getContext());
        this.q = aeVar;
        aeVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels2, dipsToIntPixels3);
        layoutParams.addRule(11);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.splash.i.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.u = true;
                if (i.this.f == null) {
                    return;
                }
                ag sessionManager = i.this.f.getSessionManager();
                if (sessionManager != null) {
                    sessionManager.a("skip", 0);
                }
                BaseBroadcastReceiver.a(i.this.e, i.this.f.getUuid(), IntentActions.ACTION_SPLAH_SKIP);
            }
        });
        layoutParams.setMargins(0, l, dipsToIntPixels, 0);
        addView(this.q, layoutParams);
    }

    private void a(Context context) {
        d a2 = d.a(context, this.f);
        this.d = a2;
        a2.setAspectRatio(this.v);
        this.f646c.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        this.k = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dipsToIntPixels = Dips.dipsToIntPixels(a, this.e);
        layoutParams.setMargins(dipsToIntPixels, (int) (dipsToIntPixels * 2.5d), dipsToIntPixels, dipsToIntPixels);
        this.k.setClickable(true);
        this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.i.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f646c.addView(this.k, layoutParams);
        this.l = new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.i.7
            private MotionEvent b;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (i.this.f == null) {
                    SigmobLog.e("adUnit is null");
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    this.b = MotionEvent.obtain(motionEvent);
                } else if (motionEvent.getAction() == 1) {
                    if (this.b == null) {
                        this.b = motionEvent;
                    }
                    try {
                        i.this.f.getClickCommon().sld = "0";
                        i.this.f.getClickCommon().click_area = "companion";
                        i.this.f.getClickCommon().click_scene = "ad";
                        i.this.f.getMacroCommon().updateClickMarco(this.b, motionEvent, false);
                    } catch (Throwable th) {
                        SigmobLog.e("splash click macro set " + th.getMessage());
                    }
                    i.this.a((String) null);
                }
                return true;
            }
        };
    }

    private void a(final BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("handleUrlAction: ");
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null");
        } else {
            new an.a().a(am.IGNORE_ABOUT_SCHEME, am.DOWNLOAD_APK, am.MARKET_SCHEME, am.OPEN_WITH_BROWSER, am.FOLLOW_PACKAGE_NAME, am.FOLLOW_DEEP_LINK, am.MINI_PROGRAM).a(new an.b() { // from class: com.sigmob.sdk.splash.i.8
                @Override // com.sigmob.sdk.base.common.an.b
                public void a(final String str2, am amVar) {
                    SigmobLog.i("urlHandlingSucceeded: " + amVar.name() + " url: " + str2);
                    if (i.this.f == null) {
                        SigmobLog.e("adUnit is null");
                        return;
                    }
                    i.this.f.getClickCommon().is_final_click = true;
                    if (!baseAdUnit.getAd().forbiden_parse_landingpage.booleanValue()) {
                        com.sigmob.sdk.base.common.ae.a(baseAdUnit, amVar.name(), str2);
                    }
                    BaseBroadcastReceiver.a(i.this.e, i.this.f.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
                    int i = AnonymousClass5.a[amVar.ordinal()];
                    if (i == 3) {
                        Log.d("lance", "打开小程序成功:" + amVar);
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "open_deeplink");
                        com.sigmob.sdk.base.common.ae.a("open_deeplink", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.splash.i.8.1
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str2);
                                    if (i.this.f.getInteractionType() == 8) {
                                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.b.a());
                                    }
                                }
                            }
                        });
                    } else if (i == 5) {
                        AndroidMarket androidMarket = i.this.f.getAndroidMarket();
                        if (androidMarket != null) {
                            com.sigmob.sdk.base.common.ae.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? BaseConstants.SCHEME_MARKET : "mimarket", i.this.f);
                            if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                                try {
                                    FileUtil.writeToCache(i.this.f, new File(com.sigmob.sdk.base.utils.e.g(), androidMarket.app_package_name + ".log").getAbsolutePath());
                                } catch (Throwable th) {
                                    SigmobLog.e("write ad info with package error " + th.getMessage());
                                }
                            }
                        }
                        com.sigmob.sdk.base.common.ae.a(PointCategory.OPEN_MARKET, (String) null, i.this.f, new ae.a() { // from class: com.sigmob.sdk.splash.i.8.2
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str2);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("app_package_name", i.this.f.getAndroidMarket().app_package_name);
                                    hashMap.put("store_package_name", i.this.f.getAndroidMarket().appstore_package_name);
                                    pointEntitySigmob.setOptions(hashMap);
                                }
                            }
                        });
                    } else if (i == 6) {
                        if (i.this.g.j()) {
                            i.this.f.getClickCommon().is_final_click = false;
                        } else {
                            i.this.a(true);
                            i.this.g.f(str2);
                        }
                    }
                    ag sessionManager = baseAdUnit.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a("click", 0);
                    }
                }

                @Override // com.sigmob.sdk.base.common.an.b
                public void b(final String str2, am amVar) {
                    SigmobLog.i("urlHandlingFailed: " + amVar.name() + " url: " + str2);
                    if (i.this.f == null) {
                        return;
                    }
                    i.this.f.getClickCommon().is_final_click = true;
                    int i = AnonymousClass5.a[amVar.ordinal()];
                    if (i == 3 || i == 4) {
                        Log.d("lance", "打开小程序失败:" + amVar);
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "open_deeplink_failed");
                        com.sigmob.sdk.base.common.ae.a("open_deeplink_failed", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.splash.i.8.3
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str2);
                                    if (i.this.f.getInteractionType() == 8) {
                                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.b.a());
                                    }
                                }
                            }
                        });
                        return;
                    }
                    if (i == 5) {
                        com.sigmob.sdk.base.common.ae.a(PointCategory.OPEN_MARKET_FAILED, (String) null, i.this.f, new ae.a() { // from class: com.sigmob.sdk.splash.i.8.4
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str2);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("app_package_name", i.this.f.getAndroidMarket().app_package_name);
                                    hashMap.put("store_package_name", i.this.f.getAndroidMarket().appstore_package_name);
                                    pointEntitySigmob.setOptions(hashMap);
                                }
                            }
                        });
                        return;
                    }
                    if (i != 8) {
                        return;
                    }
                    if (!baseAdUnit.getAd().forbiden_parse_landingpage.booleanValue()) {
                        com.sigmob.sdk.base.common.ae.a(baseAdUnit, amVar.name(), str2);
                    }
                    i.this.f.getClickCommon().is_final_click = true;
                    ag sessionManager = baseAdUnit.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a("click", 0);
                    }
                }
            }).a(baseAdUnit.isSkipSigmobBrowser()).a(baseAdUnit).b(baseAdUnit.getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        SigmobLog.d("handleClick: ");
        if (this.f == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        this.n = true;
        if (com.sigmob.sdk.b.h() == null) {
            com.sigmob.sdk.b.a(com.sigmob.sdk.base.utils.f.c(this));
        }
        a(this.f, str);
    }

    private void a(String str, String str2) {
        ao aoVar = new ao(getContext());
        aoVar.setTitle(str);
        aoVar.setDescription(str2);
        int dipsToIntPixels = Dips.dipsToIntPixels(82.0f, getContext());
        if (this.f.getClickType() == 1) {
            aoVar.setOnTouchListener(this.l);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels);
        addView(aoVar, layoutParams);
    }

    private void f() {
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, getContext());
        Dips.dipsToIntPixels(75.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, getContext());
        TextView textView = new TextView(getContext());
        textView.setText("互动广告");
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ccffffff"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dipsToIntPixels2);
        layoutParams.addRule(0, this.q.getId());
        layoutParams.addRule(6, this.q.getId());
        layoutParams.setMargins(0, 0, dipsToIntPixels, 0);
        addView(textView, layoutParams);
    }

    private void g() {
        this.t = new ac(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.t.setOnTouchListener(this.l);
        }
        aa.e eVar = new aa.e(getContext(), new aa.b() { // from class: com.sigmob.sdk.splash.i.10
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || i.this.f == null || i.this.n) {
                    return;
                }
                i.this.n = true;
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                i.this.f.getClickCommon().sld = "2";
                i.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
                i.this.f.getClickCommon().click_scene = "ad";
                if (number != null) {
                    i.this.f.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    i.this.f.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    i.this.f.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                i.this.t.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.i.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.a((String) null);
                    }
                }, 400L);
            }
        });
        this.r = eVar;
        eVar.a(this.f.getSensitivity());
        this.r.a();
        addView(this.t, layoutParams);
    }

    private void h() {
        this.t = new ak(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.t.setOnTouchListener(this.l);
        }
        aa.c cVar = new aa.c(getContext(), new aa.b() { // from class: com.sigmob.sdk.splash.i.11
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f) {
                if (i.this.t instanceof ak) {
                    ((ak) i.this.t).a(f);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || i.this.f == null || i.this.n) {
                    return;
                }
                i.this.n = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    i.this.f.getClickCommon().turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    i.this.f.getClickCommon().turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    i.this.f.getClickCommon().turn_z = String.valueOf(number3.intValue());
                }
                i.this.f.getClickCommon().turn_time = String.valueOf(number4);
                i.this.f.getClickCommon().sld = "5";
                i.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
                i.this.f.getClickCommon().click_scene = "ad";
                i.this.t.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.i.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.a((String) null);
                    }
                }, 400L);
            }
        }, aa.d.SLOPE);
        this.r = cVar;
        cVar.a(this.f.getSensitivity());
        this.r.a();
        addView(this.t, layoutParams);
    }

    private void i() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.splash.i.12
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                i.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (i.this.f != null) {
                    i.this.getLocationOnScreen(new int[2]);
                    i.this.f.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r0[0], i.this.getContext()));
                    i.this.f.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r0[1], i.this.getContext()));
                    i.this.f.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(i.this.getWidth(), i.this.getContext()));
                    i.this.f.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(i.this.getHeight(), i.this.getContext()));
                }
            }
        });
    }

    private void j() {
        this.t = new com.sigmob.sdk.base.views.an(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.t.setOnTouchListener(this.l);
        }
        aa.c cVar = new aa.c(getContext(), new aa.b() { // from class: com.sigmob.sdk.splash.i.13
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f) {
                if (i.this.t instanceof com.sigmob.sdk.base.views.an) {
                    ((com.sigmob.sdk.base.views.an) i.this.t).a(f);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || i.this.f == null || i.this.n) {
                    return;
                }
                i.this.n = true;
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null) {
                    i.this.f.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    i.this.f.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    i.this.f.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                i.this.f.getClickCommon().sld = "2";
                i.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
                i.this.f.getClickCommon().click_scene = "ad";
                i.this.t.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.i.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.a((String) null);
                    }
                }, 400L);
            }
        }, aa.d.SWING);
        this.r = cVar;
        cVar.a(this.f.getSensitivity());
        this.r.a();
        addView(this.t, layoutParams);
    }

    private void k() {
        View aiVar = new ai(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        if (this.f.getClickType() == 1) {
            aiVar.setOnTouchListener(this.l);
        }
        int i = 50;
        int sensitivity = this.f.getSensitivity();
        if (sensitivity == 10) {
            i = 0;
        } else if (sensitivity > 0 && sensitivity < 10) {
            i = ((10 - sensitivity) + 1) * 10;
        }
        final int dipsToIntPixels2 = Dips.dipsToIntPixels(i, com.sigmob.sdk.b.e());
        this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.i.2

            /* renamed from: c, reason: collision with root package name */
            private MotionEvent f647c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (i.this.f == null) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    this.f647c = MotionEvent.obtain(motionEvent);
                    i.this.n = false;
                } else {
                    if ((motionEvent.getAction() != 2 && motionEvent.getAction() != 1) || i.this.n) {
                        return true;
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (((float) Math.sqrt(Math.pow(Math.abs(x - this.f647c.getX()), 2.0d) + Math.pow(Math.abs(y - this.f647c.getY()), 2.0d))) >= dipsToIntPixels2) {
                        i.this.n = true;
                        SigMacroCommon macroCommon = i.this.f.getMacroCommon();
                        if (macroCommon != null) {
                            macroCommon.updateClickMarco(this.f647c, motionEvent, false);
                        }
                        i.this.a((String) null);
                    }
                }
                return true;
            }
        });
        int dipsToIntPixels3 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels3);
        addView(aiVar, layoutParams);
    }

    private void l() {
        com.sigmob.sdk.base.views.aa aaVar = new com.sigmob.sdk.base.views.aa(getContext());
        aaVar.setButtonColor(this.f.getButtonColor());
        aaVar.a(this.f.getDesc(), null);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        aaVar.setOnTouchListener(this.l);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(100.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(aaVar, layoutParams);
    }

    private void m() {
        com.sigmob.sdk.base.views.ag agVar = new com.sigmob.sdk.base.views.ag(getContext());
        String title = this.f.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击查看详情";
        }
        agVar.a(title, this.f.getDesc());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, getContext());
        agVar.setOnTouchListener(this.l);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(100.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels3);
        addView(agVar, layoutParams);
    }

    private void n() {
        com.sigmob.sdk.base.views.i iVar = new com.sigmob.sdk.base.views.i(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(183.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(iVar, layoutParams);
        iVar.setOnTouchListener(this.l);
        String title = this.f.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击前往";
        }
        ao aoVar = new ao(getContext());
        aoVar.setTitle(title);
        aoVar.setDescription(this.f.getDesc());
        aoVar.setOnTouchListener(this.l);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(aoVar, layoutParams2);
    }

    private void o() {
        x xVar = new x(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, getContext());
        boolean z = this.f.getadPrivacy() != null;
        if (z) {
            xVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.i.3
                private MotionEvent b;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (i.this.f == null) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        this.b = MotionEvent.obtain(motionEvent);
                    } else if (motionEvent.getAction() == 1) {
                        i.this.f.getClickCommon().click_area = "appinfo";
                        i.this.f.getClickCommon().click_scene = "ad";
                        if (this.b == null) {
                            this.b = motionEvent;
                        }
                        try {
                            i.this.f.getMacroCommon().updateClickMarco(this.b, motionEvent, false);
                        } catch (Throwable th) {
                            SigmobLog.e("splash click macro set " + th.getMessage());
                        }
                        i.this.g.i();
                    }
                    return true;
                }
            });
        }
        xVar.a(this.f.getAd_source_logo(), z);
        xVar.setAlpha(0.5f);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(5.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels2);
        addView(xVar, layoutParams);
    }

    private void p() {
        final au auVar = new au(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            auVar.setOnTouchListener(this.l);
        }
        aa.c cVar = new aa.c(getContext(), new aa.b() { // from class: com.sigmob.sdk.splash.i.4
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map == null || i.this.f == null || i.this.n) {
                    return;
                }
                i.this.n = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    i.this.f.getClickCommon().turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    i.this.f.getClickCommon().turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    i.this.f.getClickCommon().turn_z = String.valueOf(number3.intValue());
                }
                i.this.f.getClickCommon().turn_time = String.valueOf(number4);
                i.this.f.getClickCommon().sld = "5";
                i.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
                i.this.f.getClickCommon().click_scene = "ad";
                auVar.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.i.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.a((String) null);
                    }
                }, 400L);
            }
        }, aa.d.WRING);
        this.r = cVar;
        cVar.a(this.f.getSensitivity());
        this.r.a();
        addView(auVar, layoutParams);
    }

    protected void a() {
        super.setVisibility(8);
        d dVar = this.d;
        if (dVar != null) {
            dVar.setVisibility(8);
        }
    }

    void a(boolean z) {
        if (z) {
            BaseBroadcastReceiver.a(this.e, this.f.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
            this.q.setOnClickListener(null);
            com.sigmob.sdk.base.common.h.b(this.f);
            this.f = null;
        }
        aa.a aVar = this.r;
        if (aVar != null) {
            aVar.c();
            this.r = null;
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.b();
        }
        this.d.setOnTouchListener(null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0122 A[Catch: all -> 0x012e, TryCatch #0 {all -> 0x012e, blocks: (B:3:0x0001, B:7:0x012a, B:10:0x0035, B:11:0x011e, B:13:0x0122, B:14:0x0125, B:16:0x0052, B:17:0x006f, B:18:0x008c, B:21:0x009e, B:22:0x00be, B:23:0x00c2, B:26:0x00d4, B:27:0x00d9, B:30:0x00eb, B:31:0x00f0, B:34:0x0102, B:35:0x0107, B:38:0x0119), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r5, android.app.Activity r6) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.splash.i.a(com.sigmob.sdk.base.models.BaseAdUnit, android.app.Activity):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        super.setVisibility(4);
    }

    public boolean c() {
        BaseAdUnit baseAdUnit = this.f;
        if (baseAdUnit != null && baseAdUnit.getSplashFilePath() != null) {
            return this.d.a(this.f);
        }
        SigmobLog.e("adUnit or splashFilePath is null");
        return false;
    }

    public void d() {
        this.n = false;
        aa.a aVar = this.r;
        if (aVar != null) {
            aVar.b();
        }
        this.d.b();
    }

    public void e() {
        aa.a aVar = this.r;
        if (aVar != null) {
            aVar.a();
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.a();
        }
        this.d.c();
    }

    public int getDuration() {
        return this.d.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        c cVar = this.g;
        if (cVar == null) {
            return;
        }
        cVar.a(com.sigmob.sdk.base.utils.f.c(this), this.f, new q.b() { // from class: com.sigmob.sdk.splash.i.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                i.this.o = false;
                i.this.n = false;
                if (i.this.p) {
                    i.this.a(true);
                } else if (i.this.r != null) {
                    i.this.r.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str, String str2) {
                if (i.this.f != null) {
                    i.this.f.getClickCommon().click_scene = "appinfo";
                    i.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    i.this.f.getClickCommon().is_final_click = true;
                    ag sessionManager = i.this.f.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a("click", 0);
                    }
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                if (i.this.r != null) {
                    i.this.r.b();
                }
                i.this.o = true;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aa.a aVar = this.r;
        if (aVar != null) {
            aVar.c();
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.b();
        }
        removeAllViews();
    }

    public void setAspectRatio(float f) {
        this.v = f;
    }

    public void setDuration(int i) {
        com.sigmob.sdk.base.views.ae aeVar;
        if (this.f == null) {
            return;
        }
        if (i > 0 && (aeVar = this.q) != null) {
            aeVar.a(i);
            return;
        }
        this.p = true;
        if (!this.o || this.u) {
            a(true);
        }
        com.sigmob.sdk.base.common.ae.a("complete", (String) null, this.f);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.setOnTouchListener(onTouchListener);
        }
    }

    public void setShowAppLogo(boolean z) {
        this.i = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        ag sessionManager;
        if (i == 0) {
            this.q.setVisibility(0);
            this.d.a();
            BaseAdUnit baseAdUnit = this.f;
            if (baseAdUnit != null && (sessionManager = baseAdUnit.getSessionManager()) != null) {
                sessionManager.a("start", 0);
            }
            super.setVisibility(i);
            return;
        }
        try {
            com.sigmob.sdk.base.common.ae.a(PointCategory.SPLASHADBLOCK, WindAdError.ERROR_SPLASH_ADBLOCK.getErrorCode(), Preconditions.NoThrow.getLineInfo(), this.f);
            SigmobLog.e("debug " + Preconditions.NoThrow.getLineInfo());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
