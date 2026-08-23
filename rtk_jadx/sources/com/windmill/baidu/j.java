package com.windmill.baidu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.czhj.sdk.common.utils.ImageManager;
import com.qumeng.advlib.core.ADEvent;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import com.windmill.sdk.natives.WMNativePrivacyInfo;
import com.windmill.sdk.natives.WMVideoOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class j extends WMNativeAdData {
    WMNativeAdData.NativeAdInteractionListener a;
    WMCustomNativeAdapter b;

    /* renamed from: c, reason: collision with root package name */
    WMNativeAdData f1151c = this;
    WMVideoOption d;
    private NativeResponse e;
    private WMNativeAdData.NativeADMediaListener f;
    private WMNativeAdData.DislikeInteractionCallback g;
    private Bitmap h;
    private WMNativeAdData.AppDownloadListener i;
    private Map<String, Object> j;
    private FeedPortraitVideoView k;

    public j(Context context, NativeResponse nativeResponse, WMCustomNativeAdapter wMCustomNativeAdapter, Map<String, Object> map) {
        this.e = nativeResponse;
        this.b = wMCustomNativeAdapter;
        this.j = map;
        if (context == null || nativeResponse == null) {
            return;
        }
        ImageManager.with(context).getBitmap(this.e.getBaiduLogoUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.windmill.baidu.j.1
            public final void onBitmapLoadFailed() {
            }

            public final void onBitmapLoaded(Bitmap bitmap) {
                j.this.h = bitmap;
            }
        });
    }

    private WMImage a(final String str) {
        return new WMImage() { // from class: com.windmill.baidu.j.3
            public final int getHeight() {
                return j.this.e.getMainPicHeight();
            }

            public final String getImageUrl() {
                return str;
            }

            public final int getWidth() {
                return j.this.e.getMainPicWidth();
            }

            public final boolean isValid() {
                return true;
            }
        };
    }

    public final void bindImageViews(Context context, List<ImageView> list, int i) {
        if (this.e == null || list.isEmpty()) {
            return;
        }
        String imageUrl = this.e.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            ImageManager.with(context).load(imageUrl).placeholder(i).error(i).into(list.get(0));
            return;
        }
        List multiPicUrls = this.e.getMultiPicUrls();
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
        if (this.e != null) {
            if (viewGroup != null) {
                FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(viewGroup.getContext());
                this.k = feedPortraitVideoView;
                WMVideoOption wMVideoOption = this.d;
                if (wMVideoOption != null) {
                    feedPortraitVideoView.setShowProgress(wMVideoOption.isNeedProgressBar());
                } else {
                    feedPortraitVideoView.setShowProgress(true);
                }
                this.k.setProgressBackgroundColor(-16777216);
                this.k.setProgressBarColor(-1);
                this.k.setProgressHeightInDp(1);
                this.k.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.windmill.baidu.BdNativeDrawAdData$7
                    public void pauseBtnClick() {
                        WMLogUtil.d(WMLogUtil.TAG, "----------pauseBtnClick()---------");
                    }

                    public void playCompletion() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "---------playCompletion----------");
                        nativeADMediaListener = j.this.f;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = j.this.f;
                            nativeADMediaListener2.onVideoCompleted();
                        }
                    }

                    public void playError() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "----------playError()---------");
                        nativeADMediaListener = j.this.f;
                        if (nativeADMediaListener != null) {
                            WindMillError windMillError = WindMillError.ERROR_AD_PLAY;
                            nativeADMediaListener2 = j.this.f;
                            nativeADMediaListener2.onVideoError(windMillError);
                        }
                    }

                    public void playPause() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "----------------playPause()-------------");
                        nativeADMediaListener = j.this.f;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = j.this.f;
                            nativeADMediaListener2.onVideoPause();
                        }
                    }

                    public void playRenderingStart() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "------------playRenderingStart()-----------");
                        nativeADMediaListener = j.this.f;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = j.this.f;
                            nativeADMediaListener2.onVideoStart();
                        }
                    }

                    public void playResume() {
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener;
                        WMNativeAdData.NativeADMediaListener nativeADMediaListener2;
                        WMLogUtil.d(WMLogUtil.TAG, "------------playResume()------------");
                        nativeADMediaListener = j.this.f;
                        if (nativeADMediaListener != null) {
                            nativeADMediaListener2 = j.this.f;
                            nativeADMediaListener2.onVideoResume();
                        }
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                viewGroup.removeAllViews();
                viewGroup.addView((View) this.k, (ViewGroup.LayoutParams) layoutParams);
            }
            if (this.k != null) {
                Map<String, Object> map = this.j;
                if (map != null) {
                    Object obj = map.get("autoPlayMuted");
                    Object obj2 = this.j.get("showDownloadDialog");
                    if (obj == null || !obj.equals("0")) {
                        this.k.setVideoMute(true);
                    } else {
                        this.k.setVideoMute(false);
                    }
                    if (obj2 == null || !obj2.equals("1")) {
                        this.k.setUseDownloadFrame(false);
                    } else {
                        this.k.setUseDownloadFrame(true);
                    }
                }
                this.k.setAdData(this.e);
                this.k.play();
            }
        }
    }

    public final void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
        NativeResponse nativeResponse = this.e;
        if (nativeResponse != null) {
            nativeResponse.registerViewForInteraction(view, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.windmill.baidu.BdNativeDrawAdData$2
                public void onADExposed() {
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
                    WMCustomNativeAdapter wMCustomNativeAdapter;
                    WMCustomNativeAdapter wMCustomNativeAdapter2;
                    WMNativeAdData wMNativeAdData;
                    WMCustomNativeAdapter wMCustomNativeAdapter3;
                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener2;
                    WMCustomNativeAdapter wMCustomNativeAdapter4;
                    WMNativeAdData wMNativeAdData2;
                    nativeAdInteractionListener = j.this.a;
                    if (nativeAdInteractionListener != null) {
                        wMCustomNativeAdapter3 = j.this.b;
                        if (wMCustomNativeAdapter3 != null) {
                            nativeAdInteractionListener2 = j.this.a;
                            wMCustomNativeAdapter4 = j.this.b;
                            wMNativeAdData2 = j.this.f1151c;
                            nativeAdInteractionListener2.onADExposed(wMCustomNativeAdapter4.getAdInFo(wMNativeAdData2));
                        }
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "onADExposed:" + j.this.e.getTitle());
                    wMCustomNativeAdapter = j.this.b;
                    if (wMCustomNativeAdapter != null) {
                        wMCustomNativeAdapter2 = j.this.b;
                        wMNativeAdData = j.this.f1151c;
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
                    if (j.this.e.getAdActionType() == 2) {
                        appDownloadListener = j.this.i;
                        if (appDownloadListener != null) {
                            int downloadStatus = j.this.e.getDownloadStatus();
                            if (downloadStatus >= 0 && downloadStatus <= 100) {
                                appDownloadListener7 = j.this.i;
                                appDownloadListener7.onDownloadActive(100L, downloadStatus, "", "");
                                return;
                            }
                            if (downloadStatus == 101) {
                                appDownloadListener6 = j.this.i;
                                appDownloadListener6.onDownloadFinished(100L, "", "");
                                return;
                            }
                            if (downloadStatus == 102) {
                                appDownloadListener5 = j.this.i;
                                appDownloadListener5.onDownloadPaused(100L, 50L, "", "");
                            } else if (downloadStatus == 103) {
                                appDownloadListener4 = j.this.i;
                                appDownloadListener4.onInstalled("", "");
                            } else if (downloadStatus == 104) {
                                appDownloadListener3 = j.this.i;
                                appDownloadListener3.onDownloadFailed(100L, 1L, "", "");
                            } else {
                                appDownloadListener2 = j.this.i;
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
                    nativeAdInteractionListener = j.this.a;
                    if (nativeAdInteractionListener != null) {
                        wMCustomNativeAdapter3 = j.this.b;
                        if (wMCustomNativeAdapter3 != null) {
                            nativeAdInteractionListener2 = j.this.a;
                            wMCustomNativeAdapter4 = j.this.b;
                            wMNativeAdData2 = j.this.f1151c;
                            nativeAdInteractionListener2.onADClicked(wMCustomNativeAdapter4.getAdInFo(wMNativeAdData2));
                        }
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "onAdClick:" + j.this.e.getTitle());
                    wMCustomNativeAdapter = j.this.b;
                    if (wMCustomNativeAdapter != null) {
                        wMCustomNativeAdapter2 = j.this.b;
                        wMNativeAdData = j.this.f1151c;
                        wMCustomNativeAdapter2.callNativeAdClick(wMNativeAdData);
                    }
                }

                public void onAdUnionClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "onAdUnionClick()");
                }
            });
            this.e.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.windmill.baidu.BdNativeDrawAdData$3
                public void adDownloadWindowClose() {
                    FeedPortraitVideoView feedPortraitVideoView;
                    FeedPortraitVideoView feedPortraitVideoView2;
                    WMLogUtil.d(WMLogUtil.TAG, "adDownloadWindowClose");
                    feedPortraitVideoView = j.this.k;
                    if (feedPortraitVideoView != null) {
                        feedPortraitVideoView2 = j.this.k;
                        feedPortraitVideoView2.resume();
                    }
                }

                public void adDownloadWindowShow() {
                    FeedPortraitVideoView feedPortraitVideoView;
                    FeedPortraitVideoView feedPortraitVideoView2;
                    WMLogUtil.d(WMLogUtil.TAG, "AdDownloadWindowShow");
                    feedPortraitVideoView = j.this.k;
                    if (feedPortraitVideoView != null) {
                        feedPortraitVideoView2 = j.this.k;
                        feedPortraitVideoView2.pause();
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
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.windmill.baidu.j.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        if (j.this.g != null) {
                            j.this.g.onSelected(0, ADEvent.BAIDU, true);
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
        FeedPortraitVideoView feedPortraitVideoView = this.k;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }

    public final Bitmap getAdLogo() {
        return this.h;
    }

    public final int getAdPatternType() {
        return 4;
    }

    public final WMNativeAdData.AppInfo getAppInfo() {
        NativeResponse nativeResponse = this.e;
        if (nativeResponse != null) {
            return new WMNativePrivacyInfo(nativeResponse.getBrandName(), this.e.getAppVersion(), this.e.getAppSize(), this.e.getAppPackage(), this.e.getPublisher(), this.e.getAppPrivacyLink(), "", this.e.getAppPermissionLink(), this.e.getAppFunctionLink());
        }
        return null;
    }

    public final String getCTAText() {
        NativeResponse nativeResponse = this.e;
        if (nativeResponse == null) {
            return "查看详情";
        }
        String actButtonString = nativeResponse.getActButtonString();
        if (this.e.getAdActionType() != 2) {
            return !TextUtils.isEmpty(actButtonString) ? actButtonString : "查看详情";
        }
        int downloadStatus = this.e.getDownloadStatus();
        if (downloadStatus < 0 || downloadStatus > 100) {
            return downloadStatus == 101 ? "点击安装" : downloadStatus == 102 ? "继续下载" : downloadStatus == 103 ? "点击启动" : downloadStatus == 104 ? "重新下载" : !TextUtils.isEmpty(actButtonString) ? actButtonString : "点击下载";
        }
        return "下载中：" + downloadStatus + "%";
    }

    public final WMNativeAdData.CustomizeVideo getCustomizeVideo() {
        final NativeResponse.CustomizeMediaPlayer customizeMediaPlayer;
        NativeResponse nativeResponse = this.e;
        return (nativeResponse == null || (customizeMediaPlayer = nativeResponse.getCustomizeMediaPlayer()) == null) ? super.getCustomizeVideo() : new WMNativeAdData.CustomizeVideo() { // from class: com.windmill.baidu.j.4
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
        NativeResponse nativeResponse = this.e;
        return nativeResponse != null ? nativeResponse.getDesc() : "";
    }

    public final View getExpressAdView() {
        return null;
    }

    public final String getIconUrl() {
        NativeResponse nativeResponse = this.e;
        return nativeResponse != null ? nativeResponse.getIconUrl() : "";
    }

    public final List<WMImage> getImageList() {
        if (this.e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String imageUrl = this.e.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            arrayList.add(a(imageUrl));
        } else if (this.e.getMultiPicUrls() != null) {
            for (int i = 0; i < this.e.getMultiPicUrls().size(); i++) {
                arrayList.add(a((String) this.e.getMultiPicUrls().get(i)));
            }
        }
        return arrayList;
    }

    public final List<String> getImageUrlList() {
        NativeResponse nativeResponse = this.e;
        if (nativeResponse == null) {
            return null;
        }
        String imageUrl = nativeResponse.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            return this.e.getMultiPicUrls();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageUrl);
        return arrayList;
    }

    public final int getInteractionType() {
        NativeResponse nativeResponse = this.e;
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
        WMCustomNativeAdapter wMCustomNativeAdapter = this.b;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public final Object getOriginNativeAdData() {
        return this.e;
    }

    public final String getTitle() {
        NativeResponse nativeResponse = this.e;
        return nativeResponse != null ? nativeResponse.getTitle() : "";
    }

    public final boolean isExpressAd() {
        return false;
    }

    public final boolean isNativeDrawAd() {
        return true;
    }

    public final void pauseVideo() {
        FeedPortraitVideoView feedPortraitVideoView = this.k;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    public final void render() {
    }

    public final View renderShakeView(int i, int i2, final WMNativeAdData.AdShakeViewListener adShakeViewListener) {
        NativeResponse nativeResponse = this.e;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.windmill.baidu.BdNativeDrawAdData$6
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
        FeedPortraitVideoView feedPortraitVideoView = this.k;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    public final void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.g = dislikeInteractionCallback;
        }
    }

    public final void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
        if (appDownloadListener != null) {
            this.i = appDownloadListener;
        }
    }

    public final void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.a = nativeAdInteractionListener;
        }
    }

    public final void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (nativeADMediaListener != null) {
            this.f = nativeADMediaListener;
        }
    }

    public final void setMediaViewOption(WMVideoOption wMVideoOption) {
        this.d = wMVideoOption;
    }

    public final void startVideo() {
        FeedPortraitVideoView feedPortraitVideoView = this.k;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.play();
        }
    }

    public final void stopVideo() {
        FeedPortraitVideoView feedPortraitVideoView = this.k;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }
}
