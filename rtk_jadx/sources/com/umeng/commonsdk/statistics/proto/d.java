package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Imprint.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d implements at<d, e>, Serializable, Cloneable {
    public static final Map<e, bf> d;
    private static final long e = 2846460275012375038L;
    private static final bx f = new bx("Imprint");
    private static final bn g = new bn("property", bz.k, 1);
    private static final bn h = new bn("version", (byte) 8, 2);
    private static final bn i = new bn("checksum", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public String f1118c;
    private byte l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends cc<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, d dVar) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                byte b = l.b;
                if (b == 0) {
                    break;
                }
                short s = l.f1033c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bv.a(bsVar, b);
                        } else if (b == 11) {
                            dVar.f1118c = bsVar.z();
                            dVar.c(true);
                        } else {
                            bv.a(bsVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = bsVar.w();
                        dVar.b(true);
                    } else {
                        bv.a(bsVar, b);
                    }
                } else if (b == 13) {
                    bp n = bsVar.n();
                    dVar.a = new HashMap(n.f1034c * 2);
                    for (int i = 0; i < n.f1034c; i++) {
                        String z = bsVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(bsVar);
                        dVar.a.put(z, eVar);
                    }
                    bsVar.o();
                    dVar.a(true);
                } else {
                    bv.a(bsVar, b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, d dVar) {
            dVar.l();
            bsVar.a(d.f);
            if (dVar.a != null) {
                bsVar.a(d.g);
                bsVar.a(new bp((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    bsVar.a(entry.getKey());
                    entry.getValue().write(bsVar);
                }
                bsVar.e();
                bsVar.c();
            }
            bsVar.a(d.h);
            bsVar.a(dVar.b);
            bsVar.c();
            if (dVar.f1118c != null) {
                bsVar.a(d.i);
                bsVar.a(dVar.f1118c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: Imprint.java */
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
    /* compiled from: Imprint.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends cd<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, d dVar) {
            by byVar = (by) bsVar;
            byVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                byVar.a(entry.getKey());
                entry.getValue().write(byVar);
            }
            byVar.a(dVar.b);
            byVar.a(dVar.f1118c);
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, d dVar) {
            by byVar = (by) bsVar;
            bp bpVar = new bp((byte) 11, (byte) 12, byVar.w());
            dVar.a = new HashMap(bpVar.f1034c * 2);
            for (int i = 0; i < bpVar.f1034c; i++) {
                String z = byVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(byVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = byVar.w();
            dVar.b(true);
            dVar.f1118c = byVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class C0136d implements cb {
        private C0136d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cc.class, new b());
        hashMap.put(cd.class, new C0136d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bf("property", (byte) 1, new bi(bz.k, new bg((byte) 11), new bk((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bf("version", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bf("checksum", (byte) 1, new bg((byte) 11)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bf.a(d.class, unmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.f1118c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = aq.b(this.l, 0);
    }

    public boolean h() {
        return aq.a(this.l, 0);
    }

    public String i() {
        return this.f1118c;
    }

    public void j() {
        this.f1118c = null;
    }

    public boolean k() {
        return this.f1118c != null;
    }

    public void l() {
        if (this.a != null) {
            if (this.f1118c != null) {
                return;
            }
            throw new bt("Required field 'checksum' was not present! Struct: " + toString());
        }
        throw new bt("Required field 'property' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        j.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f1118c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        j.get(bsVar.D()).b().a(bsVar, this);
    }

    /* compiled from: Imprint.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum e implements ba {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
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
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
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

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void b(boolean z) {
        this.l = aq.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f1118c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.f1118c = str;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.f1118c = dVar.f1118c;
        }
    }

    public d a(String str) {
        this.f1118c = str;
        return this;
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
            this.l = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
