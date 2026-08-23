package com.tencent.smtt.export.external.interfaces;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getQuicDetailedErrorCode();
}
