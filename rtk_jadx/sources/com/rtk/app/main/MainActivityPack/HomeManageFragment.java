package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.UpgradeGameBean;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.Home5Activity.Home5MyExperienceActivity;
import com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeManageFragment extends BaseFragment implements h.j {
    public static boolean u = false;

    @BindView
    TextView home5AboutAndHelp;

    @BindView
    TextView home5AccountSecurity;

    @BindView
    TextView home5ApplicationSetting;

    @BindView
    LinearLayout home5AttentionList;

    @BindView
    TextView home5ClickHistory;

    @BindView
    ImageView home5DayNight;

    @BindView
    View home5DownloadManager;

    @BindView
    LinearLayout home5FansList;

    @BindView
    TextView home5FeedBack;

    @BindView
    TextView home5FeedShaer;

    @BindView
    TextView home5ForUserTitle;

    @BindView
    TextView home5GoogleFrame;

    @BindView
    TextView home5HTML5Game;

    @BindView
    TextView home5HeadAuditState;

    @BindView
    RoundedImageView home5HeadImg;

    @BindView
    RelativeLayout home5HeadLayout;

    @BindView
    TextView home5HeadTv;

    @BindView
    View home5InstallApk;

    @BindView
    TextView home5MassageNum;

    @BindView
    LinearLayout home5MedalWall;

    @BindView
    View home5MedalWallTv;

    @BindView
    ImageView home5MessageSamll;

    @BindView
    View home5MyCollect;

    @BindView
    View home5MyComment;

    @BindView
    LinearLayout home5MyUpSrc;

    @BindView
    MarkedImageView home5MyUpSrcImage;

    @BindView
    TextView home5PersonalInfoAudit;

    @BindView
    LinearLayout home5PostList;

    @BindView
    LinearLayout home5PostReplyList;

    @BindView
    TextView home5ProtocolOfUsage;

    @BindView
    TextView home5RtkUid;

    @BindView
    TextView home5SetTheme;

    @BindView
    ImageView home5Setting;

    @BindView
    TextView home5ShareSelf;

    @BindView
    TextView home5ShoppingMall;

    @BindView
    SwipeRefreshLayout home5SwipeRefresh;

    @BindView
    View home5UninstallBtu;

    @BindView
    TextView home5UpPlate;

    @BindView
    LinearLayout home5UpgradeGame;

    @BindView
    ImageView home5UpgradeIcon;

    @BindView
    TextView home5UpgradeIconNum;

    @BindView
    TextView home5UserAge;

    @BindView
    TextView home5UserContributeNum;

    @BindView
    TextView home5UserGoldNum;

    @BindView
    TextView home5UserGrade;

    @BindView
    View home5_browser_history;

    @BindView
    View home5_my_family;

    @BindView
    View home5_r_money;

    @BindView
    FlowLayout homeManageFragmentMedal;
    View o;
    Unbinder p;
    private Home5ImfromationBean q;
    private int r;
    private boolean s;
    FamilyListBean t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements h.j {
        a() {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            HomeManageFragment homeManageFragment = HomeManageFragment.this;
            homeManageFragment.t = (FamilyListBean) ((BaseFragment) homeManageFragment).f.fromJson(str, FamilyListBean.class);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AllFileAccessPermissionDialog.a {
        b(HomeManageFragment homeManageFragment) {
        }

        @Override // com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog.a
        public void a(AllFileAccessPermissionDialog allFileAccessPermissionDialog) {
            allFileAccessPermissionDialog.dismiss();
        }

        @Override // com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog.a
        public void b(AllFileAccessPermissionDialog allFileAccessPermissionDialog) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            if (HomeManageFragment.this.q != null || com.rtk.app.tool.t.t1(((BaseFragment) HomeManageFragment.this).e)) {
                if (!y.x(((BaseFragment) HomeManageFragment.this).e) || HomeManageFragment.this.q == null) {
                    com.rtk.app.tool.t.w0(((BaseFragment) HomeManageFragment.this).e);
                    return;
                } else {
                    com.rtk.app.tool.c.b((Activity) ((BaseFragment) HomeManageFragment.this).e, Home5MyExperienceActivity.class, null);
                    return;
                }
            }
            com.rtk.app.tool.f.a(((BaseFragment) HomeManageFragment.this).e, "请检查您的网络", f.a.f);
        }
    }

    public HomeManageFragment() {
        new ArrayList();
        this.s = true;
    }

    private void B() {
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 2 || MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserNicknameAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserNicknameAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserSignatureAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserSignatureAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 2)) {
            this.home5PersonalInfoAudit.setVisibility(0);
        } else {
            this.home5PersonalInfoAudit.setVisibility(8);
        }
    }

    private void E() {
        StringBuilder sb = new StringBuilder();
        sb.append("family/my-family");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
        com.rtk.app.tool.o.h.l(this.e, new a(), 100, com.rtk.app.tool.o.h.h(y.e).a(sb.toString()));
    }

    public void F() {
        int b2 = com.rtk.app.tool.v.b(this.e, "THEME");
        if (b2 % 27 == 0 && b2 != 0) {
            this.home5DayNight.setSelected(true);
        } else {
            this.home5DayNight.setSelected(false);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        String str2;
        this.home5SwipeRefresh.setRefreshing(false);
        c0.u("HomeManageFragment", i + "   我的个人中心   " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 3) {
                return;
            }
            UpgradeGameBean upgradeGameBean = (UpgradeGameBean) create.fromJson(str, UpgradeGameBean.class);
            if (upgradeGameBean.getCode() == 0) {
                this.r = upgradeGameBean.getData().size();
                if (com.rtk.app.tool.v.a(this.e, "settingUpgradableNoticeVALUE")) {
                    if (this.r > 0) {
                        this.home5UpgradeIconNum.setText(this.r + "");
                        this.home5UpgradeIconNum.setVisibility(0);
                        return;
                    }
                    this.home5UpgradeIconNum.setVisibility(8);
                    return;
                }
                this.home5UpgradeIconNum.setVisibility(8);
                return;
            }
            return;
        }
        this.q = (Home5ImfromationBean) create.fromJson(str, Home5ImfromationBean.class);
        com.rtk.app.tool.v.h(this.e, com.rtk.app.tool.v.f, str);
        if (this.q.getData() != null) {
            if (!c0.q(this.q.getData().getNickname_new())) {
                this.home5HeadTv.setText(this.q.getData().getNickname_new() + "(审核中)");
            } else {
                this.home5HeadTv.setText(this.q.getData().getNickname());
            }
            if (!c0.q(this.q.getData().getFace_new())) {
                com.rtk.app.tool.t.d(this.e, this.q.getData().getFace_new(), this.home5HeadImg);
                this.home5HeadAuditState.setVisibility(0);
            } else {
                com.rtk.app.tool.t.d(this.e, this.q.getData().getFace(), this.home5HeadImg);
                this.home5HeadAuditState.setVisibility(8);
            }
            this.home5UserAge.setSelected(this.q.getData().getSex().equals("1"));
            this.home5UserAge.setText(this.q.getData().getAge() + "");
            this.home5RtkUid.setText("软天空号:" + this.q.getData().getRtkUid());
            this.home5UserGrade.setText(this.q.getData().getLevel());
            this.home5UserContributeNum.setText(this.q.getData().getContribute());
            this.home5UserGoldNum.setText(this.q.getData().getCoin());
            int allUnreadNum = this.q.getData().getInformNumList().getAllUnreadNum();
            if (allUnreadNum > 0) {
                TextView textView = this.home5MassageNum;
                if (allUnreadNum > 99) {
                    str2 = "99+";
                } else {
                    str2 = allUnreadNum + "";
                }
                textView.setText(str2);
                this.home5MassageNum.setVisibility(0);
            } else {
                this.home5MassageNum.setVisibility(8);
            }
            ((TextView) this.home5PostList.getChildAt(0)).setText(this.q.getData().getPostsNum());
            ((TextView) this.home5PostReplyList.getChildAt(0)).setText(this.q.getData().getReplyNum());
            ((TextView) this.home5AttentionList.getChildAt(0)).setText(this.q.getData().getFollows());
            ((TextView) this.home5FansList.getChildAt(0)).setText(this.q.getData().getFans());
            com.rtk.app.tool.t.L1(this.home5ForUserTitle, "", this.q.getData().getUser_title(), new c());
            LoginBean loginBean = MainActivity.p;
            if (loginBean != null && loginBean.getData() != null) {
                MainActivity.p.getData().setHome5BeanToLoginBean(this.q);
            }
            com.rtk.app.tool.t.p1(this.e, this.homeManageFragmentMedal, this.q.getData().getMedalList().getAchievement(), this.q.getData().getMedalList().getEventMedal());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void D() {
        if (this.s) {
            this.s = false;
            return;
        }
        E();
        StringBuilder sb = new StringBuilder();
        sb.append("members/userBaseInfo");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        c0.u("HomeManageFragment", "个人中心   " + y.d + sb2);
        List<PackageInfo> z = com.rtk.app.tool.t.z(this.e);
        String str = "[";
        for (int i = 0; i < z.size(); i++) {
            str = str + "{\"packagename\":\"" + z.get(i).packageName + "\",\"versioncode\":\"" + z.get(i).versionCode + "\"},";
        }
        String str2 = str.substring(0, str.length() - 1) + "]";
        HashMap hashMap = new HashMap();
        Context context = this.e;
        hashMap.put("channel", y.m(context, context.getPackageName()));
        hashMap.put("version", y.i(this.e));
        hashMap.put(ak.aj, y.g());
        hashMap.put("phone_model", y.T());
        hashMap.put("package_data", str2);
        hashMap.put("key", com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "package_data=" + str2))));
        com.rtk.app.tool.o.h.j(this.e, this, y.d + "game/gamesIsUpdate", 3, hashMap);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.home5PersonalInfoAudit.setOnClickListener(this);
        this.home5RtkUid.setOnClickListener(this);
        this.home5HeadTv.setOnClickListener(this);
        this.home5UserAge.setOnClickListener(this);
        this.home5ShareSelf.setOnClickListener(this);
        this.home5Setting.setOnClickListener(this);
        this.home5MedalWall.setOnClickListener(this);
        this.homeManageFragmentMedal.setOnClickListener(this);
        this.home5DayNight.setOnClickListener(this);
        this.home5HeadImg.setOnClickListener(this);
        this.home5DownloadManager.setOnClickListener(this);
        this.home5UninstallBtu.setOnClickListener(this);
        this.home5InstallApk.setOnClickListener(this);
        this.home5MyUpSrc.setOnClickListener(this);
        this.home5UpgradeGame.setOnClickListener(this);
        this.home5SetTheme.setOnClickListener(this);
        this.home5MyCollect.setOnClickListener(this);
        this.home5_browser_history.setOnClickListener(this);
        this.home5ProtocolOfUsage.setOnClickListener(this);
        this.home5FeedBack.setOnClickListener(this);
        this.home5AboutAndHelp.setOnClickListener(this);
        this.home5ApplicationSetting.setOnClickListener(this);
        this.home5ShoppingMall.setOnClickListener(this);
        this.home5MyComment.setOnClickListener(this);
        this.home5FeedShaer.setOnClickListener(this);
        this.home5HTML5Game.setOnClickListener(this);
        this.home5UpPlate.setOnClickListener(this);
        this.home5AttentionList.setOnClickListener(this);
        this.home5FansList.setOnClickListener(this);
        this.home5GoogleFrame.setOnClickListener(this);
        this.home5PostList.setOnClickListener(this);
        this.home5PostReplyList.setOnClickListener(this);
        this.home5UserGoldNum.setOnClickListener(this);
        this.home5UserContributeNum.setOnClickListener(this);
        this.home5UserGrade.setOnClickListener(this);
        this.home5MessageSamll.setOnClickListener(this);
        this.home5AccountSecurity.setOnClickListener(this);
        this.home5ClickHistory.setOnClickListener(this);
        this.home5SwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.l
            public final void onRefresh() {
                HomeManageFragment.this.D();
            }
        });
        this.home5_r_money.setOnClickListener(this);
        this.home5MedalWallTv.setOnClickListener(this);
        this.home5_my_family.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("HomeManageFragment", "" + str);
        SwipeRefreshLayout swipeRefreshLayout = this.home5SwipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (i2 == 1 && i == 2001) {
            com.rtk.app.tool.t.w0(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    public void h() {
        com.rtk.app.tool.t.S1(this.e, this.home5HeadLayout, null, null, null, null);
        try {
            F();
        } catch (Exception unused) {
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        LoginBean loginBean = MainActivity.p;
        if (loginBean != null && loginBean.getData() != null) {
            if (!c0.q(MainActivity.p.getData().getFace_new())) {
                com.rtk.app.tool.t.d(this.e, MainActivity.p.getData().getFace_new(), this.home5HeadImg);
                this.home5HeadAuditState.setVisibility(0);
            } else {
                com.rtk.app.tool.t.d(this.e, MainActivity.p.getData().getFace(), this.home5HeadImg);
                this.home5HeadAuditState.setVisibility(8);
            }
            if (!c0.q(MainActivity.p.getData().getNickname_new())) {
                this.home5HeadTv.setText(MainActivity.p.getData().getNickname_new() + "(审核中)");
            } else {
                this.home5HeadTv.setText(MainActivity.p.getData().getNickname());
            }
            B();
        } else {
            this.home5HeadImg.setImageResource(R.mipmap.icon_logo);
            this.home5HeadTv.setText("点击头像登录");
        }
        this.home5ShareSelf.setVisibility(y.x(this.e) ? 0 : 8);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 1614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.MainActivityPack.HomeManageFragment.onClick(android.view.View):void");
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home5_layout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            c();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        F();
        return this.o;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        C();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        try {
            if (!y.x(this.e)) {
                this.home5UserAge.setText("- -");
                this.home5RtkUid.setText("软天空号:- -");
                this.home5UserGrade.setText("- -");
                this.home5UserContributeNum.setText("- -");
                this.home5UserGoldNum.setText("- -");
                this.home5HeadAuditState.setVisibility(8);
                this.home5PersonalInfoAudit.setVisibility(8);
                ((TextView) this.home5PostList.getChildAt(0)).setText("- -");
                ((TextView) this.home5PostReplyList.getChildAt(0)).setText("- -");
                ((TextView) this.home5AttentionList.getChildAt(0)).setText("- -");
                ((TextView) this.home5FansList.getChildAt(0)).setText("- -");
                this.home5MassageNum.setVisibility(8);
            }
            if (((MainActivity) this.e).m == this) {
                C();
                c0.u("HomeManageFragment", "home5的onResume()");
            }
            i();
        } catch (NullPointerException e) {
            c0.u("HomeManageFragment", "个人中心异常" + e.toString());
        }
        if (MainActivity.p == null || this.q != null || c0.q(com.rtk.app.tool.v.d(this.e, com.rtk.app.tool.v.f))) {
            return;
        }
        d(com.rtk.app.tool.v.d(this.e, com.rtk.app.tool.v.f), 1);
    }
}
