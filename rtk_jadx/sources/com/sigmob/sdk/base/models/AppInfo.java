package com.sigmob.sdk.base.models;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppInfo {
    public final String appVersion;
    public final String os;
    public final String sdkVersion;

    public AppInfo(String str, String str2, String str3) {
        this.sdkVersion = str;
        this.appVersion = str2;
        this.os = str3;
    }

    public String toString() {
        return "appInfo={sdkVersion='" + this.sdkVersion + "', appVersion='" + this.appVersion + "', os='" + this.os + "'}";
    }
}
