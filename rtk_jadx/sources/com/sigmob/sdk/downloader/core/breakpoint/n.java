package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.breakpoint.m;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class n {
    long a;
    private final m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m.a aVar) {
        this(new m(aVar));
    }

    n(m mVar) {
        this.b = mVar;
        this.a = 1500L;
    }

    void a() {
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return !this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.b.e(i);
        this.b.a(i, this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.b.e(i);
        try {
            if (this.b.a(i)) {
                return;
            }
            this.b.b(i);
        } finally {
            this.b.d(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        this.b.e(i);
        this.b.c(i);
    }
}
