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
public interface POFactory extends InnerPOFactory {
    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ ACTD getActivityDelegate(String str, Activity activity);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ String getBuyerId(Map<String, Object> map);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ String getSDKInfo(String str);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ void start(JSONObject jSONObject);
}
