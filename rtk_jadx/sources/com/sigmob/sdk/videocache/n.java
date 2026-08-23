package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    private static final String a = "ping";
    private static final String b = "ping ok";

    /* renamed from: c, reason: collision with root package name */
    private final ExecutorService f670c = Executors.newSingleThreadExecutor();
    private final String d;
    private final int e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(n.this.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, int i) {
        this.d = (String) o.a(str);
        this.e = i;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        u a2 = t.a(c());
        try {
            byte[] bytes = b.getBytes();
            a2.a(0L);
            byte[] bArr = new byte[bytes.length];
            a2.a(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            SigmobLog.i("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (q e) {
            SigmobLog.e("Error reading ping response", e);
            return false;
        } finally {
            a2.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.d, Integer.valueOf(this.e), a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(b.getBytes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2) {
        o.a(i >= 1);
        o.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                SigmobLog.w("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.f670c.submit(new a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        SigmobLog.e(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return a.equals(str);
    }
}
