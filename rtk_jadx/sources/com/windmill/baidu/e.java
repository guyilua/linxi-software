package com.windmill.baidu;

import android.app.Activity;
import com.windmill.sdk.base.WMAdapterError;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class e {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void adapterDidLoadBiddingPriceSuccess(String str, String... strArr);

        void onInterstitialAdClick();

        void onInterstitialAdClose();

        void onInterstitialAdFailToLoad(WMAdapterError wMAdapterError);

        void onInterstitialAdFailToPlaying(WMAdapterError wMAdapterError);

        void onInterstitialAdLoadSuccess();

        void onInterstitialAdPlayComplete();

        void onInterstitialAdStartPlaying();
    }

    public abstract Object a();

    public abstract void a(Activity activity);

    public abstract void a(String str, LinkedHashMap<String, Object> linkedHashMap);

    public abstract void a(String str, Map<String, Object> map);

    public abstract void b(String str, LinkedHashMap<String, Object> linkedHashMap);

    public abstract boolean b();

    public abstract void c();

    public abstract Map<String, Object> d();
}
