package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements c.a, c.b {
    private static final String a = "BreakpointInterceptor";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    static long a(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    long a(com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Content-Range"
            java.lang.String r0 = r7.c(r0)
            boolean r1 = com.sigmob.sdk.downloader.core.c.a(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            long r0 = a(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L1a
            r4 = 1
            long r0 = r0 + r4
            goto L1c
        L1a:
            r0 = -1
        L1c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L30
            java.lang.String r2 = "Content-Length"
            java.lang.String r7 = r7.c(r2)
            boolean r2 = com.sigmob.sdk.downloader.core.c.a(r7)
            if (r2 != 0) goto L30
            long r0 = java.lang.Long.parseLong(r7)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.interceptor.a.a(com.sigmob.sdk.downloader.core.connection.a$a):long");
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0041a a(f fVar) {
        a.InterfaceC0041a n = fVar.n();
        com.sigmob.sdk.downloader.core.breakpoint.c d = fVar.d();
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        if (d.g() == 1 && !d.b()) {
            long a2 = a(n);
            long j = d.j();
            if (a2 > 0 && a2 != j) {
                com.sigmob.sdk.downloader.core.c.b(a, "SingleBlock special check: the response instance-length[" + a2 + "] isn't equal to the instance length from trial-connection[" + j + "]");
                boolean z = d.b(0).c() != 0;
                com.sigmob.sdk.downloader.core.breakpoint.a aVar = new com.sigmob.sdk.downloader.core.breakpoint.a(0L, a2);
                d.f();
                d.a(aVar);
                if (z) {
                    com.sigmob.sdk.downloader.core.c.a(a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(fVar.c(), d, com.sigmob.sdk.downloader.core.cause.b.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (fVar.r().a(d)) {
                return n;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long b(f fVar) {
        long a2 = fVar.a();
        int e = fVar.e();
        boolean z = a2 != -1;
        long j = 0;
        com.sigmob.sdk.downloader.core.file.d g = fVar.g();
        while (true) {
            try {
                long p = fVar.p();
                if (p == -1) {
                    break;
                }
                j += p;
            } finally {
                fVar.j();
                if (!fVar.f().d()) {
                    g.a(e);
                }
            }
        }
        if (z) {
            g.b(e);
            if (j != a2) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j + "!= " + a2);
            }
        }
        return j;
    }
}
