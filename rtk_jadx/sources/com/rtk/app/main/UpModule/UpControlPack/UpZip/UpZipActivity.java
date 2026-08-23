package com.rtk.app.main.UpModule.UpControlPack.UpZip;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.bean.UpApkRequestBean;
import com.rtk.app.bean.UpZipSourceBean;
import com.rtk.app.custom.CustomMultiLineEditTextView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.Home5Activity.Home5MyUpSrcActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpHolderTool.UpApkUpImageHolder;
import com.rtk.app.main.UpModule.UpHolderTool.UpGameSrcTypeHolder;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.main.UpModule.UpProtocolActivity;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForPublishUpSrcShowShatus;
import com.rtk.app.tool.c;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.f;
import com.rtk.app.tool.g.g;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipActivity extends BaseActivity implements h.j {
    private DialogForPublishUpSrcShowShatus B;
    private UpApkUpImageHolder q;
    private UpGameSrcTypeHolder r;
    private com.rtk.app.main.UpModule.UpControlPack.c.b s;
    public UpZipApkHolder t;
    private String u;

    @BindView
    ImageView upApkUpImageAddPhoto;

    @BindView
    FlowLayout upApkUpImagePhotoLv;

    @BindView
    NoOOMEditText upZipAddEditName;

    @BindView
    CustomMultiLineEditTextView upZipAddSrcDescription;

    @BindView
    CustomMultiLineEditTextView upZipAddSrcFeature;

    @BindView
    TextView upZipAddUpLoad;

    @BindView
    TextView upZipAtBackground;

    @BindView
    TextView upZipBack;

    @BindView
    ImageView upZipExplainBtu;

    @BindView
    View upZipHolderView;

    @BindView
    RelativeLayout upZipLayout;

    @BindView
    MarkedImageView upZipMyUpLoading;

    @BindView
    TextView upZipNotice;

    @BindView
    TextView upZipProtocol;

    @BindView
    CheckBox upZipProtocolCheckBox;

    @BindView
    CheckBox upZipPublishPostCheckBox;

    @BindView
    TextView upZipShowStatus;

    @BindView
    LinearLayout upZipShowStatusLv;

    @BindView
    View upZipSrcTypeView;

    @BindView
    View upZipUpImageIncludeView;
    private String v;
    private String w;
    private UpApkBean x;
    private g z;
    private int y = 0;
    private String A = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            String v = UpZipActivity.this.q.v();
            String w = UpZipActivity.this.q.w();
            String u = UpZipActivity.this.q.u();
            f e = f.e(UpZipActivity.this.f147c);
            UpZipActivity upZipActivity = UpZipActivity.this;
            e.p(upZipActivity.t.l, upZipActivity.u, UpZipActivity.this.r.n, UpZipActivity.this.r.o, UpZipActivity.this.r.p, UpZipActivity.this.w, UpZipActivity.this.v, v, w, u, 0, UpZipActivity.this.y, "0", 0);
            c0.u("UpZipActivity", "Zip设置进入后台上传");
            v.h(UpZipActivity.this.f147c, v.m, "");
            com.rtk.app.main.UpModule.UpControlPack.b.i().f(UpZipActivity.this.t.u.l);
            UpZipActivity.this.finish();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpZipActivity.this.y = Integer.parseInt(strArr[0]);
        }
    }

    private void T(UpApkRequestBean upApkRequestBean) {
        if (upApkRequestBean.getData() == null || upApkRequestBean.getData().getSid() == 0) {
            return;
        }
        this.A = "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.A);
        sb.append("【应用类型】   <br>");
        sb.append(this.r.n % 2 == 0 ? "游戏" : "软件");
        sb.append("-");
        sb.append(this.r.p);
        sb.append("<br><br>");
        this.A = sb.toString();
        this.A += "【应用版本】   <br>" + this.x.getVersionName() + "(" + this.x.getVersionCode() + ")<br><br>";
        this.A += "【应用大小】   <br>" + c0.k(this.x.getSourceSize()) + "<br><br>";
        this.A += "【应用包名】   <br>" + this.x.getPackageName() + "<br><br>";
        this.A += "【应用特色】   <br>" + this.w + "<br><br>";
        this.A += "【应用介绍】   <br>" + this.v + "<br><br>";
        this.A += "【下载地址】   <br>[upfile=" + upApkRequestBean.getData().getSid() + "]" + this.u + "[/upfile]<br>";
        this.A += "【应用截图】   <br>";
        for (int i = 0; i < this.q.j.size(); i++) {
            this.A += "[img]" + this.q.j.get(0).getUrl() + this.q.j.get(i).getThumb() + "[/img]";
        }
        this.A = this.A.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, "<br>");
        S(4);
    }

    private void U() {
        this.upZipAddSrcDescription.setContent("");
        this.upZipAddSrcFeature.setContent("");
        this.upZipAddEditName.setText("");
        this.q.j.clear();
        this.q.x();
        UpZipApkHolder upZipApkHolder = this.t;
        upZipApkHolder.s = null;
        upZipApkHolder.u.o = null;
        com.rtk.app.main.UpModule.UpControlPack.b.i().q(this.t.u.l);
        v.h(this.f147c, v.m, "");
        f.e(this.f147c).n(this.t.q);
    }

    private void V() {
        String v = this.q.v();
        String w = this.q.w();
        String u = this.q.u();
        this.u = this.upZipAddEditName.getText().toString().trim();
        this.v = this.upZipAddSrcDescription.getContent();
        this.w = this.upZipAddSrcFeature.getContent();
        try {
            f e = f.e(this.f147c);
            String str = this.t.l;
            String str2 = this.u;
            UpGameSrcTypeHolder upGameSrcTypeHolder = this.r;
            e.p(str, str2, upGameSrcTypeHolder.n, upGameSrcTypeHolder.o, upGameSrcTypeHolder.p, this.w, this.v, v, w, u, 0, this.y, "0", 0);
        } catch (Exception e2) {
            c0.u("UpZipActivity", "返回保存失败" + e2.toString());
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.upZipLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            str = "members/sourceZipNotice" + y.u(this.f147c) + "&key=" + t.c0(c0.e(y.v(this.f147c, new String[0])));
        } else if (i == 3) {
            String v = this.q.v();
            if (c0.q(this.x.getPackageName())) {
                this.upZipAddUpLoad.setEnabled(true);
                if (this.t.upZipApkHolderProgress.getProgress() < this.t.upZipApkHolderProgress.getMax()) {
                    com.rtk.app.tool.f.a(this.f147c, "文件上传中，请稍后", f.a.f);
                    return;
                } else {
                    com.rtk.app.tool.f.a(this.f147c, "服务器无法识别文件，请尝试再次上传，多次失败请联系客服处理", f.a.f);
                    return;
                }
            }
            Map<String, String> k = com.rtk.app.main.UpModule.UpControlPack.b.k(com.rtk.app.tool.g.f.e(this.f147c).i(this.t.q));
            k.put("sourcePic", v);
            k.put("sourceCharacteristic", this.w);
            k.put("varName", this.u);
            k.put("tags", this.r.o);
            k.put("sourceDescription", this.v);
            h.j(this.f147c, this, y.e + "up/save/add", iArr[0], k);
        } else if (i == 4) {
            String str2 = this.A;
            String str3 = this.u;
            HashMap hashMap = new HashMap();
            hashMap.put("channel", y.m(this.f147c, getPackageName()));
            hashMap.put("version", y.i(this.f147c));
            hashMap.put(ak.aj, y.g());
            hashMap.put("phone_model", y.T());
            hashMap.put(ak.J, y.p(this.f147c));
            hashMap.put("uid", y.K() + "");
            hashMap.put("token", y.H());
            hashMap.put("mid", "1");
            hashMap.put(k.l, "up");
            hashMap.put("tags", ((this.r.n % 2) + 1) + "");
            String str4 = str3 + "-V" + this.x.getVersionName();
            hashMap.put("title", str4);
            hashMap.put("content", str2);
            hashMap.put(ak.y, y.D());
            hashMap.put("pid", "");
            hashMap.put("display_mode", "2");
            hashMap.put("diN", y.r(MyApplication.b()));
            hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "uid=" + y.K() + "", "title=" + str4, "token=" + y.H(), "mid=1", "display_mode=2"))));
            AppCompatActivity appCompatActivity = this.f147c;
            StringBuilder sb = new StringBuilder();
            sb.append(y.e);
            sb.append("bbs/posts-save");
            h.j(appCompatActivity, this, sb.toString(), iArr[0], hashMap);
        }
        if (c0.q(str)) {
            return;
        }
        c0.u("UpZipActivity", "  上传资源页面  " + y.d + str);
        h.l(this.f147c, this, iArr[0], h.h(new String[0]).a(str));
    }

    public void W() {
        this.t.G();
        U();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpZipActivity", "上传zip文件   mark " + str);
        if (i == 1) {
            UpZipSourceBean upZipSourceBean = (UpZipSourceBean) this.g.fromJson(str, UpZipSourceBean.class);
            if (!c0.q(upZipSourceBean.getData().getSourceNotice())) {
                this.upZipNotice.setVisibility(0);
                this.upZipNotice.setText(upZipSourceBean.getData().getSourceNotice());
                return;
            } else {
                this.upZipNotice.setVisibility(8);
                return;
            }
        }
        if (i != 3) {
            return;
        }
        this.upZipAddUpLoad.setEnabled(true);
        this.upZipAtBackground.setEnabled(true);
        com.rtk.app.tool.f.a(this.f147c, "上传成功，审核后即可显示", f.a.f);
        c0.u("UpZipActivity", "上传资源返回内容" + str);
        UpApkRequestBean upApkRequestBean = (UpApkRequestBean) this.g.fromJson(str, UpApkRequestBean.class);
        if (this.upZipPublishPostCheckBox.isChecked()) {
            T(upApkRequestBean);
            U();
        } else {
            U();
            c.b(this.f147c, Home5MyUpSrcActivity.class, null);
            finish();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        V();
        this.t.j();
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().c(this.s);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 3) {
            return;
        }
        c0.u("UpZipActivity", "code=" + i + "   上传zip失败" + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        this.upZipAddUpLoad.setEnabled(true);
        this.upZipAtBackground.setEnabled(true);
        if (i == 9106) {
            U();
            c.b(this.f147c, Home5MyUpSrcActivity.class, null);
            finish();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        g gVar;
        this.t = new UpZipApkHolder(this.f147c, this.upZipHolderView);
        this.upZipUpImageIncludeView.setTag(1);
        this.q = new UpApkUpImageHolder(this.f147c, this.upZipUpImageIncludeView);
        this.r = new UpGameSrcTypeHolder(this.f147c, this.upZipSrcTypeView);
        this.s = new com.rtk.app.main.UpModule.UpControlPack.c.b(this.upZipMyUpLoading);
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().a(this.s);
        String d = v.d(this.f147c, v.m);
        this.z = com.rtk.app.tool.g.f.e(this.f147c).h(d);
        if (!c0.q(d) && (gVar = this.z) != null) {
            this.w = gVar.d();
            this.v = this.z.g();
            this.u = this.z.h();
            this.y = this.z.x();
            this.upZipAddSrcDescription.setContent(this.v);
            this.upZipAddSrcFeature.setContent(this.w);
            this.upZipAddEditName.setText(this.u);
            this.upZipShowStatus.setText(t.W(this.y));
            this.t.o = this.z.t();
        }
        this.upZipAddSrcFeature.setBackground(ContextCompat.getDrawable(this, com.rtk.app.R.drawable.shape_corner_theme35_5dp));
        this.upZipAddSrcFeature.setMaxWordCount(1000);
        this.upZipAddSrcFeature.getEditText().setTextSize(13.0f);
        this.upZipAddSrcFeature.setHint("示例：本版本无广告，无需谷歌。（选填,5-1000字）");
        this.upZipAddSrcDescription.setBackground(ContextCompat.getDrawable(this, com.rtk.app.R.drawable.shape_corner_theme35_5dp));
        this.upZipAddSrcDescription.setMaxWordCount(1000);
        this.upZipAddSrcDescription.getEditText().setTextSize(13.0f);
        this.upZipAddSrcDescription.setHint("示例：这是一款XXX的游戏，画面XXX，玩法XX，剧情XXX。（必填,2-1000字）");
        S(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c0.u("UpZipActivity", "requestCode" + i + "resultCode" + i2);
        if (i != 115) {
            if (i != 1028) {
                return;
            }
            this.t.F(i, i2, intent);
        } else if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            List<com.luck.picture.lib.f.b> d = com.luck.picture.lib.b.d(intent);
            arrayList.clear();
            for (com.luck.picture.lib.f.b bVar : d) {
                c0.u("UpZipActivity", "选择图片的地址" + bVar.f());
                arrayList.add(bVar.f());
            }
            this.q.y(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.up_zip_add_upLoad /* 2131301063 */:
            case com.rtk.app.R.id.up_zip_at_background /* 2131301075 */:
                UpZipApkHolder upZipApkHolder = this.t;
                if (c0.q(upZipApkHolder.q, upZipApkHolder.l, upZipApkHolder.j)) {
                    com.rtk.app.tool.f.a(this.f147c, "请选择资源", f.a.f);
                    return;
                }
                this.u = this.upZipAddEditName.getText().toString().trim();
                this.v = this.upZipAddSrcDescription.getContent();
                this.w = this.upZipAddSrcFeature.getContent();
                UpApkBean C = this.t.C();
                this.x = C;
                if (C != null && this.t.u.upZipHolderProgress.getMax() == this.t.u.upZipHolderProgress.getProgress()) {
                    this.upZipAddUpLoad.setEnabled(false);
                    this.upZipAtBackground.setEnabled(false);
                    V();
                    if (!com.rtk.app.main.UpModule.UpControlPack.b.i().h(this.f147c, this.u, this.v, Boolean.valueOf(this.upZipProtocolCheckBox.isChecked()), this.r.o, this.q.j.size())) {
                        this.upZipAddUpLoad.setEnabled(true);
                        this.upZipAtBackground.setEnabled(true);
                        return;
                    } else {
                        S(3);
                        return;
                    }
                }
                if (!com.rtk.app.main.UpModule.UpControlPack.b.i().h(this.f147c, this.u, this.v, Boolean.valueOf(this.upZipProtocolCheckBox.isChecked()), this.r.o, this.q.j.size())) {
                    this.upZipAddUpLoad.setEnabled(true);
                    return;
                }
                if (this.x == null) {
                    new DialogForEnSure(this.f147c, "请等待apk文件上传完，目前进度" + ((Object) this.t.upZipApkHolderProgressPercentage.getText()), null).show();
                    return;
                }
                new DialogForEnSure(this.f147c, "软天空将在后台为您不间断传输，并自动发布", new a()).show();
                return;
            case com.rtk.app.R.id.up_zip_back /* 2131301076 */:
                finish();
                return;
            case com.rtk.app.R.id.up_zip_explain_btu /* 2131301077 */:
            case com.rtk.app.R.id.up_zip_protocol /* 2131301093 */:
                c.b(this.f147c, UpProtocolActivity.class, null);
                return;
            case com.rtk.app.R.id.up_zip_help /* 2131301078 */:
            case com.rtk.app.R.id.up_zip_usage_checkBox /* 2131301100 */:
            case com.rtk.app.R.id.up_zip_usage_protocol /* 2131301101 */:
                t.f1(this.f147c, "members/sourceZipHelp");
                return;
            case com.rtk.app.R.id.up_zip_my_up_loading /* 2131301091 */:
                c.b(this.f147c, UpLoadPoolControlActivity.class, null);
                return;
            case com.rtk.app.R.id.up_zip_show_status_lv /* 2131301097 */:
                if (this.B == null) {
                    this.B = new DialogForPublishUpSrcShowShatus(this.f147c, this.y, this.upZipShowStatus, new b());
                }
                this.B.show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_zip);
        ButterKnife.a(this);
    }
}
