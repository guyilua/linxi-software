package com.sigmob.sdk.downloader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.file.a;
import com.sigmob.sdk.downloader.core.file.b;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {

    @SuppressLint({"StaticFieldLeak"})
    static volatile g a;
    d b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.downloader.core.dispatcher.b f550c;
    private final com.sigmob.sdk.downloader.core.dispatcher.a d;
    private final com.sigmob.sdk.downloader.core.breakpoint.g e;
    private final a.b f;
    private final a.InterfaceC0044a g;
    private final com.sigmob.sdk.downloader.core.file.e h;
    private final com.sigmob.sdk.downloader.core.download.g i;
    private final Context j;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private com.sigmob.sdk.downloader.core.dispatcher.b a;
        private com.sigmob.sdk.downloader.core.dispatcher.a b;

        /* renamed from: c, reason: collision with root package name */
        private com.sigmob.sdk.downloader.core.breakpoint.j f551c;
        private a.b d;
        private com.sigmob.sdk.downloader.core.file.e e;
        private com.sigmob.sdk.downloader.core.download.g f;
        private a.InterfaceC0044a g;
        private d h;
        private final Context i;

        public a(Context context) {
            this.i = context.getApplicationContext();
        }

        public a a(com.sigmob.sdk.downloader.core.breakpoint.j jVar) {
            this.f551c = jVar;
            return this;
        }

        public a a(a.b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.a aVar) {
            this.b = aVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.b bVar) {
            this.a = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.download.g gVar) {
            this.f = gVar;
            return this;
        }

        public a a(a.InterfaceC0044a interfaceC0044a) {
            this.g = interfaceC0044a;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.file.e eVar) {
            this.e = eVar;
            return this;
        }

        public a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public g a() {
            if (this.a == null) {
                this.a = new com.sigmob.sdk.downloader.core.dispatcher.b();
            }
            if (this.b == null) {
                this.b = new com.sigmob.sdk.downloader.core.dispatcher.a();
            }
            if (this.f551c == null) {
                this.f551c = com.sigmob.sdk.downloader.core.c.a(this.i);
            }
            if (this.d == null) {
                this.d = com.sigmob.sdk.downloader.core.c.c();
            }
            if (this.g == null) {
                this.g = new b.a();
            }
            if (this.e == null) {
                this.e = new com.sigmob.sdk.downloader.core.file.e();
            }
            if (this.f == null) {
                this.f = new com.sigmob.sdk.downloader.core.download.g();
            }
            g gVar = new g(this.i, this.a, this.b, this.f551c, this.d, this.g, this.e, this.f);
            gVar.a(this.h);
            com.sigmob.sdk.downloader.core.c.b("FileDownload", "downloadStore[" + this.f551c + "] connectionFactory[" + this.d);
            return gVar;
        }
    }

    g(Context context, com.sigmob.sdk.downloader.core.dispatcher.b bVar, com.sigmob.sdk.downloader.core.dispatcher.a aVar, com.sigmob.sdk.downloader.core.breakpoint.j jVar, a.b bVar2, a.InterfaceC0044a interfaceC0044a, com.sigmob.sdk.downloader.core.file.e eVar, com.sigmob.sdk.downloader.core.download.g gVar) {
        this.j = context;
        this.f550c = bVar;
        this.d = aVar;
        this.e = jVar;
        this.f = bVar2;
        this.g = interfaceC0044a;
        this.h = eVar;
        this.i = gVar;
        bVar.a(com.sigmob.sdk.downloader.core.c.a(jVar));
    }

    public static void a(g gVar) {
        if (a != null) {
            throw new IllegalArgumentException("FileDownload must be null.");
        }
        synchronized (g.class) {
            if (a != null) {
                throw new IllegalArgumentException("FileDownload must be null.");
            }
            a = gVar;
        }
    }

    public static g j() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    if (com.sigmob.sdk.b.e() == null) {
                        throw new IllegalStateException("context == null");
                    }
                    a = new a(com.sigmob.sdk.b.e()).a();
                }
            }
        }
        return a;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.b a() {
        return this.f550c;
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.a b() {
        return this.d;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.g c() {
        return this.e;
    }

    public a.b d() {
        return this.f;
    }

    public a.InterfaceC0044a e() {
        return this.g;
    }

    public com.sigmob.sdk.downloader.core.file.e f() {
        return this.h;
    }

    public com.sigmob.sdk.downloader.core.download.g g() {
        return this.i;
    }

    public Context h() {
        return this.j;
    }

    public d i() {
        return this.b;
    }
}
