package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
interface InnerPOFactory {
    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    String getBuyerId();

    String getBuyerId(Map<String, Object> map);

    DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    String getSDKInfo(String str);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);

    void start(JSONObject jSONObject);
}
