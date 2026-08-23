package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    private final RewardVideoADListener i;
    private volatile boolean j;
    private LoadAdParams k;
    private ServerSideVerificationOptions l;
    private final boolean m;
    private final ADListenerAdapter n;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        private NegativeFeedbackListener a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
                return;
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    return;
                case 103:
                    this.adListener.onADExpose();
                    return;
                case 104:
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                        Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num != null) {
                            hashMap.put(ServerSideVerificationOptions.ACTION, num);
                        }
                        this.adListener.onReward(hashMap);
                        return;
                    }
                    return;
                case 105:
                    this.adListener.onADClick();
                    return;
                case 106:
                    this.adListener.onADClose();
                    return;
                case 107:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 != null) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(rewardVideoADListener, z);
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this(rewardVideoADListener, z);
        a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z) {
        this.k = null;
        this.m = z;
        this.i = rewardVideoADListener;
        this.n = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        RewardVideoADListener rewardVideoADListener = this.i;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.a;
        if (t != 0) {
            return ((RVADI) t).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.j = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.k = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.a(this.n, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.l = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((RVADI) t).showAD(activity);
        } else {
            a("showAD");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.m);
        rvadi.setLoadAdParams(this.k);
        rvadi.setServerSideVerificationOptions(this.l);
        if (this.j) {
            loadAD();
        }
    }
}
