package com.sigmob.sdk.videocache;

import java.util.Objects;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class o {
    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T a(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
        }
    }
}
