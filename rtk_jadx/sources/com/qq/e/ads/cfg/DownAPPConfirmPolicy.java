package com.qq.e.ads.cfg;

@Deprecated
/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);

    private final int a;

    DownAPPConfirmPolicy(int i) {
        this.a = i;
    }

    public int value() {
        return this.a;
    }
}
