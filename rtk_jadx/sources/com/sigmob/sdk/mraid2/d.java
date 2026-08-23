package com.sigmob.sdk.mraid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.sdk.mraid2.g;
import com.sigmob.windad.WindAdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private final FrameLayout a;

    /* renamed from: c, reason: collision with root package name */
    private b f582c;
    private g d;
    private LinearLayout e;
    private l f;
    private c g;
    private List<BaseAdUnit> i;
    private com.sigmob.sdk.base.common.g j;
    private d k;
    private WindowInsets l;
    private boolean b = false;
    private List<g> h = new ArrayList();
    private g.b m = new g.b() { // from class: com.sigmob.sdk.mraid2.d.2
        @Override // com.sigmob.sdk.mraid2.g.b
        public LinearLayout a(g gVar, int i) {
            if (d.this.e == null) {
                d.this.e = new LinearLayout(d.this.f());
            }
            if (d.this.f == null) {
                if (i == 1) {
                    d.this.f = new j(d.this.f());
                    d.this.e.setOrientation(0);
                } else {
                    d.this.f = new o(d.this.f());
                    d.this.e.setOrientation(1);
                }
                d.this.f.setPageChangedListener(new c.InterfaceC0053c() { // from class: com.sigmob.sdk.mraid2.d.2.1
                    @Override // com.sigmob.sdk.mraid2.c.InterfaceC0053c
                    public void a(g gVar2, int i2, int i3) {
                        if (gVar2 == null || gVar2.getMraidBridge() == null) {
                            return;
                        }
                        gVar2.getMraidBridge().a(i2, i3);
                    }
                });
                d.this.f.getView().addView(d.this.e, new ViewGroup.LayoutParams(-1, -1));
                d.this.a.addView(d.this.f.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
            }
            if (gVar != null && gVar.getScrollTouchListener() == null) {
                gVar.setScrollTouchListener(new g.c() { // from class: com.sigmob.sdk.mraid2.d.2.2
                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void a(g gVar2, JSONObject jSONObject) {
                        int optInt = jSONObject.optInt("x");
                        int optInt2 = jSONObject.optInt("y");
                        if (d.this.f != null) {
                            d.this.f.a(gVar2, Dips.asIntPixels(optInt, d.this.f()), Dips.asIntPixels(optInt2, d.this.f()));
                        }
                    }

                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void a(JSONObject jSONObject) {
                        int optInt = jSONObject.optInt("x");
                        int optInt2 = jSONObject.optInt("y");
                        if (d.this.f != null) {
                            d.this.f.a(Dips.asIntPixels(optInt, d.this.f()), Dips.asIntPixels(optInt2, d.this.f()));
                        }
                    }

                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void b(JSONObject jSONObject) {
                        int optInt = jSONObject.optInt("x");
                        int optInt2 = jSONObject.optInt("y");
                        if (d.this.f != null) {
                            d.this.f.b(Dips.asIntPixels(optInt, d.this.f()), Dips.asIntPixels(optInt2, d.this.f()));
                        }
                    }
                });
            }
            return d.this.e;
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public g a(g gVar, JSONObject jSONObject) {
            d dVar = d.this;
            g a2 = dVar.a(dVar.f(), gVar, jSONObject);
            d.this.h.add(a2);
            return a2;
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a() {
            if (d.this.f582c != null) {
                d.this.f582c.d();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a(g gVar) {
            if (d.this.f582c != null) {
                d.this.f582c.b();
            }
            if (d.this.h == null || d.this.h.size() <= 0) {
                return;
            }
            for (int i = 0; i < d.this.h.size(); i++) {
                ((g) d.this.h.get(i)).a();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject) {
            if (d.this.f582c != null) {
                d.this.f582c.a(gVar, baseAdUnit, jSONObject);
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void b(g gVar) {
            if (d.this.f582c != null) {
                d.this.f582c.c();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void b(g gVar, JSONObject jSONObject) {
            d.this.b = jSONObject.optBoolean("flag");
            if (d.this.f582c != null) {
                d.this.f582c.a(d.this.b);
            }
        }
    };

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4);

        void a(BaseAdUnit baseAdUnit);

        boolean a(ConsoleMessage consoleMessage);

        boolean a(String str, JsResult jsResult);

        void b();

        void c();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(View view);

        void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(WindAdError windAdError);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends BroadcastReceiver {
        private Context b;

        /* renamed from: c, reason: collision with root package name */
        private int f583c = -1;

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
            int screenOrientation;
            if (this.b == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (screenOrientation = ClientMetadata.getInstance().getScreenOrientation(d.this.f())) == this.f583c) {
                return;
            }
            this.f583c = screenOrientation;
            d.this.a(screenOrientation);
        }
    }

    public d(Context context, List<BaseAdUnit> list) {
        Preconditions.checkNotNull(context);
        this.i = list;
        FrameLayout frameLayout = new FrameLayout(context);
        this.a = frameLayout;
        frameLayout.setBackgroundColor(0);
        c cVar = new c();
        this.g = cVar;
        cVar.a(context);
        g gVar = new g(context, list, frameLayout);
        this.d = gVar;
        gVar.setLoadListener(new g.a() { // from class: com.sigmob.sdk.mraid2.d.1
            @Override // com.sigmob.sdk.mraid2.g.a
            public void a(g gVar2) {
                try {
                    if (d.this.f582c != null) {
                        d.this.f582c.a(d.this.d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.g.a
            public void a(WindAdError windAdError) {
                try {
                    if (d.this.f582c != null) {
                        d.this.f582c.a(windAdError);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.d.setNextWebViewListener(this.m);
        this.h.clear();
        this.h.add(this.d);
        frameLayout.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(Context context, g gVar, JSONObject jSONObject) {
        g gVar2 = new g(context, this.i, this.a, gVar, jSONObject);
        gVar2.setAdSize(this.j);
        gVar2.setNextWebViewListener(this.m);
        return gVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context f() {
        FrameLayout frameLayout = this.a;
        if (frameLayout != null) {
            return frameLayout.getContext();
        }
        return null;
    }

    public void a() {
        List<g> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            g gVar = this.h.get(i);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        SigmobLog.i("handleOrientationChange " + i);
        List<g> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            g gVar = this.h.get(i2);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().e();
                gVar.getMraidBridge().a(this.j);
            }
        }
    }

    public void a(WindowInsets windowInsets, boolean z) {
        this.l = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (z) {
            com.sigmob.sdk.base.utils.d a2 = com.sigmob.sdk.videoplayer.d.a(windowInsets);
            List<g> list = this.h;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.h.size(); i++) {
                g gVar = this.h.get(i);
                if (gVar.getMraidBridge() != null) {
                    gVar.getMraidBridge().a(a2.a(), a2.b(), a2.c(), a2.d());
                }
            }
        }
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.j = gVar;
        this.d.setAdSize(gVar);
        this.d.l();
    }

    public void a(BaseAdUnit baseAdUnit) {
        SigmobLog.e("onShow start");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid2.d.3
            @Override // java.lang.Runnable
            public void run() {
                SigmobLog.e("onShow end");
                if (d.this.f582c != null) {
                    d.this.f582c.a(d.this.b);
                }
            }
        }, 5 * 1000);
    }

    public void a(a aVar) {
        this.d.getMraidBridge().a(aVar);
    }

    public void a(b bVar) {
        this.f582c = bVar;
    }

    public void b() {
        List<g> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            g gVar = this.h.get(i);
            gVar.j();
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().a(true);
            }
        }
    }

    public g c() {
        return this.d;
    }

    public void d() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a();
            this.g = null;
        }
        try {
            Iterator<g> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.h.clear();
            this.d = null;
            this.f582c = null;
        } catch (Throwable unused) {
        }
    }

    public FrameLayout e() {
        return this.a;
    }
}
