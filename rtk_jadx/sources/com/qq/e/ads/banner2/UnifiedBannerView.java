package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {
    final UnifiedBannerAD a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.a.destroy();
    }

    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.a.getECPM();
    }

    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    public boolean isValid() {
        return this.a.isValid();
    }

    public void loadAD() {
        this.a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.a.onWindowFocusChanged(z);
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
        this.a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        this.a.f(i);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.a.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
