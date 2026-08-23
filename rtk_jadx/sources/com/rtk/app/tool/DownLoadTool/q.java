package com.rtk.app.tool.DownLoadTool;

import com.rtk.app.tool.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DownLoadInfoDao.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q {
    private static List<p> a = new ArrayList();
    public static int b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f286c = 1;
    public static int d = 2;
    public static int e = 3;
    public static int f = 4;
    public static int g = 5;
    private static List<Map<String, String>> h = new ArrayList();

    public static synchronized void a(p pVar) {
        synchronized (q.class) {
            if (d(pVar.j()) == null) {
                a.add(pVar);
            }
        }
    }

    public static synchronized void b(int i, String str) {
        synchronized (q.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("gameId", i + "");
            hashMap.put("packageName", str);
            h.add(hashMap);
        }
    }

    public static synchronized List<p> c(String str) {
        ArrayList arrayList;
        synchronized (q.class) {
            arrayList = new ArrayList();
            for (p pVar : a) {
                if (pVar.n().equals(str)) {
                    arrayList.add(pVar);
                }
            }
        }
        return arrayList;
    }

    public static synchronized p d(int i) {
        synchronized (q.class) {
            for (p pVar : a) {
                if (i == pVar.j() || i == pVar.q()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" getInfoToPackageName:");
                    sb.append(pVar.g() == null ? "null" : " downlist.size:" + pVar.g().size());
                    c0.u("DownLoadInfoDao", sb.toString());
                    return pVar;
                }
            }
            return null;
        }
    }

    public static synchronized List<p> e() {
        List<p> list;
        synchronized (q.class) {
            list = a;
        }
        return list;
    }

    public static synchronized boolean f(int i) {
        synchronized (q.class) {
            for (p pVar : a) {
                if (i == pVar.j()) {
                    a.remove(pVar);
                    return true;
                }
            }
            return false;
        }
    }

    public static synchronized void g(p pVar) {
        synchronized (q.class) {
            f(pVar.j());
            a(pVar);
        }
    }
}
