package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class c extends a {

    /* renamed from: com.sigmob.sdk.downloader.core.listener.c$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.sigmob.sdk.downloader.core.cause.a.values().length];
            a = iArr;
            try {
                iArr[com.sigmob.sdk.downloader.core.cause.a.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.sigmob.sdk.downloader.core.cause.a.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.sigmob.sdk.downloader.core.cause.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.sigmob.sdk.downloader.core.cause.a.PRE_ALLOCATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected abstract void a(com.sigmob.sdk.downloader.f fVar);

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, a.b bVar) {
        switch (AnonymousClass1.a[aVar.ordinal()]) {
            case 1:
                a(fVar);
                return;
            case 2:
                c(fVar);
                return;
            case 3:
            case 4:
                a(fVar, exc);
                return;
            case 5:
            case 6:
                d(fVar);
                return;
            default:
                com.sigmob.sdk.downloader.core.c.a("DownloadListener3", "Don't support " + aVar);
                return;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0045a
    public final void a(com.sigmob.sdk.downloader.f fVar, a.b bVar) {
        b(fVar);
    }

    protected abstract void a(com.sigmob.sdk.downloader.f fVar, Exception exc);

    protected abstract void b(com.sigmob.sdk.downloader.f fVar);

    protected abstract void c(com.sigmob.sdk.downloader.f fVar);

    protected abstract void d(com.sigmob.sdk.downloader.f fVar);
}
