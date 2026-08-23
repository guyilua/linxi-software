package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i extends IOException {
    private final int a;

    public i(int i, long j) {
        super("Response code can't handled on internal " + i + " with current offset " + j);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
