package com.windmill.baidu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.czhj.sdk.common.utils.ImageManager;
import com.qumeng.advlib.core.ADEvent;
import com.sigmob.sdk.base.mta.PointCategory;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import com.windmill.sdk.natives.WMNativePrivacyInfo;
import com.windmill.sdk.natives.WMVideoOption;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class h extends WMNativeAdData {
    WMVideoOption a;
    private NativeResponse b;

    /* renamed from: c, reason: collision with root package name */
    private WMNativeAdData.NativeAdInteractionListener f1150c;
    private WMCustomNativeAdapter d;
    private WMNativeAdData.NativeADMediaListener e;
    private WMNativeAdData.DislikeInteractionCallback f;
    private Bitmap h;
    private WMNativeAdData.AppDownloadListener i;
    private Map<String, Object> k;
    private WMNativeAdData g = this;
    private XNativeView j = null;

    public h(Context context, NativeResponse nativeResponse, WMCustomNativeAdapter wMCustomNativeAdapter, Map<String, Object> map) {
        this.b = nativeResponse;
        this.d = wMCustomNativeAdapter;
        this.k = map;
        if (context == null || nativeResponse == null) {
            return;
        }
        ImageManager.with(context).getBitmap(this.b.getBaiduLogoUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.windmill.baidu.h.1
            public final void onBitmapLoadFailed() {
            }

            public final void onBitmapLoaded(Bitmap bitmap) {
                h.this.h = bitmap;
            }
        });
    }

    private WMImage a(final String str) {
        return new WMImage() { // from class: com.windmill.baidu.h.4
            public final int getHeight() {
                return h.this.b.getMainPicHeight();
            }

            public final String getImageUrl() {
                return str;
            }

            public final int getWidth() {
                return h.this.b.getMainPicWidth();
            }

            public final boolean isValid() {
                return true;
            }
        };
    }

    public final void bindImageViews(Context context, List<ImageView> list, int i) {
        if (this.b == null || list.isEmpty()) {
            return;
        }
        String imageUrl = this.b.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            ImageManager.with(context).load(imageUrl).placeholder(i).error(i).into(list.get(0));
            return;
        }
        List multiPicUrls = this.b.getMultiPicUrls();
        if (multiPicUrls == null || multiPicUrls.size() <= 0) {
            return;
        }
        int min = Math.min(list.size(), multiPicUrls.size());
        for (int i2 = 0; i2 < min; i2++) {
            String str = (String) multiPicUrls.get(i2);
            if (!TextUtils.isEmpty(str)) {
                ImageManager.with(context).load(str).placeholder(i).error(i).into(list.get(i2));
            }
        }
    }

    public final void bindMediaView(Context context, ViewGroup viewGroup) {
        if (this.b != null) {
            if (viewGroup != null) {
                XNativeView xNativeView = new XNativeView(context);
                this.j = xNativeView;
                xNativeView.setBackgroundColor(-16777216);
                ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                }
                viewGroup.removeAllViews();
                viewGroup.addView((View) this.j, layoutParams);
            }
            XNativeView xNativeView2 = this.j;
            if (xNativeView2 != null) {
                WMVideoOption wMVideoOption = this.a;
                if (wMVideoOption != null) {
                    xNativeView2.setShowProgress(wMVideoOption.isNeedProgressBar());
                } else {
                    xNativeView2.setShowProgress(true);
                }
                this.j.setProgressBarColor(-7829368);
                this.j.setProgressBackgroundColor(-16777216);
                this.j.setProgressHeightInDp(1);
                this.j.setNativeItem(this.b);
                Map<String, Object> map = this.k;
                if (map != null) {
                    Object obj = map.get("autoPlayMuted");
                    Object obj2 = this.k.get("showDownloadDialog");
                    if (obj == null || !obj.equals("0")) {
                        this.j.setVideoMute(true);
                    } else {
                        this.j.setVideoMute(false);
                    }
                    if (obj2 == null || !obj2.equals("1")) {
                        this.j.setUseDownloadFrame(false);
                    } else {
                        this.j.setUseDownloadFrame(true);
                    }
                }
                this.j.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.windmill.baidu.BdNativeAdData$8
                    public void onNativeViewClick(XNativeView xNativeView3) {
                        WMLogUtil.d(WMLogUtil.TAG, "onNativeViewClick:".concat(String.valueOf(xNativeView3)));
                    }
                });
                this.j.setNativeVideoListener(new INativeVideoListener() { // from class: com.windmill.baidu.BdNativeAdData$9
                    public void onCompletion() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onCompletion");
                        nativeADMediaListener = h.this.e;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = h.this.e;
                            nativeADMediaListener2.onVideoCompleted();
                        }
                    }

                    public void onError() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onError()");
                        nativeADMediaListener = h.this.e;
                        if (nativeADMediaListener != null) {
                            WindMillError windMillError = WindMillError.ERROR_AD_PLAY;
                            nativeADMediaListener2 = h.this.e;
                            nativeADMediaListener2.onVideoError(windMillError);
                        }
                    }

                    public void onPause() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onPause()");
                        nativeADMediaListener = h.this.e;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = h.this.e;
                            nativeADMediaListener2.onVideoPause();
                        }
                    }

                    public void onRenderingStart() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onRenderingStart()");
                        nativeADMediaListener = h.this.e;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = h.this.e;
                            nativeADMediaListener2.onVideoStart();
                        }
                    }

                    public void onResume() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onResume()");
                        nativeADMediaListener = h.this.e;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = h.this.e;
                            nativeADMediaListener2.onVideoResume();
                        }
                    }
                });
                this.j.render();
            }
        }
    }

    public final void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse != null) {
            nativeResponse.registerViewForInteraction(view, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.windmill.baidu.BdNativeAdData$2
                public void onADExposed() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMCustomNativeAdapter wMCustomNativeAdapter;
                    WMCustomNativeAdapter wMCustomNativeAdapter2;
                    WMNativeAdData wMNativeAdData;
                    WMCustomNativeAdapter wMCustomNativeAdapter3;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMCustomNativeAdapter wMCustomNativeAdapter4;
                    WMNativeAdData wMNativeAdData2;
                    nativeAdInteractionListener = h.this.f1150c;
                    if (nativeAdInteractionListener != null) {
                        wMCustomNativeAdapter3 = h.this.d;
                        if (wMCustomNativeAdapter3 != null) {
                            nativeAdInteractionListener2 = h.this.f1150c;
                            wMCustomNativeAdapter4 = h.this.d;
                            wMNativeAdData2 = h.this.g;
                            nativeAdInteractionListener2.onADExposed(wMCustomNativeAdapter4.getAdInFo(wMNativeAdData2));
                        }
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "onADExposed:" + h.this.b.getTitle());
                    wMCustomNativeAdapter = h.this.d;
                    if (wMCustomNativeAdapter != null) {
                        wMCustomNativeAdapter2 = h.this.d;
                        wMNativeAdData = h.this.g;
                        wMCustomNativeAdapter2.callNativeAdShow(wMNativeAdData);
                    }
                }

                public void onADExposureFailed(int i) {
                    WMLogUtil.d(WMLogUtil.TAG, "onADExposureFailed:".concat(String.valueOf(i)));
                }

                public void onADStatusChanged() {
                    WMNativeAdData.AppDownloadListener appDownloadListener;
                    WMNativeAdData.AppDownloadListener appDownloadListener2;
                    WMNativeAdData.AppDownloadListener appDownloadListener3;
                    WMNativeAdData.AppDownloadListener appDownloadListener4;
                    WMNativeAdData.AppDownloadListener appDownloadListener5;
                    WMNativeAdData.AppDownloadListener appDownloadListener6;
                    WMNativeAdData.AppDownloadListener appDownloadListener7;
                    WMLogUtil.d(WMLogUtil.TAG, "onADStatusChanged()");
                    if (h.this.b.getAdActionType() == 2) {
                        appDownloadListener = h.this.i;
                        if (appDownloadListener != null) {
                            int downloadStatus = h.this.b.getDownloadStatus();
                            if (downloadStatus >= 0 && downloadStatus <= 100) {
                                appDownloadListener7 = h.this.i;
                                appDownloadListener7.onDownloadActive(100L, downloadStatus, "", "");
                                return;
                            }
                            if (downloadStatus == 101) {
                                appDownloadListener6 = h.this.i;
                                appDownloadListener6.onDownloadFinished(100L, "", "");
                                return;
                            }
                            if (downloadStatus == 102) {
                                appDownloadListener5 = h.this.i;
                                appDownloadListener5.onDownloadPaused(100L, 50L, "", "");
                            } else if (downloadStatus == 103) {
                                appDownloadListener4 = h.this.i;
                                appDownloadListener4.onInstalled("", "");
                            } else if (downloadStatus == 104) {
                                appDownloadListener3 = h.this.i;
                                appDownloadListener3.onDownloadFailed(100L, 1L, "", "");
                            } else {
                                appDownloadListener2 = h.this.i;
                                appDownloadListener2.onIdle();
                            }
                        }
                    }
                }

                public void onAdClick() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMCustomNativeAdapter wMCustomNativeAdapter;
                    WMCustomNativeAdapter wMCustomNativeAdapter2;
                    WMNativeAdData wMNativeAdData;
                    WMCustomNativeAdapter wMCustomNativeAdapter3;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMCustomNativeAdapter wMCustomNativeAdapter4;
                    WMNativeAdData wMNativeAdData2;
                    nativeAdInteractionListener = h.this.f1150c;
                    if (nativeAdInteractionListener != null) {
                        wMCustomNativeAdapter3 = h.this.d;
                        if (wMCustomNativeAdapter3 != null) {
                            nativeAdInteractionListener2 = h.this.f1150c;
                            wMCustomNativeAdapter4 = h.this.d;
                            wMNativeAdData2 = h.this.g;
                            nativeAdInteractionListener2.onADClicked(wMCustomNativeAdapter4.getAdInFo(wMNativeAdData2));
                        }
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "onAdClick:" + h.this.b.getTitle());
                    wMCustomNativeAdapter = h.this.d;
                    if (wMCustomNativeAdapter != null) {
                        wMCustomNativeAdapter2 = h.this.d;
                        wMNativeAdData = h.this.g;
                        wMCustomNativeAdapter2.callNativeAdClick(wMNativeAdData);
                    }
                }

                public void onAdUnionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "onAdUnionClick()");
                }
            });
            this.b.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.windmill.baidu.BdNativeAdData$3
                public void adDownloadWindowClose() {
                    XNativeView xNativeView;
                    XNativeView xNativeView2;
                    WMLogUtil.d(WMLogUtil.TAG, "adDownloadWindowClose");
                    xNativeView = h.this.j;
                    if (xNativeView != null) {
                        xNativeView2 = h.this.j;
                        xNativeView2.resume();
                    }
                }

                public void adDownloadWindowShow() {
                    XNativeView xNativeView;
                    XNativeView xNativeView2;
                    WMLogUtil.d(WMLogUtil.TAG, "AdDownloadWindowShow");
                    xNativeView = h.this.j;
                    if (xNativeView != null) {
                        xNativeView2 = h.this.j;
                        xNativeView2.pause();
                    }
                }

                public void onADFunctionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "onADFunctionClick");
                }

                public void onADPermissionClose() {
                    WMLogUtil.d(WMLogUtil.TAG, "onADPermissionClose");
                }

                public void onADPermissionShow() {
                    WMLogUtil.d(WMLogUtil.TAG, "onADPermissionShow");
                }

                public void onADPrivacyClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "onADPrivacyClick");
                }
            });
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.windmill.baidu.h.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        if (h.this.f != null) {
                            h.this.f.onSelected(0, ADEvent.BAIDU, true);
                        }
                    }
                });
            }
        }
    }

    public final void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
        if (wMNativeAdRender != null) {
            View createView = wMNativeAdRender.createView(activity, getAdPatternType());
            wMNativeAdRender.renderAdView(createView, this);
            if (wMNativeAdContainer != null) {
                wMNativeAdContainer.removeAllViews();
                wMNativeAdContainer.addView(createView, new ViewGroup.LayoutParams(-1, -2));
            }
        }
    }

    public final void destroy() {
    }

    public final Bitmap getAdLogo() {
        return this.h;
    }

    public final int getAdPatternType() {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null) {
            return 1;
        }
        if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
            return 4;
        }
        if (!TextUtils.isEmpty(this.b.getImageUrl())) {
            return 2;
        }
        List multiPicUrls = this.b.getMultiPicUrls();
        return (multiPicUrls == null || multiPicUrls.isEmpty()) ? 1 : 3;
    }

    public final WMNativeAdData.AppInfo getAppInfo() {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse != null) {
            return new WMNativePrivacyInfo(nativeResponse.getBrandName(), this.b.getAppVersion(), this.b.getAppSize(), this.b.getAppPackage(), this.b.getPublisher(), this.b.getAppPrivacyLink(), "", this.b.getAppPermissionLink(), this.b.getAppFunctionLink());
        }
        return null;
    }

    public final String getCTAText() {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null) {
            return "查看详情";
        }
        String actButtonString = nativeResponse.getActButtonString();
        if (this.b.getAdActionType() != 2) {
            return !TextUtils.isEmpty(actButtonString) ? actButtonString : "查看详情";
        }
        int downloadStatus = this.b.getDownloadStatus();
        if (downloadStatus < 0 || downloadStatus > 100) {
            return downloadStatus == 101 ? "点击安装" : downloadStatus == 102 ? "继续下载" : downloadStatus == 103 ? "点击启动" : downloadStatus == 104 ? "重新下载" : !TextUtils.isEmpty(actButtonString) ? actButtonString : "点击下载";
        }
        return "下载中：" + downloadStatus + "%";
    }

    public final WMNativeAdData.CustomizeVideo getCustomizeVideo() {
        final NativeResponse.CustomizeMediaPlayer customizeMediaPlayer;
        NativeResponse nativeResponse = this.b;
        return (nativeResponse == null || (customizeMediaPlayer = nativeResponse.getCustomizeMediaPlayer()) == null) ? super.getCustomizeVideo() : new WMNativeAdData.CustomizeVideo() { // from class: com.windmill.baidu.h.2
            public final String getVideoUrl() {
                return customizeMediaPlayer.getVideoUrl();
            }

            public final void reportVideoCompleted() {
                customizeMediaPlayer.reportVideoReplay();
            }

            public final void reportVideoError(long j, int i, int i2) {
                customizeMediaPlayer.reportPlayError(0);
            }

            public final void reportVideoPause(long j) {
                customizeMediaPlayer.reportVideoPause(0, NativeResponse.VideoReason.OTHER_REASON);
            }

            public final void reportVideoPreload() {
                customizeMediaPlayer.reportPlayerReady();
            }

            public final void reportVideoResume(long j) {
                customizeMediaPlayer.reportVideoResume(0);
            }

            public final void reportVideoStart() {
                customizeMediaPlayer.reportVideoShow();
                customizeMediaPlayer.reportVideoStart(true);
            }
        };
    }

    public final String getDesc() {
        NativeResponse nativeResponse = this.b;
        return nativeResponse != null ? nativeResponse.getDesc() : "";
    }

    public final View getExpressAdView() {
        return null;
    }

    public final String getIconUrl() {
        NativeResponse nativeResponse = this.b;
        return nativeResponse != null ? nativeResponse.getIconUrl() : "";
    }

    public final List<WMImage> getImageList() {
        if (this.b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String imageUrl = this.b.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            arrayList.add(a(imageUrl));
        } else if (this.b.getMultiPicUrls() != null) {
            for (int i = 0; i < this.b.getMultiPicUrls().size(); i++) {
                arrayList.add(a((String) this.b.getMultiPicUrls().get(i)));
            }
        }
        return arrayList;
    }

    public final List<String> getImageUrlList() {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null) {
            return null;
        }
        String imageUrl = nativeResponse.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            return this.b.getMultiPicUrls();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageUrl);
        return arrayList;
    }

    public final int getInteractionType() {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null) {
            return 0;
        }
        int adActionType = nativeResponse.getAdActionType();
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

    public final View getInteractionWidgetView(int i, int i2, int i3, final WMNativeAdData.AdShakeViewListener adShakeViewListener) {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.windmill.baidu.BdNativeAdData$7
                public void onDismiss() {
                    WMNativeAdData.AdShakeViewListener adShakeViewListener2 = adShakeViewListener;
                    if (adShakeViewListener2 != null) {
                        adShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    public final int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.d;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public final Object getOriginNativeAdData() {
        return this.b;
    }

    public final String getTitle() {
        NativeResponse nativeResponse = this.b;
        return nativeResponse != null ? nativeResponse.getTitle() : "";
    }

    public final boolean isExpressAd() {
        return false;
    }

    public final boolean isNativeDrawAd() {
        return false;
    }

    public final void pauseVideo() {
        XNativeView xNativeView = this.j;
        if (xNativeView != null) {
            xNativeView.pause();
        }
    }

    public final void render() {
    }

    public final View renderShakeView(int i, int i2, final WMNativeAdData.AdShakeViewListener adShakeViewListener) {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.windmill.baidu.BdNativeAdData$6
                public void onDismiss() {
                    WMNativeAdData.AdShakeViewListener adShakeViewListener2 = adShakeViewListener;
                    if (adShakeViewListener2 != null) {
                        adShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    public final void resumeVideo() {
        XNativeView xNativeView = this.j;
        if (xNativeView != null) {
            xNativeView.resume();
        }
    }

    public final void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.f = dislikeInteractionCallback;
        }
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
        if (appDownloadListener != null) {
            this.i = appDownloadListener;
        }
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.f1150c = nativeAdInteractionListener;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (nativeADMediaListener != null) {
            this.e = nativeADMediaListener;
        }
    }

    public final void setMediaViewOption(WMVideoOption wMVideoOption) {
        this.a = wMVideoOption;
    }

    public final void startVideo() {
        try {
            XNativeView xNativeView = this.j;
            if (xNativeView != null) {
                Method declaredMethod = xNativeView.getClass().getDeclaredMethod(PointCategory.PLAY, new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.j, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void stopVideo() {
        XNativeView xNativeView = this.j;
        if (xNativeView != null) {
            xNativeView.stop();
        }
    }
}
