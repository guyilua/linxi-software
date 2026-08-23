package com.ss.android.socialbase.downloader.constants;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloadStatus {
    public static final int CANCELED = -4;
    public static final int CONNECTED = 3;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int FIRST_START = 6;
    public static final int FIRST_SUCCESS = -6;
    public static final int IDLE_STATUS = 0;
    public static final int INTERCEPT = -7;
    public static final int PAUSED = -2;
    public static final int PAUSED_BY_DB_INIT = -5;
    public static final int PREPARE = 1;
    public static final int PROGRESS = 4;
    public static final int RETRY = 5;
    public static final int RETRY_DELAY = 7;
    public static final int SINGLE_CHUNK_DELAY_RETRY = 10;
    public static final int SINGLE_CHUNK_RETRY = 9;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int WAITING_ASYNC_HANDLER = 8;

    public static boolean isDownloadOver(int i) {
        return (i >= 0 || i == -2 || i == -5) ? false : true;
    }

    public static boolean isDownloading(int i) {
        return (i <= 0 || i == 7 || i == 8 || i == 10) ? false : true;
    }

    public static boolean isFailedStatus(int i) {
        return i == -1 || i == -7;
    }

    public static boolean isMonitorStatus(int i) {
        return i == 2 || i == -3 || i == -1 || i == -4 || i == -2 || i == 6 || i == 0;
    }

    public static boolean isRealTimeUploadStatus(int i) {
        return i == -3 || i == -1 || i == -4 || i == -2 || i == 5 || i == 7 || i == 8;
    }

    public static boolean isTimeUploadStatus(int i) {
        return i == -3 || i == -1 || i == -4;
    }

    public static boolean isUnCompletedStatus(int i) {
        return i == -1 || i == -2 || i == -7 || i == -4 || i == -5;
    }
}
