package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements com.ss.android.socialbase.downloader.network.h {
    @Override // com.ss.android.socialbase.downloader.network.h
    public com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        OkHttpClient s = com.ss.android.socialbase.downloader.downloader.c.s();
        if (s != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    head.addHeader(cVar.a(), com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
                }
            }
            final Call newCall = s.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (com.ss.android.socialbase.downloader.i.a.a(2097152)) {
                    execute.close();
                }
                return new com.ss.android.socialbase.downloader.network.g() { // from class: com.ss.android.socialbase.downloader.impls.f.1
                    @Override // com.ss.android.socialbase.downloader.network.g
                    public String a(String str2) {
                        return execute.header(str2);
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public int b() {
                        return execute.code();
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public void c() {
                        Call call = newCall;
                        if (call == null || call.isCanceled()) {
                            return;
                        }
                        newCall.cancel();
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
