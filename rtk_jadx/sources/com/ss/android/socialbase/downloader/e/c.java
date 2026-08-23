package com.ss.android.socialbase.downloader.e;

import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements b {
    private final InputStream a;
    private final com.ss.android.socialbase.downloader.f.a b;

    public c(InputStream inputStream, int i) {
        this.a = inputStream;
        this.b = new com.ss.android.socialbase.downloader.f.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() {
        com.ss.android.socialbase.downloader.f.a aVar = this.b;
        aVar.f858c = this.a.read(aVar.a);
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        f.a(this.a);
    }
}
