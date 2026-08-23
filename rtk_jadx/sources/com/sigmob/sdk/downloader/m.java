package com.sigmob.sdk.downloader;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m {
    final List<Integer> b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final c f555c = new c() { // from class: com.sigmob.sdk.downloader.m.1
        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i, int i2, Map<String, List<String>> map) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a(fVar, i, i2, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i, long j) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a(fVar, i, j);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, int i, Map<String, List<String>> map) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a(fVar, i, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar2 : b) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar2 : b) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar, bVar);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a(fVar, aVar, exc);
                }
            }
            if (m.this.b.contains(Integer.valueOf(fVar.c()))) {
                m.this.a(fVar.c());
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, Map<String, List<String>> map) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a(fVar, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(f fVar) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.a_(fVar);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f fVar, int i, long j) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.b(fVar, i, j);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(f fVar, int i, Map<String, List<String>> map) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.b(fVar, i, map);
                }
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void c(f fVar, int i, long j) {
            c[] b = m.b(fVar, m.this.a);
            if (b == null) {
                return;
            }
            for (c cVar : b) {
                if (cVar != null) {
                    cVar.c(fVar, i, j);
                }
            }
        }
    };
    final SparseArray<ArrayList<c>> a = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static c[] b(f fVar, SparseArray<ArrayList<c>> sparseArray) {
        ArrayList<c> arrayList = sparseArray.get(fVar.c());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        c[] cVarArr = new c[arrayList.size()];
        arrayList.toArray(cVarArr);
        return cVarArr;
    }

    public c a() {
        return this.f555c;
    }

    public synchronized void a(int i) {
        this.a.remove(i);
    }

    public synchronized void a(c cVar) {
        int size = this.a.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            ArrayList<c> valueAt = this.a.valueAt(i);
            if (valueAt != null) {
                valueAt.remove(cVar);
                if (valueAt.isEmpty()) {
                    arrayList.add(Integer.valueOf(this.a.keyAt(i)));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.a.remove(((Integer) it.next()).intValue());
        }
    }

    boolean a(f fVar) {
        return l.a(fVar);
    }

    public synchronized boolean a(f fVar, c cVar) {
        int c2 = fVar.c();
        ArrayList<c> arrayList = this.a.get(c2);
        if (arrayList == null) {
            return false;
        }
        boolean remove = arrayList.remove(cVar);
        if (arrayList.isEmpty()) {
            this.a.remove(c2);
        }
        return remove;
    }

    public synchronized void b(int i) {
        if (this.b.contains(Integer.valueOf(i))) {
            return;
        }
        this.b.add(Integer.valueOf(i));
    }

    public synchronized void b(f fVar, c cVar) {
        int c2 = fVar.c();
        ArrayList<c> arrayList = this.a.get(c2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(c2, arrayList);
        }
        if (!arrayList.contains(cVar)) {
            arrayList.add(cVar);
            if (cVar instanceof com.sigmob.sdk.downloader.core.listener.assist.d) {
                ((com.sigmob.sdk.downloader.core.listener.assist.d) cVar).b(true);
            }
        }
    }

    public synchronized void c(int i) {
        this.b.remove(Integer.valueOf(i));
    }

    public synchronized void c(f fVar, c cVar) {
        b(fVar, cVar);
        if (!a(fVar)) {
            fVar.b(this.f555c);
        }
    }

    public synchronized void d(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.b(this.f555c);
    }

    public synchronized void e(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.c(this.f555c);
    }
}
