package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IdTracking.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements at<c, e>, Serializable, Cloneable {
    public static final Map<e, bf> d;
    private static final long e = -5764118265293965743L;
    private static final bx f = new bx("IdTracking");
    private static final bn g = new bn("snapshots", bz.k, 1);
    private static final bn h = new bn("journals", bz.m, 2);
    private static final bn i = new bn("checksum", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;

    /* renamed from: c, reason: collision with root package name */
    public String f1116c;
    private e[] k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends cc<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, c cVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                byte b = l.b;
                if (b == 0) {
                    bsVar.k();
                    cVar.n();
                    return;
                }
                short s = l.f1033c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bv.a(bsVar, b);
                        } else if (b == 11) {
                            cVar.f1116c = bsVar.z();
                            cVar.c(true);
                        } else {
                            bv.a(bsVar, b);
                        }
                    } else if (b == 15) {
                        bo p = bsVar.p();
                        cVar.b = new ArrayList(p.b);
                        while (i < p.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(bsVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        bsVar.q();
                        cVar.b(true);
                    } else {
                        bv.a(bsVar, b);
                    }
                } else if (b == 13) {
                    bp n = bsVar.n();
                    cVar.a = new HashMap(n.f1034c * 2);
                    while (i < n.f1034c) {
                        String z = bsVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(bsVar);
                        cVar.a.put(z, bVar);
                        i++;
                    }
                    bsVar.o();
                    cVar.a(true);
                } else {
                    bv.a(bsVar, b);
                }
                bsVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, c cVar) {
            cVar.n();
            bsVar.a(c.f);
            if (cVar.a != null) {
                bsVar.a(c.g);
                bsVar.a(new bp((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    bsVar.a(entry.getKey());
                    entry.getValue().write(bsVar);
                }
                bsVar.e();
                bsVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                bsVar.a(c.h);
                bsVar.a(new bo((byte) 12, cVar.b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(bsVar);
                }
                bsVar.f();
                bsVar.c();
            }
            if (cVar.f1116c != null && cVar.m()) {
                bsVar.a(c.i);
                bsVar.a(cVar.f1116c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdTracking.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class b implements cb {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0135c extends cd<c> {
        private C0135c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, c cVar) {
            by byVar = (by) bsVar;
            byVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                byVar.a(entry.getKey());
                entry.getValue().write(byVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            byVar.a(bitSet, 2);
            if (cVar.j()) {
                byVar.a(cVar.b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(byVar);
                }
            }
            if (cVar.m()) {
                byVar.a(cVar.f1116c);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, c cVar) {
            by byVar = (by) bsVar;
            bp bpVar = new bp((byte) 11, (byte) 12, byVar.w());
            cVar.a = new HashMap(bpVar.f1034c * 2);
            for (int i = 0; i < bpVar.f1034c; i++) {
                String z = byVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(byVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b = byVar.b(2);
            if (b.get(0)) {
                bo boVar = new bo((byte) 12, byVar.w());
                cVar.b = new ArrayList(boVar.b);
                for (int i2 = 0; i2 < boVar.b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(byVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.f1116c = byVar.z();
                cVar.c(true);
            }
        }
    }

    /* compiled from: IdTracking.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class d implements cb {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0135c b() {
            return new C0135c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new b());
        hashMap.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new bf("snapshots", (byte) 1, new bi(bz.k, new bg((byte) 11), new bk((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new bf("journals", (byte) 2, new bh(bz.m, new bk((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bf("checksum", (byte) 2, new bg((byte) 11)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bf.a(c.class, unmodifiableMap);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.a = null;
        this.b = null;
        this.f1116c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.f1116c;
    }

    public void l() {
        this.f1116c = null;
    }

    public boolean m() {
        return this.f1116c != null;
    }

    public void n() {
        if (this.a != null) {
            return;
        }
        throw new bt("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        j.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f1116c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        j.get(bsVar.D()).b().a(bsVar, this);
    }

    /* compiled from: IdTracking.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum e implements ba {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }

        public static e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f1116c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.f1116c = cVar.f1116c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(String str) {
        this.f1116c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new bm(new ce(objectOutputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
