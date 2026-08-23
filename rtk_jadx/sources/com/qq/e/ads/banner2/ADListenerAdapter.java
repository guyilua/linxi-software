package com.qq.e.ads.banner2;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class ADListenerAdapter implements ADListener {
    private final UnifiedBannerADListener a;
    private NegativeFeedbackListener b;

    /* renamed from: c, reason: collision with root package name */
    private ADRewardListener f3c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                    return;
                }
                return;
            case 104:
                if (this.f3c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                this.f3c.onReward(hashMap);
                return;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                    return;
                }
                return;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f3c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.b = negativeFeedbackListener;
    }
}
