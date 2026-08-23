package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {
    private volatile ViewGroup i;
    private volatile SplashADListener j;
    private volatile ADRewardListener k;
    private volatile LoadAdParams l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile int p;
    private volatile byte[] q;
    private volatile ServerSideVerificationOptions r;
    private int s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.j == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l = (Long) aDEvent.getParam(Long.class);
                if (l != null) {
                    SplashAD.this.j.onADTick(l.longValue());
                    return;
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.j.onADLoaded(l2.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.j.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.j.onADPresent();
                    return;
                case 103:
                    SplashAD.this.j.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.k == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                    SplashAD.this.k.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.j.onADClicked();
                    return;
                case 106:
                    SplashAD.this.j.onADDismissed();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.m = false;
        this.j = splashADListener;
        this.s = i;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.m = false;
        this.j = splashADListener;
        this.s = i;
        a(context, str, str2);
    }

    private void g(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.o = z;
            this.i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void h(boolean z) {
        if (a()) {
            if (!b()) {
                this.o = z;
                this.n = true;
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void j(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        if (this.j != null) {
            this.j.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void fetchAdOnly() {
        h(false);
    }

    public void fetchFullScreenAdOnly() {
        h(true);
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.m = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.a;
        if (t == 0) {
            this.p = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.a;
        if (t == 0) {
            this.q = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.l = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.k = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.r = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        j(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        j(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.l != null) {
            nspvi.setLoadAdParams(this.l);
        }
        if (this.p != 0) {
            nspvi.setDeveloperLogo(this.p);
        }
        if (this.q != null) {
            nspvi.setDeveloperLogo(this.q);
        }
        nspvi.setFetchDelay(this.s);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.r);
        if (this.i != null) {
            if (this.o) {
                g(this.i, true);
            } else {
                g(this.i, false);
            }
        }
        if (this.m) {
            nspvi.preload();
            this.m = false;
        }
        if (this.n) {
            if (this.o) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.n = false;
        }
    }
}
