package com.windmill.adscope;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZiCustomController;
import com.beizi.fusion.BeiZis;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WMAdConfig;
import com.windmill.sdk.WMCustomController;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdScopeAdapterProxy extends WMCustomAdapterProxy {
    private WMCustomController a;

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public int getAdapterSdkVersion() {
        return 39000;
    }

    public String getNetworkSdkVersion() {
        return BeiZis.getSdkVersion();
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            String str = (String) map.get("appId");
            SigmobLog.i(getClass().getSimpleName() + " initializeADN:" + str);
            if (!TextUtils.isEmpty(WindMillAd.sharedAds().getOaidVersion())) {
                BeiZis.setOaidVersion(WindMillAd.sharedAds().getOaidVersion());
            }
            WMAdConfig adConfig = WindMillAd.sharedAds().getAdConfig();
            if (adConfig != null && adConfig.getCustomController() != null) {
                this.a = adConfig.getCustomController();
            }
            BeiZis.init(context, str, new BeiZiCustomController() { // from class: com.windmill.adscope.AdScopeAdapterProxy.1
                public final String getDevOaid() {
                    return AdScopeAdapterProxy.this.a != null ? AdScopeAdapterProxy.this.a.getDevOaid() : super.getDevOaid();
                }

                public final String getOaidVersion() {
                    return !TextUtils.isEmpty(WindMillAd.sharedAds().getOaidVersion()) ? WindMillAd.sharedAds().getOaidVersion() : super.getOaidVersion();
                }

                public final boolean isCanUseLocation() {
                    return AdScopeAdapterProxy.this.a != null ? AdScopeAdapterProxy.this.a.isCanUseLocation() : super.isCanUseLocation();
                }

                public final boolean isCanUsePhoneState() {
                    return AdScopeAdapterProxy.this.a != null ? AdScopeAdapterProxy.this.a.isCanUsePhoneState() : super.isCanUsePhoneState();
                }

                public final boolean isCanUseWifiState() {
                    return AdScopeAdapterProxy.this.a != null ? AdScopeAdapterProxy.this.a.isCanUseWifiState() : super.isCanUseWifiState();
                }
            });
            callInitSuccess();
        } catch (Throwable th) {
            th.printStackTrace();
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage());
        }
    }

    public void notifyPrivacyStatusChange() {
        try {
            BeiZis.setSupportPersonalized(WindMillAd.sharedAds().isPersonalizedAdvertisingOn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
