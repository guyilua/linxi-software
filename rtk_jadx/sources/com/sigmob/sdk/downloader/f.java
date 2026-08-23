package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.util.SparseArray;
import com.sigmob.sdk.base.common.aj;
import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends com.sigmob.sdk.downloader.core.a implements Comparable<f> {
    private static final int a = 3;
    private final File A;
    private final File B;
    private File C;
    private String D;
    private File E;
    private int F;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f547c;
    private final String d;
    private final Uri e;
    private final Map<String, List<String>> h;
    private com.sigmob.sdk.downloader.core.breakpoint.c i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final Integer o;
    private final Boolean p;
    private final boolean q;
    private final boolean r;
    private final int s;
    private volatile com.sigmob.sdk.downloader.c t;
    private volatile SparseArray<Object> u;
    private Object v;
    private final boolean w;
    private final AtomicLong x = new AtomicLong();
    private final boolean y;
    private final g.a z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final int f548c = 4096;
        public static final int d = 16384;
        public static final int e = 65536;
        public static final int f = 2000;
        public static final boolean g = true;
        public static final int h = 1000;
        public static final boolean i = true;
        public static final boolean j = false;
        final String a;
        final Uri b;
        private volatile Map<String, List<String>> k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private boolean q;
        private int r;
        private String s;
        private boolean t;
        private boolean u;
        private Boolean v;
        private Integer w;
        private Boolean x;

        public a(String str, Uri uri) {
            this.m = f548c;
            this.n = d;
            this.o = 65536;
            this.p = f;
            this.q = true;
            this.r = 1000;
            this.t = true;
            this.u = false;
            this.a = str;
            this.b = uri;
            if (com.sigmob.sdk.downloader.core.c.a(uri)) {
                this.s = com.sigmob.sdk.downloader.core.c.c(uri);
            }
        }

        public a(String str, File file) {
            this.m = f548c;
            this.n = d;
            this.o = 65536;
            this.p = f;
            this.q = true;
            this.r = 1000;
            this.t = true;
            this.u = false;
            this.a = str;
            this.b = Uri.fromFile(file);
        }

        public a(String str, String str2, String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str3)) {
                this.v = Boolean.TRUE;
            } else {
                this.s = str3;
            }
        }

        public a a(int i2) {
            this.w = Integer.valueOf(i2);
            return this;
        }

        public a a(Boolean bool) {
            if (!com.sigmob.sdk.downloader.core.c.b(this.b)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.v = bool;
            return this;
        }

        public a a(String str) {
            this.s = str;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.k = map;
            return this;
        }

        public a a(boolean z) {
            this.x = Boolean.valueOf(z);
            return this;
        }

        public f a() {
            return new f(this.a, this.b, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.k, this.s, this.t, this.u, this.v, this.w, this.x);
        }

        public synchronized void a(String str, String str2) {
            if (this.k == null) {
                this.k = new HashMap();
            }
            List<String> list = this.k.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.k.put(str, list);
            }
            list.add(str2);
        }

        public a b(int i2) {
            this.r = i2;
            return this;
        }

        public a b(boolean z) {
            this.q = z;
            return this;
        }

        public a c(int i2) {
            this.l = i2;
            return this;
        }

        public a c(boolean z) {
            this.t = z;
            return this;
        }

        public a d(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.m = i2;
            return this;
        }

        public a d(boolean z) {
            this.u = z;
            return this;
        }

        public a e(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.n = i2;
            return this;
        }

        public a f(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.o = i2;
            return this;
        }

        public a g(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.p = i2;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b extends com.sigmob.sdk.downloader.core.a {
        final int a;
        final String b;

        /* renamed from: c, reason: collision with root package name */
        final File f549c;
        final String d;
        final File e;

        public b(int i) {
            this.a = i;
            this.b = "";
            File file = com.sigmob.sdk.downloader.core.a.g;
            this.f549c = file;
            this.d = null;
            this.e = file;
        }

        public b(int i, f fVar) {
            this.a = i;
            this.b = fVar.d;
            this.e = fVar.l();
            this.f549c = fVar.A;
            this.d = fVar.d();
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public int c() {
            return this.a;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String d() {
            return this.d;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String i() {
            return this.b;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        protected File k() {
            return this.f549c;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public File l() {
            return this.e;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c {
        public static long a(f fVar) {
            return fVar.z();
        }

        public static void a(f fVar, long j) {
            fVar.a(j);
        }

        public static void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            fVar.a(cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0117, code lost:
    
        if (com.sigmob.sdk.downloader.core.c.a((java.lang.CharSequence) r16) != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(java.lang.String r6, android.net.Uri r7, int r8, int r9, int r10, int r11, int r12, boolean r13, int r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15, java.lang.String r16, boolean r17, boolean r18, java.lang.Boolean r19, java.lang.Integer r20, java.lang.Boolean r21) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.f.<init>(java.lang.String, android.net.Uri, int, int, int, int, int, boolean, int, java.util.Map, java.lang.String, boolean, boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean):void");
    }

    public static void a(f[] fVarArr) {
        g.j().a().a((com.sigmob.sdk.downloader.core.a[]) fVarArr);
    }

    public static void a(f[] fVarArr, com.sigmob.sdk.downloader.c cVar) {
        for (f fVar : fVarArr) {
            fVar.t = cVar;
        }
        g.j().a().a(fVarArr);
    }

    public static b c(int i) {
        return new b(i);
    }

    public synchronized void A() {
        this.v = null;
    }

    public void B() {
        if (System.currentTimeMillis() - this.f547c < 500) {
            aj.a(com.sigmob.sdk.b.e(), "操作太频繁", 0).show();
        } else {
            this.f547c = System.currentTimeMillis();
            g.j().a().a(this);
        }
    }

    public boolean C() {
        int i = this.F;
        this.F = i + 1;
        if (i >= 3) {
            return false;
        }
        g.j().a().a(this);
        return true;
    }

    public void D() {
        g.j().a().b(this);
    }

    public void E() {
        if (System.currentTimeMillis() - this.f547c < 500) {
            aj.a(com.sigmob.sdk.b.e(), "操作太频繁", 0).show();
        } else {
            this.f547c = System.currentTimeMillis();
            g.j().a().a((com.sigmob.sdk.downloader.core.a) this);
        }
    }

    public com.sigmob.sdk.downloader.c F() {
        return this.t;
    }

    public int G() {
        return this.j;
    }

    public a H() {
        return a(this.d, this.e);
    }

    public a a(String str, Uri uri) {
        a c2 = new a(str, uri).c(this.j).d(this.k).e(this.l).f(this.m).g(this.n).b(this.r).b(this.s).a(this.h).c(this.q);
        if (com.sigmob.sdk.downloader.core.c.b(uri) && !new File(uri.getPath()).isFile() && com.sigmob.sdk.downloader.core.c.b(this.e) && this.z.a() != null && !new File(this.e.getPath()).getName().equals(this.z.a())) {
            c2.a(this.z.a());
        }
        return c2;
    }

    public synchronized f a(int i, Object obj) {
        if (this.u == null) {
            synchronized (this) {
                if (this.u == null) {
                    this.u = new SparseArray<>();
                }
            }
        }
        this.u.put(i, obj);
        return this;
    }

    public Object a(int i) {
        if (this.u == null) {
            return null;
        }
        return this.u.get(i);
    }

    void a(long j) {
        this.x.set(j);
    }

    public void a(com.sigmob.sdk.downloader.c cVar) {
        this.t = cVar;
    }

    void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.i = cVar;
    }

    public void a(f fVar) {
        this.v = fVar.v;
        this.u = fVar.u;
    }

    public void a(Object obj) {
        this.v = obj;
    }

    public void a(String str) {
        this.D = str;
    }

    public boolean a() {
        return this.y;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return fVar.G() - G();
    }

    public Map<String, List<String>> b() {
        return this.h;
    }

    public synchronized void b(int i) {
        if (this.u != null) {
            this.u.remove(i);
        }
    }

    public void b(com.sigmob.sdk.downloader.c cVar) {
        this.t = cVar;
        g.j().a().a(this);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public int c() {
        return this.b;
    }

    public void c(com.sigmob.sdk.downloader.c cVar) {
        this.t = cVar;
        g.j().a().b(this);
    }

    public b d(int i) {
        return new b(i, this);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String d() {
        return this.z.a() + ".tmp";
    }

    public boolean e() {
        return this.q;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.b == this.b) {
            return true;
        }
        return a((com.sigmob.sdk.downloader.core.a) fVar);
    }

    public boolean f() {
        return this.w;
    }

    public g.a g() {
        return this.z;
    }

    public Uri h() {
        return this.e;
    }

    public int hashCode() {
        return (this.d + this.A.toString() + this.z.a()).hashCode();
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String i() {
        return this.d;
    }

    public String j() {
        return this.D;
    }

    @Override // com.sigmob.sdk.downloader.core.a
    protected File k() {
        return this.A;
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public File l() {
        return this.B;
    }

    public File m() {
        String str = this.z.a() + ".tmp";
        if (str == null) {
            return null;
        }
        if (this.E == null) {
            this.E = new File(this.B, str);
        }
        return this.E;
    }

    public File n() {
        String a2 = this.z.a();
        if (a2 == null) {
            return null;
        }
        if (this.C == null) {
            this.C = new File(this.B, a2);
        }
        return this.C;
    }

    public int o() {
        return this.k;
    }

    public int p() {
        return this.l;
    }

    public int q() {
        return this.m;
    }

    public int r() {
        return this.n;
    }

    public boolean s() {
        return this.r;
    }

    public int t() {
        return this.s;
    }

    public String toString() {
        return super.toString() + "@" + this.b + "@" + this.d + "@" + this.B.toString() + "/" + this.z.a();
    }

    public Integer u() {
        return this.o;
    }

    public Boolean v() {
        return this.p;
    }

    public int w() {
        com.sigmob.sdk.downloader.core.breakpoint.c cVar = this.i;
        if (cVar == null) {
            return 0;
        }
        return cVar.g();
    }

    public Object x() {
        return this.v;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c y() {
        if (this.i == null) {
            this.i = g.j().c().a(this.b);
        }
        return this.i;
    }

    long z() {
        return this.x.get();
    }
}
