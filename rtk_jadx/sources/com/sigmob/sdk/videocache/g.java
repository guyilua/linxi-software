package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends p {
    private static final float a = 0.2f;
    private final u b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.videocache.file.b f663c;
    private d d;

    public g(u uVar, com.sigmob.sdk.videocache.file.b bVar) {
        super(uVar, bVar);
        this.f663c = bVar;
        this.b = uVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j, 8192);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j += a2;
            }
        }
    }

    private boolean a(f fVar) {
        long a2 = this.b.a();
        return (((a2 > 0L ? 1 : (a2 == 0L ? 0 : -1)) > 0) && fVar.f661c && ((float) fVar.b) > ((float) this.f663c.a()) + (((float) a2) * a)) ? false : true;
    }

    private String b(f fVar) {
        String c2 = this.b.c();
        boolean z = !TextUtils.isEmpty(c2);
        long a2 = this.f663c.d() ? this.f663c.a() : this.b.a();
        boolean z2 = a2 >= 0;
        boolean z3 = fVar.f661c;
        long j = z3 ? a2 - fVar.b : a2;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.f661c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(fVar.b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        sb.append(z ? a("Content-Type: %s\n", c2) : "");
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) {
        u a2 = t.a(this.b);
        try {
            a2.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a3 = a2.a(bArr);
                if (a3 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a3);
            }
        } finally {
            a2.b();
        }
    }

    private String c(f fVar) {
        return "HTTP/1.1 404 Not Found\n";
    }

    @Override // com.sigmob.sdk.videocache.p
    protected void a(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.f663c.a, this.b.g(), i);
        }
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(f fVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(fVar).getBytes("UTF-8"));
        long j = fVar.b;
        if (a(fVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.videocache.p
    public void a(Throwable th) {
        super.a(th);
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.b.g(), th);
        }
    }
}
