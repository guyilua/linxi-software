package com.qq.e.comm.util;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdError {
    private int a;
    private String b;

    public AdError() {
    }

    public AdError(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.b;
    }
}
