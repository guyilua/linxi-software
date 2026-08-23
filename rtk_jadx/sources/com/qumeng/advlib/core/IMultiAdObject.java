package com.qumeng.advlib.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qumeng.advlib.core.AdRequestParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class IMultiAdObject {
    public static final int INTERACTION_TYPE_DOWNLOAD = 2;
    public static final int INTERACTION_TYPE_LANDPAGE = 1;
    public static final int MATERIAL_TYPE_BIG_IMAGE = 2;
    public static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    public static final int MATERIAL_TYPE_INCITE_VIDEO = 12;
    public static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    public static final int MATERIAL_TYPE_SPLASH = 6;
    public static final int MATERIAL_TYPE_VIDEO_H = 4;
    public static final int MATERIAL_TYPE_VIDEO_V = 9;
    public static final int PUT_TYPE_DEFAULT = 0;
    public static final int PUT_TYPE_LIVE = 2;
    public static final int PUT_TYPE_NEW = 1;

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADEventListener {
        void onADExposed();

        void onAdClick();

        void onAdFailed(String str);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ADStateListener {
        void onAdEvent(int i, @NonNull Bundle bundle);
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface MediaStateListener {
        void onVideoCompleted();

        void onVideoPause();

        void onVideoReady();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop();
    }

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface SplashEventListener {
        void onObClicked();

        void onObShow();

        void onObSkip();

        void onObTimeOver();
    }

    public void bindEvent(ViewGroup viewGroup, List<View> list, ADEventListener aDEventListener) {
    }

    public void bindEvent(ViewGroup viewGroup, List<View> list, List<View> list2, ADEventListener aDEventListener) {
    }

    public void bindView(ViewGroup viewGroup, ADEventListener aDEventListener) {
    }

    public void closeInteractionAd() {
    }

    public void destroy() {
    }

    @Nullable
    public AppInformation getAppInformation() {
        return null;
    }

    public String getAppLogoUrl() {
        return "";
    }

    public String getAppName() {
        return "";
    }

    public String getAppPackageName() {
        return "";
    }

    public String getDesc() {
        return "";
    }

    public DownloadAdController getDownloadAdController() {
        return null;
    }

    public String getDownloadUrl() {
        return "";
    }

    public int getECPM() {
        return 0;
    }

    public Map<String, Object> getExtraInfo() {
        return null;
    }

    public List<String> getImageUrls() {
        return new ArrayList();
    }

    public int getInteractionType() {
        return 0;
    }

    public String getLandingPageUrl() {
        return "";
    }

    public int getMaterialType() {
        return 0;
    }

    public Pair<Integer, Integer> getMediaSize() {
        return null;
    }

    public int getPutType() {
        return 0;
    }

    public String getQMLogo() {
        return "";
    }

    public String getRequestId() {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public View getTwistView(Context context) {
        return null;
    }

    public String getVideoCoverImage() {
        return "";
    }

    public int getVideoDuration() {
        return 0;
    }

    public String getVideoUrl() {
        return "";
    }

    public View getVideoView(Context context) {
        return null;
    }

    public void lossNotice(int i, String str, String str2) {
    }

    public void setADStateListener(ADStateListener aDStateListener) {
    }

    public void setDownloadListener(IAppDownloadListener iAppDownloadListener) {
    }

    public void setOnMediaStateListener(MediaStateListener mediaStateListener) {
    }

    public void showInteractionAd(Activity activity, AdRequestParam.ADInteractionListener aDInteractionListener) {
    }

    public void showRewardVideo(Activity activity, AdRequestParam.ADRewardVideoListener aDRewardVideoListener) {
    }

    public void showSplashView(ViewGroup viewGroup, SplashEventListener splashEventListener) {
    }

    public void showWithdrawalTask(Activity activity, AdRequestParam.ADWithdrawalTaskListener aDWithdrawalTaskListener) {
    }

    public void winNotice(int i) {
    }
}
