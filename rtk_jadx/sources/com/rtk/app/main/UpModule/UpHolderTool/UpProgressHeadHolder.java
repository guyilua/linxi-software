package com.rtk.app.main.UpModule.UpHolderTool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.rtk.app.R;
import com.rtk.app.base.g;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.UpGameActivity;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.e;
import com.rtk.app.main.UpModule.UpGameSelectActivity;
import com.rtk.app.main.dialogPack.DialogAnalysisApk;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.UpDeleteDialog;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.k;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpProgressHeadHolder extends g implements h.j, View.OnClickListener {
    public String j;
    public String k;
    public String l;
    private boolean m;
    private Handler n;
    private UpApkBean o;
    private File p;
    public String q;
    private DialogAnalysisApk r;
    private c s;
    private DialogForProgressTip t;
    private e u;

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
    private int v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                UpProgressHeadHolder upProgressHeadHolder = UpProgressHeadHolder.this;
                upProgressHeadHolder.q = (String) message.obj;
                upProgressHeadHolder.r.dismiss();
                String str = "uid" + y.K() + "_" + System.currentTimeMillis();
                c0.u("UP_TAG UpProgressHeadHolder", "  md5  " + UpProgressHeadHolder.this.q + "  当前保存的path地址  " + UpProgressHeadHolder.this.l + "  当前保存的upApkFileName  " + str);
                f e = f.e(((g) UpProgressHeadHolder.this).a);
                UpProgressHeadHolder upProgressHeadHolder2 = UpProgressHeadHolder.this;
                e.l(upProgressHeadHolder2.j, upProgressHeadHolder2.q, upProgressHeadHolder2.l, upProgressHeadHolder2.k, str, "");
                com.rtk.app.tool.g.g i2 = f.e(((g) UpProgressHeadHolder.this).a).i(UpProgressHeadHolder.this.q);
                if (i2 == null) {
                    c0.s("UP_TAG UpProgressHeadHolder", "upLoadApkInfoForMd5 is null.");
                    return;
                }
                PackageInfo packageArchiveInfo = ((g) UpProgressHeadHolder.this).a.getPackageManager().getPackageArchiveInfo(UpProgressHeadHolder.this.l, 1);
                if (packageArchiveInfo != null) {
                    if (i2.t() == null) {
                        i2.J(new UpApkBean(packageArchiveInfo.applicationInfo.packageName));
                    } else {
                        i2.t().setPackageName(packageArchiveInfo.applicationInfo.packageName);
                    }
                    f.e(((g) UpProgressHeadHolder.this).a).q(UpProgressHeadHolder.this.q, i2.t());
                }
                UpProgressHeadHolder.this.v = i2.E();
                UpProgressHeadHolder upProgressHeadHolder3 = UpProgressHeadHolder.this;
                upProgressHeadHolder3.I(upProgressHeadHolder3.v);
                k.i().r(UpProgressHeadHolder.this, y.i + y.k, 0, 1, UpProgressHeadHolder.this.q, false);
                v.h(((g) UpProgressHeadHolder.this).a, v.l, UpProgressHeadHolder.this.l);
                Map<String, h.j> map = n.f;
                UpProgressHeadHolder upProgressHeadHolder4 = UpProgressHeadHolder.this;
                map.put(upProgressHeadHolder4.q, upProgressHeadHolder4);
                return;
            }
            if (i == 3) {
                UpProgressHeadHolder.this.m = true;
                f.e(((g) UpProgressHeadHolder.this).a).n(UpProgressHeadHolder.this.q);
                UpProgressHeadHolder.this.upHeadHolderSpeed.setText("");
                UpProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
                UpProgressHeadHolder.this.upHeadHolderStop.setVisibility(0);
                UpProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
                UpProgressHeadHolder.this.upHeadHolderIcon.setImageResource(R.mipmap.icon_post_add);
                UpProgressHeadHolder.this.upHeadHolderIcon.setEnabled(true);
                UpProgressHeadHolder.this.upHeadHolderProgressLv.setVisibility(8);
                ((UpGameActivity) ((g) UpProgressHeadHolder.this).a).T();
                UpProgressHeadHolder upProgressHeadHolder5 = UpProgressHeadHolder.this;
                upProgressHeadHolder5.j = null;
                upProgressHeadHolder5.k = null;
                upProgressHeadHolder5.l = null;
                upProgressHeadHolder5.o = null;
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h(UpProgressHeadHolder.this.u);
                try {
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(UpProgressHeadHolder.this.u.f);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (i == 4) {
                if (((Boolean) message.obj).booleanValue()) {
                    UpProgressHeadHolder.this.upHeadHolderSpeed.setText("");
                    UpProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
                    UpProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
                    UpProgressHeadHolder.this.m = true;
                    return;
                }
                c0.u("UP_TAG UpProgressHeadHolder", "是暂停");
                UpProgressHeadHolder.this.upHeadHolderDelete.setVisibility(4);
                UpProgressHeadHolder.this.upHeadHolderStop.setChecked(true);
                UpProgressHeadHolder.this.m = false;
                return;
            }
            if (i == 5) {
                UpProgressHeadHolder.this.upHeadHolderSpeed.setText("");
                UpProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
                UpProgressHeadHolder.this.upHeadHolderStop.setVisibility(8);
                UpProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
                return;
            }
            if (i != 7) {
                return;
            }
            UpProgressHeadHolder.this.m = true;
            UpProgressHeadHolder.this.upHeadHolderSpeed.setText("请重试");
            UpProgressHeadHolder.this.upHeadHolderStop.setChecked(false);
            UpProgressHeadHolder.this.upHeadHolderStop.setVisibility(0);
            UpProgressHeadHolder.this.t.dismiss();
            UpProgressHeadHolder.this.upHeadHolderDelete.setVisibility(0);
            UpProgressHeadHolder.this.upHeadHolderProgress.setProgress(1);
            UpProgressHeadHolder.this.upHeadHolderProgress.setMax(100);
            UpProgressHeadHolder.this.upHeadHolderProgressPercentage.setText("0%");
            if (UpProgressHeadHolder.this.u != null) {
                UpProgressHeadHolder.this.u.l(UpProgressHeadHolder.this.v);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpProgressHeadHolder.this.n.sendEmptyMessage(3);
        }
    }

    public UpProgressHeadHolder(Context context, View view) {
        super(context, view);
        this.o = null;
        this.v = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        e eVar = this.u;
        if (eVar == null || i != eVar.f) {
            c0.u("UP_TAG UpProgressHeadHolder", "myUpSubject   创建成功");
            this.upHeadHolderProgress.setTag(Integer.valueOf(i));
            this.u = new e(i, this.upHeadHolderProgress, this.upHeadHolderStop, this.upHeadHolderDelete, this.upHeadHolderSpeed, this.upHeadHolderProgressPercentage, this.t);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.u);
        }
    }

    private void J(String str, int i) {
        if (c0.q(str)) {
            this.upHeadHolderDelete.setVisibility(4);
            return;
        }
        File file = new File(str);
        this.p = file;
        if (file.exists() && this.p.isFile()) {
            int length = (int) (this.p.length() / n.a);
            if (this.p.length() % n.a > 0) {
                length++;
            }
            PackageInfo Q = t.Q(this.a, str);
            ApplicationInfo applicationInfo = Q.applicationInfo;
            applicationInfo.sourceDir = this.p.getAbsolutePath();
            applicationInfo.publicSourceDir = this.p.getAbsolutePath();
            this.j = Q.applicationInfo.loadLabel(this.a.getPackageManager()).toString();
            this.k = this.p.length() + "";
            this.l = str;
            this.upHeadHolderIcon.setImageDrawable(t.C(this.a, str));
            this.upHeadHolderGameName.setText(this.j);
            ((UpGameActivity) this.a).upGameAddGameEditName.setText(this.j);
            this.upHeadHolderApkSize.setText(c0.k(Double.parseDouble(this.k)));
            this.upHeadHolderProgress.setMax(length);
            this.upHeadHolderProgress.setProgress(i);
            TextView textView = this.upHeadHolderProgressPercentage;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            int i3 = (i2 * 100) / length;
            sb.append(i3);
            sb.append("%");
            textView.setText(sb.toString());
            com.rtk.app.tool.g.g i4 = f.e(this.a).i(this.q);
            if (length == i2 || length == i) {
                this.upHeadHolderStop.setVisibility(8);
                if (i4 != null && TextUtils.isEmpty(i4.t().getJsonData())) {
                    c0.u("UP_TAG UpProgressHeadHolder", "initUpView:index:" + i + "  " + length);
                    this.upHeadHolderStop.setVisibility(0);
                    this.upHeadHolderProgress.setProgress(i2);
                    this.upHeadHolderProgressPercentage.setText(i3 + "%");
                    return;
                }
                this.upHeadHolderProgressPercentage.setText("100%");
                com.rtk.app.main.UpModule.UpControlPack.d.b(true, this.n);
            }
        }
    }

    public UpApkBean H(String str) {
        if (this.o == null) {
            this.o = com.rtk.app.main.UpModule.UpControlPack.b.i().l(str);
        }
        return this.o;
    }

    public void K(UpApkBean upApkBean) {
        this.o = upApkBean;
    }

    public void L(Intent intent) {
        Bundle extras = intent.getExtras();
        this.j = extras.getString("apkName");
        this.k = extras.getString("apkSize");
        this.l = extras.getString("apkPath");
        this.q = "";
        c0.u("UP_TAG UpProgressHeadHolder", "引用资源 apkPath:" + this.l + " apkSize:" + this.k + " apkName:" + this.j);
        this.p = new File(this.l);
        com.rtk.app.main.UpModule.UpControlPack.d.a(true, this.upHeadHolderIcon, this.upHeadHolderProgressLv, this.upHeadHolderIntro, this.upHeadHolderStop, this.upHeadHolderApkSize, this.upHeadHolderGameName);
        this.m = false;
        J(this.l, 1);
        com.rtk.app.tool.g.g h = f.e(MyApplication.b()).h(this.l);
        if (h != null) {
            this.q = h.n();
        }
        if (c0.q(this.q)) {
            this.r.p(this.p.length());
            this.r.show();
            c cVar = new c(this.l, this.n);
            this.s = cVar;
            cVar.execute(new String[0]);
            return;
        }
        if (h.m() == 0) {
            v.h(this.a, v.l, this.l);
            n.f.put(this.q, this);
            c0.u("UP_TAG UpProgressHeadHolder", "holder上传文件的md5  " + this.q + "holder上传文件的文件名  " + f.e(this.a).i(this.q).w() + "  文件地址  " + this.l);
            int E = h.E();
            this.v = E;
            I(E);
            k.i().r(this, y.i + y.k, 0, 1, this.q, true);
            return;
        }
        com.rtk.app.tool.f.a(this.a, "该apk已在后台传输，请选择其他apk", f.a.f);
        this.j = extras.getString("apkName");
        this.k = extras.getString("apkSize");
        this.l = extras.getString("apkPath");
        this.q = "";
        this.n.sendEmptyMessage(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 0) {
            return;
        }
        c0.r("UP_TAG UpProgressHeadHolder", "  上传apk文件   " + str);
        this.o = (UpApkBean) create.fromJson(str, UpApkBean.class);
        com.rtk.app.tool.g.f.e(this.a).q(this.q, this.o);
        this.n.sendEmptyMessage(5);
        this.m = true;
        if (n.f.get(this.q) != null) {
            h.j jVar = n.f.get(this.q);
            n.f.remove(this.q);
            jVar.d(str, i);
        }
    }

    @Override // com.rtk.app.base.g
    public void f() {
        super.f();
        this.n = new a();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 0) {
            return;
        }
        if (n.f.get(this.q) != null) {
            n.f.get(this.q);
            n.f.remove(this.q);
        }
        c0.u("UP_TAG UpProgressHeadHolder", "mark:" + i2 + " code:" + i + "  --上传失败" + str);
        this.n.sendEmptyMessage(7);
        com.rtk.app.tool.g.g i3 = com.rtk.app.tool.g.f.e(this.a).i(this.q);
        if (i != 1) {
            this.m = true;
            com.rtk.app.tool.f.a(this.a, str, f.a.f);
            com.rtk.app.tool.g.f.e(this.a).w(this.q, 1, 100);
            com.rtk.app.tool.f.a(this.a, "上传失败，请检查网络", f.a.f);
            return;
        }
        String str2 = "uid" + y.K() + "_apk_" + System.currentTimeMillis();
        i3.M(str2);
        com.rtk.app.tool.g.f.e(this.a).v(str2, this.q);
        c0.u("UP_TAG UpProgressHeadHolder", "开始上传" + str2);
        k.i().r(this, y.i + y.k, 0, 1, this.q, true);
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.upHeadHolderIcon.setOnClickListener(this);
        this.upHeadHolderDelete.setOnClickListener(this);
        this.upHeadHolderStop.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        this.r = new DialogAnalysisApk(context);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(context, "处理中，请稍后...");
        this.t = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        this.l = v.d(context, v.l);
        com.rtk.app.tool.g.g h = com.rtk.app.tool.g.f.e(context).h(this.l);
        c0.u("UP_TAG UpProgressHeadHolder", "apk地址  " + this.l);
        if (!c0.q(this.l) && h != null) {
            this.o = h.t();
            String n = h.n();
            this.q = n;
            n.f.put(n, this);
            int e = h.e();
            if (e <= 0) {
                e = 1;
            }
            com.rtk.app.main.UpModule.UpControlPack.d.a(true, this.upHeadHolderIcon, this.upHeadHolderProgressLv, this.upHeadHolderIntro, this.upHeadHolderStop, this.upHeadHolderApkSize, this.upHeadHolderGameName);
            int E = h.E();
            this.v = E;
            I(E);
            J(this.l, e);
            if (n.e.contains(this.q)) {
                this.upHeadHolderProgressLv.setVisibility(0);
                this.upHeadHolderIntro.setVisibility(8);
                this.m = false;
                this.upHeadHolderStop.setChecked(true);
                return;
            }
            this.upHeadHolderProgressLv.setVisibility(0);
            this.upHeadHolderIntro.setVisibility(8);
            this.m = true;
            this.upHeadHolderStop.setChecked(false);
            return;
        }
        this.m = true;
        this.upHeadHolderDelete.setVisibility(4);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        super.j();
        this.n.removeMessages(2);
        this.n.removeMessages(4);
        this.n.removeMessages(3);
        this.n.removeMessages(5);
        n.f.remove(this.q);
        n.f.clear();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300952) {
            new UpDeleteDialog(this.a, this.j, this.l, new b()).show();
            return;
        }
        if (id == 2131300954) {
            ((Activity) this.a).startActivityForResult(new Intent(this.a, (Class<?>) UpGameSelectActivity.class), 1012);
            return;
        }
        if (id != 2131300961) {
            return;
        }
        boolean z = !this.upHeadHolderStop.isChecked();
        this.m = z;
        this.upHeadHolderStop.setChecked(z);
        if (this.m) {
            if (this.upHeadHolderProgress.getProgress() == this.upHeadHolderProgress.getMax()) {
                this.t.setCancelable(true);
            } else {
                this.t.setCancelable(false);
            }
            this.t.show();
            this.upHeadHolderSpeed.setText("");
            this.upHeadHolderStop.setChecked(false);
            this.upHeadHolderDelete.setVisibility(0);
            com.rtk.app.tool.g.f.e(this.a).r(this.q, 1);
            return;
        }
        if (t.M(this.a) == 0) {
            com.rtk.app.tool.f.a(this.a, "请检查网络", f.a.f);
            return;
        }
        com.rtk.app.tool.g.f.e(this.a).r(this.q, 0);
        com.rtk.app.tool.g.g i = com.rtk.app.tool.g.f.e(this.a).i(this.q);
        if (i == null) {
            com.rtk.app.tool.f.a(this.a, "apk文件已被卸载或删除", f.a.f);
            return;
        }
        String o = i.o();
        this.upHeadHolderDelete.setVisibility(4);
        if (this.p == null || c0.q(this.q)) {
            return;
        }
        c0.u("UP_TAG UpProgressHeadHolder", "继续上传 md5 :" + this.q + " fileName:" + com.rtk.app.tool.g.f.e(this.a).i(this.q).w() + " apkPath:" + o);
        int e = com.rtk.app.tool.g.f.e(this.a).i(this.q).e();
        int i2 = e <= 0 ? 1 : e;
        this.upHeadHolderStop.setChecked(true);
        if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.q)) {
            com.rtk.app.tool.f.a(this.a, "已在后台传输，请勿重复上传", f.a.f);
            return;
        }
        if (k.i().t(this.q)) {
            c0.t("UP_TAG UpProgressHeadHolder", "重复点击");
            return;
        }
        this.upHeadHolderSpeed.setText("上传中...");
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.u);
        k.i().r(this, y.i + y.k, 0, i2, this.q, true);
    }
}
