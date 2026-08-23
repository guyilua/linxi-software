package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.ExtensionEvent;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.o;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private APKStatusBroadcastReceiver A;
    private boolean B;
    private com.sigmob.sdk.base.common.g C;
    private WindowInsets D;
    private final PlacementType a;
    private final BaseAdUnit b;

    /* renamed from: c, reason: collision with root package name */
    private final FrameLayout f561c;
    private final C0050d d;
    private final l e;
    private final com.sigmob.sdk.mraid.b f;
    private final i g;
    private boolean h;
    private Integer i;
    private String j;
    private ViewGroup k;
    private ViewState l;
    private a m;
    private e n;
    private r o;
    private f p;
    private p q;
    private c r;
    private Integer s;
    private boolean t;
    private k u;
    private boolean v;
    private HashMap<String, j> w;
    private com.sigmob.sdk.mraid2.f x;
    private final b.c y;
    private final b.InterfaceC0048b z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void a(float f);

        void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z);

        void a(View view);

        void a(WindAdError windAdError);

        void a(String str);

        void a(URI uri, int i, String str);

        void a(boolean z);

        void b();

        void b(float f);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(p pVar, com.sigmob.sdk.base.common.t tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c extends BroadcastReceiver {
        private Context b;

        /* renamed from: c, reason: collision with root package name */
        private int f562c = -1;

        c() {
        }

        public void a() {
            Context context = this.b;
            if (context != null) {
                context.unregisterReceiver(this);
                this.b = null;
            }
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            if (applicationContext != null) {
                IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int x;
            if (this.b == null || d.this.v || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (x = d.this.x()) == this.f562c) {
                return;
            }
            this.f562c = x;
            d.this.a(x);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.mraid.d$d, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0050d {
        private final Handler a = new Handler();
        private a b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.sigmob.sdk.mraid.d$d$a */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class a {
            int a;
            private final View[] b;

            /* renamed from: c, reason: collision with root package name */
            private final Handler f563c;
            private Runnable d;
            private final Runnable e;

            private a(Handler handler, View[] viewArr) {
                this.e = new Runnable() { // from class: com.sigmob.sdk.mraid.d.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (final View view : a.this.b) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.this.b();
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.mraid.d.d.a.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.this.b();
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.f563c = handler;
                this.b = viewArr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Runnable runnable;
                int i = this.a - 1;
                this.a = i;
                if (i != 0 || (runnable = this.d) == null) {
                    return;
                }
                runnable.run();
                this.d = null;
            }

            void a() {
                this.f563c.removeCallbacks(this.e);
                this.d = null;
            }

            void a(Runnable runnable) {
                this.d = runnable;
                this.a = this.b.length;
                this.f563c.post(this.e);
            }
        }

        C0050d() {
        }

        a a(View... viewArr) {
            a aVar = new a(this.a, viewArr);
            this.b = aVar;
            return aVar;
        }

        void a() {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
                this.b = null;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface e {
        void a(boolean z);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface f {
        void a();

        void a(Integer num);

        void a(Map<String, String> map);

        void b();

        void b(Map<String, String> map);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public d(Context context, BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(context, baseAdUnit, placementType, new com.sigmob.sdk.mraid.b(baseAdUnit, placementType), null, new C0050d());
    }

    d(Context context, BaseAdUnit baseAdUnit, PlacementType placementType, com.sigmob.sdk.mraid.b bVar, com.sigmob.sdk.mraid.b bVar2, C0050d c0050d) {
        this.h = false;
        ViewState viewState = ViewState.LOADING;
        this.l = viewState;
        this.r = new c();
        this.t = true;
        this.u = k.NONE;
        this.v = false;
        this.w = new HashMap<>();
        b.c cVar = new b.c() { // from class: com.sigmob.sdk.mraid.d.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.sigmob.sdk.mraid.b.c
            public void a(String str, JSONObject jSONObject) {
                char c2;
                SigmobLog.d(" handleVpaidEvent event:" + str);
                SigmobLog.d(" postMessage args:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || d.this.q == null) {
                    SigmobLog.e(" handleVpaidEvent uniqueId is null:" + jSONObject);
                    return;
                }
                o oVar = null;
                j jVar = (j) d.this.w.get(optString);
                if (jVar != null && (jVar instanceof o)) {
                    oVar = (o) jVar;
                }
                str.hashCode();
                switch (str.hashCode()) {
                    case -934524953:
                        if (str.equals("replay")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -373213089:
                        if (str.equals("assetURL")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3443508:
                        if (str.equals(PointCategory.PLAY)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3526264:
                        if (str.equals("seek")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3540994:
                        if (str.equals("stop")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 104264043:
                        if (str.equals("muted")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 106440182:
                        if (str.equals("pause")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        if (oVar != null) {
                            oVar.c(jSONObject);
                            return;
                        }
                        return;
                    case 1:
                        if (oVar != null) {
                            oVar.a(jSONObject);
                            return;
                        }
                        return;
                    case 2:
                        o oVar2 = new o(optString);
                        oVar2.a(new o.a() { // from class: com.sigmob.sdk.mraid.d.1.1
                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, int i) {
                                if (d.this.f != null) {
                                    d.this.f.c(str2, i);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, int i, String str3) {
                                if (d.this.f != null) {
                                    d.this.f.b(str2, "code:" + i + ", msg:" + str3);
                                }
                                ae.a(PointCategory.VIDEO, i, str3, d.this.b);
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, (int) j);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j, int i, int i2) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, (int) j, i, i2);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j, long j2) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, (int) j, (int) j2);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void b(String str2, int i) {
                                if (d.this.f != null) {
                                    d.this.f.b(str2, i);
                                }
                            }
                        });
                        d.this.w.put(optString, oVar2);
                        oVar2.a(d.this.q.getContext(), jSONObject);
                        View b2 = oVar2.b();
                        if (b2 != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                            layoutParams.topMargin = -1;
                            layoutParams.rightMargin = -1;
                            d.this.f561c.addView(b2, layoutParams);
                            return;
                        }
                        return;
                    case 3:
                        if (oVar != null) {
                            oVar.b(jSONObject);
                            return;
                        }
                        return;
                    case 4:
                        if (oVar != null) {
                            oVar.g(jSONObject);
                            return;
                        }
                        return;
                    case 5:
                        if (oVar != null) {
                            oVar.e(jSONObject);
                            oVar.c();
                            d.this.w.remove(optString);
                            return;
                        }
                        return;
                    case 6:
                        if (oVar != null) {
                            oVar.h(jSONObject);
                            return;
                        }
                        return;
                    case 7:
                        if (oVar != null) {
                            oVar.f(jSONObject);
                            return;
                        }
                        return;
                    case '\b':
                        if (oVar != null) {
                            oVar.d(jSONObject);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void b(String str, JSONObject jSONObject) {
                j jVar;
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || (jVar = (j) d.this.w.get(optString)) == null || jVar.b() == null) {
                    return;
                }
                d.this.f561c.bringChildToFront(d.this.q);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void c(String str, JSONObject jSONObject) {
                j jVar;
                View b2;
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || (jVar = (j) d.this.w.get(optString)) == null || (b2 = jVar.b()) == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.f.a(b2);
                d.this.f561c.addView(b2);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void d(String str, JSONObject jSONObject) {
                com.sigmob.sdk.mraid2.f fVar;
                SigmobLog.d(" postMessage subEvent data:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObject);
                    return;
                }
                j jVar = (j) d.this.w.get(optString);
                com.sigmob.sdk.mraid2.f fVar2 = jVar instanceof com.sigmob.sdk.mraid2.f ? (com.sigmob.sdk.mraid2.f) jVar : null;
                str.hashCode();
                char c2 = 65535;
                int i = 2;
                switch (str.hashCode()) {
                    case -1579599527:
                        if (str.equals("init_sensitivity_raw")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1557372922:
                        if (str.equals("destroy")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String optString2 = jSONObject.optString(com.umeng.analytics.pro.d.y, "");
                        int optInt = jSONObject.optInt("sensitivity_raw", 0);
                        fVar = new com.sigmob.sdk.mraid2.f(optString, optString2);
                        fVar.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.3
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, str3, str4, hashMap);
                                }
                            }
                        });
                        fVar.b(optInt);
                        break;
                    case 1:
                        String optString3 = jSONObject.optString(com.umeng.analytics.pro.d.y, "");
                        int optInt2 = jSONObject.optInt("sensitivity", 0);
                        fVar = new com.sigmob.sdk.mraid2.f(optString, optString3);
                        fVar.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.2
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, str3, str4, hashMap);
                                }
                            }
                        });
                        if (optInt2 == 0) {
                            i = 3;
                        } else if (optInt2 == 2) {
                            i = 1;
                        } else if (optInt2 != 1) {
                            i = optInt2;
                        }
                        fVar.a(i);
                        break;
                    case 2:
                        if (fVar2 != null) {
                            fVar2.c();
                        }
                        d.this.w.remove(optString);
                        return;
                    default:
                        return;
                }
                fVar.a();
                d.this.w.put(optString, fVar);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void e(String str, JSONObject jSONObject) {
                SigmobLog.d(" onMotionViewEvent event:" + str);
                SigmobLog.d(" postMessage args:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObject);
                    return;
                }
                j jVar = (j) d.this.w.get(optString);
                h hVar = (jVar == null || !(jVar instanceof h)) ? null : (h) jVar;
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1217487446:
                        if (str.equals("hidden")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109757538:
                        if (str.equals("start")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 564403871:
                        if (str.equals("sensitivity")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1557372922:
                        if (str.equals("destroy")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1599250056:
                        if (str.equals("sensitivity_raw")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (hVar != null) {
                            hVar.a(jSONObject.optBoolean("hidden"));
                            return;
                        }
                        return;
                    case 1:
                        h hVar2 = new h(com.sigmob.sdk.b.g(), optString, jSONObject.optInt(com.umeng.analytics.pro.d.y));
                        hVar2.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.4
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (d.this.f != null) {
                                    d.this.f.a(str2, str3, str4, hashMap);
                                }
                            }
                        });
                        d.this.w.put(optString, hVar2);
                        return;
                    case 2:
                        if (hVar != null) {
                            hVar.a(jSONObject);
                            return;
                        }
                        return;
                    case 3:
                        if (hVar != null) {
                            hVar.a();
                            return;
                        }
                        return;
                    case 4:
                        if (hVar != null) {
                            hVar.a(jSONObject.optInt("sensitivity"));
                            return;
                        }
                        return;
                    case 5:
                        if (hVar != null) {
                            hVar.c();
                        }
                        d.this.w.remove(optString);
                        return;
                    case 6:
                        if (hVar != null) {
                            hVar.b(jSONObject.optInt("sensitivity_raw"));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.y = cVar;
        b.InterfaceC0048b interfaceC0048b = new b.InterfaceC0048b() { // from class: com.sigmob.sdk.mraid.d.2
            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a() {
                d.this.k();
                if (d.this.m != null) {
                    d.this.m.a(d.this.f561c);
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z) {
                if (d.this.m != null) {
                    d.this.m.a(i, i2, i3, i4, enumC0047a, z);
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(WindAdError windAdError) {
                d.this.a(windAdError);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(String str, Map<String, String> map) {
                d.this.b(str, map);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(URI uri) {
                d.this.a(uri.toString());
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(URI uri, int i, String str) {
                d.this.a(uri, i, str);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(URI uri, boolean z) {
                d.this.a(uri, z);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(boolean z) {
                d.this.f.a(z);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void a(boolean z, k kVar) {
                d.this.a(z, kVar);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public boolean a(ConsoleMessage consoleMessage) {
                return d.this.a(consoleMessage);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public boolean a(String str, JsResult jsResult) {
                return d.this.a(str, jsResult);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void b() {
                d.this.j();
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void b(String str, Map<String, String> map) {
                d.this.a(str, map);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void b(boolean z) {
                d.this.e(z);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void c() {
                if (d.this.m != null) {
                    d.this.m.e();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void d() {
                d.this.n();
                d.this.m.h();
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void e() {
                if (d.this.m != null) {
                    d.this.m.f();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void f() {
                if (d.this.m != null) {
                    d.this.m.g();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0048b
            public void g() {
                if (d.this.m != null) {
                    d.this.m.c();
                }
            }
        };
        this.z = interfaceC0048b;
        Preconditions.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f561c = frameLayout;
        this.b = baseAdUnit;
        this.a = placementType;
        this.f = bVar;
        this.d = c0050d;
        this.l = viewState;
        this.e = new l(context, context.getResources().getDisplayMetrics().density);
        frameLayout.setBackgroundColor(0);
        new View(context).setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid.d.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.r.a(context);
        bVar.a(interfaceC0048b);
        bVar.a(cVar);
        this.g = new i();
    }

    static void a(a aVar, ViewState viewState, ViewState viewState2) {
        Preconditions.checkNotNull(aVar);
        Preconditions.checkNotNull(viewState);
        Preconditions.checkNotNull(viewState2);
    }

    private void a(Runnable runnable) {
        this.d.a();
        p g = g();
        if (g == null || this.v) {
            return;
        }
        DisplayMetrics displayMetrics = w().getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.C;
        if (gVar != null) {
            this.e.a(gVar.a(), this.C.b());
        } else {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int[] iArr = new int[2];
        ViewGroup z = z();
        z.getLocationOnScreen(iArr);
        this.e.a(iArr[0], iArr[1], z.getWidth(), z.getHeight());
        this.e.c(iArr[0], iArr[1], z.getWidth(), z.getHeight());
        g.getLocationOnScreen(iArr);
        this.e.b(iArr[0], iArr[1], g.getWidth(), g.getHeight());
        this.f.a(new CurrentAppOrientation(ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape", true));
        this.f.a(this.e);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        if (this.m == null) {
            return;
        }
        try {
            String a2 = com.sigmob.sdk.mraid.b.a(map.get(com.sigmob.sdk.base.k.m));
            String a3 = com.sigmob.sdk.mraid.b.a(map.get("ctime"));
            String a4 = com.sigmob.sdk.mraid.b.a(map.get("state"));
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1610203128:
                    if (str.equals(ExtensionEvent.AD_ENDCARD_SHOW)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1102513700:
                    if (str.equals(ExtensionEvent.AD_COMPANION_CLICK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -934326481:
                    if (str.equals("reward")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -900560382:
                    if (str.equals(ExtensionEvent.AD_SKIP)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 112386354:
                    if (str.equals(ExtensionEvent.AD_MUTE)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1293469449:
                    if (str.equals(ExtensionEvent.AD_SHOE_SKIP_TIME)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                Float valueOf = Float.valueOf(com.sigmob.sdk.base.blurkit.c.d);
                try {
                    valueOf = Float.valueOf(a3);
                } catch (Throwable unused) {
                }
                this.m.b(valueOf.floatValue());
                return;
            }
            if (c2 == 1) {
                Float valueOf2 = Float.valueOf(com.sigmob.sdk.base.blurkit.c.d);
                try {
                    valueOf2 = Float.valueOf(a3);
                } catch (Throwable unused2) {
                }
                this.m.a(valueOf2.floatValue());
            } else {
                if (c2 == 2) {
                    this.m.a(a4.equalsIgnoreCase("true") || a4.equalsIgnoreCase("1"));
                    return;
                }
                if (c2 == 3) {
                    this.m.a();
                } else if (c2 == 4) {
                    this.m.a(a2);
                } else {
                    if (c2 != 5) {
                        return;
                    }
                    this.m.b();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private void b(ViewState viewState) {
        SigmobLog.d("MRAID state set to " + viewState);
        ViewState viewState2 = this.l;
        this.l = viewState;
        this.f.a(viewState);
        a aVar = this.m;
        if (aVar != null) {
            a(aVar, viewState2, viewState);
        }
        SigmobLog.e("setViewState state set to " + viewState);
        a((Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Map<String, String> map) {
        if (this.p == null) {
            return;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1741877423:
                if (str.equals(s.d)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1686946132:
                if (str.equals(s.f574c)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1528092430:
                if (str.equals(s.j)) {
                    c2 = 2;
                    break;
                }
                break;
            case -916384160:
                if (str.equals(s.h)) {
                    c2 = 3;
                    break;
                }
                break;
            case 123005777:
                if (str.equals(s.f)) {
                    c2 = 4;
                    break;
                }
                break;
            case 369958203:
                if (str.equals(s.g)) {
                    c2 = 5;
                    break;
                }
                break;
            case 488344453:
                if (str.equals(s.b)) {
                    c2 = 6;
                    break;
                }
                break;
            case 858456394:
                if (str.equals(s.i)) {
                    c2 = 7;
                    break;
                }
                break;
            case 1024669788:
                if (str.equals(s.a)) {
                    c2 = '\b';
                    break;
                }
                break;
            case 2133007979:
                if (str.equals(s.e)) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.p.b();
                return;
            case 1:
                this.p.a();
                return;
            case 2:
                this.p.f();
                return;
            case 3:
                this.p.g();
                return;
            case 4:
                this.p.d();
                return;
            case 5:
                this.p.e();
                return;
            case 6:
                this.p.b(map);
                return;
            case 7:
                this.p.h();
                return;
            case '\b':
                this.p.a(map);
                return;
            case '\t':
                this.p.c();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context w() {
        FrameLayout frameLayout = this.f561c;
        if (frameLayout != null) {
            return frameLayout.getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        return ClientMetadata.getInstance().getScreenOrientation(w());
    }

    private void y() {
        this.f.b();
        this.q = null;
    }

    private ViewGroup z() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            return viewGroup;
        }
        View a2 = com.sigmob.sdk.base.utils.f.a(w(), this.f561c);
        ViewGroup viewGroup2 = a2 instanceof ViewGroup ? (ViewGroup) a2 : this.f561c;
        this.k = viewGroup2;
        return viewGroup2;
    }

    int a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    public String a() {
        return this.f.a();
    }

    public void a(int i) {
        SigmobLog.i("handleOrientationChange " + i);
        a((Runnable) null);
    }

    @Deprecated
    void a(int i, int i2) {
        this.e.a(0, 0, i, i2);
    }

    void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z) {
    }

    public void a(Activity activity) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.n != null) {
                    d.this.n.a(d.this.h);
                }
            }
        }, 5000);
    }

    public void a(WindowInsets windowInsets) {
        this.D = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (this.B) {
            com.sigmob.sdk.base.utils.d a2 = com.sigmob.sdk.videoplayer.d.a(windowInsets);
            com.sigmob.sdk.mraid.b bVar = this.f;
            if (bVar != null) {
                bVar.a(a2.a(), a2.b(), a2.c(), a2.d());
            }
        }
    }

    public void a(ValueCallback valueCallback) {
        this.f.a(valueCallback);
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.C = gVar;
    }

    @Deprecated
    void a(ViewState viewState) {
        this.l = viewState;
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    @Deprecated
    void a(c cVar) {
        this.r = cVar;
    }

    public void a(e eVar) {
        this.n = eVar;
    }

    public void a(f fVar) {
        this.p = fVar;
    }

    public void a(r rVar) {
        this.o = rVar;
    }

    void a(WindAdError windAdError) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(windAdError);
        }
    }

    void a(String str) {
    }

    public void a(String str, b bVar) {
        p pVar = new p(w());
        this.q = pVar;
        pVar.a(true);
        this.q.setBackgroundColor(0);
        if (bVar != null) {
            bVar.a(this.q, (com.sigmob.sdk.base.common.t) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.f561c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.a(w(), str);
    }

    public void a(String str, String str2) {
        this.f.a(str, str2);
    }

    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        this.f.a(str, str2, str3, hashMap);
    }

    void a(URI uri, int i, String str) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(uri, i, str);
        }
    }

    void a(URI uri, boolean z) {
    }

    public void a(boolean z) {
        if (z) {
            this.f.f();
        } else {
            this.f.g();
        }
    }

    void a(boolean z, k kVar) {
        if (!a(kVar)) {
            throw new com.sigmob.sdk.mraid.c("Unable to force orientation to " + kVar);
        }
        this.t = z;
        this.u = kVar;
        if (this.l == ViewState.EXPANDED || (this.a == PlacementType.INTERSTITIAL && !this.v)) {
            o();
        }
    }

    boolean a(ConsoleMessage consoleMessage) {
        r rVar = this.o;
        if (rVar != null) {
            return rVar.a(consoleMessage);
        }
        return true;
    }

    boolean a(k kVar) {
        if (kVar == k.NONE) {
            return true;
        }
        Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f561c);
        if (c2 == null) {
            return false;
        }
        try {
            int i = c2.getPackageManager().getActivityInfo(new ComponentName(c2, c2.getClass()), 0).screenOrientation;
            return i == -1 || i == kVar.a();
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    boolean a(String str, JsResult jsResult) {
        r rVar = this.o;
        if (rVar != null) {
            return rVar.a(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    public void b() {
        this.v = true;
        this.f.a(false);
    }

    void b(int i) {
        Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f561c);
        if (c2 == null || !a(this.u)) {
            throw new com.sigmob.sdk.mraid.c("Attempted to lock orientation to unsupported value: " + this.u.name());
        }
        if (this.s == null) {
            this.s = Integer.valueOf(c2.getRequestedOrientation());
        }
        try {
            c2.setRequestedOrientation(i);
        } catch (Exception e2) {
            SigmobLog.e("lockOrientation: " + e2.getMessage());
        }
    }

    public void b(String str) {
        this.f.c(str);
    }

    public void b(String str, b bVar) {
        p pVar = new p(w());
        this.q = pVar;
        pVar.a(true);
        this.q.setBackgroundColor(0);
        if (bVar != null) {
            bVar.a(this.q, (com.sigmob.sdk.base.common.t) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.f561c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.b(str);
    }

    public void b(boolean z) {
        if (z) {
            this.f.h();
        } else {
            this.f.g();
        }
    }

    public void c() {
        p pVar = this.q;
        if (pVar != null) {
            pVar.resumeTimers();
        }
        if (this.v) {
            this.f.a(true);
        }
        this.v = false;
    }

    public void c(boolean z) {
        if (z) {
            this.f.i();
        }
    }

    public void d() {
        this.f.a(new ExposureChange(100.0f, new Rect(0, 0, z().getWidth(), z().getHeight()), null));
    }

    public void d(boolean z) {
        this.v = true;
        p pVar = this.q;
        if (pVar != null) {
            pVar.b(z);
        }
    }

    public com.sigmob.sdk.mraid.b e() {
        return this.f;
    }

    protected void e(boolean z) {
        this.h = z;
        e eVar = this.n;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    public Integer f() {
        Integer num = this.i;
        if (num != null) {
            return num;
        }
        this.f.b(new ValueCallback<String>() { // from class: com.sigmob.sdk.mraid.d.5
            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                Float valueOf;
                try {
                    if (str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined") || (valueOf = Float.valueOf(str)) == null || valueOf.floatValue() <= 1.0E-5d) {
                        return;
                    }
                    d.this.i = Integer.valueOf((int) (valueOf.floatValue() * 1000.0f));
                    if (d.this.p != null) {
                        d.this.p.a(d.this.i);
                    }
                } catch (Throwable unused) {
                }
            }
        });
        return 0;
    }

    public p g() {
        return this.q;
    }

    boolean h() {
        Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f561c);
        if (c2 == null || g() == null) {
            return false;
        }
        if (this.a != PlacementType.INLINE) {
            return true;
        }
        return this.g.a(c2, g());
    }

    void i() {
        String str = ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape";
        DisplayMetrics displayMetrics = w().getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.C;
        if (gVar != null) {
            this.e.a(gVar.a(), this.C.b());
        } else {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        ViewGroup z = z();
        this.e.a(0, 0, z.getMeasuredWidth(), z.getMeasuredHeight());
        this.e.c(0, 0, z.getMeasuredWidth(), z.getMeasuredHeight());
        this.e.b(0, 0, z.getMeasuredWidth(), z.getMeasuredHeight());
        this.f.a(new CurrentAppOrientation(str, true));
        this.f.a(this.e);
    }

    @SuppressLint({"JavascriptInterface"})
    void j() {
        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.mraid.d.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.f.a(new MraidEnv());
                    d.this.f.a(d.this.g.b(d.this.w()), d.this.g.a(d.this.w()), i.d(d.this.w()), i.c(d.this.w()), d.this.h(), true, true);
                    d.this.f.a(d.this.a);
                    d.this.f.a(d.this.b.getRvAdSetting());
                    if (d.this.D != null) {
                        com.sigmob.sdk.base.utils.d a2 = com.sigmob.sdk.videoplayer.d.a(d.this.D);
                        d.this.f.a(a2.a(), a2.b(), a2.c(), a2.d());
                    }
                    if (!TextUtils.isEmpty(d.this.b.getVideo_url())) {
                        String proxyVideoUrl = d.this.b.getProxyVideoUrl();
                        d.this.f.a(d.this.b.getMaterial().video_size != null ? new VideoItem(proxyVideoUrl, d.this.b.getMaterial().video_size.width.intValue(), d.this.b.getMaterial().video_size.height.intValue()) : new VideoItem(proxyVideoUrl, 0, 0));
                        d.this.f();
                    }
                    MaterialMeta.Builder newBuilder = d.this.b.getMaterial().newBuilder();
                    if (!d.this.b.getMaterial().has_companion_endcard.booleanValue()) {
                        newBuilder = newBuilder.companion(null);
                    }
                    d.this.f.a(newBuilder.html_snippet(null).html_url(null).deeplink_url(null).landing_page(null).web_event_handle(null).endcard_url(null).build());
                    d.this.f.a(d.this.b.getAd().newBuilder().materials(new LinkedList()).ad_tracking(new LinkedList()).build(), d.this.b.getSlotAdSetting());
                } catch (Throwable th) {
                    SigmobLog.e("handleMraidLoad", th);
                }
                if (d.this.B) {
                    d.this.k();
                }
            }
        });
    }

    @SuppressLint({"JavascriptInterface"})
    void k() {
        try {
            this.B = true;
            i();
            b(ViewState.DEFAULT);
            d();
            this.f.e();
            this.f.a(true);
            try {
                this.f.j();
                o();
                DeviceContext b2 = com.sigmob.sdk.b.b();
                this.f.a(b2 != null ? b2.getLocation() : ClientMetadata.getInstance().getLocation());
            } catch (Throwable unused) {
                SigmobLog.e("Failed to apply orientation.");
            }
        } catch (Throwable th) {
            SigmobLog.e("handlePageLoad error", th);
        }
    }

    public void l() {
        this.v = false;
        p pVar = this.q;
        if (pVar != null) {
            pVar.onResume();
        }
    }

    public void m() {
        this.d.a();
        this.n = null;
        this.m = null;
        Iterator<j> it = this.w.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.w.clear();
        try {
            this.r.a();
        } catch (Throwable unused) {
        }
        try {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.A;
            if (aPKStatusBroadcastReceiver != null) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
        } catch (Throwable unused2) {
        }
        if (!this.v) {
            d(true);
        }
        y();
        p();
    }

    protected void n() {
        ViewState viewState;
        ViewState viewState2;
        if (this.q == null || (viewState = this.l) == ViewState.LOADING || viewState == (viewState2 = ViewState.HIDDEN)) {
            return;
        }
        ViewState viewState3 = ViewState.EXPANDED;
        if (viewState == viewState3 || this.a == PlacementType.INTERSTITIAL) {
            p();
        }
        ViewState viewState4 = this.l;
        if (viewState4 == ViewState.RESIZED || viewState4 == viewState3) {
            this.f561c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
            this.f561c.setVisibility(0);
            b(ViewState.DEFAULT);
        } else if (viewState4 == ViewState.DEFAULT) {
            this.f561c.setVisibility(4);
            b(viewState2);
        }
    }

    void o() {
        int a2;
        k kVar = this.u;
        if (kVar != k.NONE) {
            a2 = kVar.a();
        } else {
            if (this.t) {
                p();
                return;
            }
            Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f561c);
            if (c2 == null) {
                throw new com.sigmob.sdk.mraid.c("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            a2 = ClientMetadata.getInstance().getScreenOrientation(c2);
        }
        b(a2);
    }

    void p() {
        Integer num;
        try {
            Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f561c);
            if (c2 != null && (num = this.s) != null) {
                c2.setRequestedOrientation(num.intValue());
            }
            this.s = null;
        } catch (Exception e2) {
            SigmobLog.e("unApplyOrientation: " + e2.getMessage());
        }
    }

    public FrameLayout q() {
        return this.f561c;
    }

    @Deprecated
    ViewState r() {
        return this.l;
    }

    @Deprecated
    Integer s() {
        return this.s;
    }

    @Deprecated
    boolean t() {
        return this.t;
    }

    @Deprecated
    k u() {
        return this.u;
    }

    @Deprecated
    p v() {
        return this.q;
    }
}
