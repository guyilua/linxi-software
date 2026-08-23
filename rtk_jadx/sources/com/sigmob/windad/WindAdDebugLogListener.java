package com.sigmob.windad;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface WindAdDebugLogListener {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum WindAdLogLevel {
        WindLogLevelError,
        WindLogLevelWarning,
        WindLogLevelInformation,
        WindLogLevelDebug
    }

    void windAdDebugLog(String str, WindAdLogLevel windAdLogLevel);
}
