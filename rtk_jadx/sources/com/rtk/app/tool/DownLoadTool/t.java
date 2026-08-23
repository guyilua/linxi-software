package com.rtk.app.tool.DownLoadTool;

import com.rtk.app.tool.c0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: DownloadUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t {
    private static t a;
    private static OkHttpClient b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Integer, Call> f288c;
    private static List<s> d = new ArrayList();
    private static Map<Integer, s> e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements Callback {
        final /* synthetic */ s a;
        final /* synthetic */ b b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p f289c;
        final /* synthetic */ long d;
        final /* synthetic */ String e;

        a(s sVar, b bVar, p pVar, long j, String str) {
            this.a = sVar;
            this.b = bVar;
            this.f289c = pVar;
            this.d = j;
            this.e = str;
        }

        public void onFailure(Call call, IOException iOException) {
            t.f(this.a);
            c0.u("DownloadUtil", "下载失败" + iOException);
            this.b.c(iOException, "下载失败");
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0346  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x034b  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0358  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x035d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onResponse(okhttp3.Call r36, okhttp3.Response r37) {
            /*
                Method dump skipped, instructions count: 881
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.DownLoadTool.t.a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: DownloadUtil.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(int i, String str, long j, long j2);

        void b();

        void c(Exception exc, String str);

        void onDownloadStart();
    }

    private t() {
        b = new OkHttpClient();
        f288c = new HashMap();
    }

    public static void d(s sVar) {
        p b2 = sVar.b();
        String d2 = sVar.d();
        c0.u("DownloadUtil", "downloadForStack saveDir:" + d2);
        b c2 = sVar.c();
        long a2 = sVar.a();
        if (b2 == null) {
            c0.s("DownloadUtil", "info is null");
            return;
        }
        Request build = new Request.Builder().url(b2.r()).header("RANGE", "bytes=" + a2 + "-").build();
        c2.onDownloadStart();
        b.newCall(build).enqueue(new a(sVar, c2, b2, a2, d2));
    }

    public static t e() {
        if (a == null) {
            a = new t();
        }
        return a;
    }

    public static void f(s sVar) {
        c0.u("DownloadUtil", "开始下一个");
        if (d.contains(sVar)) {
            e.remove(Integer.valueOf(sVar.b().j()));
            d.remove(sVar);
        }
        int size = d.size();
        int i = com.rtk.app.tool.y.q;
        if (size >= i) {
            d(d.get(i - 1));
        }
    }

    public static void g(int i, int i2) {
        try {
            e();
            Call call = f288c.get(Integer.valueOf(i));
            if (call != null) {
                call.cancel();
                if (i2 == q.d) {
                    x.c().k(i);
                }
            }
            f288c.remove(Integer.valueOf(i));
            p d2 = q.d(i);
            d2.y(i2);
            q.g(d2);
        } catch (Exception e2) {
            c0.u("DownloadUtil", "异常id" + i + "\n暂停  ---DownLoadUtils  stopDown()取消下载异常" + e2 + "");
        }
    }

    public static void h(int i, int i2, boolean... zArr) {
        boolean z = zArr.length > 0 ? zArr[0] : true;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                if (i == ((s) arrayList.get(i3)).b().j()) {
                    s sVar = (s) arrayList.get(i3);
                    c0.u("DownloadUtil", "暂停  --从下载栈中  删除全部" + z);
                    if (z) {
                        f(sVar);
                    } else if (d.contains(sVar)) {
                        d.remove(sVar);
                        e.remove(Integer.valueOf(sVar.b().j()));
                    }
                }
            } catch (Exception e2) {
                c0.u("DownloadUtil", "暂停 ---从下载栈中  删除异常" + e2.toString());
            }
        }
        g(i, i2);
        c0.u("DownloadUtil", "暂停栈里还有任务数量" + arrayList.size());
    }

    public void c(p pVar, String str, b bVar, long j) {
        s sVar = new s(pVar, str, bVar, j);
        d.add(sVar);
        e.put(Integer.valueOf(pVar.j()), sVar);
        if (d.size() <= com.rtk.app.tool.y.q) {
            d(sVar);
        }
    }
}
