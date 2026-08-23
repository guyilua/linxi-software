package com.sigmob.sdk.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class i {
    private static final int a = 1;
    private static final int b = 2;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f666c = new AtomicInteger(0);
    private final String d;
    private volatile g e;
    private final List<d> f;
    private final d g;
    private final e h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class a extends Handler implements d {
        private final String a;
        private final List<d> b;

        public a(String str, List<d> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.b = list;
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            obtainMessage.what = 1;
            sendMessage(obtainMessage);
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(String str, Throwable th) {
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = th;
            obtainMessage.what = 2;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (d dVar : this.b) {
                int i = message.what;
                if (i == 1) {
                    dVar.a((File) message.obj, this.a, message.arg1);
                } else if (i == 2) {
                    dVar.a(this.a, (Throwable) message.obj);
                }
            }
        }
    }

    public i(String str, e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f = copyOnWriteArrayList;
        this.d = (String) o.a(str);
        this.h = (e) o.a(eVar);
        this.g = new a(str, copyOnWriteArrayList);
    }

    private synchronized void c() {
        this.e = this.e == null ? e() : this.e;
    }

    private synchronized void d() {
        if (this.f666c.decrementAndGet() <= 0) {
            this.e.a();
            this.e = null;
        }
    }

    private g e() {
        String str = this.d;
        e eVar = this.h;
        g gVar = new g(t.a(str, eVar.d, eVar.e), new com.sigmob.sdk.videocache.file.b(this.h.a(this.d), this.h.f660c));
        gVar.a(this.g);
        return gVar;
    }

    public void a() {
        this.f.clear();
        if (this.e != null) {
            this.e.a((d) null);
            this.e.a();
            this.e = null;
        }
        this.f666c.set(0);
    }

    public void a(d dVar) {
        this.f.add(dVar);
    }

    public void a(f fVar, Socket socket) {
        c();
        try {
            this.f666c.incrementAndGet();
            this.e.a(fVar, socket);
        } finally {
            try {
            } finally {
            }
        }
    }

    public int b() {
        return this.f666c.get();
    }

    public void b(d dVar) {
        this.f.remove(dVar);
    }
}
