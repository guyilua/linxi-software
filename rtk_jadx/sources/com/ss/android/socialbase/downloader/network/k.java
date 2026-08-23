package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    private static final String a = "k";
    private final d b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f909c;
    private final AtomicReference<l> d;
    private AtomicReference<l> e;
    private final ArrayList<Object> f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.network.k$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        public static final k a = new k(null);
    }

    /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        return a.a;
    }

    private boolean c() {
        if (this.b == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.a[this.d.get().ordinal()];
            double d = 2000.0d;
            double d2 = 550.0d;
            if (i == 1) {
                d2 = 0.0d;
                d = 150.0d;
            } else if (i == 2) {
                d = 550.0d;
                d2 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d = 3.4028234663852886E38d;
                d2 = 2000.0d;
            }
            double a2 = this.b.a();
            if (a2 > d) {
                if (a2 > d * 1.25d) {
                    return true;
                }
            } else if (a2 < d2 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void d() {
        try {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i);
                this.d.get();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        d dVar = this.b;
        if (dVar == null) {
            return l.UNKNOWN;
        }
        try {
            return a(dVar.a());
        } catch (Throwable th) {
            th.printStackTrace();
            return l.UNKNOWN;
        }
    }

    private k() {
        this.b = new d(0.05d);
        this.f909c = false;
        this.d = new AtomicReference<>(l.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.b.a(d);
            l b = b();
            if (this.f909c) {
                this.g++;
                if (b != this.e.get()) {
                    this.f909c = false;
                    this.g = 1;
                }
                if (this.g >= 5.0d && c()) {
                    this.f909c = false;
                    this.g = 1;
                    this.d.set(this.e.get());
                    d();
                }
                return;
            }
            if (this.d.get() != b) {
                this.f909c = true;
                this.e = new AtomicReference<>(b);
            }
        } catch (Throwable unused) {
        }
    }

    private l a(double d) {
        if (d < 0.0d) {
            return l.UNKNOWN;
        }
        if (d < 150.0d) {
            return l.POOR;
        }
        if (d < 550.0d) {
            return l.MODERATE;
        }
        if (d < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }
}
