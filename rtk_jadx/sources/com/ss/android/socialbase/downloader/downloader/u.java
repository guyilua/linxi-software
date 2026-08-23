package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface u {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements u {
        @Override // com.ss.android.socialbase.downloader.downloader.u
        public com.ss.android.socialbase.downloader.exception.g a(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.u
        public boolean a() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.u
        public boolean a(Throwable th) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.u
        public IDownloadHttpService b() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.u
        public com.ss.android.socialbase.downloader.network.h c() {
            return null;
        }
    }

    com.ss.android.socialbase.downloader.exception.g a(Throwable th, String str);

    boolean a();

    boolean a(Throwable th);

    IDownloadHttpService b();

    com.ss.android.socialbase.downloader.network.h c();
}
