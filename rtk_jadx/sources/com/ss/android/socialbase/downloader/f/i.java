package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class i {
    volatile m a;
    int b;

    /* renamed from: c, reason: collision with root package name */
    private final long f861c;
    private final AtomicLong d;
    private volatile long e;
    private long f;
    private int g;
    private JSONObject h;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.f861c = j;
        atomicLong.set(j);
        this.e = j;
        if (j2 >= j) {
            this.f = j2;
        } else {
            this.f = -1L;
        }
    }

    public long a() {
        return this.d.get() - this.f861c;
    }

    public long b() {
        long j = this.f;
        if (j >= this.f861c) {
            return (j - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f861c;
    }

    public long d() {
        long j = this.d.get();
        long j2 = this.f;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long d = mVar.d();
            if (d > this.e) {
                return d;
            }
        }
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.b++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.b--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.b;
    }

    public JSONObject k() {
        JSONObject jSONObject = this.h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put("cu", d());
        jSONObject.put("en", f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f861c + ",\t currentOffset=" + this.d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f + '}';
    }

    public void a(long j) {
        long j2 = this.f861c;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.d.set(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j) {
        if (j >= this.f861c) {
            this.f = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.d.addAndGet(j);
    }

    public void d(long j) {
        if (j >= this.d.get()) {
            this.e = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.g = i;
    }

    public static String a(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<i>() { // from class: com.ss.android.socialbase.downloader.f.i.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(i iVar, i iVar2) {
                return (int) (iVar.c() - iVar2.c());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.f861c = iVar.f861c;
        this.f = iVar.f;
        atomicLong.set(iVar.d.get());
        this.e = atomicLong.get();
        this.g = iVar.g;
    }

    public i(JSONObject jSONObject) {
        this.d = new AtomicLong();
        this.b = 0;
        this.f861c = jSONObject.optLong("st");
        c(jSONObject.optLong("en"));
        a(jSONObject.optLong("cu"));
        d(d());
    }
}
