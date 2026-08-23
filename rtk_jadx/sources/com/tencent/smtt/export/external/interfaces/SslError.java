package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface SslError {
    boolean addError(int i);

    SslCertificate getCertificate();

    int getPrimaryError();

    String getUrl();

    boolean hasError(int i);
}
