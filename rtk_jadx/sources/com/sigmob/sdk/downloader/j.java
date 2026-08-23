package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.connection.a;
import java.net.ProtocolException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    public static final int a = 10;
    static final int b = 307;

    /* renamed from: c, reason: collision with root package name */
    static final int f552c = 308;

    public static String a(a.InterfaceC0041a interfaceC0041a, int i) {
        String c2 = interfaceC0041a.c("Location");
        if (c2 != null) {
            return c2;
        }
        throw new ProtocolException("Response code is " + i + " but can't find Location field");
    }

    public static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
