package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    private final HashMap<String, Integer> a;
    private final SparseArray<String> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        this(new HashMap(), new SparseArray());
    }

    k(HashMap<String, Integer> hashMap, SparseArray<String> sparseArray) {
        this.a = hashMap;
        this.b = sparseArray;
    }

    public Integer a(com.sigmob.sdk.downloader.f fVar) {
        Integer num = this.a.get(b(fVar));
        if (num != null) {
            return num;
        }
        return null;
    }

    public void a(int i) {
        String str = this.b.get(i);
        if (str != null) {
            this.a.remove(str);
            this.b.remove(i);
        }
    }

    public void a(com.sigmob.sdk.downloader.f fVar, int i) {
        String b = b(fVar);
        this.a.put(b, Integer.valueOf(i));
        this.b.put(i, b);
    }

    String b(com.sigmob.sdk.downloader.f fVar) {
        return fVar.i() + fVar.h() + fVar.d();
    }
}
