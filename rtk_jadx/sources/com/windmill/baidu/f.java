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
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import com.windmill.sdk.natives.WMNativePrivacyInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class f extends WMNativeAdData {
    private NativeResponse a;
    private WMNativeAdData.NativeAdInteractionListener b;

    /* renamed from: c, reason: collision with root package name */
    private WMNativeAdData.NativeADMediaListener f1149c;
    private WMNativeAdData.DislikeInteractionCallback d;
    private Bitmap e;
    private WMNativeAdData.AppDownloadListener f;
    private XNativeView g = null;
    private Map<String, Object> h;
    private int i;

    public f(Context context, NativeResponse nativeResponse, int i, Map<String, Object> map) {
        this.a = nativeResponse;
        this.i = i;
        this.h = map;
        if (context == null || nativeResponse == null) {
            return;
        }
        ImageManager.with(context).getBitmap(this.a.getBaiduLogoUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.windmill.baidu.f.1
            public final void onBitmapLoadFailed() {
            }

            public final void onBitmapLoaded(Bitmap bitmap) {
                f.this.e = bitmap;
            }
        });
    }

    private WMImage a(final String str) {
        return new WMImage() { // from class: com.windmill.baidu.f.3
            public final int getHeight() {
                return f.this.a.getMainPicHeight();
            }

            public final String getImageUrl() {
                return str;
            }

            public final int getWidth() {
                return f.this.a.getMainPicWidth();
            }

            public final boolean isValid() {
                return true;
            }
        };
    }

    public final void bindImageViews(Context context, List<ImageView> list, int i) {
        if (this.a == null || list.isEmpty()) {
            return;
        }
        String imageUrl = this.a.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            ImageManager.with(context).load(imageUrl).placeholder(i).error(i).into(list.get(0));
            return;
        }
        List multiPicUrls = this.a.getMultiPicUrls();
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
        if (this.a != null) {
            if (viewGroup != null) {
                XNativeView xNativeView = new XNativeView(context);
                this.g = xNativeView;
                xNativeView.setBackgroundColor(-16777216);
                ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                }
                viewGroup.removeAllViews();
                viewGroup.addView((View) this.g, layoutParams);
            }
            XNativeView xNativeView2 = this.g;
            if (xNativeView2 != null) {
                xNativeView2.setShowProgress(true);
                this.g.setProgressBarColor(-7829368);
                this.g.setProgressBackgroundColor(-16777216);
                this.g.setProgressHeightInDp(1);
                this.g.setNativeItem(this.a);
                Map<String, Object> map = this.h;
                if (map != null) {
                    Object obj = map.get("autoPlayMuted");
                    Object obj2 = this.h.get("showDownloadDialog");
                    if (obj == null || !obj.equals("0")) {
                        this.g.setVideoMute(true);
                    } else {
                        this.g.setVideoMute(false);
                    }
                    if (obj2 == null || !obj2.equals("1")) {
                        this.g.setUseDownloadFrame(false);
                    } else {
                        this.g.setUseDownloadFrame(true);
                    }
                }
                this.g.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.windmill.baidu.BdNSIAdData$7
                    public void onNativeViewClick(XNativeView xNativeView3) {
                        WMLogUtil.d(WMLogUtil.TAG, "onNativeViewClick:".concat(String.valueOf(xNativeView3)));
                    }
                });
                this.g.setNativeVideoListener(new INativeVideoListener() { // from class: com.windmill.baidu.BdNSIAdData$8
                    public void onCompletion() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onCompletion");
                        nativeADMediaListener = f.this.f1149c;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = f.this.f1149c;
                            nativeADMediaListener2.onVideoCompleted();
                        }
                    }

                    public void onError() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onError()");
                        nativeADMediaListener = f.this.f1149c;
                        if (nativeADMediaListener != null) {
                            WindMillError windMillError = WindMillError.ERROR_AD_PLAY;
                            nativeADMediaListener2 = f.this.f1149c;
                            nativeADMediaListener2.onVideoError(windMillError);
                        }
                    }

                    public void onPause() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onPause()");
                        nativeADMediaListener = f.this.f1149c;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = f.this.f1149c;
                            nativeADMediaListener2.onVideoPause();
                        }
                    }

                    public void onRenderingStart() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onRenderingStart()");
                        nativeADMediaListener = f.this.f1149c;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = f.this.f1149c;
                            nativeADMediaListener2.onVideoStart();
                        }
                    }

                    public void onResume() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "onResume()");
                        nativeADMediaListener = f.this.f1149c;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = f.this.f1149c;
                            nativeADMediaListener2.onVideoResume();
                        }
                    }
                });
            }
            this.g.render();
        }
    }

    public final void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            nativeResponse.registerViewForInteraction(view, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.windmill.baidu.BdNSIAdData$2
                public void onADExposed() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    nativeAdInteractionListener = f.this.b;
                    if (nativeAdInteractionListener != null) {
                        nativeAdInteractionListener2 = f.this.b;
                        nativeAdInteractionListener2.onADExposed((AdInfo) null);
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
                    if (f.this.a.getAdActionType() == 2) {
                        appDownloadListener = f.this.f;
                        if (appDownloadListener != null) {
                            int downloadStatus = f.this.a.getDownloadStatus();
                            if (downloadStatus >= 0 && downloadStatus <= 100) {
                                appDownloadListener7 = f.this.f;
                                appDownloadListener7.onDownloadActive(100L, downloadStatus, "", "");
                                return;
                            }
                            if (downloadStatus == 101) {
                                appDownloadListener6 = f.this.f;
                                appDownloadListener6.onDownloadFinished(100L, "", "");
                                return;
                            }
                            if (downloadStatus == 102) {
                                appDownloadListener5 = f.this.f;
                                appDownloadListener5.onDownloadPaused(100L, 50L, "", "");
                            } else if (downloadStatus == 103) {
                                appDownloadListener4 = f.this.f;
                                appDownloadListener4.onInstalled("", "");
                            } else if (downloadStatus == 104) {
                                appDownloadListener3 = f.this.f;
                                appDownloadListener3.onDownloadFailed(100L, 1L, "", "");
                            } else {
                                appDownloadListener2 = f.this.f;
                                appDownloadListener2.onIdle();
                            }
                        }
                    }
                }

                public void onAdClick() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    nativeAdInteractionListener = f.this.b;
                    if (nativeAdInteractionListener != null) {
                        nativeAdInteractionListener2 = f.this.b;
                        nativeAdInteractionListener2.onADClicked((AdInfo) null);
                    }
                }

                public void onAdUnionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "onAdUnionClick()");
                }
            });
            this.a.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.windmill.baidu.BdNSIAdData$3
                public void adDownloadWindowClose() {
                    XNativeView xNativeView;
                    XNativeView xNativeView2;
                    WMLogUtil.d(WMLogUtil.TAG, "adDownloadWindowClose");
                    xNativeView = f.this.g;
                    if (xNativeView != null) {
                        xNativeView2 = f.this.g;
                        xNativeView2.resume();
                    }
                }

                public void adDownloadWindowShow() {
                    XNativeView xNativeView;
                    XNativeView xNativeView2;
                    WMLogUtil.d(WMLogUtil.TAG, "AdDownloadWindowShow");
                    xNativeView = f.this.g;
                    if (xNativeView != null) {
                        xNativeView2 = f.this.g;
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
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.windmill.baidu.f.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        if (f.this.d != null) {
                            f.this.d.onSelected(0, ADEvent.BAIDU, true);
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
        if (this.b != null) {
            this.b = null;
        }
    }

    public final Bitmap getAdLogo() {
        return this.e;
    }

    public final int getAdPatternType() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null) {
            return 1;
        }
        if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
            return 4;
        }
        if (!TextUtils.isEmpty(this.a.getImageUrl())) {
            return 2;
        }
        List multiPicUrls = this.a.getMultiPicUrls();
        return (multiPicUrls == null || multiPicUrls.isEmpty()) ? 1 : 3;
    }

    public final WMNativeAdData.AppInfo getAppInfo() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return new WMNativePrivacyInfo(nativeResponse.getBrandName(), this.a.getAppVersion(), this.a.getAppSize(), this.a.getAppPackage(), this.a.getPublisher(), this.a.getAppPrivacyLink(), "", this.a.getAppPermissionLink(), this.a.getAppFunctionLink());
        }
        return null;
    }

    public final String getCTAText() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null) {
            return "获取详情";
        }
        String actButtonString = nativeResponse.getActButtonString();
        if (this.a.getAdActionType() != 2) {
            return !TextUtils.isEmpty(actButtonString) ? actButtonString : "获取详情";
        }
        int downloadStatus = this.a.getDownloadStatus();
        if (downloadStatus < 0 || downloadStatus > 100) {
            return downloadStatus == 101 ? "点击安装" : downloadStatus == 102 ? "继续下载" : downloadStatus == 103 ? "点击启动" : downloadStatus == 104 ? "重新下载" : !TextUtils.isEmpty(actButtonString) ? actButtonString : "点击下载";
        }
        return "下载中：" + downloadStatus + "%";
    }

    public final WMNativeAdData.CustomizeVideo getCustomizeVideo() {
        final NativeResponse.CustomizeMediaPlayer customizeMediaPlayer;
        NativeResponse nativeResponse = this.a;
        return (nativeResponse == null || (customizeMediaPlayer = nativeResponse.getCustomizeMediaPlayer()) == null) ? super.getCustomizeVideo() : new WMNativeAdData.CustomizeVideo() { // from class: com.windmill.baidu.f.4
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
        NativeResponse nativeResponse = this.a;
        return nativeResponse != null ? nativeResponse.getDesc() : "";
    }

    public final View getExpressAdView() {
        return null;
    }

    public final String getIconUrl() {
        NativeResponse nativeResponse = this.a;
        return nativeResponse != null ? nativeResponse.getIconUrl() : "";
    }

    public final List<WMImage> getImageList() {
        if (this.a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String imageUrl = this.a.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            arrayList.add(a(imageUrl));
        } else if (this.a.getMultiPicUrls() != null) {
            for (int i = 0; i < this.a.getMultiPicUrls().size(); i++) {
                arrayList.add(a((String) this.a.getMultiPicUrls().get(i)));
            }
        }
        return arrayList;
    }

    public final List<String> getImageUrlList() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null) {
            return null;
        }
        String imageUrl = nativeResponse.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            return this.a.getMultiPicUrls();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageUrl);
        return arrayList;
    }

    public final int getInteractionType() {
        NativeResponse nativeResponse = this.a;
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

    public final int getNetworkId() {
        return this.i;
    }

    public final Object getOriginNativeAdData() {
        return this.a;
    }

    public final String getTitle() {
        NativeResponse nativeResponse = this.a;
        return nativeResponse != null ? nativeResponse.getTitle() : "";
    }

    public final boolean isExpressAd() {
        return false;
    }

    public final boolean isNativeDrawAd() {
        return false;
    }

    public final void pauseVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView != null) {
            xNativeView.pause();
        }
    }

    public final void render() {
    }

    public final View renderShakeView(int i, int i2, final WMNativeAdData.AdShakeViewListener adShakeViewListener) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.windmill.baidu.BdNSIAdData$6
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
        XNativeView xNativeView = this.g;
        if (xNativeView != null) {
            xNativeView.resume();
        }
    }

    public final void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.d = dislikeInteractionCallback;
        }
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
        if (appDownloadListener != null) {
            this.f = appDownloadListener;
        }
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.b = nativeAdInteractionListener;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (nativeADMediaListener != null) {
            this.f1149c = nativeADMediaListener;
        }
    }

    public final void setVideoMute(boolean z) {
        XNativeView xNativeView = this.g;
        if (xNativeView != null) {
            xNativeView.setVideoMute(z);
        }
    }

    public final void startVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView != null) {
            xNativeView.render();
        }
    }

    public final void stopVideo() {
        XNativeView xNativeView = this.g;
        if (xNativeView != null) {
            xNativeView.stop();
        }
    }
}
