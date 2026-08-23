package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qumeng.advlib.core.ADEvent;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.windad.natives.AdAppInfo;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ad implements WindNativeAdData {
    private final String a;
    private final String b;

    /* renamed from: c, reason: collision with root package name */
    private final String f606c;
    private final List<SigImage> d;
    private final SigVideo e;
    private final int f;
    private final y g;
    private AdAppInfo h;

    public ad(BaseAdUnit baseAdUnit) {
        this.a = baseAdUnit.getTitle();
        this.b = baseAdUnit.getDesc();
        this.f606c = baseAdUnit.getIconUrl();
        this.d = baseAdUnit.getImageUrlList();
        this.f = baseAdUnit.getNativeAd().type.intValue();
        this.h = baseAdUnit.getAdAppInfo();
        this.e = baseAdUnit.getNativeVideo();
        y yVar = new y();
        this.g = yVar;
        yVar.a(baseAdUnit, this);
    }

    public String a() {
        return ADEvent.SIGMOB;
    }

    public double b() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.s();
        }
        return 0.0d;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindImageViews(List<ImageView> list, int i) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.a(list, i);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaView(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.b(viewGroup, nativeADMediaListener);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaViewWithoutAppInfo(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.a(viewGroup, nativeADMediaListener);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindViewForInteraction(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.a(view, list, list2, view2, nativeADEventListener);
        }
    }

    public double c() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.t();
        }
        return 0.0d;
    }

    public int d() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.p();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void destroy() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.w();
        }
    }

    public int e() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.u();
        }
        return 0;
    }

    public int f() {
        return this.f;
    }

    public void g() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.v();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public AdAppInfo getAdAppInfo() {
        return this.h;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public Bitmap getAdLogo() {
        return this.g.B();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getAdPatternType() {
        return this.f;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public View getAdView() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.q();
        }
        return null;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getCTAText() {
        y yVar = this.g;
        return yVar != null ? yVar.A() : "";
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getDesc() {
        return this.b;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getEcpm() {
        y yVar = this.g;
        return yVar != null ? yVar.H() : "";
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getIconUrl() {
        return this.f606c;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public List<SigImage> getImageList() {
        return this.d;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getInteractionType() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.z();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getTitle() {
        return this.a;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getVideoCoverImageUrl() {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.I();
        }
        return null;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoHeight() {
        SigVideo sigVideo = this.e;
        if (sigVideo != null) {
            return sigVideo.getHeight();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoWidth() {
        SigVideo sigVideo = this.e;
        if (sigVideo != null) {
            return sigVideo.getWidth();
        }
        return 0;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public View getWidgetView(int i, int i2) {
        y yVar = this.g;
        if (yVar != null) {
            return yVar.a(i, i2);
        }
        return null;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void pauseVideo() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.D();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void resumeVideo() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.F();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void setDislikeInteractionCallback(Activity activity, WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.a(dislikeInteractionCallback);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void startVideo() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.C();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void stopVideo() {
        y yVar = this.g;
        if (yVar != null) {
            yVar.G();
        }
    }
}
