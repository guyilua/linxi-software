package com.qq.e.comm.constants;

import android.text.TextUtils;
import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomPkgConstants {
    private static final String a = DownloadService.class.getName();
    private static final String b = ADActivity.class.getName();

    /* renamed from: c, reason: collision with root package name */
    private static final String f17c = PortraitADActivity.class.getName();
    private static final String d = RewardvideoPortraitADActivity.class.getName();
    private static final String e = LandscapeADActivity.class.getName();
    private static final String f = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !TextUtils.isEmpty(customADActivityClassName) ? customADActivityClassName : b;
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return a;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !TextUtils.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !TextUtils.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f17c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : d;
    }
}
