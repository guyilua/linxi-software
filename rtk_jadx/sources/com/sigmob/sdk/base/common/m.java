package com.sigmob.sdk.base.common;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum m {
    CreativeTypeVideo_Tar(1),
    CreativeTypeImage(3),
    CreativeTypeVideo_Html_Snippet(4),
    CreativeTypeVideo_Tar_Companion(5),
    CreativeTypeVideo_transparent_html(6),
    CreativeTypeVideo_EndCardURL(7),
    CreativeTypeSplashVideo(8),
    CreativeTypeMRAID(9),
    CreativeTypeMRAIDTWO(10),
    CreativeTypeNewInterstitial(16);

    private int k;

    m(int i) {
        this.k = i;
    }

    public int a() {
        return this.k;
    }
}
