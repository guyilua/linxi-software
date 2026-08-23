package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends IOException {
    private final com.sigmob.sdk.downloader.core.cause.b a;

    public f(com.sigmob.sdk.downloader.core.cause.b bVar) {
        super("Resume failed because of " + bVar);
        this.a = bVar;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.a;
    }
}
