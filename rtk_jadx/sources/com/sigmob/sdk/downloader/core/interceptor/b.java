package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements c.b {
    private final InputStream a;
    private final byte[] b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.downloader.core.file.d f540c;
    private final int d;
    private final f e;
    private final com.sigmob.sdk.downloader.core.dispatcher.a f = g.j().b();

    public b(int i, InputStream inputStream, com.sigmob.sdk.downloader.core.file.d dVar, f fVar) {
        this.d = i;
        this.a = inputStream;
        this.b = new byte[fVar.o()];
        this.f540c = dVar;
        this.e = fVar;
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long b(com.sigmob.sdk.downloader.core.download.f fVar) {
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        g.j().g().b(fVar.c());
        int read = this.a.read(this.b);
        if (read == -1) {
            return read;
        }
        this.f540c.a(this.d, this.b, read);
        long j = read;
        fVar.b(j);
        if (this.f.a(this.e)) {
            fVar.j();
        }
        return j;
    }
}
