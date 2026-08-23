package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.commonsdk.statistics.common.MLog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class StatTracer implements b {
    private static final String KEY_CLIENT_REQUEST_FAILED = "failed_requests ";
    private static final String KEY_CLIENT_REQUEST_LATENCY = "last_request_spent_ms";
    private static final String KEY_CLIENT_REQUEST_SUCCESS = "successful_request";
    private static final String KEY_CLIENT_REQUEST_TIME = "last_request_time";
    private static final String KEY_FIRST_ACTIVATE_TIME = "first_activate_time";
    private static final String KEY_LAST_REQ = "last_req";
    private static Context mContext;
    private final int MAX_REQUEST_LIMIT;
    private long firstActivateTime;
    private long lastRequestTime;
    public int mFailedRequest;
    private int mLastRequestLatency;
    public long mLastSuccessfulRequestTime;
    public int mSuccessfulRequest;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        public static final StatTracer a = new StatTracer();

        private a() {
        }
    }

    public static StatTracer getInstance(Context context) {
        if (mContext == null) {
            if (context != null) {
                mContext = context.getApplicationContext();
            } else {
                MLog.e("inside StatTracer. please check context. context must not be null!");
            }
        }
        return a.a;
    }

    private void init() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(mContext);
        this.mSuccessfulRequest = sharedPreferences.getInt(KEY_CLIENT_REQUEST_SUCCESS, 0);
        this.mFailedRequest = sharedPreferences.getInt(KEY_CLIENT_REQUEST_FAILED, 0);
        this.mLastRequestLatency = sharedPreferences.getInt(KEY_CLIENT_REQUEST_LATENCY, 0);
        this.mLastSuccessfulRequestTime = sharedPreferences.getLong(KEY_CLIENT_REQUEST_TIME, 0L);
        this.lastRequestTime = sharedPreferences.getLong(KEY_LAST_REQ, 0L);
    }

    public long getFirstActivateTime() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(mContext);
        long j = PreferenceWrapper.getDefault(mContext).getLong(KEY_FIRST_ACTIVATE_TIME, 0L);
        this.firstActivateTime = j;
        if (j == 0) {
            this.firstActivateTime = System.currentTimeMillis();
            sharedPreferences.edit().putLong(KEY_FIRST_ACTIVATE_TIME, this.firstActivateTime).commit();
        }
        return this.firstActivateTime;
    }

    public long getLastReqTime() {
        return this.lastRequestTime;
    }

    public int getLastRequestLatency() {
        int i = this.mLastRequestLatency;
        return i > 3600000 ? BaseConstants.Time.HOUR : i;
    }

    public boolean isFirstRequest() {
        return this.mLastSuccessfulRequestTime == 0;
    }

    public void logFailedRequest() {
        this.mFailedRequest++;
    }

    public void logRequestEnd() {
        this.mLastRequestLatency = (int) (System.currentTimeMillis() - this.lastRequestTime);
    }

    public void logRequestStart() {
        this.lastRequestTime = System.currentTimeMillis();
    }

    public void logSuccessfulRequest(boolean z) {
        this.mSuccessfulRequest++;
        if (z) {
            this.mLastSuccessfulRequestTime = this.lastRequestTime;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestEnd() {
        logRequestEnd();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestFailed() {
        logFailedRequest();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestStart() {
        logRequestStart();
    }

    @Override // com.umeng.commonsdk.statistics.internal.b
    public void onRequestSucceed(boolean z) {
        logSuccessfulRequest(z);
    }

    public void saveSate() {
        PreferenceWrapper.getDefault(mContext).edit().putInt(KEY_CLIENT_REQUEST_SUCCESS, this.mSuccessfulRequest).putInt(KEY_CLIENT_REQUEST_FAILED, this.mFailedRequest).putInt(KEY_CLIENT_REQUEST_LATENCY, this.mLastRequestLatency).putLong(KEY_LAST_REQ, this.lastRequestTime).putLong(KEY_CLIENT_REQUEST_TIME, this.mLastSuccessfulRequestTime).commit();
    }

    private StatTracer() {
        this.MAX_REQUEST_LIMIT = BaseConstants.Time.HOUR;
        this.lastRequestTime = 0L;
        this.firstActivateTime = 0L;
        init();
    }
}
