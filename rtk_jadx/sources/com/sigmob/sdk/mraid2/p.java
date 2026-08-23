package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p extends com.sigmob.sdk.videoAd.c {
    List<BaseAdUnit> f;
    private final Bundle g;
    private int h;
    private boolean i;
    private d j;
    private ap k;
    private com.sigmob.sdk.nativead.a l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private w q;
    private Handler r;
    private boolean s;
    private View.OnClickListener t;

    /* renamed from: com.sigmob.sdk.mraid2.p$9, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public p(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.n = false;
        this.o = false;
        this.p = true;
        this.t = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid2.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<BaseAdUnit> list;
                Activity n = p.this.n();
                if (n == null || (list = p.this.f) == null || list.get(0) == null) {
                    return;
                }
                p.this.l = new com.sigmob.sdk.nativead.a(n, p.this.f.get(0));
                if (p.this.l != null) {
                    p.this.l.a();
                }
                p.this.l.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.p.6.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        if (p.this.l != null) {
                            p.this.l.dismiss();
                            p.this.l.b();
                            p.this.l = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        if (p.this.l != null) {
                            p.this.l.dismiss();
                            p.this.l.b();
                            p.this.l = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.f = com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid());
        this.g = bundle;
        d a = b.a().a(baseAdUnit.getUuid());
        this.j = a;
        if (a == null) {
            this.j = new d(com.sigmob.sdk.b.e(), this.f);
        }
        if (Build.VERSION.SDK_INT >= 20) {
            a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid2.p.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    p.this.j.a(windowInsets, p.this.s);
                    return windowInsets;
                }
            });
        }
        n().requestWindowFeature(1);
    }

    private void a(int i, RelativeLayout.LayoutParams layoutParams) {
        int i2;
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.b);
        if (i == 1 || i == 2) {
            layoutParams.addRule(10);
            i2 = 9;
        } else {
            if (i != 3 && i != 4) {
                return;
            }
            layoutParams.addRule(10);
            i2 = 11;
        }
        layoutParams.addRule(i2);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
    }

    private void a(Context context, int i) {
        if (this.q == null) {
            w wVar = new w(context);
            this.q = wVar;
            wVar.setText("反馈");
            this.q.setOnClickListener(this.t);
            this.q.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.k.getId());
            layoutParams.addRule(6, this.k.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.q, layoutParams);
        }
        w wVar2 = this.q;
        if (wVar2 != null) {
            wVar2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, BaseAdUnit baseAdUnit, String str, final String str2, JSONObject jSONObject, String str3, boolean z) {
        BaseAdUnit baseAdUnit2;
        BaseAdUnit baseAdUnit3;
        String str4 = null;
        String str5 = "";
        if (am.OPEN_WITH_BROWSER.a(Uri.parse(str2), 0)) {
            try {
                if (z) {
                    if (baseAdUnit != null) {
                        baseAdUnit.setRecord(true);
                        baseAdUnit3 = baseAdUnit;
                    } else {
                        baseAdUnit3 = gVar.getAdUnitList().get(0);
                        baseAdUnit3.setRecord(false);
                    }
                    baseAdUnit3.setUrl(str2);
                    com.sigmob.sdk.base.common.h.a(baseAdUnit3);
                    BaseAdActivity.a(l(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit3);
                } else {
                    u.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                }
                str4 = str5;
            } catch (Exception e) {
                String message = e.getMessage();
                if (TextUtils.isEmpty(str3)) {
                    str4 = message;
                } else {
                    try {
                        u.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        str4 = e.getMessage();
                    }
                }
            }
            a(gVar, baseAdUnit, str, jSONObject, str4);
        }
        try {
            com.sigmob.sdk.base.common.h.d(baseAdUnit);
            u.a(l(), Uri.parse(str2));
        } catch (Exception e3) {
            com.sigmob.sdk.base.common.h.d((BaseAdUnit) null);
            str5 = e3.getMessage();
        }
        if (baseAdUnit != null) {
            try {
                if (!TextUtils.isEmpty(str5)) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "open_deeplink_failed");
                    baseAdUnit.getClickCommon().isDeeplink = "0";
                    ae.a("open_deeplink_failed", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.mraid2.p.5
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).setFinal_url(str2);
                            }
                        }
                    });
                }
            } catch (Exception e4) {
                str5 = e4.getMessage();
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
            if (z) {
                if (baseAdUnit != null) {
                    baseAdUnit.setRecord(true);
                    baseAdUnit2 = baseAdUnit;
                } else {
                    baseAdUnit2 = gVar.getAdUnitList().get(0);
                    baseAdUnit2.setRecord(false);
                }
                baseAdUnit2.setUrl(str3);
                com.sigmob.sdk.base.common.h.a(baseAdUnit2);
                BaseAdActivity.a(l(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit2);
            } else {
                u.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
            }
            a(gVar, baseAdUnit, str, jSONObject, str4);
        }
        str4 = str5;
        a(gVar, baseAdUnit, str, jSONObject, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, final BaseAdUnit baseAdUnit, String str, final JSONObject jSONObject, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (gVar.getMraidBridge() != null) {
                    gVar.getMraidBridge().b(str + "_failed", str2);
                    return;
                }
                return;
            }
            a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().b(str + "_success", "");
            }
            if (baseAdUnit == null || !baseAdUnit.isRecord()) {
                return;
            }
            final ClickCommon clickCommon = baseAdUnit.getClickCommon();
            ae.a(com.sigmob.sdk.base.a.ENDCARD.name().toLowerCase(), "click", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.mraid2.p.4
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                        pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                        pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                        pointEntitySigmob.setIs_deeplink(clickCommon.isDeeplink);
                        pointEntitySigmob.setFinal_url(clickCommon.clickUrl);
                        pointEntitySigmob.setCoordinate(clickCommon.clickCoordinate);
                        pointEntitySigmob.setVtime(String.format("%.2f", Float.valueOf(com.sigmob.sdk.base.blurkit.c.d)));
                        if (jSONObject != null) {
                            HashMap hashMap = new HashMap();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, jSONObject.optString(next));
                            }
                            pointEntitySigmob.setOptions(hashMap);
                        }
                        Map options = pointEntitySigmob.getOptions();
                        options.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        options.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    }
                }
            });
            com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b(Context context, int i) {
        if (this.k != null) {
            return;
        }
        ap apVar = new ap(context);
        this.k = apVar;
        apVar.setVisibility(i);
        this.k.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        a(3, layoutParams);
        m().addView(this.k, layoutParams);
        this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid2.p.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    p.this.n = true;
                    p.this.m = true;
                    p.this.k().a();
                }
                return true;
            }
        });
        this.k.a(this.f.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        List<BaseAdUnit> list;
        if (this.o || (list = this.f) == null || list.size() <= 0) {
            return;
        }
        ae.b("h5_state", "0", this.f.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ap apVar = this.k;
        if (apVar != null) {
            apVar.setVisibility(4);
        }
        w wVar = this.q;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.k == null) {
            b(this.b, 0);
        }
        this.k.setVisibility(0);
        a(l(), 0);
    }

    public View a() {
        if (this.j == null) {
            this.j = new d(this.b, this.f);
        }
        this.j.a(this.e);
        this.j.a(new d.a() { // from class: com.sigmob.sdk.mraid2.p.2
            @Override // com.sigmob.sdk.mraid2.d.a
            public void a() {
                p.this.c();
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void a(int i, int i2, int i3, int i4) {
                try {
                    p.this.j.e();
                    if (i4 == 0) {
                        p.this.m().setBackgroundColor(0);
                    } else {
                        p.this.m().setBackgroundColor(Color.argb((int) ((i4 / 100.0f) * 255.0f), i, i2, i3));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void a(BaseAdUnit baseAdUnit) {
                List<BaseAdUnit> list;
                if (baseAdUnit == null && (list = p.this.f) != null) {
                    baseAdUnit = list.get(0);
                }
                Activity n = p.this.n();
                if (n == null || baseAdUnit == null) {
                    return;
                }
                p.this.l = new com.sigmob.sdk.nativead.a(n, baseAdUnit);
                if (p.this.l != null) {
                    p.this.l.a();
                }
                p.this.l.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.p.2.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        g c2;
                        c mraidBridge;
                        if (p.this.j != null && (c2 = p.this.j.c()) != null && (mraidBridge = c2.getMraidBridge()) != null) {
                            mraidBridge.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                        }
                        if (p.this.l != null) {
                            p.this.l.dismiss();
                            p.this.l.b();
                            p.this.l = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        g c2;
                        c mraidBridge;
                        if (p.this.j != null && (c2 = p.this.j.c()) != null && (mraidBridge = c2.getMraidBridge()) != null) {
                            mraidBridge.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                        }
                        if (p.this.l != null) {
                            p.this.l.dismiss();
                            p.this.l.b();
                            p.this.l = null;
                        }
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        g c2;
                        c mraidBridge;
                        if (p.this.j == null || (c2 = p.this.j.c()) == null || (mraidBridge = c2.getMraidBridge()) == null) {
                            return;
                        }
                        mraidBridge.a("feedbackDidAppear", (HashMap<String, Object>) null);
                    }
                });
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass9.a[consoleMessage.messageLevel().ordinal()] == 1) {
                    SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                    ae.a("h5_error", "mraid2", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, p.this.f.get(0), (ae.a) null);
                }
                return false;
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public boolean a(String str, JsResult jsResult) {
                return false;
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void b() {
                p.this.d();
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void c() {
                p.this.s = true;
            }
        });
        this.j.a(new d.b() { // from class: com.sigmob.sdk.mraid2.p.3
            @Override // com.sigmob.sdk.mraid2.d.b
            public void a() {
                SigmobLog.d("MraidActivity failed to load. Finishing the activity");
                if (((com.sigmob.sdk.base.common.j) p.this).a != null) {
                    p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
                }
                ((com.sigmob.sdk.base.common.j) p.this).d.a();
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(View view) {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
                SigmobLog.d("onLoaded() called");
            }

            /* JADX WARN: Removed duplicated region for block: B:66:0x0180  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.sigmob.sdk.mraid2.d.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(final com.sigmob.sdk.mraid2.g r23, final com.sigmob.sdk.base.models.BaseAdUnit r24, org.json.JSONObject r25) {
                /*
                    Method dump skipped, instructions count: 611
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.p.AnonymousClass3.a(com.sigmob.sdk.mraid2.g, com.sigmob.sdk.base.models.BaseAdUnit, org.json.JSONObject):void");
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(WindAdError windAdError) {
                SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
                if (((com.sigmob.sdk.base.common.j) p.this).a != null) {
                    p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
                }
                ((com.sigmob.sdk.base.common.j) p.this).d.a();
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(boolean z) {
                if (z) {
                    p.this.q();
                } else {
                    p.this.r();
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void b() {
                p.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
                p.this.n = true;
                ((com.sigmob.sdk.base.common.j) p.this).d.a();
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void c() {
                if (p.this.i) {
                    return;
                }
                p.this.i = true;
                p.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void d() {
                p.this.o = true;
            }
        });
        return this.j.e();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a(configuration.orientation);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(16778240);
        b(n(), this.h, this.g);
        BaseAdUnit baseAdUnit = this.f.get(0);
        if (baseAdUnit != null && (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1)) {
            b();
            m().setBackgroundColor(Color.argb(127, 0, 0, 0));
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (!this.n) {
            this.j.a();
        } else {
            this.p = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        this.j.b();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        BaseAdUnit baseAdUnit;
        d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
        com.sigmob.sdk.nativead.a aVar = this.l;
        if (aVar != null) {
            aVar.dismiss();
            this.l.b();
            this.l = null;
        }
        List<BaseAdUnit> list = this.f;
        if (list != null) {
            if (this.m && (baseAdUnit = list.get(0)) != null) {
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
                ae.a("ad_close", (String) null, baseAdUnit);
            }
            for (BaseAdUnit baseAdUnit2 : this.f) {
                if (baseAdUnit2 != null) {
                    baseAdUnit2.destroy();
                }
            }
        }
        if (!this.n || !this.p) {
            this.p = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        Sigmob.getInstance().getMacroCommon().clearMacro();
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
        d dVar = this.j;
        if (dVar != null) {
            dVar.a(this.f.get(0));
        }
        if (this.r == null) {
            this.r = new Handler();
        }
        this.r.postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid2.p.8
            @Override // java.lang.Runnable
            public void run() {
                p.this.p();
            }
        }, 5000L);
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
    }
}
