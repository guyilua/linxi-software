package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends IOException {
    private final long a;
    private final long b;

    public e(long j, long j2) {
        super("There is Free space less than Require space: " + j2 + " < " + j);
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
