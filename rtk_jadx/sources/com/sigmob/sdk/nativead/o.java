package com.sigmob.sdk.nativead;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ImageUtils;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.LinkedList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o extends p implements i, com.sigmob.sdk.videoplayer.c {
    public static LinkedList<ViewGroup> e = new LinkedList<>();
    public static long f = 0;
    private com.sigmob.sdk.videoplayer.g h;
    private l i;
    private q j;
    private Bitmap k;
    private Bitmap l;
    private ViewGroup m;
    private Context n;
    private long o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.nativead.o$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.DETAIL_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.DETAIL_PAGE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o(Context context) {
        super(context.getApplicationContext());
        this.k = null;
        this.l = null;
        this.n = context.getApplicationContext();
        getVideoAdView().setVideoAdViewListener(this);
        this.m = new RelativeLayout(this.n);
        getVideoAdView().setVideoAdStatusListener(this);
        com.sigmob.sdk.base.blurkit.a.a(this.n);
    }

    private void a(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 21 ? 5894 : 4);
    }

    private void a(ViewGroup viewGroup) {
        k kVar = null;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof k) {
                kVar = (k) childAt;
            }
        }
        if (kVar != null) {
            com.sigmob.sdk.base.utils.f.a(kVar);
        }
    }

    private void b(Activity activity) {
        int asIntPixels = Dips.asIntPixels(10.0f, this.n);
        int asIntPixels2 = Dips.asIntPixels(15.0f, this.n);
        int a = com.sigmob.sdk.videoplayer.d.a(activity);
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
            activity.setRequestedOrientation(0);
            asIntPixels += a;
        } else {
            asIntPixels2 += a;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getVideoAdView().getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.n), 0, asIntPixels, asIntPixels2);
            getVideoAdView().getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getVideoAdView().getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(35.0f, this.n), asIntPixels, 0);
            getVideoAdView().getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    private void k() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getVideoAdView().getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(com.sigmob.sdk.base.blurkit.c.d, this.n), Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(15.0f, this.n));
            getVideoAdView().getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getVideoAdView().getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(15.0f, this.n), Dips.asIntPixels(10.0f, this.n), 0);
            getVideoAdView().getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    private void l() {
        if (this.i != null) {
            ViewGroup appContainer = getVideoAdView().getAppContainer();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            appContainer.addView(this.i, layoutParams);
        }
    }

    private void m() {
        Bitmap textureBitmap;
        if (getVideoAdView() == null || (textureBitmap = getVideoAdView().getTextureBitmap()) == null) {
            return;
        }
        Bitmap a = com.sigmob.sdk.base.blurkit.a.a().a(textureBitmap, 25);
        getVideoAdView().getBlurImageView().setImageBitmap(a);
        getVideoAdView().getAppContainer().setVisibility(0);
        this.k = textureBitmap;
        this.l = a;
    }

    private void n() {
        k appInfoView = getAppInfoView();
        if (appInfoView != null) {
            com.sigmob.sdk.base.utils.f.a(appInfoView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, Dips.asIntPixels(5.0f, this.n));
            layoutParams.addRule(12);
            addView(appInfoView, layoutParams);
        }
    }

    public int a(int i) {
        double adPercent = getVideoAdView().getVideoWidth() == 0 ? getAdUnit().getAdPercent() : (getVideoAdView().getVideoWidth() * 1.0f) / getVideoAdView().getVideoHeight();
        int i2 = ClientMetadata.getInstance().getDisplayMetrics().heightPixels / 2;
        int i3 = (int) (i / adPercent);
        return i3 > i2 ? i2 : i3;
    }

    @Override // com.sigmob.sdk.nativead.i
    public void a() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().a();
        }
    }

    @Override // com.sigmob.sdk.nativead.i
    public void a(long j, long j2) {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().a(j, j2);
        }
        if (j > 0) {
            this.o = j2;
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void a(z zVar) {
        super.a(zVar);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit != null) {
            a(this);
            File videoProxyFile = adUnit.getVideoProxyFile();
            if (videoProxyFile == null || !videoProxyFile.exists()) {
                getVideoAdView().setUp(adUnit.getProxyVideoUrl());
            } else {
                getVideoAdView().setUp(videoProxyFile.getAbsolutePath());
            }
            setUIStyle(g.PREVIEW);
            if (TextUtils.isEmpty(adUnit.getVideoCoverImageUrl())) {
                getVideoAdView().b(true);
            } else {
                ImageManager.with(this.n).load(adUnit.getVideoCoverImageUrl()).into(getVideoAdView().getThumbView());
            }
            getAppView().a(adUnit.getIconUrl(), adUnit.getTitle(), adUnit.getCTAText());
            getVideoAdView().setSoundChange(getAdConfig().n());
        }
    }

    @Override // com.sigmob.sdk.nativead.j
    public boolean a(MotionEvent motionEvent) {
        l lVar = this.i;
        if (lVar == null || lVar.getParent() == null || this.i.getVisibility() != 0) {
            return false;
        }
        return com.sigmob.sdk.base.utils.f.a(this.i.getCtaView(), motionEvent);
    }

    @Override // com.sigmob.sdk.nativead.j, com.sigmob.sdk.videoplayer.c
    public boolean b() {
        if (e.size() != 0 && getVideoAdView() != null) {
            getVideoAdView().u();
            return true;
        }
        if (e.size() != 0 || getVideoAdView() == null || getVideoAdView().x == 0) {
            return false;
        }
        getVideoAdView().m();
        return true;
    }

    @Override // com.sigmob.sdk.nativead.p, com.sigmob.sdk.nativead.j
    public void c() {
        super.c();
        ImageUtils.recycleBitmap(this.k);
        ImageUtils.recycleBitmap(this.l);
        q qVar = this.j;
        if (qVar != null) {
            qVar.d();
            this.j.i();
            this.j = null;
        }
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            com.sigmob.sdk.base.utils.f.a(this.m);
        }
        com.sigmob.sdk.videoplayer.g gVar = this.h;
        if (gVar != null) {
            com.sigmob.sdk.base.utils.f.a(gVar);
            this.h.setVideoAdViewListener(null);
            this.h.setVideoAdStatusListener(null);
            this.h.setBackClickListener(null);
            this.h.a();
            this.h = null;
        }
    }

    @Override // com.sigmob.sdk.nativead.j
    public void d() {
        super.d();
        if (getVideoAdView() != null) {
            getVideoAdView().E();
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void e() {
        super.e();
        if (getVideoAdView() != null) {
            getVideoAdView().C();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.c
    public void f() {
        ViewGroup viewGroup = (ViewGroup) this.m.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.m);
        }
        Activity b = com.sigmob.sdk.videoplayer.d.b(e.getLast().getContext());
        if (b != null) {
            b.getWindow().getDecorView().setSystemUiVisibility(0);
        }
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth() && b != null) {
            b.setRequestedOrientation(1);
        }
        e.getLast().removeAllViews();
        e.getLast().addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        e.pop();
    }

    @Override // com.sigmob.sdk.videoplayer.c
    public void g() {
        ViewGroup viewGroup = (ViewGroup) this.m.getParent();
        viewGroup.removeView(this.m);
        e.add(viewGroup);
        Activity b = com.sigmob.sdk.videoplayer.d.b(viewGroup.getContext());
        if (b != null) {
            ((ViewGroup) b.findViewById(R.id.content)).addView(this.m, new FrameLayout.LayoutParams(-1, -1));
            if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
                b.setRequestedOrientation(6);
            }
        }
    }

    public l getAppView() {
        if (this.i == null) {
            this.i = new l(this.n);
        }
        return this.i;
    }

    public i getSigAdVideoStatusListener() {
        q qVar = this.j;
        if (qVar != null) {
            return qVar.g();
        }
        return null;
    }

    @Override // com.sigmob.sdk.nativead.j
    public q getSigVideoAdController() {
        if (this.j == null) {
            this.j = new r(getVideoAdView());
        }
        return this.j;
    }

    public com.sigmob.sdk.videoplayer.g getVideoAdView() {
        if (this.h == null) {
            this.h = new com.sigmob.sdk.videoplayer.g(this.n);
        }
        return this.h;
    }

    public ViewGroup getVideoContainer() {
        return this.m;
    }

    @Override // com.sigmob.sdk.nativead.p
    public double getVideoDuration() {
        return getVideoAdView() != null ? ((float) getVideoAdView().getDuration()) / 1000.0f : super.getVideoDuration();
    }

    @Override // com.sigmob.sdk.nativead.p
    public double getVideoProgress() {
        return getVideoAdView() != null ? ((((float) getVideoAdView().getCurrentPositionWhenPlaying()) * 1.0f) / ((float) getVideoAdView().getDuration())) / 100.0f : super.getVideoProgress();
    }

    public int getVideoSurferViewHeight() {
        if (getVideoAdView() != null) {
            return getVideoAdView().getVideoSurferViewHeight();
        }
        return 0;
    }

    public void h() {
        if (System.currentTimeMillis() - f > 2000 && getVideoAdView().w == 4 && getVideoAdView().x == 1) {
            f = System.currentTimeMillis();
            b();
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void i() {
        super.i();
    }

    @Override // com.sigmob.sdk.nativead.p
    public void j() {
        super.j();
        if (getVideoAdView() != null) {
            getVideoAdView().D();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoCompleted() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoCompleted();
        }
        m();
        g gVar = this.d;
        if (gVar != g.PREVIEW) {
            if (gVar == g.DETAIL_PAGE) {
                setUIStyle(g.DETAIL_PAGE_END);
            }
        } else {
            if (getAppView().getParent() == null) {
                l();
            }
            getAppView().setVisibility(0);
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, true);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoError(WindAdError windAdError) {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoError(windAdError);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoLoad() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoLoad();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoPause() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoPause();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoResume() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoResume();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoStart() {
        if (getAdUnit() == null) {
            return;
        }
        l lVar = this.i;
        if (lVar != null) {
            com.sigmob.sdk.base.utils.f.a(lVar);
            getVideoAdView().getAppContainer().setVisibility(4);
        }
        ImageUtils.recycleBitmap(this.k);
        ImageUtils.recycleBitmap(this.l);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit != null) {
            adUnit.updateRealAdPercent((getVideoAdView().getVideoWidth() * 1.0f) / getVideoAdView().getVideoHeight());
        }
        g gVar = this.d;
        if (gVar == g.DETAIL_PAGE_END) {
            gVar = g.DETAIL_PAGE;
        }
        setUIStyle(gVar);
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoStart();
        }
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        if (getVideoAdView() != null) {
            getVideoAdView().setBackClickListener(onClickListener);
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void setUIStyle(g gVar) {
        if (getAdUnit() == null) {
            return;
        }
        super.setUIStyle(gVar);
        int i = AnonymousClass1.a[gVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (this.i.getParent() != null) {
                    this.i.setVisibility(4);
                }
                if (this.m.getChildCount() > 0) {
                    this.m.removeAllViews();
                }
                removeView(getVideoAdView());
                this.m.addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
                getVideoAdView().setSoundChange(getAdConfig().o() || com.sigmob.sdk.b.f());
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, true);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, true);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, false);
            } else {
                if (i != 3) {
                    return;
                }
                if (this.i.getParent() != null) {
                    this.i.setVisibility(4);
                }
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, true);
            }
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BACK, true);
            return;
        }
        this.m.removeAllViews();
        com.sigmob.sdk.base.utils.f.a(this.m);
        com.sigmob.sdk.base.utils.f.a(getVideoAdView());
        addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
        if (getVideoAdView().w == 0) {
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, true);
        } else {
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
        }
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, false);
        com.sigmob.sdk.videoplayer.g videoAdView = getVideoAdView();
        com.sigmob.sdk.videoplayer.f fVar = com.sigmob.sdk.videoplayer.f.RETRY;
        videoAdView.a(fVar, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BACK, false);
        getVideoAdView().setSoundChange(getAdConfig().n());
        if (this.i != null && (getVideoAdView().w == 6 || getVideoAdView().w == 7)) {
            if (this.i.getParent() == null) {
                l();
            }
            this.i.setVisibility(0);
            getVideoAdView().a(fVar, true);
        }
        n();
    }
}
