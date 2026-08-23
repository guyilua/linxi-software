package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends e {
    private final long a;

    public h(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.a = j;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    protected boolean a(File file, long j, int i) {
        return j <= this.a;
    }
}
