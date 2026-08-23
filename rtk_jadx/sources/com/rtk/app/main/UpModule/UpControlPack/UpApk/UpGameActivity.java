package com.rtk.app.main.UpModule.UpControlPack.UpApk;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.bean.UpApkRequestBean;
import com.rtk.app.bean.UpSourceBean;
import com.rtk.app.bean.UserUpSetCoinCheckBean;
import com.rtk.app.custom.CustomMultiLineEditTextView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.Home5Activity.Home5MyUpSrcActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpHolderTool.UpApkUpImageHolder;
import com.rtk.app.main.UpModule.UpHolderTool.UpGameSrcTypeHolder;
import com.rtk.app.main.UpModule.UpHolderTool.UpProgressHeadHolder;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.main.UpModule.UpProtocolActivity;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForPublishUpSrcShowShatus;
import com.rtk.app.main.dialogPack.DialogUpUserAgreement;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.g;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.n;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameActivity extends BaseActivity implements h.j {
    private int A = 0;
    private DialogForPublishUpSrcShowShatus B;
    private String C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    public UpProgressHeadHolder q;
    private UpApkUpImageHolder r;
    private UpGameSrcTypeHolder s;

    @BindView
    NoOOMEditText setDownloadCoinsEt;

    @BindView
    View setDownloadCoinsLayout;
    private String t;
    private String u;

    @BindView
    public NoOOMEditText upGameAddGameEditName;

    @BindView
    CustomMultiLineEditTextView upGameAddSrcDescription;

    @BindView
    CustomMultiLineEditTextView upGameAddSrcFeature;

    @BindView
    TextView upGameAddUpLoad;

    @BindView
    TextView upGameAtBackground;

    @BindView
    TextView upGameBack;

    @BindView
    ImageView upGameExplainBtu;

    @BindView
    RelativeLayout upGameLayout;

    @BindView
    MarkedImageView upGameMyUpLoading;

    @BindView
    TextView upGameNotice;

    @BindView
    TextView upGameProtocol;

    @BindView
    CheckBox upGameProtocolCheckBox;

    @BindView
    CheckBox upGamePublishPostCheckBox;

    @BindView
    TextView upGameShowStatus;

    @BindView
    LinearLayout upGameShowStatusLv;

    @BindView
    View upGameSrcTypeView;

    @BindView
    View upGameUpImageIncludeView;

    @BindView
    TextView upHeadHolderApkSize;

    @BindView
    ImageView upHeadHolderDelete;

    @BindView
    TextView upHeadHolderGameName;

    @BindView
    TextView upHeadHolderIntro;

    @BindView
    RelativeLayout upHeadHolderLv;

    @BindView
    ProgressBar upHeadHolderProgress;

    @BindView
    LinearLayout upHeadHolderProgressLv;

    @BindView
    TextView upHeadHolderProgressPercentage;

    @BindView
    TextView upHeadHolderSpeed;

    @BindView
    CheckBox upHeadHolderStop;

    @BindView
    View upHeadHolderView;
    private UpApkBean v;
    private String w;
    private String x;
    private g y;
    private com.rtk.app.main.UpModule.UpControlPack.c.b z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpGameActivity.this.A = Integer.parseInt(strArr[0]);
        }
    }

    private void N() {
        HashMap<String, String> l = y.l();
        l.put("family_id", this.D ? this.C : "0");
        l.put("key", t.L(l));
        h.l(this.f147c, this, 5, h.h(y.e).a(y.w("user/up/set-coin-check", l)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        if (strArr.length == 0) {
            return;
        }
        String str = strArr[0];
        str.hashCode();
        if (str.equals("0")) {
            com.rtk.app.tool.c.b(this.f147c, UpProtocolActivity.class, null);
        } else if (str.equals("yes")) {
            this.upGameProtocolCheckBox.setChecked(true);
            V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        String v = this.r.v();
        String w = this.r.w();
        String u = this.r.u();
        com.rtk.app.tool.g.f e = com.rtk.app.tool.g.f.e(this.f147c);
        String str = this.q.l;
        String str2 = this.x;
        UpGameSrcTypeHolder upGameSrcTypeHolder = this.s;
        e.p(str, str2, upGameSrcTypeHolder.n, upGameSrcTypeHolder.o, upGameSrcTypeHolder.p, this.u, this.t, v, w, u, 0, this.A, this.C, this.E);
        v.h(this.f147c, v.l, "");
        com.rtk.app.main.UpModule.UpControlPack.b.i().e(this.q.q);
        n.e.remove(this.q.q);
        finish();
    }

    private void S(UpApkRequestBean upApkRequestBean) {
        if (upApkRequestBean.getData() == null || upApkRequestBean.getData().getSid() == 0) {
            return;
        }
        this.w = "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.w);
        sb.append("【应用类型】   <br>");
        sb.append(this.s.n % 2 == 0 ? "游戏" : "软件");
        sb.append("-");
        sb.append(this.s.p);
        sb.append("<br><br>");
        this.w = sb.toString();
        this.w += "【应用版本】   <br>" + this.v.getVersionName() + "(" + this.v.getVersionCode() + ")<br><br>";
        this.w += "【应用大小】   <br>" + c0.k(this.v.getSourceSize()) + "<br><br>";
        this.w += "【应用包名】   <br>" + this.v.getPackageName() + "<br><br>";
        this.w += "【应用特色】   <br>" + this.u + "<br><br>";
        this.w += "【应用介绍】   <br>" + this.t + "<br><br>";
        this.w += "【下载地址】   <br>[upfile=" + upApkRequestBean.getData().getSid() + "]" + this.x + "[/upfile]<br>";
        this.w += "【应用截图】   <br>";
        for (int i = 0; i < this.r.j.size(); i++) {
            this.w += "[img]" + this.r.j.get(0).getUrl() + this.r.j.get(i).getThumb() + "[/img]";
        }
        this.w = this.w.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, "<br>");
        M(4);
    }

    private void U() {
        String v = this.r.v();
        String w = this.r.w();
        String u = this.r.u();
        this.x = this.upGameAddGameEditName.getText().toString().trim();
        this.t = this.upGameAddSrcDescription.getContent();
        this.u = this.upGameAddSrcFeature.getContent();
        try {
            com.rtk.app.tool.g.f e = com.rtk.app.tool.g.f.e(this.f147c);
            String str = this.q.l;
            String str2 = this.x;
            UpGameSrcTypeHolder upGameSrcTypeHolder = this.s;
            e.p(str, str2, upGameSrcTypeHolder.n, upGameSrcTypeHolder.o, upGameSrcTypeHolder.p, this.u, this.t, v, w, u, 0, this.A, this.C, this.E);
        } catch (Exception e2) {
            c0.u("UpGameActivity", "返回保存失败" + e2.toString());
        }
    }

    private void V() {
        this.x = this.upGameAddGameEditName.getText().toString().trim();
        this.t = this.upGameAddSrcDescription.getContent();
        this.u = this.upGameAddSrcFeature.getContent();
        c0.u("UpGameActivity", "md5值：" + this.q.q);
        UpProgressHeadHolder upProgressHeadHolder = this.q;
        UpApkBean H = upProgressHeadHolder.H(upProgressHeadHolder.q);
        this.v = H;
        if (H != null && this.upHeadHolderProgress.getMax() == this.upHeadHolderProgress.getProgress()) {
            if (!com.rtk.app.main.UpModule.UpControlPack.b.i().h(this.f147c, this.x, this.t, Boolean.valueOf(this.upGameProtocolCheckBox.isChecked()), this.s.o, this.r.j.size())) {
                this.upGameAddUpLoad.setEnabled(true);
                this.upGameAtBackground.setEnabled(true);
                return;
            } else {
                U();
                this.upGameAddUpLoad.setEnabled(false);
                this.upGameAtBackground.setEnabled(false);
                M(3);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("upApkBean is null");
        sb.append(this.v == null);
        sb.append("upHeadHolderProgress.getMax():");
        sb.append(this.upHeadHolderProgress.getMax());
        sb.append("upHeadHolderProgress.getProgress()");
        sb.append(this.upHeadHolderProgress.getProgress());
        c0.s("UpGameActivity", sb.toString());
        if (!com.rtk.app.main.UpModule.UpControlPack.b.i().h(this.f147c, this.x, this.t, Boolean.valueOf(this.upGameProtocolCheckBox.isChecked()), this.s.o, this.r.j.size())) {
            this.upGameAddUpLoad.setEnabled(true);
            this.upGameAtBackground.setEnabled(true);
        } else {
            new DialogForEnSure(this.f147c, "软天空将在后台为您不间断传输，并自动发布", new s() { // from class: com.rtk.app.main.UpModule.UpControlPack.UpApk.d
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpGameActivity.this.R(strArr);
                }
            }).show();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.upGameLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M(int... iArr) {
        String str;
        int i = iArr[0];
        if (i == 1) {
            str = "members/sourceNotice" + y.u(this.f147c) + "&key=" + t.c0(c0.e(y.v(this.f147c, new String[0])));
        } else if (i != 2) {
            if (i == 3) {
                String v = this.r.v();
                if (c0.q(this.v.getPackageName())) {
                    this.upGameAddUpLoad.setEnabled(true);
                    this.upGameAtBackground.setEnabled(true);
                    if (this.q.upHeadHolderProgress.getProgress() < this.q.upHeadHolderProgress.getMax()) {
                        com.rtk.app.tool.f.a(this.f147c, "文件上传中，请稍后", f.a.f);
                        return;
                    } else {
                        com.rtk.app.tool.f.a(this.f147c, "服务器无法识别文件，请尝试再次上传，多次失败请联系客服处理", f.a.f);
                        return;
                    }
                }
                Map<String, String> k = com.rtk.app.main.UpModule.UpControlPack.b.k(com.rtk.app.tool.g.f.e(this.f147c).i(this.v.getApkmd5()));
                k.put("sourcePic", v);
                if (!TextUtils.isEmpty(this.C)) {
                    k.put("family_id", this.C);
                } else {
                    k.put("family_id", "0");
                }
                k.put("needCoin", this.E + "");
                h.j(this.f147c, this, y.e + "up/save/add", iArr[0], k);
            } else if (i == 4) {
                String str2 = this.w;
                String str3 = this.x;
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
                hashMap.put("tags", ((this.s.n % 2) + 1) + "");
                String str4 = str3 + "-V" + this.v.getVersionName();
                hashMap.put("title", str4);
                hashMap.put("content", str2);
                hashMap.put(ak.y, y.D());
                hashMap.put("pid", "");
                hashMap.put("display_mode", "2");
                hashMap.put("diN", y.r(MyApplication.b()));
                hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "uid=" + y.K() + "", "token=" + y.H(), "title=" + str4, "mid=1", "display_mode=2"))));
                AppCompatActivity appCompatActivity = this.f147c;
                StringBuilder sb = new StringBuilder();
                sb.append(y.e);
                sb.append("bbs/posts-save");
                h.j(appCompatActivity, this, sb.toString(), iArr[0], hashMap);
            }
            str = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/userLoginGetScore");
            sb2.append(y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(y.K());
            sb2.append("&token=");
            sb2.append(y.H());
            sb2.append("&key=");
            sb2.append(t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H()))));
            str = sb2.toString();
        }
        if (c0.q(str)) {
            return;
        }
        c0.u("UpGameActivity", "  上传资源页面  " + y.d + str);
        h.l(this.f147c, this, iArr[0], h.h(new String[0]).a(str));
    }

    public void T() {
        this.upGameAddSrcDescription.setContent("");
        this.upGameAddSrcFeature.setContent("");
        this.upGameAddGameEditName.setText("");
        this.r.j.clear();
        this.r.x();
        com.rtk.app.main.UpModule.UpControlPack.b.i().p(this.q.q);
        v.h(this.f147c, v.l, "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            UpSourceBean upSourceBean = (UpSourceBean) this.g.fromJson(str, UpSourceBean.class);
            if (!c0.q(upSourceBean.getData())) {
                this.upGameNotice.setVisibility(0);
                this.upGameNotice.setText(upSourceBean.getData());
                return;
            } else {
                this.upGameNotice.setVisibility(8);
                return;
            }
        }
        if (i == 3) {
            this.upGameAddUpLoad.setEnabled(true);
            this.upGameAtBackground.setEnabled(true);
            com.rtk.app.tool.f.a(this.f147c, "上传成功，审核后即可显示", f.a.f);
            c0.u("UpGameActivity", "上传资源返回内容" + str);
            UpApkRequestBean upApkRequestBean = (UpApkRequestBean) this.g.fromJson(str, UpApkRequestBean.class);
            if (this.upGamePublishPostCheckBox.isChecked()) {
                S(upApkRequestBean);
                T();
                return;
            } else {
                T();
                com.rtk.app.tool.c.b(this.f147c, Home5MyUpSrcActivity.class, null);
                finish();
                return;
            }
        }
        if (i == 4) {
            com.rtk.app.tool.f.a(this.f147c, "上传成功，审核后即可显示。\n同步发帖成功", f.a.f);
            com.rtk.app.tool.c.b(this.f147c, Home5MyUpSrcActivity.class, null);
            finish();
            return;
        }
        if (i != 5) {
            return;
        }
        c0.r("UpGameActivity", com.rtk.app.c.a.b(str));
        UserUpSetCoinCheckBean userUpSetCoinCheckBean = (UserUpSetCoinCheckBean) this.g.fromJson(str, UserUpSetCoinCheckBean.class);
        this.F = userUpSetCoinCheckBean.getData().getMaxCoin();
        int minCoin = userUpSetCoinCheckBean.getData().getMinCoin();
        this.G = minCoin;
        int i2 = this.F;
        if (i2 <= 0 || minCoin < 0) {
            this.setDownloadCoinsLayout.setVisibility(8);
            return;
        }
        if (minCoin <= i2) {
            this.setDownloadCoinsLayout.setVisibility(0);
            String str2 = "可设置" + this.G + "-" + this.F + "金币";
            if (this.G == 0) {
                str2 = str2 + "（选题，默认0金币）";
            }
            this.setDownloadCoinsEt.setHint(str2);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        U();
        this.q.j();
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().c(this.z);
        c0.u("UpGameActivity", " 返回finish()  ");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 3) {
            if (i2 == 4) {
                com.rtk.app.tool.f.a(this.f147c, "资源上传成功，自动发帖失败。", f.a.f);
                finish();
                return;
            } else {
                if (i2 != 5) {
                    return;
                }
                this.setDownloadCoinsLayout.setVisibility(8);
                return;
            }
        }
        if (i == 2001) {
            t.w0(this.f147c);
            return;
        }
        c0.u("UpGameActivity", "  上传接口   " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        this.upGameAddUpLoad.setEnabled(true);
        this.upGameAtBackground.setEnabled(true);
        if (i == 9106) {
            T();
            com.rtk.app.tool.c.b(this.f147c, Home5MyUpSrcActivity.class, null);
            finish();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        M(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        g gVar;
        String stringExtra = getIntent().getStringExtra("family_id");
        this.C = stringExtra;
        boolean z = !TextUtils.isEmpty(stringExtra);
        this.D = z;
        if (z) {
            this.upGameBack.setText("上传家族资源");
            this.upGameShowStatusLv.setVisibility(8);
        }
        N();
        String d = v.d(this.f147c, v.l);
        this.y = com.rtk.app.tool.g.f.e(this.f147c).h(d);
        if (!c0.q(d) && (gVar = this.y) != null) {
            this.u = gVar.d();
            this.t = this.y.g();
            this.x = this.y.h();
            this.A = this.y.x();
            this.upGameAddSrcDescription.setContent(this.t);
            this.upGameAddSrcFeature.setContent(this.u);
            this.upGameAddGameEditName.setText(this.x);
            this.upGameShowStatus.setText(t.W(this.A));
        }
        this.q = new UpProgressHeadHolder(this.f147c, this.upHeadHolderView);
        this.upGameUpImageIncludeView.setTag(0);
        this.r = new UpApkUpImageHolder(this.f147c, this.upGameUpImageIncludeView);
        this.s = new UpGameSrcTypeHolder(this.f147c, this.upGameSrcTypeView);
        this.z = new com.rtk.app.main.UpModule.UpControlPack.c.b(this.upGameMyUpLoading);
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().a(this.z);
        this.upGameAddSrcFeature.setBackground(ContextCompat.getDrawable(this, com.rtk.app.R.drawable.shape_corner_theme35_5dp));
        this.upGameAddSrcFeature.setMaxWordCount(1000);
        this.upGameAddSrcFeature.getEditText().setTextSize(13.0f);
        this.upGameAddSrcFeature.setHint("示例：本版本无广告，无需谷歌。（选填,5-1000字）");
        this.upGameAddSrcDescription.setBackground(ContextCompat.getDrawable(this, com.rtk.app.R.drawable.shape_corner_theme35_5dp));
        this.upGameAddSrcDescription.setMaxWordCount(1000);
        this.upGameAddSrcDescription.getEditText().setTextSize(13.0f);
        this.upGameAddSrcDescription.setHint("示例：这是一款XXX的游戏，画面XXX，玩法XX，剧情XXX。（必填,2-1000字）");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        UpProgressHeadHolder upProgressHeadHolder;
        super.onActivityResult(i, i2, intent);
        if (i != 115) {
            if (i == 1012 && i2 == 1014 && (upProgressHeadHolder = this.q) != null) {
                upProgressHeadHolder.L(intent);
                return;
            }
            return;
        }
        if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            List<com.luck.picture.lib.f.b> d = com.luck.picture.lib.b.d(intent);
            arrayList.clear();
            for (com.luck.picture.lib.f.b bVar : d) {
                c0.u("UpGameActivity", "选择图片的地址" + bVar.f());
                arrayList.add(bVar.f());
            }
            this.r.y(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131300933) {
            if (id != 2131300935) {
                if (id != 2131300943) {
                    switch (id) {
                        case com.rtk.app.R.id.up_game_add_upLoad /* 2131300923 */:
                        case com.rtk.app.R.id.up_game_at_background /* 2131300924 */:
                            UpProgressHeadHolder upProgressHeadHolder = this.q;
                            if (c0.q(upProgressHeadHolder.q, upProgressHeadHolder.l, upProgressHeadHolder.j)) {
                                com.rtk.app.tool.f.a(this.f147c, "请选择资源", f.a.f);
                                return;
                            }
                            if (this.setDownloadCoinsLayout.getVisibility() == 0) {
                                String obj = this.setDownloadCoinsEt.getText().toString();
                                if (TextUtils.isEmpty(obj)) {
                                    this.E = 0;
                                } else {
                                    this.E = Integer.parseInt(obj);
                                }
                                int i = this.E;
                                if (i > this.F) {
                                    com.rtk.app.tool.f.a(this.f147c, "金币设置数量不可超过" + this.F, f.a.f);
                                    return;
                                }
                                if (i < this.G) {
                                    com.rtk.app.tool.f.a(this.f147c, "金币设置数量不可小于" + this.G, f.a.f);
                                    return;
                                }
                            }
                            if (!this.upGameProtocolCheckBox.isChecked()) {
                                new DialogUpUserAgreement(this.f147c, new s() { // from class: com.rtk.app.main.UpModule.UpControlPack.UpApk.c
                                    @Override // com.rtk.app.tool.s
                                    public final void a(String[] strArr) {
                                        UpGameActivity.this.P(strArr);
                                    }
                                }).show();
                                return;
                            } else {
                                V();
                                return;
                            }
                        case com.rtk.app.R.id.up_game_back /* 2131300925 */:
                            finish();
                            return;
                        case com.rtk.app.R.id.up_game_explain_btu /* 2131300926 */:
                            break;
                        default:
                            return;
                    }
                } else {
                    if (this.B == null) {
                        this.B = new DialogForPublishUpSrcShowShatus(this.f147c, this.A, this.upGameShowStatus, new a());
                    }
                    this.B.show();
                    return;
                }
            }
            com.rtk.app.tool.c.b(this.f147c, UpProtocolActivity.class, null);
            return;
        }
        com.rtk.app.tool.c.b(this.f147c, UpLoadPoolControlActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_game_test);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onPause() {
        super.onPause();
        U();
        c0.u("UpGameActivity", "onPause被调用");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        c0.u("UpGameActivity", "onResume被调用");
    }

    protected void onStop() {
        super.onStop();
        c0.u("UpGameActivity", "onStop被调用");
    }
}
