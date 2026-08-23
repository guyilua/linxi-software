package com.ss.android.socialbase.downloader.i;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private a a;
    private a b;

    /* renamed from: c, reason: collision with root package name */
    private int f873c;
    private int d = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        long a;
        long b;

        /* renamed from: c, reason: collision with root package name */
        a f874c;
        a d;

        private a() {
        }
    }

    public boolean a(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j >= aVar.a && j2 >= aVar.b) {
                    a aVar2 = aVar.f874c;
                    if (aVar2 != null && j2 - aVar2.b < 1000) {
                        aVar.a = j;
                        aVar.b = j2;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j;
            a2.b = j2;
            if (aVar != null) {
                a2.f874c = aVar;
                aVar.d = a2;
            }
            this.a = a2;
            return true;
        }
    }

    public long b(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1L;
            }
            a a2 = a(j);
            if (a2 == null) {
                return -1L;
            }
            long j3 = aVar.a - a2.a;
            long j4 = j2 - a2.b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private a a() {
        a aVar;
        int i = this.f873c;
        if (i >= this.d && (aVar = this.b) != null) {
            a aVar2 = aVar.d;
            aVar.d = null;
            this.b = aVar2;
            if (aVar2 != null) {
                aVar2.f874c = null;
            }
            return aVar;
        }
        this.f873c = i + 1;
        return new a();
    }

    private a a(long j) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.b > j) {
            aVar2 = aVar;
            aVar = aVar.f874c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j - aVar.b >= aVar2.b - j) ? aVar2 : aVar;
    }
}
