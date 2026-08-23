package com.sigmob.sdk.videoAd;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum m {
    START("start"),
    FIRST_QUARTILE("firstQuartile"),
    MIDPOINT("midpoint"),
    THIRD_QUARTILE("thirdQuartile"),
    COMPLETE("complete"),
    COMPANION_AD_VIEW("companionAdView"),
    COMPANION_AD_CLICK("companionAdClick"),
    FINISH("finish"),
    SHOW("show"),
    CLICK("click"),
    UNKNOWN("");

    private final String l;

    m(String str) {
        this.l = str;
    }

    public static m a(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        for (m mVar : values()) {
            if (str.equals(mVar.a())) {
                return mVar;
            }
        }
        return UNKNOWN;
    }

    private String a() {
        return this.l;
    }
}
