package com.windmill.baidu;

import android.content.Context;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.sdk.WMAdConfig;
import com.windmill.sdk.WMCustomController;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BdAdapterProxy extends WMCustomAdapterProxy {
    private WMCustomController a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(19:3|(2:5|(2:7|(2:9|(4:11|(2:15|(1:(1:(1:(1:20))(1:167))(1:168))(1:169))|170|(0)(0))(4:171|(2:173|(0)(0))|170|(0)(0)))(4:174|(2:176|(0)(0))|170|(0)(0)))(4:177|(2:179|(0)(0))|170|(0)(0)))(4:180|(2:182|(0)(0))|170|(0)(0))|21|(17:23|24|26|28|29|30|(1:32)(1:141)|33|34|(9:36|37|39|41|(1:43)|44|(1:46)|(12:48|(1:50)|51|(10:53|54|56|63|(7:65|66|68|70|(4:72|73|75|77)|87|77)|98|70|(0)|87|77)|122|63|(0)|98|70|(0)|87|77)|123)|139|41|(0)|44|(0)|(0)|123)|166|28|29|30|(0)(0)|33|34|(0)|139|41|(0)|44|(0)|(0)|123)|183|21|(0)|166|28|29|30|(0)(0)|33|34|(0)|139|41|(0)|44|(0)|(0)|123) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f2, code lost:
    
        if (r1.equals("900") == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0129, code lost:
    
        r2.put("ad_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0122 A[Catch: Exception -> 0x0129, TRY_LEAVE, TryCatch #0 {Exception -> 0x0129, blocks: (B:30:0x0110, B:32:0x0116, B:33:0x011a, B:141:0x0122), top: B:29:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0116 A[Catch: Exception -> 0x0129, TryCatch #0 {Exception -> 0x0129, blocks: (B:30:0x0110, B:32:0x0116, B:33:0x011a, B:141:0x0122), top: B:29:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.LinkedHashMap<java.lang.String, java.lang.Object> castBiddingInfo(boolean r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.windmill.baidu.BdAdapterProxy.castBiddingInfo(boolean, java.util.Map):java.util.LinkedHashMap");
    }

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public int getAdapterSdkVersion() {
        return 39000;
    }

    public String getNetworkSdkVersion() {
        return AdSettings.getSDKVersion();
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            String str = (String) map.get("appId");
            SigmobLog.i(getClass().getSimpleName() + "---initializeADN:" + str);
            WMAdConfig adConfig = WindMillAd.sharedAds().getAdConfig();
            if (adConfig != null && adConfig.getCustomController() != null) {
                this.a = adConfig.getCustomController();
            }
            WMCustomController wMCustomController = this.a;
            if (wMCustomController != null) {
                MobadsPermissionSettings.setPermissionLocation(wMCustomController.isCanUseLocation());
                MobadsPermissionSettings.setPermissionReadDeviceID(this.a.isCanUsePhoneState());
                MobadsPermissionSettings.setPermissionStorage(this.a.isCanUseWriteExternal());
                MobadsPermissionSettings.setPermissionAppList(this.a.isCanUseAppList());
            }
            MobadsPermissionSettings.setLimitPersonalAds(!WindMillAd.sharedAds().isPersonalizedAdvertisingOn());
            BDAdConfig.Builder dialogParams = new BDAdConfig.Builder().setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build());
            callInitBefore(dialogParams);
            dialogParams.setAppsid(str).setWXAppid(WindMillAd.sharedAds().getWxOpenAppId()).build(context).init();
            callInitSuccess();
        } catch (Throwable th) {
            th.printStackTrace();
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage());
        }
    }

    public void notifyPrivacyStatusChange() {
        try {
            MobadsPermissionSettings.setLimitPersonalAds(!WindMillAd.sharedAds().isPersonalizedAdvertisingOn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
