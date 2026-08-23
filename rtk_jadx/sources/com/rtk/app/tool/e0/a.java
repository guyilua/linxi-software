package com.rtk.app.tool.e0;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.a0;
import com.rtk.app.tool.DownLoadTool.p;
import com.rtk.app.tool.DownLoadTool.q;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.g.c;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.List;

/* compiled from: ZipUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private Context a;
    private d.a.a.f.a b;

    /* renamed from: c, reason: collision with root package name */
    private d.a.a.a.b f300c;
    private File d;
    private Thread e;
    private boolean f = false;
    private Handler g = new HandlerC0026a();

    /* compiled from: ZipUtils.java */
    /* renamed from: com.rtk.app.tool.e0.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class HandlerC0026a extends Handler {
        HandlerC0026a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (a.this.f) {
                return;
            }
            a.this.a = MyApplication.b();
            p pVar = (p) message.obj;
            Message message2 = new Message();
            x c2 = x.c();
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                c0.u("ZipUtils", "移动后是完整的getZipApkPath" + pVar.t() + "  getApp_save_path  " + pVar.e());
                if (t.V(a.this.a, pVar.t())) {
                    c0.u("ZipUtils", "移动后是完整的");
                    c2.l(pVar.j());
                    pVar.x(100L);
                    pVar.B(100L);
                    pVar.y(q.e);
                    pVar.z(0);
                    q.g(pVar);
                    c.e(a.this.a).g(pVar.j(), pVar.t());
                    t.m1(a.this.a, pVar);
                    return;
                }
                c0.u("ZipUtils", "移动后不完整的");
                message2.obj = message.obj;
                message2.what = message.what;
                int i2 = message.arg1 + 1;
                message2.arg1 = i2;
                if (i2 < 1000) {
                    a.this.g.sendMessageDelayed(message2, 500L);
                    return;
                }
                return;
            }
            c2.e(99, pVar.j());
            if (!t.V(a.this.a, pVar.t())) {
                if (a.j(pVar.t())) {
                    new a0(a.this.a, "[" + pVar.c() + "]" + a.this.a.getResources().getString(R.string.apk_version_max));
                    pVar.x(100L);
                    pVar.B(100L);
                    pVar.y(q.e);
                    pVar.z(0);
                    q.g(pVar);
                    c2.l(pVar.j());
                    return;
                }
                message2.obj = message.obj;
                message2.what = 0;
                int i3 = message.arg1 + 1;
                message2.arg1 = i3;
                if (i3 < 3000) {
                    c0.u("ZipUtils", "解压次数" + message2.arg1);
                    a.this.g.sendMessageDelayed(message2, 500L);
                } else {
                    c2.f(pVar.j(), "解压失败");
                }
                c0.u("ZipUtils", "解压后我是不完整的");
                return;
            }
            File file = new File(pVar.t());
            String str = y.C(a.this.a) + "/zip/" + pVar.j() + "/";
            c0.u("ZipUtils", "解压后我是完整的" + str);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            pVar.C(str + file.getName());
            if (file.renameTo(new File(pVar.t()))) {
                message2.what = 1;
                message2.obj = pVar;
                message2.arg1 = 1;
                c0.u("ZipUtils", "开始移动");
                a.this.g.sendMessageDelayed(message2, 100L);
                return;
            }
            c0.u("ZipUtils", "解压失败  文件名修改失败");
            f.a(a.this.a, "解压失败，请重试", f.a.f);
            c2.f(pVar.j(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ZipUtils.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ p a;
        final /* synthetic */ String b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f301c;

        b(p pVar, String str, boolean z) {
            this.a = pVar;
            this.b = str;
            this.f301c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            try {
                try {
                    x c2 = x.c();
                    c2.j(this.a.j());
                    boolean z = false;
                    int i2 = 0;
                    while (!a.this.f) {
                        try {
                            try {
                                Thread.sleep(50L);
                                i2 = a.this.b.c();
                                if (i2 > 0) {
                                    z = true;
                                }
                                if (i2 != 100) {
                                    c2.e(i2, this.a.j());
                                    this.a.x(i2);
                                    this.a.B(100L);
                                    this.a.y(q.g);
                                    q.g(this.a);
                                }
                                c0.u("ZipUtils", "解压的进度条  ---》》》》  " + i2);
                                if (i2 < 100 && (i2 != 0 || !z)) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                i = i2;
                                if (this.f301c) {
                                    new File(this.b).delete();
                                }
                                if (a.this.f && i == 0) {
                                    x.c().i(this.a.j());
                                    q.f(this.a.j());
                                    c.e(MyApplication.b()).a(this.a.j());
                                }
                                throw th;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            i = i2;
                            c0.u("ZipUtils", "解压里面的异常   ——>>>>>" + e);
                            e.printStackTrace();
                            if (this.f301c) {
                                new File(this.b).delete();
                            }
                            if (!a.this.f || i != 0) {
                                return;
                            }
                            x.c().i(this.a.j());
                            q.f(this.a.j());
                            c.e(MyApplication.b()).a(this.a.j());
                        }
                    }
                    try {
                        c0.u("ZipUtils", "加压的尺寸     " + a.this.f300c.k().size());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        c0.u("ZipUtils", "加压的尺寸     " + e2);
                    }
                    File file = new File(Environment.getExternalStorageDirectory() + "/" + a.i(this.b));
                    p pVar = this.a;
                    pVar.C(file.getAbsolutePath());
                    Message message = new Message();
                    message.obj = pVar;
                    message.what = 0;
                    message.arg1 = 1;
                    a.this.g.sendMessageDelayed(message, 500L);
                    if (this.f301c) {
                        new File(this.b).delete();
                    }
                    if (!a.this.f || i2 != 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (InterruptedException e3) {
                e = e3;
            }
            x.c().i(this.a.j());
            q.f(this.a.j());
            c.e(MyApplication.b()).a(this.a.j());
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public static boolean h(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!h(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(String str) {
        try {
            List i = new d.a.a.a.b(new File(str)).i();
            for (int i2 = 0; i2 < i.size(); i2++) {
                d.a.a.e.f fVar = (d.a.a.e.f) i.get(i2);
                if (fVar.l().indexOf(".apk") != -1) {
                    return fVar.l();
                }
            }
            return null;
        } catch (d.a.a.c.a e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean j(String str) {
        try {
            return new d.a.a.a.b(new File(str)).l();
        } catch (Exception e) {
            e.printStackTrace();
            c0.u("ZipUtils", "isZip异常" + e);
            return false;
        }
    }

    public void k() {
        this.f = true;
    }

    public void l(String str, String str2, boolean z, p pVar) {
        File file = new File(str);
        this.d = file;
        this.f300c = new d.a.a.a.b(file);
        c0.u("ZipUtils", "zip编码  1");
        String H = t.H(str);
        c0.u("ZipUtils", "zip编码  " + H);
        this.f300c.n(H);
        if (this.f300c.l()) {
            File file2 = new File(str2);
            if (file2.isDirectory() && !file2.exists()) {
                file2.mkdir();
            }
            this.b = this.f300c.j();
            Thread thread = new Thread(new b(pVar, str, z));
            this.e = thread;
            thread.start();
            this.f300c.o(true);
            this.f300c.c(str2);
            return;
        }
        throw new d.a.a.c.a("exception!");
    }
}
