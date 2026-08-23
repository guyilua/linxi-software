package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.d;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface DownloadModel {
    boolean autoInstallWithoutNotification();

    boolean distinctDir();

    boolean enablePause();

    void forceHideNotification();

    void forceHideToast();

    void forceWifi();

    String getAppIcon();

    List<String> getBackupUrls();

    List<String> getClickTrackUrl();

    DeepLink getDeepLink();

    IDownloadFileUriProvider getDownloadFileUriProvider();

    JSONObject getDownloadSettings();

    String getDownloadUrl();

    int getExecutorGroup();

    long getExpectFileLength();

    JSONObject getExtra();

    long getExtraValue();

    String getFileName();

    String getFilePath();

    int getFunnelType();

    Map<String, String> getHeaders();

    long getId();

    String getLogExtra();

    String getMd5();

    String getMimeType();

    int getModelType();

    String getName();

    String getNotificationJumpUrl();

    String getPackageName();

    d getQuickAppModel();

    String getSdkMonitorScene();

    String getStartToast();

    int getVersionCode();

    String getVersionName();

    boolean isAd();

    boolean isAutoInstall();

    boolean isInExternalPublicDir();

    boolean isNeedWifi();

    boolean isShowNotification();

    boolean isShowToast();

    boolean isVisibleInDownloadsUi();

    boolean needIndependentProcess();

    DownloadModel setFilePath(String str);

    boolean shouldDownloadWithPatchApply();
}
