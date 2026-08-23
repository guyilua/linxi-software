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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdJournal.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements at<a, e>, Serializable, Cloneable {
    public static final Map<e, bf> e;
    private static final long f = 9132678615281394583L;
    private static final bx g = new bx("IdJournal");
    private static final bn h = new bn("domain", (byte) 11, 1);
    private static final bn i = new bn("old_id", (byte) 11, 2);
    private static final bn j = new bn("new_id", (byte) 11, 3);
    private static final bn k = new bn("ts", (byte) 10, 4);
    private static final Map<Class<? extends ca>, cb> l;
    private static final int m = 0;
    public String a;
    public String b;

    /* renamed from: c, reason: collision with root package name */
    public String f1112c;
    public long d;
    private byte n;
    private e[] o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0133a extends cc<a> {
        private C0133a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, a aVar) {
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
                            if (s != 4) {
                                bv.a(bsVar, b);
                            } else if (b == 10) {
                                aVar.d = bsVar.x();
                                aVar.d(true);
                            } else {
                                bv.a(bsVar, b);
                            }
                        } else if (b == 11) {
                            aVar.f1112c = bsVar.z();
                            aVar.c(true);
                        } else {
                            bv.a(bsVar, b);
                        }
                    } else if (b == 11) {
                        aVar.b = bsVar.z();
                        aVar.b(true);
                    } else {
                        bv.a(bsVar, b);
                    }
                } else if (b == 11) {
                    aVar.a = bsVar.z();
                    aVar.a(true);
                } else {
                    bv.a(bsVar, b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, a aVar) {
            aVar.n();
            bsVar.a(a.g);
            if (aVar.a != null) {
                bsVar.a(a.h);
                bsVar.a(aVar.a);
                bsVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                bsVar.a(a.i);
                bsVar.a(aVar.b);
                bsVar.c();
            }
            if (aVar.f1112c != null) {
                bsVar.a(a.j);
                bsVar.a(aVar.f1112c);
                bsVar.c();
            }
            bsVar.a(a.k);
            bsVar.a(aVar.d);
            bsVar.c();
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: IdJournal.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class b implements cb {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0133a b() {
            return new C0133a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends cd<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, a aVar) {
            by byVar = (by) bsVar;
            byVar.a(aVar.a);
            byVar.a(aVar.f1112c);
            byVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            byVar.a(bitSet, 1);
            if (aVar.g()) {
                byVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, a aVar) {
            by byVar = (by) bsVar;
            aVar.a = byVar.z();
            aVar.a(true);
            aVar.f1112c = byVar.z();
            aVar.c(true);
            aVar.d = byVar.x();
            aVar.d(true);
            if (byVar.b(1).get(0)) {
                aVar.b = byVar.z();
                aVar.b(true);
            }
        }
    }

    /* compiled from: IdJournal.java */
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
        l = hashMap;
        hashMap.put(cc.class, new b());
        hashMap.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new bf("domain", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new bf("old_id", (byte) 2, new bg((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new bf("new_id", (byte) 1, new bg((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bf("ts", (byte) 1, new bg((byte) 10)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = unmodifiableMap;
        bf.a(a.class, unmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
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
        this.b = null;
        this.f1112c = null;
        d(false);
        this.d = 0L;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.f1112c;
    }

    public void i() {
        this.f1112c = null;
    }

    public boolean j() {
        return this.f1112c != null;
    }

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = aq.b(this.n, 0);
    }

    public boolean m() {
        return aq.a(this.n, 0);
    }

    public void n() {
        if (this.a != null) {
            if (this.f1112c != null) {
                return;
            }
            throw new bt("Required field 'new_id' was not present! Struct: " + toString());
        }
        throw new bt("Required field 'domain' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        l.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f1112c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        l.get(bsVar.D()).b().a(bsVar, this);
    }

    /* compiled from: IdJournal.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum e implements ba {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");

        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
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
            return this.g;
        }

        public static e a(String str) {
            return e.get(str);
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f;
        }
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public a c(String str) {
        this.f1112c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = aq.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
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
        this.f1112c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.f1112c = str2;
        this.d = j2;
        d(true);
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
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

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.f1112c = aVar.f1112c;
        }
        this.d = aVar.d;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.n = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
