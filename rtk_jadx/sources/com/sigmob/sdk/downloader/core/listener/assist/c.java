package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.k;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements b.a, e.b<b> {
    private a a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(f fVar, int i, long j, k kVar);

        void a(f fVar, int i, com.sigmob.sdk.downloader.core.breakpoint.a aVar, k kVar);

        void a(f fVar, long j, k kVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, b bVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, k kVar);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b extends b.c {
        k d;
        SparseArray<k> e;

        public b(int i) {
            super(i);
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.b.c, com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            super.a(cVar);
            this.d = new k();
            this.e = new SparseArray<>();
            int g = cVar.g();
            for (int i = 0; i < g; i++) {
                this.e.put(i, new k());
            }
        }

        public k b(int i) {
            return this.e.get(i);
        }

        public k f() {
            return this.d;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(int i) {
        return new b(i);
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, int i, long j, b.c cVar) {
        b bVar = (b) cVar;
        bVar.e.get(i).a(j);
        bVar.d.a(j);
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.f544c.get(i).longValue(), bVar.b(i));
        this.a.a(fVar, cVar.b, bVar.d);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, int i, b.c cVar) {
        b bVar = (b) cVar;
        bVar.e.get(i).g();
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, i, cVar.a.b(i), bVar.b(i));
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, b.c cVar2) {
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(fVar, cVar, z, (b) cVar2);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b.c cVar) {
        k kVar = ((b) cVar).d;
        if (kVar != null) {
            kVar.g();
        } else {
            kVar = new k();
        }
        a aVar2 = this.a;
        if (aVar2 == null) {
            return true;
        }
        aVar2.a(fVar, aVar, exc, kVar);
        return true;
    }
}
