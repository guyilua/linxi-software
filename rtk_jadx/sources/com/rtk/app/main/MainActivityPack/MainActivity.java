package com.rtk.app.main.MainActivityPack;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.base.MainBaseActivity;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForUserTip;
import com.rtk.app.main.dialogPack.DialogNotice;
import com.rtk.app.main.dialogPack.DialogProtocolOfUsage;
import com.rtk.app.main.dialogPack.DialogUpdata;
import com.rtk.app.tool.MyUnOrInStallApkBrodcastReceiver;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainActivity extends MainBaseActivity implements h.j {
    public static Context o;
    public static LoginBean p;
    private HomePageFragment b;

    /* renamed from: c, reason: collision with root package name */
    private HomeGameFragment f209c;
    private MainHomeUpFragment d;
    private HomeCommunityFragment e;
    private HomeManageFragment f;
    private DialogUpdata g;
    private DialogNotice h;
    private MainUseProtocolUpdateNoticeBean i;
    private DialogProtocolOfUsage j;
    private MyUnOrInStallApkBrodcastReceiver l;
    public Fragment m;

    @BindView
    RadioGroup mainBtu;

    @BindView
    RadioButton mainBtuCommunity;

    @BindView
    RadioButton mainBtuGame;

    @BindView
    RadioButton mainBtuHome;

    @BindView
    RadioButton mainBtuManage;

    @BindView
    RadioButton mainBtuUp;

    @BindView
    LinearLayout mainLinearLayout;
    private boolean k = false;
    private long n = 0;

    private Fragment A(Fragment fragment, Class cls) {
        if (fragment == null) {
            try {
                fragment = (Fragment) cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragment2 = this.m;
        if (fragment2 != null) {
            beginTransaction.hide(fragment2);
        }
        this.m = fragment;
        supportFragmentManager.executePendingTransactions();
        if (fragment.isAdded()) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.add(R.id.main_linearLayout, fragment, cls.getName());
        }
        beginTransaction.addToBackStack(cls.getName());
        beginTransaction.commitAllowingStateLoss();
        return fragment;
    }

    private void u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_btu_community /* 2131299009 */:
                this.e = (HomeCommunityFragment) A(this.e, HomeCommunityFragment.class);
                return;
            case R.id.main_btu_game /* 2131299010 */:
                this.f209c = (HomeGameFragment) A(this.f209c, HomeGameFragment.class);
                return;
            case R.id.main_btu_home /* 2131299011 */:
                this.b = (HomePageFragment) A(this.b, HomePageFragment.class);
                return;
            case R.id.main_btu_manage /* 2131299012 */:
                this.f = (HomeManageFragment) A(this.f, HomeManageFragment.class);
                return;
            case R.id.main_btu_up /* 2131299013 */:
                this.d = (MainHomeUpFragment) A(this.d, MainHomeUpFragment.class);
                return;
            default:
                return;
        }
    }

    private void y() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = this.m;
        if (fragment != null) {
            beginTransaction.hide(fragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            c0.u("MainActivity", "更新app+公告+协议" + str);
            this.i = (MainUseProtocolUpdateNoticeBean) create.fromJson(str, MainUseProtocolUpdateNoticeBean.class);
            this.h = new DialogNotice(MyApplication.b(), this.i.getData().getAnnouncement());
            this.g = new DialogUpdata(MyApplication.b(), this.i.getData().getCheckupdates());
            this.j = new DialogProtocolOfUsage(MyApplication.b(), this.i.getData().getAgreement_privacy());
            this.h.show();
            this.g.show();
            y.i = this.i.getData().getUploadUrl();
            y.j = this.i.getData().getVideoUploadUrl();
            com.rtk.app.tool.v.h(o, "ServiceUpPath", y.i);
            com.rtk.app.tool.v.h(o, "ServiceUpVideoPath", y.j);
            this.j.show();
            new DialogForUserTip(o, this.i.getData().getSign());
            return;
        }
        if (i == 2) {
            t(3);
            return;
        }
        if (i == 3) {
            Home5ImfromationBean home5ImfromationBean = (Home5ImfromationBean) create.fromJson(str, Home5ImfromationBean.class);
            com.rtk.app.tool.v.h(o, com.rtk.app.tool.v.f, str);
            LoginBean loginBean = p;
            if (loginBean == null || loginBean.getData() == null) {
                return;
            }
            p.getData().setHome5BeanToLoginBean(home5ImfromationBean);
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            c0.u("MainActivity", "新解密接口" + str);
            return;
        }
        c0.u("MainActivity", "穿山甲广告信息" + com.rtk.app.c.a.b(str));
        com.rtk.app.tool.v.h(o, "ChuanshanAdIdValue", str);
        com.rtk.app.tool.d.a.b().f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        HomePageFragment homePageFragment = this.b;
        if (homePageFragment != null) {
            homePageFragment.n();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("MainActivity", "当前mark" + i2 + "   " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        if (!com.rtk.app.tool.v.a(getApplicationContext(), "isFirstOpenMainActivity")) {
            c0.u("MainActivity", "  iniData  ");
            Context applicationContext = getApplicationContext();
            Boolean bool = Boolean.TRUE;
            com.rtk.app.tool.v.e(applicationContext, "isFirstOpenMainActivity", bool);
            com.rtk.app.tool.v.f(getApplicationContext(), "THEME", 1);
            com.rtk.app.tool.v.e(o, "settingNoWifiVALUE", bool);
            com.rtk.app.tool.v.e(o, "settingInstallVALUE", bool);
            com.rtk.app.tool.v.e(o, "settingDeleteAfterInstallVALUE", bool);
            com.rtk.app.tool.v.e(o, "settingUpgradableNoticeVALUE", bool);
            u();
        }
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        String d = com.rtk.app.tool.v.d(o, "userInformation");
        com.rtk.app.main.UpModule.UpControlPack.b.i().n();
        try {
            c0.u("MainActivity", "用户信息" + d);
            p = (LoginBean) create.fromJson(d, LoginBean.class);
        } catch (Exception e) {
            c0.s("MainActivity", "用户信息 初始化失败" + e);
        }
        t(1);
        t(2);
        t(4);
        t(5);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.mainBtu.check(R.id.main_btu_home);
        this.mainBtu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.MainActivityPack.v
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                MainActivity.this.x(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.b = (HomePageFragment) A(this.b, HomePageFragment.class);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        MobclickAgent.onKillProcess(o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.MainBaseActivity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ButterKnife.a(this);
        if (bundle != null) {
            this.m = getSupportFragmentManager().findFragmentByTag(bundle.getString("fragmentTag"));
            y();
        }
        o = this;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        MyUnOrInStallApkBrodcastReceiver myUnOrInStallApkBrodcastReceiver = new MyUnOrInStallApkBrodcastReceiver();
        this.l = myUnOrInStallApkBrodcastReceiver;
        registerReceiver(myUnOrInStallApkBrodcastReceiver, intentFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.l);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (System.currentTimeMillis() - this.n > 2000) {
            com.rtk.app.tool.f.a(o, "再按一次返回键退出应用", f.a.f);
            this.n = System.currentTimeMillis();
            return true;
        }
        finish();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onRestoreInstanceState(Bundle bundle) {
        super/*android.app.Activity*/.onRestoreInstanceState(bundle);
        this.k = true;
    }

    @Override // com.rtk.app.base.MainBaseActivity
    protected void onResume() {
        super.onResume();
        if (this.k) {
            if (this.b == null) {
                this.b = new HomePageFragment();
            }
            A(this.b, HomePageFragment.class);
            this.k = false;
        }
        DialogUpdata dialogUpdata = this.g;
        if (dialogUpdata != null) {
            dialogUpdata.s();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        bundle.putString("fragmentTag", this.m.getClass().getName());
    }

    @Override // com.rtk.app.base.MainBaseActivity
    protected boolean r() {
        return true;
    }

    @Override // com.rtk.app.base.MainBaseActivity
    protected void s() {
        com.rtk.app.tool.t.S1(o, null, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), null);
        try {
            this.b.h();
            this.f209c.h();
            this.d.h();
            this.f.h();
        } catch (Exception e) {
            c0.u("MainActivity", "异常" + e);
        }
        if (y.F()) {
            com.rtk.app.tool.t.o(this.mainBtuHome, R.drawable.icon_main_home_gray, o);
            com.rtk.app.tool.t.o(this.mainBtuCommunity, R.drawable.icon_main_home_community_gray, o);
            com.rtk.app.tool.t.o(this.mainBtuGame, R.drawable.icon_main_rank_gray, o);
            com.rtk.app.tool.t.o(this.mainBtuUp, R.drawable.icon_main_up_btu_gray, o);
            com.rtk.app.tool.t.o(this.mainBtuManage, R.drawable.icon_main_personal_gray, o);
            return;
        }
        com.rtk.app.tool.t.o(this.mainBtuHome, R.drawable.icon_main_home_gray_night, o);
        com.rtk.app.tool.t.o(this.mainBtuCommunity, R.drawable.icon_main_home_community_night, o);
        com.rtk.app.tool.t.o(this.mainBtuGame, R.drawable.icon_main_rank_gray_night, o);
        com.rtk.app.tool.t.o(this.mainBtuUp, R.drawable.icon_main_up_btu_gray_night, o);
        com.rtk.app.tool.t.o(this.mainBtuManage, R.drawable.icon_main_personal_gray_night, o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            if (!c0.q(y.K())) {
                str = "&uid=" + y.K() + "&token=" + y.H();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("system/checkAppVersion");
            sb.append(y.u(o));
            sb.append("&app_version=");
            sb.append(com.rtk.app.tool.t.Y(o));
            sb.append("&params=all&device_id=");
            sb.append(y.o(o));
            sb.append(str);
            sb.append("&device_name=");
            sb.append(y.p(o));
            sb.append("&os_version=");
            sb.append(y.D());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(o, "app_version=" + com.rtk.app.tool.t.Y(o)))));
            str = sb.toString();
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/userLoginGetScore");
            sb2.append(y.u(this.a));
            sb2.append("&uid=");
            sb2.append(y.K());
            sb2.append("&token=");
            sb2.append(y.H());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.a, "uid=" + y.K(), "token=" + y.H()))));
            str = sb2.toString();
        } else if (i == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/userBaseInfo");
            sb3.append(y.u(o));
            sb3.append("&uid=");
            sb3.append(y.K());
            sb3.append("&token=");
            sb3.append(y.H());
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(c0.e(y.v(o, "uid=" + y.K(), "token=" + y.H()))));
            str = sb3.toString();
        } else if (i == 4) {
            HashMap<String, String> l = y.l();
            l.put("device_id", y.o(this));
            l.put(ak.J, y.p(this));
            l.put("key", com.rtk.app.tool.t.c0(c0.e(y.v(o, new String[0]))));
            str = y.w("members/csjparameter", l);
        } else if (i == 5) {
            str = "members/modulesList" + y.u(o) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(o, new String[0])));
        }
        com.rtk.app.tool.o.h.l(o, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
        c0.u("MainActivity", "链接" + y.d + str);
    }

    public int v() {
        MainHomeUpFragment mainHomeUpFragment = this.d;
        if (mainHomeUpFragment != null) {
            return mainHomeUpFragment.u();
        }
        return 0;
    }

    public void z() {
        MainHomeUpFragment mainHomeUpFragment = this.d;
        if (mainHomeUpFragment != null) {
            mainHomeUpFragment.v();
        }
    }
}
