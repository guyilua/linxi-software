package com.sigmob.sdk.base.models;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardAdRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoadAdRequest implements Serializable {
    private int ad_count = 1;
    private String ad_scene;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String adx_id;
    private int bidFloor;
    private String bidToken;
    private String currency;
    private boolean disableAutoHideAd;
    private boolean enable_keep_on;
    private boolean enable_screen_lock_displayad;
    private boolean isExpired;
    private boolean isHalfInterstitial;
    private String last_campid;
    private String last_crid;
    private final int mAdtype;
    private String mLoadId;
    private Map<String, String> mOptions;
    private final String mPlacementId;
    private final String mUserId;
    private String requestId;
    private int request_scene_type;

    public LoadAdRequest(WindAdRequest windAdRequest) {
        boolean isEnableScreenLockDisPlayAd;
        this.mUserId = windAdRequest.getUserId();
        this.mLoadId = windAdRequest.getLoadId();
        this.adx_id = windAdRequest.getAdxId();
        SigmobLog.i("adx_id:" + windAdRequest.getAdxId());
        this.mAdtype = windAdRequest.getAdType();
        this.isHalfInterstitial = windAdRequest.isHalfInterstitial();
        this.mPlacementId = windAdRequest.getPlacementId();
        if (windAdRequest instanceof WindSplashAdRequest) {
            this.disableAutoHideAd = ((WindSplashAdRequest) windAdRequest).isDisableAutoHideAd();
        } else {
            if (windAdRequest instanceof WindRewardAdRequest) {
                WindRewardAdRequest windRewardAdRequest = (WindRewardAdRequest) windAdRequest;
                this.enable_keep_on = windRewardAdRequest.isEnableKeepOn();
                isEnableScreenLockDisPlayAd = windRewardAdRequest.isEnableScreenLockDisPlayAd();
            } else if (windAdRequest instanceof WindNewInterstitialAdRequest) {
                WindNewInterstitialAdRequest windNewInterstitialAdRequest = (WindNewInterstitialAdRequest) windAdRequest;
                this.enable_keep_on = windNewInterstitialAdRequest.isEnableKeepOn();
                isEnableScreenLockDisPlayAd = windNewInterstitialAdRequest.isEnableScreenLockDisPlayAd();
            }
            this.enable_screen_lock_displayad = isEnableScreenLockDisPlayAd;
        }
        if (windAdRequest.hasOptions()) {
            this.mOptions = new HashMap();
            for (String str : windAdRequest.getOptions().keySet()) {
                Object obj = windAdRequest.getOptions().get(str);
                this.mOptions.put(str, obj instanceof String ? (String) obj : obj != null ? obj.toString() : "");
            }
        }
    }

    public int getAdCount() {
        return this.ad_count;
    }

    public String getAdSceneDesc() {
        return this.ad_scene_desc;
    }

    public String getAdSceneId() {
        return this.ad_scene_id;
    }

    public int getAdType() {
        return this.mAdtype;
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public int getBidFloor() {
        return this.bidFloor;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getLastCampid() {
        return this.last_campid;
    }

    public String getLastCrid() {
        return this.last_crid;
    }

    public String getLoadId() {
        return this.mLoadId;
    }

    public Map<String, String> getOptions() {
        return this.mOptions;
    }

    public String getPlacementId() {
        return this.mPlacementId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getRequest_scene_type() {
        return this.request_scene_type;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isDisableAutoHideAd() {
        return this.disableAutoHideAd;
    }

    public boolean isEnable_keep_on() {
        return this.enable_keep_on;
    }

    public boolean isEnable_screen_lock_displayad() {
        return this.enable_screen_lock_displayad;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public void setAd_count(int i) {
        this.ad_count = i;
    }

    public void setAd_scene_desc(String str) {
        this.ad_scene_desc = str;
    }

    public void setAd_scene_id(String str) {
        this.ad_scene_id = str;
    }

    public void setAdx_id(String str) {
        this.adx_id = str;
        SigmobLog.i("new adx_id: " + this.adx_id);
    }

    public void setBidFloor(int i) {
        this.bidFloor = i;
    }

    public LoadAdRequest setBidToken(String str) {
        this.bidToken = str;
        return this;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDisableAutoHideAd(boolean z) {
        this.disableAutoHideAd = z;
    }

    public LoadAdRequest setExpired(boolean z) {
        this.isExpired = z;
        return this;
    }

    public void setHalfInterstitial(boolean z) {
        this.isHalfInterstitial = z;
    }

    public LoadAdRequest setLastCampid(String str) {
        this.last_campid = str;
        return this;
    }

    public LoadAdRequest setLastCrid(String str) {
        this.last_crid = str;
        return this;
    }

    public LoadAdRequest setLoadId(String str) {
        this.mLoadId = str;
        return this;
    }

    public void setOptions(Map<String, String> map) {
        if (this.mOptions == null) {
            this.mOptions = new HashMap();
        }
        this.mOptions.putAll(map);
    }

    public LoadAdRequest setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public LoadAdRequest setRequest_scene_type(int i) {
        this.request_scene_type = i;
        return this;
    }
}
