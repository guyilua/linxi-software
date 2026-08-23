package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
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

/* compiled from: IdSnapshot.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements at<b, e>, Serializable, Cloneable {
    public static final Map<e, bf> d;
    private static final long e = -6496538196005191531L;
    private static final bx f = new bx("IdSnapshot");
    private static final bn g = new bn("identity", (byte) 11, 1);
    private static final bn h = new bn("ts", (byte) 10, 2);
    private static final bn i = new bn("version", (byte) 8, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;
    private static final int l = 1;
    public String a;
    public long b;

    /* renamed from: c, reason: collision with root package name */
    public int f1114c;
    private byte m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends cc<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, b bVar) {
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
                        } else if (b == 8) {
                            bVar.f1114c = bsVar.w();
                            bVar.c(true);
                        } else {
                            bv.a(bsVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = bsVar.x();
                        bVar.b(true);
                    } else {
                        bv.a(bsVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = bsVar.z();
                    bVar.a(true);
                } else {
                    bv.a(bsVar, b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (bVar.g()) {
                if (bVar.j()) {
                    bVar.k();
                    return;
                }
                throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, b bVar) {
            bVar.k();
            bsVar.a(b.f);
            if (bVar.a != null) {
                bsVar.a(b.g);
                bsVar.a(bVar.a);
                bsVar.c();
            }
            bsVar.a(b.h);
            bsVar.a(bVar.b);
            bsVar.c();
            bsVar.a(b.i);
            bsVar.a(bVar.f1114c);
            bsVar.c();
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class C0134b implements cb {
        private C0134b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends cd<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, b bVar) {
            by byVar = (by) bsVar;
            byVar.a(bVar.a);
            byVar.a(bVar.b);
            byVar.a(bVar.f1114c);
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, b bVar) {
            by byVar = (by) bsVar;
            bVar.a = byVar.z();
            bVar.a(true);
            bVar.b = byVar.x();
            bVar.b(true);
            bVar.f1114c = byVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class d implements cb {
        private d() {
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
        hashMap.put(cc.class, new C0134b());
        hashMap.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bf("identity", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bf("ts", (byte) 1, new bg((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bf("version", (byte) 1, new bg((byte) 8)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bf.a(b.class, unmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.f1114c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = aq.b(this.m, 0);
    }

    public boolean g() {
        return aq.a(this.m, 0);
    }

    public int h() {
        return this.f1114c;
    }

    public void i() {
        this.m = aq.b(this.m, 1);
    }

    public boolean j() {
        return aq.a(this.m, 1);
    }

    public void k() {
        if (this.a != null) {
            return;
        }
        throw new bt("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        j.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f1114c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        j.get(bsVar.D()).b().a(bsVar, this);
    }

    /* compiled from: IdSnapshot.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum e implements ba {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");

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
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
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

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = aq.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = aq.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.f1114c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f1114c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new bm(new ce(objectOutputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.f1114c = bVar.f1114c;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.m = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
