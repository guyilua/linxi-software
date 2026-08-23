package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.ax;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum Gender implements ax {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);

    private final int value;

    Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        if (i == 0) {
            return MALE;
        }
        if (i == 1) {
            return FEMALE;
        }
        if (i != 2) {
            return null;
        }
        return UNKNOWN;
    }

    @Override // com.umeng.analytics.pro.ax
    public int getValue() {
        return this.value;
    }
}
