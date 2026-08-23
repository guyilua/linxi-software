package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends IOException {
    public static final c a = new c() { // from class: com.sigmob.sdk.downloader.core.exception.c.1
        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    };

    private c() {
        super("Interrupted");
    }
}
