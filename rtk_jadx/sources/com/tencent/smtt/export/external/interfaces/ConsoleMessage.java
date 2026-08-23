package com.tencent.smtt.export.external.interfaces;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface ConsoleMessage {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
