package com.ss.android.socialbase.downloader.exception;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends BaseException {
    private final long a;
    private final long b;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.a = j;
        this.b = j2;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
