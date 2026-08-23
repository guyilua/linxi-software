package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.qq.e.comm.constants.ErrorCode;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j implements u {
    private static final int a = 5;
    private final com.sigmob.sdk.videocache.sourcestorage.c b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.videocache.headers.b f667c;
    private v d;
    private HttpURLConnection e;
    private InputStream f;

    public j(u uVar) {
        this.d = uVar.d();
        this.b = uVar.e();
        this.f667c = uVar.f();
    }

    public j(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.b = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.f667c = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v a2 = cVar.a(str);
        this.d = a2 == null ? new v(str, -2147483648L, r.a(str)) : a2;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.e);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a2 = a(httpURLConnection);
        return i == 200 ? a2 : i == 206 ? a2 + j : this.d.b;
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        boolean z;
        String str2 = this.d.a;
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null && j > 0 && httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            this.e = null;
            r.a(this.f);
        }
        if (this.e == null) {
            int i2 = 0;
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Open connection ");
                if (j > 0) {
                    str = " with offset " + j;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" to ");
                sb.append(str2);
                SigmobLog.d(sb.toString());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                this.e = httpURLConnection2;
                a(httpURLConnection2, str2);
                if (j > 0) {
                    this.e.setRequestProperty(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
                }
                if (i > 0) {
                    this.e.setConnectTimeout(i);
                    this.e.setReadTimeout(i);
                }
                int responseCode = this.e.getResponseCode();
                z = responseCode == 301 || responseCode == 302 || responseCode == 303;
                if (z) {
                    String headerField = this.e.getHeaderField("Location");
                    URI create = URI.create(headerField);
                    if (create != null && !create.isAbsolute()) {
                        try {
                            URI create2 = URI.create(str2);
                            if (create2 != null) {
                                headerField = create2.resolve(create).toString();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    i2++;
                    this.e.disconnect();
                    str2 = headerField;
                }
                if (i2 > 5) {
                    throw new q("Too many redirects: " + i2);
                }
            } while (z);
        }
        return this.e;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f667c.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void h() {
        SigmobLog.d("Read content info from " + this.d.a);
        try {
            HttpURLConnection a2 = a(0L, ErrorCode.NETWORK_UNKNOWN);
            v vVar = new v(this.d.a, a(a2), a2.getContentType());
            this.d = vVar;
            this.b.a(vVar.a, vVar);
            SigmobLog.d("Source info fetched: " + this.d);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.d.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        InputStream inputStream = this.f;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.d.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new l("Reading source " + this.d.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.d.a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized long a() {
        if (this.d.b == -2147483648L) {
            h();
        }
        return this.d.b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        try {
            HttpURLConnection a2 = a(j, ErrorCode.NETWORK_UNKNOWN);
            this.e = a2;
            String contentType = a2.getContentType();
            this.f = new BufferedInputStream(this.e.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.e;
            v vVar = new v(this.d.a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.d = vVar;
            this.b.a(vVar.a, vVar);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.d.a + " with offset " + j, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() {
        if (TextUtils.isEmpty(this.d.f674c)) {
            h();
        }
        return this.d.f674c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.d;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.f667c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.d.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.d + "}";
    }
}
