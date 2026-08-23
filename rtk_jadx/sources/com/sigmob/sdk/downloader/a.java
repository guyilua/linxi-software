package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.listener.f;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f491c = "DownloadContext";
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Serial", false));
    volatile boolean a;
    final com.sigmob.sdk.downloader.b b;
    private final f[] e;
    private final d f;
    private Handler g;

    /* renamed from: com.sigmob.sdk.downloader.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0040a {
        private final a a;

        C0040a(a aVar) {
            this.a = aVar;
        }

        public C0040a a(f fVar, f fVar2) {
            f[] fVarArr = this.a.e;
            for (int i = 0; i < fVarArr.length; i++) {
                if (fVarArr[i] == fVar) {
                    fVarArr[i] = fVar2;
                }
            }
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        final ArrayList<f> a;
        private final d b;

        /* renamed from: c, reason: collision with root package name */
        private com.sigmob.sdk.downloader.b f493c;

        public b() {
            this(new d());
        }

        public b(d dVar) {
            this(dVar, new ArrayList());
        }

        public b(d dVar, ArrayList<f> arrayList) {
            this.b = dVar;
            this.a = arrayList;
        }

        public b a(com.sigmob.sdk.downloader.b bVar) {
            this.f493c = bVar;
            return this;
        }

        public b a(f fVar) {
            int indexOf = this.a.indexOf(fVar);
            if (indexOf >= 0) {
                this.a.set(indexOf, fVar);
            } else {
                this.a.add(fVar);
            }
            return this;
        }

        public a a() {
            return new a((f[]) this.a.toArray(new f[this.a.size()]), this.f493c, this.b);
        }

        public f a(f.a aVar) {
            if (this.b.a != null) {
                aVar.a(this.b.a);
            }
            if (this.b.f495c != null) {
                aVar.d(this.b.f495c.intValue());
            }
            if (this.b.d != null) {
                aVar.e(this.b.d.intValue());
            }
            if (this.b.e != null) {
                aVar.f(this.b.e.intValue());
            }
            if (this.b.j != null) {
                aVar.d(this.b.j.booleanValue());
            }
            if (this.b.f != null) {
                aVar.g(this.b.f.intValue());
            }
            if (this.b.g != null) {
                aVar.b(this.b.g.booleanValue());
            }
            if (this.b.h != null) {
                aVar.b(this.b.h.intValue());
            }
            if (this.b.i != null) {
                aVar.c(this.b.i.booleanValue());
            }
            f a = aVar.a();
            if (this.b.k != null) {
                a.a(this.b.k);
            }
            this.a.add(a);
            return a;
        }

        public f a(String str) {
            if (this.b.b != null) {
                return a(new f.a(str, this.b.b).a(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public void a(int i) {
            for (f fVar : (List) this.a.clone()) {
                if (fVar.c() == i) {
                    this.a.remove(fVar);
                }
            }
        }

        public void b(f fVar) {
            this.a.remove(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends com.sigmob.sdk.downloader.core.listener.b {
        private final AtomicInteger a;
        private final com.sigmob.sdk.downloader.b b;

        /* renamed from: c, reason: collision with root package name */
        private final a f494c;

        c(a aVar, com.sigmob.sdk.downloader.b bVar, int i) {
            this.a = new AtomicInteger(i);
            this.b = bVar;
            this.f494c = aVar;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            int decrementAndGet = this.a.decrementAndGet();
            this.b.a(this.f494c, fVar, aVar, exc, decrementAndGet);
            if (decrementAndGet <= 0) {
                this.b.a(this.f494c);
                com.sigmob.sdk.downloader.core.c.b(a.f491c, "taskEnd and remainCount " + decrementAndGet);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(f fVar) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class d {
        private Map<String, List<String>> a;
        private Uri b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f495c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Boolean g;
        private Integer h;
        private Boolean i;
        private Boolean j;
        private Object k;

        public d a(int i) {
            this.f495c = Integer.valueOf(i);
            return this;
        }

        public d a(Uri uri) {
            this.b = uri;
            return this;
        }

        public d a(File file) {
            if (file.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.b = Uri.fromFile(file);
            return this;
        }

        public d a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public d a(Integer num) {
            this.h = num;
            return this;
        }

        public d a(Object obj) {
            this.k = obj;
            return this;
        }

        public d a(String str) {
            return a(new File(str));
        }

        public d a(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public Map<String, List<String>> a() {
            return this.a;
        }

        public void a(Map<String, List<String>> map) {
            this.a = map;
        }

        public Uri b() {
            return this.b;
        }

        public d b(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public d b(Boolean bool) {
            this.g = bool;
            return this;
        }

        public int c() {
            Integer num = this.f495c;
            return num == null ? f.a.f548c : num.intValue();
        }

        public d c(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public d d(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public boolean d() {
            Boolean bool = this.j;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public int e() {
            Integer num = this.d;
            return num == null ? f.a.d : num.intValue();
        }

        public int f() {
            Integer num = this.e;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.f;
            return num == null ? f.a.f : num.intValue();
        }

        public boolean h() {
            Boolean bool = this.g;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public int i() {
            Integer num = this.h;
            if (num == null) {
                return 1000;
            }
            return num.intValue();
        }

        public Object j() {
            return this.k;
        }

        public boolean k() {
            Boolean bool = this.i;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public b l() {
            return new b(this);
        }
    }

    a(f[] fVarArr, com.sigmob.sdk.downloader.b bVar, d dVar) {
        this.a = false;
        this.e = fVarArr;
        this.b = bVar;
        this.f = dVar;
    }

    a(f[] fVarArr, com.sigmob.sdk.downloader.b bVar, d dVar, Handler handler) {
        this(fVarArr, bVar, dVar);
        this.g = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.sigmob.sdk.downloader.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        if (!z) {
            bVar.a(this);
            return;
        }
        if (this.g == null) {
            this.g = new Handler(Looper.getMainLooper());
        }
        this.g.post(new Runnable() { // from class: com.sigmob.sdk.downloader.a.2
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.b.a(aVar);
            }
        });
    }

    public void a(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, true);
    }

    public void a(final com.sigmob.sdk.downloader.c cVar, boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        com.sigmob.sdk.downloader.core.c.b(f491c, "start " + z);
        this.a = true;
        if (this.b != null) {
            cVar = new f.a().a(cVar).a(new c(this, this.b, this.e.length)).a();
        }
        if (z) {
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.e);
            Collections.sort(arrayList);
            a(new Runnable() { // from class: com.sigmob.sdk.downloader.a.1
                @Override // java.lang.Runnable
                public void run() {
                    for (f fVar : arrayList) {
                        if (!a.this.a()) {
                            a.this.a(fVar.s());
                            return;
                        }
                        fVar.c(cVar);
                    }
                }
            });
        } else {
            f.a(this.e, cVar);
        }
        com.sigmob.sdk.downloader.core.c.b(f491c, "start finish " + z + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    void a(Runnable runnable) {
        d.execute(runnable);
    }

    public boolean a() {
        return this.a;
    }

    public void b(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, false);
    }

    public f[] b() {
        return this.e;
    }

    public C0040a c() {
        return new C0040a(this);
    }

    public void d() {
        if (this.a) {
            g.j().a().a((com.sigmob.sdk.downloader.core.a[]) this.e);
        }
        this.a = false;
    }

    public b e() {
        return new b(this.f, new ArrayList(Arrays.asList(this.e))).a(this.b);
    }
}
