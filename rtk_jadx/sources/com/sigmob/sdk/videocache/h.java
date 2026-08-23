package com.sigmob.sdk.videocache;

import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static final String a = "127.0.0.1";
    private final Object b;

    /* renamed from: c, reason: collision with root package name */
    private final ExecutorService f664c;
    private final Map<String, i> d;
    private final ServerSocket e;
    private final int f;
    private final Thread g;
    private final e h;
    private final n i;
    private InetAddress j;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class a {
        private static final long a = 536870912;
        private File b;
        private com.sigmob.sdk.videocache.sourcestorage.c e;
        private com.sigmob.sdk.videocache.file.a d = new com.sigmob.sdk.videocache.file.h(a);

        /* renamed from: c, reason: collision with root package name */
        private com.sigmob.sdk.videocache.file.c f665c = new com.sigmob.sdk.videocache.file.f();
        private com.sigmob.sdk.videocache.headers.b f = new com.sigmob.sdk.videocache.headers.a();

        public a(Context context) {
            this.e = com.sigmob.sdk.videocache.sourcestorage.d.a(context);
            this.b = w.a(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e b() {
            return new e(this.b, this.f665c, this.d, this.e, this.f);
        }

        public a a(int i) {
            this.d = new com.sigmob.sdk.videocache.file.g(i);
            return this;
        }

        public a a(long j) {
            this.d = new com.sigmob.sdk.videocache.file.h(j);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.file.a aVar) {
            this.d = (com.sigmob.sdk.videocache.file.a) o.a(aVar);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.file.c cVar) {
            this.f665c = (com.sigmob.sdk.videocache.file.c) o.a(cVar);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.headers.b bVar) {
            this.f = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
            return this;
        }

        public a a(File file) {
            this.b = (File) o.a(file);
            return this;
        }

        public h a() {
            return new h(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(this.b);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private final class c implements Runnable {
        private final CountDownLatch b;

        public c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.countDown();
            h.this.d();
        }
    }

    public h(Context context) {
        this(new a(context).b());
    }

    private h(e eVar) {
        this.b = new Object();
        this.f664c = ThreadPoolFactory.getFixIOExecutor();
        this.d = new ConcurrentHashMap();
        this.h = (e) o.a(eVar);
        try {
            this.j = InetAddress.getByName(a);
            ServerSocket serverSocket = new ServerSocket(0, 8, this.j);
            this.e = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f = localPort;
            k.a(a, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new c(countDownLatch));
            this.g = thread;
            thread.start();
            countDownLatch.await();
            this.i = new n(a, localPort);
            SigmobLog.i("Proxy cache server started. Is it alive? " + b());
        } catch (IOException | InterruptedException e) {
            this.f664c.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void a(File file) {
        try {
            this.h.f660c.a(file);
        } catch (IOException e) {
            SigmobLog.e("Error touching file " + file, e);
        }
    }

    private void a(Throwable th) {
        SigmobLog.e("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        StringBuilder sb;
        try {
            try {
                f a2 = f.a(socket.getInputStream());
                SigmobLog.d("Request to cache proxy:" + a2);
                String c2 = r.c(a2.a);
                if (this.i.a(c2)) {
                    this.i.a(socket);
                } else {
                    f(c2).a(a2, socket);
                }
                b(socket);
                sb = new StringBuilder();
            } catch (q e) {
                e = e;
                a(new q("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                SigmobLog.d("Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                a(new q("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(e());
            SigmobLog.d(sb.toString());
        } catch (Throwable th) {
            b(socket);
            SigmobLog.d("Opened connections: " + e());
            throw th;
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private boolean b() {
        return this.i.a(3, 70);
    }

    private void c() {
        synchronized (this.b) {
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.d.clear();
        }
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            SigmobLog.d("Releasing input stream… Socket is closed by client.");
        } catch (IOException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.f664c.submit(new b(this.e.accept()));
            } catch (IOException e) {
                a(new q("Error during waiting connection", e));
                return;
            }
        }
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    private int e() {
        int i;
        synchronized (this.b) {
            i = 0;
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                i += it.next().b();
            }
        }
        return i;
    }

    private String e(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", a, Integer.valueOf(this.f), r.b(str));
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException unused) {
        }
    }

    private i f(String str) {
        i iVar;
        synchronized (this.b) {
            iVar = this.d.get(str);
            if (iVar == null) {
                iVar = new i(str, this.h);
                this.d.put(str, iVar);
            }
        }
        return iVar;
    }

    public String a(String str) {
        return a(StringUtil.getUrl(str), true);
    }

    public String a(String str, boolean z) {
        if (!z || !b(str)) {
            return b() ? e(str) : str;
        }
        File c2 = c(str);
        a(c2);
        return Uri.fromFile(c2).toString();
    }

    public void a() {
        SigmobLog.i("Shutdown proxy server");
        c();
        this.h.d.a();
        this.g.interrupt();
        try {
            if (this.e.isClosed()) {
                return;
            }
            this.e.close();
        } catch (IOException e) {
            a(new q("Error shutting down proxy server", e));
        }
    }

    public void a(d dVar) {
        o.a(dVar);
        synchronized (this.b) {
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().b(dVar);
            }
        }
    }

    public void a(d dVar, String str) {
        o.a(dVar, str);
        synchronized (this.b) {
            try {
                f(str).a(dVar);
            } catch (q e) {
                SigmobLog.w("Error registering cache listener", e);
            }
        }
    }

    public void b(d dVar, String str) {
        o.a(dVar, str);
        synchronized (this.b) {
            try {
                f(str).b(dVar);
            } catch (q e) {
                SigmobLog.w("Error registering cache listener", e);
            }
        }
    }

    public boolean b(String str) {
        o.a(str, "Url can't be null!");
        return c(str).exists();
    }

    public File c(String str) {
        e eVar = this.h;
        return new File(eVar.a, eVar.b.a(str));
    }

    public void d(String str) {
        synchronized (this.b) {
            i iVar = this.d.get(str);
            if (iVar != null) {
                iVar.a();
            }
        }
    }
}
