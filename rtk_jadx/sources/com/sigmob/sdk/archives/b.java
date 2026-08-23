package com.sigmob.sdk.archives;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public b(String str) {
        super(str);
    }

    public b(String str, Exception exc) {
        super(str);
        initCause(exc);
    }
}
