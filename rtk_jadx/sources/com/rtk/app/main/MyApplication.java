package com.rtk.app.main;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;
import com.google.gson.GsonBuilder;
import com.mob.MobSDK;
import com.rtk.app.bean.LoginAddCoinBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import java.util.HashSet;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyApplication extends Application {
    private static Context a = null;
    public static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f210c;
    public static String d;
    private static final HashSet<String> e = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements h.j {
        a() {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            com.rtk.app.tool.c0.u("MyApplication", "分享成功" + str);
            LoginAddCoinBean loginAddCoinBean = (LoginAddCoinBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, LoginAddCoinBean.class);
            if (loginAddCoinBean.getData().getIsShow() == 1) {
                com.rtk.app.tool.f.a(MyApplication.a, loginAddCoinBean.getData().getTips(), f.a.f);
            }
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            com.rtk.app.tool.c0.u("MyApplication", "分享了 增加积分或者金币  接口失败" + str);
        }
    }

    public static Context b() {
        return a;
    }

    public static HashSet<String> c() {
        return e;
    }

    public static String[] d(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
                com.rtk.app.tool.c0.u("MyApplication", "友盟测试机0" + strArr[0]);
                com.rtk.app.tool.c0.u("MyApplication", "友盟测试机1" + strArr[1]);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static void f(Context context) {
        a = context;
    }

    public static void g() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/shareReward");
        sb.append(com.rtk.app.tool.y.u(a));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&type=");
        sb.append(d);
        sb.append("&sid=");
        sb.append(f210c);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(a, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "type=" + d))));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("分享链接");
        sb3.append(com.rtk.app.tool.y.d);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("MyApplication", sb3.toString());
        com.rtk.app.tool.o.h.l(a, new a(), 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        com.rtk.app.tool.c0.u("MyApplication", "分享成功+请求接口" + com.rtk.app.tool.y.d + sb2);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public synchronized void e() {
        if (b) {
            return;
        }
        b = true;
        com.rtk.app.tool.c0.u("MyApplication", "initMethod");
        com.hjq.toast.k.e(this);
        UMConfigure.init(a, 1, "");
        d(a);
        UMConfigure.setLogEnabled(true);
        MobSDK.init(a, "a2c83ab6aedc", "49503bc84fd006be716e446b8e8c389b");
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a = this;
        com.rtk.app.b.b.a = com.rtk.app.tool.v.a(this, "log4jSaveLogSwitch");
        com.hjq.toast.k.e(this);
        UMConfigure.preInit(this, "5667eb0b67e58e79ac000f08", "rtk");
        com.rtk.app.tool.c0.u("MyApplication", "是否同意用户隐私协议" + com.rtk.app.tool.v.a(getApplicationContext(), "user_privacy_protocol"));
    }
}
