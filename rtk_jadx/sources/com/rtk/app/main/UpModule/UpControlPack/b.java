package com.rtk.app.main.UpModule.UpControlPack;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.bean.UpZipBean;
import com.rtk.app.bean.UpZipLastBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.UpGameActivity;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.main.dialogPack.DialogJustEnsure;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.g.g;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.k;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UpGamePoolControl.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static List<g> f216c = new ArrayList();
    private static b d;
    private Map<String, UpApkBean> a = new HashMap();
    private Map<String, h.j> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpGamePoolControl.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends TimerTask {
        final /* synthetic */ int a;

        a(b bVar, int i) {
            this.a = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            g gVar = (g) b.f216c.get(this.a);
            if (gVar.u() == 0 && !n.e.contains(gVar.n()) && !k.i().t(gVar.n())) {
                c0.u("UP_TAG UpGamePoolControl", "有压缩包在后台传输");
                String z = gVar.z();
                if (c0.q(z)) {
                    String n = gVar.n();
                    int e = f.e(MyApplication.b()).i(n).e();
                    k.i().r(b.m(n), y.i + y.k, 0, e, n, true);
                } else {
                    int f = f.e(MyApplication.b()).j(z).f();
                    n.p(b.m(z), y.i + "html/filelist/appsUploadDataBag", 0, f, z, gVar.A(), true);
                }
            } else {
                c0.s("UP_TAG UpGamePoolControl", "upLoadApkInfo.getUp_load_state():" + gVar.u());
            }
            cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpGamePoolControl.java */
    /* renamed from: com.rtk.app.main.UpModule.UpControlPack.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0021b implements h.j {
        final /* synthetic */ String a;

        C0021b(String str) {
            this.a = str;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            g gVar;
            c0.u("UP_TAG UpGamePoolControl", "  上传apk文件 在后台的回调成功  ");
            Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
            g i2 = f.e(MyApplication.b()).i(this.a);
            g j = f.e(MyApplication.b()).j(this.a);
            if (i2 != null) {
                UpApkBean upApkBean = (UpApkBean) create.fromJson(str, UpApkBean.class);
                f.e(MyApplication.b()).q(this.a, upApkBean);
                if (!b.i().o(this.a)) {
                    if (((Activity) MyApplication.b()).getLocalClassName().contains("UpGameActivity")) {
                        ((UpGameActivity) MyApplication.b()).q.K(upApkBean);
                        b.i().a.put(this.a, upApkBean);
                        return;
                    }
                    return;
                }
                gVar = f.e(MyApplication.b()).i(this.a);
            } else if (j != null) {
                UpZipBean upZipBean = (UpZipBean) create.fromJson(str, UpZipBean.class);
                c0.u("UP_TAG UpGamePoolControl", "将服务器返回的地址保存起来" + upZipBean.getDataPath());
                f.e(MyApplication.b()).A(upZipBean);
                gVar = f.e(MyApplication.b()).j(this.a);
            } else {
                gVar = null;
            }
            h.j(MyApplication.b(), b.c(), y.e + "up/save/add", gVar.E(), b.k(gVar));
            b.i().b.remove(this.a);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            g i3 = f.e(MyApplication.b()).i(this.a);
            c0.u("UP_TAG UpGamePoolControl", "上传失败原因" + str + "   md5--  " + this.a);
            if (i3 != null) {
                if (f.e(MyApplication.b()).i(this.a) == null) {
                    c0.s("UP_TAG UpGamePoolControl", "upLoadApkInfo is null ");
                    return;
                }
                f.e(MyApplication.b()).w(this.a, 1, 100);
                f.e(MyApplication.b()).v("uid" + y.K() + "_apk_" + System.currentTimeMillis(), this.a);
                if (i == k.k) {
                    return;
                }
                k.i().r(this, y.i + y.k, 0, 1, this.a, true);
                return;
            }
            g j = f.e(MyApplication.b()).j(this.a);
            if (j == null) {
                c0.s("UP_TAG UpGamePoolControl", "upLoadApkInfoZip is null ");
                return;
            }
            f.e(MyApplication.b()).x(this.a, 1, 100);
            String str2 = "uid" + y.K() + "_zip_" + System.currentTimeMillis();
            f.e(MyApplication.b()).z(this.a, str2);
            if (i == k.k) {
                return;
            }
            n.p(this, y.i + "html/filelist/appsUploadDataBag", 0, 1, j.z(), str2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpGamePoolControl.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c implements h.j {

        /* compiled from: UpGamePoolControl.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements s {
            final /* synthetic */ int a;

            a(c cVar, int i) {
                this.a = i;
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                g g = f.e(MyApplication.b()).g(this.a);
                h.j(MyApplication.b(), b.c(), y.e + "up/save/add", g.E(), b.k(g));
            }
        }

        c() {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            g g = f.e(MyApplication.b()).g(i);
            f.e(MyApplication.b()).n(g.n());
            c0.u("UP_TAG UpGamePoolControl", "上传成功，发布游戏也成功");
            com.rtk.app.tool.f.a(MyApplication.b(), "文件上传成功。", f.a.f);
            if (MyApplication.b().getClass().toString().contains("UpLoadPoolControlActivity")) {
                ((UpLoadPoolControlActivity) MyApplication.b()).M();
            }
            if (g == null || c0.q(g.z())) {
                return;
            }
            com.rtk.app.tool.g.f.e(MyApplication.b()).o(g.z());
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            try {
                c0.u("UP_TAG UpGamePoolControl", "上传文件的id:" + i2);
                g gVar = null;
                if (i == 3005 || i == 3016) {
                    com.rtk.app.tool.f.a(MyApplication.b(), str, f.a.f);
                } else if (i != 9106) {
                    com.rtk.app.tool.f.a(MyApplication.b(), "上传成功，但发布失败，点击确定重新发布", f.a.f);
                    gVar = com.rtk.app.tool.g.f.e(MyApplication.b()).g(i2);
                    new DialogJustEnsure(MyApplication.b(), "[" + gVar.c() + "]上传失败，请重新上传。", new a(this, i2)).show();
                } else {
                    gVar = com.rtk.app.tool.g.f.e(MyApplication.b()).g(i2);
                    com.rtk.app.tool.g.f.e(MyApplication.b()).n(gVar.n());
                    c0.u("UP_TAG UpGamePoolControl", "上传成功，发布游戏也成功");
                    com.rtk.app.tool.f.a(MyApplication.b(), "" + str, f.a.f);
                    if (MyApplication.b().getClass().toString().contains("UpLoadPoolControlActivity")) {
                        ((UpLoadPoolControlActivity) MyApplication.b()).M();
                    }
                }
                if (gVar != null && !c0.q(gVar.z())) {
                    com.rtk.app.tool.g.f.e(MyApplication.b()).o(gVar.z());
                }
            } catch (Exception unused) {
            }
            c0.u("UP_TAG UpGamePoolControl", "后台传输并且上传信息失败backgroundUpSrcInformation()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpGamePoolControl.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements h.j {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f217c;
        final /* synthetic */ String d;
        final /* synthetic */ g e;
        final /* synthetic */ h.j f;
        final /* synthetic */ Map g;

        d(b bVar, String str, int i, int i2, String str2, g gVar, h.j jVar, Map map) {
            this.a = str;
            this.b = i;
            this.f217c = i2;
            this.d = str2;
            this.e = gVar;
            this.f = jVar;
            this.g = map;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            com.rtk.app.tool.g.f.e(MyApplication.b()).y(this.a, this.b, this.f217c, this.d);
            b.i().s(this.e);
            g k = com.rtk.app.tool.g.f.e(MyApplication.b()).k(this.a);
            com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).b((Activity) MyApplication.b(), k, (((this.b - 1) * 100) / this.f217c) + "%", ((this.b - 1) * 100) / this.f217c);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c((long) this.f217c, (long) (this.b + (-1)), this.e.y());
            com.rtk.app.tool.f.a(MyApplication.b(), "上传成功", f.a.f);
            c0.u("UP_TAG UpGamePoolControl", "zip上传成功:" + str);
            if (b.i().o(this.a)) {
                c0.u("UP_TAG UpGamePoolControl", "上传成功在线程池里");
                b.m(this.a).d(str, i);
                com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(this.e);
                try {
                    ((UpLoadPoolControlActivity) MyApplication.b()).M();
                } catch (Exception e) {
                    c0.u("UP_TAG UpGamePoolControl", "刷新线程池界面异常" + e.toString());
                }
                b.i().q(this.a);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.e.y());
                com.rtk.app.tool.g.f e2 = com.rtk.app.tool.g.f.e(MyApplication.b());
                String str2 = this.a;
                int i2 = this.f217c;
                e2.x(str2, i2, i2);
            } else {
                c0.u("UP_TAG UpGamePoolControl", "上传成功不在线程池里");
                this.f.d(str, i);
                com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(this.e);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.e.y());
                com.rtk.app.tool.g.f.e(MyApplication.b()).y(this.a, this.b, this.f217c, this.d);
            }
            b.i().r();
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            c0.u("UP_TAG UpGamePoolControl", "请求数据合成失败" + i + "  str  " + str);
            if (i != 1 && i != 5 && i != 9106) {
                h.m(MyApplication.b(), this, y.i + y.l, i2, this.g);
                return;
            }
            this.f.g(i, str, i2);
        }
    }

    static /* synthetic */ h.j c() {
        return g();
    }

    private static h.j g() {
        return new c();
    }

    public static b i() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    public static Map<String, String> k(g gVar) {
        if (gVar != null && gVar.t() != null) {
            UpApkBean t = gVar.t();
            String h = gVar.h();
            String g = gVar.g();
            String d2 = gVar.d();
            StringBuilder sb = new StringBuilder();
            sb.append(gVar.s());
            String str = "";
            sb.append("");
            String sb2 = sb.toString();
            String str2 = gVar.r() + "";
            String c2 = gVar.c();
            String k = gVar.k();
            int x = gVar.x();
            HashMap hashMap = new HashMap();
            hashMap.put("channel", y.m(MyApplication.b(), MyApplication.b().getPackageName()));
            hashMap.put("version", y.i(MyApplication.b()));
            hashMap.put(ak.aj, y.g());
            hashMap.put("phone_model", y.T());
            hashMap.put("uid", y.K());
            hashMap.put("token", y.H());
            hashMap.put(com.umeng.analytics.pro.d.y, sb2);
            hashMap.put("tags", str2);
            hashMap.put("sourceName", c2);
            hashMap.put("sourceSize", t.getSourceSize() + "");
            hashMap.put("sourceDescription", g);
            hashMap.put("md5", t.getMd5());
            hashMap.put("apkmd5", t.getApkmd5());
            hashMap.put("diN", y.r(MyApplication.b()));
            hashMap.put("sourcePic", k);
            hashMap.put(ak.y, y.D());
            hashMap.put("versionName", t.getVersionName());
            hashMap.put("versionCode", t.getVersionCode());
            hashMap.put("otherVersion", t.getOtherVersion());
            hashMap.put("packageName", t.getPackageName());
            hashMap.put("varName", h);
            hashMap.put("sourcePath", t.getSourcePath());
            hashMap.put("sourceCharacteristic", d2);
            hashMap.put("deviceName", y.p(MyApplication.b()));
            hashMap.put("sha256", t.getSha256());
            hashMap.put("sourceLogo", t.getSourceLogo());
            hashMap.put("sha1", t.getSha1());
            hashMap.put(PointCategory.PERMISSION, t.getPermission());
            hashMap.put("targetVersion", t.getTargetVersion());
            hashMap.put("sdkVersion", t.getSdkVersion());
            hashMap.put("apkJsonData", t.getJsonData());
            hashMap.put("viewPermissions", x + "");
            hashMap.put("family_id", "0");
            hashMap.put("needCoin", "0");
            if (!c0.q(gVar.z())) {
                c0.u("UP_TAG UpGamePoolControl", "发布APK时增加的参数 服务器zip保存地址  " + gVar.B() + "\nzipMd5" + gVar.z());
                hashMap.put("dataPath", gVar.B());
                hashMap.put("zipmd5", gVar.z());
                hashMap.put("dataSize", "" + gVar.C());
                hashMap.put("zipType", gVar.t().getZipType() + "");
                hashMap.put("zipKey", gVar.t().getZipKey());
                hashMap.put("zipSecTrans", gVar.t().getZipSecTrans() + "");
                hashMap.put("apkType", gVar.t().getApkType() + "");
                hashMap.put("apkKey", gVar.t().getApkKey());
                hashMap.put("apkSecTrans", gVar.t().getApkSecTrans() + "");
            } else {
                hashMap.put("apkType", gVar.t().getApkType() + "");
                hashMap.put("apkKey", gVar.t().getApkKey());
                hashMap.put("apkSecTrans", gVar.t().getApkSecTrans() + "");
            }
            if (!TextUtils.isEmpty(gVar.i())) {
                hashMap.put("family_id", gVar.i());
            }
            hashMap.put("needCoin", gVar.p() + "");
            hashMap.put("key", t.c0(c0.e(y.v(MyApplication.b(), "uid=" + y.K(), "token=" + y.H(), "sourcePath=" + t.getSourcePath(), "varName=" + h, "apkmd5=" + t.getApkmd5()))));
            for (String str3 : hashMap.keySet()) {
                str = str + "   " + str3 + "  " + ((String) hashMap.get(str3)) + UMCustomLogInfoBuilder.LINE_SEP;
            }
            c0.u("UP_TAG UpGamePoolControl", "上传数据 upApkMap---\n" + str);
            return hashMap;
        }
        c0.s("UP_TAG UpGamePoolControl", "upLoadApkInfo or getUpApkBean is null");
        return new ArrayMap();
    }

    public static h.j m(String str) {
        c0.u("UP_TAG UpGamePoolControl", "进入后台传输的回调" + str);
        h.j jVar = i().b.get(str);
        if (jVar != null) {
            return jVar;
        }
        C0021b c0021b = new C0021b(str);
        i().b.put(str, c0021b);
        return c0021b;
    }

    public synchronized void e(String str) {
        c0.u("UP_TAG UpGamePoolControl", "放入后台" + str);
        com.rtk.app.tool.g.f.e(MyApplication.b()).s(str, 1);
        f216c.add(com.rtk.app.tool.g.f.e(MyApplication.b()).i(str));
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().d(f216c.size());
        Iterator<g> it = f216c.iterator();
        while (it.hasNext()) {
            c0.u("UP_TAG UpGamePoolControl", f216c.size() + "当前线程池里保留的" + it.next().n());
        }
    }

    public synchronized void f(String str) {
        c0.u("UP_TAG UpGamePoolControl", "放入后台" + str);
        com.rtk.app.tool.g.f.e(MyApplication.b()).u(str, 1);
        f216c.add(com.rtk.app.tool.g.f.e(MyApplication.b()).j(str));
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().d(f216c.size());
        Iterator<g> it = f216c.iterator();
        while (it.hasNext()) {
            c0.u("UP_TAG UpGamePoolControl", f216c.size() + "当前线程池里保留的" + it.next().z());
        }
    }

    public boolean h(Context context, String str, String str2, Boolean bool, String str3, int i) {
        if (c0.q(str)) {
            com.rtk.app.tool.f.a(context, "请填写资源名称", f.a.f);
            return false;
        }
        if (!c0.q(str2) && str2.length() >= 2) {
            if (!bool.booleanValue()) {
                com.rtk.app.tool.f.a(context, "请阅读并同意《UP资源功能使用协议》", f.a.f);
                return false;
            }
            if (c0.q(str3)) {
                com.rtk.app.tool.f.a(context, "请选择资源类型", f.a.f);
                return false;
            }
            if (i >= 2) {
                return true;
            }
            com.rtk.app.tool.f.a(context, "请至少上传两张截图", f.a.f);
            return false;
        }
        com.rtk.app.tool.f.a(context, "请填写资源介绍(2-1000个字)", f.a.f);
        return false;
    }

    public int j() {
        return f216c.size();
    }

    public UpApkBean l(String str) {
        UpApkBean upApkBean = this.a.get(str);
        return upApkBean == null ? com.rtk.app.tool.g.f.e(MyApplication.b()).f(str) : upApkBean;
    }

    public void n() {
        try {
            f216c.clear();
            f216c.addAll(com.rtk.app.tool.g.f.e(MyApplication.b()).c());
            c0.u("UP_TAG UpGamePoolControl", "上传列表长度  " + f216c.size());
            for (int i = 0; i < f216c.size() && i <= y.r; i++) {
                Timer timer = new Timer();
                c0.u("UP_TAG UpGamePoolControl", "后台上传的数据" + f216c.get(i).toString());
                timer.schedule(new a(this, i), 6000L);
            }
        } catch (Exception unused) {
            com.rtk.app.tool.f.a(MyApplication.b(), "initUpApkBackground异常", f.a.f);
        }
    }

    public boolean o(String str) {
        for (g gVar : f216c) {
            if (gVar.n().equalsIgnoreCase(str) || gVar.z().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void p(String str) {
        try {
            com.rtk.app.tool.g.f.e(MyApplication.b()).s(str, 0);
            for (g gVar : f216c) {
                if (gVar.n().equalsIgnoreCase(str) || gVar.z().equalsIgnoreCase(str)) {
                    f216c.remove(gVar);
                    com.rtk.app.main.UpModule.UpControlPack.c.a.b().d(f216c.size());
                    break;
                }
            }
            if (((Activity) MyApplication.b()).getClass().toString().trim().contains("UpLoadPoolControlActivity")) {
                ((UpLoadPoolControlActivity) MyApplication.b()).t.sendEmptyMessage(1);
            }
        } catch (Exception unused) {
            c0.u("UP_TAG UpGamePoolControl", "移除失败");
        }
    }

    public synchronized void q(String str) {
        try {
            g j = com.rtk.app.tool.g.f.e(MyApplication.b()).j(str);
            com.rtk.app.tool.g.f.e(MyApplication.b()).u(str, 0);
            for (g gVar : f216c) {
                if (gVar.z().equalsIgnoreCase(str) || gVar.n().equalsIgnoreCase(j.n())) {
                    f216c.remove(gVar);
                    com.rtk.app.main.UpModule.UpControlPack.c.a.b().d(f216c.size());
                    break;
                }
            }
            if (((Activity) MyApplication.b()).getClass().toString().trim().contains("UpLoadPoolControlActivity")) {
                ((UpLoadPoolControlActivity) ((Activity) MyApplication.b())).t.sendEmptyMessage(1);
            }
        } catch (Exception unused) {
            c0.u("UP_TAG UpGamePoolControl", "移除失败");
        }
    }

    public void r() {
        if (n.e.size() + k.i().u() > y.r) {
            c0.t("UP_TAG UpGamePoolControl", "startNextUpForBack 当前上传线程池尺寸已最大");
            return;
        }
        for (g gVar : f216c) {
            String z = gVar.z();
            if (c0.q(z)) {
                if (!k.i().t(gVar.n()) && gVar.u() == 0) {
                    String n = gVar.n();
                    int e = com.rtk.app.tool.g.f.e(MyApplication.b()).i(n).e();
                    k.i().r(m(n), y.i + y.k, 0, e, n, false);
                    return;
                }
            } else if (n.e.contains(gVar.z())) {
                continue;
            } else {
                c0.u("UP_TAG UpGamePoolControl", "不在上传中准备开始:" + gVar.E() + " 以及他的状态" + gVar.v());
                if (gVar.v() == 0) {
                    int f = com.rtk.app.tool.g.f.e(MyApplication.b()).j(z).f();
                    n.p(m(z), y.i + "html/filelist/appsUploadDataBag", 0, f, z, gVar.A(), false);
                    return;
                }
            }
        }
    }

    public void s(g gVar) {
        for (int i = 0; i < f216c.size(); i++) {
            if (f216c.get(i).E() == gVar.E()) {
                f216c.get(i).H(gVar.e());
                f216c.get(i).F(gVar.a());
                f216c.get(i).K(gVar.u());
                return;
            }
        }
    }

    public void t(g gVar) {
        for (int i = 0; i < f216c.size(); i++) {
            if (f216c.get(i).E() == gVar.E()) {
                f216c.get(i).I(gVar.f());
                f216c.get(i).G(gVar.b());
                f216c.get(i).L(gVar.v());
                f216c.get(i).N(gVar.C());
                return;
            }
        }
    }

    public void u(String str, String str2, int i, g gVar, h.j jVar, int i2, int i3, String str3) {
        UpZipLastBean upZipLastBean = (UpZipLastBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str2, UpZipLastBean.class);
        HashMap hashMap = new HashMap();
        hashMap.put("total", upZipLastBean.getTotal());
        hashMap.put("currentmd5", upZipLastBean.getCurrentmd5());
        hashMap.put("md5", upZipLastBean.getMd5());
        hashMap.put("oldname", upZipLastBean.getOldname());
        hashMap.put("newname", upZipLastBean.getNewname());
        d dVar = new d(this, str, i2, i3, str3, gVar, jVar, hashMap);
        c0.u("UP_TAG UpGamePoolControl", "请求数据合成接口被请求");
        h.m(MyApplication.b(), dVar, y.i + y.l, i, hashMap);
    }
}
