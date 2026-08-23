package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IdTracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    public static final long a = 86400000;
    public static e b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1107c = "umeng_it.cache";
    private static Object j = new Object();
    private File d;
    private long f;
    private a i;
    private com.umeng.commonsdk.statistics.proto.c e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    /* compiled from: IdTracker.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized boolean a(String str) {
            return !this.b.contains(str);
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.i = null;
        this.d = new File(context.getFilesDir(), f1107c);
        a aVar = new a(context);
        this.i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (e.class) {
            e eVar = b;
            if (eVar != null) {
                eVar.e();
                b = null;
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (j) {
            if (!this.d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.d);
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new aw().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= this.g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.i.a();
                g();
            }
            this.f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i = i();
        if (i == null) {
            return;
        }
        a(i);
        ArrayList arrayList = new ArrayList(this.h.size());
        synchronized (this) {
            this.e = i;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                aVar.a(this.e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                e eVar2 = new e(context);
                b = eVar2;
                eVar2.a(new f(context));
                b.a(new b(context));
                b.a(new j(context));
                b.a(new d(context));
                b.a(new c(context));
                b.a(new g(context));
                b.a(new i());
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
                    b.a(new h(context));
                }
                b.f();
            }
            eVar = b;
        }
        return eVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new bc().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.d, a2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
            cVar.a.remove("mac");
        }
        if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.b.g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
            cVar.a.remove("android_id");
        }
        if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.b.j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.b.w)) {
            cVar.a.remove("idfa");
        }
        if (!cVar.a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }
}
