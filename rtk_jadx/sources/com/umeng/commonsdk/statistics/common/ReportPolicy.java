package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.Defcon;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    static final int BATCH_AT_TERMINATE = 2;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int DAILY = 4;
    static final int IMMEDIATE = 3;
    public static final int QUASI_REALTIME_POLICY = 11;
    public static final int REALTIME = 0;
    public static final int SMART_POLICY = 8;
    public static final int WIFIONLY = 5;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DebugPolicy extends ReportStrategy {
        private final long ReportInterval = 15000;
        private StatTracer mTracer;

        public DebugPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= 15000;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DefconPolicy extends ReportStrategy {
        private Defcon defcon;
        private StatTracer tracer;

        public DefconPolicy(StatTracer statTracer, Defcon defcon) {
            this.tracer = statTracer;
            this.defcon = defcon;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return this.defcon.isOpen();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval();
        }

        public boolean shouldSendMessageByInstant() {
            return System.currentTimeMillis() - UMEnvelopeBuild.getLastInstantBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class LatentPolicy extends ReportStrategy {
        private long latency;
        private long start;

        public LatentPolicy(int i) {
            this.start = 0L;
            this.latency = i;
            this.start = System.currentTimeMillis();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return System.currentTimeMillis() - this.start < this.latency;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return System.currentTimeMillis() - this.start >= this.latency;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportAtLaunch extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return z;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportByInterval extends ReportStrategy {
        private static long MAX_REPORT_INTERVAL = 86400000;
        private static long MIN_REPORT_INTERVAL = 90000;
        private long mReportInterval;
        private StatTracer mTracer;

        public ReportByInterval(StatTracer statTracer, long j) {
            this.mTracer = statTracer;
            setReportInterval(j);
        }

        public static boolean isValidValue(int i) {
            return ((long) i) >= MIN_REPORT_INTERVAL;
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j) {
            long j2 = MIN_REPORT_INTERVAL;
            if (j >= j2 && j <= MAX_REPORT_INTERVAL) {
                this.mReportInterval = j;
            } else {
                this.mReportInterval = j2;
            }
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return z || System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.mReportInterval;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportDaily extends ReportStrategy {
        private long HOURS_DAY = 86400000;
        private StatTracer mTracer;

        public ReportDaily(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.HOURS_DAY;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportQuasiRealtime extends ReportStrategy {
        private static long DEFAULT_REPORT_INTERVAL = 15000;
        private static long MAX_REPORT_INTERVAL = 90000;
        private static long MIN_REPORT_INTERVAL = 3000;
        private long mReportInterval;

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j) {
            if (j >= MIN_REPORT_INTERVAL && j <= MAX_REPORT_INTERVAL) {
                this.mReportInterval = j;
            } else {
                this.mReportInterval = DEFAULT_REPORT_INTERVAL;
            }
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportRealtime extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportStrategy {
        public boolean isValid() {
            return true;
        }

        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ReportWifiOnly extends ReportStrategy {
        private Context mContext;

        public ReportWifiOnly(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return DeviceConfig.isWiFiAvailable(this.mContext);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class SmartPolicy extends ReportStrategy {
        private final long ReportInterval = 10800000;
        private StatTracer mTracer;

        public SmartPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= 10800000;
        }
    }

    public static boolean isValid(int i) {
        if (i != 8 && i != 11) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
