package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.nativead.d;
import com.sigmob.sdk.nativead.m;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y implements View.OnClickListener, View.OnTouchListener, d.a, m.a, z, WindNativeAdData.DislikeInteractionCallback {
    private static Stack<u> O = new Stack<>();
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private int A;
    private boolean D;
    private boolean E;
    private boolean F;
    private List<View> G;
    private long H;
    private View J;
    private boolean K;
    private WindNativeAdData.DislikeInteractionCallback L;
    private boolean M;
    private u N;
    private Bitmap P;
    protected WindNativeAdData a;
    protected BaseAdUnit b;

    /* renamed from: c, reason: collision with root package name */
    protected h f622c;
    private o h;
    private m i;
    private d l;
    private k m;
    private MotionEvent n;
    private c o;
    private NativeADEventListener p;
    private boolean q;
    private boolean r;
    private ViewGroup s;
    private ViewGroup.LayoutParams t;
    private Bitmap u;
    private com.sigmob.sdk.base.views.q v;
    private boolean w;
    private s x;
    private boolean y;
    private boolean z;
    private List<View> j = new ArrayList();
    private HashSet<View> k = new HashSet<>();
    private boolean B = true;
    private boolean C = false;
    private List<View> I = new ArrayList();
    private q.b Q = new q.b() { // from class: com.sigmob.sdk.nativead.y.6
        @Override // com.sigmob.sdk.base.views.q.b
        public void a() {
            if (y.this.v != null) {
                y.this.v.dismiss();
                y.this.v.c();
                y.this.v = null;
            }
            y.this.w = false;
            y.this.b.getClickCommon().click_scene = "preview";
            y.this.j().a(com.sigmob.sdk.base.common.a.g, 0);
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void a(String str, String str2) {
            BaseAdUnit baseAdUnit = y.this.b;
            if (baseAdUnit != null) {
                baseAdUnit.getClickCommon().sld = "0";
                y.this.b.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                y.this.b.getClickCommon().click_scene = "appinfo";
                y.this.b.getClickCommon().is_final_click = true;
                if (y.this.w) {
                    y.this.x().a(com.sigmob.sdk.base.a.PREVIEW, str, str2, true);
                }
            }
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void b() {
            if (y.this.h != null) {
                y.this.r().a();
            }
            y.this.j().a(com.sigmob.sdk.base.common.a.f, 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Context J() {
        return com.sigmob.sdk.b.e();
    }

    private void K() {
        try {
            Activity d2 = com.sigmob.sdk.base.utils.f.d(L());
            if (this.v == null && d2 != null) {
                com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(d2, this.b);
                this.v = qVar;
                qVar.a(this.Q);
            }
            com.sigmob.sdk.base.views.q qVar2 = this.v;
            if (qVar2 == null || !qVar2.a() || this.w) {
                return;
            }
            this.b.getClickCommon().click_area = "appinfo";
            this.v.show();
            this.w = true;
        } catch (Exception e2) {
            SigmobLog.e("openFourElements fail:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View L() {
        View view;
        m mVar = this.i;
        if (mVar == null || (view = (View) mVar.getParent()) == null) {
            return null;
        }
        return view;
    }

    private boolean M() {
        return this.b.isExpiredAd();
    }

    private boolean N() {
        return false;
    }

    private View a(HashSet<View> hashSet, MotionEvent motionEvent) {
        if (hashSet == null) {
            return null;
        }
        Iterator<View> it = hashSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (com.sigmob.sdk.base.utils.f.a(next, motionEvent)) {
                return next;
            }
        }
        return null;
    }

    private View a(List<View> list, MotionEvent motionEvent) {
        if (list == null) {
            return null;
        }
        for (View view : list) {
            if (com.sigmob.sdk.base.utils.f.a(view, motionEvent)) {
                return view;
            }
        }
        return null;
    }

    private o a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof o) {
                return (o) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            com.sigmob.sdk.base.models.BaseAdUnit r0 = r8.b
            com.sigmob.sdk.base.common.h.a(r0)
            r0 = 0
            if (r10 == 0) goto L2d
            android.view.View r0 = r8.L()
            com.czhj.sdk.common.utils.TouchLocation r0 = com.czhj.sdk.common.utils.TouchLocation.getTouchLocation(r0, r10)
            android.view.View r10 = r8.L()
            android.view.MotionEvent r1 = r8.n
            com.czhj.sdk.common.utils.TouchLocation r10 = com.czhj.sdk.common.utils.TouchLocation.getTouchLocation(r10, r1)
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r1 = r1.getClickCommon()
            r1.down = r10
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r1 = r1.getClickCommon()
            r1.up = r10
            r4 = r10
            r5 = r0
            goto L2f
        L2d:
            r4 = r0
            r5 = r4
        L2f:
            com.sigmob.sdk.base.models.BaseAdUnit r10 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r10 = r10.getClickCommon()
            java.lang.String r0 = "preview"
            r10.click_scene = r0
            java.lang.String r10 = "click"
            r0 = 1
            r1 = 0
            if (r9 == r0) goto Lc1
            r2 = 2
            if (r9 == r2) goto L4e
            r10 = 3
            if (r9 == r10) goto L4c
            r10 = 4
            if (r9 == r10) goto L4a
            goto Lc0
        L4a:
            r9 = 0
            goto L72
        L4c:
            r9 = 0
            goto L7f
        L4e:
            boolean r9 = r8.N()
            com.sigmob.sdk.base.models.BaseAdUnit r3 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r3 = r3.getClickCommon()
            java.lang.String r6 = "material"
            r3.click_area = r6
            if (r9 == 0) goto L71
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            r9.is_final_click = r1
            com.sigmob.sdk.base.common.ag r9 = r8.j()
            r9.a(r10, r1)
            r8.y()
            return
        L71:
            r9 = 1
        L72:
            if (r9 != 0) goto L7f
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            java.lang.String r10 = "component"
            r9.click_area = r10
            r9 = 1
        L7f:
            if (r9 != 0) goto L8b
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            java.lang.String r10 = "btn"
            r9.click_area = r10
        L8b:
            boolean r9 = r8.M
            if (r9 != 0) goto L98
            com.sigmob.windad.natives.WindNativeAdData r9 = r8.a
            int r9 = r9.getAdPatternType()
            if (r9 != r0) goto L98
            goto La9
        L98:
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            int r9 = r9.getInteractionType()
            if (r9 != r2) goto La9
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            r9.is_final_click = r1
            goto Lb1
        La9:
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            r9.is_final_click = r0
        Lb1:
            com.sigmob.sdk.nativead.c r2 = r8.x()
            android.content.Context r3 = r8.J()
            com.sigmob.sdk.base.a r6 = com.sigmob.sdk.base.a.PREVIEW
            com.sigmob.sdk.base.models.BaseAdUnit r7 = r8.b
            r2.a(r3, r4, r5, r6, r7)
        Lc0:
            return
        Lc1:
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            java.lang.String r0 = "appinfo"
            r9.click_area = r0
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r8.b
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            r9.is_final_click = r1
            com.sigmob.sdk.base.common.ag r9 = r8.j()
            if (r9 == 0) goto Ldc
            r9.a(r10, r1)
        Ldc:
            r8.K()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.y.a(int, android.view.MotionEvent):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (view.getParent() instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            layoutParams = layoutParams2;
        } else if (view.getParent() instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams = layoutParams3;
        } else {
            if (!(view.getParent() instanceof LinearLayout)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            layoutParams = layoutParams4;
        }
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    private boolean a(MotionEvent motionEvent) {
        o oVar = this.h;
        if (oVar != null) {
            return oVar.a(motionEvent);
        }
        return false;
    }

    private m b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof m) {
                return (m) childAt;
            }
        }
        return null;
    }

    public String A() {
        return k().getCTAText();
    }

    public Bitmap B() {
        return this.u;
    }

    public void C() {
        o oVar;
        q r;
        if (this.r || !this.D || (oVar = this.h) == null || oVar.getParent() == null || (r = r()) == null) {
            return;
        }
        r.c();
    }

    public void D() {
        q r;
        if (this.r || (r = r()) == null) {
            return;
        }
        this.z = true;
        r.a();
    }

    public void E() {
        o oVar;
        if (this.s != null && (oVar = this.h) != null) {
            ViewParent parent = oVar.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.h);
            }
            this.s.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.t;
            if (layoutParams != null) {
                this.s.addView(this.h, layoutParams);
            } else {
                this.s.addView(this.h);
            }
            if (!this.k.contains(this.h)) {
                this.k.add(this.h);
            }
        }
        this.s = null;
        this.t = null;
    }

    public void F() {
        o oVar;
        q r;
        if (this.r || !this.D || (oVar = this.h) == null || oVar.getParent() == null || (r = r()) == null) {
            return;
        }
        r.b();
    }

    public void G() {
        q r;
        if (this.r || (r = r()) == null) {
            return;
        }
        r.d();
    }

    public String H() {
        BiddingResponse biddingResponse;
        BaseAdUnit baseAdUnit = this.b;
        return (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) ? "" : String.valueOf(biddingResponse.ecpm);
    }

    public String I() {
        SigVideo nativeVideo = this.b.getNativeVideo();
        if (nativeVideo != null) {
            return nativeVideo.getThumbUrl();
        }
        return null;
    }

    public View a(int i, int i2) {
        if (this.N == null && this.b != null) {
            u uVar = new u(J());
            if (!uVar.a((int) this.b.getWidgetId(0), this.b.getSensitivity(), this.b.getClickCommon())) {
                return null;
            }
            uVar.setMotionActionListener(new b() { // from class: com.sigmob.sdk.nativead.y.7
                @Override // com.sigmob.sdk.nativead.b
                public void a() {
                    y.this.a(4, (MotionEvent) null);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Dips.dipsToIntPixels(i, J()), Dips.dipsToIntPixels(i2, J()));
            layoutParams.gravity = 17;
            uVar.setLayoutParams(layoutParams);
            this.N = uVar;
        }
        return this.N;
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void a() {
        if (x() != null) {
            x().a(J(), this.b);
        }
    }

    public void a(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        m mVar;
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP);
                return;
            }
            return;
        }
        if (com.sigmob.sdk.b.h() == null) {
            com.sigmob.sdk.b.a(com.sigmob.sdk.base.utils.f.d(view));
        }
        if (view2 != null) {
            if (this.x == null) {
                a aVar = new a(view2.getContext(), this.b);
                this.x = aVar;
                aVar.a(this);
            }
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.nativead.y.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1 && y.this.x != null) {
                        y.this.x.a();
                    }
                    return true;
                }
            });
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.nativead.y.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (y.this.b != null) {
                    viewGroup.getLocationOnScreen(new int[2]);
                    y.this.b.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r0[0], y.this.J()));
                    y.this.b.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r0[1], y.this.J()));
                    y.this.b.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(viewGroup.getWidth(), y.this.J()));
                    y.this.b.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(viewGroup.getHeight(), y.this.J()));
                }
            }
        });
        u uVar = (u) com.sigmob.sdk.base.utils.f.a(viewGroup, u.class);
        if (uVar != null && uVar != this.N) {
            com.sigmob.sdk.base.utils.f.a(uVar);
        }
        x().a(new com.sigmob.sdk.base.common.ac() { // from class: com.sigmob.sdk.nativead.y.5
            @Override // com.sigmob.sdk.base.common.ac
            public void a(boolean z, com.sigmob.sdk.base.a aVar2) {
                ag j;
                if (y.this.p != null) {
                    y.this.p.onAdClicked();
                }
                if (z && (j = y.this.j()) != null) {
                    j.a("click", 0);
                }
            }
        });
        if (list2 != null) {
            this.j = list2;
        }
        List<View> list3 = this.I;
        if (list3 != null) {
            this.k.removeAll(list3);
        }
        if (list != null) {
            this.I = list;
        }
        this.p = nativeADEventListener;
        o().a((Map<String, Object>) null, this.b);
        com.sigmob.sdk.base.common.h.g().a(this.b, (h.b) null);
        m mVar2 = this.i;
        if (mVar2 == null) {
            m b = b(viewGroup);
            this.i = b;
            if (b == null) {
                mVar = new m(J());
                this.i = mVar;
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            this.k.addAll(this.I);
            this.i.setAdVisibilityStatusChangeListener(this);
            this.i.a(x().s(), x().t());
        }
        com.sigmob.sdk.base.utils.f.a(mVar2);
        mVar = this.i;
        layoutParams = new ViewGroup.LayoutParams(0, 0);
        viewGroup.addView(mVar, layoutParams);
        this.k.addAll(this.I);
        this.i.setAdVisibilityStatusChangeListener(this);
        this.i.a(x().s(), x().t());
    }

    public void a(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        this.M = true;
        b(viewGroup, nativeADMediaListener);
    }

    public void a(BaseAdUnit baseAdUnit, WindNativeAdData windNativeAdData) {
        this.b = baseAdUnit;
        this.a = windNativeAdData;
        if (this.h == null && baseAdUnit.getNativeAd().type.intValue() == 1) {
            this.h = new o(com.sigmob.sdk.b.e());
        }
        com.sigmob.sdk.base.common.h.a().getBitmap(k().getAd_source_logo(), new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.nativead.y.1
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                y.this.u = bitmap;
            }
        });
    }

    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.L = dislikeInteractionCallback;
    }

    public void a(HashSet<View> hashSet, View.OnTouchListener onTouchListener) {
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setOnClickListener(null);
                    next.setOnTouchListener(null);
                    next.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void a(List<ImageView> list, int i) {
        List<SigImage> imageUrlList = k().getImageUrlList();
        if (list == null || imageUrlList == null) {
            return;
        }
        int min = Math.min(list.size(), imageUrlList.size());
        for (int i2 = 0; i2 < min; i2++) {
            SigImage sigImage = imageUrlList.get(i2);
            ImageView imageView = list.get(i2);
            if (!this.k.contains(imageView)) {
                this.k.add(imageView);
            }
            List<View> list2 = this.G;
            if (list2 == null) {
                this.G = new ArrayList();
            } else {
                list2.clear();
            }
            this.G.add(imageView);
            com.sigmob.sdk.base.common.h.a().load(sigImage.getImageUrl()).placeholder(i).error(i).into(imageView);
        }
    }

    public void a(List<View> list, View.OnTouchListener onTouchListener) {
        if (list != null) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                    view.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    @Override // com.sigmob.sdk.nativead.m.a
    public void a(boolean z) {
        if (this.y) {
            return;
        }
        if (!this.r) {
            com.sigmob.sdk.base.common.h.g().e(this.b);
            if (z) {
                NativeADEventListener nativeADEventListener = this.p;
                if (nativeADEventListener != null) {
                    nativeADEventListener.onAdExposed();
                }
                j().a("ad_show", 0);
            }
        }
        this.y = z;
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void b() {
        if (x() != null) {
            x().b(J(), this.b);
        }
    }

    public void b(ViewGroup viewGroup, final WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (viewGroup == null) {
            return;
        }
        o oVar = (o) com.sigmob.sdk.base.utils.f.a(viewGroup, o.class);
        if (oVar != null) {
            com.sigmob.sdk.base.utils.f.a(oVar);
        }
        o oVar2 = this.h;
        if (oVar2 != null) {
            com.sigmob.sdk.base.utils.f.a(oVar2);
            viewGroup.addView(this.h, new ViewGroup.LayoutParams(-1, -2));
        }
        if (!this.k.contains(this.h)) {
            this.k.add(this.h);
        }
        if (!this.b.equals(this.h.getAdUnit())) {
            this.h.a(this);
        }
        final q sigVideoAdController = this.h.getSigVideoAdController();
        if (sigVideoAdController != null) {
            sigVideoAdController.a(new i() { // from class: com.sigmob.sdk.nativead.y.2
                @Override // com.sigmob.sdk.nativead.i
                public void a() {
                    y.this.j().a("video_restart", 0);
                }

                @Override // com.sigmob.sdk.nativead.i
                public void a(long j, long j2) {
                    y.this.b.getVideoCommon().end_time = sigVideoAdController.j();
                    c x = y.this.x();
                    if (x != null) {
                        for (com.sigmob.sdk.videoAd.f fVar : x.a(j, j2)) {
                            y.this.j().a(fVar.getEvent(), sigVideoAdController.j());
                            fVar.setTracked();
                        }
                    }
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoCompleted() {
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoCompleted();
                    }
                    y.this.b.getVideoCommon().end_time = sigVideoAdController.e();
                    y.this.b.getVideoCommon().is_last = 1;
                    y.this.j().a("complete", sigVideoAdController.j());
                    y.this.j().a("video_link", 0);
                    y.this.C = false;
                    y.this.z = false;
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoError(WindAdError windAdError) {
                    y.this.z = false;
                    y.this.C = false;
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoError(windAdError);
                    }
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoLoad() {
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoLoad();
                    }
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoPause() {
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoPause();
                    }
                    y.this.C = true;
                    y.this.j().a("video_pause", 0);
                    y.this.j().a("video_link", 0);
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoResume() {
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoResume();
                    }
                    y.this.C = false;
                    y.this.b.getVideoCommon().type = 2;
                    y.this.b.getVideoCommon().is_first = 0;
                    y.this.b.getVideoCommon().begin_time = sigVideoAdController.j();
                    y.this.z = false;
                    y.this.j().a("video_start", sigVideoAdController.j());
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
                public void onVideoStart() {
                    View L = y.this.L();
                    if (L != null) {
                        y.this.b.setAdSize(L.getWidth(), L.getHeight());
                    }
                    y.this.b.getVideoCommon().video_time = sigVideoAdController.e();
                    y.this.b.getVideoCommon().is_first = 1;
                    y.this.b.getVideoCommon().is_last = 0;
                    y.this.b.getVideoCommon().end_time = 0;
                    y.this.b.getVideoCommon().is_auto_play = y.this.x().u() ? 1 : 2;
                    if (y.this.r) {
                        y.this.b.getVideoCommon().scene = 3;
                    } else {
                        y.this.b.getVideoCommon().scene = 1;
                    }
                    if (y.this.B) {
                        y.this.b.getVideoCommon().type = 1;
                        y.this.B = false;
                    } else {
                        y.this.b.getVideoCommon().type = 3;
                    }
                    WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                    if (nativeADMediaListener2 != null) {
                        nativeADMediaListener2.onVideoStart();
                    }
                    y.this.z = false;
                    y.this.C = false;
                    y.this.j().a("video_start", 0);
                }
            });
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit) {
        o oVar = this.h;
        if (oVar != null) {
            ViewGroup.LayoutParams layoutParams = ((View) oVar.getParent()).getLayoutParams();
            SigmobLog.d("visibilityStatusChange() called with: isVisible = [" + layoutParams.width + ":" + layoutParams.height + "]");
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
    }

    public void b(boolean z) {
        q r;
        if (this.r || (r = r()) == null) {
            return;
        }
        r.a(z);
    }

    @Override // com.sigmob.sdk.nativead.d.a
    public void c() {
        SigmobLog.d("----------onAdDetailShow----------");
        if (x() != null) {
            x().c(J(), this.b);
        }
        this.r = true;
        NativeADEventListener nativeADEventListener = this.p;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailShow();
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void c(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.nativead.d.a
    public void d() {
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.nativead.d.a
    public void e() {
        this.r = false;
        NativeADEventListener nativeADEventListener = this.p;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailDismiss();
        }
        if (x() != null) {
            x().d(J(), this.b);
        }
        E();
        k kVar = this.m;
        if (kVar != null) {
            kVar.setVisibility(0);
        }
        d dVar = this.l;
        if (dVar != null) {
            dVar.b(this.b);
        }
        View L = L();
        if (L != null) {
            x().a(com.sigmob.sdk.base.utils.f.c(L), this.b, this.Q);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void e(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.nativead.m.a
    public void f() {
        if (this.D) {
            u uVar = this.N;
            if (uVar != null) {
                uVar.b();
                O.remove(this.N);
            }
            q r = r();
            if (r != null) {
                r.a();
            }
            SigmobLog.d("-----------onAdViewPauseImpression---------");
            this.D = false;
        }
    }

    @Override // com.sigmob.sdk.nativead.m.a
    public void g() {
        u lastElement;
        u uVar;
        if (this.N != null && !O.isEmpty() && (lastElement = O.lastElement()) != null && lastElement == (uVar = this.N)) {
            uVar.a();
        }
        if (this.r || this.D) {
            return;
        }
        this.D = true;
        u uVar2 = this.N;
        if (uVar2 != null && !O.contains(uVar2)) {
            O.push(this.N);
            this.N.a();
        }
        o oVar = this.h;
        if (oVar == null || oVar.getParent() == null) {
            return;
        }
        c x = x();
        if (!this.z && x != null && x.u()) {
            r().c();
        }
        SigmobLog.d("------------onAdViewStartImpression------------");
    }

    @Override // com.sigmob.sdk.nativead.m.a
    public void h() {
        if (this.r || J() == null || !this.E) {
            return;
        }
        HashSet<View> hashSet = this.k;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.E = false;
        u uVar = this.N;
        if (uVar != null) {
            uVar.b();
            O.remove(this.N);
        }
        SigmobLog.d("------------onAdViewRemoved----------" + hashCode());
        q r = r();
        if (r != null) {
            r.a();
        }
        this.D = false;
        m mVar = this.i;
        if (mVar != null && mVar.hasWindowFocus()) {
            this.y = false;
        }
        ag j = j();
        if (j != null) {
            j.a("ad_hide", 0);
        }
        if (this.B || this.C || j == null) {
            return;
        }
        j.a("video_link", 0);
    }

    @Override // com.sigmob.sdk.nativead.m.a
    public void i() {
        if (this.E || this.r) {
            return;
        }
        this.E = true;
        SigmobLog.d("----------onAdViewShow------------" + hashCode());
        this.z = false;
        this.D = false;
        View L = L();
        if (L != null) {
            x().a(com.sigmob.sdk.base.utils.f.c(L), this.b, this.Q);
            L.setOnTouchListener(this);
        }
        o oVar = this.h;
        if (oVar != null && !this.k.contains(oVar)) {
            this.k.add(this.h);
        } else if (this.G != null) {
            if (this.k.isEmpty()) {
                this.k.addAll(this.G);
            } else {
                for (View view : this.G) {
                    if (!this.k.contains(view)) {
                        this.k.add(view);
                    }
                }
            }
        }
        u uVar = this.N;
        if (uVar != null && !this.k.contains(uVar)) {
            this.k.add(this.N);
        }
        this.k.addAll(this.I);
        a(this.j, this);
        a(this.k, this);
        ag j = j();
        if (j != null) {
            j.a("start", 0);
        }
    }

    public ag j() {
        BaseAdUnit baseAdUnit = this.b;
        if (baseAdUnit == null) {
            return null;
        }
        ag sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        f fVar = new f();
        fVar.a(this.b);
        return fVar;
    }

    @Override // com.sigmob.sdk.nativead.z
    public BaseAdUnit k() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.z
    public WindNativeAdData l() {
        return this.a;
    }

    @Override // com.sigmob.sdk.nativead.z
    public k m() {
        if (!this.M && this.m == null && this.b.getadPrivacy() != null) {
            k kVar = new k(J());
            this.m = kVar;
            kVar.setOnTouchListener(this);
            this.m.a(this.b.getAppVersion(), this.b.getCompanyName());
        }
        return this.m;
    }

    public boolean n() {
        d dVar = this.l;
        if (dVar != null) {
            return dVar.a(this.b);
        }
        return false;
    }

    public d o() {
        if (this.l == null) {
            this.l = new d(this);
        }
        return this.l;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onCancel() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.L;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.L;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onSelected(i, str, z);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onShow() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.L;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if ((motionEvent.getAction() != 0 || this.H <= 0 || System.currentTimeMillis() - this.H >= 500) && this.b != null) {
            try {
                if (motionEvent.getAction() != 1) {
                    this.H = System.currentTimeMillis();
                    this.n = motionEvent;
                    return true;
                }
                this.b.getClickCommon().click_scene = "preview";
                this.b.getClickCommon().sld = "0";
                if (view == this.m) {
                    SigmobLog.d("click mSigAppInfoView");
                    a(1, motionEvent);
                    return true;
                }
                SigmobLog.d("click " + view);
                List<View> list = this.j;
                int i = 3;
                if (list != null) {
                    if ((list.contains(view) ? view : a(this.j, motionEvent)) != null) {
                        SigmobLog.d("click ctaClickView");
                        this.b.getClickCommon().click_scene = "preview";
                        this.b.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                        a(3, motionEvent);
                        return true;
                    }
                }
                HashSet<View> hashSet = this.k;
                if (hashSet != null) {
                    if (!hashSet.contains(view)) {
                        view = a(this.k, motionEvent);
                    }
                    if (view != null) {
                        SigmobLog.d("click mCreativeViews");
                        o oVar = this.h;
                        if (!(oVar != null && oVar.a(motionEvent))) {
                            i = 2;
                        }
                        a(i, motionEvent);
                        return true;
                    }
                }
            } catch (Throwable th) {
                SigmobLog.e("onTouch error", th);
            }
        }
        return false;
    }

    public int p() {
        int width;
        View L = L();
        return (this.h == null || L == null || (width = L.getWidth()) <= 0) ? LogType.UNEXP_ANR : width;
    }

    public View q() {
        return this.h;
    }

    public q r() {
        if (q() != null) {
            return this.h.getSigVideoAdController();
        }
        return null;
    }

    public double s() {
        if (r() != null) {
            return r0.e();
        }
        return 0.0d;
    }

    public double t() {
        if (r() != null) {
            return r0.f();
        }
        return 0.0d;
    }

    public int u() {
        View L = L();
        if (q() == null || L == null || L.getWidth() <= 0) {
            return 720;
        }
        return (int) (L.getWidth() / this.b.getAdPercent());
    }

    public void v() {
        a(this.k, (View.OnTouchListener) null);
        a(this.j, (View.OnTouchListener) null);
        HashSet<View> hashSet = this.k;
        if (hashSet != null) {
            hashSet.clear();
        }
        List<View> list = this.j;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.I;
        if (list2 != null) {
            list2.clear();
        }
        this.p = null;
        this.f622c = null;
    }

    public void w() {
        Object[] objArr = new Object[1];
        BaseAdUnit baseAdUnit = this.b;
        objArr[0] = baseAdUnit != null ? baseAdUnit.getVid() : "null";
        SigmobLog.i(String.format("native ad data %s is Destroy", objArr));
        v();
        List<View> list = this.G;
        if (list != null) {
            list.clear();
        }
        o oVar = this.h;
        if (oVar != null) {
            com.sigmob.sdk.base.utils.f.a(oVar);
            this.h.c();
            this.h = null;
        }
        BaseAdUnit baseAdUnit2 = this.b;
        if (baseAdUnit2 != null && baseAdUnit2.getSessionManager() != null) {
            j().a("ad_hide", 0);
            j().a();
        }
        u uVar = this.N;
        if (uVar != null) {
            uVar.c();
            O.remove(this.N);
            com.sigmob.sdk.base.utils.f.a(this.N);
            this.N = null;
        }
        com.sigmob.sdk.base.common.h.g().e(this.b);
        com.sigmob.sdk.base.common.h.b(this.b);
        com.sigmob.sdk.base.views.q qVar = this.v;
        if (qVar != null) {
            qVar.dismiss();
            this.v.c();
            this.v = null;
        }
        s sVar = this.x;
        if (sVar != null && (sVar instanceof a)) {
            sVar.a(null);
            a aVar = (a) this.x;
            aVar.dismiss();
            aVar.b();
            this.x = null;
        }
        this.L = null;
        this.Q = null;
        m mVar = this.i;
        if (mVar != null) {
            mVar.setAdVisibilityStatusChangeListener(null);
            com.sigmob.sdk.base.utils.f.a(this.i);
            this.i = null;
        }
        d dVar = this.l;
        if (dVar != null) {
            dVar.b(this.b);
            this.l = null;
        }
        BaseAdUnit baseAdUnit3 = this.b;
        if (baseAdUnit3 != null) {
            baseAdUnit3.destroy();
        }
    }

    @Override // com.sigmob.sdk.nativead.z
    public c x() {
        BaseAdUnit baseAdUnit;
        if (this.o == null && (baseAdUnit = this.b) != null) {
            this.o = (c) baseAdUnit.getAdConfig();
        }
        return this.o;
    }

    public void y() {
        Bundle bundle = new Bundle();
        if (this.h != null && x().l()) {
            ab abVar = new ab();
            int[] iArr = new int[2];
            this.h.getLocationOnScreen(iArr);
            abVar.a(iArr[0]);
            abVar.b(iArr[1]);
            abVar.c(this.h.getMeasuredWidth());
            abVar.d(this.h.getMeasuredHeight());
            bundle.putParcelable("attr", abVar);
            this.s = (ViewGroup) this.h.getParent();
            this.t = this.h.getLayoutParams();
            w.a(this.h);
            SigMacroCommon macroCommon = this.b.getMacroCommon();
            if (macroCommon != null) {
                macroCommon.addMarcoKey(SigMacroCommon._SCENE_, GlobalSetting.SPLASH_AD);
            }
            this.r = true;
        }
        k kVar = this.m;
        if (kVar != null) {
            kVar.setVisibility(4);
        }
        o().a(this.b, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        int interactionType = this.b.getInteractionType();
        if (interactionType == 2) {
            return 1;
        }
        return interactionType == 0 ? 0 : 2;
    }
}
