package com.qq.e.ads.interstitial2;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class ADListenerAdapter implements ADListener {
    private final UnifiedInterstitialADListener a;
    private UnifiedInterstitialMediaListener b;

    /* renamed from: c, reason: collision with root package name */
    private com.qq.e.comm.listeners.ADRewardListener f8c;
    private NegativeFeedbackListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.a = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.a;
            if (unifiedInterstitialADListener2 == null || !a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.a.onRenderSuccess();
            return;
        }
        if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.a;
            if (unifiedInterstitialADListener3 == null || !a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.a.onRenderFail();
            return;
        }
        if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.a;
                if (unifiedInterstitialADListener5 != null) {
                    unifiedInterstitialADListener5.onADReceive();
                    return;
                }
                return;
            case 101:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 == null || (unifiedInterstitialADListener = this.a) == null) {
                    return;
                }
                unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                return;
            case 102:
                UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.a;
                if (unifiedInterstitialADListener6 != null) {
                    unifiedInterstitialADListener6.onADOpened();
                    return;
                }
                return;
            case 103:
                UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.a;
                if (unifiedInterstitialADListener7 != null) {
                    unifiedInterstitialADListener7.onADExposure();
                    return;
                }
                return;
            case 104:
                if (this.f8c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                this.f8c.onReward(hashMap);
                return;
            case 105:
                UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.a;
                if (unifiedInterstitialADListener8 != null) {
                    unifiedInterstitialADListener8.onADClicked();
                    return;
                }
                return;
            case 106:
                UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.a;
                if (unifiedInterstitialADListener9 != null) {
                    unifiedInterstitialADListener9.onADClosed();
                    return;
                }
                return;
            default:
                switch (type) {
                    case 209:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.b;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                            return;
                        }
                        return;
                    case 210:
                        Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.b;
                        if (unifiedInterstitialMediaListener6 == null || num3 == null) {
                            return;
                        }
                        unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                        return;
                    case 211:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.b;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            return;
                        }
                        return;
                    default:
                        switch (type) {
                            case AdEventType.VIDEO_PAGE_OPEN /* 301 */:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.b;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    return;
                                }
                                return;
                            case 302:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.b;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    return;
                                }
                                return;
                            case 303:
                                UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.a;
                                if (unifiedInterstitialADListener10 != null) {
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                    return;
                                }
                                return;
                            case 304:
                                NegativeFeedbackListener negativeFeedbackListener = this.d;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f8c = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.b = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.d = negativeFeedbackListener;
    }
}
