package com.windmill.adscope;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class a extends WMNativeAdData {
    WMNativeAdData.NativeAdInteractionListener a;
    WMNativeAdData.DislikeInteractionCallback b;

    /* renamed from: c, reason: collision with root package name */
    private View f1133c;
    private WMCustomNativeAdapter d;

    public a(View view, WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.f1133c = view;
        this.d = wMCustomNativeAdapter;
    }

    public final void bindImageViews(Context context, List<ImageView> list, int i) {
    }

    public final void bindMediaView(Context context, ViewGroup viewGroup) {
    }

    public final void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
    }

    public final void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
    }

    public final void destroy() {
    }

    public final Bitmap getAdLogo() {
        return null;
    }

    public final int getAdPatternType() {
        return 0;
    }

    public final String getCTAText() {
        return "";
    }

    public final String getDesc() {
        return "";
    }

    public final View getExpressAdView() {
        View view = this.f1133c;
        if (view != null) {
            return view;
        }
        return null;
    }

    public final String getIconUrl() {
        return "";
    }

    public final List<WMImage> getImageList() {
        return null;
    }

    public final List<String> getImageUrlList() {
        return null;
    }

    public final int getInteractionType() {
        return 0;
    }

    public final int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.d;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public final Object getOriginNativeAdData() {
        return this.f1133c;
    }

    public final String getTitle() {
        return "";
    }

    public final boolean isExpressAd() {
        return true;
    }

    public final boolean isNativeDrawAd() {
        return false;
    }

    public final void render() {
        WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
        if (this.f1133c == null || (nativeAdInteractionListener = this.a) == null) {
            return;
        }
        nativeAdInteractionListener.onADRenderSuccess(this.d.getAdInFo(this), this.f1133c, r2.getWidth(), this.f1133c.getHeight());
    }

    public final void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.b = dislikeInteractionCallback;
        }
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.a = nativeAdInteractionListener;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
    }
}
