package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements c.a, c.b {
    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0041a a(f fVar) {
        com.sigmob.sdk.downloader.core.download.d f = fVar.f();
        while (true) {
            try {
                if (f.k()) {
                    throw com.sigmob.sdk.downloader.core.exception.c.a;
                }
                return fVar.n();
            } catch (IOException e) {
                if (!(e instanceof g)) {
                    fVar.f().e(e);
                    fVar.g().d(fVar.e());
                    throw e;
                }
                fVar.l();
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long b(f fVar) {
        try {
            return fVar.o();
        } catch (IOException e) {
            fVar.f().e(e);
            throw e;
        }
    }
}
