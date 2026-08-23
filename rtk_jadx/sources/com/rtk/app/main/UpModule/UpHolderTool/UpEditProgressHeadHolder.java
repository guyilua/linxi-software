package com.rtk.app.main.UpModule.UpHolderTool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.e;
import com.rtk.app.main.UpModule.UpGameSelectActivity;
import com.rtk.app.main.dialogPack.DialogAnalysisApk;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.UpDeleteDialog;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.g.g;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.k;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpEditProgressHeadHolder implements h.j, View.OnClickListener {
    public String a;
    public String b;

    /* renamed from: c, reason: collision with root package name */
    public String f218c;
    private boolean d;
    private File f;
    public String g;
    private DialogAnalysisApk h;
    private com.rtk.app.main.UpModule.UpHolderTool.c i;
    private DialogForProgressTip j;
    private e k;
    private c l;
    private UpApkDetailsBean.DataBean n;
    protected Context o;
    protected View p;

    @BindView
    TextView upHeadHolderApkSize;

    @BindView
    ImageView upHeadHolderDelete;

    @BindView
    TextView upHeadHolderGameName;

    @BindView
    ImageView upHeadHolderIcon;

    @BindView
    TextView upHeadHolderIntro;

    @BindView
    RelativeLayout upHeadHolderLv;

    @BindView
    public ProgressBar upHeadHolderProgress;

    @BindView
    LinearLayout upHeadHolderProgressLv;

    @BindView
    TextView upHeadHolderProgressPercentage;

    @BindView
    TextView upHeadHolderSpeed;

    @BindView
    CheckBox upHeadHolderStop;
    private UpApkBean e = null;
    private int m = 0;
    private Handler q = new a();
    private boolean r = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                UpEditProgressHeadHolder upEditProgressHeadHolder = UpEditProgressHeadHolder.this;
                String str = (String) message.obj;
                upEditProgressHeadHolder.g = str;
                upEditProgressHeadHolder.j(str);
                return;
            }
            if (i == 3) {
                UpEditProgressHeadHolder.this.i();
                return;
            }
            if (i == 4) {
                if (((Boolean) message.obj).booleanValue()) {
                    UpEditProgressHeadHolder.this.upHeadHolderSpeed.setText("");
                    UpEditProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
                    UpEditProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
                    UpEditProgressHeadHolder.this.d = true;
                    return;
                }
                c0.u("UpEditProgressHeadHolder", "是暂停");
                UpEditProgressHeadHolder.this.upHeadHolderDelete.setVisibility(4);
                UpEditProgressHeadHolder.this.upHeadHolderStop.setChecked(true);
                UpEditProgressHeadHolder.this.d = false;
                return;
            }
            if (i == 5) {
                UpEditProgressHeadHolder.this.upHeadHolderSpeed.setText("");
                UpEditProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
                UpEditProgressHeadHolder.this.upHeadHolderStop.setVisibility(8);
                UpEditProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
                return;
            }
            if (i != 7) {
                return;
            }
            UpEditProgressHeadHolder.this.d = true;
            UpEditProgressHeadHolder.this.upHeadHolderSpeed.setText("请重试");
            UpEditProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
            UpEditProgressHeadHolder.this.upHeadHolderStop.setVisibility(0);
            UpEditProgressHeadHolder.this.j.dismiss();
            UpEditProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
            UpEditProgressHeadHolder.this.upHeadHolderProgress.setProgress(1);
            UpEditProgressHeadHolder.this.upHeadHolderProgress.setMax(100);
            UpEditProgressHeadHolder.this.upHeadHolderProgressPercentage.setText("0%");
            if (UpEditProgressHeadHolder.this.k != null) {
                UpEditProgressHeadHolder.this.k.l(UpEditProgressHeadHolder.this.m);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpEditProgressHeadHolder.this.q.sendEmptyMessage(3);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void a();

        void b(String str);
    }

    public UpEditProgressHeadHolder(Context context, View view, UpApkDetailsBean.DataBean dataBean, c cVar) {
        this.l = cVar;
        this.n = dataBean;
        this.o = context;
        this.p = view;
        p(context, view);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        this.h.dismiss();
        String str2 = "uid" + y.K() + "_" + System.currentTimeMillis();
        c0.u("UpEditProgressHeadHolder", "  md5  " + str + "  当前保存的path地址  " + this.f218c + "  当前保存的upApkFileName  " + str2);
        f.e(this.o).l(this.a, str, this.f218c, this.b, str2, "");
        g i = f.e(this.o).i(str);
        PackageInfo packageArchiveInfo = this.o.getPackageManager().getPackageArchiveInfo(this.f218c, 1);
        if (packageArchiveInfo != null) {
            if (i.t() == null) {
                i.J(new UpApkBean(packageArchiveInfo.applicationInfo.packageName));
            } else {
                i.t().setPackageName(packageArchiveInfo.applicationInfo.packageName);
            }
            f.e(this.o).q(str, i.t());
        }
        int E = i.E();
        this.m = E;
        l(E);
        k.i().r(this, y.i + y.k, 0, 1, str, false);
    }

    private void l(int i) {
        e eVar = this.k;
        if (eVar == null || i != eVar.f) {
            c0.u("UpEditProgressHeadHolder", "myUpSubject   创建成功");
            this.upHeadHolderProgress.setTag(Integer.valueOf(i));
            this.k = new e(i, this.upHeadHolderProgress, this.upHeadHolderStop, this.upHeadHolderDelete, this.upHeadHolderSpeed, this.upHeadHolderProgressPercentage, this.j);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.k);
        }
    }

    private void o(String str, int i) {
        if (c0.q(str)) {
            this.upHeadHolderDelete.setVisibility(4);
            return;
        }
        File file = new File(str);
        this.f = file;
        if (file.exists() && this.f.isFile()) {
            int length = (int) (this.f.length() / n.a);
            if (this.f.length() % n.a > 0) {
                length++;
            }
            PackageInfo Q = t.Q(this.o, str);
            if (Q == null) {
                c0.t("UpEditProgressHeadHolder", "packageInfoForPath is null.");
                return;
            }
            ApplicationInfo applicationInfo = Q.applicationInfo;
            applicationInfo.sourceDir = this.f.getAbsolutePath();
            applicationInfo.publicSourceDir = this.f.getAbsolutePath();
            this.a = Q.applicationInfo.loadLabel(this.o.getPackageManager()).toString();
            this.b = this.f.length() + "";
            this.f218c = str;
            this.upHeadHolderIcon.setImageDrawable(t.C(this.o, str));
            this.upHeadHolderGameName.setText(this.a);
            c cVar = this.l;
            if (cVar == null) {
                return;
            }
            cVar.b(this.a);
            this.upHeadHolderApkSize.setText(c0.k(Double.parseDouble(this.b)));
            this.upHeadHolderProgress.setMax(length);
            this.upHeadHolderProgress.setProgress(i);
            TextView textView = this.upHeadHolderProgressPercentage;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append((i2 * 100) / length);
            sb.append("%");
            textView.setText(sb.toString());
            if (length == i2 || length == i) {
                this.upHeadHolderProgressPercentage.setText("100%");
                com.rtk.app.main.UpModule.UpControlPack.d.b(true, this.q);
                this.upHeadHolderStop.setVisibility(8);
            }
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 0) {
            return;
        }
        c0.u("UpEditProgressHeadHolder", "  上传apk文件   " + str);
        this.e = (UpApkBean) create.fromJson(str, UpApkBean.class);
        f.e(this.o).q(this.g, this.e);
        this.q.sendEmptyMessage(5);
        this.d = true;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 0) {
            return;
        }
        c0.u("UpEditProgressHeadHolder", "mark:" + i2 + " code:" + i + "  --上传失败" + str);
        this.q.sendEmptyMessage(7);
        g i3 = f.e(this.o).i(this.g);
        if (i != 1) {
            this.d = true;
            com.rtk.app.tool.f.a(this.o, str, f.a.f);
            com.rtk.app.tool.g.f.e(this.o).w(this.g, 1, 100);
            com.rtk.app.tool.f.a(this.o, "上传失败，请检查网络", f.a.f);
            return;
        }
        String str2 = "uid" + y.K() + "_apk_" + System.currentTimeMillis();
        i3.M(str2);
        com.rtk.app.tool.g.f.e(this.o).v(str2, this.g);
        c0.u("UpEditProgressHeadHolder", "开始上传" + str2);
        k.i().r(this, y.i + y.k, 0, 1, this.g, true);
    }

    public void i() {
        this.d = true;
        this.r = false;
        com.rtk.app.tool.g.f.e(this.o).n(this.g);
        this.upHeadHolderSpeed.setText("");
        this.upHeadHolderStop.setChecked(false);
        this.upHeadHolderStop.setVisibility(0);
        this.upHeadHolderDelete.setVisibility(0);
        this.upHeadHolderIcon.setEnabled(true);
        this.upHeadHolderIntro.setVisibility(0);
        t.c(this.o, this.n.getSourceLogo(), this.upHeadHolderIcon, new boolean[0]);
        this.upHeadHolderProgressLv.setVisibility(8);
        this.l.a();
        this.a = null;
        this.b = null;
        this.f218c = null;
        this.e = null;
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h(this.k);
        try {
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.k.f);
        } catch (Exception unused) {
        }
    }

    public UpApkBean k(String str) {
        if (this.e == null) {
            this.e = com.rtk.app.main.UpModule.UpControlPack.b.i().l(str);
        }
        return this.e;
    }

    public boolean m() {
        return this.r;
    }

    public void n() {
        this.upHeadHolderIcon.setOnClickListener(this);
        this.upHeadHolderDelete.setOnClickListener(this);
        this.upHeadHolderStop.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300868) {
            new UpDeleteDialog(this.o, this.a, this.f218c, new b()).show();
            return;
        }
        if (id == 2131300870) {
            ((Activity) this.o).startActivityForResult(new Intent(this.o, (Class<?>) UpGameSelectActivity.class), 1012);
            return;
        }
        if (id != 2131300877) {
            return;
        }
        boolean z = !this.upHeadHolderStop.isChecked();
        this.d = z;
        this.upHeadHolderStop.setChecked(z);
        if (this.d) {
            if (this.upHeadHolderProgress.getProgress() == this.upHeadHolderProgress.getMax()) {
                this.j.setCancelable(true);
            } else {
                this.j.setCancelable(false);
            }
            this.j.show();
            this.upHeadHolderSpeed.setText("");
            this.upHeadHolderStop.setChecked(false);
            this.upHeadHolderDelete.setVisibility(0);
            com.rtk.app.tool.g.f.e(this.o).r(this.g, 1);
            return;
        }
        if (t.M(this.o) == 0) {
            com.rtk.app.tool.f.a(this.o, "请检查网络", f.a.f);
            return;
        }
        com.rtk.app.tool.g.f.e(this.o).r(this.g, 0);
        g i = com.rtk.app.tool.g.f.e(this.o).i(this.g);
        if (i == null) {
            com.rtk.app.tool.f.a(this.o, "apk文件已被卸载或删除", f.a.f);
            return;
        }
        String o = i.o();
        this.upHeadHolderDelete.setVisibility(4);
        if (this.f == null || c0.q(this.g)) {
            return;
        }
        c0.u("UpEditProgressHeadHolder", "继续上传 md5 :" + this.g + " fileName:" + com.rtk.app.tool.g.f.e(this.o).i(this.g).w() + " apkPath:" + o);
        int e = com.rtk.app.tool.g.f.e(this.o).i(this.g).e();
        int i2 = e <= 0 ? 1 : e;
        this.upHeadHolderStop.setChecked(true);
        if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.g)) {
            com.rtk.app.tool.f.a(this.o, "已在后台传输，请勿重复上传", f.a.f);
            return;
        }
        if (k.i().t(this.g)) {
            c0.t("UpEditProgressHeadHolder", "重复点击");
            return;
        }
        this.upHeadHolderSpeed.setText("上传中...");
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.k);
        k.i().r(this, y.i + y.k, 0, i2, this.g, true);
    }

    public void p(Context context, View view) {
        ButterKnife.b(this, view);
        this.h = new DialogAnalysisApk(context);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(context, "处理中，请稍后...");
        this.j = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        t.c(context, this.n.getSourceLogo(), this.upHeadHolderIcon, new boolean[0]);
        this.d = true;
        this.upHeadHolderDelete.setVisibility(4);
    }

    public void q() {
        com.rtk.app.tool.g.f.e(this.o).r(this.g, 1);
        i();
        this.q.removeMessages(2);
        this.q.removeMessages(4);
        this.q.removeMessages(3);
        this.q.removeMessages(5);
    }

    public void r(Intent intent) {
        this.r = true;
        Bundle extras = intent.getExtras();
        this.a = extras.getString("apkName");
        this.b = extras.getString("apkSize");
        this.f218c = extras.getString("apkPath");
        this.g = "";
        c0.u("UpEditProgressHeadHolder", "引用资源 apkPath:" + this.f218c + " apkSize:" + this.b + " apkName:" + this.a);
        this.f = new File(this.f218c);
        com.rtk.app.main.UpModule.UpControlPack.d.a(true, this.upHeadHolderIcon, this.upHeadHolderProgressLv, this.upHeadHolderIntro, this.upHeadHolderStop, this.upHeadHolderApkSize, this.upHeadHolderGameName);
        this.d = false;
        o(this.f218c, 1);
        g h = com.rtk.app.tool.g.f.e(MyApplication.b()).h(this.f218c);
        if (h != null) {
            this.g = h.n();
        }
        if (c0.q(this.g)) {
            this.h.p(this.f.length());
            this.h.show();
            com.rtk.app.main.UpModule.UpHolderTool.c cVar = new com.rtk.app.main.UpModule.UpHolderTool.c(this.f218c, this.q);
            this.i = cVar;
            cVar.execute(new String[0]);
            return;
        }
        if (h.m() == 0) {
            int E = h.E();
            this.m = E;
            l(E);
            k.i().r(this, y.e + "up/save/edit", 0, 1, this.g, true);
            return;
        }
        this.a = extras.getString("apkName");
        this.b = extras.getString("apkSize");
        this.f218c = extras.getString("apkPath");
        this.g = "";
        this.q.sendEmptyMessage(3);
    }
}
