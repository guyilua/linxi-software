package com.sigmob.sdk.videocache;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q extends Exception {
    private static final String a = ". Version: 4.19.8";

    public q(String str) {
        super(str + a);
    }

    public q(String str, Throwable th) {
        super(str + a, th);
    }

    public q(Throwable th) {
        super("No explanation error. Version: 4.19.8", th);
    }
}
