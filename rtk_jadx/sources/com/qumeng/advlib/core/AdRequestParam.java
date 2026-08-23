package com.qumeng.advlib.core;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.qumeng.advlib.core.IMultiAdObject;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdRequestParam {
    public static final int ADTYPE_AGGREGATE = 5;
    public static final int ADTYPE_BANNER = 1;
    public static final int ADTYPE_FEED = 3;
    public static final int ADTYPE_FLOAT_INDEX = 11;
    public static final int ADTYPE_H5_PAGE = 13;
    public static final int ADTYPE_INTERACTION = 2;
    public static final int ADTYPE_PUSH_DIALOG = 10;
    public static final int ADTYPE_REWARD_VIDEO = 4;
    public static final int ADTYPE_SPLASH = 6;
    public static final int ADTYPE_WITHDRAWAL_TASK = 14;
    private int adCount;
    private ADLoadListener adLoadListener;
    private ADRewardVideoListener adRewardVideoListener;
    private int adType;
    private ViewGroup adViewContainer;
    private String adm;
    private String adslotID;
    private int bannerHeight;
    private int bannerWidth;
    private String ctx;
    private int expectedPicHeight;
    private int expectedPicWidth;
    private Bundle extraBundle;
    private QLocation qLocation;

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADInteractionListener extends IMultiAdObject.ADEventListener {
        void onAdClose(Bundle bundle);
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADLoadListener {
        void onADLoaded(IMultiAdObject iMultiAdObject);

        void onAdFailed(String str);
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADRewardVideoListener {
        void onAdClick(Bundle bundle);

        void onAdClose(Bundle bundle);

        void onAdShow(Bundle bundle);

        void onReward(Bundle bundle);

        void onSkippedVideo(Bundle bundle);

        void onVideoComplete(Bundle bundle);

        void onVideoError(Bundle bundle);
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADWithdrawalTaskListener {
        void onAdClick(Bundle bundle);

        void onAdClose(Bundle bundle);

        void onAdShow(Bundle bundle);

        void onReward(Bundle bundle);

        void onTaskError(Bundle bundle);
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Builder {
        private ADLoadListener adLoadListener;
        private ADRewardVideoListener adRewardVideoListener;
        private ViewGroup adViewContainer;
        private String adm;
        private String adslotID;
        private int bannerHeight;
        private int bannerWidth;
        private String ctx;
        private int expectedPicHeight;
        private int expectedPicWidth;
        private Bundle extraBundle;
        private QLocation qLocation;
        private int adType = 1;
        private int adCount = 1;

        public Builder adCount(int i) {
            this.adCount = i;
            return this;
        }

        public Builder adLoadListener(ADLoadListener aDLoadListener) {
            this.adLoadListener = aDLoadListener;
            return this;
        }

        public Builder adRewardVideoListener(ADRewardVideoListener aDRewardVideoListener) {
            this.adRewardVideoListener = aDRewardVideoListener;
            return this;
        }

        public Builder adType(int i) {
            this.adType = i;
            return this;
        }

        public Builder adViewContainer(ViewGroup viewGroup) {
            this.adViewContainer = viewGroup;
            return this;
        }

        public Builder adslotID(String str) {
            this.adslotID = str;
            return this;
        }

        public Builder bannerSize(int i, int i2) {
            this.bannerWidth = i;
            this.bannerHeight = i2;
            return this;
        }

        public AdRequestParam build() {
            AdRequestParam adRequestParam = new AdRequestParam();
            adRequestParam.adslotID = this.adslotID;
            adRequestParam.adType = this.adType;
            adRequestParam.bannerHeight = this.bannerHeight;
            adRequestParam.bannerWidth = this.bannerWidth;
            adRequestParam.expectedPicHeight = this.expectedPicHeight;
            adRequestParam.expectedPicWidth = this.expectedPicWidth;
            adRequestParam.adCount = this.adCount;
            adRequestParam.extraBundle = this.extraBundle;
            adRequestParam.adViewContainer = this.adViewContainer;
            adRequestParam.ctx = this.ctx;
            adRequestParam.adm = this.adm;
            adRequestParam.adLoadListener = this.adLoadListener;
            adRequestParam.adRewardVideoListener = this.adRewardVideoListener;
            adRequestParam.qLocation = this.qLocation;
            return adRequestParam;
        }

        public Builder expectedPicSize(int i, int i2) {
            this.expectedPicWidth = i;
            this.expectedPicHeight = i2;
            return this;
        }

        public Builder extraBundle(Bundle bundle) {
            this.extraBundle = bundle;
            return this;
        }

        public Builder setAdm(String str) {
            this.adm = str;
            return this;
        }

        public Builder setCtx(String str) {
            this.ctx = str;
            return this;
        }

        public void setQLocation(QLocation qLocation) {
            this.qLocation = qLocation;
        }
    }

    public int getAdCount() {
        return this.adCount;
    }

    public ADLoadListener getAdLoadListener() {
        return this.adLoadListener;
    }

    public ADRewardVideoListener getAdRewardVideoListener() {
        return this.adRewardVideoListener;
    }

    public int getAdType() {
        return this.adType;
    }

    public ViewGroup getAdViewContainer() {
        return this.adViewContainer;
    }

    public String getAdm() {
        return this.adm;
    }

    public String getAdslotID() {
        return this.adslotID;
    }

    public int getBannerHeight() {
        return this.bannerHeight;
    }

    public int getBannerWidth() {
        return this.bannerWidth;
    }

    public String getCtx() {
        return this.ctx;
    }

    public int getExpectedPicHeight() {
        return this.expectedPicHeight;
    }

    public int getExpectedPicWidth() {
        return this.expectedPicWidth;
    }

    public Bundle getExtraBundle() {
        return this.extraBundle;
    }

    public void setExtraBundle(Bundle bundle) {
        this.extraBundle = bundle;
    }
}
