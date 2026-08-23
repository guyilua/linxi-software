package com.rtk.app.main.UpModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.DownListBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpSuguestBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.b;
import com.rtk.app.main.GameFeedBackActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForAttention;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogPostReward;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsActivity extends BaseActivity implements h.j {
    private com.rtk.app.tool.b0.a A;
    private int B = 0;
    private List<Fragment> q;
    private List<String> r;
    private ApkInfo s;
    private int t;
    private UpApkDetailsBean u;

    @BindView
    CustomTextView upApkAuditCheckState;

    @BindView
    CustomTextView upApkAuditListShow;

    @BindView
    TextView upApkDetailFamilyAudit;

    @BindView
    TextView upApkDetailGoToCheckAgainPage;

    @BindView
    TextView upApkDetailGoToCheckPage;

    @BindView
    TextView upApkDetailIsFamily;

    @BindView
    CheckBox upApkDetailsAppCollect;

    @BindView
    TextView upApkDetailsAppDownLoadBtu;

    @BindView
    ProgressBar upApkDetailsAppDownLoadProgressBar;

    @BindView
    RoundedImageView upApkDetailsAppIcon;

    @BindView
    TextView upApkDetailsAppName;

    @BindView
    TextView upApkDetailsAppOpenBtu;

    @BindView
    TextView upApkDetailsAppReward;

    @BindView
    TextView upApkDetailsAppSizeAndPlayerNum;

    @BindView
    TextView upApkDetailsAppVersion;

    @BindView
    TextView upApkDetailsAttention;

    @BindView
    AppBarLayout upApkDetailsBar;

    @BindView
    LinearLayout upApkDetailsCheckStatusLv;

    @BindView
    CustomTextView upApkDetailsCheckStatusTV;

    @BindView
    TextView upApkDetailsCopyUrl;

    @BindView
    LinearLayout upApkDetailsHeadLv;

    @BindView
    TextView upApkDetailsRemark;

    @BindView
    TextView upApkDetailsShare;

    @BindView
    CustomTextView upApkDetailsSuggest;

    @BindView
    TabLayout upApkDetailsTab;

    @BindView
    TextView upApkDetailsTopBack;

    @BindView
    MarkedImageView upApkDetailsTopDownload;

    @BindView
    ImageView upApkDetailsTopFeedback;

    @BindView
    ImageView upApkDetailsTopHome;

    @BindView
    LinearLayout upApkDetailsTopLayout;

    @BindView
    RoundedImageView upApkDetailsUserIcon;

    @BindView
    LinearLayout upApkDetailsUserLv;

    @BindView
    TextView upApkDetailsUserName;

    @BindView
    ViewPager upApkDetailsViewPager;

    @BindView
    CustomTextView upApkFamilyCheckStatusTV;

    @BindView
    CustomTextView upApkListShow;
    private com.rtk.app.tool.DownLoadTool.u v;
    private UpApkDetailsFragment1 w;
    private UpApkDetailsFragment2 x;
    private UpSuguestBean y;
    private DialogForProgressTip z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.b {
        a() {
        }

        @Override // com.rtk.app.custom.b
        public void a(AppBarLayout appBarLayout, b.a aVar) {
            if (aVar == b.a.EXPANDED) {
                try {
                    UpApkDetailsActivity.this.upApkDetailsTopBack.setText("资源详情");
                } catch (NullPointerException | Exception unused) {
                }
            } else if (aVar == b.a.COLLAPSED) {
                UpApkDetailsActivity upApkDetailsActivity = UpApkDetailsActivity.this;
                upApkDetailsActivity.upApkDetailsTopBack.setText(upApkDetailsActivity.s.getAppName());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M(int i, Intent intent) {
        Bundle extras = intent.getExtras();
        int i2 = extras.getInt("modifyStatus2");
        String string = extras.getString("msg2");
        int i3 = extras.getInt("isshow2");
        String string2 = extras.getString("showMsg2");
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "auditAgainPass modifyStatus:" + i2 + " msg:" + string + " isshow:" + i3 + " showMsg:" + string2);
        this.u.getData().setStatus2(i2);
        this.u.getData().setIsshow2(i3);
        if (!com.rtk.app.tool.c0.q(string2)) {
            this.u.getData().setShowmsg2(string2);
        }
        if (!com.rtk.app.tool.c0.q(string)) {
            this.u.getData().setMsg2(string);
        }
        Q();
        extras.putInt("id", this.t);
        intent.putExtras(extras);
        setResult(i, intent);
        O(1);
        G(null, this.upApkDetailsTopLayout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(int i, Intent intent) {
        if (i == 1008) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("modifyStatus");
            String string2 = extras.getString("msg");
            String string3 = extras.getString("isshow");
            String string4 = extras.getString("showMsg");
            if (!com.rtk.app.tool.c0.q(string)) {
                this.u.getData().setStatus(string);
            }
            if (!com.rtk.app.tool.c0.q(string3)) {
                this.u.getData().setIsshow(string3);
            }
            if (!com.rtk.app.tool.c0.q(string4)) {
                this.u.getData().setShowmsg(string4);
            }
            if (!com.rtk.app.tool.c0.q(string2)) {
                this.u.getData().setMsg(string2);
            }
            Q();
            extras.putInt("id", this.t);
            intent.putExtras(extras);
            setResult(1008, intent);
            return;
        }
        if (i == 1011) {
            Bundle extras2 = intent.getExtras();
            String string5 = extras2.getString("modifyStatus");
            String string6 = extras2.getString("msg");
            String string7 = extras2.getString("isshow");
            String string8 = extras2.getString("showMsg");
            if (!string5.isEmpty()) {
                this.u.getData().setStatus(string5);
            }
            if (!string7.isEmpty()) {
                this.u.getData().setIsshow(string7);
            }
            if (!com.rtk.app.tool.c0.q(string8)) {
                this.u.getData().setShowmsg(string8);
            }
            if (!com.rtk.app.tool.c0.q(string6)) {
                this.u.getData().setMsg(string6);
            }
            Q();
            extras2.putInt("id", this.t);
            intent.putExtras(extras2);
            setResult(1008, intent);
            O(1);
            G(null, this.upApkDetailsTopLayout);
        }
    }

    private void P() {
        if (!c.d.a.d.d()) {
            this.upApkDetailGoToCheckPage.setVisibility(8);
            return;
        }
        if (MainActivity.p.getData().getAdmin().getAdmin() != 1 && MainActivity.p.getData().getAdmin().getUpAdmin() != 1 && !com.rtk.app.tool.y.a) {
            if ((MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAdmin() == 2) && this.u.getData().getStatus().equals("1")) {
                this.upApkDetailGoToCheckPage.setVisibility(0);
                this.upApkDetailsCheckStatusTV.setVisibility(0);
                this.upApkListShow.setVisibility(0);
                O(3);
            } else {
                this.upApkDetailsCheckStatusTV.setVisibility(8);
                this.upApkDetailGoToCheckPage.setVisibility(8);
                this.upApkListShow.setVisibility(8);
                this.upApkDetailsSuggest.setVisibility(8);
            }
        } else {
            this.upApkDetailGoToCheckPage.setVisibility(0);
            this.upApkDetailsCheckStatusTV.setVisibility(0);
            this.upApkListShow.setVisibility(0);
            O(3);
        }
        if (com.rtk.app.tool.y.K().equals(this.u.getData().getUid() + "")) {
            this.upApkDetailGoToCheckPage.setText("编辑");
            this.upApkDetailGoToCheckPage.setVisibility(0);
            this.upApkDetailGoToCheckPage.setEnabled(true);
        }
    }

    private void Q() {
        if (this.u == null) {
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "initCheckView upApkDetailsBean is null.");
            return;
        }
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "当前审核展示状态  " + this.u.getData().getIsshow());
        P();
        Y();
        R();
        a0();
        Z();
        b0();
    }

    private void R() {
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 2)) {
            this.upApkDetailGoToCheckAgainPage.setVisibility(0);
            this.upApkAuditCheckState.setVisibility(0);
            this.upApkAuditListShow.setVisibility(0);
        } else {
            this.upApkDetailGoToCheckAgainPage.setVisibility(8);
            this.upApkAuditCheckState.setVisibility(8);
            this.upApkAuditListShow.setVisibility(8);
        }
    }

    private void S() {
        this.s.setAppName(this.u.getData().getVarName());
        this.s.setIcon_url(this.u.getData().getSourceLogo());
        this.s.setPackageName(this.u.getData().getPackageName());
        this.s.setInstallation(this.u.getData().getInstallation());
        com.rtk.app.tool.t.c(this.f147c, this.s.getIcon_url(), this.upApkDetailsAppIcon, new boolean[0]);
        this.upApkDetailsAppName.setText(this.s.getAppName());
        this.upApkDetailsAppSizeAndPlayerNum.setText(com.rtk.app.tool.c0.q(this.u.getData().getDataPath()) ? this.u.getData().getSourceSize() : this.u.getData().getDataSize() + "(数据包)");
        this.upApkDetailsAppVersion.setText("V" + this.u.getData().getVersionName());
        this.upApkDetailsUserName.setText(this.u.getData().getNickname());
        if (!com.rtk.app.tool.c0.q(this.u.getData().getNotename())) {
            this.upApkDetailsRemark.setVisibility(0);
            this.upApkDetailsRemark.setText("备注：" + this.u.getData().getNotename());
        } else {
            this.upApkDetailsRemark.setVisibility(8);
        }
        com.rtk.app.tool.t.c(this.f147c, this.u.getData().getFace(), this.upApkDetailsUserIcon, new boolean[0]);
        this.upApkDetailsAppCollect.setChecked(this.u.getData().getCollected() != 0);
        this.upApkDetailsAppCollect.setEnabled(true);
        this.upApkDetailsAppReward.setEnabled(true);
        if (this.w == null && this.x == null) {
            this.w = new UpApkDetailsFragment1();
            this.x = new UpApkDetailsFragment2();
            Bundle bundle = new Bundle();
            bundle.putSerializable("upApkDetails", this.u);
            bundle.putSerializable("apkInfo", this.s);
            bundle.putInt("upUid", this.u.getData().getUid());
            this.w.setArguments(bundle);
            this.x.setArguments(bundle);
            this.q.add(this.w);
            this.q.add(this.x);
            this.r.add("详情");
            this.r.add("评论" + (this.u.getData().getCommentNum().equals("0") ? "" : "(" + this.u.getData().getCommentNum() + ")"));
            this.upApkDetailsViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
        } else {
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("upApkDetails", this.u);
                bundle2.putSerializable("apkInfo", this.s);
                bundle2.putInt("upUid", this.u.getData().getUid());
                this.w.setArguments(bundle2);
                this.w.i();
            } catch (Exception e) {
                com.rtk.app.tool.c0.u("UpApkDetailsActivity", "up资源详情" + e.toString());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.u.getData().isZip()) {
            for (int i = 0; i < this.u.getData().getUpDataPathList().size(); i++) {
                arrayList.add(new DownListBean(this.u.getData().getUpDataPathList().get(i)));
            }
        } else {
            for (int i2 = 0; i2 < this.u.getData().getUpSourcePathList().size(); i2++) {
                arrayList.add(new DownListBean(this.u.getData().getUpSourcePathList().get(i2)));
            }
        }
        this.s.setDownlist(arrayList);
        com.rtk.app.tool.DownLoadTool.r.i(1, this.f147c, this.s, this.upApkDetailsAppDownLoadBtu, this.upApkDetailsAppDownLoadProgressBar);
        if (this.u.getData().getFamily() == null || this.u.getData().getFamily().getFamily_id() <= 0) {
            return;
        }
        this.upApkDetailIsFamily.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        O(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(String[] strArr) {
        O(4);
        this.z.show();
    }

    private void X() {
        if (!c.d.a.d.d() && MainActivity.p.getData().getAdmin().getAdmin() == 0 && MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 0) {
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "暂无权限");
            return;
        }
        if (!com.rtk.app.tool.t.q1(this.f147c, this.u.getData().getPackageName()) && MainActivity.p.getData().getAdmin().getAdmin() == 0) {
            com.rtk.app.tool.f.a(this.f147c, "请先安装测试后，再审核", f.a.f);
            return;
        }
        if (com.rtk.app.tool.t.Z(this.f147c, this.u.getData().getPackageName()) != this.u.getData().getVersionCode() && MainActivity.p.getData().getAdmin().getAdmin() == 0) {
            com.rtk.app.tool.f.a(this.f147c, "请先安装该版本测试后，再审核", f.a.f);
            return;
        }
        char c2 = (MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 2) ? (char) 2 : (char) 0;
        if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 1) {
            c2 = 1;
        }
        if (c2 == 1) {
            com.rtk.app.tool.t.Y0(this.f147c, this.u.getData().getId() + "", this.u.getData().getStatus2(), 1009, this.u);
            return;
        }
        if (this.u.getData().getStatus2() == 1) {
            com.rtk.app.tool.t.Y0(this.f147c, this.u.getData().getId() + "", this.u.getData().getStatus2(), 1009, this.u);
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "您只能审核未审核的UP", f.a.f);
    }

    private void Y() {
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(this.u.getData().getUid() + "");
        hVar.i(this.u.getData());
        this.A = new com.rtk.app.tool.b0.a(this.u.getData().getUid() + "", this.u.getData().getFollowed() + "", this.upApkDetailsAttention, hVar);
        com.rtk.app.tool.b0.b.b().a(this.A);
        if (!com.rtk.app.tool.c0.q(this.u.getData().getMsg())) {
            this.upApkDetailsCheckStatusTV.setRightText(" [" + this.u.getData().getMsg() + "]");
        }
        com.rtk.app.tool.t.X1(this.f147c, this.upApkDetailsCheckStatusTV, this.u.getData().getStatus());
        if (!com.rtk.app.tool.c0.q(this.u.getData().getShowmsg())) {
            this.upApkListShow.setRightText(" [" + this.u.getData().getShowmsg() + "]");
        }
        com.rtk.app.tool.t.W1(this.f147c, this.upApkListShow, this.u.getData().getIsshow());
    }

    private void Z() {
        int isshow2 = this.u.getData().getIsshow2();
        if (isshow2 != 0) {
            if (isshow2 != 1) {
                return;
            }
            this.upApkAuditListShow.setText("展示");
            this.upApkAuditListShow.setTextColor(getResources().getColor(R.color.theme3));
            return;
        }
        this.upApkAuditListShow.setTextColor(getResources().getColor(R.color.theme20));
        this.upApkAuditListShow.setRightText(" [" + this.u.getData().getShowmsg2() + "]");
        this.upApkAuditListShow.setText("不展示");
    }

    private void a0() {
        int status2 = this.u.getData().getStatus2();
        if (status2 == 1) {
            this.upApkAuditCheckState.setText("待审核");
            this.upApkAuditCheckState.setTextColor(getResources().getColor(R.color.theme1));
            return;
        }
        if (status2 == 2) {
            this.upApkAuditCheckState.setRightText("(" + this.u.getData().getMsg2() + ")");
            this.upApkAuditCheckState.setText("审核不通过");
            this.upApkAuditCheckState.setTextColor(getResources().getColor(R.color.theme20));
            return;
        }
        if (status2 == 3) {
            this.upApkAuditCheckState.setText("审核通过");
            this.upApkAuditCheckState.setTextColor(getResources().getColor(R.color.theme3));
        } else {
            if (status2 != 4) {
                return;
            }
            this.upApkAuditCheckState.setRightText("(" + this.u.getData().getMsg2() + ")");
            this.upApkAuditCheckState.setText("已删除");
            this.upApkAuditCheckState.setTextColor(getResources().getColor(R.color.drak999));
        }
    }

    private void b0() {
        if (this.u.getData().getFamily() != null) {
            if (c.d.a.d.b(this.u.getData().getFamily().getFamily_id() + "")) {
                this.upApkDetailFamilyAudit.setVisibility(0);
                this.upApkFamilyCheckStatusTV.setVisibility(0);
                int status3 = this.u.getData().getStatus3();
                if (status3 == 1) {
                    this.upApkFamilyCheckStatusTV.setRightText("");
                    this.upApkFamilyCheckStatusTV.setText("待审核");
                    this.upApkFamilyCheckStatusTV.setTextColor(getResources().getColor(R.color.theme1));
                    return;
                }
                if (status3 == 2) {
                    this.upApkFamilyCheckStatusTV.setRightText("(" + this.u.getData().getMsg3() + ")");
                    this.upApkFamilyCheckStatusTV.setText("审核不通过");
                    this.upApkFamilyCheckStatusTV.setTextColor(getResources().getColor(R.color.theme20));
                    return;
                }
                if (status3 == 3) {
                    this.upApkFamilyCheckStatusTV.setRightText("");
                    this.upApkFamilyCheckStatusTV.setText("审核通过");
                    this.upApkFamilyCheckStatusTV.setTextColor(getResources().getColor(R.color.theme3));
                    return;
                } else {
                    if (status3 != 4) {
                        return;
                    }
                    this.upApkFamilyCheckStatusTV.setRightText("(" + this.u.getData().getMsg3() + ")");
                    this.upApkFamilyCheckStatusTV.setText("已删除");
                    this.upApkFamilyCheckStatusTV.setTextColor(getResources().getColor(R.color.drak999));
                    return;
                }
            }
        }
        this.upApkFamilyCheckStatusTV.setVisibility(8);
        this.upApkDetailFamilyAudit.setVisibility(8);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upApkDetailsTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void O(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i != 1) {
            if (i == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/sourceCollect");
                sb2.append(com.rtk.app.tool.y.u(this.f147c));
                sb2.append("&uid=");
                sb2.append(com.rtk.app.tool.y.K());
                sb2.append("&token=");
                sb2.append(com.rtk.app.tool.y.H());
                sb2.append("&sid=");
                sb2.append(this.t);
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.t, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                sb = sb2.toString();
            } else if (i == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("members/upSuguest");
                sb3.append(com.rtk.app.tool.y.u(this.f147c));
                sb3.append("&sid=");
                sb3.append(this.t);
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.t))));
                sb = sb3.toString();
            } else if (i != 4) {
                sb = "";
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("members/follows");
                sb4.append(com.rtk.app.tool.y.u(this.f147c));
                sb4.append("&uid=");
                sb4.append(com.rtk.app.tool.y.K());
                sb4.append("&token=");
                sb4.append(com.rtk.app.tool.y.H());
                sb4.append("&fans=");
                sb4.append(this.u.getData().getUid());
                sb4.append("&key=");
                sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "fans=" + this.u.getData().getUid(), "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                sb = sb4.toString();
            }
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "  up详情接口  " + com.rtk.app.tool.y.d + sb);
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("up/detail");
        sb5.append(com.rtk.app.tool.y.u(this.f147c));
        sb5.append("&sid=");
        sb5.append(this.t);
        sb5.append("&uid=");
        sb5.append(com.rtk.app.tool.y.K());
        sb5.append("&token=");
        sb5.append(com.rtk.app.tool.y.H());
        sb5.append("&di=");
        sb5.append(com.rtk.app.tool.y.r(this.f147c));
        sb5.append("&isCheck=");
        sb5.append(this.B);
        sb5.append("&key=");
        sb5.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.t, "di=" + com.rtk.app.tool.y.r(this.f147c)))));
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb5.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "up资源详情  " + com.rtk.app.c.a.b(str));
        if (i == 1) {
            F();
            this.u = (UpApkDetailsBean) this.g.fromJson(str, UpApkDetailsBean.class);
            S();
            this.s.setNeedCoin(this.u.getData().getNeedCoin());
            this.s.setApkSize(com.rtk.app.tool.c0.q(this.u.getData().getDataPath()) ? this.u.getData().getSourceSize() : this.u.getData().getDataSize());
            this.s.setVersionName(this.u.getData().getVersionName());
            try {
                com.rtk.app.main.Home5Activity.ClickHistory.f.c(this.f147c, this.s);
            } catch (Exception e) {
                com.rtk.app.tool.c0.r("UpApkDetailsActivity", e.getMessage());
            }
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "1");
            Q();
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "2");
            return;
        }
        if (i == 2) {
            com.rtk.app.tool.f.a(this.f147c, this.upApkDetailsAppCollect.isChecked() ? "收藏成功" : "取消收藏", f.a.f);
            return;
        }
        String str2 = "";
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                com.rtk.app.tool.f.a(this, "购买成功", f.a.f);
                UpApkDetailsBean upApkDetailsBean = this.u;
                if (upApkDetailsBean == null || upApkDetailsBean.getData() == null) {
                    return;
                }
                this.u.getData().setIsBuy(1);
                return;
            }
            this.z.dismiss();
            com.rtk.app.tool.f.a(this.f147c, "关注成功", f.a.f);
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "关注TA  " + str);
            int followed = this.u.getData().getFollowed();
            if (followed != 1 && followed != 2) {
                com.rtk.app.tool.f.a(this.f147c, "关注成功", f.a.f);
                this.u.getData().setFollowed(1);
                com.rtk.app.tool.b0.b.b().e(this.u.getData().getUid(), 1);
            } else {
                com.rtk.app.tool.f.a(this.f147c, "取消关注成功", f.a.f);
                this.u.getData().setFollowed(0);
                com.rtk.app.tool.b0.b.b().e(this.u.getData().getUid(), 0);
            }
            com.rtk.app.tool.t.H1(this.upApkDetailsAttention, this.u.getData().getFollowed() + "");
            return;
        }
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "审核黑名单" + str);
        this.y = (UpSuguestBean) this.g.fromJson(str, UpSuguestBean.class);
        this.upApkDetailGoToCheckPage.setEnabled(true);
        this.upApkDetailGoToCheckAgainPage.setEnabled(true);
        if (this.y.getData() != null) {
            com.rtk.app.tool.c0.u("UpApkDetailsActivity", "建议不为空");
            if (this.y.getData().getIsSuguest().equals("1")) {
                this.upApkDetailsSuggest.setRightText("(" + this.y.getData().getDesc() + ")");
                this.upApkDetailsSuggest.setText("通过");
                this.upApkDetailsSuggest.setVisibility(0);
                this.upApkDetailsSuggest.setTextColor(this.f147c.getResources().getColor(R.color.theme3));
                return;
            }
            if (this.y.getData().getIsSuguest().equals("0")) {
                if (!com.rtk.app.tool.c0.q(this.y.getData().getId())) {
                    str2 = "[" + this.y.getData().getId() + "]";
                }
                this.upApkDetailsSuggest.setRightText("(" + this.y.getData().getDesc() + ")" + str2);
                this.upApkDetailsSuggest.setText("不通过");
                this.upApkDetailsSuggest.setVisibility(0);
                this.upApkDetailsSuggest.setTextColor(this.f147c.getResources().getColor(R.color.theme26));
                return;
            }
            if (this.y.getData().getIsSuguest().equals("2")) {
                if (!com.rtk.app.tool.c0.q(this.y.getData().getId())) {
                    str2 = "[" + this.y.getData().getId() + "]";
                }
                this.upApkDetailsSuggest.setRightText("(" + this.y.getData().getDesc() + ")" + str2);
                this.upApkDetailsSuggest.setText("不列表展示");
                this.upApkDetailsSuggest.setVisibility(0);
                this.upApkDetailsSuggest.setTextColor(this.f147c.getResources().getColor(R.color.theme2));
                return;
            }
            return;
        }
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "建议为空");
        this.upApkDetailsSuggest.setVisibility(8);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        com.rtk.app.tool.DownLoadTool.x.c().m(this.v);
        com.rtk.app.tool.b0.b.b().c(this.A);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.h
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpApkDetailsActivity.this.U(strArr);
                }
            });
        } else if (i2 == 4) {
            this.z.dismiss();
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        ApkInfo apkInfo = (ApkInfo) getIntent().getExtras().getSerializable("apkInfo");
        this.s = apkInfo;
        if (apkInfo == null) {
            com.rtk.app.tool.f.a(this.f147c, "该资源数据错误，请与客服联系", f.a.f);
            finish();
        }
        try {
            this.t = this.s.getUpGameId();
        } catch (NullPointerException unused) {
            com.rtk.app.tool.f.a(this.f147c, "该资源数据错误，id为空，请与客服联系", f.a.f);
            finish();
        }
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.upApkDetailsTab.setupWithViewPager(this.upApkDetailsViewPager, true);
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.upApkDetailsTopDownload);
        com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
        if (com.rtk.app.tool.t.q1(this.f147c, this.s.getPackageName())) {
            this.upApkDetailsAppOpenBtu.setVisibility(0);
        }
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 2 || c.d.a.d.c())) {
            this.B = 1;
        }
        O(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upApkDetailsBar.addOnOffsetChangedListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.c(this.f147c, this.s.getIcon_url(), this.upApkDetailsAppIcon, new boolean[0]);
        this.upApkDetailsAppName.setText(this.s.getAppName());
        this.upApkDetailsAppDownLoadBtu.setTag(Integer.valueOf(this.s.getGameId()));
        this.v = new com.rtk.app.tool.DownLoadTool.u(this.upApkDetailsAppDownLoadProgressBar, this.s.getGameId(), this.upApkDetailsAppDownLoadBtu, this.upApkDetailsAppOpenBtu);
        com.rtk.app.tool.DownLoadTool.x.c().a(this.v);
        com.rtk.app.tool.i.i.q(1, this.f147c, this.s, this.upApkDetailsAppDownLoadBtu, this.upApkDetailsAppDownLoadProgressBar);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f147c, "请稍后...");
        this.z = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "更新onActivityResult" + i + "   " + i2);
        if (i != 1009) {
            if (i != 1015) {
                if (i == 1022) {
                    if (i2 == -1) {
                        this.x.z();
                    } else if (i2 == 1) {
                        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "更新评论");
                        Bundle extras = intent.getExtras();
                        this.x.E(extras.getInt("itemPosition"), extras.getString("replyComment"));
                    }
                }
                if (i2 == 1033 || intent == null) {
                    return;
                }
                Bundle extras2 = intent.getExtras();
                int i3 = extras2.getInt("modifyStatus3");
                String string = extras2.getString("reason");
                com.rtk.app.tool.c0.u("UpApkDetailsActivity", "up 族审返回信息 FamilyUpApkDetailsRequestCode" + i3);
                this.u.getData().setStatus3(i3);
                this.u.getData().setMsg3(string);
                Q();
                extras2.putInt("id", this.t);
                intent.putExtras(extras2);
                setResult(1008, intent);
            }
            O(1);
        } else if (i2 == 1032) {
            M(i2, intent);
        } else {
            N(i2, intent);
        }
        if (i2 == 1033) {
            return;
        }
        Bundle extras22 = intent.getExtras();
        int i32 = extras22.getInt("modifyStatus3");
        String string2 = extras22.getString("reason");
        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "up 族审返回信息 FamilyUpApkDetailsRequestCode" + i32);
        this.u.getData().setStatus3(i32);
        this.u.getData().setMsg3(string2);
        Q();
        extras22.putInt("id", this.t);
        intent.putExtras(extras22);
        setResult(1008, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_apk_detail_family_audit /* 2131300594 */:
                com.rtk.app.tool.t.r0(this.f147c, this.u.getData().getId() + "", 1009, this.u);
                return;
            case R.id.up_apk_detail_goToCheckAgainPage /* 2131300595 */:
                X();
                return;
            case R.id.up_apk_detail_goToCheckPage /* 2131300596 */:
                if (com.rtk.app.tool.y.K().equals(this.u.getData().getUid() + "")) {
                    if (this.u.getData().isZip()) {
                        com.rtk.app.tool.f.a(this.f147c, "数据包类型UP资源不支持编辑", f.a.f);
                        return;
                    } else {
                        com.rtk.app.tool.c0.u("UpApkDetailsActivity", "跳转编辑");
                        com.rtk.app.tool.t.b1(this.f147c, this.u.getData(), 1015);
                        return;
                    }
                }
                com.rtk.app.tool.c0.u("UpApkDetailsActivity", "跳转审核");
                com.rtk.app.tool.t.Z0(this.f147c, this.u.getData().getId() + "", this.y, this.u.getData().getStatus(), 1009, this.u);
                return;
            case R.id.up_apk_details_appDownLoadBtu /* 2131300612 */:
                com.rtk.app.tool.i.i.o(this.f147c, this.s, this.upApkDetailsAppDownLoadBtu);
                return;
            case R.id.up_apk_details_appOpenBtu /* 2131300616 */:
                com.rtk.app.tool.i.i.o(this.f147c, this.s, this.upApkDetailsAppOpenBtu);
                return;
            case R.id.up_apk_details_app_collect /* 2131300619 */:
                if (com.rtk.app.tool.y.x(this.f147c)) {
                    O(2);
                    return;
                } else {
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                }
            case R.id.up_apk_details_app_reward /* 2131300620 */:
                if (com.rtk.app.tool.y.x(this.f147c)) {
                    new DialogPostReward(this.f147c, "" + this.u.getData().getUid(), "rewardUp", this.s.getUpGameId() + "", "0").show();
                    return;
                }
                com.rtk.app.tool.t.w0(this.f147c);
                return;
            case R.id.up_apk_details_attention /* 2131300621 */:
                if (com.rtk.app.tool.y.x(this.f147c)) {
                    if (this.u.getData().getFollowed() != 0) {
                        new DialogForAttention(MyApplication.b(), new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.i
                            @Override // com.rtk.app.tool.s
                            public final void a(String[] strArr) {
                                UpApkDetailsActivity.this.W(strArr);
                            }
                        }).show();
                        return;
                    } else {
                        O(4);
                        this.z.show();
                        return;
                    }
                }
                com.rtk.app.tool.f.a(this.f147c, "请先登录", 200);
                com.rtk.app.tool.t.w0(this.f147c);
                return;
            case R.id.up_apk_details_copy_Url /* 2131300625 */:
                com.rtk.app.tool.t.I1(this.f147c, "http://a.ruansky.com/up/" + this.t + "/");
                return;
            case R.id.up_apk_details_share /* 2131300660 */:
                com.rtk.app.tool.t.a2(this.f147c, this.s, this.u.getData().getSourceCharacteristic() + this.u.getData().getSourceDescription());
                return;
            case R.id.up_apk_details_top_back /* 2131300663 */:
                finish();
                return;
            case R.id.up_apk_details_top_download /* 2131300664 */:
                com.rtk.app.tool.t.o0(this.f147c);
                return;
            case R.id.up_apk_details_top_feedback /* 2131300665 */:
                if (!com.rtk.app.tool.y.x(this.f147c)) {
                    com.rtk.app.tool.t.w0(this.f147c);
                    com.rtk.app.tool.f.a(this.f147c, "请先登录", f.a.f);
                    return;
                } else {
                    if (this.u == null) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("gameId", this.s.getUpGameId());
                    bundle.putString("gameName", this.s.getAppName());
                    bundle.putString("logo", this.u.getData().getSourceLogo());
                    bundle.putString(com.umeng.analytics.pro.d.y, "upApk");
                    com.rtk.app.tool.c.b(this.f147c, GameFeedBackActivity.class, bundle);
                    return;
                }
            case R.id.up_apk_details_userLv /* 2131300669 */:
                if (this.u != null) {
                    com.rtk.app.tool.t.B0(this.f147c, this.u.getData().getUid() + "");
                    return;
                }
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
        setContentView(R.layout.activity_up_apk_details);
        ButterKnife.a(this);
        G(null, this.upApkDetailsTopLayout);
    }
}
