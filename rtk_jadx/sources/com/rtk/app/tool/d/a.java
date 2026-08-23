package com.rtk.app.tool.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.AdIdBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.v;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.splash.WMSplashAd;
import com.windmill.sdk.splash.WMSplashAdListener;
import com.windmill.sdk.splash.WMSplashAdRequest;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: AdTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static a d;
    private boolean a = false;
    private String b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f299c = null;

    public a() {
        new ArrayList();
    }

    public static a b() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private DisplayMetrics c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return displayMetrics;
    }

    public int a(float f, Context context) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public String d() {
        if (!TextUtils.isEmpty(this.f299c)) {
            c0.u("AdTool", "getSplashAdId:" + this.f299c);
            return this.f299c;
        }
        f();
        return this.f299c;
    }

    public synchronized void e(Context context) {
        c0.u("AdTool", "initAdSdk");
        if (this.a) {
            return;
        }
        WindMillAd sharedAds = WindMillAd.sharedAds();
        sharedAds.setAdult(true);
        sharedAds.setPersonalizedAdvertisingOn(true);
        sharedAds.setDebugEnable(false);
        sharedAds.startWithAppId(context, "30073");
        this.a = true;
    }

    public void f() {
        String d2 = v.d(MyApplication.b(), "ChuanshanAdIdValue");
        if (!c0.q(d2)) {
            try {
                AdIdBean adIdBean = (AdIdBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(d2, AdIdBean.class);
                this.f299c = adIdBean.getData().getGroMore().getCodeBitId();
                this.b = adIdBean.getData().getTtSplash().getAppid() + "";
                c0.u("AdTool", "adBean:" + adIdBean + ",getRewardAdId:" + this.b);
                return;
            } catch (Exception unused) {
                c0.u("AdTool", "getRewardAdId 激励广告信息格式化失败");
                v.h(MyApplication.b(), "ChuanshanAdIdValue", "");
            }
        }
        this.f299c = "3339246222935184";
        this.b = "1861135488127239";
    }

    public void g(Activity activity, String str, ViewGroup viewGroup, WMSplashAdListener wMSplashAdListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", "user123");
        hashMap.put("ad_key_width", Integer.valueOf(c(activity).widthPixels));
        hashMap.put("ad_key_height", Integer.valueOf(c(activity).heightPixels - a(100.0f, activity)));
        WMSplashAdRequest wMSplashAdRequest = new WMSplashAdRequest(str, "user123", hashMap);
        wMSplashAdRequest.setDisableAutoHideAd(false);
        new WMSplashAd(activity, wMSplashAdRequest, wMSplashAdListener).loadAdAndShow(viewGroup);
    }
}
