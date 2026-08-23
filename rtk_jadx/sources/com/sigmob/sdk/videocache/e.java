package com.sigmob.sdk.videocache;

import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    public final File a;
    public final com.sigmob.sdk.videocache.file.c b;

    /* renamed from: c, reason: collision with root package name */
    public final com.sigmob.sdk.videocache.file.a f660c;
    public final com.sigmob.sdk.videocache.sourcestorage.c d;
    public final com.sigmob.sdk.videocache.headers.b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(File file, com.sigmob.sdk.videocache.file.c cVar, com.sigmob.sdk.videocache.file.a aVar, com.sigmob.sdk.videocache.sourcestorage.c cVar2, com.sigmob.sdk.videocache.headers.b bVar) {
        this.a = file;
        this.b = cVar;
        this.f660c = aVar;
        this.d = cVar2;
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.a, this.b.a(str));
    }
}
