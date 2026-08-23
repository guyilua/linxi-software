package com.sigmob.sdk.downloader.core.file;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static final String a = "FileLock";
    private static final long d = TimeUnit.MILLISECONDS.toNanos(100);
    private final Map<String, AtomicInteger> b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Thread> f537c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        this(new HashMap(), new HashMap());
    }

    c(Map<String, AtomicInteger> map, Map<String, Thread> map2) {
        this.b = map;
        this.f537c = map2;
    }

    void a() {
        LockSupport.park(Long.valueOf(d));
    }

    public void a(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.b) {
                this.b.put(str, atomicInteger);
            }
        }
        com.sigmob.sdk.downloader.core.c.b(a, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
    }

    void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    boolean a(AtomicInteger atomicInteger) {
        return atomicInteger.get() <= 0;
    }

    public void b(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(a, "decreaseLock decrease lock-count to 0 " + str);
        synchronized (this.f537c) {
            thread = this.f537c.get(str);
            if (thread != null) {
                this.f537c.remove(str);
            }
        }
        if (thread != null) {
            com.sigmob.sdk.downloader.core.c.b(a, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.b) {
            this.b.remove(str);
        }
    }

    public void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.f537c) {
            this.f537c.put(str, Thread.currentThread());
        }
        com.sigmob.sdk.downloader.core.c.b(a, "waitForRelease start " + str);
        while (!a(atomicInteger)) {
            a();
        }
        com.sigmob.sdk.downloader.core.c.b(a, "waitForRelease finish " + str);
    }
}
