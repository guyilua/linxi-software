package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements i {
    protected final Object a;
    private final List<com.ss.android.socialbase.downloader.model.c> b;

    /* renamed from: c, reason: collision with root package name */
    private i f903c;
    private boolean d;
    private long e;
    private InputStream f;

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() {
        i iVar = this.f903c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.f903c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.f903c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() {
        synchronized (this.a) {
            if (this.d && this.f903c == null) {
                this.a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.b;
    }

    public boolean g() {
        try {
            i iVar = this.f903c;
            if (iVar != null) {
                return a(iVar.b());
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.e < b.a;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.f903c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
