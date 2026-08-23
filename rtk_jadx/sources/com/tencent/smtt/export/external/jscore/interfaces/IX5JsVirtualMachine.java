package com.tencent.smtt.export.external.jscore.interfaces;

import android.os.Looper;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IX5JsVirtualMachine {
    IX5JsContext createJsContext();

    void destroy();

    Looper getLooper();

    void onPause();

    void onResume();
}
