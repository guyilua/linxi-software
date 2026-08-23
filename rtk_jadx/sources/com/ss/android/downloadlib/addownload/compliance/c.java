package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends com.ss.android.socialbase.downloader.i.h<Long, com.ss.android.downloadlib.addownload.b.b> {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static c a = new c();
    }

    public static c a() {
        return a.a;
    }

    private c() {
        super(16, 16);
    }

    public void a(com.ss.android.downloadlib.addownload.b.b bVar) {
        if (bVar == null) {
            return;
        }
        put(Long.valueOf(bVar.a()), bVar);
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j) {
        return get(Long.valueOf(j));
    }
}
