package com.rtk.app.main.UpModule.UpControlPack.UpZip;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.g;
import com.rtk.app.bean.UpZipBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.e;
import com.rtk.app.main.UpModule.UpControlPack.d;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.UpDeleteDialog;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipHolder extends g implements h.j, View.OnClickListener {
    private DialogForProgressTip j;
    private String k;
    public String l;
    private String m;
    private Handler n;
    public e o;
    private File p;
    private long q;
    private boolean r;
    private String s;
    private int t;

    @BindView
    TextView upZipHolderApkSize;

    @BindView
    ImageView upZipHolderDelete;

    @BindView
    TextView upZipHolderGameName;

    @BindView
    ImageView upZipHolderIcon;

    @BindView
    TextView upZipHolderIntro;

    @BindView
    ProgressBar upZipHolderProgress;

    @BindView
    LinearLayout upZipHolderProgressLv;

    @BindView
    TextView upZipHolderProgressPercentage;

    @BindView
    TextView upZipHolderSpeed;

    @BindView
    CheckBox upZipHolderStop;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                c0.u("UpZipHolder", "开始上传zip");
                UpZipHolder.this.C(f.e(((g) UpZipHolder.this).a).h(UpZipHolder.this.s));
                return;
            }
            if (i == 7) {
                UpZipHolder.this.r = true;
                UpZipHolder.this.upZipHolderSpeed.setText("请重试");
                UpZipHolder.this.upZipHolderStop.setChecked(false);
                UpZipHolder.this.upZipHolderStop.setVisibility(0);
                UpZipHolder.this.j.dismiss();
                UpZipHolder.this.upZipHolderDelete.setVisibility(0);
                UpZipHolder.this.upZipHolderProgress.setProgress(1);
                UpZipHolder.this.upZipHolderProgress.setMax(100);
                UpZipHolder.this.upZipHolderProgressPercentage.setText("0%");
                UpZipHolder upZipHolder = UpZipHolder.this;
                e eVar = upZipHolder.o;
                if (eVar != null) {
                    eVar.l(upZipHolder.t);
                    return;
                }
                return;
            }
            if (i == 3) {
                ((UpZipActivity) ((g) UpZipHolder.this).a).W();
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                UpZipHolder.this.upZipHolderSpeed.setText("");
                UpZipHolder.this.upZipHolderStop.setChecked(false);
                UpZipHolder.this.upZipHolderStop.setVisibility(8);
                UpZipHolder.this.upZipHolderDelete.setVisibility(0);
                return;
            }
            if (((Boolean) message.obj).booleanValue()) {
                UpZipHolder.this.upZipHolderSpeed.setText("");
                UpZipHolder.this.upZipHolderStop.setChecked(false);
                UpZipHolder.this.upZipHolderDelete.setVisibility(0);
                UpZipHolder.this.r = true;
                return;
            }
            c0.u("UpZipHolder", "是暂停");
            UpZipHolder.this.upZipHolderDelete.setVisibility(4);
            UpZipHolder.this.upZipHolderStop.setChecked(true);
            UpZipHolder.this.r = false;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpZipHolder.this.n.sendEmptyMessage(3);
        }
    }

    public UpZipHolder(Context context, View view) {
        super(context, view);
        this.t = 0;
    }

    private void y(int i) {
        e eVar = this.o;
        if (eVar == null || i != eVar.f) {
            this.upZipHolderProgress.setTag(Integer.valueOf(i));
            this.t = i;
            this.o = new e(i, this.upZipHolderProgress, this.upZipHolderStop, this.upZipHolderDelete, this.upZipHolderSpeed, this.upZipHolderProgressPercentage, this.j);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.o);
        }
    }

    private void z(String str, com.rtk.app.tool.g.g gVar) {
        int f = gVar.f();
        if (f <= 0) {
            f = 1;
        }
        if (c0.q(str)) {
            this.upZipHolderDelete.setVisibility(4);
            return;
        }
        File file = new File(str);
        this.p = file;
        if (file.exists() && this.p.isFile()) {
            int length = (int) (this.p.length() / n.a);
            if (this.p.length() % n.a > 0) {
                length++;
            }
            this.m = this.p.getName();
            this.q = this.p.length();
            this.k = str;
            this.upZipHolderGameName.setText(this.m);
            this.upZipHolderApkSize.setText(c0.k(Double.parseDouble(this.q + "")));
            this.upZipHolderProgress.setMax(length);
            this.upZipHolderProgress.setProgress(f);
            TextView textView = this.upZipHolderProgressPercentage;
            StringBuilder sb = new StringBuilder();
            int i = f - 1;
            sb.append((i * 100) / length);
            sb.append("%");
            textView.setText(sb.toString());
            if (length == i || length == f) {
                this.upZipHolderProgressPercentage.setText("100%");
                d.b(true, this.n);
                this.upZipHolderStop.setVisibility(8);
            }
        }
    }

    public void A() {
        this.o = null;
        this.r = true;
        com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(f.e(this.a).j(this.l));
        f.e(this.a).n(this.l);
        this.upZipHolderSpeed.setText("");
        this.upZipHolderStop.setChecked(false);
        this.upZipHolderStop.setVisibility(0);
        this.upZipHolderDelete.setVisibility(0);
        this.upZipHolderIntro.setVisibility(0);
        this.upZipHolderProgressLv.setVisibility(8);
        this.s = null;
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h(this.o);
        try {
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.o.f);
        } catch (Exception unused) {
        }
    }

    public void B(String str, String str2) {
        this.s = str;
        this.k = str2;
        this.n.sendEmptyMessage(0);
    }

    public void C(com.rtk.app.tool.g.g gVar) {
        c0.u("UpZipHolder", "开始上传zip资源" + gVar.D());
        this.p = new File(c0.q(this.k) ? gVar.D() : this.k);
        d.a(true, this.upZipHolderIcon, this.upZipHolderProgressLv, this.upZipHolderIntro, this.upZipHolderStop, this.upZipHolderApkSize, this.upZipHolderGameName);
        this.r = false;
        z(this.k, gVar);
        this.q = this.p.length();
        this.l = gVar.z();
        if (gVar.m() == 0) {
            v.h(this.a, v.m, this.s);
            n.f.put(this.l, this);
            String A = gVar.A();
            c0.u("UpZipHolder", "holder上传zip文件的md5  " + this.l + "holder上传zip文件的zip文件名  " + A + "  文件地址  " + this.k);
            int y = gVar.y();
            this.t = y;
            y(y);
            StringBuilder sb = new StringBuilder();
            sb.append(y.i);
            sb.append("html/filelist/appsUploadDataBag");
            n.p(this, sb.toString(), 0, 1, this.l, A, false);
            this.upZipHolderProgressLv.setVisibility(0);
            this.upZipHolderIntro.setVisibility(8);
            d.a(true, this.upZipHolderIcon, this.upZipHolderProgressLv, this.upZipHolderIntro, this.upZipHolderStop, this.upZipHolderApkSize, this.upZipHolderGameName);
            return;
        }
        com.rtk.app.tool.f.a(this.a, "该数据包已在后台传输，请选择其他数据包", f.a.f);
        this.l = "";
        this.n.sendEmptyMessage(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 0) {
            return;
        }
        com.rtk.app.tool.f.a(this.a, "上传成功", f.a.f);
        com.rtk.app.tool.g.f.e(this.a).A((UpZipBean) create.fromJson(str, UpZipBean.class));
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
        this.o.l(this.t);
        c0.u("UpZipHolder", "上传失败" + i + "   str" + str);
        com.rtk.app.tool.g.g j = com.rtk.app.tool.g.f.e(MyApplication.b()).j(this.l);
        com.rtk.app.tool.g.f.e(MyApplication.b()).x(this.l, 1, 100);
        String str2 = "uid" + y.K() + "_zip_" + System.currentTimeMillis();
        com.rtk.app.tool.g.f.e(MyApplication.b()).z(this.l, str2);
        n.p(this, y.i + "html/filelist/appsUploadDataBag", 0, 1, j.z(), str2, false);
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.upZipHolderIcon.setOnClickListener(this);
        this.upZipHolderDelete.setOnClickListener(this);
        this.upZipHolderStop.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(context, "处理中，请稍后...");
        this.j = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        this.s = v.d(context, v.m);
        com.rtk.app.tool.g.g h = com.rtk.app.tool.g.f.e(context).h(this.s);
        c0.u("UpZipHolder", "apkPath  " + this.s);
        if (!c0.q(this.s) && h != null) {
            this.k = h.D();
            String z = h.z();
            this.l = z;
            n.f.put(z, this);
            d.a(true, this.upZipHolderIcon, this.upZipHolderProgressLv, this.upZipHolderIntro, this.upZipHolderStop, this.upZipHolderApkSize, this.upZipHolderGameName);
            int y = h.y();
            this.t = y;
            y(y);
            z(this.k, h);
            if (n.e.contains(this.l)) {
                this.upZipHolderProgressLv.setVisibility(0);
                this.upZipHolderIntro.setVisibility(8);
                this.r = false;
                this.upZipHolderStop.setChecked(true);
                return;
            }
            if (h.f() < 1 && h.e() != h.a()) {
                this.upZipHolderProgressLv.setVisibility(8);
                this.upZipHolderIntro.setVisibility(0);
            } else {
                this.upZipHolderProgressLv.setVisibility(0);
                this.upZipHolderIntro.setVisibility(8);
            }
            this.r = true;
            this.upZipHolderStop.setChecked(false);
            return;
        }
        this.r = true;
        this.upZipHolderDelete.setVisibility(4);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        super.j();
        this.n.removeMessages(2);
        this.n.removeMessages(4);
        this.n.removeMessages(3);
        this.n.removeMessages(5);
        this.n.removeMessages(7);
        n.f.remove(this.l);
        n.f.clear();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131301080) {
            new UpDeleteDialog(this.a, this.m, this.s, new b()).show();
            return;
        }
        if (id != 2131301088) {
            return;
        }
        boolean z = !this.upZipHolderStop.isChecked();
        this.r = z;
        this.upZipHolderStop.setChecked(z);
        if (this.r) {
            if (this.upZipHolderProgress.getProgress() == this.upZipHolderProgress.getMax()) {
                this.j.setCancelable(true);
            } else {
                this.j.setCancelable(false);
            }
            this.j.show();
            this.upZipHolderSpeed.setText("");
            this.upZipHolderStop.setChecked(false);
            this.upZipHolderDelete.setVisibility(0);
            com.rtk.app.tool.g.f.e(this.a).t(this.l, 1);
            return;
        }
        if (t.M(this.a) == 0) {
            com.rtk.app.tool.f.a(this.a, "请检查网络", f.a.f);
            return;
        }
        com.rtk.app.tool.g.f.e(this.a).t(this.l, 0);
        com.rtk.app.tool.g.g j = com.rtk.app.tool.g.f.e(this.a).j(this.l);
        if (j == null) {
            com.rtk.app.tool.f.a(this.a, "apk文件已被卸载或删除", f.a.f);
            return;
        }
        String o = j.o();
        String A = com.rtk.app.tool.g.f.e(this.a).j(this.l).A();
        this.upZipHolderDelete.setVisibility(4);
        if (this.p == null || c0.q(this.l)) {
            return;
        }
        c0.u("UpZipHolder", "继续上传  zipMd5  " + this.l + "   fileName  " + A + "   apkPath " + o);
        int f = com.rtk.app.tool.g.f.e(this.a).j(this.l).f();
        int i = f <= 0 ? 1 : f;
        this.upZipHolderStop.setChecked(true);
        if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.l)) {
            com.rtk.app.tool.f.a(this.a, "已在后台传输，请勿重复上传", f.a.f);
            return;
        }
        this.upZipHolderSpeed.setText("上传中...");
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(this.o);
        n.p(this, y.i + "html/filelist/appsUploadDataBag", 0, i, this.l, A, false);
    }
}
