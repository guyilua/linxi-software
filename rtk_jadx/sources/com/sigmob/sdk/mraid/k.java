package com.sigmob.sdk.mraid;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum k {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);

    private final int d;

    k(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }
}
