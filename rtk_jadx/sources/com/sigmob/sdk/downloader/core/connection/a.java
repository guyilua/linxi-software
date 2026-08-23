package com.sigmob.sdk.downloader.core.connection;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface a {
    public static final int a = 0;

    /* renamed from: com.sigmob.sdk.downloader.core.connection.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0041a {
        String c(String str);

        int d();

        InputStream e();

        Map<String, List<String>> f();

        String g();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        a a(String str);
    }

    InterfaceC0041a a();

    void a(String str, String str2);

    boolean a(String str);

    String b(String str);

    void b();

    Map<String, List<String>> c();
}
