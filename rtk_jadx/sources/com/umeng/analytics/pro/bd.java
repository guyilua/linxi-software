package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bd;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class bd<T extends bd<?, ?>, F extends ba> implements at<T, F> {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends ca>, cb> f1025c;
    protected Object a;
    protected F b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TUnion.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends cc<bd> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, bd bdVar) {
            bdVar.b = null;
            bdVar.a = null;
            bsVar.j();
            bn l = bsVar.l();
            Object a = bdVar.a(bsVar, l);
            bdVar.a = a;
            if (a != null) {
                bdVar.b = (F) bdVar.a(l.f1033c);
            }
            bsVar.m();
            bsVar.l();
            bsVar.k();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, bd bdVar) {
            if (bdVar.a() != null && bdVar.b() != null) {
                bsVar.a(bdVar.d());
                bsVar.a(bdVar.c(bdVar.b));
                bdVar.a(bsVar);
                bsVar.c();
                bsVar.d();
                bsVar.b();
                return;
            }
            throw new bt("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
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
    /* compiled from: TUnion.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends cd<bd> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bs bsVar, bd bdVar) {
            bdVar.b = null;
            bdVar.a = null;
            short v = bsVar.v();
            Object a = bdVar.a(bsVar, v);
            bdVar.a = a;
            if (a != null) {
                bdVar.b = (F) bdVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bs bsVar, bd bdVar) {
            if (bdVar.a() != null && bdVar.b() != null) {
                bsVar.a(bdVar.b.a());
                bdVar.b(bsVar);
                return;
            }
            throw new bt("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
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
        f1025c = hashMap;
        hashMap.put(cc.class, new b());
        hashMap.put(cd.class, new d());
    }

    protected bd() {
        this.b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        if (obj instanceof at) {
            return ((at) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return au.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(bs bsVar, bn bnVar);

    protected abstract Object a(bs bsVar, short s);

    protected abstract void a(bs bsVar);

    public Object b() {
        return this.a;
    }

    protected abstract void b(F f, Object obj);

    protected abstract void b(bs bsVar);

    protected abstract bn c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.at
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    protected abstract bx d();

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        f1025c.get(bsVar.D()).b().b(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                au.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        f1025c.get(bsVar.D()).b().a(bsVar, this);
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b((bd<T, F>) a((short) i));
    }

    protected bd(F f, Object obj) {
        a((bd<T, F>) f, obj);
    }

    protected bd(bd<T, F> bdVar) {
        if (bdVar.getClass().equals(getClass())) {
            this.b = bdVar.b;
            this.a = a(bdVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    public Object a(int i) {
        return a((bd<T, F>) a((short) i));
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public void a(int i, Object obj) {
        a((bd<T, F>) a((short) i), obj);
    }
}
