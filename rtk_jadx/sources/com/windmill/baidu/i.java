package com.windmill.baidu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class i extends WMNativeAdData {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WMNativeAdData.NativeAdInteractionListener a() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WMCustomNativeAdapter b() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WMNativeAdData c() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ NativeResponse d() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WMNativeAdData.AppDownloadListener e() {
        throw null;
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
        throw null;
    }

    public final WMNativeAdData.AppInfo getAppInfo() {
        throw null;
    }

    public final String getCTAText() {
        return "";
    }

    public final String getDesc() {
        return "";
    }

    public final View getExpressAdView() {
        throw null;
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
        throw null;
    }

    public final int getNetworkId() {
        throw null;
    }

    public final Object getOriginNativeAdData() {
        throw null;
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
    }

    public final void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        throw null;
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
        if (appDownloadListener != null) {
            throw null;
        }
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            throw null;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
    }
}
