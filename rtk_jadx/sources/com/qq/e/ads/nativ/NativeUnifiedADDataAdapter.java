package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {
    private NativeUnifiedADData a;
    private NativeADEventListener b;

    /* renamed from: c, reason: collision with root package name */
    private NativeADMediaListener f12c;
    private DownloadConfirmListener d;
    private NegativeFeedbackListener e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class UnifiedAdListener implements ADListener {
        private UnifiedAdListener() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeUnifiedADDataAdapter.a(NativeUnifiedADDataAdapter.this, aDEvent) || NativeUnifiedADDataAdapter.b(NativeUnifiedADDataAdapter.this, aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter.c(NativeUnifiedADDataAdapter.this, aDEvent);
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener());
        }
    }

    static boolean a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.b != null) {
            int type = aDEvent.getType();
            if (type == 103) {
                nativeUnifiedADDataAdapter.b.onADExposed();
            } else if (type == 105) {
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.b;
                if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                    ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.b).onADClicked((View) aDEvent.getParam(View.class));
                } else {
                    nativeADEventListener.onADClicked();
                }
            } else if (type == 107) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeUnifiedADDataAdapter.b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 111) {
                nativeUnifiedADDataAdapter.b.onADStatusChanged();
            }
            return true;
        }
        return false;
    }

    static boolean b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f12c != null) {
            switch (aDEvent.getType()) {
                case 201:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        nativeUnifiedADDataAdapter.f12c.onVideoLoaded(num.intValue());
                    }
                    return true;
                case 202:
                    nativeUnifiedADDataAdapter.f12c.onVideoStart();
                    return true;
                case 203:
                    nativeUnifiedADDataAdapter.f12c.onVideoResume();
                    return true;
                case 204:
                    nativeUnifiedADDataAdapter.f12c.onVideoPause();
                    return true;
                case 205:
                    nativeUnifiedADDataAdapter.f12c.onVideoStop();
                    return true;
                case 206:
                    nativeUnifiedADDataAdapter.f12c.onVideoCompleted();
                    return true;
                case 207:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 != null) {
                        nativeUnifiedADDataAdapter.f12c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    }
                    return true;
                case 208:
                    nativeUnifiedADDataAdapter.f12c.onVideoClicked();
                    return true;
                case 209:
                    nativeUnifiedADDataAdapter.f12c.onVideoInit();
                    return true;
                case 210:
                    nativeUnifiedADDataAdapter.f12c.onVideoReady();
                    return true;
                case 211:
                    nativeUnifiedADDataAdapter.f12c.onVideoLoading();
                    return true;
            }
        }
        return false;
    }

    static boolean c(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.e == null || aDEvent.getType() != 304) {
            return false;
        }
        nativeUnifiedADDataAdapter.e.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        this.a.bindImageViews(list, i);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.a.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f12c = nativeADMediaListener;
        this.a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.a.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.a.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.a.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.a.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.a.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.a.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.a.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.a.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.b = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.e = negativeFeedbackListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.a.stopVideo();
    }
}
