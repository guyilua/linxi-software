package com.sigmob.sdk.downloader.core.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements com.sigmob.sdk.downloader.c {
    final com.sigmob.sdk.downloader.c[] a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private List<com.sigmob.sdk.downloader.c> a = new ArrayList();

        public a a(com.sigmob.sdk.downloader.c cVar) {
            if (cVar != null && !this.a.contains(cVar)) {
                this.a.add(cVar);
            }
            return this;
        }

        public f a() {
            List<com.sigmob.sdk.downloader.c> list = this.a;
            return new f((com.sigmob.sdk.downloader.c[]) list.toArray(new com.sigmob.sdk.downloader.c[list.size()]));
        }

        public boolean b(com.sigmob.sdk.downloader.c cVar) {
            return this.a.remove(cVar);
        }
    }

    f(com.sigmob.sdk.downloader.c[] cVarArr) {
        this.a = cVarArr;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, int i2, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(fVar, i, i2, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(fVar, i, j);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(fVar, i, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.a) {
            cVar2.a(fVar, cVar);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.a) {
            cVar2.a(fVar, cVar, bVar);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(fVar, aVar, exc);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(fVar, map);
        }
    }

    public boolean a(com.sigmob.sdk.downloader.c cVar) {
        for (com.sigmob.sdk.downloader.c cVar2 : this.a) {
            if (cVar2 == cVar) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a_(com.sigmob.sdk.downloader.f fVar) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a_(fVar);
        }
    }

    public int b(com.sigmob.sdk.downloader.c cVar) {
        int i = 0;
        while (true) {
            com.sigmob.sdk.downloader.c[] cVarArr = this.a;
            if (i >= cVarArr.length) {
                return -1;
            }
            if (cVarArr[i] == cVar) {
                return i;
            }
            i++;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.b(fVar, i, j);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i, Map<String, List<String>> map) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.b(fVar, i, map);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void c(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.c(fVar, i, j);
        }
    }
}
