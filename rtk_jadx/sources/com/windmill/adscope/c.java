package com.windmill.adscope;

import android.app.Activity;
import com.windmill.sdk.base.WMAdapterError;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class c {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void onInterstitialAdClick();

        void onInterstitialAdClose();

        void onInterstitialAdFailToLoad(WMAdapterError wMAdapterError);

        void onInterstitialAdFailToPlaying(WMAdapterError wMAdapterError);

        void onInterstitialAdLoadSuccess(int i);

        void onInterstitialAdStartPlaying();
    }

    public abstract void a(Activity activity);

    public abstract void a(String str, Map<String, Object> map);

    public abstract boolean a();

    public abstract void b();
}
