package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m implements u {

    /* renamed from: c, reason: collision with root package name */
    private static final int f669c = 5;
    private static OkHttpClient d;
    protected volatile long a;
    protected volatile String b;
    private InputStream e;
    private v f;
    private final com.sigmob.sdk.videocache.sourcestorage.c g;
    private final com.sigmob.sdk.videocache.headers.b h;
    private Response i;

    public m(u uVar) {
        this.a = -2147483648L;
        this.b = "video/mp4";
        this.f = uVar.d();
        this.g = uVar.e();
        this.h = uVar.f();
    }

    public m(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.a = -2147483648L;
        this.b = "video/mp4";
        this.g = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.h = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v a = cVar.a(str);
        this.f = a == null ? new v(str, -2147483648L, r.a(str)) : a;
    }

    private long a(Response response, long j) {
        int code = response.code();
        int contentLength = (int) response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j : this.a;
    }

    private Response a(long j, int i) {
        if (d == null) {
            OkHttpClient.Builder connectionPool = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            d = connectionPool.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).build();
        }
        String str = this.f.a;
        Response response = this.i;
        if (response != null && j > 0) {
            try {
                response.close();
            } catch (Throwable unused) {
            }
            this.i = null;
            r.a(this.e);
        }
        if (this.i == null) {
            int i2 = 0;
            boolean z = false;
            do {
                Request.Builder builder = new Request.Builder();
                builder.get();
                builder.url(str);
                a(builder, str);
                if (j > 0) {
                    builder.addHeader(com.sigmob.sdk.downloader.core.c.b, "bytes=" + j + "-");
                }
                Response execute = d.newCall(builder.build()).execute();
                this.i = execute;
                if (execute.isRedirect()) {
                    str = this.i.header("Location");
                    z = this.i.isRedirect();
                    i2++;
                }
                if (i2 > 5) {
                    throw new q("Too many redirects: " + i2);
                }
            } while (z);
        }
        return this.i;
    }

    private void a(Request.Builder builder, String str) {
        for (Map.Entry<String, String> entry : this.h.a(str).entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private void h() {
        try {
            SigmobLog.d("Read content info from " + this.f.a);
            Response a = a(0L, 10000);
            if (a == null || !a.isSuccessful()) {
                throw new q("Fail to fetchContentInfo: " + this.f.a);
            }
            ResponseBody body = a.body();
            if (body != null) {
                this.a = (int) body.contentLength();
                if (body.contentType() != null) {
                    this.b = body.contentType().toString();
                }
            }
            v vVar = new v(this.f.a, this.a, this.b);
            this.f = vVar;
            this.g.a(vVar.a, vVar);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.f.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.f.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new l("Reading source " + this.f.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.f.a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() {
        if (this.a == -2147483648L) {
            h();
        }
        return this.a;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        try {
            Response a = a(j, -1);
            this.i = a;
            ResponseBody body = a.body();
            if (body != null && body.contentType() != null) {
                this.b = body.contentType().toString();
            }
            this.a = a(this.i, j);
            this.e = new BufferedInputStream(body.byteStream(), 8192);
            v vVar = new v(this.f.a, this.a, this.b);
            this.f = vVar;
            this.g.a(vVar.a, vVar);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.f.a + " with offset " + j, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
        try {
            r.a(this.e);
        } catch (ArrayIndexOutOfBoundsException e) {
            SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        } catch (NullPointerException e3) {
            e = e3;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() {
        if (TextUtils.isEmpty(this.f.f674c)) {
            h();
        }
        return this.f.f674c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.f;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.g;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.h;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.f.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f + "}";
    }
}
