package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class z extends Dialog implements DialogInterface.OnShowListener {
    protected com.sigmob.sdk.base.common.t a;
    private View b;

    /* renamed from: c, reason: collision with root package name */
    private Window f490c;
    private a d;
    private RelativeLayout e;
    private com.sigmob.sdk.videoAd.a f;
    private BaseAdUnit g;
    private com.sigmob.sdk.mraid.d h;
    private Context i;
    private int j;
    private int k;
    private boolean l;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();
    }

    public z(Context context, BaseAdUnit baseAdUnit, com.sigmob.sdk.videoAd.a aVar) {
        super(context, com.sigmob.sdk.base.g.e());
        this.f490c = null;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.i = context.getApplicationContext();
        this.g = baseAdUnit;
        this.f = aVar;
        this.b = b();
    }

    private void d() {
        Window window = getWindow();
        this.f490c = window;
        if (window != null) {
            window.setGravity(80);
            int g = com.sigmob.sdk.base.g.g();
            if (g != 0) {
                this.f490c.setWindowAnimations(g);
            }
            this.f490c.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.f490c.getAttributes();
            int i = this.i.getResources().getDisplayMetrics().widthPixels;
            int i2 = this.i.getResources().getDisplayMetrics().heightPixels;
            int i3 = this.k;
            if (i3 - 1 <= i) {
                attributes.width = -1;
            } else {
                attributes.width = i3;
            }
            int i4 = this.j;
            if (i4 - 1 <= i2) {
                attributes.height = -1;
            } else {
                attributes.height = i4;
            }
            SigmobLog.i("RecommendDialog windowDeploy: " + i + "====" + i2 + "====" + attributes.width + "====" + attributes.height);
            this.f490c.setAttributes(attributes);
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.t tVar = this.a;
        if (tVar != null) {
            tVar.a(str, 0);
        }
    }

    public boolean a() {
        if (this.k <= 0 || this.j <= 0) {
            this.l = true;
        }
        return this.l;
    }

    public View b() {
        if (this.h == null) {
            this.h = new com.sigmob.sdk.mraid.d(this.i, this.g, PlacementType.INTERSTITIAL);
        }
        this.h.a(new d.f() { // from class: com.sigmob.sdk.base.views.z.1
            @Override // com.sigmob.sdk.mraid.d.f
            public void a() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Integer num) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Map<String, String> map) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b(Map<String, String> map) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void d() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void e() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void f() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void h() {
            }
        });
        this.h.a(new d.a() { // from class: com.sigmob.sdk.base.views.z.2
            private int i() {
                WindowInsets rootWindowInsets;
                if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = z.this.getWindow().getDecorView().getRootWindowInsets()) == null || rootWindowInsets.getDisplayCutout() == null) {
                    return 0;
                }
                return rootWindowInsets.getDisplayCutout().getSafeInsetTop();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a() {
                SigmobLog.d("RecommendDialog onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(float f) {
                SigmobLog.d("RecommendDialog onReward()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z) {
                int i5 = z.this.i.getResources().getDisplayMetrics().widthPixels;
                int i6 = z.this.i.getResources().getDisplayMetrics().heightPixels;
                int l = com.sigmob.sdk.videoplayer.d.l(z.this.getContext());
                int i7 = i();
                SigmobLog.i("RecommendDialog Origin onResize :" + i + "==" + i2 + "==" + i3 + "==" + i4 + "==" + z);
                z zVar = z.this;
                zVar.k = Dips.dipsToIntPixels((float) i, zVar.i);
                z zVar2 = z.this;
                zVar2.j = Dips.dipsToIntPixels((float) i2, zVar2.i);
                int dipsToIntPixels = Dips.dipsToIntPixels((float) i3, z.this.i);
                int dipsToIntPixels2 = Dips.dipsToIntPixels((float) i4, z.this.i) - Math.max(l, i7);
                if (z.this.b != null) {
                    if (!z) {
                        if (dipsToIntPixels < 0) {
                            dipsToIntPixels = 0;
                        }
                        if (dipsToIntPixels > i5) {
                            dipsToIntPixels = i5;
                        }
                        if (dipsToIntPixels2 < 0) {
                            dipsToIntPixels2 = 0;
                        }
                        if (dipsToIntPixels2 > i6) {
                            dipsToIntPixels2 = i6;
                        }
                        if (z.this.k + dipsToIntPixels > i5) {
                            z.this.k = i5 - dipsToIntPixels;
                        }
                        if (z.this.j + dipsToIntPixels2 > i6) {
                            z.this.j = i6 - dipsToIntPixels2;
                        }
                    }
                    SigmobLog.i("RecommendDialog onResize: " + z.this.k + "==" + z.this.j + "==" + dipsToIntPixels + "==" + dipsToIntPixels2);
                    if (z.this.k <= 0 || z.this.j <= 0) {
                        z.this.l = true;
                    }
                    z.this.b.setX(dipsToIntPixels);
                    z.this.b.setY(dipsToIntPixels2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(z.this.k, z.this.j);
                    layoutParams.addRule(12);
                    z.this.b.setLayoutParams(layoutParams);
                    z.this.b.requestLayout();
                }
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(View view) {
                SigmobLog.d("RecommendDialog onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(WindAdError windAdError) {
                SigmobLog.i("RecommendDialog onRenderProcessGone:" + windAdError.toString());
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(String str) {
                SigmobLog.i("RecommendDialog onCompanionClick:" + str);
                boolean z = true;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt(com.umeng.analytics.pro.d.y);
                        z.this.h.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (optInt != 1) {
                            z.this.a(com.sigmob.sdk.base.common.a.w);
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        z.this.h.a("0", "0");
                        z.this.a(com.sigmob.sdk.base.common.a.w);
                    }
                }
                z.this.f.a(com.sigmob.sdk.base.a.ENDCARD, z.this.h.a(), z);
            }

            /* JADX WARN: Removed duplicated region for block: B:5:0x00a3  */
            @Override // com.sigmob.sdk.mraid.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.net.URI r11, int r12, java.lang.String r13) {
                /*
                    r10 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "RecommendDialog  onOpen:"
                    r0.append(r1)
                    r0.append(r11)
                    java.lang.String r1 = "======"
                    r0.append(r1)
                    r0.append(r12)
                    java.lang.String r12 = "====="
                    r0.append(r12)
                    r0.append(r13)
                    java.lang.String r12 = r0.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r12)
                    boolean r12 = android.text.TextUtils.isEmpty(r13)
                    java.lang.String r0 = "click"
                    r1 = 0
                    java.lang.String r2 = "0"
                    r3 = 1
                    r4 = 0
                    if (r12 != 0) goto L90
                    org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Exception -> L7e
                    r12.<init>(r13)     // Catch: java.lang.Exception -> L7e
                    java.lang.String r13 = "type"
                    int r13 = r12.optInt(r13)     // Catch: java.lang.Exception -> L7d
                    java.lang.String r4 = "x"
                    int r4 = r12.optInt(r4)     // Catch: java.lang.Exception -> L7d
                    java.lang.String r5 = "y"
                    int r5 = r12.optInt(r5)     // Catch: java.lang.Exception -> L7d
                    java.lang.String r6 = "disable_landing"
                    boolean r6 = r12.optBoolean(r6)     // Catch: java.lang.Exception -> L7d
                    java.lang.String r7 = "feDisable"
                    boolean r7 = r12.optBoolean(r7)     // Catch: java.lang.Exception -> L7a
                    if (r7 != 0) goto L58
                    r7 = 1
                    goto L59
                L58:
                    r7 = 0
                L59:
                    com.sigmob.sdk.base.views.z r8 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L77
                    com.sigmob.sdk.mraid.d r8 = com.sigmob.sdk.base.views.z.b(r8)     // Catch: java.lang.Exception -> L77
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L77
                    java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L77
                    r8.a(r4, r5)     // Catch: java.lang.Exception -> L77
                    if (r13 == r3) goto L72
                    com.sigmob.sdk.base.views.z r13 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L77
                    r13.a(r0)     // Catch: java.lang.Exception -> L77
                    r1 = 1
                L72:
                    r8 = r12
                    r9 = r6
                    r6 = r1
                    r1 = r9
                    goto La1
                L77:
                    r4 = r12
                    r1 = r6
                    goto L7f
                L7a:
                    r4 = r12
                    r1 = r6
                    goto L7e
                L7d:
                    r4 = r12
                L7e:
                    r7 = 1
                L7f:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r2, r2)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r8 = r4
                    r6 = 1
                    goto La1
                L90:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r2, r2)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r8 = r4
                    r6 = 1
                    r7 = 1
                La1:
                    if (r1 != 0) goto Lcb
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.base.models.BaseAdUnit r12 = com.sigmob.sdk.base.views.z.h(r12)
                    java.lang.String r12 = r12.getLanding_page()
                    boolean r12 = android.text.TextUtils.isEmpty(r12)
                    if (r12 == 0) goto Lb4
                    goto Lcb
                Lb4:
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r2 = com.sigmob.sdk.base.views.z.c(r11)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    r4 = 0
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r5 = r11.a()
                    r2.a(r3, r4, r5, r6, r7)
                    goto Le4
                Lcb:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r2 = com.sigmob.sdk.base.views.z.c(r12)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r4 = r11.toString()
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r5 = r11.a()
                    r2.a(r3, r4, r5, r6, r7, r8)
                Le4:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.z.AnonymousClass2.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(boolean z) {
                SigmobLog.d("RecommendDialog onMute()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b() {
                SigmobLog.d("RecommendDialog onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b(float f) {
                SigmobLog.d("RecommendDialog onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void d() {
                SigmobLog.d("RecommendDialog onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void e() {
                SigmobLog.i("RecommendDialog onFailedToLoad()");
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void f() {
                SigmobLog.i("RecommendDialog onUnload()");
                z.this.dismiss();
                z.this.a(com.sigmob.sdk.base.common.a.e);
                z.this.c();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void h() {
                SigmobLog.i("RecommendDialog onClose()");
                if (z.this.d != null) {
                    z.this.d.a();
                }
            }
        });
        if (!TextUtils.isEmpty(this.g.getCloseCardHtmlData())) {
            this.h.a(this.g.getCloseCardHtmlData(), new d.b() { // from class: com.sigmob.sdk.base.views.z.3
                @Override // com.sigmob.sdk.mraid.d.b
                public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
                    z zVar = z.this;
                    if (tVar != null) {
                        zVar.a = tVar;
                        return;
                    }
                    zVar.a = new com.sigmob.sdk.base.common.t();
                    z zVar2 = z.this;
                    zVar2.a.a(zVar2.g);
                }
            });
        }
        return this.h.q();
    }

    public void c() {
        com.sigmob.sdk.mraid.d dVar = this.h;
        if (dVar != null) {
            this.d = null;
            dVar.m();
            this.h = null;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setBackgroundColor(0);
        setContentView(this.e);
        setOnShowListener(this);
        SigmobLog.i("RecommendDialog onCreate:" + this.k + ":" + this.j);
        View view = this.b;
        if (view != null) {
            this.e.addView(view);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        d();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("RecommendDialog  onShow");
        a(com.sigmob.sdk.base.common.a.d);
        this.h.a(0);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        this.f490c = window;
        com.sigmob.sdk.videoplayer.d.a(window);
    }
}
