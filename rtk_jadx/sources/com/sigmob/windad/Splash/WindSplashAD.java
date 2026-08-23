package com.sigmob.windad.Splash;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.utils.f;
import com.sigmob.sdk.splash.g;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.umeng.analytics.pro.i;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class WindSplashAD extends j implements AdLifecycleManager.LifecycleListener, WindSplashADListener {
    public AdStatus adStatus;
    private WindSplashADListener b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f687c;
    private int d;
    private RelativeLayout e;
    private boolean f;
    private boolean g;
    private boolean h;
    private g i;
    private Handler j;

    public WindSplashAD(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        super(windSplashAdRequest, false);
        this.adStatus = AdStatus.AdStatusNone;
        this.d = 5;
        this.g = false;
        this.b = windSplashADListener;
        this.j = new Handler(Looper.getMainLooper());
        this.i = new g(windSplashAdRequest, this);
        this.d = windSplashAdRequest.getFetchDelay();
        this.f = windSplashAdRequest.isDisableAutoHideAd();
    }

    private void a(final WindAdError windAdError, final String str) {
        SigmobLog.e("onSplashError: " + windAdError + " :placementId: " + str);
        if (this.g) {
            return;
        }
        this.j.removeMessages(1);
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.2
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.g = true;
                    WindSplashAD.this.b.onSplashAdLoadFail(windAdError, str);
                }
            }
        });
        h();
    }

    private void d() {
        if (this.f687c != null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f687c.getContext());
            this.e = relativeLayout;
            relativeLayout.setVisibility(4);
            this.e.setId(ClientMetadata.generateViewId());
            this.f687c.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.i == null) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, a());
            return;
        }
        d();
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.1
            @Override // java.lang.Runnable
            public void run() {
                WindSplashAD.this.i.a(WindSplashAD.this.e);
            }
        });
        this.adStatus = AdStatus.AdStatusPlaying;
    }

    private boolean f() {
        if (!loadAdFilter()) {
            return false;
        }
        AdLifecycleManager.getInstance().addLifecycleListener(this);
        this.adStatus = AdStatus.AdStatusLoading;
        if (!this.i.g()) {
            b();
        }
        this.i.a(getBid_token(), getBidFloor(), getCurrency(), this.d, false);
        return true;
    }

    private void g() {
        ViewGroup viewGroup;
        Activity c2;
        if (Build.VERSION.SDK_INT < 19 || (viewGroup = this.f687c) == null || (c2 = f.c(viewGroup)) == null) {
            return;
        }
        Window window = c2.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = i.b;
        window.setAttributes(attributes);
        window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f) {
            return;
        }
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.e.removeAllViews();
            this.e = null;
        }
        this.f687c = null;
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(final WindAdError windAdError) {
        this.adStatus = AdStatus.AdStatusNone;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.8
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdLoadFail(windAdError, WindSplashAD.this.a());
                }
            }
        });
    }

    @Override // com.sigmob.sdk.base.j
    protected void a(String str, String str2) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    protected Map<String, BiddingResponse> c() {
        g gVar = this.i;
        if (gVar != null) {
            return gVar.l();
        }
        return null;
    }

    public void destroy() {
        Object[] objArr = new Object[1];
        WindAdRequest windAdRequest = this.a;
        objArr[0] = windAdRequest != null ? windAdRequest.getPlacementId() : "null";
        SigmobLog.i(String.format("splash ad  %s is Destroy", objArr));
        g gVar = this.i;
        if (gVar != null) {
            gVar.j();
            this.j.removeCallbacksAndMessages(null);
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                this.e.removeAllViews();
                this.e = null;
            }
            this.b = null;
            this.f687c = null;
        }
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        g gVar = this.i;
        if (gVar != null) {
            return gVar.k();
        }
        return null;
    }

    public boolean isReady() {
        return this.adStatus == AdStatus.AdStatusReady && this.i.g();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd() {
        this.h = false;
        super.loadAd();
        return f();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        super.loadAd(str);
        return f();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd();
        this.f687c = viewGroup;
        this.h = true;
        f();
    }

    public void loadAndShow(String str, ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd(str);
        this.f687c = viewGroup;
        this.h = true;
        f();
    }

    public void onCreate(Activity activity) {
    }

    public void onDestroy(Activity activity) {
    }

    public void onPause(Activity activity) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.a(activity);
        }
    }

    public void onResume(Activity activity) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.b(activity);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClick(String str) {
        WindSplashADListener windSplashADListener = this.b;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClick(str);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClose(final String str) {
        this.adStatus = AdStatus.AdStatusClose;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.5
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdClose(str);
                }
                WindSplashAD.this.h();
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadFail(final WindAdError windAdError, final String str) {
        this.adStatus = AdStatus.AdStatusNone;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.4
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdLoadFail(windAdError, str);
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadSuccess(final String str) {
        this.adStatus = AdStatus.AdStatusReady;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.3
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdLoadSuccess(str);
                }
                if (WindSplashAD.this.h) {
                    WindSplashAD.this.e();
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShow(String str) {
        WindSplashADListener windSplashADListener = this.b;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdShow(str);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShowError(final WindAdError windAdError, final String str) {
        this.adStatus = AdStatus.AdStatusNone;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.7
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdShowError(windAdError, str);
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdSkip(final String str) {
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.6
            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.b != null) {
                    WindSplashAD.this.b.onSplashAdSkip(str);
                }
            }
        });
    }

    public void onStart(Activity activity) {
    }

    public void onStop(Activity activity) {
    }

    public void show(ViewGroup viewGroup) {
        if (this.h) {
            return;
        }
        if (this.adStatus != AdStatus.AdStatusReady) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, a());
        } else if (viewGroup == null) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL, a());
        } else {
            this.f687c = viewGroup;
            e();
        }
    }
}
