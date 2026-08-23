package com.rtk.app.main;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mob.MobSDK;
import com.rtk.app.R;
import com.rtk.app.bean.FristCoverBean;
import com.rtk.app.main.FirstActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogDisagreeFirstPermission;
import com.rtk.app.main.dialogPack.DialogForPermissionTip;
import com.rtk.app.tool.o.h;
import com.umeng.analytics.MobclickAgent;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.splash.IWMSplashEyeAd;
import com.windmill.sdk.splash.WMSplashAdListener;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FirstActivity extends AppCompatActivity implements h.j {
    private Context a;
    private View b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f179c;
    private DialogForPermissionTip d;
    private Timer e = new Timer();
    public boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements com.rtk.app.tool.s {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(String[] strArr) {
            if (strArr.length > 0 && strArr[0].equals("YES")) {
                FirstActivity.this.d.show();
            } else {
                FirstActivity.this.finish();
            }
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            com.rtk.app.tool.c0.u("FirstActivityRQY", "dialogForPermissionTip callBack");
            if (strArr.length > 0 && strArr[0].equals("YES")) {
                com.rtk.app.tool.c0.u("FirstActivityRQY", "yes");
                ((MyApplication) FirstActivity.this.getApplication()).e();
                MobSDK.submitPolicyGrantResult(true);
                FirstActivity.this.y();
                com.rtk.app.tool.v.e(FirstActivity.this.a, "user_privacy_protocol", Boolean.TRUE);
                return;
            }
            new DialogDisagreeFirstPermission(FirstActivity.this.a, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.k
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr2) {
                    FirstActivity.a.this.c(strArr2);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements WMSplashAdListener {
        b() {
        }

        public void onSplashAdClicked(AdInfo adInfo) {
            com.rtk.app.tool.c0.r("FirstActivityRQY", "onSplashAdClicked,,adInfo:" + adInfo);
        }

        public void onSplashAdFailToLoad(WindMillError windMillError, String str) {
            com.rtk.app.tool.c0.r("FirstActivityRQY", "onSplashAdFailToLoad,placementId" + str + ",error:" + windMillError);
            FirstActivity.this.D();
        }

        public void onSplashAdSuccessLoad(String str) {
            FirstActivity.this.e.cancel();
            com.rtk.app.tool.c0.r("FirstActivityRQY", "onSplashAdSuccessLoad,placementId:" + str);
        }

        public void onSplashAdSuccessPresent(AdInfo adInfo) {
            FirstActivity.this.b.setVisibility(8);
            com.rtk.app.tool.c0.r("FirstActivityRQY", "onSplashAdSuccessPresent:" + adInfo);
        }

        public void onSplashClosed(AdInfo adInfo, IWMSplashEyeAd iWMSplashEyeAd) {
            com.rtk.app.tool.c0.r("FirstActivityRQY", "onSplashClosed,,adInfo:" + adInfo);
            FirstActivity.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FirstActivity.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.f) {
            D();
        } else {
            this.f = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B() {
        com.rtk.app.tool.d.a.b().e(getApplicationContext());
        b bVar = new b();
        String d = com.rtk.app.tool.d.a.b().d();
        E();
        com.rtk.app.tool.d.a.b().g(this, d, this.f179c, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D() {
        this.e.cancel();
        startActivity(new Intent(this.a, (Class<?>) MainActivity.class));
        finish();
    }

    private void E() {
        this.e.schedule(new c(), 5000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        com.rtk.app.tool.o.h.l(this.a, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/game_app_controller" + com.rtk.app.tool.y.u(this.a) + "&platform=" + com.rtk.app.tool.y.m(this.a, getPackageName()) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.a, new String[0])))));
    }

    private void x() {
        com.rtk.app.tool.g.c.e(this.a).j(com.rtk.app.tool.DownLoadTool.q.f286c, com.rtk.app.tool.DownLoadTool.q.d);
        com.rtk.app.tool.g.c.e(this.a).b();
        if (com.rtk.app.tool.g.e.c().i()) {
            com.rtk.app.tool.g.e.h(this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        String d = com.rtk.app.tool.v.d(this.a, "ServicePath");
        String d2 = com.rtk.app.tool.v.d(this.a, "ServicePathNew");
        String d3 = com.rtk.app.tool.v.d(this.a, "ServiceUpPath");
        String d4 = com.rtk.app.tool.v.d(this.a, "ServiceUpVideoPath");
        if (com.rtk.app.tool.c0.q(d)) {
            d = com.rtk.app.tool.y.d;
        }
        com.rtk.app.tool.y.d = d;
        if (com.rtk.app.tool.c0.q(d2)) {
            d2 = com.rtk.app.tool.y.e;
        }
        com.rtk.app.tool.y.e = d2;
        if (com.rtk.app.tool.c0.q(d3)) {
            d3 = com.rtk.app.tool.y.i;
        }
        com.rtk.app.tool.y.i = d3;
        if (com.rtk.app.tool.c0.q(d4)) {
            d4 = com.rtk.app.tool.y.j;
        }
        com.rtk.app.tool.y.j = d4;
        Intent intent = new Intent((Context) this, (Class<?>) SurvivalService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void C() {
        MobclickAgent.setScenarioType(this.a, MobclickAgent.EScenarioType.E_UM_NORMAL);
        String m = com.rtk.app.tool.y.m(this.a, getPackageName());
        m.hashCode();
        char c2 = 65535;
        switch (m.hashCode()) {
            case -1523126597:
                if (m.equals("360shoujizhushou")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1102567284:
                if (m.equals("liqucn")) {
                    c2 = 1;
                    break;
                }
                break;
            case -920819049:
                if (m.equals("rtknew")) {
                    c2 = 2;
                    break;
                }
                break;
            case 110755:
                if (m.equals("pc6")) {
                    c2 = 3;
                    break;
                }
                break;
            case 113257:
                if (m.equals("rtk")) {
                    c2 = 4;
                    break;
                }
                break;
            case 120130:
                if (m.equals("yyb")) {
                    c2 = 5;
                    break;
                }
                break;
            case 94873598:
                if (m.equals("cr173")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                com.rtk.app.tool.c0.u("FirstActivityRQY", "360shoujizhushou");
                D();
                com.rtk.app.tool.c0.u("FirstActivityRQY", "360shoujizhushou57");
                return;
            default:
                com.rtk.app.tool.c0.u("FirstActivityRQY", "掩护页面");
                w();
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        if (((FristCoverBean) create.fromJson(str, FristCoverBean.class)).getData().getIsVisible() == 1) {
            startActivity(new Intent(this.a, (Class<?>) CoverActivity.class));
            finish();
        } else {
            E();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("FirstActivityRQY", "请求错误  进行跳转" + str);
        D();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        if ((getIntent().getFlags() & 4194304) != 0) {
            finish();
            return;
        }
        setContentView(R.layout.activity_first);
        this.a = this;
        MyApplication.f(this);
        this.f179c = (ViewGroup) findViewById(R.id.m_splash_container);
        this.b = findViewById(R.id.logo);
        int b2 = com.rtk.app.tool.v.b(this.a, "THEME");
        if (b2 % 27 == 0 && b2 != 0) {
            com.rtk.app.tool.y.S(false, null);
        }
        if (com.rtk.app.tool.v.a(getApplicationContext(), "user_privacy_protocol")) {
            ((MyApplication) getApplication()).e();
            y();
        } else {
            DialogForPermissionTip dialogForPermissionTip = new DialogForPermissionTip(this.a, new a());
            this.d = dialogForPermissionTip;
            dialogForPermissionTip.show();
        }
    }

    protected void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        this.f = false;
    }

    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.f) {
            D();
        }
        this.f = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y() {
        com.rtk.app.tool.c0.u("FirstActivityRQY", "initMainMethod");
        x();
        if (com.rtk.app.tool.v.b(this.a, "settingDownStackNum") != 0) {
            com.rtk.app.tool.y.q = com.rtk.app.tool.v.b(this.a, "settingDownStackNum");
        }
        if (!com.rtk.app.tool.t.t1(this)) {
            com.rtk.app.tool.c0.s("FirstActivityRQY", "not NetWork");
            C();
        } else {
            com.rtk.app.tool.c0.r("FirstActivityRQY", "loadAd:true");
            B();
            z();
        }
    }
}
