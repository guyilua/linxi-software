package com.windmill.adscope;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.adscope.d;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e extends d {
    NativeAd a;
    List<WMNativeAdData> b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    d.a f1135c;
    WMCustomNativeAdapter d;

    public e(WMCustomNativeAdapter wMCustomNativeAdapter, d.a aVar) {
        this.d = wMCustomNativeAdapter;
        this.f1135c = aVar;
    }

    private static float e() {
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (f <= com.sigmob.sdk.base.blurkit.c.d) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    @Override // com.windmill.adscope.d
    public final void a(Context context, final String str, Map<String, Object> map, Map<String, Object> map2) {
        float e;
        int i;
        try {
            this.b.clear();
            SigmobLog.i(getClass().getSimpleName() + " loadAd " + str);
            float e2 = e();
            float f = com.sigmob.sdk.base.blurkit.c.d;
            if (map != null) {
                try {
                    Object obj = map.get("ad_key_width");
                    if (obj != null && ((Integer) obj).intValue() != 0) {
                        e2 = ((Integer) obj).intValue();
                    }
                    Object obj2 = map.get("ad_key_height");
                    if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                        f = ((Integer) obj2).intValue();
                    }
                } catch (Exception unused) {
                    e = e();
                }
            }
            e = e2;
            try {
                Object obj3 = map2.get("adTemplateType");
                i = obj3 != null ? Integer.parseInt((String) obj3) : 1;
            } catch (Exception e3) {
                e3.printStackTrace();
                i = 1;
            }
            WMLogUtil.d(WMLogUtil.TAG, e + "-----expressViewWidth--------expressViewHeight-------:" + f);
            NativeAd nativeAd = new NativeAd(context, str, new NativeAdListener() { // from class: com.windmill.adscope.e.1
                public final void onAdClick() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdClick---------");
                    List<WMNativeAdData> list = e.this.b;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < e.this.b.size(); i2++) {
                        WMNativeAdData wMNativeAdData = e.this.b.get(i2);
                        a aVar = (a) wMNativeAdData;
                        AdInfo adInFo = e.this.d.getAdInFo(aVar);
                        WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener = aVar.a;
                        if (nativeAdInteractionListener != null) {
                            nativeAdInteractionListener.onADClicked(adInFo);
                        }
                        d.a aVar2 = e.this.f1135c;
                        if (aVar2 != null) {
                            aVar2.onADClicked(wMNativeAdData);
                        }
                    }
                }

                public final void onAdClosed() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdClosed---------");
                }

                public final void onAdClosed(View view) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdClosed---------".concat(String.valueOf(view)));
                    List<WMNativeAdData> list = e.this.b;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < e.this.b.size(); i2++) {
                        WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = ((a) e.this.b.get(i2)).b;
                        if (dislikeInteractionCallback != null) {
                            dislikeInteractionCallback.onSelected(0, "adscope", true);
                        }
                    }
                }

                public final void onAdFailed(int i2) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdFailed---------".concat(String.valueOf(i2)));
                    if (e.this.f1135c != null) {
                        e.this.f1135c.onNativeAdFailToLoad(new WMAdapterError(i2, "onAdFailed"));
                    }
                }

                public final void onAdLoaded(View view) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdLoaded---------".concat(String.valueOf(view)));
                    if (view == null) {
                        if (e.this.f1135c != null) {
                            e.this.f1135c.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "view is null " + str));
                            return;
                        }
                        return;
                    }
                    NativeAd nativeAd2 = e.this.a;
                    int ecpm = nativeAd2 != null ? nativeAd2.getECPM() : 0;
                    e.this.b.add(new a(view, e.this.d));
                    e eVar = e.this;
                    d.a aVar = eVar.f1135c;
                    if (aVar != null) {
                        aVar.onNativeAdLoadSuccess(eVar.b, ecpm);
                    }
                }

                public final void onAdShown() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdShown---------");
                    List<WMNativeAdData> list = e.this.b;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < e.this.b.size(); i2++) {
                        WMNativeAdData wMNativeAdData = e.this.b.get(i2);
                        a aVar = (a) wMNativeAdData;
                        AdInfo adInFo = e.this.d.getAdInFo(aVar);
                        WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener = aVar.a;
                        if (nativeAdInteractionListener != null) {
                            nativeAdInteractionListener.onADExposed(adInFo);
                        }
                        d.a aVar2 = e.this.f1135c;
                        if (aVar2 != null) {
                            aVar2.onADExposure(wMNativeAdData);
                        }
                    }
                }
            }, 5000L, i);
            this.a = nativeAd;
            nativeAd.loadAd(e, f);
        } catch (Throwable th) {
            SigmobLog.i(e.class.getSimpleName() + " catch throwable " + th);
            d.a aVar = this.f1135c;
            if (aVar != null) {
                aVar.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage()));
            }
        }
    }

    @Override // com.windmill.adscope.d
    public final boolean a() {
        return this.b.size() > 0;
    }

    @Override // com.windmill.adscope.d
    public final void b() {
        NativeAd nativeAd = this.a;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.a = null;
        }
    }

    @Override // com.windmill.adscope.d
    public final void c() {
        NativeAd nativeAd = this.a;
        if (nativeAd != null) {
            nativeAd.resume();
        }
    }

    @Override // com.windmill.adscope.d
    public final List<WMNativeAdData> d() {
        return this.b;
    }
}
