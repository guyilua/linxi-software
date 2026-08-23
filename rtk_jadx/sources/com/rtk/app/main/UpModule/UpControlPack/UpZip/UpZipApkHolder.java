package com.rtk.app.main.UpModule.UpControlPack.UpZip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Environment;
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
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.g;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.e;
import com.rtk.app.main.UpModule.UpControlPack.d;
import com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogForUnZipFail;
import com.rtk.app.main.dialogPack.UpDeleteDialog;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.k;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.r;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipApkHolder extends g implements h.j, View.OnClickListener {
    public String j;
    public String k;
    public String l;
    private boolean m;
    private Handler n;
    public UpApkBean o;
    private File p;
    public String q;
    private DialogForProgressTip r;
    public e s;
    private String t;
    public UpZipHolder u;

    @BindView
    TextView upZipApkHolderApkSize;

    @BindView
    ImageView upZipApkHolderDelete;

    @BindView
    TextView upZipApkHolderGameName;

    @BindView
    ImageView upZipApkHolderIcon;

    @BindView
    TextView upZipApkHolderIntro;

    @BindView
    RelativeLayout upZipApkHolderLv;

    @BindView
    ProgressBar upZipApkHolderProgress;

    @BindView
    LinearLayout upZipApkHolderProgressLv;

    @BindView
    public TextView upZipApkHolderProgressPercentage;

    @BindView
    TextView upZipApkHolderSpeed;

    @BindView
    CheckBox upZipApkHolderStop;

    @BindView
    View upZipHolderView;
    private DialogForProgressTip v;
    private int w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 3:
                    try {
                        ((UpZipActivity) ((g) UpZipApkHolder.this).a).W();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                case 4:
                    if (((Boolean) message.obj).booleanValue()) {
                        UpZipApkHolder.this.upZipApkHolderSpeed.setText("");
                        UpZipApkHolder.this.upZipApkHolderStop.setChecked(false);
                        UpZipApkHolder.this.upZipApkHolderDelete.setVisibility(0);
                        UpZipApkHolder.this.m = true;
                        return;
                    }
                    c0.u("UpZipApkHolder", "是暂停");
                    UpZipApkHolder.this.upZipApkHolderDelete.setVisibility(4);
                    UpZipApkHolder.this.upZipApkHolderStop.setChecked(true);
                    UpZipApkHolder.this.m = false;
                    return;
                case 5:
                    UpZipApkHolder.this.upZipApkHolderSpeed.setText("");
                    UpZipApkHolder.this.upZipApkHolderStop.setChecked(false);
                    UpZipApkHolder.this.upZipApkHolderStop.setVisibility(8);
                    UpZipApkHolder.this.upZipApkHolderDelete.setVisibility(0);
                    return;
                case 6:
                default:
                    return;
                case 7:
                    UpZipApkHolder.this.m = true;
                    UpZipApkHolder.this.upZipApkHolderSpeed.setText("请重试");
                    UpZipApkHolder.this.upZipApkHolderStop.setChecked(false);
                    UpZipApkHolder.this.upZipApkHolderStop.setVisibility(0);
                    UpZipApkHolder.this.r.dismiss();
                    UpZipApkHolder.this.upZipApkHolderDelete.setVisibility(0);
                    UpZipApkHolder.this.upZipApkHolderProgress.setProgress(1);
                    UpZipApkHolder.this.upZipApkHolderProgress.setMax(100);
                    UpZipApkHolder.this.upZipApkHolderProgressPercentage.setText("0%");
                    UpZipApkHolder upZipApkHolder = UpZipApkHolder.this;
                    e eVar = upZipApkHolder.s;
                    if (eVar != null) {
                        eVar.l(upZipApkHolder.w);
                        return;
                    }
                    return;
                case 8:
                    Map map = (Map) message.obj;
                    UpZipApkHolder upZipApkHolder2 = UpZipApkHolder.this;
                    String str = (String) map.get("apk_path");
                    upZipApkHolder2.l = str;
                    String str2 = (String) map.get("zipMd5");
                    UpZipApkHolder upZipApkHolder3 = UpZipApkHolder.this;
                    String str3 = (String) map.get("apkMd5");
                    upZipApkHolder3.q = str3;
                    String str4 = (String) map.get("zipSize");
                    String str5 = (String) map.get("zipSize");
                    String str6 = (String) map.get("zipPath");
                    String str7 = (String) map.get("apkName");
                    String str8 = "uid" + y.K() + "_apk_" + System.currentTimeMillis();
                    String str9 = "uid" + y.K() + "_zip_" + System.currentTimeMillis();
                    c0.u("UpZipApkHolder", "   md5  " + str3 + "  当前保存的path地址  " + str + "  当前保存的upApkFileName  " + str8);
                    f.e(((g) UpZipApkHolder.this).a).m(str7, str3, str, str5, str8, str2, str4, str9, str6);
                    PackageInfo packageArchiveInfo = ((g) UpZipApkHolder.this).a.getPackageManager().getPackageArchiveInfo(str, 1);
                    if (packageArchiveInfo != null) {
                        UpApkBean upApkBean = new UpApkBean(packageArchiveInfo.applicationInfo.packageName);
                        c0.u("UpZipApkHolder", "zip apk packageName:" + packageArchiveInfo.applicationInfo.packageName);
                        f.e(((g) UpZipApkHolder.this).a).q(str3, upApkBean);
                    }
                    v.h(((g) UpZipApkHolder.this).a, v.m, str);
                    n.f.put(str3, UpZipApkHolder.this);
                    UpZipApkHolder.this.H(str);
                    UpZipApkHolder.this.v.dismiss();
                    return;
                case 9:
                    String str10 = (String) message.obj;
                    UpZipApkHolder.this.v.dismiss();
                    c0.u("UpZipApkHolder", "解压apk失败");
                    new DialogForUnZipFail(((g) UpZipApkHolder.this).a, str10, null).show();
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AllFileAccessPermissionDialog.a {
        b(UpZipApkHolder upZipApkHolder) {
        }

        @Override // com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog.a
        public void a(AllFileAccessPermissionDialog allFileAccessPermissionDialog) {
            allFileAccessPermissionDialog.dismiss();
        }

        @Override // com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog.a
        public void b(AllFileAccessPermissionDialog allFileAccessPermissionDialog) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpZipApkHolder.this.n.sendEmptyMessage(3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UpZipApkHolder(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.o = null;
        this.w = 0;
    }

    private void D(int i) {
        e eVar = this.s;
        if (eVar == null || i != eVar.f) {
            c0.u("UpZipApkHolder", "myUpSubject   创建成功");
            this.upZipApkHolderProgress.setTag(Integer.valueOf(i));
            this.s = new e(i, this.upZipApkHolderProgress, this.upZipApkHolderStop, this.upZipApkHolderDelete, this.upZipApkHolderSpeed, this.upZipApkHolderProgressPercentage, this.r);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.s);
        }
    }

    private void E(String str, int i) {
        if (c0.q(str)) {
            this.upZipApkHolderDelete.setVisibility(4);
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
            this.upZipApkHolderIcon.setImageDrawable(t.C(this.a, str));
            this.upZipApkHolderGameName.setText(this.j);
            ((UpZipActivity) this.a).upZipAddEditName.setText(this.j);
            this.upZipApkHolderApkSize.setText(c0.k(Double.parseDouble(this.k)));
            this.upZipApkHolderProgress.setMax(length);
            this.upZipApkHolderProgress.setProgress(i);
            TextView textView = this.upZipApkHolderProgressPercentage;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append((i2 * 100) / length);
            sb.append("%");
            textView.setText(sb.toString());
            if (length == i2 || length == i) {
                this.upZipApkHolderProgressPercentage.setText("100%");
                d.b(true, this.n);
                this.upZipApkHolderStop.setVisibility(8);
            }
        }
    }

    public UpApkBean C() {
        return this.o;
    }

    public void F(int i, int i2, Intent intent) {
        if (i2 == 1029) {
            try {
                String string = intent.getExtras().getString("zipPath");
                this.t = string;
                if (string != null) {
                    this.v.show();
                    new com.rtk.app.main.UpModule.UpHolderTool.a(this.t, this.n).execute(new String[0]);
                }
            } catch (Exception e) {
                c0.u("UpZipApkHolder", "选择zip异常" + e.toString());
            }
        }
    }

    public void G() {
        this.m = true;
        com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(f.e(this.a).i(this.q));
        f.e(this.a).n(this.q);
        this.upZipApkHolderSpeed.setText("");
        this.upZipApkHolderStop.setChecked(false);
        this.upZipApkHolderStop.setVisibility(0);
        this.upZipApkHolderDelete.setVisibility(0);
        this.upZipApkHolderIntro.setVisibility(0);
        this.upZipApkHolderIcon.setImageResource(R.mipmap.icon_post_add);
        this.upZipApkHolderIcon.setEnabled(true);
        this.upZipApkHolderProgressLv.setVisibility(8);
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = null;
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h(this.s);
        try {
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.s.f);
        } catch (Exception unused) {
        }
        this.u.A();
        com.rtk.app.main.UpModule.UpControlPack.b.i().q(this.u.l);
    }

    public void H(String str) {
        this.q = "";
        c0.u("UpZipApkHolder", "引用资源" + str);
        this.p = new File(str);
        d.a(true, this.upZipApkHolderIcon, this.upZipApkHolderProgressLv, this.upZipApkHolderIntro, this.upZipApkHolderStop, this.upZipApkHolderApkSize, this.upZipApkHolderGameName);
        this.m = false;
        E(str, 1);
        com.rtk.app.tool.g.g h = f.e(MyApplication.b()).h(str);
        if (h != null) {
            this.q = h.n();
        }
        if (h.m() == 0) {
            v.h(this.a, v.m, str);
            n.f.put(this.q, this);
            c0.u("UpZipApkHolder", "holder上传文件的md5:" + this.q + " holder上传文件的文件名:" + f.e(this.a).i(this.q).w() + " 文件地址:" + str);
            int E = h.E();
            this.w = E;
            D(E);
            k.i().r(this, y.i + y.k, 0, 1, this.q, true);
            return;
        }
        com.rtk.app.tool.f.a(this.a, "该apk已在后台传输，请选择其他apk", f.a.f);
        this.q = "";
        this.n.sendEmptyMessage(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 0) {
            return;
        }
        c0.u("UpZipApkHolder", "  上传apk文件   " + str);
        this.o = (UpApkBean) create.fromJson(str, UpApkBean.class);
        com.rtk.app.tool.g.f.e(this.a).q(this.q, this.o);
        this.n.sendEmptyMessage(5);
        this.m = true;
        this.u.B(this.l, this.t);
        if (n.f.get(this.q) != null) {
            n.f.get(this.q);
            n.f.remove(this.q);
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
        c0.u("UpZipApkHolder", "mark: " + i2 + "   code:" + i + "  --上传失败" + str);
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
        c0.u("UpZipApkHolder", "开始上传" + str2);
        k.i().r(this, y.i + y.k, 0, 1, this.q, true);
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.upZipApkHolderIcon.setOnClickListener(this);
        this.upZipApkHolderDelete.setOnClickListener(this);
        this.upZipApkHolderStop.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        this.u = new UpZipHolder(context, this.upZipHolderView);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(context, "分析数据包中，请耐心等待1-3分钟~");
        this.v = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        DialogForProgressTip dialogForProgressTip2 = new DialogForProgressTip(context, "处理中，请稍后...");
        this.r = dialogForProgressTip2;
        dialogForProgressTip2.setCancelable(false);
        this.l = v.d(context, v.m);
        com.rtk.app.tool.g.g h = com.rtk.app.tool.g.f.e(context).h(this.l);
        c0.u("UpZipApkHolder", "apk地址  " + this.l);
        if (!c0.q(this.l) && h != null) {
            this.o = h.t();
            String n = h.n();
            this.q = n;
            n.f.put(n, this);
            int e = h.e();
            if (e <= 0) {
                e = 1;
            }
            d.a(true, this.upZipApkHolderIcon, this.upZipApkHolderProgressLv, this.upZipApkHolderIntro, this.upZipApkHolderStop, this.upZipApkHolderApkSize, this.upZipApkHolderGameName);
            int E = h.E();
            this.w = E;
            D(E);
            E(this.l, e);
            if (n.e.contains(this.q)) {
                this.upZipApkHolderProgressLv.setVisibility(0);
                this.upZipApkHolderIntro.setVisibility(8);
                this.m = false;
                this.upZipApkHolderStop.setChecked(true);
                return;
            }
            this.upZipApkHolderProgressLv.setVisibility(0);
            this.upZipApkHolderIntro.setVisibility(8);
            this.m = true;
            this.upZipApkHolderStop.setChecked(false);
            return;
        }
        this.m = true;
        this.upZipApkHolderDelete.setVisibility(4);
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
        this.u.j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131301065) {
            new UpDeleteDialog(this.a, this.j, this.l, new c()).show();
            return;
        }
        if (id == 2131301067) {
            AllFileAccessPermissionDialog h = r.h(this.a);
            if (h != null) {
                h.d(new b(this));
                return;
            } else {
                this.s = null;
                t.j1((Activity) this.a, Environment.getExternalStorageDirectory().getAbsolutePath());
                return;
            }
        }
        if (id != 2131301074) {
            return;
        }
        boolean z = !this.upZipApkHolderStop.isChecked();
        this.m = z;
        this.upZipApkHolderStop.setChecked(z);
        if (this.m) {
            this.r.setCancelable(this.upZipApkHolderProgress.getProgress() == this.upZipApkHolderProgress.getMax());
            this.r.show();
            this.upZipApkHolderSpeed.setText("");
            this.upZipApkHolderStop.setChecked(false);
            this.upZipApkHolderDelete.setVisibility(0);
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
        String w = com.rtk.app.tool.g.f.e(this.a).i(this.q).w();
        this.upZipApkHolderDelete.setVisibility(4);
        if (this.p == null || c0.q(this.q)) {
            return;
        }
        c0.u("UpZipApkHolder", "继续上传 md5:" + this.q + " fileName:" + w + " apkPath:" + o);
        int e = com.rtk.app.tool.g.f.e(this.a).i(this.q).e();
        int i2 = e <= 0 ? 1 : e;
        this.upZipApkHolderStop.setChecked(true);
        if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.q)) {
            com.rtk.app.tool.f.a(this.a, "已在后台传输，请勿重复上传", f.a.f);
            return;
        }
        this.upZipApkHolderSpeed.setText("上传中...");
        k.i().r(this, y.i + y.k, 0, i2, this.q, true);
    }
}
