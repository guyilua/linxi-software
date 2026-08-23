package com.windmill.adscope;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.SplashAd;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdScopeSplashAdAdapter extends WMCustomSplashAdapter {
    private SplashAd a;
    private boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private Activity f1132c;

    private static DisplayMetrics a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            } catch (Exception e) {
                SigmobLog.e(e.getMessage());
            }
        }
        return displayMetrics;
    }

    static /* synthetic */ boolean a(AdScopeSplashAdAdapter adScopeSplashAdAdapter) {
        adScopeSplashAdAdapter.b = true;
        return true;
    }

    public void destroyAd() {
        SplashAd splashAd = this.a;
        if (splashAd != null) {
            Activity activity = this.f1132c;
            if (activity != null) {
                splashAd.cancel(activity);
            }
            this.a = null;
        }
    }

    public boolean isReady() {
        return this.b && this.a != null;
    }

    public void loadAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        try {
            this.b = false;
            if (activity == null) {
                callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
                return;
            }
            this.f1132c = activity;
            String str = (String) map2.get("placementId");
            SigmobLog.i(getClass().getSimpleName() + " loadAd:" + str);
            int i = a(activity).widthPixels;
            int i2 = a(activity).heightPixels;
            int px2dip = px2dip(activity, (float) i);
            int px2dip2 = px2dip(activity, (float) i2);
            try {
                Object obj = map2.get("load_timeout");
                r1 = obj != null ? Integer.parseInt(String.valueOf(obj)) : 5;
                Object obj2 = map.get("ad_key_width");
                if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                    px2dip = px2dip(activity, Integer.parseInt(String.valueOf(obj2)));
                }
                Object obj3 = map.get("ad_key_height");
                if (obj3 != null && ((Integer) obj3).intValue() != 0) {
                    px2dip2 = px2dip(activity, Integer.parseInt(String.valueOf(obj3)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            SplashAd splashAd = new SplashAd(activity, (View) null, str, new AdListener() { // from class: com.windmill.adscope.AdScopeSplashAdAdapter.1
                public final void onAdClicked() {
                    SigmobLog.i(AdScopeSplashAdAdapter.this.getClass().getSimpleName() + " onAdClicked");
                    AdScopeSplashAdAdapter.this.callSplashAdClick();
                }

                public final void onAdClosed() {
                    SigmobLog.i(AdScopeSplashAdAdapter.this.getClass().getSimpleName() + " onAdClosed");
                    AdScopeSplashAdAdapter.this.callSplashAdClosed();
                }

                public final void onAdFailedToLoad(int i3) {
                    SigmobLog.i(AdScopeSplashAdAdapter.this.getClass().getSimpleName() + " onAdFailedToLoad: " + i3);
                    AdScopeSplashAdAdapter.this.callLoadFail(new WMAdapterError(i3, "no message"));
                }

                public final void onAdLoaded() {
                    SigmobLog.i(AdScopeSplashAdAdapter.this.getClass().getSimpleName() + " onAdLoaded");
                    AdScopeSplashAdAdapter.a(AdScopeSplashAdAdapter.this);
                    int ecpm = AdScopeSplashAdAdapter.this.a != null ? AdScopeSplashAdAdapter.this.a.getECPM() : 0;
                    if (AdScopeSplashAdAdapter.this.getBiddingType() == 1) {
                        AdScopeSplashAdAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(ecpm)));
                    }
                    AdScopeSplashAdAdapter.this.callLoadSuccess();
                }

                public final void onAdShown() {
                    SigmobLog.i(AdScopeSplashAdAdapter.this.getClass().getSimpleName() + " onAdShown");
                    AdScopeSplashAdAdapter.this.callSplashAdShow();
                }

                public final void onAdTick(long j) {
                }
            }, 1000 * r1);
            this.a = splashAd;
            splashAd.loadAd(px2dip, px2dip2);
        } catch (Exception e2) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e2.getMessage()));
        }
    }

    public int px2dip(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= com.sigmob.sdk.base.blurkit.c.d) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        try {
            SplashAd splashAd = this.a;
            if (splashAd != null) {
                splashAd.show(viewGroup);
            } else {
                callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "mSplashAD is null"));
            }
            this.b = false;
        } catch (Exception e) {
            callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
