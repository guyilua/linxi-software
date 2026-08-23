package com.sigmob.sdk.downloader.core.interceptor.connect;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements c.a {
    private static final String a = "HeaderInterceptor";

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0041a a(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.c d = fVar.d();
        com.sigmob.sdk.downloader.core.connection.a i = fVar.i();
        com.sigmob.sdk.downloader.f c2 = fVar.c();
        Map<String, List<String>> b = c2.b();
        if (b != null) {
            com.sigmob.sdk.downloader.core.c.a(b, i);
        }
        if (b == null || !b.containsKey(com.sigmob.sdk.downloader.core.c.d)) {
            com.sigmob.sdk.downloader.core.c.a(i);
        }
        int e = fVar.e();
        com.sigmob.sdk.downloader.core.breakpoint.a b2 = d.b(e);
        if (b2 == null) {
            throw new IOException("No block-info found on " + e);
        }
        String str = "bytes=" + b2.c() + "-";
        if (!d.b()) {
            str = str + b2.e();
        }
        i.a(com.sigmob.sdk.downloader.core.c.b, str);
        com.sigmob.sdk.downloader.core.c.b(a, "AssembleHeaderRange (" + c2.c() + ") block(" + e + ") downloadFrom(" + b2.c() + ") currentOffset(" + b2.a() + ")");
        String k = d.k();
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) k)) {
            i.a(com.sigmob.sdk.downloader.core.c.f508c, k);
        }
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        g.j().b().a().b(c2, e, i.c());
        a.InterfaceC0041a n = fVar.n();
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        Map<String, List<String>> f = n.f();
        if (f == null) {
            f = new HashMap<>();
        }
        g.j().b().a().a(c2, e, n.d(), f);
        g.j().g().a(n, e, d).a();
        String c3 = n.c(com.sigmob.sdk.downloader.core.c.e);
        fVar.a((c3 == null || c3.length() == 0) ? com.sigmob.sdk.downloader.core.c.d(n.c(com.sigmob.sdk.downloader.core.c.f)) : com.sigmob.sdk.downloader.core.c.b(c3));
        return n;
    }
}
