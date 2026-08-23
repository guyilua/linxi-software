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

/* compiled from: ImprintValue.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements at<e, EnumC0137e>, Serializable, Cloneable {
    public static final Map<EnumC0137e, bf> d;
    private static final long e = 7501688097813630241L;
    private static final bx f = new bx("ImprintValue");
    private static final bn g = new bn("value", (byte) 11, 1);
    private static final bn h = new bn("ts", (byte) 10, 2);
    private static final bn i = new bn("guid", (byte) 11, 3);
    private static final Map<Class<? extends ca>, cb> j;
    private static final int k = 0;
    public String a;
    public long b;

    /* renamed from: c, reason: collision with root package name */
    public String f1120c;
    private byte l;
    private EnumC0137e[] m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImprintValue.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends cc<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, e eVar) {
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
                            eVar.f1120c = bsVar.z();
                            eVar.c(true);
                        } else {
                            bv.a(bsVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = bsVar.x();
                        eVar.b(true);
                    } else {
                        bv.a(bsVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = bsVar.z();
                    eVar.a(true);
                } else {
                    bv.a(bsVar, b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (eVar.g()) {
                eVar.k();
                return;
            }
            throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, e eVar) {
            eVar.k();
            bsVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                bsVar.a(e.g);
                bsVar.a(eVar.a);
                bsVar.c();
            }
            bsVar.a(e.h);
            bsVar.a(eVar.b);
            bsVar.c();
            if (eVar.f1120c != null) {
                bsVar.a(e.i);
                bsVar.a(eVar.f1120c);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* compiled from: ImprintValue.java */
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
    /* compiled from: ImprintValue.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends cd<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, e eVar) {
            by byVar = (by) bsVar;
            byVar.a(eVar.b);
            byVar.a(eVar.f1120c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            byVar.a(bitSet, 1);
            if (eVar.d()) {
                byVar.a(eVar.a);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, e eVar) {
            by byVar = (by) bsVar;
            eVar.b = byVar.x();
            eVar.b(true);
            eVar.f1120c = byVar.z();
            eVar.c(true);
            if (byVar.b(1).get(0)) {
                eVar.a = byVar.z();
                eVar.a(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
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
        hashMap.put(cc.class, new b());
        hashMap.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0137e.class);
        enumMap.put((EnumMap) EnumC0137e.VALUE, (EnumC0137e) new bf("value", (byte) 2, new bg((byte) 11)));
        enumMap.put((EnumMap) EnumC0137e.TS, (EnumC0137e) new bf("ts", (byte) 1, new bg((byte) 10)));
        enumMap.put((EnumMap) EnumC0137e.GUID, (EnumC0137e) new bf("guid", (byte) 1, new bg((byte) 11)));
        Map<EnumC0137e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bf.a(e.class, unmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0137e[]{EnumC0137e.VALUE};
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
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
        this.f1120c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = aq.b(this.l, 0);
    }

    public boolean g() {
        return aq.a(this.l, 0);
    }

    public String h() {
        return this.f1120c;
    }

    public void i() {
        this.f1120c = null;
    }

    public boolean j() {
        return this.f1120c != null;
    }

    public void k() {
        if (this.f1120c != null) {
            return;
        }
        throw new bt("Required field 'guid' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        j.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f1120c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        j.get(bsVar.D()).b().a(bsVar, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum EnumC0137e implements ba {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC0137e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(EnumC0137e.class).iterator();
            while (it.hasNext()) {
                EnumC0137e enumC0137e = (EnumC0137e) it.next();
                d.put(enumC0137e.b(), enumC0137e);
            }
        }

        EnumC0137e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static EnumC0137e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0137e b(int i) {
            EnumC0137e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }

        public static EnumC0137e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = aq.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f1120c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.f1120c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.f1120c = str;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.at
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0137e fieldForId(int i2) {
        return EnumC0137e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new bm(new ce(objectOutputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0137e[]{EnumC0137e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.f1120c = eVar.f1120c;
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
