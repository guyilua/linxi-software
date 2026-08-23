package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.i;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0041a {
    private static final String f = "DownloadUrlConnection";
    protected URLConnection b;

    /* renamed from: c, reason: collision with root package name */
    private a f512c;
    private URL d;
    private i e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private Proxy a;
        private Integer b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f513c;

        public a a(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public a a(Proxy proxy) {
            this.a = proxy;
            return this;
        }

        public a b(int i) {
            this.f513c = Integer.valueOf(i);
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements a.b {
        private final a a;

        public b() {
            this(null);
        }

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String str) {
            return new c(str, this.a);
        }

        com.sigmob.sdk.downloader.core.connection.a a(URL url) {
            return new c(url, this.a);
        }
    }

    /* renamed from: com.sigmob.sdk.downloader.core.connection.c$c, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static final class C0042c implements i {
        String a;

        C0042c() {
        }

        @Override // com.sigmob.sdk.downloader.i
        public String a() {
            return this.a;
        }

        @Override // com.sigmob.sdk.downloader.i
        public void a(com.sigmob.sdk.downloader.core.connection.a aVar, a.InterfaceC0041a interfaceC0041a, Map<String, List<String>> map) {
            c cVar = (c) aVar;
            int i = 0;
            for (int d = interfaceC0041a.d(); j.a(d); d = cVar.d()) {
                cVar.b();
                i++;
                if (i > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
                String a = j.a(interfaceC0041a, d);
                this.a = a;
                URI create = URI.create(a);
                if (create != null && !create.isAbsolute()) {
                    try {
                        this.a = ((c) aVar).d.toURI().resolve(create).toString();
                    } catch (Throwable unused) {
                    }
                }
                cVar.d = new URL(this.a);
                cVar.h();
                com.sigmob.sdk.downloader.core.c.b(map, cVar);
                cVar.b.connect();
            }
        }
    }

    public c(String str) {
        this(str, (a) null);
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) {
        this(url, aVar, new C0042c());
    }

    public c(URL url, a aVar, i iVar) {
        this.f512c = aVar;
        this.d = url;
        this.e = iVar;
        h();
    }

    c(URLConnection uRLConnection) {
        this(uRLConnection, new C0042c());
    }

    c(URLConnection uRLConnection, i iVar) {
        this.b = uRLConnection;
        this.d = uRLConnection.getURL();
        this.e = iVar;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0041a a() {
        Map<String, List<String>> c2 = c();
        this.b.connect();
        this.e.a(this, this, c2);
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String str, String str2) {
        this.b.addRequestProperty(str, str2);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String str) {
        URLConnection uRLConnection = this.b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String str) {
        return this.b.getRequestProperty(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void b() {
        try {
            InputStream inputStream = this.b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException | Exception unused) {
        }
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a
    public String c(String str) {
        return this.b.getHeaderField(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> c() {
        return this.b.getRequestProperties();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a
    public int d() {
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a
    public InputStream e() {
        return this.b.getInputStream();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a
    public Map<String, List<String>> f() {
        return this.b.getHeaderFields();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0041a
    public String g() {
        return this.e.a();
    }

    void h() {
        com.sigmob.sdk.downloader.core.c.b(f, "config connection for " + this.d);
        a aVar = this.f512c;
        this.b = (aVar == null || aVar.a == null) ? this.d.openConnection() : this.d.openConnection(this.f512c.a);
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        a aVar2 = this.f512c;
        if (aVar2 != null) {
            if (aVar2.b != null) {
                this.b.setReadTimeout(this.f512c.b.intValue());
            }
            if (this.f512c.f513c != null) {
                this.b.setConnectTimeout(this.f512c.f513c.intValue());
            }
        }
    }
}
