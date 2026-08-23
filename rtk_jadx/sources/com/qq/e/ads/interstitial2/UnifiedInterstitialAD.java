package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {
    private AtomicInteger i;
    private AtomicInteger j;
    private volatile VideoOption k;
    private volatile int l;
    private volatile int m;
    private volatile LoadAdParams n;
    private UnifiedInterstitialADListener o;
    private ServerSideVerificationOptions p;
    private final ADListenerAdapter q;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.o = unifiedInterstitialADListener;
        this.q = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.o = unifiedInterstitialADListener;
        this.q = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.q);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.o;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    protected void c() {
        setVideoOption(this.k);
        setMinVideoDuration(this.l);
        setMaxVideoDuration(this.m);
        setLoadAdParams(this.n);
        setServerSideVerificationOptions(this.p);
        while (this.i.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.j.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.i.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.j.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.n = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.n);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.m = i;
        if (this.m > 0 && this.l > this.m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.q.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i) {
        this.l = i;
        if (this.m > 0 && this.l > this.m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.q.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.q.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.k = videoOption;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            a("show");
        }
    }

    public void show(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            a("show");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
