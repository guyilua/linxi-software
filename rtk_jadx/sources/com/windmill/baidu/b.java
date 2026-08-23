package com.windmill.baidu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.qumeng.advlib.core.ADEvent;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b extends WMNativeAdData {
    private ExpressResponse a;
    private WMNativeAdData.NativeAdInteractionListener b;

    /* renamed from: c, reason: collision with root package name */
    private WMNativeAdData f1146c = this;
    private WMCustomNativeAdapter d;

    public b(ExpressResponse expressResponse, final WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.a = expressResponse;
        this.d = wMCustomNativeAdapter;
        if (expressResponse != null) {
            expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.windmill.baidu.BdExpressAdData$1
                public void onAdClick() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData wMNativeAdData;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMNativeAdData wMNativeAdData2;
                    WMLogUtil.d(WMLogUtil.TAG, "----------onAdClicked-----------");
                    nativeAdInteractionListener = b.this.b;
                    if (nativeAdInteractionListener != null && wMCustomNativeAdapter != null) {
                        nativeAdInteractionListener2 = b.this.b;
                        WMCustomNativeAdapter wMCustomNativeAdapter2 = wMCustomNativeAdapter;
                        wMNativeAdData2 = b.this.f1146c;
                        nativeAdInteractionListener2.onADClicked(wMCustomNativeAdapter2.getAdInFo(wMNativeAdData2));
                    }
                    WMCustomNativeAdapter wMCustomNativeAdapter3 = wMCustomNativeAdapter;
                    if (wMCustomNativeAdapter3 != null) {
                        wMNativeAdData = b.this.f1146c;
                        wMCustomNativeAdapter3.callNativeAdClick(wMNativeAdData);
                    }
                }

                public void onAdExposed() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData wMNativeAdData;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMNativeAdData wMNativeAdData2;
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onAdExposed-----------");
                    nativeAdInteractionListener = b.this.b;
                    if (nativeAdInteractionListener != null && wMCustomNativeAdapter != null) {
                        nativeAdInteractionListener2 = b.this.b;
                        WMCustomNativeAdapter wMCustomNativeAdapter2 = wMCustomNativeAdapter;
                        wMNativeAdData2 = b.this.f1146c;
                        nativeAdInteractionListener2.onADExposed(wMCustomNativeAdapter2.getAdInFo(wMNativeAdData2));
                    }
                    WMCustomNativeAdapter wMCustomNativeAdapter3 = wMCustomNativeAdapter;
                    if (wMCustomNativeAdapter3 != null) {
                        wMNativeAdData = b.this.f1146c;
                        wMCustomNativeAdapter3.callNativeAdShow(wMNativeAdData);
                    }
                }

                public void onAdRenderFail(View view, String str, int i) {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData wMNativeAdData;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMNativeAdData wMNativeAdData2;
                    WMLogUtil.d(WMLogUtil.TAG, "-------------onAdRenderFail-----------:" + str + ":" + i);
                    nativeAdInteractionListener = b.this.b;
                    if (nativeAdInteractionListener != null && wMCustomNativeAdapter != null) {
                        WindMillError windMillError = WindMillError.ERROR_AD_ADAPTER_PLAY;
                        windMillError.setMessage("code : " + i + " msg : " + str);
                        nativeAdInteractionListener2 = b.this.b;
                        WMCustomNativeAdapter wMCustomNativeAdapter2 = wMCustomNativeAdapter;
                        wMNativeAdData2 = b.this.f1146c;
                        nativeAdInteractionListener2.onADError(wMCustomNativeAdapter2.getAdInFo(wMNativeAdData2), windMillError);
                    }
                    WMCustomNativeAdapter wMCustomNativeAdapter3 = wMCustomNativeAdapter;
                    if (wMCustomNativeAdapter3 != null) {
                        wMNativeAdData = b.this.f1146c;
                        wMCustomNativeAdapter3.callNativeAdShowError(wMNativeAdData, new WMAdapterError(i, "bd onRenderFail:".concat(String.valueOf(str))));
                    }
                }

                public void onAdRenderSuccess(View view, float f, float f2) {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMNativeAdData wMNativeAdData;
                    WMLogUtil.d(WMLogUtil.TAG, "-------------onRenderSuccess-----------:" + f + ":" + f2);
                    nativeAdInteractionListener = b.this.b;
                    if (nativeAdInteractionListener == null || wMCustomNativeAdapter == null) {
                        return;
                    }
                    nativeAdInteractionListener2 = b.this.b;
                    WMCustomNativeAdapter wMCustomNativeAdapter2 = wMCustomNativeAdapter;
                    wMNativeAdData = b.this.f1146c;
                    nativeAdInteractionListener2.onADRenderSuccess(wMCustomNativeAdapter2.getAdInFo(wMNativeAdData), view, f, f2);
                }

                public void onAdUnionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onAdUnionClick-----------");
                }
            });
            this.a.setAdPrivacyListener(new ExpressResponse.ExpressAdDownloadWindowListener() { // from class: com.windmill.baidu.BdExpressAdData$2
                public void adDownloadWindowClose() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------adDownloadWindowClose-----------");
                }

                public void adDownloadWindowShow() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------adDownloadWindowShow-----------");
                }

                public void onADFunctionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onADFunctionClick-----------");
                }

                public void onADPermissionClose() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onADPermissionClose-----------");
                }

                public void onADPermissionShow() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onADPermissionShow-----------");
                }

                public void onADPrivacyClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onADPrivacyClick-----------");
                }
            });
        }
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
        ExpressResponse expressResponse = this.a;
        return (expressResponse == null || expressResponse.getStyleType() != 41) ? 0 : 4;
    }

    public final String getCTAText() {
        return "";
    }

    public final String getDesc() {
        return "";
    }

    public final View getExpressAdView() {
        ExpressResponse expressResponse = this.a;
        if (expressResponse != null) {
            return expressResponse.getExpressAdView();
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
        ExpressResponse expressResponse = this.a;
        if (expressResponse == null) {
            return 0;
        }
        int adActionType = expressResponse.getAdActionType();
        if (adActionType != 1) {
            if (adActionType == 2) {
                return 1;
            }
            if (adActionType != 3) {
                return 0;
            }
        }
        return 2;
    }

    public final int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.d;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public final Object getOriginNativeAdData() {
        return this.a;
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
        ExpressResponse expressResponse = this.a;
        if (expressResponse != null) {
            expressResponse.render();
        }
    }

    public final void setDislikeInteractionCallback(Activity activity, final WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        ExpressResponse expressResponse = this.a;
        if (expressResponse != null) {
            expressResponse.bindInteractionActivity(activity);
            this.a.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.windmill.baidu.BdExpressAdData$3
                public void onDislikeItemClick(String str) {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onDislikeItemClick-----------:".concat(String.valueOf(str)));
                    WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                    if (dislikeInteractionCallback2 != null) {
                        dislikeInteractionCallback2.onSelected(0, str, true);
                    }
                }

                public void onDislikeWindowClose() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onDislikeWindowClose-----------");
                    WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                    if (dislikeInteractionCallback2 != null) {
                        dislikeInteractionCallback2.onCancel();
                    }
                }

                public void onDislikeWindowShow() {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onDislikeWindowShow-----------");
                    WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                    if (dislikeInteractionCallback2 != null) {
                        dislikeInteractionCallback2.onShow();
                    }
                }
            });
            this.a.setAdCloseListener(new ExpressResponse.ExpressCloseListener() { // from class: com.windmill.baidu.BdExpressAdData$4
                public void onAdClose(ExpressResponse expressResponse2) {
                    WMLogUtil.d(WMLogUtil.TAG, "---------------onAdClose-----------");
                    WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                    if (dislikeInteractionCallback2 != null) {
                        dislikeInteractionCallback2.onSelected(0, ADEvent.BAIDU, true);
                    }
                }
            });
        }
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.b = nativeAdInteractionListener;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
    }
}
