package com.rtk.app.tool.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.AdBean;
import com.rtk.app.bean.UpByCheckBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogDownLoadTipForInstall;
import com.rtk.app.main.dialogPack.DialogNoWifi;
import com.rtk.app.main.dialogPack.DialogProgressForRewardVideoAdTip;
import com.rtk.app.main.dialogPack.DialogTipsForCallBack;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.DownLoadTool.p;
import com.rtk.app.tool.DownLoadTool.q;
import com.rtk.app.tool.DownLoadTool.t;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.i.i;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.r;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.reward.WMRewardAd;
import com.windmill.sdk.reward.WMRewardAdListener;
import com.windmill.sdk.reward.WMRewardAdRequest;
import com.windmill.sdk.reward.WMRewardInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: DownLoadMethodForUp.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private static Gson a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownLoadMethodForUp.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements WMRewardAdListener {
        final /* synthetic */ AdBean.DataDTO.DownAdDTO a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f309c;
        final /* synthetic */ WMRewardAd d;
        final /* synthetic */ Activity e;
        final /* synthetic */ DialogProgressForRewardVideoAdTip f;

        a(AdBean.DataDTO.DownAdDTO downAdDTO, Context context, int i, WMRewardAd wMRewardAd, Activity activity, DialogProgressForRewardVideoAdTip dialogProgressForRewardVideoAdTip) {
            this.a = downAdDTO;
            this.b = context;
            this.f309c = i;
            this.d = wMRewardAd;
            this.e = activity;
            this.f = dialogProgressForRewardVideoAdTip;
        }

        public void a() {
            int intValue = this.a.getContinuedTime().intValue();
            v.e(this.b, "overTask" + this.f309c, Boolean.TRUE);
            v.g(this.b, "adOverTaskTime", Long.valueOf(System.currentTimeMillis() + ((long) (intValue * BaseConstants.Time.MINUTE))));
        }

        public void onVideoAdClicked(AdInfo adInfo) {
            c0.r("DownLoadMethodForUp", "onVideoAdClicked,adInfo:" + adInfo);
        }

        public void onVideoAdClosed(AdInfo adInfo) {
            c0.r("DownLoadMethodForUp", "onVideoAdClosed,adInfo:" + adInfo);
        }

        public void onVideoAdLoadError(WindMillError windMillError, String str) {
            c0.r("DownLoadMethodForUp", "onVideoAdLoadError,windMillError:" + windMillError + ",s:" + str);
            this.f.dismiss();
            com.rtk.app.tool.f.a(this.e, "视频播放失败，您可直接下载~", f.a.f);
            a();
        }

        public void onVideoAdLoadSuccess(String str) {
            c0.r("DownLoadMethodForUp", "onVideoAdLoadSuccess,placementId:" + str);
            a();
            WMRewardAd wMRewardAd = this.d;
            if (wMRewardAd != null && wMRewardAd.isReady()) {
                this.d.show(this.e, new HashMap());
            }
            this.f.dismiss();
        }

        public void onVideoAdPlayEnd(AdInfo adInfo) {
            c0.r("DownLoadMethodForUp", "onVideoAdPlayEnd,adInfo:" + adInfo);
            a();
            String endTips = this.a.getEndTips();
            if (TextUtils.isEmpty(endTips)) {
                return;
            }
            com.rtk.app.tool.f.a(this.e, endTips, f.a.f);
        }

        public void onVideoAdPlayError(WindMillError windMillError, String str) {
            c0.r("DownLoadMethodForUp", "onVideoAdPlayError,error:" + windMillError + ",placementId:" + str);
            com.rtk.app.tool.f.a(this.e, "视频播放失败，您可直接下载~", f.a.f);
            a();
        }

        public void onVideoAdPlayStart(AdInfo adInfo) {
            c0.r("DownLoadMethodForUp", "onVideoAdPlayStart,adInfo:" + adInfo);
        }

        public void onVideoRewarded(AdInfo adInfo, WMRewardInfo wMRewardInfo) {
            c0.r("DownLoadMethodForUp", "onVideoRewarded,wmRewardInfo:" + wMRewardInfo + ",adInfo:" + adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownLoadMethodForUp.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements h.j {
        final /* synthetic */ ApkInfo a;
        final /* synthetic */ Context b;

        b(ApkInfo apkInfo, Context context) {
            this.a = apkInfo;
            this.b = context;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            try {
                UpByCheckBean upByCheckBean = (UpByCheckBean) i.a.fromJson(str, UpByCheckBean.class);
                UpByCheckBean.DataBean data = upByCheckBean.getData();
                if (data.getIsBuy() != 1) {
                    i.z(this.b, this.a, upByCheckBean.getData().getTips());
                    return;
                }
                if (this.a.getDownlist() != null) {
                    this.a.getDownlist().clear();
                    this.a.getDownlist().addAll(data.isZip() ? data.getUpDataPathList() : data.getUpSourcePathList());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(data.isZip() ? data.getUpDataPathList() : data.getUpSourcePathList());
                    this.a.setDownlist(arrayList);
                }
                i.e(this.b, new p(this.a, q.b));
            } catch (Exception unused) {
            }
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            com.rtk.app.tool.f.a(this.b, str, f.a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownLoadMethodForUp.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c implements DialogInterface.OnClickListener {
        final /* synthetic */ ApkInfo a;
        final /* synthetic */ Context b;

        /* compiled from: DownLoadMethodForUp.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements h.j {
            a() {
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                UpByCheckBean.DataBean data = ((UpByCheckBean) i.a.fromJson(str, UpByCheckBean.class)).getData();
                if (c.this.a.getDownlist() != null) {
                    c.this.a.getDownlist().clear();
                    c.this.a.getDownlist().addAll(data.isZip() ? data.getUpDataPathList() : data.getUpSourcePathList());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(data.isZip() ? data.getUpDataPathList() : data.getUpSourcePathList());
                    c.this.a.setDownlist(arrayList);
                }
                i.e(c.this.b, new p(c.this.a, q.b));
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
                com.rtk.app.tool.f.a(c.this.b, str, f.a.f);
            }
        }

        c(ApkInfo apkInfo, Context context) {
            this.a = apkInfo;
            this.b = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HashMap<String, String> l = y.l();
            l.put("sid", this.a.getUpGameId() + "");
            l.put("key", t.L(l));
            com.rtk.app.tool.o.h.j(this.b, new a(), y.e + "up/buy", 1, l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownLoadMethodForUp.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class d implements t.b {
        final /* synthetic */ p a;
        final /* synthetic */ Context b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownLoadMethodForUp.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class a implements h.j {
            a(d dVar) {
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                c0.u("DownLoadMethodForUp", c0.a + "游戏下载量统计成功" + str);
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
                c0.s("DownLoadMethodForUp", c0.a + "游戏下载量统计失败" + str);
            }
        }

        d(p pVar, Context context) {
            this.a = pVar;
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void f(Context context, p pVar) {
            com.rtk.app.tool.g.c.e(context).a(pVar.j());
            c0.u("DownLoadMethodForUp", c0.a + "第一个下载链接现在失败，现在重试");
            i.d(context, pVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void g(Context context, p pVar) {
            c0.u("DownLoadMethodForUp", c0.a + "我下载失败了，超时  重新下载");
            i.d(context, pVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void h(Context context, p pVar) {
            try {
                if (v.a(context, "settingInstallVALUE") && pVar.l() == null) {
                    com.rtk.app.tool.t.M1(pVar.j(), context, new s[0]);
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
            com.rtk.app.tool.p.a(MyApplication.b()).d(this.a.j());
            com.rtk.app.tool.p.a(MyApplication.b()).c((Activity) MyApplication.b(), new ApkInfo(this.a));
            c0.u("DownLoadMethodForUp", c0.a + "下载成功");
            x c2 = x.c();
            c2.g(100L, 100L, this.a.j(), "", this.a.d(), this.a.d());
            c2.l(this.a.j());
            this.a.y(q.e);
            q.g(this.a);
            com.rtk.app.tool.g.c.e(this.b).h(this.a.j(), q.e, this.a.r(), 100L, 100L, this.a.d(), this.a.s());
            com.rtk.app.tool.DownLoadTool.t.h(this.a.j(), q.e, new boolean[0]);
            Activity activity = (Activity) MyApplication.b();
            final Context context = this.b;
            final p pVar = this.a;
            activity.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.i.d
                @Override // java.lang.Runnable
                public final void run() {
                    i.d.h(context, pVar);
                }
            });
            d(this.a);
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void c(Exception exc, String str) {
            com.rtk.app.tool.p.a(MyApplication.b()).d(this.a.j());
            com.rtk.app.tool.DownLoadTool.t.g(this.a.j(), q.d);
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
                                activity.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.i.b
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.rtk.app.tool.f.a(context, "找不到资源包", f.a.f);
                                    }
                                });
                                com.rtk.app.tool.g.c.e(this.b).a(this.a.j());
                            }
                            c0.u("DownLoadMethodForUp", c0.a + "下载失败" + this.a.toString());
                            if (this.a.g() == null || this.a.g().size() <= 1 || this.a.g().get(this.a.g().size() - 1).getUrl().equals(this.a.r())) {
                                c0.u("DownLoadMethodForUp", c0.a + "下载失败不满足");
                            } else {
                                while (true) {
                                    if (i < this.a.g().size()) {
                                        if (this.a.g().get(i).getUrl().equals(this.a.r())) {
                                            this.a.u();
                                            Activity activity2 = (Activity) MyApplication.b();
                                            final Context context2 = this.b;
                                            final p pVar = this.a;
                                            activity2.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.i.c
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    i.d.f(context2, pVar);
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
                    } catch (NullPointerException unused) {
                        return;
                    }
                case 1:
                    c0.u("DownLoadMethodForUp", c0.a + "DownLoadMethod  onDownloadFailed手机内存不足");
                    com.rtk.app.tool.f.a(this.b, "手机内存不足", f.a.f);
                    com.rtk.app.tool.g.c.e(this.b).a(this.a.j());
                    q.f(this.a.j());
                    c2.f(this.a.j(), str);
                    return;
                case 3:
                    c0.u("DownLoadMethodForUp", c0.a + "我下载失败了，超时");
                    if (this.a.i() < 3) {
                        p pVar2 = this.a;
                        pVar2.z(pVar2.i() + 1);
                        Activity activity3 = (Activity) MyApplication.b();
                        final Context context3 = this.b;
                        final p pVar3 = this.a;
                        activity3.runOnUiThread(new Runnable() { // from class: com.rtk.app.tool.i.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                i.d.g(context3, pVar3);
                            }
                        });
                        return;
                    }
                    c0.u("DownLoadMethodForUp", c0.a + "我下载失败了，超时  我不下了");
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
            String str;
            String sb;
            Context b = MyApplication.b();
            a aVar = new a(this);
            if (y.x(b)) {
                str = "&uid=" + y.I(b) + "&token=" + y.G(b);
            } else {
                str = "";
            }
            if (pVar.q() != 0 && pVar.j() > 10000000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/countDownNumNew");
                sb2.append(y.u(b));
                sb2.append("&sid=");
                sb2.append(pVar.q());
                sb2.append(str);
                sb2.append("&device_id=");
                sb2.append(y.o(b));
                sb2.append("&device_name=");
                sb2.append(y.p(b));
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(b, "sid=" + pVar.q(), "device_id=" + y.o(b), "device_name=" + y.p(b)))));
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("game/gameDownloadUpdate");
                sb3.append(y.u(b));
                sb3.append("&game_id=");
                sb3.append(pVar.j());
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(c0.e(y.v(b, "game_id=" + pVar.j()))));
                sb = sb3.toString();
            }
            c0.u("DownLoadMethodForUp", sb);
            com.rtk.app.tool.o.h.l(b, aVar, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        }

        @Override // com.rtk.app.tool.DownLoadTool.t.b
        public void onDownloadStart() {
            c0.u("DownLoadMethodForUp", "up资源下载开始");
            x.c().j(this.a.j());
            this.a.y(q.f286c);
            q.g(this.a);
            com.rtk.app.tool.p.a(MyApplication.b()).e((Activity) MyApplication.b(), new ApkInfo(this.a), this.a.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, ApkInfo apkInfo) {
        if (com.rtk.app.tool.t.M(context) != 0) {
            n(context, apkInfo);
        } else {
            com.rtk.app.tool.f.a(context, "网络断开", f.a.f);
        }
    }

    public static void d(Context context, p pVar) {
        String str;
        c0.u("DownLoadMethodForUp", c0.a + "downLoadHttp in");
        if (pVar.r().endsWith(".apk")) {
            pVar.A(1);
        } else if (pVar.r().endsWith(".zip")) {
            pVar.A(0);
        }
        if (pVar.m() == 1) {
            str = y.C(context) + "/upModuleApk/" + pVar.q() + ".apk";
        } else {
            str = y.C(context) + "/upModuleZip/" + pVar.q() + "/" + pVar.j() + ".zip";
        }
        String str2 = str;
        pVar.w(str2);
        pVar.y(q.f286c);
        com.rtk.app.tool.g.c.e(context).f(pVar);
        x.c().j(pVar.j());
        q.a(pVar);
        c0.u("DownLoadMethodForUp", c0.a + "下载地址:" + str2 + " isApk:" + pVar.m() + "版本" + pVar.s());
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
            c0.u("DownLoadMethodForUp", "文件异常");
            e.printStackTrace();
        }
        c0.u("DownLoadMethodForUp", c0.a + "开始下载");
        com.rtk.app.tool.DownLoadTool.t.e().c(pVar, str2, new d(pVar, context), j);
    }

    public static void e(final Context context, final p pVar) {
        c0.u("DownLoadMethodForUp", c0.a + "downLoadHttpVerifyWifi in");
        if (pVar.g().get(0).getApkType() != 0 && pVar.g().get(0).getApkType() != 1) {
            com.rtk.app.tool.f.a(MyApplication.b(), "请升级软天空APP后再来下载！", f.a.f);
            return;
        }
        if (v.a(context, "settingNoWifiVALUE")) {
            if (com.rtk.app.tool.t.M(context) == 2) {
                new DialogNoWifi(MyApplication.b(), new s() { // from class: com.rtk.app.tool.i.g
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        i.d(context, pVar);
                    }
                }).show();
                return;
            } else {
                d(context, pVar);
                return;
            }
        }
        d(context, pVar);
    }

    private static boolean f(final Context context, final AdBean.DataDTO.DownAdDTO downAdDTO, final int i) {
        long longValue = v.c(context, "adOverTaskTime").longValue();
        if (longValue != 0 && System.currentTimeMillis() < longValue) {
            c0.u("DownLoadMethodForUp", "任务完成持续时间内");
            return true;
        }
        if (downAdDTO == null) {
            c0.u("DownLoadMethodForUp", "downAdDTO is null");
            return false;
        }
        if ((y.x(context) ? MainActivity.p.getData().getLevel() : 0) > downAdDTO.getGradeLimit().intValue()) {
            c0.u("DownLoadMethodForUp", "高于指定等级不用分享");
            return true;
        }
        if (downAdDTO.getAdType().intValue() != 1 && downAdDTO.getAdType().intValue() == 2) {
            new DialogTipsForCallBack(context, downAdDTO.getTips(), new s() { // from class: com.rtk.app.tool.i.e
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    i.k(context, downAdDTO, i, strArr);
                }
            }).show();
        }
        return false;
    }

    private static boolean g(final Context context, AdBean.DataDTO.DownShareDTO downShareDTO, final int i) {
        long longValue = v.c(context, "shareOverTaskTime").longValue();
        if (longValue != 0 && System.currentTimeMillis() < longValue) {
            c0.u("DownLoadMethodForUp", "任务完成持续时间内");
            return true;
        }
        int level = y.x(context) ? MainActivity.p.getData().getLevel() : 0;
        if (downShareDTO == null) {
            c0.u("DownLoadMethodForUp", "downShareDTO is null");
            return false;
        }
        if (level > downShareDTO.getGradeLimit().intValue()) {
            c0.u("DownLoadMethodForUp", "高于指定等级不用分享");
            return true;
        }
        final int intValue = downShareDTO.getContinuedTime().intValue();
        s sVar = new s() { // from class: com.rtk.app.tool.i.h
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                i.l(context, i, intValue, strArr);
            }
        };
        if (downShareDTO.getShareType().intValue() == 1) {
            com.rtk.app.tool.t.c2(context, downShareDTO.getPhotoFieldUrl(), downShareDTO.getPhotoFieldTitle(), sVar);
        } else if (downShareDTO.getShareType().intValue() == 2) {
            com.rtk.app.tool.t.d2(context, downShareDTO.getUrlFieldIconUrl(), downShareDTO.getUrlFieldUrl(), downShareDTO.getUrlFieldTitle(), downShareDTO.getUrlFieldContent(), sVar);
        }
        com.rtk.app.tool.f.a(context, downShareDTO.getTips(), f.a.f);
        return false;
    }

    private static Gson h() {
        if (a == null) {
            a = new GsonBuilder().enableComplexMapKeySerialization().create();
        }
        return a;
    }

    private static boolean i(Context context, ApkInfo apkInfo) {
        String d2 = v.d(context, "ChuanshanAdIdValue");
        if (!c0.q(d2)) {
            AdBean adBean = null;
            try {
                adBean = (AdBean) h().fromJson(d2, AdBean.class);
            } catch (Exception e) {
                c0.u("DownLoadMethodForUp", "广告信息格式化异常" + e);
            }
            if (adBean != null) {
                if (adBean.getData().getDownTask().intValue() != 1 && adBean.getData().getDownTask().intValue() != 2) {
                    c0.u("DownLoadMethodForUp", "无需任务");
                    return true;
                }
                if (v.a(context, "overTask" + apkInfo.getUpGameId())) {
                    c0.u("DownLoadMethodForUp", "该ID完成过任务");
                    return true;
                }
                if (adBean.getData().getDownTask().intValue() == 1) {
                    return g(context, adBean.getData().getDownShare(), apkInfo.getUpGameId());
                }
                if (adBean.getData().getDownTask().intValue() == 2) {
                    return f(context, adBean.getData().getDownAd(), apkInfo.getUpGameId());
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(Context context, AdBean.DataDTO.DownAdDTO downAdDTO, int i, String[] strArr) {
        if (strArr.length <= 0 || !strArr[0].equals("false")) {
            if (!com.rtk.app.tool.t.t1(context)) {
                com.rtk.app.tool.f.a(context, "请检查网络", f.a.f);
                return;
            }
            if (context instanceof Activity) {
                DialogProgressForRewardVideoAdTip dialogProgressForRewardVideoAdTip = new DialogProgressForRewardVideoAdTip(context, "加载中，请稍后……");
                dialogProgressForRewardVideoAdTip.show();
                c0.u("DownLoadMethodForUp", "loadRewardVideoAd");
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", "user123");
                Activity activity = (Activity) context;
                WMRewardAd wMRewardAd = new WMRewardAd(activity, new WMRewardAdRequest(downAdDTO.getCodeBitIdToBid(), "user123", hashMap));
                wMRewardAd.setRewardedAdListener(new a(downAdDTO, context, i, wMRewardAd, activity, dialogProgressForRewardVideoAdTip));
                wMRewardAd.loadAd();
                return;
            }
            c0.u("DownLoadMethodForUp", "当前点击下载的地方context为非activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(Context context, int i, int i2, String[] strArr) {
        v.e(context, "overTask" + i, Boolean.TRUE);
        v.g(context, "shareOverTaskTime", Long.valueOf(System.currentTimeMillis() + ((long) (i2 * BaseConstants.Time.MINUTE))));
    }

    public static void n(Context context, ApkInfo apkInfo) {
        if (apkInfo.getNeedCoin() <= 0) {
            e(context, new p(apkInfo, q.b));
            return;
        }
        if (!y.x(context)) {
            com.rtk.app.tool.t.w0(context);
            return;
        }
        HashMap<String, String> l = y.l();
        l.put("sid", apkInfo.getUpGameId() + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(context, new b(apkInfo, context), 1, com.rtk.app.tool.o.h.h(y.e).a(y.w("up/buy/check", l)));
    }

    public static void o(final Context context, final ApkInfo apkInfo, TextView textView) {
        c0.u("DownLoadMethodForUp", c0.a + "setDownloadEvent in");
        if (!i(context, apkInfo)) {
            c0.u("DownLoadMethodForUp", c0.a + "需要做任务，暂不可下载");
            return;
        }
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
                c0.u("DownLoadMethodForUp", c0.a + "下载按钮被点击");
                if (apkInfo.getDownlist() != null && apkInfo.getDownlist().size() != 0) {
                    if (apkInfo.getDownlist() != null && !apkInfo.getDownlist().isEmpty() && apkInfo.getDownlist().get(0).getUrl().endsWith(".zip")) {
                        if (!r.b(context)) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 30 && r.c(context)) {
                            return;
                        }
                    }
                    if (apkInfo.getInstallation() == null || !apkInfo.getInstallation().isOnlyWay2() || r.b(context)) {
                        if (apkInfo.getDownlist().get(0).getIs_prompt() == 1) {
                            new DialogDownLoadTipForInstall(context, apkInfo.getDownlist().get(0), new s() { // from class: com.rtk.app.tool.i.f
                                @Override // com.rtk.app.tool.s
                                public final void a(String[] strArr) {
                                    i.c(context, apkInfo);
                                }
                            }).show();
                            return;
                        } else {
                            c(context, apkInfo);
                            return;
                        }
                    }
                    return;
                }
                c0.s("DownLoadMethodForUp", c0.a + "setDownloadEvent downList is null");
                return;
            case 1:
                p d2 = q.d(apkInfo.getGameId());
                c0.u("DownLoadMethodForUp", c0.a + "info.getPackageName():" + d2.n());
                com.rtk.app.tool.t.M1(d2.j(), context, new s[0]);
                return;
            case 2:
                com.rtk.app.tool.t.A1(context, apkInfo.getPackageName());
                return;
            case 4:
                if (com.rtk.app.tool.t.M(context) != 0) {
                    c0.u("DownLoadMethodForUp", c0.a + "DownloadInfo 游戏包名:" + apkInfo.getPackageName());
                    p d3 = q.d(apkInfo.getGameId());
                    if (d3 != null) {
                        e(context, d3);
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
                com.rtk.app.tool.p.a(MyApplication.b()).d(apkInfo.getGameId());
                x.c().k(apkInfo.getGameId());
                com.rtk.app.tool.g.c.e(context).i(q.d, apkInfo.getGameId());
                com.rtk.app.tool.DownLoadTool.t.h(apkInfo.getGameId(), q.d, new boolean[0]);
                return;
        }
    }

    public static void p(Context context, ApkInfo apkInfo, TextView textView, ProgressBar progressBar) {
        c0.u("DownLoadMethodForUp", c0.a + "setDownloadState in");
        p d2 = q.d(apkInfo.getGameId());
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        textView.setBackgroundColor(context.getResources().getColor(R.color.transparency));
        if (d2 != null && d2.j() == apkInfo.getGameId()) {
            int h = d2.h();
            if (h != 0) {
                if (h == 1) {
                    v(textView, progressBar, d2);
                    return;
                }
                if (h == 2) {
                    r(textView, progressBar, d2);
                    return;
                }
                if (h == 3) {
                    if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName()) && apkInfo.getVersion_code() <= com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                        w(textView, progressBar);
                        return;
                    } else {
                        u(textView, progressBar);
                        return;
                    }
                }
                if (h != 4) {
                    if (h == 5) {
                        v(textView, progressBar, d2);
                        textView.setText("解压中");
                        return;
                    } else if (h != 11) {
                        s(context, textView, progressBar);
                        return;
                    } else {
                        y(textView, progressBar, d2);
                        return;
                    }
                }
            }
            if (!com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
                s(context, textView, progressBar);
                return;
            } else if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                x(textView, progressBar);
                return;
            } else {
                w(textView, progressBar);
                return;
            }
        }
        if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
            if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                x(textView, progressBar);
                return;
            } else {
                w(textView, progressBar);
                q.a(new p(apkInfo.getGameId(), apkInfo.getPackageName(), apkInfo.getAppName(), null, q.f, apkInfo.getIcon_url(), 1, apkInfo.getVersion_code()));
                return;
            }
        }
        s(context, textView, progressBar);
    }

    public static void q(int i, Context context, ApkInfo apkInfo, TextView textView, ProgressBar progressBar) {
        p d2 = q.d(((Integer) textView.getTag()).intValue());
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        textView.setBackgroundColor(context.getResources().getColor(R.color.transparency));
        if (d2 != null && d2.j() == apkInfo.getGameId()) {
            int h = d2.h();
            if (h == 1) {
                v(textView, progressBar, d2);
                return;
            }
            if (h == 2) {
                r(textView, progressBar, d2);
                return;
            }
            if (h == 3) {
                u(textView, progressBar);
                return;
            }
            if (h != 4) {
                if (h == 5) {
                    v(textView, progressBar, d2);
                    textView.setText("解压中");
                    return;
                } else if (h != 11) {
                    s(context, textView, progressBar);
                    return;
                } else {
                    y(textView, progressBar, d2);
                    return;
                }
            }
            if (!com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
                s(context, textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                x(textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() == com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                if (i != 1) {
                    w(textView, progressBar);
                    return;
                } else if (!c0.q(d2.e()) && new File(d2.e()).exists()) {
                    u(textView, progressBar);
                    return;
                } else {
                    t(textView, progressBar);
                    return;
                }
            }
            return;
        }
        if (com.rtk.app.tool.t.q1(context, apkInfo.getPackageName())) {
            if (apkInfo.getVersion_code() > com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                x(textView, progressBar);
                return;
            }
            if (apkInfo.getVersion_code() < com.rtk.app.tool.t.Z(context, apkInfo.getPackageName())) {
                s(context, textView, progressBar);
                return;
            } else if (i == 1) {
                t(textView, progressBar);
                return;
            } else {
                w(textView, progressBar);
                q.a(new p(apkInfo.getGameId(), apkInfo.getPackageName(), apkInfo.getAppName(), null, q.f, apkInfo.getIcon_url(), 1, apkInfo.getVersion_code()));
                return;
            }
        }
        s(context, textView, progressBar);
    }

    private static void r(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText("继续");
        progressBar.setProgress((int) pVar.f());
    }

    private static void s(Context context, TextView textView, ProgressBar progressBar) {
        textView.setText("下载");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void t(TextView textView, ProgressBar progressBar) {
        textView.setText("重新下载");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void u(TextView textView, ProgressBar progressBar) {
        textView.setText("安装");
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(100);
    }

    private static void v(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText(R.string.download_wait);
        progressBar.setProgress((int) pVar.f());
    }

    private static void w(TextView textView, ProgressBar progressBar) {
        textView.setText("打开");
        progressBar.setSecondaryProgress(100);
    }

    private static void x(TextView textView, ProgressBar progressBar) {
        textView.setText("更新");
        progressBar.setMax(100);
        progressBar.setSecondaryProgress(0);
        progressBar.setProgress(0);
    }

    private static void y(TextView textView, ProgressBar progressBar, p pVar) {
        textView.setText("等待中");
        progressBar.setProgress((int) pVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Context context, ApkInfo apkInfo, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("下载提示");
        builder.setMessage("此UP主设置了下载付费，下载此UP需要支付" + apkInfo.getNeedCoin() + "金币，确定支付金币吗？");
        TextView textView = new TextView(context);
        textView.setTextSize((float) com.rtk.app.tool.h.a(5.0f, context));
        textView.setText(str);
        int a2 = com.rtk.app.tool.h.a(10.0f, context);
        int a3 = com.rtk.app.tool.h.a(25.0f, context);
        textView.setPadding(a3, a2, a3, 0);
        builder.setView(textView);
        builder.setPositiveButton("确定", new c(apkInfo, context));
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.show();
    }
}
