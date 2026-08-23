package com.rtk.app.tool.DownLoadTool;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogDownLoadTipForInstall;
import com.rtk.app.main.dialogPack.DialogNoWifi;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.DownLoadTool.r;
import com.rtk.app.tool.DownLoadTool.t;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;

/* compiled from: DownLoadMethod.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownLoadMethod.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements t.b {
        final /* synthetic */ p a;
        final /* synthetic */ Context b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownLoadMethod.java */
        /* renamed from: com.rtk.app.tool.DownLoadTool.r$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class C0025a implements h.j {
            C0025a(a aVar) {
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                c0.u("DownLoadMethod", c0.b + "游戏下载量统计success" + str);
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
                c0.s("DownLoadMethod", c0.b + "游戏下载量统计 error" + str);
            }
        }

        a(p pVar, Context context) {
            this.a = pVar;
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void f(Context context, p pVar) {
            com.rtk.app.tool.g.c.e(context).a(pVar.j());
            c0.u("DownLoadMethod", c0.b + "第一个下载链接现在失败，现在重试");
            r.b(context, pVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void g(Context context, p pVar) {
            c0.u("DownLoadMethod", c0.b + "下载超时重新下载");
            r.b(context, pVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void h(Context context, p pVar) {
            try {
                if (com.rtk.app.tool.v.a(context, "settingInstallVALUE") && pVar.l() == null) {
                    com.rtk.app.tool.t.M1(pVar.j(), context, new com.rtk.app.tool.s[0]);
                }
            } catch (WindowManager.BadTokenException unused) {
            }
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void a(int i, String str, long j, long j2) {
            x c2 = x.c();
            this.a.y(q.f286c);
            this.a.B(100L);
            long j3 = i;
            this.a.x(j3);
            q.g(this.a);
            c2.g(100L, j3, this.a.j(), str, j, j2);
            com.rtk.app.tool.g.c.e(this.b).h(this.a.j(), q.f286c, this.a.r(), j3, 100L, this.a.d(), this.a.s());
            com.rtk.app.tool.p.a(MyApplication.b()).b((Activity) MyApplication.b(), new ApkInfo(this.a), str, i, this.a.j());
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void b() {
            c0.u("DownLoadMethod", "下载量统计进入");
            d(this.a);
            com.rtk.app.tool.p.a(MyApplication.b()).d(this.a.j());
            com.rtk.app.tool.p.a(MyApplication.b()).c((Activity) MyApplication.b(), new ApkInfo(this.a));
            c0.u("DownLoadMethod", c0.b + "下载成功");
            x c2 = x.c();
            c2.g(100L, 100L, this.a.j(), "", this.a.d(), this.a.d());
            c2.l(this.a.j());
            this.a.y(q.e);
            q.g(this.a);
            com.rtk.app.tool.g.c.e(this.b).h(this.a.j(), q.e, this.a.r(), 100L, 100L, this.a.d(), this.a.s());
            t.h(this.a.j(), q.e, new boolean[0]);
            Activity activity = (Activity) MyApplication.b();
            final Context context = this.b;
            final p pVar = this.a;
            activity.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.b
                @Override // java.lang.Runnable
                public final void run() {
                    r.a.h(context, pVar);
                }
            });
            com.rtk.app.tool.f.a(this.b, "下载完成", f.a.f);
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void c(Exception exc, String str) {
            com.rtk.app.tool.p.a(MyApplication.b()).d(this.a.j());
            t.g(this.a.j(), q.d);
            x c2 = x.c();
            this.a.y(q.d);
            q.g(this.a);
            com.rtk.app.tool.g.c.e(this.b).i(q.d, this.a.j());
            str.hashCode();
            int i = 0;
            char c3 = 65535;
            switch (str.hashCode()) {
                case -2072679632:
                    if (str.equals("找不到包资源")) {
                        c3 = 0;
                        break;
                    }
                    break;
                case -908954401:
                    if (str.equals("手机存储空间不足")) {
                        c3 = 1;
                        break;
                    }
                    break;
                case 631238758:
                    if (str.equals("下载失败")) {
                        c3 = 2;
                        break;
                    }
                    break;
                case 631644003:
                    if (str.equals("下载超时")) {
                        c3 = 3;
                        break;
                    }
                    break;
                case 1003336700:
                    if (str.equals("网络超时")) {
                        c3 = 4;
                        break;
                    }
                    break;
            }
            switch (c3) {
                case 0:
                case 2:
                    try {
                        if (this.a.g() != null) {
                            if (this.a.g().size() <= 0) {
                                return;
                            }
                            if (this.a.g().get(this.a.g().size() - 1).getUrl().equals(this.a.r())) {
                                Activity activity = (Activity) MyApplication.b();
                                final Context context = this.b;
                                activity.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.a
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.rtk.app.tool.f.a(context, "找不到资源包", f.a.f);
                                    }
                                });
                                com.rtk.app.tool.g.c.e(this.b).a(this.a.j());
                            }
                            c0.u("DownLoadMethod", c0.b + "下载失败" + this.a.toString());
                            if (this.a.g() == null || this.a.g().size() <= 1 || this.a.g().get(this.a.g().size() - 1).getUrl().equals(this.a.r())) {
                                c0.u("DownLoadMethod", c0.b + "下载失败不满足");
                                try {
                                    new File(this.a.e()).delete();
                                } catch (Exception unused) {
                                }
                            } else {
                                while (true) {
                                    if (i < this.a.g().size()) {
                                        if (this.a.g().get(i).getUrl().equals(this.a.r())) {
                                            this.a.u();
                                            Activity activity2 = (Activity) MyApplication.b();
                                            final Context context2 = this.b;
                                            final p pVar = this.a;
                                            activity2.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.d
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    r.a.f(context2, pVar);
                                                }
                                            });
                                        } else {
                                            i++;
                                        }
                                    }
                                }
                            }
                            c2.f(this.a.j(), str);
                            return;
                        }
                        return;
                    } catch (NullPointerException unused2) {
                        return;
                    }
                case 1:
                    c0.u("DownLoadMethod", c0.b + " onDownloadFailed手机内存不足");
                    com.rtk.app.tool.f.a(this.b, "手机内存不足", f.a.f);
                    com.rtk.app.tool.g.c.e(this.b).a(this.a.j());
                    q.f(this.a.j());
                    c2.f(this.a.j(), str);
                    return;
                case 3:
                    c0.u("DownLoadMethod", c0.b + "下载失败了，超时");
                    if (this.a.i() < 3) {
                        p pVar2 = this.a;
                        pVar2.z(pVar2.i() + 1);
                        Activity activity3 = (Activity) MyApplication.b();
                        final Context context3 = this.b;
                        final p pVar3 = this.a;
                        activity3.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                r.a.g(context3, pVar3);
                            }
                        });
                        return;
                    }
                    c0.u("DownLoadMethod", c0.b + "我下载超时停止下载");
                    c2.f(this.a.j(), str);
                    return;
                case 4:
                    c2.f(this.a.j(), str);
                    return;
                default:
                    return;
            }
        }

        public void d(p pVar) {
            String sb;
            String str;
            c0.u("DownLoadMethod", c0.b + "游戏下载量统计 gameId:" + pVar.j());
            Context b = MyApplication.b();
            C0025a c0025a = new C0025a(this);
            if (pVar.q() != 0 && pVar.j() > 10000000) {
                if (com.rtk.app.tool.y.x(b)) {
                    str = "&uid=" + com.rtk.app.tool.y.I(b) + "&token=" + com.rtk.app.tool.y.G(b);
                } else {
                    str = "";
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/countDownNumNew");
                sb2.append(com.rtk.app.tool.y.u(b));
                sb2.append(str);
                sb2.append("&sid=");
                sb2.append(pVar.q());
                sb2.append("&device_id=");
                sb2.append(com.rtk.app.tool.y.o(b));
                sb2.append("&device_name=");
                sb2.append(com.rtk.app.tool.y.p(b));
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(c0.e(com.rtk.app.tool.y.v(b, "sid=" + pVar.q(), "device_id=" + com.rtk.app.tool.y.o(b), "device_name=" + com.rtk.app.tool.y.p(b)))));
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("game/gameDownloadUpdate");
                sb3.append(com.rtk.app.tool.y.u(b));
                sb3.append("&game_id=");
                sb3.append(pVar.j());
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(c0.e(com.rtk.app.tool.y.v(b, "game_id=" + pVar.j()))));
                sb = sb3.toString();
            }
            com.rtk.app.tool.o.h.l(b, c0025a, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void onDownloadStart() {
            x.c().j(this.a.j());
            this.a.y(q.f286c);
            q.g(this.a);
            com.rtk.app.tool.p.a((Activity) MyApplication.b()).e((Activity) MyApplication.b(), new ApkInfo(this.a), this.a.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, ApkInfo apkInfo) {
        c0.u("DownLoadMethod", c0.b + "btuDownloadPrivateMethod in");
        if (com.rtk.app.tool.t.M(context) != 0) {
            if (apkInfo.getNeed_share() != null && apkInfo.getNeed_share().equals("1")) {
                String d = com.rtk.app.tool.v.d(context, "IsShareStr");
                if (c0.q(d)) {
                    com.rtk.app.tool.t.y1(context, apkInfo);
                    return;
                }
                String[] split = d.split(";");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].equals(apkInfo.getGameId() + "")) {
                        f(context, apkInfo);
                        return;
                    } else {
                        if (i == split.length) {
                            com.rtk.app.tool.t.y1(context, apkInfo);
                        }
                    }
                }
                return;
            }
            f(context, apkInfo);
            return;
        }
        com.rtk.app.tool.f.a(context, "网络断开", f.a.f);
    }

    public static void b(Context context, p pVar) {
        String str;
        c0.u("DownLoadMethod", c0.b + "downLoadHttp in");
        if (pVar.r().endsWith(".apk")) {
            pVar.A(1);
        } else if (pVar.r().endsWith(".zip")) {
            pVar.A(0);
        }
        if (pVar.m() == 1) {
            str = com.rtk.app.tool.y.C(context) + "/apk/" + pVar.j() + ".apk";
        } else {
            str = com.rtk.app.tool.y.C(context) + "/zip/" + pVar.j() + "/" + pVar.j() + ".zip";
        }
        String str2 = str;
        pVar.w(str2);
        pVar.y(q.f286c);
        com.rtk.app.tool.g.c.e(context).f(pVar);
        x.c().j(pVar.j());
        q.a(pVar);
        c0.u("DownLoadMethod", c0.b + "下载地址:" + str2 + " isApk:" + pVar.m() + " 版本:" + pVar.s());
        long j = 0;
        try {
            File file = new File(str2);
            if (file.exists()) {
                if (file.isDirectory()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
            } else {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (com.rtk.app.tool.t.V(context, str2)) {
                file.delete();
                file.getParentFile().mkdirs();
                file.createNewFile();
            } else {
                j = file.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.e().c(pVar, str2, new a(pVar, context), j);
    }

    public static void c(final Context context, final p pVar) {
        c0.u("DownLoadMethod", c0.b + "downLoadHttpVerifyWifi downList.size:" + pVar.g().size());
        if (!com.rtk.app.tool.v.a(context, "settingNoWifiVALUE")) {
            c0.u("DownLoadMethod", "流量下载但本地设置为不提示");
            b(context, pVar);
        } else if (com.rtk.app.tool.t.M(context) == 2) {
            new DialogNoWifi(MyApplication.b(), new com.rtk.app.tool.s() { // from class: com.rtk.app.tool.DownLoadTool.f
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    r.b(context, pVar);
                }
            }).show();
        } else {
            b(context, pVar);
        }
    }

    public static void f(Context context, ApkInfo apkInfo) {
        c0.u("DownLoadMethod", c0.b + "setDownLoad in");
        if (apkInfo.getDownlist() != null && apkInfo.getDownlist().size() != 0) {
            c(context, new p(apkInfo, 0));
            return;
        }
        com.rtk.app.tool.f.a(context, "下载目录为空", f.a.f);
        c0.s("DownLoadMethod", c0.b + "下载目录为空");
    }

    public static void g(final Context context, final ApkInfo apkInfo, TextView textView) {
        c0.u("DownLoadMethod", c0.b + "setDownloadEvent");
        String trim = textView.getText().toString().trim();
        trim.hashCode();
        char c2 = 65535;
        switch (trim.hashCode()) {
            case 656082:
                if (trim.equals("下载")) {
                    c2 = 0;
                    break;
                }
                break;
            case 761436:
                if (trim.equals("安装")) {
                    c2 = 1;
                    break;
                }
                break;
            case 804621:
                if (trim.equals("打开")) {
                    c2 = 2;
                    break;
                }
                break;
            case 843068:
                if (trim.equals("更新")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1039590:
                if (trim.equals("继续")) {
                    c2 = 4;
                    break;
                }
                break;
            case 20844108:
                if (trim.equals("准备中")) {
                    c2 = 5;
                    break;
                }
                break;
            case 34605349:
                if (trim.equals("解压中")) {
                    c2 = 6;
                    break;
                }
                break;
            case 808769937:
                if (trim.equals("敬请期待")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1137621909:
                if (trim.equals("重新下载")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
            case '\b':
                if (apkInfo.getDownlist() == null) {
                    c0.s("DownLoadMethod", c0.b + "setDownloadEvent: downList is null");
                    return;
                }
                if (apkInfo.getIsApk() != 1) {
                    if (!com.rtk.app.tool.r.b(context)) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 30 && com.rtk.app.tool.r.c(context)) {
                        return;
                    }
                }
                if (apkInfo.getInstallation() == null || !apkInfo.getInstallation().isOnlyWay2() || com.rtk.app.tool.r.b(context)) {
                    if (apkInfo.getDownlist().get(0).getIs_prompt() == 1) {
                        new DialogDownLoadTipForInstall(context, apkInfo.getDownlist().get(0), new com.rtk.app.tool.s() { // from class: com.rtk.app.tool.DownLoadTool.e
                            @Override // com.rtk.app.tool.s
                            public final void a(String[] strArr) {
                                r.a(context, apkInfo);
                            }
                        }).show();
                        return;
                    } else {
                        a(context, apkInfo);
                        return;
                    }
                }
                return;
            case 1:
                com.rtk.app.tool.p.a(context).d(apkInfo.getGameId());
                p d = q.d(apkInfo.getGameId());
                c0.u("DownLoadMethod", c0.b + "info.getPackageName():" + d.n());
                com.rtk.app.tool.t.M1(d.j(), context, new com.rtk.app.tool.s[0]);
                return;
            case 2:
                com.rtk.app.tool.t.A1(context, apkInfo.getPackageName());
                return;
            case 4:
                if (com.rtk.app.tool.t.M(context) != 0) {
                    c0.u("DownLoadMethod", c0.b + "DownloadInfo 游戏包名:" + apkInfo.getPackageName());
                    p d2 = q.d(apkInfo.getGameId());
                    if (d2 != null) {
                        c(context, d2);
                        return;
                    } else {
                        com.rtk.app.tool.f.a(context, "info为空", f.a.f);
                        return;
                    }
                }
                com.rtk.app.tool.f.a(context, "网络断开", f.a.f);
                return;
            case 5:
                com.rtk.app.tool.f.a(context, "准备中！请稍后...", f.a.f);
                return;
            case 6:
            case 7:
                return;
            default:
                t.h(apkInfo.getGameId(), q.d, new boolean[0]);
                com.rtk.app.tool.p.a((Activity) MyApplication.b()).d(apkInfo.getGameId());
                x.c().k(apkInfo.getGameId());
                com.rtk.app.tool.g.c.e(context).i(q.d, apkInfo.getGameId());
                return;
        }
    }

    public static void h(Context context, ApkInfo apkInfo, TextView textView, ProgressBar progressBar) {
        p d = q.d(apkInfo.getGameId());
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        if (apkInfo.getDownlist() != null && apkInfo.getDownlist().size() >= 1) {
            textView.setBackgroundColor(context.getResources().getColor(R.color.transparency));
            if (d != null && d.j() == apkInfo.getGameId()) {
                int h = d.h();
                if (h != 0) {
                    if (h == 1) {
                        n(textView, progressBar, d);
                        return;
                    }
                    if (h == 2) {
                        j(textView, progressBar, d);
                        return;
                    }
                    if (h == 3) {
                        if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName()) && apkInfo.getVersion_code() <= com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                            p(textView, progressBar);
                            return;
                        } else {
                            m(textView, progressBar);
                            return;
                        }
                    }
                    if (h != 4) {
                        if (h == 5) {
                            n(textView, progressBar, d);
                            textView.setText("解压中");
                            return;
                        } else if (h != 11) {
                            k(context, textView, progressBar);
                            return;
                        } else {
                            r(textView, progressBar, d);
                            return;
                        }
                    }
                }
                if (!com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
                    k(context, textView, progressBar);
                    return;
                } else if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                    q(textView, progressBar);
                    return;
                } else {
                    p(textView, progressBar);
                    return;
                }
            }
            if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
                if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                    q(textView, progressBar);
                    return;
                } else {
                    p(textView, progressBar);
                    q.a(new p(apkInfo.getGameId(), apkInfo.getPackageName(), apkInfo.getAppName(), null, q.f, apkInfo.getIcon_url(), 1, apkInfo.getVersion_code()));
                    return;
                }
            }
            k(context, textView, progressBar);
            return;
        }
        o(context, textView, progressBar);
    }

    public static void i(int i, Context context, ApkInfo apkInfo, TextView textView, ProgressBar progressBar) {
        c0.u("DownLoadMethod", c0.b + "setDownloadStateForDetails in");
        p d = q.d(((Integer) textView.getTag()).intValue());
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        textView.setBackgroundColor(context.getResources().getColor(R.color.transparency));
        if (d != null && d.j() == apkInfo.getGameId()) {
            int h = d.h();
            if (h == 0) {
                k(context, textView, progressBar);
                return;
            }
            if (h == 1) {
                n(textView, progressBar, d);
                return;
            }
            if (h == 2) {
                j(textView, progressBar, d);
                return;
            }
            if (h == 3) {
                m(textView, progressBar);
                return;
            }
            if (h != 4) {
                if (h == 5) {
                    n(textView, progressBar, d);
                    textView.setText("解压中");
                    return;
                } else if (h != 11) {
                    k(context, textView, progressBar);
                    return;
                } else {
                    r(textView, progressBar, d);
                    return;
                }
            }
            if (!com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
                k(context, textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                q(textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() == com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                if (i != 1) {
                    p(textView, progressBar);
                    return;
                } else if (!c0.q(d.e()) && new File(d.e()).exists()) {
                    m(textView, progressBar);
                    return;
                } else {
                    l(textView, progressBar);
                    return;
                }
            }
            return;
        }
        if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
            if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                q(textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() < com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                k(context, textView, progressBar);
                return;
            } else if (i == 1) {
                l(textView, progressBar);
                return;
            } else {
                p(textView, progressBar);
                q.a(new p(apkInfo.getGameId(), apkInfo.getPackageName(), apkInfo.getAppName(), null, q.f, apkInfo.getIcon_url(), 1, apkInfo.getVersion_code()));
                return;
            }
        }
        if (apkInfo.getDownlist() != null && apkInfo.getDownlist().size() >= 1) {
            k(context, textView, progressBar);
            return;
        }
        c0.s("DownLoadMethod", c0.b + "setDownloadStateForDetails downList is null");
        o(context, textView, progressBar);
    }

    private static void j(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText("继续");
        progressBar.setProgress((int) pVar.f());
    }

    private static void k(Context context, TextView textView, ProgressBar progressBar) {
        textView.setText("下载");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void l(TextView textView, ProgressBar progressBar) {
        textView.setText("重新下载");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void m(TextView textView, ProgressBar progressBar) {
        textView.setText("安装");
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(100);
    }

    private static void n(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText(R.string.download_wait);
        progressBar.setProgress((int) pVar.f());
    }

    private static void o(Context context, TextView textView, ProgressBar progressBar) {
        textView.setText("敬请期待");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
        textView.setBackgroundColor(context.getResources().getColor(R.color.btuTheme));
    }

    private static void p(TextView textView, ProgressBar progressBar) {
        textView.setText("打开");
        progressBar.setSecondaryProgress(100);
    }

    private static void q(TextView textView, ProgressBar progressBar) {
        textView.setText("更新");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void r(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText("等待中");
        progressBar.setProgress((int) pVar.f());
    }
}
