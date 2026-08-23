package com.sigmob.sdk.downloader.core;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class b implements Runnable {
    protected final String a;

    public b(String str) {
        this.a = str;
    }

    protected abstract void a();

    protected abstract void a(InterruptedException interruptedException);

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            try {
                a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                a(e);
            }
        } finally {
            Thread.currentThread().setName(name);
            b();
        }
    }
}
