package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class JsError {
    private final IX5JsError a;

    /* JADX INFO: Access modifiers changed from: protected */
    public JsError(IX5JsError iX5JsError) {
        this.a = iX5JsError;
    }

    public String getMessage() {
        return this.a.getMessage();
    }

    public String getStack() {
        return this.a.getStack();
    }
}
