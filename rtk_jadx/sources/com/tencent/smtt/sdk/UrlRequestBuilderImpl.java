package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {
    private static final String a = "UrlRequestBuilderImpl";
    private final String b;

    /* renamed from: c, reason: collision with root package name */
    private final UrlRequest.Callback f948c;
    private final Executor d;
    private String e;
    private boolean g;
    private final ArrayList<Pair<String, String>> f = new ArrayList<>();
    private int h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        Objects.requireNonNull(str, "URL is required.");
        Objects.requireNonNull(callback, "Callback is required.");
        Objects.requireNonNull(executor, "Executor is required.");
        this.b = str;
        this.f948c = callback;
        this.d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() {
        t a2 = t.a();
        if (a2 == null || !a2.b()) {
            return null;
        }
        UrlRequest urlRequest = (UrlRequest) a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class}, this.b, Integer.valueOf(this.h), this.f948c, this.d, Boolean.valueOf(this.g), this.e, this.f);
        Objects.requireNonNull(urlRequest, "UrlRequest build fail");
        return urlRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        Objects.requireNonNull(str, "Method is required.");
        this.e = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        Objects.requireNonNull(str, "Invalid header name.");
        Objects.requireNonNull(str2, "Invalid header value.");
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            return this;
        }
        this.f.add(Pair.create(str, str2));
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.h = i;
        return this;
    }
}
